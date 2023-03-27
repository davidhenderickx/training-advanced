package expectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ChildAvailable implements ExpectedCondition<Boolean> {

	WebElement element;
	By by;
	
	public ChildAvailable(WebElement element, By by) {
		this.element = element;
		this.by = by;
	}
	
	@Override
	public Boolean apply(WebDriver input) {
		WebElement childElement = element.findElement(by);
		return childElement.isDisplayed();
	}

}
