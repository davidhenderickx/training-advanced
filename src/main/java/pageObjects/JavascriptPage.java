package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helper.DriverManager;

/**
 * Contains all the calls for javascript functions in the application
 * 
 * @author dhenderickx
 *
 */
public class JavascriptPage {
	
	public JavascriptPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public JavascriptPage resetAddressBook() {
		JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("resetAddressBook(false);");
		return this;
	}
	
	public JavascriptPage populateForTesting() {
		JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
		executor.executeScript("populateForTesting(false);");
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
		return this;
	}

	

}
