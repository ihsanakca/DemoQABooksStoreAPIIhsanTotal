package com.krafttech.step_Defs;

import com.krafttech.services.NewUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NewUserStep_Defs {
    NewUser newUser = new NewUser();

    @Given("User should register with valid credentials")
    public void user_should_register_with_valid_credentials() {
        newUser.userRegister();
    }

    @Then("User should verify the status code")
    public void user_should_verify_the_status_code() {
        newUser.verifyRegisterStatusCode();
    }
}
