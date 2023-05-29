package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
	
	private WebDriver driver ;
	private WebDriverWait wait;
	
	
	public RegistrationConfirmationPage(WebDriver driver) {
		
		this.driver =driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(4));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText= "SIGN-ON")
	private WebElement signIn;
	
	@FindBy(id= "flight-link")
	private WebElement flightLink;
	
	
	
	public void goToFlightDetailsPage() {
		this.wait.until(ExpectedConditions.visibilityOf(signIn));
		this.flightLink.click();
		
	}
	

}
