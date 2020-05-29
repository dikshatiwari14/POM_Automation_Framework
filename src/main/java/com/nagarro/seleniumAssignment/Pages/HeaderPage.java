package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class HeaderPage extends Base{
	
	public HeaderPage(){
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = AmazonConstants.CATEGORY_DROPDOWN)
	WebElement SearchCategoryDropdown;
	
	@FindBy(xpath = AmazonConstants.SEARCH_FIELD)
	WebElement SearchTextField;
	
	@FindBy(xpath = AmazonConstants.GO_BUTTON)
	WebElement GoButton;
	
	@FindBy(xpath = AmazonConstants.CART_LINK)
	WebElement CartLink;
    
	CommonFunctions common = new CommonFunctions();
	
	//method to select any product category and product search keyword in search field
	public void searchProduct(String category, String searchText){
				
		test.log(Status.INFO, " *** Clicking on search category dropdown and selecting one category.*** ");
		log.info(" *** Clicking on search category dropdown and selecting one category.***  ");
		common.selectDropdown(SearchCategoryDropdown, category);
		
		test.log(Status.INFO, " *** Entering the search keyword.*** ");
		log.info(" *** Entering the search keyword.*** ");
		SearchTextField.sendKeys(searchText);
		
		test.log(Status.INFO, " *** Clicking on search button to perform search.*** ");
		log.info(" *** Clicking on search button to perform search.*** ");
		GoButton.click();
		
	}
	
	// method to navigate to cart page from header
	public void goToCartPage(){
		
		test.log(Status.INFO, " *** Clicking on Cart button on main header. *** ");
		log.info(" *** Clicking on Cart button on main header. *** ");
		CartLink.click();
		
	}
		
}
