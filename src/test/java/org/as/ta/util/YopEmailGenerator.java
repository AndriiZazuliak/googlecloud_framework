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
        // треба чекати поки прийде лист
        getYopMailPage().clickAndCheckEmail();
        getYopMailPage().waitForPageLoadComplete(waitTime * 2);
        // випадок, коли у поштовій скриньці вже є листи
        String previousText = getYopMailPage().arriveEmail();

        do {
            getYopMailPage().waiter(waitTime);
            getYopMailPage().clickButtonRefresh();
        }while (getYopMailPage().arriveEmail().equals(previousText));

        getYopMailPage().comeInYopFrame();
        return getYopMailPage().getMonthCost();
    }
}
