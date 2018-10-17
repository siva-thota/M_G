package com.automationtest.test.steps;

import com.automationtest.test.BasePage;
import com.automationtest.test.SedolCheckerWebPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


/**
 * Created by Siva.Thota on 21/Dec/2017
 **/

public class SedolCheckerWebAppStepDefs extends BasePage {


    private SedolCheckerWebPage SedolCheckerWebPage;
    String inputSedol=null;

    @Given("^I navigate to sedol validator page$")
    public void i_navigate_to_sedol_validator_page() throws Throwable {
        navigateToBaseUrl ();
    }

    @When("^I input the stringValue\"([^\"]*)\"$")
    public void i_input_the_stringValue(String text) throws Exception {
        SedolCheckerWebPage=new SedolCheckerWebPage ();
        this.inputSedol=text;
        SedolCheckerWebPage.inputSEDOLCode (inputSedol);
        SedolCheckerWebPage.selectIsUserDefined ();
        SedolCheckerWebPage.selectIsValidSedol ();
        SedolCheckerWebPage.clickOnSubmitButton ();
    }

    @Then("^I validate \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void i_validate(Boolean isValidSedol, Boolean isUserDefinedVal, String validationMessage) {
        Assert.assertEquals (SedolCheckerWebPage.isValidSEDOL (inputSedol), isValidSedol);
        Assert.assertEquals (SedolCheckerWebPage.isUserDefined (isUserDefinedVal), isUserDefinedVal);
        Assert.assertEquals (SedolCheckerWebPage.getValidationMessage (),validationMessage );

    }

}