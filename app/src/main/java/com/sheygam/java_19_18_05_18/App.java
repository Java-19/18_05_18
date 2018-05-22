package com.sheygam.java_19_18_05_18;

import android.app.Application;

import com.sheygam.java_19_18_05_18.model.provider.store.IStoreProvider;
import com.sheygam.java_19_18_05_18.model.provider.store.SPrefProvider;
import com.sheygam.java_19_18_05_18.model.provider.web.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static App app;
    private Api api;
    private IStoreProvider storeProvider;

    public App() {
        app = this;
    }

    public static App get(){
        return app;
    }

    public IStoreProvider getStoreProvider(){
        if(storeProvider == null){
            storeProvider = createProvider();
        }
        return storeProvider;
    }

    public Api getApi() {
        if(api == null){
            api = createApi();
        }
        return api;
    }

    private IStoreProvider createProvider(){
        return new SPrefProvider(this);
    }

    private Api createApi(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://telranstudentsproject.appspot.com/")
                .build()
                .create(Api.class);
    }
}
