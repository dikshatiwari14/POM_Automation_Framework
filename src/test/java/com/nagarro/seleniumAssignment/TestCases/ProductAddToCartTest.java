package com.nagarro.seleniumAssignment.TestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Pages.AddToCartConfirmationPage;
import com.nagarro.seleniumAssignment.Pages.CartPage;
import com.nagarro.seleniumAssignment.Pages.HeaderPage;
import com.nagarro.seleniumAssignment.Pages.ProductPage;
import com.nagarro.seleniumAssignment.Pages.SearchResultsPage;
import com.nagarro.seleniumAssignment.Utilities.DataUtil;

public class ProductAddToCartTest extends Base {
	
	@Test(dataProvider = "getData", groups = { "Regression", "Sanity" })
	public void verifyProductSelection(Hashtable<String, String> data)
			throws Exception {

		HeaderPage headerPage = new HeaderPage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		ProductPage productPage = new ProductPage();

		try {
			// Selecting the category and entering the search keyword from Data excel
			headerPage.searchProduct(data.get("Product_Category"),
					data.get("Search_Text"));

			String ExpectedProductTitle = searchResultsPage
					.getClickedProductTitle();

			// Clicking on first product on search results page
			searchResultsPage.clickOnFirstProduct();

			searchResultsPage.switchToNewTab();
			String ActualProductTitle = productPage.getOpenedProductTitle();

			// Verifying if the same product is opened in new tab on the basis of title
			Assert.assertEquals(ActualProductTitle, ExpectedProductTitle,
					"Different product is opened in new tab");
		}

		catch (Exception e) {

			throw e;
		}
	}

	@Test(dependsOnMethods = { "verifyProductSelection" }, groups = { "Regression" })
	public void verifyProductAddedInCartConfirmationMessage() throws Exception {
		AddToCartConfirmationPage addToCartConfirmation = new AddToCartConfirmationPage();
		ProductPage productPage = new ProductPage();
		try {
			// Adding the product to cart
			productPage.addProductToCart();

			Boolean isConfirmationAppears = addToCartConfirmation
					.isProductAddedInCartConfirmationAppears();

			// verifying if confirmation message is appearing
			Assert.assertTrue(isConfirmationAppears,
					"AddedToCartConfirmationNotAppeared");
		}
		catch (Exception e) {
			throw e;
		}
	}

	@Test(dependsOnMethods = { "verifyProductAddedInCartConfirmationMessage" }, groups = { "Regression" })
	public void verifyTheProductInCart() throws Exception {

		HeaderPage headerPage = new HeaderPage();
		CartPage cartPage = new CartPage();
		try {
			// Navigating to cart page from main header
			headerPage.goToCartPage();

			// verifying if same product is displayed in cart
			Assert.assertTrue(
					cartPage.getDetailsOfProductInCart().contains(
							SearchResultsPage.firstProductTitle),
					"Incorrect product is displayed in cart");
		} catch (Exception e) {
			throw e;
		}
	}

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, "verifyProductSelection");
	}
}