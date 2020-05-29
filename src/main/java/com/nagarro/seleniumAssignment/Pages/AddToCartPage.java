package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class AddToCartPage extends Base {

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = AmazonConstants.ADD_TO_CART_MAIN)
	WebElement AddToCartButton;

	@FindBy(xpath = AmazonConstants.CONFIRMATION_TEXT)
	WebElement AddedToCartConfirmationText;

	@FindBy(xpath = AmazonConstants.All_BUYING_OPTION_BUTTON)
	WebElement AllBuyingOptionsButton;

	@FindBy(xpath = AmazonConstants.ADD_TO_CART_SECOND)
	WebElement AddToCartSecondButton;

	CommonFunctions common = new CommonFunctions();

	// to add the product in cart
	public void addProductToCart() {

		// verifying if "Add To Cart" button is present on the page
		if (AddToCartButton.isDisplayed()) {
			common.waitForElement(AddToCartButton);
			AddToCartButton.click();
			test.log(Status.INFO, "*** Clicking on Add to Cart button.*** ");
			log.info(" *** Clicking on Add to Cart button.*** ");
		} 
		// if Add to Cart is not present then, clicking on "See All Buying Options" button and then clicking on Add to Cart button
		else if (AllBuyingOptionsButton.isDisplayed()) {
			common.waitForElement(AllBuyingOptionsButton);
			AllBuyingOptionsButton.click();
			test.log(Status.INFO, "*** Clicking on See All Buying Options button in case of Add to Cart button is not dispalyed on the page. *** ");
			log.info(" *** Clicking on See All Buying Options button in case of Add to Cart button is not dispalyed on the page. ***");
			
			common.waitForElement(AddToCartSecondButton);
			AddToCartSecondButton.click();
			test.log(Status.INFO, " *** Clicking on Add to Cart button after clicking on See All buying options button. *** ");
			log.info(" *** Clicking on Add to Cart button after clicking on See All buying options button. *** ");

		} else {
			
			log.debug("Add to Cart Button is not displayed");
		}
	}

	//Verifying the confirmation after product is added to cart
	public boolean isProductAddedInCartConfirmationAppears() {

		common.waitForElement(AddedToCartConfirmationText);
		boolean isConfirmationTextAppears = AddedToCartConfirmationText
				.isDisplayed();
		
		test.log(Status.INFO, " *** Verifying if the confirmation text for added to cart is shown after adding the product to cart. ***");
		log.info(" *** Verifying if the confirmation text for added to cart is shown after adding the product to cart. *** ");
		return isConfirmationTextAppears;
	}

}
