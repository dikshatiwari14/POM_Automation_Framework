package com.nagarro.seleniumAssignment.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class CartPage extends Base {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = AmazonConstants.Cart_ProductLink)
	List<WebElement> CartProduct;

	public List<String> getDetailsOfProductInCart() {
		List<String> cartProductTitle = new ArrayList<String>();

		log.info(" *** Total Products in Cart are : " + CartProduct.size()
				+ "*** ");
		test.log(Status.INFO,
				"Total Products in Cart are : " + CartProduct.size());

		// To verify if same product is displayed in the cart
		for (WebElement product : CartProduct) {
			log.info(" *** Product title---" + product.getText() + "***");
			cartProductTitle.add(product.getText());
		}
		log.info(" *** List.size : " + cartProductTitle.toString() + "*** ");
		return cartProductTitle;

	}
}
