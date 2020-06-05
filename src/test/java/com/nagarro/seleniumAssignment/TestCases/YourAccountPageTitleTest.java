package com.nagarro.seleniumAssignment.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.seleniumAssignment.Base.Base;
import com.nagarro.seleniumAssignment.Pages.HeaderPage;

public class YourAccountPageTitleTest extends Base{
	
	@Test(groups = {"Regression", "Sanity"})
	public void verifyYourAccountsPageTitle() throws Exception{
		try{
		HeaderPage header = new HeaderPage();
		header.goToYourAccount();
		String PageTitle = driver.getTitle();
		//Applying assertion to fail this test case
		Assert.assertTrue(
				PageTitle.contains(
						"Profile"),
				"Title is different");
		
	}
		catch(Exception e){
			throw e;
			}
		}

}
