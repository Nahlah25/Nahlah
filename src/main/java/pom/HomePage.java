package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;

public HomePage(WebDriver driver){
this .driver=driver;
PageFactory.initElements(driver, this);
}

public WebElement getCAM() {
	return CAM;
}


public WebElement getCON() {
	return CON;
}



public WebElement getPRO() {
	return PRO;
}


public WebElement getCRE() {
	return CRE;
}



public WebElement getUSE() {
	return USE;
}



public WebElement getLOG() {
	return LOG;
}



public WebElement getToast() {
	return toast;
}



public WebElement getCLOSE() {
	return CLOSE;
}




@FindBy (linkText = "Campaigns")
 private WebElement CAM;

@FindBy(linkText = "Contacts")
private WebElement CON;

@FindBy(linkText = "Products")
private WebElement PRO;

@FindBy(xpath = "//span[text()='Add Product']")
private WebElement addpro;

public WebElement getAddpro() {
	return addpro;
}

public void setAddpro(WebElement addpro) {
	this.addpro = addpro;
}




@FindBy(xpath = "//span[text()='Create Campaign']")
private WebElement CRE;

@FindBy(xpath = "//div[@class='user-icon']")
private WebElement USE;

@FindBy(xpath = "//div[text()='Logout ']")
private WebElement LOG;


@FindBy(xpath =  "//div[@role='alert']")
private WebElement toast;

@FindBy(xpath = "//button[@aria-label='close']")
private WebElement CLOSE;
}