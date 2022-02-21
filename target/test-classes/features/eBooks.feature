@eBooks
Feature: Check console errors on eBooks

  @withoutLogin
  Scenario: Check console errors on eBooks pages
  Given user is the on home page
  Then click on eBooks text and check console error
  Then select option from sort By and check the console error

 
  @withLogin
  Scenario: Check console errors on eBooks pages withlogin
  Given Go to the home page 
  Then Enter paid valid credentials
  Then click on eBooks on the top navigation bar
  Then Select option from sort By and check the console error
  Then Logout from the application and verify the page
