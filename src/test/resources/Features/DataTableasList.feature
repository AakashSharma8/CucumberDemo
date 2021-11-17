Feature: UserRegestration

Scenario: User Regestration with different List of  data
Given user is on registration page
When User enter following details
	|Akash|Newzeland|akash@mail.com |123456789|
	|Shivam|India|Shivam@mail.com |123456454|
Then USer regestraion should be successful

Scenario: User Regestration with different data with columns
Given user is on registration page
When User enter following details with columns
	|First Name|Country|Email|Mobile No.|
	|Akash|Newzeland|akash@mail.com |123456789|
	|Shivam|India|Shivam@mail.com |123456454|
Then USer regestraion should be successful