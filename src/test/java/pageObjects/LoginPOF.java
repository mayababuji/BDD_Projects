package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ConfigReader;
import webDriverManager.DriverFactory;
import utilities.LoggerLoad;


public class LoginPOF {
	// Define the WebDriver instance and instantiate i
	WebDriver driver = DriverFactory.getDriver();
	ConfigReader configFileReader=DriverFactory.configReader();
		
		
		@FindBy(xpath = "//button[@class='btn']")
		WebElement getStarted;
		
		@FindBy(linkText = "Sign in")
	    WebElement signIn;
		
		@FindBy(id = "id_username")
	    WebElement usernameField;
		
		@FindBy(id = "id_password")
	    WebElement passwordField;
		
		@FindBy(xpath = "//input[contains(@value,'Login')]")
	    WebElement loginButton;
		
		@FindBy(xpath = "//a[@href='/logout']")
	    WebElement signoutButton;
		
		@FindBy(xpath = "//div[@class='alert alert-primary']")
	    WebElement alertmessage;
		
		
		@FindBy(xpath = "//a[@href='data-structures-introduction']")
	    WebElement getStartedDataStructures;
		
		
		@FindBy(xpath = "//a[@href='array']")
	    WebElement getStartedArray;
		
		
		@FindBy(xpath = "//a[@href='linked-list']")
	    WebElement getStartedLinkedList;
		
		
		@FindBy(xpath = "//a[@href='stack']")
	    WebElement getStartedStack;
		
		
		@FindBy(xpath = "//a[@href='queue']")
	    WebElement getStartedQueue;
		
		
		@FindBy(xpath = "//a[@href='tree']")
	    WebElement getStartedTree;
		
		@FindBy(xpath = "//a[@href='graph']")
	    WebElement getStartedGraph;
		
		// Constructor to initialize the page object with the WebDriver instance
		public LoginPOF() {
			
			// Use the PageFactory.initElements method to initialize the elements on the login page
			PageFactory.initElements(driver, this);
		}
		
		
		public void clickOnGetstarted() {
			
			LoggerLoad.info("Clicking on get started" );
		    getStarted.click();
			
		}
		
		
		
		public void clickOnSignin() {
			LoggerLoad.info("Clicking in Signin Button " );
			signIn.click();
		}
		
		public String getTitleHomePage(String expectedTitle) {
			
			String actualTitle = driver.getTitle();
			LoggerLoad.info("The Page Title is" + actualTitle);
			return actualTitle;
		}
		
		
	   public void clickonLogin() {
					LoggerLoad.info("Clicking in Login Button " );
					loginButton.click();
					
				}
				
				
	  public String validate_login_with_blank_credentials(String validationMessage,String field) {
					
					LoggerLoad.info("Expected error message is   "+ validationMessage );
					String message1 = null;
					if (field.equalsIgnoreCase("username")) {
					@SuppressWarnings("deprecation")
					String message = usernameField.getAttribute("validationMessage");
					message1 =message;	

					} else if (field.equalsIgnoreCase("password")) {
						@SuppressWarnings("deprecation")
						String message = passwordField.getAttribute("validationMessage");
						message1 =message;		
					}
					
					return message1;
							
				}
				
		public void enter_user_name(String username) {
					LoggerLoad.info("Clearing the username fields");
					usernameField.clear();
					LoggerLoad.info("Entering the  User Name  "+ username );
					usernameField.sendKeys(username);	
				}
				
		public void enter_user_password(String password) {
					LoggerLoad.info("Clearing the username fields");
					passwordField.clear();
					LoggerLoad.info("Entering the  User Name  "+ password );
					passwordField.sendKeys(password);	
				}
				
		public void enter_login_credentails(String username, String password ) {
					
					
					LoggerLoad.info("Clearing the username fields");
					usernameField.clear();
					LoggerLoad.info("Entering the  User Name  "+ username );
					usernameField.sendKeys(username);
					LoggerLoad.info("Clearing the password fields");
					passwordField.clear();
					LoggerLoad.info("Entering the  Password "+ password );
					passwordField.sendKeys(password);
					
					
				}
		
				public void clickOnGetstartedDataStructures() {
					
					LoggerLoad.info("Clicking on Datastructures getstarted" );
					getStartedDataStructures.click();
					
				}
				public void clickonLogout() {
					LoggerLoad.info("Clicking in Signout Button " );
					signoutButton.click();
					
							
						}
				
				public String getlogoutAlert(String expectedLogoutMessage) {
					String logoutMessage = alertmessage.getText();
					LoggerLoad.info("The alert message is " +logoutMessage);
					return logoutMessage;
				}
				
				public void clickOnGetstartedArray() {
					
					LoggerLoad.info("Clicking on Array getstarted" );
					getStartedArray.click();
					
				}



				public void clickOnGetstartedLinkedList() {
	
					LoggerLoad.info("Clicking on LinkedList getstarted" );
					getStartedLinkedList.click();
					
				}

				public void clickOnGetstartedStack() {
	
					LoggerLoad.info("Clicking on Stack getstarted" );
					getStartedStack.click();
					
				}
	

				public void clickOnGetstartedQueue() {
	
					LoggerLoad.info("Clicking on Queue getstarted" );
					getStartedQueue.click();
					
				}

				public void clickOnGetstartedTree() {
	
					LoggerLoad.info("Clicking on Tree getstarted" );
					getStartedTree.click();
					
				}

				public void clickOnGetstartedGraph() {
	
					LoggerLoad.info("Clicking on Graph getstarted" );
					getStartedGraph.click();
					
				}
				public String siginPageTitle() {
					
					String succesmsg=alertmessage.getText();
					return succesmsg;
					
									
								}


}
