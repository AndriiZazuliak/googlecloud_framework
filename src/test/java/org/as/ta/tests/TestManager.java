package org.as.ta.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.as.ta.model.Estimation;
import org.as.ta.services.EstimationCreator;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.as.ta.util.GoogleCloudEstimator.*;
import static org.as.ta.util.YopEmailGenerator.*;
import static org.testng.Assert.assertTrue;

public class TestManager extends CommonConditions{
    private static final Logger logger = LogManager.getRootLogger();
    private static final long WAIT_TIME = 10;

    @Test
    public void theFirstEstimationTest() {
        Estimation estimation = EstimationCreator.withData();

        String email = generateNewYopMail(WAIT_TIME);
        String yopTab = getYopMailPage().getWindowId();  // запам'ятовуємо ID вкладки YopMail
        getHomePage().switchToNewTab();  //переключаємося на нову вкладку
        String calkTab = getHomePage().getWindowId();  // запам'ятовуємо ID вкладки калькулятора
        openGCPCalculator(WAIT_TIME);
        // працюємо з калькулятором
        String calcEstimation = insertDataInTheCalculatorAndEstimate(WAIT_TIME, email, estimation);

        getYopMailPage().switchToPreviousTab(calkTab);  //переключаємося на попередню вкладку
        // переключаємося на сторінку електронної пошти
        getEmailPage().switchToPreviousTab(yopTab);
        String mailEstimation = showEstimatedAmount(WAIT_TIME); // записуємо текст отриманих поштою розрахунків
        logger.info("Estimated amount is " + getYopMailPage().getMonthCost());
        logger.info("Estimation text: " + getEmailPage().getEstimation());
        Pattern pattern = Pattern.compile(".*" + mailEstimation + ".*");
        Matcher matcher = pattern.matcher(calcEstimation);
        assertTrue(matcher.matches());
    }
}
