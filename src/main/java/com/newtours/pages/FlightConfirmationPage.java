package com.newtours.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	private WebDriver driver;
	private WebDriverWait wait;

public FlightConfirmationPage(WebDriver driver) {
		
	this.driver =driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(4));
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//font[contains(text(),'Confirmation')]")
private WebElement flightConfirmationText;

@FindBy(xpath="//font[contains(text(),'USD')]")
private List<WebElement> priceAndTax;

@FindBy(linkText="SIGN-OFF")
private WebElement signoff;;


public String printConfirmation() {
	
	this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationText));
	System.out.println(this.flightConfirmationText.getText());
	String price=this.priceAndTax.get(1).getText();
	return price;
}

public void signoOffClick() {
	
	this.signoff.click();
}
}
