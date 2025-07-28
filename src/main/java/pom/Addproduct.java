package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addproduct {
WebDriver driver;
public Addproduct(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name = "productId")
private WebElement PID;

@FindBy(name = "productName")
private WebElement PNAME;

@FindBy(name = "productCategory")
private WebElement PCATE;

@FindBy(name = "quantity")
private WebElement PQUAN;

@FindBy(name = "price")
private WebElement PP;

@FindBy(name = "vendorId")
private WebElement VID;

@FindBy(xpath = "//button[text()='Add']")
private WebElement ADD;
public WebDriver getDriver() {
	return driver;
}

public WebElement getPID() {
	return PID;
}

public WebElement getPNAME() {
	return PNAME;
}

public WebElement getPCATE() {
	return PCATE;
}

public WebElement getPQUAN() {
	return PQUAN;
}

public WebElement getPP() {
	return PP;
}

public WebElement getVID() {
	return VID;
}

public WebElement getADD() {
	return ADD;
}

}
