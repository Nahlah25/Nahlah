import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {
	@Test
	public void demo() {
	String exptitle="Facebook – log In or sign up";
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");

	 driver.findElement(By.id("email")).sendKeys("r1@gmail.com");
	 @org.jspecify.annotations.Nullable
	String acttitle = driver.getTitle();

	 
	 SoftAssert soft=new SoftAssert();
	soft.assertEquals(acttitle, exptitle);
	System.out.println("step 1");
	System.out.println("step2");
	soft.assertAll();
	//eventhough we can pass email it wil give fail as title not matching eventhough one failed it wll complete the test
	}
	
}
