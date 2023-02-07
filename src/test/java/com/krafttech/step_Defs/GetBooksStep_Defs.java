package com.krafttech.step_Defs;

import com.krafttech.services.GetBooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetBooksStep_Defs {
    GetBooks getBooks = new GetBooks();

    @Given("User should see book list")
    public void user_should_see_book_list() {
        getBooks.bookList();
    }

    @Then("User verify the booksStatusCode")
    public void user_verify_the_booksStatusCode() {
        getBooks.verifyBookList();
    }

}
