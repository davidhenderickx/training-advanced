import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholders.Connection;
import helper.DriverManager;

public class Exercise_CustomControl extends AbstractTest {	
	
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
		menuPage.clickNew();
		Connection c = new Connection("David","Henderickx","M","CTG","Testing","Experienced",
				"david.henderickx@ctg.com","1234567890","Selenium");
		
		newConnectionPage.createConnection(c);
		menuPage.stats();
		Assert.assertTrue(statsPage.getRowsInStatsTable() == 11, "The stats table hasn't got 11 rows, but " + statsPage.getRowsInStatsTable() + " rows");
		Assert.assertTrue(statsPage.getConnectionStatisticsTable().getText(0, 2).equals("1"), "The data in the stats table is incorrect");
	
	}
	
}
