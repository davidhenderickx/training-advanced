import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Oefening4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhenderickx\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://satrngselcypr.z16.web.core.windows.net/#");
		
		WebElement btnLogout = driver.findElement(By.xpath("//a[@id='logout']"));
		btnLogout.click();
		
		
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("#password")).sendKeys("superduper");
		
		
		driver.findElement(By.className("content")).click();
		
		driver.quit();	
		
	}
	
	

}
