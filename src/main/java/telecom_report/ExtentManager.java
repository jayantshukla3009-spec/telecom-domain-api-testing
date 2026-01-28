package telecom_report;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
private static ExtentReports extent;
private static ThreadLocal<ExtentTest>test = new ThreadLocal<>();
public static ExtentReports getReport() throws IOException {
	String fpath = System.getProperty("user.dir")+"/Reports/TelecomAPI_"+(System.currentTimeMillis()%10000)+".html";
	File reportPath = new File(fpath);
	reportPath.getParentFile().mkdirs();
	if(extent==null) {
		ExtentSparkReporter spark = new ExtentSparkReporter(fpath);
		spark.config().setDocumentTitle("API Testing for Contact List Application");
		spark.config().setReportName("Telecom API Automation Report");
		spark.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("User name",System.getProperty("user.name") );
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		
	}
	return extent;
}
public static void createTest(String testName) throws IOException {
	ExtentTest extentTest = getReport().createTest(testName);
	test.set(extentTest);
}
public static ExtentTest getTest() {
	return test.get();
}
public static void flush() {
	if(extent!=null) {
	extent.flush();
	}
}
public static void removeTest() {
	test.remove();
}
}
