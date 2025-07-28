package Datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Datareadingfromexcelmultiplerow {public static void main(String[] args) throws IOException {
FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\selenium notepad\\multiplerowmobiles.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet s = wb.getSheet("Sheet1");
int rowcount = s.getLastRowNum();
System.out.println(rowcount);

for(int row=1;row<=rowcount;row++) {
String pc = s.getRow(row).getCell(0).getStringCellValue();
String pn = s.getRow(row).getCell(1).getStringCellValue();

System.out.println(pn+" "+pc);}



}}