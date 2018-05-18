package com.sheygam.java_19_18_05_18.presenter.login;

import com.sheygam.java_19_18_05_18.model.login.ILoginRepository;
import com.sheygam.java_19_18_05_18.model.login.ILoginRepositoryCallback;
import com.sheygam.java_19_18_05_18.view.login.ILoginView;

public class LoginPresenter implements ILoginPresenter, ILoginRepositoryCallback {
    private ILoginView view;
    private ILoginRepository repository;

    public LoginPresenter(ILoginView view, ILoginRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void onLogin(String email, String password) {

    }

    @Override
    public void onRegistration(String email, String password) {
        view.showProgress();
        if(!email.contains("@")){
            view.hideProgress();
            view.showEmailValidError("Wrong email!");
        }else if(password.length() <= 4){
            view.hideProgress();
            view.showPassValidError("Min 4 symbols!");
        }else{
            repository.registration(email,password,this);
        }
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFailure(String error) {

    }

    @Override
    public void onRegistrationSuccess() {
        view.hideProgress();
        view.showNextView();
    }

    @Override
    public void onRegistrationFailure(String error) {
        view.hideProgress();
        view.showError(error);
    }
}
