package Helperattributes;

import org.testng.Reporter;
import org.testng.annotations.Test;
//least priority run first
public class Priority {
@Test (priority=0)
public void amazon() {
	Reporter.log("amazon executed",true);
}
@Test (priority=-2)
public void bookmy() {
	Reporter.log("book my executed",true);
}
@Test (priority=3)
public void flipkart() {
	Reporter.log("flipkart executed",true);
}

}
