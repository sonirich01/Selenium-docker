package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	
	private WebDriver driver ;
	private WebDriverWait wait;
	
	@FindBy(id="passCount")
	private WebElement passengers;
	
	@FindBy(name="tripType")
	private WebElement tripType;
	
	@FindBy(name="findFlights")
	private WebElement submitButton;
	
	
	public FlightDetailsPage(WebDriver driver) {
		this.driver =driver;
		
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(4));
		PageFactory.initElements(driver, this);
	}
	
	public void selectPassengers(String passengerCount) {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.passengers));
		Select passengers=new Select(this.passengers);
		passengers.selectByValue(passengerCount);
	}

	public void goTofindFlightsPage() {
		this.submitButton.click();
	}

}
