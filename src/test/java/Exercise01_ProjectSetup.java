import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise01_ProjectSetup {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhenderickx\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		
		
		driver.get("https://www.google.be");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		System.out.println(driver.getTitle());
		
		System.out.println("The title is: " + driver.getTitle());
		
		
		

	}

}
