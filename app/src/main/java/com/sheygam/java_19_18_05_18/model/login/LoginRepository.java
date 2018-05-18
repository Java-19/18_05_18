package com.sheygam.java_19_18_05_18.model.login;

import android.util.Log;

import com.sheygam.java_19_18_05_18.model.dto.AuthDto;
import com.sheygam.java_19_18_05_18.model.dto.AuthTokenDto;
import com.sheygam.java_19_18_05_18.model.provider.store.IStoreProvider;
import com.sheygam.java_19_18_05_18.model.provider.web.Api;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository implements ILoginRepository {

    private Api api;
    private IStoreProvider storeProvider;

    public LoginRepository(Api api, IStoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @Override
    public void registration(String email, String password, final ILoginRepositoryCallback callback) {
        AuthDto authDto = new AuthDto(email,password);
        api.registration(authDto).enqueue(new Callback<AuthTokenDto>() {
            @Override
            public void onResponse(Call<AuthTokenDto> call, Response<AuthTokenDto> response) {
                if(response.isSuccessful()){
                    storeProvider.saveToken(response.body().getToken());
                    callback.onRegistrationSuccess();
                }else if(response.code() == 409){
                    callback.onRegistrationFailure("User already exist");
                }else{
                    try {
                        Log.d("MY_TAG", "registration onResponse error: " + response.errorBody().string());
                        callback.onRegistrationFailure("Server error");
                    } catch (IOException e) {
                        e.printStackTrace();
                        callback.onRegistrationFailure("Connection error!");
                    }

                }
            }

            @Override
            public void onFailure(Call<AuthTokenDto> call, Throwable t) {
                callback.onRegistrationFailure("Connection error!");
            }
        });
    }
}
