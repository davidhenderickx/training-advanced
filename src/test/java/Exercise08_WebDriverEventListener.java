import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import helper.DriverManager;
import helper.EDriverManager;
import helper.TrainingListener;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Exercise08_WebDriverEventListener {

	public static void main(String[] args) {
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(DriverManager.getDriver());
		eDriver.register(new TrainingListener());
		
		eDriver.get("https://satrngselcypr.z16.web.core.windows.net/#");
		
		MenuPage menu = new MenuPage();
		LoginPage loginPage = new LoginPage();
		WelcomePage welcomePage = new WelcomePage();
		PageFactory.initElements(eDriver, menu);
		PageFactory.initElements(eDriver, loginPage);
		PageFactory.initElements(eDriver, welcomePage);
		
		
		menu.logout();
		loginPage.setLanguageTo("French");
		loginPage.loginWith("admin", "superduper");
		
		menu.clickOnMenuItemThatDoesntExist();
		
		if (welcomePage.isWelcomeMessageShown()) {
			System.out.println("PASSED: The welcome message is shown");
		} else {
			System.out.println("FAILED: The welcome message is not shown");
		}
		
		if (welcomePage.getWelcomeMessage().contains("Welcome")) {
			System.out.println("PASSED: The welcome message is correct");
		} else {
			System.out.println("FAILED: The welcome message is not correct");
		}
		
		
		

	}

}
