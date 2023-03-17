import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Exercise06_DriverManager {

	public static void main(String[] args) {
		
		DriverManager.setFirefoxDriver();
		DriverManager.setChromeDriver();
		
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/#");
		
		MenuPage menu = new MenuPage();
		LoginPage loginPage = new LoginPage();
		WelcomePage welcomePage = new WelcomePage();
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), loginPage);
		PageFactory.initElements(DriverManager.getDriver(), welcomePage);
		
		
		menu.logout();
		loginPage.setLanguageTo("French");
		loginPage.loginWith("admin", "superduper");
		
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
		
		DriverManager.killDriver();
		

	}

}
