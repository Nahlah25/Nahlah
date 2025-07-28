package Ninzacrm;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Excelfileutility.Getdatafromexcel;
import Javautilty.getjavautility;
import PropertiesfileUtility.Getdatafrompropertiesfile;
import Webdriverutility.WebDriverUtility;
import baseclass.baseclass;
import pom.Addproduct;
import pom.HomePage;
import pom.LoginPage;
@Listeners(listenersutility.listenersimplementation.class)
public class CreateproductTest extends baseclass {
	@Test(groups="Regression")
	public  void Createproduct() throws EncryptedDocumentException, IOException, InterruptedException {
		//login into ninza
			
				WebDriverUtility wutil=new WebDriverUtility();
				Getdatafromexcel eutil= new Getdatafromexcel();
				getjavautility jutil=new getjavautility();
				
				
		Thread.sleep(3000);	
		HomePage hp=new HomePage(driver);
		hp.getPRO().click();
		hp.getAddpro().click();
		String PNAME = eutil.Getdatafromexcel("Product", 1, 2);
		String QUANTITY = eutil.Getdatafromexcel("Product", 1, 3);
		String PRICE = eutil.Getdatafromexcel("Product", 1, 4);
		
					
		
	//create product
	Addproduct ap=new Addproduct(driver);
	
	
	ap.getPID();
	ap.getPNAME().sendKeys(PNAME);
	ap.getPQUAN().clear();ap.getPQUAN().sendKeys(QUANTITY);
	ap.getPP().clear();
	ap.getPP().sendKeys(PRICE);
	
	wutil.selectByIndex(ap.getPCATE(),2);
	
	wutil.selectByIndex(ap.getVID(), 3);
	ap.getADD().click();
	Thread.sleep(4000);
	//hp.getCLOSE().click();
	
	
    driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			}

}
