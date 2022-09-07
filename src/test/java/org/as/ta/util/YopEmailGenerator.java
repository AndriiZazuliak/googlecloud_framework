package org.as.ta.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.as.ta.pages.BasePage;
import org.as.ta.pages.YopMailPage;
import org.openqa.selenium.WebDriver;

import static org.as.ta.driver.DriverSingleton.getDriver;

public class YopEmailGenerator extends BasePage {
    public YopEmailGenerator(WebDriver driver) {
        super(driver);
    }
    private static final String YOPMAIL_URL = "https://yopmail.com/";
    private static final Logger logger = LogManager.getRootLogger();

    public static void openYopMailPage(){
        getDriver().get(YOPMAIL_URL);
    }

    public static YopMailPage getYopMailPage(){
        return new YopMailPage(getDriver());
    }

    public static String generateNewYopMail(long waitTime){
        openYopMailPage();
        getYopMailPage().clickRandomEmailGenerator();
        getYopMailPage().waitForPageLoadComplete(waitTime);
        logger.info("Created email: " + getYopMailPage().copyMail());
        return getYopMailPage().copyMail();
    }

    public static String showEstimatedAmount(long waitTime){
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.warn("The letter has not arrived yet. " + waitTime + " seconds have passed");
        }
//        getYopMailPage().waitForPageLoadComplete(waitTime);
        getYopMailPage().clickAndCheckEmail();
        getYopMailPage().waitForPageLoadComplete(waitTime * 2);
        getYopMailPage().comeInYopFrame();
        logger.info("Estimated amount is " + getYopMailPage().getMonthCost());
        return getYopMailPage().getMonthCost();
    }
}
