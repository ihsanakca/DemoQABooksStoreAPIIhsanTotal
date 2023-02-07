@wip
Feature: New User Register

  Scenario: User should able to register
    Given User should register with valid credentials
    Then User should verify the status code

  Scenario: User should input the valid credentials
    Given input valid credentials
    Then verify tokenStatusCode

  Scenario: User should be able to authorized
    Given User should be authorized with valid credentials
    Then verify authorizedStatusCode

  Scenario: User should be able to see the collection
    Given User should see the book list
    Then User should verfiy the BookStatusCode

  Scenario: User should be able to add new book to the collection
    Given User should add new book
    Then User should verify the addBookStatusCode

  Scenario: User should able to update the book
    Given User should update the collection
    Then User should verify the updateStatus Code

  Scenario: User should able to delete a book from collection
    Given User should delete a book
    Then User should verify deleteStatusCode