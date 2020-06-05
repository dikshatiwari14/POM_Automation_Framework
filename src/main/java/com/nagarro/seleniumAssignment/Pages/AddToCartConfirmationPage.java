package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class AddToCartConfirmationPage extends Base {

	public AddToCartConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = AmazonConstants.CONFIRMATION_TEXT)
	WebElement AddedToCartConfirmationText;

	CommonFunctions common = new CommonFunctions();

	// Verifying the confirmation after product is added to cart
	public boolean isProductAddedInCartConfirmationAppears() {

		common.waitForElement(AddedToCartConfirmationText);
		boolean isConfirmationTextAppears = AddedToCartConfirmationText
				.isDisplayed();

		test.log(Status.INFO,
				" Verify if the confirmation text for added to cart is shown ");
		log.info(" *** Verify if the confirmation text for added to cart is shown *** ");
		return isConfirmationTextAppears;
	}
	
	// To get the confirmation message test
	public String getConfirmationMessage(){
		String confirmationMessage = AddedToCartConfirmationText.getText();
		test.log(Status.INFO, " Captured confirmation message test ");
		log.info(" *** Captured confirmation message text *** ");
		return confirmationMessage;
		
	}

}
