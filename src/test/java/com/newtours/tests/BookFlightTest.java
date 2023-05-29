	package com.newtours.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmationPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPages;

import tests.baseClass;


public class BookFlightTest {
	
	private String noOfPassangers;
	private String expectedPrice;
	
	private WebDriver driver ;
	
	@BeforeTest
	@Parameters({"noOfPassangers","expectedPrice"})
	
	public void setupValues(String noOfPassangers,String expectedPrice) throws Exception {
		this.driver = baseClass.getDriver();
		this.noOfPassangers=noOfPassangers;
		this.expectedPrice=expectedPrice;
	}
	
//	@BeforeTest
//	public void setupDriver() {
//		WebDriver driver = baseClass.getDriver();
//		driver=new FirefoxDriver();
//		
//		
//	}
	
	@Test
	public void gotoRegistrationPage() {
		RegistrationPages registrationPages=new RegistrationPages(driver);
		registrationPages.goTo();
		registrationPages.enterUserDetails("selenium", "docker");
		registrationPages.enterUserCredentials("richa", "soni");
		registrationPages.enterSubmitButton();
	}
	@Test(dependsOnMethods = "gotoRegistrationPage")
	public void gotoRegistrationConfirmationPage() {
		RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.goToFlightDetailsPage();
	}
	@Test(dependsOnMethods = "gotoRegistrationConfirmationPage")
	
	public void flightDetailsPage() {
		FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
		flightDetailsPage.selectPassengers(this.noOfPassangers);
		flightDetailsPage.goTofindFlightsPage();
	}
		@Test(dependsOnMethods = "flightDetailsPage")
	public void findFlightPage() {
		FindFlightPage findFlightPage=new FindFlightPage(driver);
		findFlightPage.clickReserveflightsConfirm();
		findFlightPage.clickbuyFlightsConfirm();
	}	
		
		@Test(dependsOnMethods = "findFlightPage")
		
		public void FlightConfirmationPage() {
			FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
			Assert.assertEquals(flightConfirmationPage.printConfirmation(),this.expectedPrice);
			flightConfirmationPage.signoOffClick();
		}
		
		
}
