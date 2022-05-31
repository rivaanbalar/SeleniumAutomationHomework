package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendResultPage extends Utils{

    private By _resultText = By.className("result");

    public void verifyUserSentEmailSuccessfully(){
        //Verify the message "Your message has been sent." (Assert Point)
        String actualMessage = driver.findElement(_resultText).getText();
        String expectedMessage = "Your message has been sent.";
        Assert.assertEquals(actualMessage, expectedMessage, "Email was not sent successfully");
    }

}