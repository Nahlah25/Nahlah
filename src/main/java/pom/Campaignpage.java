package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaignpage {

	WebDriver driver;
	public Campaignpage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(name = "campaignName")
	private WebElement NAME;
	
	@FindBy(name = "campaignStatus")
	private WebElement STATUS;
	
	@FindBy(name = "targetSize")
	private WebElement SIZE;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement SUB;
	
	@FindBy(name="expectedCloseDate")
	private WebElement closedate;

	public WebElement getClosedate() {
		return closedate;
	}

	public WebElement getSUB() {
		return SUB;
	}

	public void setSUB(WebElement sUB) {
		SUB = sUB;
	}

	public WebElement getNAME() {
		return NAME;
	}

	public WebElement getSTATUS() {
		return STATUS;
	}

	public WebElement getSIZE() {
		return SIZE;
	}
}
