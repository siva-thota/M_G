package com.automationtest.test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siva.Thota on 16/Oct/2018
 **/

public class SedolCheckerWebPage extends BasePage {

    @FindBy(id="inputBox")
    private WebElement sedolInput;

    @FindBy(xpath="//*[@id='div1']/p[1]/input")
    private WebElement isValidSedol;

    @FindBy(xpath="//*[@id='div1']/p[2]/input")
    private WebElement isUserDefined;

    @FindBy(id="submitSedol")
    private WebElement submitButton;

    @FindBy(xpath="//*[@id='div1']/div")
    private WebElement validationMessage;

    public SedolCheckerWebPage() {
        PageFactory.initElements (driver, this);
    }

    public void inputSEDOLCode(String inputext) {

        sedolInput.sendKeys (inputext);
    }

    public void selectIsValidSedol() {
        if (isValidSedol.isSelected ()) return;
        else
            isValidSedol.click ();
    }

    public void selectIsUserDefined() {
        if (isUserDefined.isSelected ()) return;
        else
            isUserDefined.click ();
    }


    public void clickOnSubmitButton() throws Exception {
        waitForClickable (submitButton, 30);
        submitButton.click ();
    }

    public boolean isValidSEDOL(String inputext) {
        if (inputext.length ()!=7) return false;
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char initialChar;
        int charPosition;
        int positionValue;
        int totalValue=0;
        int checkDigit;

        for (int i=0; i < 6; i++) {
            initialChar=inputext.charAt (i);
            charPosition=alpha.indexOf (inputext.charAt (i)) + 1;
            if (charPosition <= 26) {
                positionValue=charPosition + 9;

                //System.out.println(initialChar + " : " + (alpha.indexOf(initialChar)+1) +" : "+ (initialChar+9));
            } else {
                positionValue=charPosition - 27;
                //System.out.println(initialChar + " : " + (alpha.indexOf(initialChar)+1) +" : "+ (initialChar-27));
            }
            //System.out.println (initialChar + " : " + positionValue);
            if (i==0) {
                positionValue=positionValue * 1;
            } else if (i==1) {
                positionValue=positionValue * 3;
            } else if (i==2) {
                positionValue=positionValue * 1;
            } else if (i==3) {
                positionValue=positionValue * 7;
            } else if (i==4) {
                positionValue=positionValue * 3;
            } else if (i==5) {
                positionValue=positionValue * 9;
            }

            totalValue=totalValue + positionValue;

        }

        checkDigit=10 - (totalValue % 10) % 10;

        if (checkDigit==(inputext.charAt (6) - '0')) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isUserDefined(boolean isUserDefinedVal) {

        return isUserDefinedVal;
    }

    public String getValidationMessage() {
        String msg;
        try {
            msg=validationMessage.getText ();
        } catch (NoSuchElementException e) {
            msg="";
        }
        return msg;
    }

}
