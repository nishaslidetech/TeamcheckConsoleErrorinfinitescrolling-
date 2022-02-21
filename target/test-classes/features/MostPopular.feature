@MostPopular
Feature: Check console errors on MostPopular page

  Scenario: Check console errors on MostPopular page
  Given user is already on home page
  Then click on Popular ppts text and check console error
  Then click on the any of one ppt and verify the console error
  Then click on the pagination and check the console errorfor two pages only
  Then click on the view page and check the console error
  Then click on the Filter By Category and check the console error
  