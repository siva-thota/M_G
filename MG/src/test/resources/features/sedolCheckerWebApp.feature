@SEDOL
Feature:Validate SEDOL string

  Background:
    Given I navigate to sedol validator page

  @Test1
  Scenario Outline: Null empty string or string other than 7 characters long
    When I input the stringValue"<InputStringTestValue>"
    Then I validate "<IsValidSedol>","<IsUserDefined>","<ValidationDetails>"

    Examples:
      | InputStringTestValue | IsValidSedol | IsUserDefined | ValidationDetails                       |
      | 123456789            | False        | False         | Input string was not 7-characters long. |
      | ''                   | False        | False         | Input string was not 7-characters long. |
      | 12                   | False        | False         | Input string was not 7-characters long. |
      |                      | False        | False         | Input string was not 7-characters long. |

  @Test2
  Scenario Outline: Invalid non user define SEDOL
    When I input the stringValue"<InputStringTestValue>"
    Then I validate "<IsValidSedol>","<IsUserDefined>","<ValidationDetails>"
    Examples:
      | InputStringTestValue | IsValidSedol | IsUserDefined | ValidationDetails                                        |
      | 1234567              | False        | False         | Checksum digit does not agree with the rest of the input |

  @Test3
  Scenario Outline: Valid non user define SEDOL
    When I input the stringValue"<InputStringTestValue>"
    Then I validate "<IsValidSedol>","<IsUserDefined>","<ValidationDetails>"
    Examples:
      | InputStringTestValue | IsValidSedol | IsUserDefined | ValidationDetails |
      | 0709954              | True         | False         |                   |
      | B0YBKJ7              | True         | False         |                   |

  @Test4
  Scenario Outline: Invalid user defined SEDOL
    When I input the stringValue"<InputStringTestValue>"
    Then I validate "<IsValidSedol>","<IsUserDefined>","<ValidationDetails>"
    Examples:
      | InputStringTestValue | IsValidSedol | IsUserDefined | ValidationDetails                                        |
      | 9123451              | False        | True          | Checksum digit does not agree with the rest of the input |
      | 9ABCDE8              | False        | True          | Checksum digit does not agree with the rest of the input |

  @Test5
  Scenario Outline: Valid user defined SEDOL
    When I input the stringValue"<InputStringTestValue>"
    Then I validate "<IsValidSedol>","<IsUserDefined>","<ValidationDetails>"

    Examples:
      | InputStringTestValue | IsValidSedol | IsUserDefined | ValidationDetails |
      | 9123458              | True         | True          |                   |
      | 9ABCDE1              | True         | True          |                   |