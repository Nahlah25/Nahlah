package Ninzacrm;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;
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
public class DateaftercreatingTest extends baseclass {
    @Test(groups = "Smoke")
    public void Dateaftercreating() throws InterruptedException, IOException {
        Getdatafromexcel eutil = new Getdatafromexcel();
        WebDriverUtility wutil = new WebDriverUtility();
        getjavautility jutil = new getjavautility();

        Campaignpage cp = new Campaignpage(driver);
        Thread.sleep(2000);
        String Campname = eutil.Getdatafromexcel("Campaign", 1, 2);
        String size = eutil.Getdatafromexcel("Campaign", 1, 3);
        int ran = jutil.getRandomnumber();
        String expectdate = jutil.togetreqdate(30);

        HomePage hp = new HomePage(driver);
        hp.getCRE().click();

        // entering mandotory fields to create campaign
        cp.getNAME().sendKeys(Campname);
        cp.getSIZE().sendKeys(size);
        wutil.passInput(driver, cp.getClosedate(), jutil.togetreqdate(30));
        cp.getSUB().click();

        // validation
        Thread.sleep(2000);
        WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
        Thread.sleep(2000);
        wutil.waitForVisibilityOfElement(driver, toast);

        String msg = toast.getText();

       /* if (msg.contains(Campname)) {
            System.out.println("campaign is created");
        } else {
            System.out.println("campaign not created");
        }*/
        Assert.assertEquals(msg,"Campaign "+Campname+" Successfully Added");

        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
        
    }
}
