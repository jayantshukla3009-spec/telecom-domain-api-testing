package telecom_Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import telecom_report.ExtentManager;

public class Listeners implements ITestListener{ 

	public void onTestStart(ITestResult result) {
		try {
			ExtentManager.createTest(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void onTestSuccess(ITestResult result) {
		ExtentManager.getTest().pass(MarkupHelper.createLabel(result.getName()+"Test Passed", ExtentColor.GREEN));
		ExtentManager.removeTest();
	}
	public void onTestFailure(ITestResult result) {
		ExtentManager.getTest().fail(MarkupHelper.createLabel(result.getName()+"Test Failed", ExtentColor.RED));
		ExtentManager.getTest().fail(result.getThrowable());
		ExtentManager.removeTest();
	}
	public void onFinish(ITestContext context) {
		ExtentManager.flush();
	}
}
