package org.as.ta.tests;

import org.as.ta.driver.DriverSingleton;
import org.as.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }
    @AfterMethod
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
