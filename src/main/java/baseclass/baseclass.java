package baseclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import PropertiesfileUtility.Getdatafrompropertiesfile;
import pom.HomePage;
import pom.LoginPage;

public class baseclass {
	
public  WebDriver driver=null;
public static WebDriver sdriver=null;//forlistners
public Getdatafrompropertiesfile putil=new Getdatafrompropertiesfile();

@BeforeSuite(groups={"Smoke","Regression"})
public void beforesuite() {
	Reporter.log("db connectivity open",true);
}
@BeforeTest(groups={"Smoke","Regression"})
public void beforetest() {
	Reporter.log("preconditions",true);
}
//@Parameters("BROWSER")// add in method parameter also when needed to do cross browsing
@BeforeClass(groups={"Smoke","Regression"})
public void beforeclass() throws IOException {

String BROWSER = putil.Getdatafrompropertiesfile("browser");

	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	if(BROWSER.equalsIgnoreCase("edge")) {
		driver=new EdgeDriver();
	}
	if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	sdriver=driver;
	driver.manage().window().maximize();
System.out.println("launching browser");
}
@BeforeMethod(groups={"Smoke","Regression"})
public void beforemethod() throws IOException {
	String BROWSER = putil.Getdatafrompropertiesfile("browser");
	String URL = putil.Getdatafrompropertiesfile("url");
	String UN = putil.Getdatafrompropertiesfile("username");
	String PW = putil.Getdatafrompropertiesfile("password");
driver.get(URL);
LoginPage lp=new LoginPage(driver);
lp.getUN().sendKeys(UN);
lp.getPW().sendKeys(PW);
lp.getSI().click();
System.out.println("login done");
}
@AfterMethod(groups={"Smoke","Regression"})
public void aftermethod() {
HomePage hp= new HomePage(driver);
hp.getUSE().click();
hp.getLOG().click();
System.out.println("logout done");
}
@AfterClass(groups={"Smoke","Regression"})
public void afterclass() {
	driver.quit();
System.out.println("closing browser");	

}
@AfterTest(groups={"Smoke","Regression"})
public void aftertest() {
	System.out.println("postconditins");
}
@AfterSuite(groups={"Smoke","Regression"})
public void aftersuite() {
	
	System.out.println("db connectivity");
}

}



