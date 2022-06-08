package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationSuccessPage extends Utils{

    LoadProperty loadProperty = new LoadProperty();

    private By _registrationSuccessfulText = By.className("result");
    private By _continueButton = By.className("register-continue-button");

    public void verifyUserRegisteredSuccessfully(){
        //Assert result verification
        String actualMessage = driver.findElement(_registrationSuccessfulText).getText();
        String expectedMessage = loadProperty.getProperty("RegisteredSuccessfullyMessage");
        Assert.assertEquals(actualMessage, expectedMessage, "Registration was failed");
    }

    public void clickOnContinueButton(){
        //Click on Continue Button
        clickOnElement(_continueButton);
    }

}