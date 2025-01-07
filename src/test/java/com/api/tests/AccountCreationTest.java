package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify if user is able to sign up...")
    public void createAccount(){

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("Disha")
                .email("disha1@yahoo.com")
                .firstName("Disha")
                .password("disha123")
                .lastName("Bhatt")
                .mobileNumber("8888888889")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
    }
}
