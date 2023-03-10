
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.DriverManager;
import pageObjects.AdminPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.WelcomePage;

public class Oefening8 {

	public static void main(String[] args) {
		
		DriverManager.setFirefoxDriver();
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/#");
		
		MenuPage menu = new MenuPage();
		LoginPage loginPage = new LoginPage();
		WelcomePage welcomePage = new WelcomePage();
		AdminPage adminPage = new AdminPage();
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), loginPage);
		PageFactory.initElements(DriverManager.getDriver(), welcomePage);
		PageFactory.initElements(DriverManager.getDriver(), adminPage);
		
		
		menu.logout();
		loginPage.setLanguageTo("French");
		loginPage.loginWith("admin", "superduper");
		menu.admin();
		
		String orgWindowHandle = DriverManager.getDriver().getWindowHandle();
		System.out.println("Original window: " + orgWindowHandle);
		Set<String> allWindowHandles = DriverManager.getDriver().getWindowHandles();
		System.out.println("AllWindows: " + allWindowHandles.toString());
		String newWindowHandle = null;
		for(String windowHandle : allWindowHandles) {
			if(!windowHandle.equals(orgWindowHandle)) {
				newWindowHandle = windowHandle;
				break;
			}
		}
		System.out.println("Switching to new Window: " + newWindowHandle);
		DriverManager.getDriver().switchTo().window(newWindowHandle);
		
		//Needed for Firefox
		//try {
		//	Thread.sleep(1000);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
		
		adminPage.waitUntilShown();
		
		System.out.println("PageSource: " + DriverManager.getDriver().getPageSource());
		
		adminPage.resetUsers();
		String newUsername = "david";
		String newPassword = "testing";
				
		adminPage.createNewUser(newUsername, newPassword);

		DriverManager.getDriver().close();
		DriverManager.getDriver().switchTo().window(orgWindowHandle);
		
		menu.logout();
		loginPage.loginWith(newUsername, newPassword);
		
		if (welcomePage.isWelcomeMessageShown()) {
			System.out.println("PASSED: The welcome message is shown");
		} else {
			System.out.println("FAILED: The welcome message is not shown");
		}
		
		DriverManager.killDriver();

	}

}
