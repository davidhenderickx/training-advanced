import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholders.Connection;

public class Exercise_ImageValidation extends AbstractTest {
	
	@BeforeSuite
	public static void setupTest(){
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeMethod
	public void logout(){
		menuPage.logout();	
		
	}
	
	
	@Test
	public void bearImageShown(){
		loginPage.loginWith("admin", "superduper");
		
		welcomePage.showBear();
		
		WebElement imgBear = welcomePage.getBearImage();
		
		Assert.assertTrue(imgBear.isDisplayed(), "There is no bear image shown");
		
		int w = imgBear.getRect().getWidth();
		int h = imgBear.getRect().getHeight();
		Assert.assertTrue(w > 0 && h>0, "There is no bear image shown");
		
	
		
		
	}

}
