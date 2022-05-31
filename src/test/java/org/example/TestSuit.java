package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    EmailAFriendResultPage emailAFriendResultPage = new EmailAFriendResultPage();

    @Test
    public void userShouldBeAbleToRegisterSuccessfully(){

        //Click on register button
        homePage.clickOnRegistrationButton();

        //Verify user is on registration page
        registrationPage.verifyUserIsOnRegistrationPage();

        //Enter user registration details
        registrationPage.userEntersRegistrationDetails();

        //Verify user registered successfully
        registrationSuccessPage.verifyUserRegisteredSuccessfully();
    }

    @Test
    public void userShouldBeAbleToAddAProductToBasket(){

        //Click on the Build your own computer
        homePage.buildYourOwnComputerOnHomePage();

        //Select correct options to build the computer
        buildYourOwnComputerPage.selectOptionsToBuildTheComputer();

        //Click on add to basket button
        buildYourOwnComputerPage.addProductToBasket();

        //Click on shopping cart button
        buildYourOwnComputerPage.clickOnShoppingCartButton();

        //Check if the product has been added to the basket by verifying product name "build your own computer"
        shoppingCartPage.buildYourOwnComputerInShoppingCart();
    }

    @Test
    public void userShouldBeAbleToChangeTheCurrencyToEuro(){

        //Verify if build your own computer price is display in Dollar (Assert Point)
        homePage.verifyDollarSignOnHomePage();

        //Change the Dollar into Euro sign
        homePage.changeDollarIntoEuroSign();

        //Verify if build your own computer price is display in Euro (Assert Point)
        homePage.verifyEuroSignOnHomePage();
    }

    @Test
    public void registerUserShouldBeAbleToReferAProductToAFriend(){

        //User need to register or be logged in

        //Click on register button
        homePage.clickOnRegistrationButton();

        //Verify user is on registration page
        registrationPage.verifyUserIsOnRegistrationPage();

        //Enter user registration details
        registrationPage.userEntersRegistrationDetails();

        //Click on continue button
        registrationSuccessPage.clickOnContinueButton();

        //Click on build your own computer product on homepage
        homePage.buildYourOwnComputerOnHomePage();

        //Click on email a friend option at the bottom
        buildYourOwnComputerPage.clickOnEmailAFriendButton();

        //Enter friend's email and a personal message
        emailAFriendPage.userEnterFriendsEmailAndPersonalMessage();

        //Click on send email button
        emailAFriendPage.clickOnSendEmailButton();

        //Verify the message "Your message has been sent." (Assert Point)
        emailAFriendResultPage.verifyUserSentEmailSuccessfully();
    }

    @Test
    public void onlyRegisteredUserShouldBeAbleToVote(){

        //Verify that user is not able to vote without being registered
        homePage.verifyIfNonRegisteredUserIsAbleToVote();

        //User need to register
        //Click on register button
        homePage.clickOnRegistrationButton();

        //Verify user is on registration page
        registrationPage.verifyUserIsOnRegistrationPage();

        //Enter user registration details
        registrationPage.userEntersRegistrationDetails();

        //Verify user registered successfully
        registrationSuccessPage.verifyUserRegisteredSuccessfully();

        //Click on continue button
        registrationSuccessPage.clickOnContinueButton();

        //Verify registered user is able to vote
        homePage.verifyRegisteredUserIsAbleToVote();
    }

}