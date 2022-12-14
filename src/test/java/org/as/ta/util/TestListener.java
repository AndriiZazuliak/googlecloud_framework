package org.as.ta.util;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.as.ta.driver.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private final Logger log = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // TODO document why this method is empty
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // TODO document why this method is empty
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // TODO document why this method is empty
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // TODO document why this method is empty
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // TODO document why this method is empty
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // TODO document why this method is empty
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: {}", e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}
