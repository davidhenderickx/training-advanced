package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SimpleTable implements Table{
	private WebElement table;
	
	public SimpleTable(WebElement table){
		this.table = table;
	}
	
	@Override
	public String getText(int row, int col) {
		WebElement tr = this.table.findElements(By.tagName("tr")).get(row);
		return tr.findElements(By.tagName("td")).get(col).getText();
	}

	@Override
	public int getRowCount() {
		return this.table.findElements(By.tagName("tr")).size();
	}
}


