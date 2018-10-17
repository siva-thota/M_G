package com.automationtest.test.hooks;

import com.automationtest.test.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.IOException;

/**
 * Created by Siva.Thota on 16/Oct/2018
 **/


public class AfterHooks {
    @After()
    public void afterRunningScenario3(Scenario scenario) throws IOException {

        BasePage.driver.quit ();
    }


    }
