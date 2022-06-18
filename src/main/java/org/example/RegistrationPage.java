package org.example;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils{

    LoadProperty loadProperty = new LoadProperty();

    private By _maleOrFemaleField = By.xpath("//input[@id=\"gender-male\"]");
    private By _firstNameField = By.xpath("//input[@name='FirstName']");
    private By _lastNameField = By.id("LastName");
    private By _emailField = By.id("Email");
    private By _passwordField = By.id("Password");
    private By _confirmPasswordField = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");
    private By _dateOfBirthField = By.name("DateOfBirthDay");
    private By _monthOfBirthField = By.name("DateOfBirthMonth");
    private By _yearOfBirthField = By.name("DateOfBirthYear");

    public void verifyUserIsOnRegistrationPage(){

        driverWaitUntilURLToBe(20, loadProperty.getProperty("RegistrationPageURL"));
    }

    public void userEntersRegistrationDetails(){

        //Select Male or Female
        clickOnElement(_maleOrFemaleField); //radio button

        //Enter firstname
        typeText(_firstNameField, loadProperty.getProperty("FirstName"));

        //Enter lastname
        typeText(_lastNameField, loadProperty.getProperty("LastName"));

        //Fill in the date of birth
        selectFromDropDownIndexValue(_dateOfBirthField, Integer.parseInt(loadProperty.getProperty("DateOfBirthday")));
        selectFromDropDownIndexValue(_monthOfBirthField, Integer.parseInt(loadProperty.getProperty("MonthOfBirthday")));
        selectFromDropDownVisibleText(_yearOfBirthField, loadProperty.getProperty("YearOfBirthday"));

        //Enter email
        typeText(_emailField,loadProperty.getProperty("UserEmailField01")+randomDate()+loadProperty.getProperty("UserEmailField02"));

        //Enter password
        typeText(_passwordField,loadProperty.getProperty("UserPassword"));

        //Enter confirm password
        typeText(_confirmPasswordField,loadProperty.getProperty("UserPassword"));

    }

    public void clickOnRegisterButton(){
        //Click on register button
        clickOnElement(_registerButton);
    }

}