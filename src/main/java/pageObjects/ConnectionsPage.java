package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import helper.DriverManager;

public class ConnectionsPage {
	
	@FindBy(how = How.ID, using = "searchBy")
	private WebElement selectSearchFor;

	@FindBy(how = How.ID, using = "searchTerm")
	private WebElement txtSearchFor;
	
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
}
