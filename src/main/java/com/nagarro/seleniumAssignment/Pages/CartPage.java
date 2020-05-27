package com.nagarro.seleniumAssignment.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	//verify product in cart
	List<WebElement> products = CartProduct;
	  System.out.println("element.size : "+products.size());
	    for(WebElement ele:products)
	    {
	        System.out.println( "............"+ele.getText());
	        cartProductTitle.add(ele.getText());

	    }
	    System.out.println("List.size : "+cartProductTitle.toString());
		return cartProductTitle;

	}
}
