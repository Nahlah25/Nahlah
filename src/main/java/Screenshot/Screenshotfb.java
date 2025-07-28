package Screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Screenshotfb {
@Test(invocationCount = 3)
public void demo() throws IOException {
WebDriver driver =new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.facebook.com/");
TakesScreenshot ts = (TakesScreenshot)driver;
File temp= ts.getScreenshotAs(OutputType.FILE);
File perm=new File("./test-output/fb.png/");
FileHandler.copy(temp, perm);
	
}
}
