package com.krafttech.step_Defs;


import com.krafttech.services.NewUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenerateTokenStep_Defs {
    NewUser newUser = new NewUser();
    @Given("input valid credentials")
    public void input_valid_credentials() {
        newUser.generateToken();
    }
    @Then("verify tokenStatusCode")
    public void verify_tokenStatusCode() {
       newUser.verifyGenerateTokenStatusCode();
    }
}