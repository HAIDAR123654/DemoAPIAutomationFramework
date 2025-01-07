package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest {

    @Test(description = "Verify if the Login API is working...")
    public void loginTest(){

        LoginRequest loginRequest = new LoginRequest("haidar123","haidar@t123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(), "haidartest2001@gmail.com");


    }
}
