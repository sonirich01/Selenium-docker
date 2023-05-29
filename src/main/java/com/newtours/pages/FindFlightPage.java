package com.newtours.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "input_50_0_0")
	private WebElement emiratesEconomyDeparture;

	@FindBy(id = "input_50_0_0")
	private WebElement emiratesEconomyReturn;

	@FindBy(id = "reserveFlights")
	private WebElement reserveflightsConfirm;

	@FindBy(id = "buyFlights")
	private WebElement buyFlightsConfirm;

	public FindFlightPage(WebDriver driver) {
        this.driver =driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		PageFactory.initElements(driver, this);
	}

	public void clickReserveflightsConfirm() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveflightsConfirm));
		this.reserveflightsConfirm.click();
	}

	public void clickbuyFlightsConfirm() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFlightsConfirm));
		this.buyFlightsConfirm.click();
	}
}