package Helperattributes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
@Test(dataProvider = "logindetails")
public void login(String un,String pw) {
	System.out.println(un+"==="+pw);
}
@DataProvider
public Object[][]logindetails(){
	Object[][]objarr=new Object[3][2];
	objarr[0][0]="virat";
	objarr[0][1]="v123";
	objarr[1][0]="sachin";
	objarr[1][1]="s123";
	objarr[2][0]="rohi";
	objarr[2][1]="r123";
	return objarr;
	
}
}
