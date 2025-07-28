package Helperattributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dependsonmethod {
//when there is dependancy bw modules
	@Test
	public void createAcc() {
		Reporter.log("create executed",true);
	}
	@Test(dependsOnMethods = "createAcc")
	public void edit() {
		Reporter.log("edit executed",true);
	}
	@Test(dependsOnMethods = "edit")
	public void delete() {
		Reporter.log("delete executed",true);
	}
}
