package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest {

    @Test(description = "Verify if the Login API is working...")
    //retryAnalyzer = com.api.retrytests.MyRetryAnalyzer.class
    public void loginTest(){

        LoginRequest loginRequest = new LoginRequest("Disha","disha123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(), "disha1updated6@yahoo.com");

    }
}
