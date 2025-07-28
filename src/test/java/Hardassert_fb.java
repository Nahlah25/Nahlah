import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Nullable;

public class Hardassert_fb {
@Test
public void demo() {
String exptitle="Facebook – log in or sign up";
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");

 
 @org.jspecify.annotations.Nullable
String acttitle = driver.getTitle();

Assert.assertEquals(acttitle, exptitle);
System.out.println("step1");
System.out.println("step2");
}
}
