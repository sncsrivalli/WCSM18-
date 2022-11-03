package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationForExtentReports implements ITestListener{

	private ExtentReports report;
	private ExtentTest test;
	public static ExtentTest stest;

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("WCSM18");
		spark.config().setReportName("Extent Practice");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Srivalli");
		report.setSystemInfo("OS", "Win 11");
		report.setSystemInfo("Browser", "Chrome");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+ " Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+ " Fail");
		new WebDriverUtility().getScreenshot(BaseClassForRetry.sdriver, BaseClassForRetry.sjavaUtility, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+ " Skipped");
		test.fail(result.getThrowable());
	}


	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
