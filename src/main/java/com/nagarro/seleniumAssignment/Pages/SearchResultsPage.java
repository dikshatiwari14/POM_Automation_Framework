package com.nagarro.seleniumAssignment.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class SearchResultsPage extends Base {

	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
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

	public String getClickedProductTitle() {

		// explicit wait - to wait for the products to be visible
		common.waitForElement(FirstProductLink);

		// To get the title of First product on search results page
		firstProductTitle = FirstProductLink.getText();
		test.log(Status.INFO,
				" Captured the title of the first product on search results page ");
		log.info(" *** Captured the title of the first product on search results page *** ");
		return firstProductTitle;
	}

	// To click on the First product on search results page
	public void clickOnFirstProduct() {

		FirstProductLink.click();
		test.log(Status.INFO,
				" Clicked on the first product on search results page ");
		log.info(" Clicked on the first product on search results page*** ");
	}

	// To switch the driver to new tab in which clicked product is opened
	public void switchToNewTab() {

		String parentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		log.info(" *** No of windows or tabs after clicking: "
				+ allWindows.size() + "*** ");
		allWindows.remove(parentWindow);
		Iterator<String> ite = allWindows.iterator();
		driver.switchTo().window((String) ite.next());
		log.info(" *** Switched to new tab of browser.*** ");
	}
}
