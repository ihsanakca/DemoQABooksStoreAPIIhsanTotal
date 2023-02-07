package com.krafttech.step_Defs;

import com.krafttech.services.NewUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddBookStep_Defs {

    NewUser newUser = new NewUser();
    @Given("User should add new book")
    public void user_should_add_new_book() {
        newUser.addBooks();
    }

    @Then("User should verify the addBookStatusCode")
    public void user_should_verify_the_addBookStatusCode() {
       newUser.verifyAddBooks();
    }
}
