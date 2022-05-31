package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils{

    private By _registerButton = By.xpath("//a[@class='ico-register']");
    private By _verifyDollarSign = By.className("actual-price");
    private By _verifyEuroSign = By.xpath("//*[@id=\"customerCurrency\"]");
    private By _changeDollarToEuro = By.xpath("//*[@id=\"customerCurrency\"]/option[2]");
    private By _buildYourOwnComputer = By.xpath("//h2/a[@href=\"/build-your-own-computer\"]");
    private By _goodButtonUnderCommunityPoll = By.xpath("//input[@id=\"pollanswers-2\"]");
    private By _voteButton = By.xpath("//button[@class=\"button-2 vote-poll-button\"]");
    private By _errorMessageForVote = By.xpath("//div[@id=\"block-poll-vote-error-1\"]"); //input[@name="__RequestVerificationToken"]
    private By _successMessageForVote = By.xpath("//span[@class=\"poll-total-votes\"]");

    public void clickOnRegistrationButton(){
        //Click on register button
        clickOnElement(_registerButton);
        //driver.findElement(By.xpath("//a[@class='ico-register']")).click();
    }

    public void verifyDollarSignOnHomePage(){
        //Verify if build your own computer price is display in Dollar (Assert Point)
        String actual_Message = driver.findElement(_verifyDollarSign).getText();
        Assert.assertTrue(actual_Message.startsWith("$"), "US Dollar is not the currency selected");
    }

    public void changeDollarIntoEuroSign(){
        //Change the Dollar into Euro sign
        clickOnElement(_changeDollarToEuro);
        //driver.findElement(By.xpath("//*[@id=\"customerCurrency\"]/option[2]")).click();
    }

    public void verifyEuroSignOnHomePage(){
        //Verify if build your own computer price is display in Euro (Assert Point)
        String actualMessage = driver.findElement(_verifyEuroSign).getText();
        Assert.assertTrue(actualMessage.contains("Euro"), "Euro is not the currency selected");
    }

    public void buildYourOwnComputerOnHomePage(){
        //Click on the Build your own computer
        clickOnElement(_buildYourOwnComputer);
    }

    public void verifyIfNonRegisteredUserIsAbleToVote(){
        //Select on good button on homepage under community poll
        clickOnElement(_goodButtonUnderCommunityPoll);

        //Click on vote button
        clickOnElement(_voteButton);

        //Verify that user is not able to vote without being registered
        driverWaitUntilVisibilityOfAllElementsLocatedBy(3, _errorMessageForVote);
        String actualMessage = driver.findElement(_errorMessageForVote).getText();
        Assert.assertTrue(actualMessage.contains("Only registered users can vote."), "Non registered user is able to vote");
        //Vote Error Message = "Only registered users can vote."
    }

    public void verifyRegisteredUserIsAbleToVote(){
        //Select on good button on homepage under community poll
        clickOnElement(_goodButtonUnderCommunityPoll);

        //Click on vote button
        clickOnElement(_voteButton);

        //Verify registered user is able to vote
        String actualMessage = driver.findElement(_successMessageForVote).getText();
        Assert.assertTrue(actualMessage.contains("vote(s)..."), "Registered user is not able to vote");
        //Vote Success Message = "20 vote(s)..."
    }
}