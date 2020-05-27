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

public class ProductAddToCartTest extends Base {

	@Test(dataProvider="getData", groups = {"Regression", "Sanity"})
	public void verifyProductSelection(Hashtable<String,String> data) {
		HeaderPage headerPage = new HeaderPage(driver);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		ProductPage productPage = new ProductPage(driver);
		headerPage.searchProduct(data.get("Product_Category"),data.get("Search_Text"));
		String ExpectedProductTitle = searchResultsPage
				.getClickedProductTitle();
		searchResultsPage.clickOnFirstProduct();
		productPage.switchToNewTab();
		String ActualProductTitle = productPage.getOpenedProductTitle();

		Assert.assertEquals(ActualProductTitle, ExpectedProductTitle,
				"Different product is opened in new tab");

	}

	@Test(dependsOnMethods = { "verifyProductSelection" }, groups = {"Regression"})
	public void verifyProductAddedInCartConfirmationMessage() {
		AddToCartPage addToCart = new AddToCartPage(driver);

		addToCart.addProductToCart();
		Boolean isConfirmationAppears = addToCart
				.isProductAddedInCartConfirmationAppears();

		Assert.assertTrue(isConfirmationAppears,
				"AddedToCartConfirmationNotAppeared");

		String confirmationMassage = addToCart.getConfirmationMessage();
		Assert.assertEquals(confirmationMassage, "Added to Cart",
				"Incorrect Confirmation Text is displayed");
	}

	@Test(dependsOnMethods = { "verifyProductAddedInCartConfirmationMessage" }, groups = {"Regression"})
	public void verifyTheProductInCart() {

		HeaderPage headerPage = new HeaderPage(driver);
		CartPage cartPage = new CartPage(driver);

		headerPage.goToCartPage();
		Assert.assertTrue(
				cartPage.getDetailsOfProductInCart().contains(
						SearchResultsPage.firstProductTitle),
				"Incorrect product is displayed in cart");

	}
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, "verifyProductSelection");
	}
}