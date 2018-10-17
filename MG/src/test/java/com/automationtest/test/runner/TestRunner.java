package com.automationtest.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.automationtest.test.steps","com.automationtest.test.hooks"},
        tags={"@SEDOL"},
        format = { "pretty", "html:target/cucumber" })

public class TestRunner {

}

