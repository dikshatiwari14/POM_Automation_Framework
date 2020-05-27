package com.nagarro.seleniumAssignment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class AddToCartPage extends Base {
	
	public AddToCartPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = AmazonConstants.ADD_TO_CART_MAIN)
	WebElement AddToCartButton;
	
	@FindBy(xpath = AmazonConstants.CONFIRMATION_TEXT)
	WebElement AddedToCartConfirmationText;
	
	@FindBy(xpath = AmazonConstants.All_BUYING_OPTION_BUTTON)
	WebElement AllBuyingOptionsButton;
	
	@FindBy(xpath = AmazonConstants.ADD_TO_CART_SECOND)
	WebElement AddToCartSecondButton;
	
	
	CommonFunctions common = new CommonFunctions(driver);
	
	public void addProductToCart(){
		
		if(AddToCartButton.isDisplayed()){
        common.waitForElement(AddToCartButton);
        AddToCartButton.click();
        log.info("Clicking on Add to Cart button.");
	}
		else if(AllBuyingOptionsButton.isDisplayed()){
			 common.waitForElement(AllBuyingOptionsButton);
			 AllBuyingOptionsButton.click();
			 log.info("Clicking on See All Buying Options button in case of Add to Cart button is not dispalyed on the page.");
			 
			 common.waitForElement(AddToCartSecondButton);
			 AddToCartSecondButton.click();
			 log.info("Clicking on Add to Cart button after clicking on See All buying options button.");
			 
			}
		else {
			
			System.out.println("Button is not displayed");
		}
		}
	
	public boolean isProductAddedInCartConfirmationAppears(){
		
		common.waitForElement(AddedToCartConfirmationText);
		boolean isConfirmationTextAppears = AddedToCartConfirmationText.isDisplayed();
		log.info("Verifying if the confirmation text for added to cart is shown after adding the product to cart.");
		return isConfirmationTextAppears;
	}

	public String getConfirmationMessage(){
		String confirmationMessage = AddedToCartConfirmationText.getText();
		log.info("Getting confirmation message text.");
		return confirmationMessage;
		
	}
}
