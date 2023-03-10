package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;

/**
 * This page object contain all the functionality regarding the administration page
 * @author dhenderickx
 *
 */
public class AdminPage {
	
	@FindBy(how = How.XPATH, using ="//td[@onclick='resetUsers(true)']/label")
	private WebElement btnResetUsers;
	
	@FindBy(how = How.ID, using ="new_username")
	private WebElement fldNewUsername;
	
	@FindBy(how = How.ID, using ="new_password")
	private WebElement fldNewPassword;
	
	@FindBy(how = How.XPATH, using ="//td[@onclick='createUser()']/span")
	private WebElement btnCreateUser;
	
	
	/**
	 * Waits until the page is shown
	 */
	public void waitUntilShown() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnResetUsers));
	}
	
	/**
	 * Resets the users in the database
	 */
	public void resetUsers() {
		System.out.println("Resetting the users");
		btnResetUsers.click();
		Alert popup = DriverManager.getDriver().switchTo().alert();
		popup.accept();
	}
	
	/**
	 * Creates a new user in the data
	 * @param username the name of the user
	 * @param password the password of the user
	 */
	public void createNewUser(String username, String password) {
		System.out.println("Creating a new user: " + username + "/" + password);
		fldNewUsername.sendKeys(username);
		fldNewPassword.sendKeys(password);
		btnCreateUser.click();
	}
	

}
