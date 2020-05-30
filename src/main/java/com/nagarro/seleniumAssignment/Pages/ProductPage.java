package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class ProductPage extends Base {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = AmazonConstants.PRODUCT_TITLE)
	WebElement ProductTitle;

	@FindBy(xpath = AmazonConstants.ADD_TO_CART_MAIN)
	WebElement AddToCartButton;

	@FindBy(xpath = AmazonConstants.All_BUYING_OPTION_BUTTON)
	WebElement AllBuyingOptionsButton;

	@FindBy(xpath = AmazonConstants.ADD_TO_CART_SECOND)
	WebElement AddToCartSecondButton;

	CommonFunctions common = new CommonFunctions();

	// To get the the title of opened product from search results page
	public String getOpenedProductTitle() {

		// Explicit Wait to wait for element
		common.waitForElement(ProductTitle);

		String openedProductTitle = ProductTitle.getText();
		test.log(Status.INFO,
				" Captured the title of the clicked product on Product page ");
		log.info(" *** Captured the title of the clicked product on Product page *** ");

		return openedProductTitle;

	}

	// to add the product in cart
	public void addProductToCart() {

		// verifying if "Add To Cart" button is present on the page
		if (AddToCartButton.isDisplayed()) {
			common.waitForElement(AddToCartButton);
			AddToCartButton.click();
			test.log(Status.INFO, " Clicked on Add to Cart button ");
			log.info(" *** Clicked on Add to Cart button *** ");
		}
		// if Add to Cart is not present then, clicking on
		// "See All Buying Options" button and then clicking on Add to Cart
		// button
		else if (AllBuyingOptionsButton.isDisplayed()) {
			common.waitForElement(AllBuyingOptionsButton);
			AllBuyingOptionsButton.click();
			test.log(
					Status.INFO,
					" Clicked on See All Buying Options button in case of Add to Cart button is not displayed on the page ");
			log.info(" *** Clicked on See All Buying Options button in case of Add to Cart button is not displayed on the page ***");

			common.waitForElement(AddToCartSecondButton);
			AddToCartSecondButton.click();
			test.log(
					Status.INFO,
					" Clicked on Add to Cart button after clicking on See All buying options button ");
			log.info(" *** Clicked on Add to Cart button after clicking on See All buying options button *** ");

		} else {
			log.debug("Add to Cart Button is not displayed");
		}
	}

}
