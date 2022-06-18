package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDepths {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessPage registrationSuccessPage = new RegistrationSuccessPage();


    @Given("I am in registration page")
    public void i_am_in_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnRegistrationButton();
    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.userEntersRegistrationDetails();
    }

    @When("I click on register submit button")
    public void i_click_on_register_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.clickOnRegisterButton();
    }

    @Then("I should be able to registered successfully")
    public void i_should_be_able_to_registered_successfully() {
        // Write code here that turns the phrase above into concrete actions
        registrationSuccessPage.verifyUserRegisteredSuccessfully();
    }

    @Given("I am on homepage")
    public void i_am_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click on {string} link from top menu header")
    public void i_click_on_link_from_top_menu_header(String category_name) {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnCategoryLink(category_name);

    }
    @Then("I should be able to successfully navigate to related {string} with same category name")
    public void i_should_be_able_to_successfully_navigate_to_related_with_same_category_name(String category_url) {
        // Write code here that turns the phrase above into concrete actions
        Utils.verifyCurrentURL(category_url);
    }

}
