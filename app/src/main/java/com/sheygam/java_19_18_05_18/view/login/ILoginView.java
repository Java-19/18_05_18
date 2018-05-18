package com.sheygam.java_19_18_05_18.view.login;

public interface ILoginView {
    void showProgress();
    void hideProgress();
    void showError(String error);
    void showEmailValidError(String error);
    void showPassValidError(String error);
    void showNextView();
}
