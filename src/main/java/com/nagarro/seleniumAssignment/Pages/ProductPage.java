package com.nagarro.seleniumAssignment.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class ProductPage extends Base{
	
	public ProductPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = AmazonConstants.PRODUCT_TITLE)
	WebElement ProductTitle;
	
	CommonFunctions common = new CommonFunctions();
	
	//To switch the driver to new tab in which clicked product is opened
	public void switchToNewTab(){
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		log.info("No of windows or tabs after clicking: " + allWindows.size());
		 allWindows.remove(parentWindow);
		 Iterator<String> ite = allWindows.iterator();
		 driver.switchTo().window((String) ite.next());
		 log.info(" *** Switching in new tab of browser.*** ");
		 
	}
	public String getOpenedProductTitle(){
		
		//Explicit Wait to wait for element
        common.waitForElement(ProductTitle);
        
		test.log(Status.INFO, " *** getting the title of the clicked product on Product page *** ");
		log.info(" *** getting the title of the clicked product on Product page *** ");
        String openedProductTitle = ProductTitle.getText();
        return openedProductTitle;
        	
	}
}
