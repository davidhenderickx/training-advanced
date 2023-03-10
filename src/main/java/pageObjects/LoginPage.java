package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	@FindBy(how = How.ID, using ="username")
	private WebElement fldUsername;
	
	@FindBy(how = How.ID, using ="password")
	private WebElement fldPassword;
	
	@FindBy(how = How.CLASS_NAME, using ="content")
	private WebElement btnLogin;
	
	@FindBy(how = How.NAME, using ="language")
	private WebElement cbxLanguage;
	
	@FindBy(how = How.ID, using ="errors")
	private WebElement txtError;
	
	
	
	
	public void loginWith (String username, String password) {
	    System.out.println("Logging in with: " + username + "/" + password);
	    fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void loginWithAdmin () {
		loginWith("admin", "superduper");
	}
	
	public void setLanguageTo (String language) {
		System.out.println("Setting the language to: " + language);
		Select selLanguage = new Select(cbxLanguage);
		selLanguage.selectByVisibleText(language);
	}
	
	public boolean isErrorShown() {
		return txtError.isDisplayed();
	}
	
	public String getErrorMessage() {
		return txtError.getText();
	}
	
	
}
