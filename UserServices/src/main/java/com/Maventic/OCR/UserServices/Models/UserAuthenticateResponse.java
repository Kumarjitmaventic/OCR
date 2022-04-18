package com.Maventic.OCR.UserServices.Models;

public class UserAuthenticateResponse {
    private String jwt;

    public UserAuthenticateResponse() {
    }

    public UserAuthenticateResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "AuthorizationResponse{" +
                "jwt='" + jwt + '\'' +
                '}';
    }
}
