package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverManager extends Utils{

//            public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
//            public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
//            public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    String browserName = "chrome";

    public void openBrowser(){

        if (browserName.equalsIgnoreCase("Chrome")){
            //Open Chrome
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); //import Chrome web-driver dependency in the 'POM' file
            //System.setProperty("WebDriver.chrome.driver","src/test/java/Drivers/chromedriver");
        } else if (browserName.equalsIgnoreCase("Firefox")){
            //Open Firefox
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(); //import Chrome web-driver dependency in the 'POM' file
            //System.setProperty("WebDriver.gecko.driver","src/test/java/Drivers/geckodriver");
        } else if (browserName.equalsIgnoreCase("Edge")){
            //Open Microsoft Edge
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(); //import Chrome web-driver dependency in the 'POM' file
        } else if (browserName.equalsIgnoreCase("Safari")){
            //Open Safari
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver(); //import Chrome web-driver dependency in the 'POM' file
        } else {
            System.out.println("Provide a browser name or enter browser name correctly:"+browserName);
        }

        //Duration to timing
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //if the line is 'RED' then click on the bulb and select the first option

        //Maximize the screen
        driver.manage().window().maximize();

        //Open the URL
        driver.get("https://demo.nopcommerce.com/");
    }

    public void closeBrowser(){
        //to close the web page
        driver.quit();
    }

}