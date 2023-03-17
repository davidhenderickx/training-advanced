
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.DriverManager;
import pageObjects.AdminPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Exercise_ParametersInClass {

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
	
	@DataProvider(name="login")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "admin", "superduper" },
        };
	}

	@Test(dataProvider="login")
	public void loginWithCorrectUserNameAndPassword(String username, String password) {
		loginPage.loginWith(username, password);
		Assert.assertTrue(welcomePage.isWelcomeMessageShown(), "The welcome message is not shown");
	}
	
	

	
	

}
