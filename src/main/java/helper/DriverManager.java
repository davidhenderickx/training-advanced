package helper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class manages the setup and return of the driver
 * 
 * @author dhenderickx
 *
 */
public class DriverManager {
	
	private static WebDriver driver;
	
	/**
	 * Returns the current active webdriver
	 * If no driver exists, it creates a chromedriver
	 * @return
	 */
	public static WebDriver getDriver() {
		if(driver ==null) {
			setChromeDriver();
		}
		return driver;
	}
	
	/**
	 * Sets the current driver as a chromedriver.
	 * If there is already an active driver available, it will kill this driver
	 * and set a new chromedriver.
	 */
	public static void setChromeDriver() {
		killDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dhenderickx\\Downloads\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/**
	 * Sets the current driver as a firfoxdriver.
	 * If there is already an active driver available, it will kill this driver
	 * and set a new chromedriver.
	 */
	public static void setFirefoxDriver() {
		killDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dhenderickx\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	/**
	 * Quits the current active driver
	 */
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
