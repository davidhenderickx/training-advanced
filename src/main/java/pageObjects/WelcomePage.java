package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	
	@FindBy(how = How.ID, using ="welcome")
	private WebElement txtWelcome;
	
	@FindBy(xpath = "//input[@onclick='showBear()']")
	private WebElement btnShowBear;
	
	@FindBy(id = "bear")
	private WebElement imgBear;
	
	
	
	public String getWelcomeMessage() {
		System.out.println("Getting the welcome message");
		return txtWelcome.getText();
	}
	
	public boolean isWelcomeMessageShown() {
		System.out.println("Returning if Welcome Message is shown");
		return txtWelcome.isDisplayed();
	}
	
	public void showBear() {
		System.out.println("Opening the bear image");
		btnShowBear.click();
	}
	
	public WebElement getBearImage() {
		return imgBear;
	}

}
