package com.api.tests;

import com.api.base.UserProfileManagementService;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileRequestTest extends TestBase{

    @Test(description = "Verify if the profile details of the user getting fetched...")
    public void getProfileInfoTest(){
//        AuthService authService = new AuthService();
//        Response response = authService.login(new LoginRequest("Disha","disha123"));
//        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        //System.out.println(loginResponse.getToken());
        Response response = userProfileManagementService.getProfile(getAuthToken("Disha", "disha123"));
        //System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        //System.out.println(userProfileResponse.getUsername());
        Assert.assertEquals(userProfileResponse.getUsername(), "Disha");
    }
}
