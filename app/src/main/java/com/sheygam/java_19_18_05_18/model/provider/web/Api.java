package com.sheygam.java_19_18_05_18.model.provider.web;

import com.sheygam.java_19_18_05_18.model.dto.AuthDto;
import com.sheygam.java_19_18_05_18.model.dto.AuthTokenDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("_ah/api/contactsApi/v1/registration")
    Call<AuthTokenDto> registration(@Body AuthDto auth);
}
