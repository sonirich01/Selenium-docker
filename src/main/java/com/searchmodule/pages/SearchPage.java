package com.searchmodule.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(id="search_button_homepage")
	private WebElement searchIcon;
	
	@FindBy(linkText="Videos")
	private WebElement videosLink;
	
	@FindBy(className="tile--vid")
	private List<WebElement> videoTiles;
	
	public SearchPage(WebDriver driver) {
		    this.driver =driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		this.driver.get("https://duckduckgo.com/");
		waitForPageLoaded(driver);
	}
	
	public void doSearch(String keyword) {
		
		this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
		this.searchBox.sendKeys(keyword);
		this.searchIcon.click();
	}
	
	public Boolean verifyResult() {
		this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
		this.videosLink.click();
		
		int totalResult=this.videoTiles.size();
		if(totalResult>10) {
			return true;
		}else {
			return false;
		}
	}
	
	public void waitForPageLoaded(WebDriver driver) {

        ExpectedCondition<Boolean> expectation = new
   ExpectedCondition<Boolean>() {
           public Boolean apply(WebDriver driver) {
             return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
           }
         };

      
         try {
                wait.until(expectation);
         } catch(Throwable error) {
                 Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
         }
    } 

}
