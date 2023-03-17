package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;

public class LoginPage_Improved {

	@FindBy(id ="username")
	private WebElement fldUsername;
	
	@FindBy(id ="password")
	private WebElement fldPassword;
	
	@FindBy(className = "content")
	private WebElement btnLogin;
	
	@FindBy(name = "language")
	private WebElement cbxLanguage;
	
	@FindBy(id ="errors")
	private WebElement txtError;
	
	public LoginPage_Improved() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public Boolean isLoginPageShown() {
		try{
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}
	
	public WelcomePage loginWith (String username, String password) {
	    System.out.println("Logging in with: " + username + "/" + password);
	    fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		btnLogin.click();
		return new WelcomePage();
	}
	
	public WelcomePage loginWithAdmin () {
		loginWith("admin", "superduper");
		return new WelcomePage();
	}
	
	public LoginPage_Improved setLanguageTo (String language) {
		System.out.println("Setting the language to: " + language);
		Select selLanguage = new Select(cbxLanguage);
		selLanguage.selectByVisibleText(language);
		return this;
	}
	
	public boolean isErrorShown() {
		return txtError.isDisplayed();
	}
	
	public String getErrorMessage() {
		return txtError.getText();
	}
	
	
}
