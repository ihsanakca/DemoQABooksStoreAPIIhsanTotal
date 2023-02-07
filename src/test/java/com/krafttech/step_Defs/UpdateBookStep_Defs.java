package com.krafttech.step_Defs;

import com.krafttech.services.NewUser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateBookStep_Defs {
    NewUser newUser = new NewUser();
    @Given("User should update the collection")
    public void user_should_update_the_collection() {
        newUser.updateBook();
    }

    @Then("User should verify the updateStatus Code")
    public void user_should_verify_the_updateStatus_Code() {
        newUser.verifyUpdateBookStatus();
    }

}
