package controls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleDetails implements Details {
	private WebElement details;

	public SimpleDetails(WebElement details) {
		this.details = details;
	}

	@Override
	public void expand() {
		if (isCollapsed()) {
			getSummaryElement().click();
		}
	}

	@Override
	public void collapse() {
		if (!isCollapsed()) {
			getSummaryElement().click();
		}
	}

	@Override
	public boolean isCollapsed() {
		return details.getAttribute("open") == null;
	}

	@Override
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		List<WebElement> children = details.findElements(By.xpath("*"));
		for(WebElement e: children){
			if(!e.getTagName().equals("summary") && e.isDisplayed()){
				sb.append(e.getText());
			}
		}
		return sb.toString();
		
	}

	@Override
	public String getSummary() {
		return getSummaryElement().getText();
	}

	private WebElement getSummaryElement() {
		return details.findElement(By.tagName("summary"));
	}
}
