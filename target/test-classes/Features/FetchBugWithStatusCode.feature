Feature: Bugs With Status code

Scenario: Get bugs with different status code
Given User is already on login page
Then user enter UserName and Password
Then user click on login button
Then AvailableToQA Bugs List with three filter input "QA Bug" "Available to QA" and "All"