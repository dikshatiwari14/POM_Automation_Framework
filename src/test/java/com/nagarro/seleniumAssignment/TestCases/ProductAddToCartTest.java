package com.nagarro.seleniumAssignment.TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Pages.AddToCartPage;
import com.nagarro.seleniumAssignment.Pages.CartPage;
import com.nagarro.seleniumAssignment.Pages.HeaderPage;
import com.nagarro.seleniumAssignment.Pages.ProductPage;
import com.nagarro.seleniumAssignment.Pages.SearchResultsPage;
import com.nagarro.seleniumAssignment.Utilities.DataUtil;
import com.nagarro.seleniumAssignment.Utilities.TestListener;

public class ProductAddToCartTest extends Base {
	
	@Test(dataProvider="getData", groups = {"Regression", "Sanity"})
	public void verifyProductSelection(Hashtable<String,String> data) throws Exception {
		
		HeaderPage headerPage = new HeaderPage(driver, TestListener.test);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver, TestListener.test);
		ProductPage productPage = new ProductPage(driver, TestListener.test);
		
		try{
		//Selecting the category and entering the search keyword from Data excel
		headerPage.searchProduct(data.get("Product_Category"),data.get("Search_Text"));
		
		String ExpectedProductTitle = searchResultsPage
				.getClickedProductTitle();
		
		//Clicking on first product on search results page
		searchResultsPage.clickOnFirstProduct();
		
		productPage.switchToNewTab();
		String ActualProductTitle = productPage.getOpenedProductTitle();
		
		//Verifying if the same product is opened in new tab on the basis of title
		Assert.assertEquals(ActualProductTitle, ExpectedProductTitle,
				"Different product is opened in new tab");
		}
		
		catch (Exception e){
			
			throw e;
		}
	}

	@Test(dependsOnMethods = { "verifyProductSelection" }, groups = {"Regression"})
	public void verifyProductAddedInCartConfirmationMessage() throws Exception{
		AddToCartPage addToCart = new AddToCartPage(driver, TestListener.test);
try{
		//Adding the product to cart
		addToCart.addProductToCart();
		
		Boolean isConfirmationAppears = addToCart
				.isProductAddedInCartConfirmationAppears();

		//verifying if confirmation message is appearing
		Assert.assertTrue(isConfirmationAppears,
				"AddedToCartConfirmationNotAppeared");
	}

	catch (Exception e){
		throw e;
	}
	}

	@Test(dependsOnMethods = { "verifyProductAddedInCartConfirmationMessage" }, groups = {"Regression"})
	public void verifyTheProductInCart() throws Exception {

		HeaderPage headerPage = new HeaderPage(driver, TestListener.test);
		CartPage cartPage = new CartPage(driver, TestListener.test);
try{
		// Navigating to cart page from main header
		headerPage.goToCartPage();
		
		//verifying if same product is displayed in cart
		Assert.assertTrue(
				cartPage.getDetailsOfProductInCart().contains(
						SearchResultsPage.firstProductTitle),
				"Incorrect product is displayed in cart");
}
	catch (Exception e){
		throw e;
	}
}
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, "verifyProductSelection");
	}
}