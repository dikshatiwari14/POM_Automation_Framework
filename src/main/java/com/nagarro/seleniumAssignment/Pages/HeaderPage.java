package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class HeaderPage extends Base{
	
	public HeaderPage(WebDriver driver){
		super(driver);
	}
		
	@FindBy(xpath = AmazonConstants.CATEGORY_DROPDOWN)
	WebElement SearchCategoryDropdown;
	
	@FindBy(xpath = AmazonConstants.SEARCH_FIELD)
	WebElement SearchTextField;
	
	@FindBy(xpath = AmazonConstants.GO_BUTTON)
	WebElement GoButton;
	
	@FindBy(xpath = AmazonConstants.CART_LINK)
	WebElement CartLink;
    
	CommonFunctions common = new CommonFunctions(driver);
	
	//method to select any product category in search field
	public void searchProduct(String category, String searchText){
				
		common.selectDropdown(SearchCategoryDropdown, category);
		log.info("Clicking on search category dropdown and selecing one category.");
		
		SearchTextField.sendKeys(searchText);
		log.info("Entering the search keyword.");
		
		GoButton.click();
		log.info("Clicking on search button to perform search.");
	}
	
	// method to navigate to cart page
	public void goToCartPage(){
		
		CartLink.click();
		log.info("Clicking on Cart button on main header.");

	}
	

	
}
