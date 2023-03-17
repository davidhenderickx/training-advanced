package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import controls.SimpleTable;
import controls.Table;

public class StatsPage {
	
	@FindBy(how = How.ID, using = "statsConnections")
	private WebElement tblConnections;
	
	public Table getConnectionStatisticsTable(){
		return new SimpleTable(tblConnections);
	}
	
	public int getRowsInStatsTable() {
		Table table = new SimpleTable(tblConnections);
		return table.getRowCount();
	}
	
	public boolean hasConnections(){
		return !getConnectionStatisticsTable().getText(0, 2).equals("N/A");
	}
}
