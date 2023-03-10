package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper.DriverManager;

/**
 * This page object contain all the functionality regarding the upper menu
 * @author dhenderickx
 *
 */
public class MenuPage {
	
	@FindBy(how = How.ID, using ="logout")
	private WebElement btnLogout;
	
	@FindBy(how = How.ID, using ="crudConnection")
	private WebElement btnNew;
	
	@FindBy(how = How.LINK_TEXT, using ="Admin")
	private WebElement btnAdmin;
	
	@FindBy(how = How.LINK_TEXT, using ="NOTEXISTING")
	private WebElement btnNotExisting;

	
	/**
	 * Clicks on the logout button
	 */
	public void logout() {
		System.out.println("Op de logout button klikken");
		btnLogout.click();
	}
	
	/**
	 * Clicks on the new button
	 */
	public void clickNew() {
		System.out.println("Op de new button klikken");
		btnNew.click();
	}
	
	/**
	 * Clicks on the admin button
	 */
	public void admin() {
		System.out.println("click on Admin button");
		btnAdmin.click();
	}
	
	/**
	 * Clicks on a menu item that doesn't exist
	 */
	public void clickOnMenuItemThatDoesntExist() {
		System.out.println("click on a menu item that doesn't exist");
		btnNotExisting.click();
	}
	

}
