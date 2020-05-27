package com.nagarro.seleniumAssignment.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Common.CommonFunctions;
import com.nagarro.seleniumAssignment.Utilities.AmazonConstants;

public class ProductPage extends Base{

	public ProductPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = AmazonConstants.PRODUCT_TITLE)
	WebElement ProductTitle;
	
	CommonFunctions common = new CommonFunctions(driver);
	
	public void switchToNewTab(){
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("No of windows or tabs after clicking: " + allWindows.size());
		 allWindows.remove(parentWindow);
		 Iterator<String> ite = allWindows.iterator();
		 driver.switchTo().window((String) ite.next());
		 log.info("Switching in new tab of browser.");
		 
	}
	public String getOpenedProductTitle(){
		
		//Explicit Wait 
        common.waitForElement(ProductTitle);
        
        String openedProductTitle = ProductTitle.getText();
        return openedProductTitle;
        
	
	}
}
