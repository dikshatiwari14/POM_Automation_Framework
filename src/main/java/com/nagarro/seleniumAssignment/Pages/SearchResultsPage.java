package com.nagarro.seleniumAssignment.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class SearchResultsPage extends Base {
	
	ExtentTest test;

	public SearchResultsPage(WebDriver driver, ExtentTest test){
		super(driver);
		this.test = test;
	}
	// Declaring variable to store the product title before clicking on it
    public static String firstProductTitle;
	CommonFunctions common = new CommonFunctions();
    
	@FindBy(xpath = AmazonConstants.FIRST_PRODUCT_LINK)
	WebElement FirstProductLink;
	
	@FindBy(xpath = AmazonConstants.PRODUCT_TITLE)
	WebElement ProductTitle;
	
	@FindBy(xpath = AmazonConstants.CONFIRMATION_TEXT)
	List<WebElement> AddToCartConfirmationText;
	
	public String getClickedProductTitle(){
			
		// explicit wait - to wait for the products to be visible on search results page
		common.waitForElement(FirstProductLink);
		
    	//To get the title of First product on search results page
		test.log(Status.INFO, " *** getting the title of the first product on search results page *** ");
		log.info(" *** getting the title of the first product on search results page *** ");
		
        firstProductTitle = FirstProductLink.getText();
         return firstProductTitle;
         
	}
	
	public void clickOnFirstProduct(){
		
        // To click on the First product on search results page
		test.log(Status.INFO, " *** Clicking on the first product on search results page.*** ");
		log.info(" *** Clicking on the first product on search results page.*** ");
		
		FirstProductLink.click();
		
		
	}
}


