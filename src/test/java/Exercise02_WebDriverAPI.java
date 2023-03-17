import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise02_WebDriverAPI {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhenderickx\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.be");
		String orgTitle = driver.getTitle();
		System.out.println("I'm on " + orgTitle);
		
		driver.get("https://www.bing.com/");
		System.out.println("I'm on " + driver.getTitle());
		
		driver.navigate().back();
		if(orgTitle.equals(driver.getTitle())) {
			System.out.println("PASSED: I'm back at Google");
		} else {
			System.out.println("FAILED: I'm not back at Google");
		}
		
		driver.navigate().refresh();
		if(orgTitle.equals(driver.getTitle())) {
			System.out.println("PASSED: I refreshed to Google");
		} else {
			System.out.println("FAILED: I did not refresh to Google");
		}
		
		driver.quit();

	}
}
