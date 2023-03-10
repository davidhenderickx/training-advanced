package helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EDriverManager {
	
	private static EventFiringWebDriver edriver;
	
	public static WebDriver getDriver() {
		if(edriver ==null) {
			setChromeDriver();
		}
		return edriver;
	}
	
	public static void setChromeDriver() {
		killDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhenderickx\\Downloads\\chromedriver_win32\\chromedriver.exe");
		edriver = new EventFiringWebDriver(new ChromeDriver());
		edriver.register(new TrainingListener());
		edriver.manage().window().maximize();
	}
	
	public static void setFirefoxDriver() {
		killDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		edriver = new EventFiringWebDriver(new FirefoxDriver());
		edriver.register(new TrainingListener());
	}
	
	public static void killDriver() {
		if(edriver != null) {
			edriver.quit();
			edriver = null;
		}
	}

}
