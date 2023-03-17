import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholders.Connection;
import helper.DriverManager;

public class Exercise_DataHolderWithCustomControl extends AbstractTest {	
	
	@BeforeSuite
	public static void setupTest(){
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeMethod
	public void startOfTest(){
		menuPage.logout();	
		loginPage.loginWith("admin", "superduper");
		menuPage.clickNew();
	}
	
	@AfterMethod
	public void cleanup(){
		String whMain = DriverManager.getDriver().getWindowHandle();
		menuPage.admin();
		String whAdmin = null;
		for (String wh : DriverManager.getDriver().getWindowHandles()) {
			if (!wh.equals(whMain)) {
				whAdmin = wh;
			}
		}
		DriverManager.getDriver().switchTo().window(whAdmin);
		adminPage.resetConnections();
		
		// Close the tab/window
		DriverManager.getDriver().close();
		DriverManager.getDriver().switchTo().window(whMain);
	}
	
	@Test
	public void validCreation(){
		Connection c = new Connection("David","Henderickx","M","CTG","Testing","Experienced",
				"david.henderickx@ctg.com","1234567890","Selenium");
		
		newConnectionPage.createConnection(c);
		menuPage.connections();
		Assert.assertTrue(connectionsPage.hasResultWithName("David", "Henderickx"), "The connection manager has no result for David Henderickx");
	}
	
	/**
	 * This is just one example of an invalid test. It can serve
	 * as a template for other similar tests (e.g. testing for missing values 
	 * by leaving some parameters blank) by altering the Connection object.
	 */
	@Test
	public void invalidCreation_BadTelephoneNumber(){
		Connection c = new Connection("David","Henderickx","M","","Testing","Experienced",
				"david.henderickx@ctg.com","1234567890","Selenium");
		
		newConnectionPage.createConnection(c);
		menuPage.connections();
		
		Assert.assertTrue(!connectionsPage.hasResultWithName("David", "Henderickx"), "The connection manager has a result for David Henderickx");		
	}
}
