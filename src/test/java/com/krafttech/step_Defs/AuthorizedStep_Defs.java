package com.krafttech.step_Defs;

import com.krafttech.services.NewUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthorizedStep_Defs {

    NewUser newUser = new NewUser();

    @Given("User should be authorized with valid credentials")
    public void user_should_be_authorized_with_valid_credentials() {
        newUser.userAuthorized();
    }

    @Then("verify authorizedStatusCode")
    public void verify_authorizedStatusCode() {
        newUser.verifyAuthorizedStatusCode();
    }

}
