package com.searchmodule.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tests.baseClass;
import com.searchmodule.pages.SearchPage;

public class seachPageTest {
	
	private WebDriver driver;

	
	@BeforeTest
	public void setup() throws Exception {
		this.driver=baseClass.getDriver();
		
	}
	
	@Test
	@Parameters("keyword")
	public void doSearch(String keyword) {
		SearchPage searchPage=new SearchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.verifyResult();
	}
	
	
	
}
