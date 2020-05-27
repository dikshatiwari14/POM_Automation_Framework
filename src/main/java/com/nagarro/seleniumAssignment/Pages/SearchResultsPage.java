package com.nagarro.seleniumAssignment.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class SearchResultsPage extends Base {
    public static String firstProductTitle;
	
	public SearchResultsPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = AmazonConstants.FIRST_PRODUCT_LINK)
	WebElement FirstProductLink;
	
	@FindBy(xpath = AmazonConstants.PRODUCT_TITLE)
	WebElement ProductTitle;
	
	@FindBy(xpath = AmazonConstants.CONFIRMATION_TEXT)
	List<WebElement> AddToCartConfirmationText;
	
	CommonFunctions common = new CommonFunctions(driver);
	
	public String getClickedProductTitle(){
			
		// explicit wait - to wait for the products to be visible on search results page
		common.waitForElement(FirstProductLink);
		
    	//To get the title of First product on search results page
        firstProductTitle = FirstProductLink.getText();
         return firstProductTitle;
         
	}
	
	public void clickOnFirstProduct(){
		
        // To click on the First product on search results page
		FirstProductLink.click();
		log.info("Clicking on the first product on search results page.");
		
	}
}


