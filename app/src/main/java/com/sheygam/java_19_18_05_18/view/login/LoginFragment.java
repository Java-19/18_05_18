package com.sheygam.java_19_18_05_18.view.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sheygam.java_19_18_05_18.App;
import com.sheygam.java_19_18_05_18.R;
import com.sheygam.java_19_18_05_18.model.login.ILoginRepository;
import com.sheygam.java_19_18_05_18.model.login.LoginRepository;

import com.sheygam.java_19_18_05_18.presenter.login.ILoginPresenter;
import com.sheygam.java_19_18_05_18.presenter.login.LoginPresenter;
import com.sheygam.java_19_18_05_18.view.contactlist.ContactListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginFragment extends Fragment implements ILoginView{

    @BindView(R.id.inputEmail) EditText inputEmail;
    @BindView(R.id.inputPassword) EditText inputPassword;
    @BindView(R.id.regBtn) Button regBtn;
    @BindView(R.id.loginBtn) Button loginBtn;
    @BindView(R.id.myProgress) ProgressBar myProgress;

    private Unbinder unbinder;
    private ILoginPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ILoginRepository repository = new LoginRepository(App.get().getApi(), App.get().getStoreProvider());
        presenter = new LoginPresenter(this,repository);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.regBtn)
    protected void onRegClicked(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        presenter.onRegistration(email,password);
    }

    @OnClick(R.id.loginBtn)
    protected void onLoginCLicked(){
        Toast.makeText(getActivity(), "On login clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showProgress() {
        inputEmail.setEnabled(false);
        inputPassword.setEnabled(false);
        regBtn.setEnabled(false);
        loginBtn.setEnabled(false);
        myProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        inputEmail.setEnabled(true);
        inputPassword.setEnabled(true);
        regBtn.setEnabled(true);
        loginBtn.setEnabled(true);
        myProgress.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Error")
                .setCancelable(false)
                .setMessage(error)
                .setPositiveButton("Ok",null)
                .create()
                .show();
    }

    @Override
    public void showEmailValidError(String error) {
        inputEmail.setError(error);
    }

    @Override
    public void showPassValidError(String error) {
        inputPassword.setError(error);
    }

    @Override
    public void showNextView() {
       getFragmentManager()
               .beginTransaction()
               .replace(R.id.root,new ContactListFragment())
               .commit();
    }
}
