package Helperattributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datapoviderwithexcel {
	@Test(dataProvider = "logindetails")
	public void login(String username,String password) throws InterruptedException {
		WebDriver driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));Thread.sleep(2000);
driver.quit();}
	@DataProvider
	public Object[][]logindetails()throws IOException,EncryptedDocumentException {
		FileInputStream fis =new FileInputStream("./testdata/dataprovider.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("sheet1");
		int rowcount=sh.getLastRowNum();
		Object[][]objarr=new Object[rowcount][2]	;	
		for(int i=0;i<rowcount;i++) {
			objarr[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objarr[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
		}		
		return objarr;
		
	}

}
