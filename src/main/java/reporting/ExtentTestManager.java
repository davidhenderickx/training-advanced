package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;

/**
 * extentTestMap holds the information of thread ids and ExtentTest instances.
 * ExtentReports instance created by calling createExtentReports() method from ExtentManager.
 * At startTest() method, an instance of ExtentTest created and put into extentTestMap with current thread id.
 * At getTest() method, return ExtentTest instance in extentTestMap by using current thread id.
 */

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentReportManager.createInstance();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest createTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
    
    public static synchronized void removeTest(String testName) {
    	extent.removeTest(testName);
    }
}