package com.nagarro.seleniumAssignment.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.nagarro.seleniumAssignment.Utilities.ConfigReader;
import com.nagarro.seleniumAssignment.Utilities.ExcelReader;

public class Base {

	public static ConfigReader propertiesFileReader = new ConfigReader();
	public static WebDriver driver;
	public ExcelReader xls = new ExcelReader(System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestData\\Data.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExtentTest test;

	// To set up the browser
	public WebDriver browserSetup() {
		String browser = propertiesFileReader.getProperty("browser");
		log.info("Browser Name is :" + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Launching Chrome Browser");
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Launching Firefox Browser");

		} else if (browser.equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.info("Launching InternetExplorer Browser");

		} else {
			System.err.println("Please Enter Correct Browser");
		}

		// Maximize the browser window
		driver.manage().window().maximize();

		// Applying Implicit Wait
		int ImplicitWait = Integer.parseInt(propertiesFileReader
				.getProperty("implicitwait"));
		driver.manage().timeouts()
				.implicitlyWait(ImplicitWait, TimeUnit.SECONDS);
		log.info(ImplicitWait);
		return driver;
	}

	// To Navigate to application URL
	public void navigateToUrl() {
		driver.get(propertiesFileReader.getProperty("url"));
	}

	@BeforeClass(groups = { "Regression", "Sanity" })
	public void initiate() {
		browserSetup();
		navigateToUrl();
		log.info("Navigating to " + propertiesFileReader.getProperty("url")
				+ " URL");
	}

	@AfterClass(groups = { "Regression", "Sanity" })
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			log.info("Closing Browser");
		}
	}
}
