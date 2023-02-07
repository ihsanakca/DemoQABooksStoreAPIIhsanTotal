package com.krafttech.step_Defs;

import com.krafttech.services.NewUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteBookStep_Defs {
    NewUser newUser = new NewUser();

    @Given("User should delete a book")
    public void user_should_delete_a_book() {
        newUser.deleteABook();
    }

    @Then("User should verify deleteStatusCode")
    public void user_should_verify_deleteStatusCode() {
        newUser.verifyDelete();
    }

}
