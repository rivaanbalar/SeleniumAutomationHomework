package org.example;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage{

    public static void takeAScreenshot(String a){
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Copy file at destination
        try{
            FileUtils.copyFile(srcFile, new File("ScreenShots"+a+randomDate()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public static @NotNull String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    public static void sleep(){
        try{
            Thread.sleep(1000*1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void driverWaitUntilURLToBe(int time, String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void driverWaitUntilElementToBeClickable(int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void driverWaitUntilElementToBeSelected(int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public static void driverWaitsTitle(int time, By by, String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void driverWaitForTitleContains(int time, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(text));
    }

    public static void driverWaitUntilAttributeContains(By by, int time, String attribute, String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(by, attribute, value));
    }

    public static void driverWaitForFrameToBeAvailableAndSwitchToIt(int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public static void driverWaitUntilInvisibilityOfElementLocated(int time, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void driverWaitUntilInvisibilityOfElementWithText(int time, By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    public static void driverWaitUntilTextToBePresentInElementLocated(int time, By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public static void driverWaitUntilTextToBePresentInElementValue(int time, By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }

    public static void driverWaitUntilVisibilityOfAllElementsLocatedBy(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void driverWaitUntilVisibilityOfElementLocated(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void driverWaitUntilNumberOfElementsToBe(int time, By by, int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.numberOfElementsToBe(by, number));
    }

    public static void driverWaitUntilNumberOfElementsToBeLessThan(int time, By by, int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by, number));
    }

    public static void driverWaitUntilNumberOfElementsToBeMoorThan(int time, By by, int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, number));
    }

}