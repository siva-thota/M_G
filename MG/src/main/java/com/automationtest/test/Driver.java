package com.automationtest.test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static void main(String[] args) {
        String userPath=System.getProperty ("user.dir");
        System.setProperty ("webdriver.chrome.driver", userPath + "/src/test/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.get ("http://www.facebook.com");
        driver.manage ().window ().maximize ();

    }

}
