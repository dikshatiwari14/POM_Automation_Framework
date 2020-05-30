package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class HeaderPage extends Base {

	public HeaderPage() {
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

	@FindBy(xpath = AmazonConstants.Account_And_Lists)
	WebElement AccountAndLists;

	@FindBy(xpath = AmazonConstants.Your_Account)
	WebElement YourAccount;

	CommonFunctions common = new CommonFunctions();

	// method to select any product category and product search keyword

	public void searchProduct(String category, String searchText) {

		common.selectDropdown(SearchCategoryDropdown, category);
		test.log(Status.INFO,
				" Clicked on search category dropdown and selecting one category ");
		log.info(" *** Clicked on search category dropdown and selecting one category *** ");

		SearchTextField.sendKeys(searchText);
		test.log(Status.INFO, " Entered the search keyword ");
		log.info(" *** Entered the search keyword*** ");

		GoButton.click();
		test.log(Status.INFO, " Clicked on search button to perform search ");
		log.info(" *** Clicked on search button to perform search.*** ");
	}

	// method to navigate to cart page from header
	public void goToCartPage() {

		CartLink.click();
		test.log(Status.INFO, " Clicked on Cart button on main header ");
		log.info(" *** Clicked on Cart button on main header. *** ");
	}

	// method to navigate to "Your Account" option from header
	public void goToYourAccount() {

		Actions actions = new Actions(driver);
		actions.moveToElement(AccountAndLists).perform();
		common.waitForElement(YourAccount);
		YourAccount.click();
		test.log(Status.INFO, " Clicked on Your Account link ");
		log.info(" *** Clicked on Your Account link *** ");
	}

}
