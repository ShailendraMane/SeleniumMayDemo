Feature: Login Feature

Background:
  Given open browser and enter the valid url "http://live.techpanda.org/index.php/customer/account/login/"



  @valid@login
Scenario: valid user login
  When enter username "java@gmail.com" and password "Selenium@123"
  And click on submit button
  Then verify login successful "http://live.techpanda.org/index.php/customer/account/"

@invalid
Scenario: with invalid username
  When enter username "jav1@gmail.com" and password "Selenium@123"
  And click on submit button
  Then verify login successful "http://live.techpanda.org/index.php/customer/account/"

@params
Scenario Outline:
  Given open browser and enter the valid urlvalue
  When enter username "<Username>" and password "<Password>"
  And click on submit button
  Then verify login successful "http://live.techpanda.org/index.php/customer/account/"
  Examples:
     | Username|Password|
     |java@gmail.com|Selenium@123|
     |ava@gmail.com| Selenium@123|
     |java@gmail.com|sele@12345  |
     |ava@gmail.com |sele@12345  |

@datatable
Scenario:
  Given open browser and enter the valid urlvalue
  When enter valid username and valid password
    |java@gmail.com|Selenium@123|
    |ava@gmail.com| Selenium@123|
    |java@gmail.com|sele@12345  |
    |ava@gmail.com |sele@12345  |
  And click on submit button
  Then verify login successful "http://live.techpanda.org/index.php/customer/account/"

