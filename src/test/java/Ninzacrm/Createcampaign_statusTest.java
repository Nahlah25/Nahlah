package Ninzacrm;

import java.io.IOException;
import java.time.Duration;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Excelfileutility.Getdatafromexcel;
import Javautilty.getjavautility;
import PropertiesfileUtility.Getdatafrompropertiesfile;
import Webdriverutility.WebDriverUtility;
import baseclass.baseclass;
import pom.Campaignpage;
import pom.HomePage;
import pom.LoginPage;
@Listeners(listenersutility.listenersimplementation.class)


public class Createcampaign_statusTest extends baseclass {


@Test  (groups="Smoke")
public  void Createcampaign_status() throws IOException, InterruptedException {
	Getdatafromexcel eutil=new Getdatafromexcel();
	WebDriverUtility wutil=new WebDriverUtility();
	getjavautility jutil=new getjavautility();
//READINGDATA FOM EXCEL
String Campname = eutil.Getdatafromexcel("Campaign", 1, 2);
String size = eutil.Getdatafromexcel("Campaign", 1, 3);	
String status=eutil.Getdatafromexcel("Campaign", 1, 4);
//click on create campaign button
//HomePage hp=new HomePage(driver)

HomePage hp =new HomePage(driver);
hp.getCRE().click();

//entering mandotory fields to create campaign
Campaignpage cp=new Campaignpage(driver);
cp.getNAME().sendKeys(Campname);
cp.getSIZE().sendKeys(size);
cp.getSTATUS().sendKeys(status);
cp.getSUB().click();

//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
//driver.findElement(By.name("campaignName")).sendKeys(Campname+jutil.getRandomnumber());
//WebElement tar = driver.findElement(By.name("targetSize"));
//tar.clear();
//tar.sendKeys(size);
//driver.findElement(By.name("campaignStatus")).sendKeys(status);
//driver.findElement(By.xpath("//button[@type='submit']")).click();

//validation

//hp.getCLOSE();
//hp.getToast();
Thread.sleep(2000);
WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
Thread.sleep(2000);
wutil.waitForVisibilityOfElement (driver, toast);

String msg=toast.getText();


/*if(msg.contains(Campname)) {
	System.out.println("campaign is created");
}else {System.out.println("campaign not created");}*/
//Assert.assertTrue(msg.contains(Campname));

Assert.assertEquals(msg, "Campaign "+Campname+" Successfully Added");
driver.findElement(By.xpath("//button[@aria-label='close']")).click();//i changed xpath to id to get error
//logout 

//hp.getUSE().click();
//hp.getLOG().click();
//WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
//wutil.mouseHoverOnWebElement(driver, icon);
//Actions act=new Actions(driver);
//act.moveToElement(icon).perform();
//WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
//act.moveToElement(logout).click().perform();
//wutil.clickOnWebElement(driver, logout);


}
}