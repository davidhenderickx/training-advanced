package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	
	@FindBy(how = How.ID, using ="welcome")
	private WebElement txtWelcome;
	
	
	public String getWelcomeMessage() {
		System.out.println("Getting the welcome message");
		return txtWelcome.getText();
	}
	
	public boolean isWelcomeMessageShown() {
		System.out.println("Returning if Welcome Message is shown");
		return txtWelcome.isDisplayed();
	}

}
