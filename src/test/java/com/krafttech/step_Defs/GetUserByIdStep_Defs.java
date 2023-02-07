package com.krafttech.step_Defs;


import com.krafttech.services.NewUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetUserByIdStep_Defs {
    NewUser newUser = new NewUser();

    @Given("User should see the book list")
    public void user_should_see_the_book_list() {
        newUser.getUser();
    }

    @Then("User should verfiy the BookStatusCode")
    public void user_should_verfiy_the_BookStatusCode() {
        newUser.verifyUserById();
    }

}
