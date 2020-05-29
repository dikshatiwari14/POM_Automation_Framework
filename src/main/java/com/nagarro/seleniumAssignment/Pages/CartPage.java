package com.nagarro.seleniumAssignment.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class CartPage extends Base {

	public CartPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = AmazonConstants.Cart_ProductLink)
	List <WebElement> CartProduct;
	
	public List<String> getDetailsOfProductInCart(){
	List<String> cartProductTitle = new ArrayList<String>();
	
	//getting the title of product in cart to verify if product is same product is displayed in the cart
	List<WebElement> products = CartProduct;
	  log.info("Total Products in Cart are : " + products.size());
	  test.log(Status.INFO, "Total Products in Cart are : " + products.size());
	    for(WebElement ele:products)
	    {
	        log.info( "Product title---"+ele.getText());
	        cartProductTitle.add(ele.getText());

	    }
	    log.info("List.size : "+cartProductTitle.toString());
		return cartProductTitle;

	}
}
