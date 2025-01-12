package com.api.tests;

import com.api.base.UserProfileManagementService;
import com.api.models.request.ProfileRequest;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest extends TestBase{

    @Test(description = "Verify update profile APIs...")
    public void updateProfileTest(){
//        AuthService authService = new AuthService();
//        Response response = authService.login(new LoginRequest("Disha","disha123"));
//        LoginResponse loginResponse = response.as(LoginResponse.class);
        //System.out.println(response.asPrettyString());
        
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response response = userProfileManagementService.getProfile(getAuthToken("Disha", "disha123"));
        //System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "Disha");

        //System.out.println("===========================================");
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("DishaUpdated6")
                .lastName("BhattUpdated6")
                .email("disha1updated6@yahoo.com")
                .mobileNumber("1234567893")
                .build();
        response = userProfileManagementService.updateProfile(getAuthToken("Disha", "disha123"),profileRequest);
        userProfileResponse = response.as(UserProfileResponse.class);
        //System.out.println(response.asPrettyString());
        Assert.assertEquals(userProfileResponse.getFirstName(), "DishaUpdated6");
    }
}
