package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class baseClass {
	private static WebDriver driver;

	private baseClass() {
		// Private constructor to prevent instantiation
	}

	@BeforeTest
	public static WebDriver getDriver() throws MalformedURLException {
		String host = "localhost";
		MutableCapabilities dc;

		if (driver == null) {

			if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
				dc = new FirefoxOptions();
			else {
				dc = new ChromeOptions();
			}
			
			if (System.getProperty("HUB_HOST") != null) {
				host = System.getProperty("HUB_HOST");
			}
			
			String completeUrl = "http://" + host + ":4444/wd/hub";
			

			driver = new RemoteWebDriver(new URL(completeUrl), dc);
		}
		return driver;

	}
	/*
	
	@BeforeTest
	public static WebDriver getDriver() throws MalformedURLException {
	
		

		if (driver == null) {

			
			

			driver = new FirefoxDriver();
		}
		return driver;

	}

*/
	@AfterTest
	public void quit() {
		driver.quit();
	}

}
