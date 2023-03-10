import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Oefening5 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhenderickx\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://satrngselcypr.z16.web.core.windows.net/#");
		
		MenuPage menu = new MenuPage();
		LoginPage loginPage = new LoginPage();
		WelcomePage welcomePage = new WelcomePage();
		PageFactory.initElements(driver, menu);
		PageFactory.initElements(driver, loginPage);
		PageFactory.initElements(driver, welcomePage);
		
		
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
		

	}

}
