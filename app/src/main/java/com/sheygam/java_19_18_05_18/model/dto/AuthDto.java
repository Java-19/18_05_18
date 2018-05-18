package com.sheygam.java_19_18_05_18.model.dto;

public class AuthDto {
    private String email;
    private String password;

    public AuthDto() {
    }

    public AuthDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
