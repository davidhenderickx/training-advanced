package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;

/**
 * This page object contain all the functionality regarding the new connection screen
 * @author dhenderickx
 *
 */
public class NewConnectionPage {
	
	@FindBy(how = How.ID, using ="firstName")
	private WebElement fldFirstName;
	
	@FindBy(how = How.ID, using ="lastName")
	private WebElement fldLastName;
	
	@FindBy(how = How.ID, using ="sex")
	private WebElement cbxSex;
	
	@FindBy(how = How.ID, using ="email")
	private WebElement fldEmail;
	
	@FindBy(how = How.ID, using ="telephone")
	private WebElement fldTelephone;
	
	@FindBy(how = How.ID, using ="lastName")
	private WebElement fldCompany;
	
	@FindBy(how = How.ID, using ="SSU")
	private WebElement cbxSSU;
	
	@FindBy(how = How.ID, using ="seniority")
	private WebElement cbxSeniority;
	
	@FindBy(how = How.ID, using ="interests")
	private WebElement fldAdditionalInfo;
	
	@FindBy(how = How.XPATH, using ="//td[@id='add']//label")
	private WebElement btnAdd;
		
	
	/**
	 * Waits until the page is shown
	 */
	public void waitUntilShown() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnAdd));
	}
	
	/**
	 * Create a new connection
	 */
	public void createNewConnection(String firstName, String lastName, String sex, String email, String telephone, String company, String ssu, String seniority, String additionalInfo) {
		System.out.println("Creating a new connection");
		
		fldFirstName.clear();
		fldFirstName.sendKeys(firstName);
		
		fldLastName.clear();
		fldLastName.sendKeys(lastName);
		
		Select selSex = new Select(cbxSex);
		selSex.selectByVisibleText(sex);
		
		fldEmail.clear();
		fldEmail.sendKeys(email);
		
		fldTelephone.click();
		fldTelephone.clear();
		fldTelephone.sendKeys(telephone);
		
		fldCompany.clear();
		fldCompany.sendKeys(company);
		
		Select selSSU = new Select(cbxSSU);
		selSSU.selectByVisibleText(ssu);
		
		Select selSeniority = new Select(cbxSeniority);
		selSeniority.selectByVisibleText(seniority);
		
		fldAdditionalInfo.clear();
		fldAdditionalInfo.sendKeys(additionalInfo);
		
		btnAdd.click();
		
	}

}
