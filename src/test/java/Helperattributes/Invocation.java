package Helperattributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Invocation {
@Test(invocationCount =3)
public void login() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	Reporter.log("execution",true);
	Thread.sleep(2000);
}
}
