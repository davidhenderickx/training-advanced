import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise03_LoggingIn {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhenderickx\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://satrngselcypr.z16.web.core.windows.net/#");
		
		WebElement btnLogout = driver.findElement(By.id("logout"));
		btnLogout.click();
		
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("superduper");
		
		waitFor();
		
		Select cbxLanguage = new Select(driver.findElement(By.name("language")));
		cbxLanguage.selectByVisibleText("French");
		
		waitFor();
		
		
		driver.findElement(By.tagName("label")).click();
		waitFor();
			
		driver.findElement(By.linkText("New")).click();
		WebElement fldTel = driver.findElement(By.id("telephone"));
		fldTel.click();
		driver.findElement(By.id("telephone")).sendKeys("0494/47.57.85");
		
		driver.quit();	
		
	}
	
	public static void waitFor() {
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
