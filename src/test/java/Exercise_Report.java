
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
import reporting.ExtentReportManager;

public class Exercise_Report extends AbstractTest {

	
	@BeforeSuite
	public static void setupTest(){
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeMethod
	public void logout(){
		menuPage.logout();	
		
	}

	@Test
	public void loginWithCorrectUserNameAndPassword() {
		ExtentReportManager.logStep("Logging in with correct user and password");
		loginPage.loginWith("admin", "superduper");
		Assert.assertTrue(welcomePage.isWelcomeMessageShown(), "The welcome message is not shown");
	}

	@Test
	public void loginWithIncorrectPassword() {
		ExtentReportManager.logStep("Logging in with incorrect password");
		loginPage.loginWith("admin", "wrong");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Unable to log in with the given credentials. Please try again."), "The incorrect error message is displayed");
	}

	@Test
	public void loginWithIncorrectUserName() {
		ExtentReportManager.logStep("Logging in with incorrect user");
		loginPage.loginWith("wrong", "superduper");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Unable to log in with the given credentials. Please try again."), "The incorrect error message is displayed");
	}

	@Test
	public void loginWithEmptyUserNameAndPassword() {
		ExtentReportManager.logStep("Logging in with empty credentials");
		loginPage.loginWith("", "");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Please fill in all the fields."), "The incorrect error message is displayed");
	}
	
	@Test
	public void failingTest() {
		ExtentReportManager.logStep("This test will fail");
		loginPage.loginWith("", "");
		Assert.assertTrue(loginPage.isErrorShown(), "The error message is not shown");
		Assert.assertTrue(loginPage.getErrorMessage().equals("Please fill in a the fields."), "The incorrect error message is displayed");
	}

}
