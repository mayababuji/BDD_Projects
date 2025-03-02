package hooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import webDriverManager.DriverFactory;
import utilities.LoggerLoad;
import utilities.ConfigReader;

public class Hooks {
	private static WebDriver driver;
	private static DriverFactory driverfactory;
	ConfigReader configFileReader = new ConfigReader();
	
	@Before
	public void before() throws Throwable {
						
		String browser = Reporter.getCurrentTestResult() == null ? null : Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");	
		if (browser==null) {
			
			driverfactory = new DriverFactory();
			//browser =ConfigReader.getBrowserType();
			browser=System.getProperty("browserProperty");
			LoggerLoad.info("Testing on browser declared in the config file which is "+browser);
			ExtentService.getInstance().setSystemInfo("os", "mac");
		   
			driverfactory.webdriverinitialize(browser);
			driver = DriverFactory.getDriver();
			driver.get(ConfigReader.getApplicationUrl("applicationurl"));
			LoggerLoad.info("Initializing driver for : "+ browser);
		}
		else {
			driverfactory = new DriverFactory();
			LoggerLoad.info("Testing on browser declared in the testng XML file which is "+browser);
			driverfactory.webdriverinitialize(browser);
			driver = DriverFactory.getDriver();
			driver.get(ConfigReader.getApplicationUrl("applicationurl"));
			LoggerLoad.info("Initializing driver for the browser : "+ browser);
		}
	
	}
	
	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Myscreenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		
		}
	}

	@After
	public static void after() throws Throwable {
		LoggerLoad.info("Closing Driver");
		driverfactory.quitDriver();
	}
}