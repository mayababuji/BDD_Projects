@login
Feature: Login to DS-ALGO Application and validate login page with different scenarios
@TestScenario_login_01 @device_MAC @author_MAYAGHERKINS
  Scenario: To Verify that user is able to land on Login Page
    Given The user is on the DS Algo Home Page
    When The user should click the Sign in link
    Then The user should be redirected to Sign in page and the title of the page should be "Login"

  @TestScenario_login_02
  Scenario: To verify SignIn with Empty fields
    Given The user is on the DS Algo Login Page
    When User clicks on login button with all empty field
    Then User verify the message at username as "Please fll out this field."

  #@TestScenario_login_03
  #Scenario Outline: User on login page and login with invalid inputs "<username>" and "<password>"
    #Given The user is on the DS Algo Login Page
    #When The user enter invalid "<username>" and "<password>"
    #Then click login button to verify "Please fill out this field."
#
    #Examples: 
      #| username | password |
      #| user     |          |
#
  #@TestScenario_login_04
  #Scenario: To verify SignIn with username only
    #Given The user is on the DS Algo Login Page
    #When User clicks on login button with username as "*****"
    #Then User verify the message at password as "Please fill out this field."
#
  #@TestScenario_login_05
  #Scenario: To verify SignIn with password only
    #Given The user is on the DS Algo Login Page
    #When User clicks on login button with password as "******"
    #Then User verify the message at username as "Please fill out this field."
#
  #@TestScenario_login_06
  #Scenario Outline: Verify that user is able to land on Login Page "<Sheetname>" and <RowNumber>
    #Given The user is on the DS Algo Login Page
    #When The user enter sheet "<Sheetname>" and <RowNumber>
    #Then The user should land in Data Structure Home Page with message "You are logged in"
     #Examples: 
      #| Sheetname | RowNumber |
      #| SignIn    |         2 |
#
  #@TestScenario_login_07
  #Scenario: Verify that user able to sign out successfully being in "DataStructures Page"
    #Given The user is in home page and enters  email as "*****" and password as "****" and in "DataStructures Page"
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_08
  #Scenario: Verify that user able to sign out successfully being in "Array page"
    #Given The user is in home page and enters  email as "*****" and password as "*****" and in Array page
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_09
  #Scenario: Verify that user able to sign out successfully being in "Linked List page"
    #Given The user is in home page and enters  email as "*****" and password as "*****" and in Linked List
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_10
  #Scenario: Verify that user able to sign out successfully being in "Stack page"
    #Given The user is in home page and enters  email as "*****" and password as "*****" and in Stack
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_11
  #Scenario: Verify that user able to sign out successfully being in "Queue page"
    #Given The user is in home page and enters  email as "*****" and password as "*****" and in Queue Page
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_12
  #Scenario: Verify that user able to sign out successfully being in "Tree page"
    #Given The user is in home page and enters  email as "*****" and password as "*****" and in Tree
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_13
  #Scenario: Verify that user able to sign out successfully being in "Graph page"
    #Given The user is in home page and enters  email as "*****" and password as "*****" and in Graph page
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_14
  #Scenario: Verify signout from DS-Algo page
    #Given The user is in home page and enters  email as "*****" and password as "*****"
    #When The user clicks on signout button
    #Then Verify the logout message "Logged out successfully"
#
  #@TestScenario_login_15
  #Scenario Outline: User on login page and login with invalid and valid inputs from Excel "<Sheetname>" and <RowNumber>
    #Given The user is on the DS Algo Login Page
    #When The user enter sheet "<Sheetname>" and <RowNumber>
    #Then click login button
#
    #Examples: 
      #| Sheetname | RowNumber |
      #| SignIn    |         0 |
      #| SignIn    |         1 |
      #
         #Scenario: Verify that user is able to land on Login Page 
  #@TestScenario_login_16
  #
  #Scenario Outline: Verify that user is able to land on Login Page with valid credentials from "<Sheetname>" and <RowNumber>
    #Given The user is on the DS Algo Login Page 
    #When  The user clicks login to DsAlgo application for valid login credentails with  "<Sheetname>" and <RowNumber> 
    #
    #Then The user should land in Data Structure Home Page with message from the row "<Sheetname>" and <RowNumber>
     #Examples: 
      #| Sheetname | RowNumber |
      #| SignIn    |         2 |
