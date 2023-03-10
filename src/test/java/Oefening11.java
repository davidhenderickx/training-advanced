
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import helper.DriverManager;
import pageObjects.AdminPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Oefening11 {

	private static MenuPage menu = new MenuPage();
	private static LoginPage loginPage = new LoginPage();
	private static WelcomePage welcomePage = new WelcomePage();
	private static AdminPage adminPage = new AdminPage();

	@BeforeSuite 
	public static void setup() {
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), loginPage);
		PageFactory.initElements(DriverManager.getDriver(), welcomePage);
		PageFactory.initElements(DriverManager.getDriver(), adminPage);
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/#");
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
		loginPage.loginWith("admin", "superduper");
		Assert.assertTrue(welcomePage.isWelcomeMessageShown(), "The welcome message is not shown");
	}

	@Test
	public void loginWithIncorrectPassword() {
		loginPage.loginWith("admin", "wrong");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Unable to log in with the given credentials. Please try again."), "The incorrect error message is displayed");
	}

	@Test
	public void loginWithIncorrectUserName() {
		loginPage.loginWith("wrong", "superduper");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Unable to log in with the given credentials. Please try again."), "The incorrect error message is displayed");
	}

	@Test
	public void loginWithEmptyUserNameAndPassword() {
		loginPage.loginWith("", "");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Please fill in all the fields."), "The incorrect error message is displayed");
	}

}
