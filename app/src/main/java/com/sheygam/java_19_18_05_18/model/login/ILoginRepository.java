package com.sheygam.java_19_18_05_18.model.login;

public interface ILoginRepository {
    void registration(String email, String password, ILoginRepositoryCallback callback);
}
