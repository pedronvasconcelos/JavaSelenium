package com.javaseleniumtemplate.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.javaseleniumtemplate.GlobalParameters;
import org.testng.ITestResult;
import java.io.IOException;

public class ExtentReportUtils {
    public static ExtentReports EXTENT_REPORT = null;
    public static ExtentTest TEST;
    public static ExtentHtmlReporter  HTML_REPORTER = null;
    static String reportName = GlobalParameters.REPORT_NAME + "_" + Utils.getNowDate("yyyy-MM-dd_HH-mm-ss");
    static String reportsPath = GlobalParameters.REPORT_PATH;
    static String fileName = reportName+".html";
    static String fullReportFilePath = reportsPath + "/"+ reportName +"/" + fileName;
    static String fullScreenShotPath = reportsPath + "/"+ reportName +"/";
    private static String testNameMemory = null;

    public static void createReport(){
        if (EXTENT_REPORT == null)
        {
            //Utils.ensureDirectoryExists(fullReportFilePath);
            HTML_REPORTER = new ExtentHtmlReporter(fullReportFilePath);
            EXTENT_REPORT = new ExtentReports();
            EXTENT_REPORT.attachReporter(HTML_REPORTER);
        }
    }

    public static void addTest(String testName, String testCategory){
        testNameMemory = testName;
        TEST = EXTENT_REPORT.createTest(testName).assignCategory(testCategory.replace("Tests",""));
    }

    public static void addTestInfo(int methodLevel, String text){
        String methodName = Utils.getMethodNameByLevel(methodLevel);
        String testName = testNameMemory;
        if(GlobalParameters.GET_SCREENSHOT_FOR_EACH_STEP) {
            TEST.log(Status.PASS, methodName + " || " + text, getScreenShotMedia(testName+"_"+methodName+"_"+Utils.getNowDate("yyyy-MM-dd_HH-mm-ss-SSS")));
        }else {
            TEST.log(Status.PASS, methodName + " || " + text);
        }
    }

    public static MediaEntityModelProvider getScreenShotMedia(String testName){
        String screenshotPath = Utils.getScreenshot(testName, fullScreenShotPath);

        MediaEntityModelProvider media = null;

        try {
            media = MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath.replace(fullScreenShotPath,"./")).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return media;
    }

    public static void addTestResult(ITestResult result){
        switch (result.getStatus())
        {
            case ITestResult.FAILURE:
                TEST.log(Status.FAIL, "Test Result: " + Status.FAIL + "<pre>" + "Message: " + result.getThrowable().toString() + "</pre>" + "<pre>" + "Stack Trace: " + Utils.getAllStackTrace(result) + "</pre>", getScreenShotMedia(testNameMemory));
                break;
            case ITestResult.SKIP:
                TEST.log(Status.SKIP, "Test Result: " + Status.SKIP + "<pre>" + "Message: " + result.getThrowable().toString() + "</pre>" + "<pre>" + "Stack Trace: " + Utils.getAllStackTrace(result) + "</pre>", getScreenShotMedia(testNameMemory));
                break;
            default:
                TEST.log(Status.PASS, "Test Result: " + Status.PASS);
                break;
        }
    }

    public static void generateReport(){
        EXTENT_REPORT.flush();
    }
}
