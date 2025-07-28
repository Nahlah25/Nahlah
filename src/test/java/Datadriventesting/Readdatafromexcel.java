package Datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Readdatafromexcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("./Testdata/TestScriptdataadv.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Sheet1");
Row r = sh.getRow(1);

String campname = r.getCell(2).getStringCellValue();
String size = r.getCell(3).getStringCellValue();

/*WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.instagram.com/");
driver.findElement(By.name("username")).sendKeys(un);
driver.findElement(By.name("password")).sendKeys(pw);*/



}
}
