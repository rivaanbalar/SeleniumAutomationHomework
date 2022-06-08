package org.example;

import org.openqa.selenium.By;

public class EmailAFriendPage extends Utils{

    LoadProperty loadProperty = new LoadProperty();

    private By _friendsEmailField = By.className("friend-email");
    private By _personalMessage = By.id("PersonalMessage");
    private By _sendEmailButton = By.name("send-email");

    public void userEnterFriendsEmailAndPersonalMessage(){
        //Enter friend's email
        typeText(_friendsEmailField, loadProperty.getProperty("EmailFriendO1")+randomDate()+loadProperty.getProperty("EmailFriend02"));

        //Enter personal message
        typeText(_personalMessage, loadProperty.getProperty("PersonalMessageToFriend"));
    }

    public void clickOnSendEmailButton(){
        //Click on send email button
        clickOnElement(_sendEmailButton);
    }

}