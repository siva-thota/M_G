package com.automationtest.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siva.Thota on 16/Oct/2018
 **/
public class BasePage {
    public static WebDriver driver;
    private static final Integer POLLING_TIME=100;


    public WebDriver getDriver() {
        String userPath=System.getProperty ("user.dir");
        System.setProperty ("webdriver.chrome.driver", userPath + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.manage ().window ().maximize ();
        this.driver= driver;
        return driver;
    }

    public void navigateToBaseUrl() {
        getDriver();
        driver.navigate ().to ("http://sedolcheckerwebapp.azurewebsites.net//");
    }

    public void waitForClickable(WebElement element, final long timeout) throws Exception {
        try {
            FluentWait<WebDriver> customWait=new FluentWait<WebDriver> (driver).withTimeout (timeout, TimeUnit.SECONDS)
                    .pollingEvery (POLLING_TIME, TimeUnit.MILLISECONDS).ignoring (ElementNotVisibleException.class, StaleElementReferenceException.class);
            customWait.until (ExpectedConditions.elementToBeClickable (element));

        } catch (NoSuchElementException nse) {
            throw new Exception ("Failed to find the element: " + element);
        }
        catch (Exception ex){
            throw new Exception ("Clickable element is not yet loaded " + element);
        }
    }

}
