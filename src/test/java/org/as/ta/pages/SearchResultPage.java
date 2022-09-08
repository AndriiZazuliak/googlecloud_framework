package org.as.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement calculator;

    public void chooseCalculator(){
        calculator.click();
    }
    public WebElement getCalculator(){
        return calculator;
    }
    public SearchResultPage(WebDriver driver){
        super(driver);
    }
}
