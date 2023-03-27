import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholders.Connection;

public class Exercise_ExpectedConditions extends AbstractTest {
	
	@BeforeSuite
	public static void setupTest(){
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeMethod
	public void logout(){
		menuPage.logout();	
		
	}
	
	
	@Test
	public void expectedConditionTest(){
		
		loginPage.loginWith("admin", "superduper");
		menuPage.clickNew();
		Connection c = new Connection("David","Henderickx","M","CTG","Testing","Experienced",
				"david.henderickx@ctg.com","1234567890","Selenium");
		newConnectionPage.createConnection(c);
		
		menuPage.connections();
		
		connectionsPage.filterOnLastName("Henderickx");
		Assert.assertTrue(connectionsPage.WaitForResultIsDisplayed(), "Result is not displayed within the timeout");

		
		
		
		
	}

}
