package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(description = "Verify if thr forgot password API is working...")
    public void forgotPassword(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("haidartest2001@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
