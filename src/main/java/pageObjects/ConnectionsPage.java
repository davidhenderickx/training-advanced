package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import expectedConditions.ChildAvailable;
import helper.DriverManager;

public class ConnectionsPage {
	
	@FindBy(how = How.ID, using = "searchBy")
	private WebElement selectSearchFor;

	@FindBy(how = How.ID, using = "searchTerm")
	private WebElement txtSearchFor;
	
	@FindBy(how = How.ID, using = "myrecords")
	private WebElement divMyConnections;
	
	public void filterOnLastName(String term) {
		new Select(selectSearchFor).selectByVisibleText("last name");
		txtSearchFor.clear();
		txtSearchFor.sendKeys(term);
	}

	public boolean hasResultWithName(String firstName, String lastName){
		return getResultWithName(firstName, lastName) != null;	
	}

	private WebElement getResultWithName(String firstName, String lastName){
		filterOnLastName(lastName);	
		
		for(WebElement r : DriverManager.getDriver().findElements(By.xpath("//tr[@draggable='true']"))){
			String text = r.findElement(By.className("name")).getText();
			if(text.contains(firstName) && text.contains(lastName)){
				return r;
			}
		}
		
		return null;	
	}
	
	public Boolean WaitForResultIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		return wait.until(new ChildAvailable(divMyConnections, By.id("records")));
	}
	
	
}
