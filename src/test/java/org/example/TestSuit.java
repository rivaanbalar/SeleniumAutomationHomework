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
    ComputersPage computersPage = new ComputersPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    NopCommerceNewReleasePage nopCommerceNewReleasePage = new NopCommerceNewReleasePage();


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

        //Verify if price is display in Euro on home page (Assert Point)
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

    @Test
    public void getProductListFromHomePage(){

        //Verify the product titles on the Home Page
        homePage.getProductTitles();
    }

    @Test
    public void verifyHomePageContains(){

        //Verify elements (Register, Login, Wishlist and Welcome to our store) contains on Home Page
        homePage.verifyHomePageContains();
    }

    @Test
    public void verifyUserIsNotAbleToVoteWithoutSelectingAnOption(){

        //Click on the Vote Button on the Home Page
        homePage.voteButton();

        //Verify the message in Alert "Please select an answer" (Assert Point)
        homePage.handleVoteAlert();
    }

    @Test
    public void verifyUserIsAbleToNavigateToFacebookPage(){

        //User should be able to click on Facebook icon, and verify that new window has been opened and handled.
        homePage.facebookPageWindowHandle();

        //Then navigate back to main page and verify that user is now on Home Page
        homePage.verifyUserIsOnHomePage();
    }

    @Test
    public void verifyThatUserIsAbleToSearchGivenProductSuccessfully(){

        //On Home Page click on search bar and enter product name to search and verify user is on that product page (Parameterised  Method)
        homePage.enterProductNameToSearch("Nike");

        //Verify that all the product listed contains either Nike or Apple (Same as URL) (Assert Point)
        homePage.verifyProductListedContainsProductNameRequested();
    }

    @Test
    public void verifyThatUserCommentHasSuccessfullyBeenAddedToCommentsList(){

        //On Home Page click under News and nopCommerce new release!, click on Details Button
        homePage.clickOnDetailsButton();

        //Verify that user is on the nopcommerce new release page (Assert Point - verify URL)
        nopCommerceNewReleasePage.verifyURL();

        //Verify the title of the page "nopCommerce new release!" (Assert Point - verify Title)
        nopCommerceNewReleasePage.verifyPageTitle();

        //Enter Title
        nopCommerceNewReleasePage.enterTitle();

        //Enter Comment
        nopCommerceNewReleasePage.enterComment();

        //Click on New Comment Button
        nopCommerceNewReleasePage.clickOnCommentButton();

        //Verify comment added message "News comment is successfully added." (Assert Point - verify Message)
        nopCommerceNewReleasePage.verifyCommentAddedMessage();

        //Verify that user's comment has been added to the comments list and been displayed last on the list (Assert Point - Comment has been added to the list and is showing last on the list)
        nopCommerceNewReleasePage.verifyCommentHasBeenAddedToTheCommentListAndListedLast();

    }

    @Test
    public void verifyThatProductListIsInZToAFormat (){

        //---THIS TEST CASE SHOULD FAIL---\\

        //Click on computer on Home Page
        homePage.computerButton();

        //Click on Desktops
        computersPage.desktopButton();

        //Under sort by functionality, select "Name Z-A" option
        desktopsPage.clickOnSortByZToAOption();

        //Verify that all the products are listed in Z-A format (Assert Point)
        desktopsPage.verifyProductListedInZToAFormat();

    }

}