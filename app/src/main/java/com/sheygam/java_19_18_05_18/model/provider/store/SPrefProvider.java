package com.sheygam.java_19_18_05_18.model.provider.store;

import android.content.Context;

public class SPrefProvider implements IStoreProvider {
    private static final String AUTH_SP = "AUTH_SP";
    private static final String TOKEN_KEY = "TOKEN";
    private Context context;

    public SPrefProvider(Context context) {
        this.context = context;
    }

    @Override
    public void saveToken(String token) {
        context.getSharedPreferences(AUTH_SP,Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN_KEY,token)
                .apply();
    }
}
