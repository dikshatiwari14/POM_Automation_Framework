package com.nagarro.seleniumAssignment.Common;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nagarro.seleniumAssignment.Base.Base;

public class CommonFunctions extends Base {

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean isElementPresent(List<WebElement> elements) {
		List<WebElement> elementList = elements;
		if (elementList.size() != 0) {
			// If list size is non-zero, element is present
			System.out.println("Element present");
			return true;
		} else {
			// Else if size is 0, then element is not present
			System.out.println("Element not present");
			return false;
		}
	}

	public boolean isElementPresent(WebElement element, String text) {
		if (element.getText() == text) {
			return true;
		} else {
			return false;
		}
	}

	public void selectDropdown(WebElement element, String text) {

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}

}