package Helperattributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class enabled {
@Test(enabled = true)
public void all() {
	Reporter.log("all executed",true);
}
@Test(enabled = false)//if want to skip
public void a22() {
	Reporter.log("a22 executed",true);
}
@Test
public void a10() {
	Reporter.log("a10 executed",true);
}
}
