package Datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Propertiesfile {
	public static void main(String[] args) throws IOException {
		//IF Not able to do the file path right click create new folder config file
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\Desktop\\selenium notepad\\ninza.properties.txt");
		//create object for properties
		Properties prop=new Properties();
		//load all prop keys
		prop.load(fis);
		//get properies
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		//suppose if any of the browser not working we can do like this
		WebDriver driver=null;
		if(BROWSER.equals("Edge")) {
			driver=new EdgeDriver();
		}
		if(BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();
		}
		if(BROWSER.equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		//actual script
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		}

}
