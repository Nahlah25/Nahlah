package listenersutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseclass.baseclass;

public class listenersimplementation implements ITestListener ,ISuiteListener{
public ExtentSparkReporter spark;
public ExtentReports report;
public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
	Reporter.log("report configuration",true);
	Date d=new Date();
	String newdate = d.toString().replace(" ", "_").replace(":", "_");
	spark = new ExtentSparkReporter("./Advancereport/report_"+newdate+".html");
	spark.config().setDocumentTitle("ninza crm test results");
	spark.config().setReportName("crm report");
	spark.config().setTheme(Theme.DARK);
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "windows 11");
	report.setSystemInfo("browser", " edge");

		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		Reporter.log("report backup",true);}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"==="+result.getMethod().getMethodName()+"execution stated");}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		Reporter.log("===="+testname+"FAILURE===",true);
		Date d=new Date();
		String newdate = d.toString().replace(" ","_").replace(":","_");
		TakesScreenshot ts=(TakesScreenshot)baseclass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,testname+newdate);
		test.log(Status.FAIL,"==="+testname+"failure===");
		/*File perm= new File("./errorshots/"+testname+""+newdate+".png");
		try {
			FileHandler.copy(temp, perm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
