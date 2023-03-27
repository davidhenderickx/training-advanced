import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholders.Connection;

public class Exercise_Javascript extends AbstractTest {
	
	@BeforeSuite
	public static void setupTest(){
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	@BeforeMethod
	public void logout(){
		menuPage.logout();	
		
	}
	
	
	@Test
	public void validCreation(){
		loginPage.loginWith("admin", "superduper");
		
		javascriptPage.resetAddressBook();
		menuPage.stats();
		Assert.assertTrue(!statsPage.hasConnections(), "There are still connections available");
		
		javascriptPage.populateForTesting();
		
		menuPage.connections();
		Assert.assertTrue(connectionsPage.hasResultWithName("Peter", "Parker"), "There is no Peter Parker as a record");
		
		menuPage.stats();
		String men = statsPage.getConnectionStatisticsTable().getText(1, 2);
		String women = statsPage.getConnectionStatisticsTable().getText(2, 2);
		Assert.assertTrue(men.equals("13"), "There are not 13 men, but " + men);
		Assert.assertTrue(women.equals("3"), "There are not 3 women, but " + women);
		
		
		
	}

}
