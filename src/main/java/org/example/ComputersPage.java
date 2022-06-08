package org.example;

import org.openqa.selenium.By;

public class ComputersPage extends Utils{

    private By _desktopsButton = By.linkText("Desktops");

    public void desktopButton(){
        //Click on Desktops
        clickOnElement(_desktopsButton);
    }
}
