package com.sheygam.java_19_18_05_18.model.login;

public interface ILoginRepositoryCallback {
    void onLoginSuccess();
    void onLoginFailure(String error);
    void onRegistrationSuccess();
    void onRegistrationFailure(String error);
}
