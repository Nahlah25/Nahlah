package Datadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writebacktoexcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\selenium notepad\\instagram.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Sheet1");
Row r = sh.getRow(1);
Cell cell = r.createCell(5);
cell.setCellType(CellType.STRING);
cell.setCellValue("nahlah");
FileOutputStream fos= new FileOutputStream("C:\\Users\\User\\Desktop\\selenium notepad\\instagram.xlsx");
wb.write(fos);
wb.close();
}
}
