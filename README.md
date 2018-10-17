Automation Framework design
============================

## Introduction ##
Test automation framework is designed using Selenium Webdriver, Java, cucumber, Junit and is mavenised, and designed in page object model.


## To Run the framework ##

Need any IDE such as Intellij or Eclipse, and import the project as a maven project.

Inside the Test folder, you should see the TestRunner file inside the runner folder, and run the file.




## Test Execution and Test Report ##

Inside the features folder, you should see the feature file with 5 tests. You can run the full feature by providing the feature level tag, or we can run the individual tests by providing the scenario level tag.

Test 2 and Test 5: These tests will fail because of the incorrect validation provided for the Tests
Expected: Checksum digit does not agree with the first 6 characters.
Actual: Checksum digit does not agree with the rest of the input

Note: we will raise a bug for this, if the expected is accurate according the requirements.


Test execution report can be found from below location and can be opened in any browser.
Location: /target/cucumber/index.html




## SEDOL validations performed in the framework ##

isValidSEDOL()
This method takes the input text in SEDOL input, and validates if the provided input text is a valid SEDOL or not, and returns either True of false.

validationMessage()
Validation message is retrieved from the UI, and compared with the expected validation message.

isUserDefined()
Logic of user defined was not completely clear to me from the instruction.
My understanding was the rule ‘The check digit for a SEDOL is chosen to make the total weighted sum of all seven characters a multiple of 10.’  Is for user defined. 
When tested manually the SEDOL for the 4th scenario (9123451 & 9ABCDE8) against the above rule and was NOT valid. In the 5th scenario (9123458 & 9ABCDE1) the above rule is VALID. So either the SEDOL given in the fourth scenario is wrong or the above rule mentioned is not complete. 

SO, with this ambiguity in mind, and I haven’t implemented the code for the is UserDefined() method. 
At the moment this method, just intakes the Value from the cucumber file and validates the same.

NOTE: This can be implemented when we have the requirements clearely.


