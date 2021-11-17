Feature:  CRM login Feature

Scenario: CRM login Scenario
Given User is already on login page
When login page title is CRMnext
Then user enter UserName and Password
Then user click on login button
And user is on home page 


@Smoke
Scenario:  CRM login Scenario
Given User is already on login page
When login page title is CRMnext
Then user enter UserName and Password
Then user click on login button
And user is on home page 
Then CustomTabLayout Objects
Then SummaryDropDown objects
Then CustomView Table
Then AvailableToQA Bugs List with three filter input "QA Bug" "Available to QA" and "All" 


@Regression
Scenario: Fetch Invalid Status Bugs
Given User is already on login page
When login page title is CRMnext
Then user enter UserName and Password
Then user click on login button
And user is on home page
Then Invalid Staus bugs list "QA Bug" and "Invalid"