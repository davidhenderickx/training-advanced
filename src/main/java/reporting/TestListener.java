package reporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import helper.DriverManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext iTestContext) {
		// Log.info("I am in onStart method " + iTestContext.getName());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		if (ExtentReportManager.getExtentReport() != null) {
			ExtentReportManager.getExtentReport().flush();
		}
		// Log.info("I am in onFinish method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		ExtentTestManager.createTest(
				iTestResult.getTestClass().getName() + " :: " + iTestResult.getMethod().getMethodName(),
				iTestResult.getMethod().getDescription());

		// Log.info(getTestMethodName(iTestResult) + " test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		String logText = "<b>Test Method" + iTestResult.getMethod().getMethodName() + " Successful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentTestManager.getTest().log(Status.PASS, m);
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		String exceptionMessage = "";
		Throwable exceptionThrowable = iTestResult.getThrowable();
		if (exceptionThrowable != null && !isAssertionError(exceptionThrowable)) {
			String assertionMessage = iTestResult.getThrowable().getMessage();
			exceptionMessage = "<details><summary><b><font color=red>" + "Assertion occured, click to see deails:"
					+ "</font></b></summary>" + assertionMessage.replaceAll(",", "<br>") + "</details> \n";
		} else {
			String stackTrace = Arrays.toString(iTestResult.getThrowable().getStackTrace());
			exceptionMessage = "<details><summary><b><font color=red>" + "Exception occured, click to see deails:"
					+ "</font></b></summary>" + stackTrace.replaceAll(",", "<br>") + "</details> \n";
		}
		ExtentTestManager.getTest().fail(exceptionMessage);
		Date d = new Date();
		String directory = System.getProperty("user.dir") + File.separator + "test-output" + File.separator
				+ "screenshots";
		String screenshotFileName = iTestResult.getMethod().getMethodName() + "_screenshot_"
				+ d.toString().replace(":", "_").replace(" ", "_");
		new File(directory).mkdirs();
		String path = directory + File.separator + screenshotFileName + ".png";
		try {
			File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot, new File(path));
			System.out.println("Captured screenshot: " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ExtentTestManager.getTest().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									".." + File.separator + "screenshots" + File.separator + screenshotFileName + ".png")
							.build());
		} catch (Exception e) {
			ExtentTestManager.getTest().fail("Test failed, cannot attach screenshot");
		}

		String logText = "<b>Test Method" + iTestResult.getMethod().getMethodName() + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentTestManager.getTest().log(Status.FAIL, m);

	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		String logText = "<b>Test Method" + iTestResult.getMethod().getMethodName() + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentTestManager.getTest().log(Status.SKIP, m);

		// Log.info(getTestMethodName(iTestResult) + " test is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// Not needed
	}

	private boolean isAssertionError(Throwable throwed) {
		String message = stackTraceToString(throwed);
		return message.startsWith("org.testng.Assert");
	}

	public String stackTraceToString(Throwable throwable) {
		String printString = "";
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		try {
			throwable.printStackTrace(pWriter);
			printString = sWriter.toString();
			pWriter.flush();
			pWriter.close();
			sWriter.flush();
			sWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return printString;
	}

}
