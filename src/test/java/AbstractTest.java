import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import helper.DriverManager;
import pageObjects.AdminPage;
import pageObjects.ConnectionsPage;
import pageObjects.JavascriptPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.NewConnectionPage;
import pageObjects.StatsPage;
import pageObjects.WelcomePage;

public abstract class AbstractTest {
	protected static WebDriver driver;
	
	protected static AdminPage adminPage;
	protected static ConnectionsPage connectionsPage;
	protected static JavascriptPage javascriptPage;
	protected static MenuPage menuPage;
	protected static NewConnectionPage newConnectionPage;
	protected static LoginPage loginPage;
	protected static StatsPage statsPage;
	protected static WelcomePage welcomePage;
	
	
	@BeforeSuite
	public static void beforeAllTests(){
		driver = DriverManager.getDriver();
		
		menuPage = new MenuPage();
		PageFactory.initElements(driver, menuPage);
		
		loginPage = new LoginPage();
		PageFactory.initElements(driver, loginPage);
		
		welcomePage = new WelcomePage();
		PageFactory.initElements(driver, welcomePage);
		
		connectionsPage = new ConnectionsPage();
		PageFactory.initElements(driver, connectionsPage);
		
		adminPage = new AdminPage();
		PageFactory.initElements(driver, adminPage);
		
		newConnectionPage = new NewConnectionPage();
		PageFactory.initElements(driver, newConnectionPage);
		
		statsPage = new StatsPage();
		PageFactory.initElements(driver, statsPage);
		
		javascriptPage = new JavascriptPage();
	}
	
	@AfterSuite
	public static void afterAllTests(){
		DriverManager.killDriver();
	}
}