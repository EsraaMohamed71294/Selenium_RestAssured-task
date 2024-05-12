Feature: Test all Scenarios of Contact Details Page

  Background: User open site
    Given User Navigate to the website

  Scenario: User Add Contact Details of Employee Successfully
    Given User can Login Successfully
    And   User can Search by employee data
    When  User Open the Selected Employee To Add Details
    Then  I verify the appearance of success message
    And   User Stop Driver


