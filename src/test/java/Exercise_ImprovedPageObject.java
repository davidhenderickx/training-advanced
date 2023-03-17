
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import helper.DriverManager;
import pageObjects.AdminPage;
import pageObjects.LoginPage;
import pageObjects.LoginPage_Improved;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Exercise_ImprovedPageObject {

	private static MenuPage menu = new MenuPage();
	private static LoginPage_Improved loginPage = new LoginPage_Improved();
	private static WelcomePage welcomePage = new WelcomePage();
	private static AdminPage adminPage = new AdminPage();

	@BeforeSuite 
	public static void setup() {
		//Does not contain the loginpage
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), welcomePage);
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@AfterSuite
	public static void teardown() {
		DriverManager.killDriver();
	}
	
	@BeforeMethod
	public void beforeTheTest() {
		menu.logout();
	}

	@Test
	public void loginWithCorrectUserNameAndPassword() {
		loginPage.setLanguageTo("French").loginWith("admin", "superduper").getWelcomeMessage();
		Assert.assertTrue(welcomePage.isWelcomeMessageShown(), "The welcome message is not shown");
	}



}
