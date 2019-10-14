Feature: n11.com Applications Test

  Scenario: Validate n11.com Home Page Test

    When close the main popup
    Then user is on login page
    Then user enter username and password


  Scenario: Password is wrong

    When close the main popup
    Then user is on login page
    Then user enter username without password



  Scenario: check AllManButiqueLinks

    When go to man butique
    Then check all url