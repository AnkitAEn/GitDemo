Feature: Login into the application

Scenario Outline: Positive test validation login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com/" Site
And Click on the Login link available on the top right corner to land on the signin page
When User enter <username> and <password> and click on login button
Then Verify the user to successfully logged in
And Close browser

Examples:
|username		 |password	|
|test@gmail.com  |12345678	|
|test1@gmail.com |12345678	|

