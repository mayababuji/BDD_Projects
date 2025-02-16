package stepDefinitions;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPOF;

import utilities.LoggerLoad;
import utilities.Utility_Methods;
import utilities.ConfigReader;

import utilities.ExcelReader;

import org.testng.Assert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;

import java.util.List;
import java.util.Map;


public class LoginSteps {
	
	
	public LoginPOF loginpagefactory = new LoginPOF();
	static String username;
	static String password;
	static String message;
	String Excelpath=ConfigReader.getexcelfilepath();
	Utility_Methods util=new Utility_Methods();
	

	////@TestScenario_login_01  
	@Given("The user is on the DS Algo Home Page")
	public void the_user_is_on_the_ds_algo_home_page() {
		//loginpagefactory.homepage();
		loginpagefactory.clickOnGetstarted();
	}
////@TestScenario_login_01 
	@When("The user should click the Sign in link")
	public void the_user_should_click_the_sign_in_link() {
		loginpagefactory.clickOnSignin();
	}
////@TestScenario_login_01 
	@Then("The user should be redirected to Sign in page and the title of the page should be {string}")
	public void the_user_should_be_redirected_to_sign_in_page_and_the_title_of_the_page_should_be(String expectedTitle) {
		String actualTitle = loginpagefactory.getTitleHomePage(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
     ////@TestScenario_login_02 & @TestScenario_login_03  &  @TestScenario_login_04 & @TestScenario_login_05
	@Given("The user is on the DS Algo Login Page")
	public void the_user_is_on_the_ds_algo_login_page()  {
		LoggerLoad.info("Opening the Login Page");
		
		loginpagefactory.clickOnGetstarted();  ///new added
		
		loginpagefactory.clickOnSignin();
		//loginpagefactory.loginpage();
	}
    ////@TestScenario_login_02
	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {


		loginpagefactory.clickonLogin();
	}

    ////@TestScenario_login_02 & @TestScenario_login_03 & @TestScenario_login_04 
	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String validationMessage) {
		String username ="username";
		String message =loginpagefactory.validate_login_with_blank_credentials(validationMessage,username);
		Assert.assertEquals(validationMessage, message);
	}
   ////@TestScenario_login_03
	@When("User clicks on login button with username as {string}")
	public void user_clicks_on_login_button_with_username_as(String username) {
		loginpagefactory.clickOnSignin();
		loginpagefactory.enter_user_name(username);
		loginpagefactory.clickonLogin();
	}
   ////@TestScenario_login_03
	@Then("User verify the message at password as {string}")
	public void user_verify_the_message_at_password_as(String validationMessage) {
		String password ="password";
		String message =loginpagefactory.validate_login_with_blank_credentials(validationMessage,password);
		Assert.assertEquals(validationMessage, message);
	}
    //////@TestScenario_login_04
	@When("User clicks on login button with password as {string}")
	public void user_clicks_on_login_button_with_password_as(String password) {
		loginpagefactory.clickOnSignin();
		loginpagefactory.enter_user_password(password);
		loginpagefactory.clickonLogin();
	}
   ////@TestScenario_login_05 
	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String username, String password) {
		loginpagefactory.clickOnSignin();
		LoggerLoad.info("The user succesfully clicked on signin button");
		loginpagefactory.enter_login_credentails(username,password);
		LoggerLoad.info("The user succesfully entered  the username and password");
}
  ////@TestScenario_login_05
	@Then("The user should land in Data Structure Home Page with message {string}")
	public void the_user_should_land_in_data_structure_home_page_with_message(String string) {
		String expectedTitle = "NumpyNinja";
		loginpagefactory.clickonLogin();
		LoggerLoad.info("The user succesfully clicked on signin button");
		String actualTitle = loginpagefactory.getTitleHomePage(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	///@TestScenario_login_07
	@Given("The user is in home page and enters  email as {string} and password as {string} and in {string}")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in(String username, String password, String string3) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedDataStructures();
	}
	///@TestScenario_login_07  & @TestScenario_login_08
	@When("The user clicks on signout button")
	public void the_user_clicks_on_signout_button() {
		loginpagefactory.clickonLogout();
	  
		LoggerLoad.info("The user succesfully clicked on signout button");
	}
	///@TestScenario_login_07 & @TestScenario_login_08
	@Then("Verify the logout message {string}")
	public void verify_the_logout_message(String expectedLogoutMessage) {
		String logoutMessage = loginpagefactory.getlogoutAlert(expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
	}
	///@TestScenario_login_08
	@Given("The user is in home page and enters  email as {string} and password as {string} and in Array page")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in_array_page(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedArray();
		
	}
	
	///@TestScenario_login_09
	@Given("The user is in home page and enters  email as {string} and password as {string} and in Linked List")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in_linked_list(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedLinkedList();
	}
	///@TestScenario_login_10
	@Given("The user is in home page and enters  email as {string} and password as {string} and in Stack")
	public void t_the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in_stack(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedStack();
	}
	
	//@TestScenario_login_11
	@Given("The user is in home page and enters  email as {string} and password as {string} and in Queue Page")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in_queue_page(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedQueue();
	}
	//@TestScenario_login_12
	@Given("The user is in home page and enters  email as {string} and password as {string} and in Tree")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in_tree(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedTree();
	}
	//@TestScenario_login_13
	@Given("The user is in home page and enters  email as {string} and password as {string} and in Graph page")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as_and_in_graph_page(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		loginpagefactory.clickOnGetstartedGraph();
	}
    ////@TestScenario_login_14
	@Given("The user is in home page and enters  email as {string} and password as {string}")
	public void the_user_is_in_home_page_and_enters_email_as_and_password_as(String String1, String String2) throws InvalidFormatException, IOException {
		loginpagefactory.clickOnGetstarted();
		loginpagefactory.clickOnSignin();
		username = util.get_username();
		password = util.get_password();
		loginpagefactory.enter_login_credentails(username,password);
		loginpagefactory.clickonLogin();
		
	 
	}
	
	///@TestScenario_login_15
	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = reader.getData(Excelpath, sheetname);
		username = testdata.get(rownumber).get("username");
		password = testdata.get(rownumber).get("password");
		message = testdata.get(rownumber).get("expectedmessage");

		LoggerLoad.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		if (username != null || password != null)
			loginpagefactory.enter_login_credentails(username, password);

	}
    //@TestScenario_login_15
	@Then("click login button")
	public void click_login_button() {
		String expectedTitle = "Login";
		loginpagefactory.clickOnSignin();
		String actualTitle = loginpagefactory.getTitleHomePage(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	/// @TestScenario_login_03
	@When("The user enter invalid {string} and {string}")
	public void the_user_enter_invalid_and(String username, String password) {
		loginpagefactory.enter_login_credentails(username,password);
		
	}
	/// @TestScenario_login_03
	@Then("click login button to verify {string}")
	public void click_login_button_to_verify(String validationMessage) {
		//loginpagefactory.clickOnSignin();
		loginpagefactory.clickonLogin();
		String username ="password";
		String message = loginpagefactory.validate_login_with_blank_credentials(validationMessage,username);
		Assert.assertEquals(validationMessage, message);
	}
	
	//// @TestScenario_login_16
	@When("The user clicks login to DsAlgo application for valid login credentails with  {string} and {int}")
	public void the_user_clicks_login_to_ds_algo_application_for_valid_login_credentails_with_and(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(Excelpath, sheetname);
		username = testdata.get(rownumber).get("username");
		password = testdata.get(rownumber).get("password");
		LoggerLoad.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		if (username != null || password != null)
			loginpagefactory.enter_login_credentails(username, password);
			loginpagefactory.clickonLogin();

	}
	
////@TestScenario_login_16
	@Then("The user should land in Data Structure Home Page with message from the row {string} and {int}")
	public void the_user_should_land_in_data_structure_home_page_with_message_from_the_row_and(String sheetname, Integer rownumber ) throws InvalidFormatException, IOException{
	
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(Excelpath, sheetname);
		LoggerLoad.info("The user succesfully clicked on signin button");
		String expectedTitle = testdata.get(rownumber).get("expectedmessage");
		String actualTitle = loginpagefactory.siginPageTitle();		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
		
}
