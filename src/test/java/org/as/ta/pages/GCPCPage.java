package org.as.ta.pages;

import org.as.ta.model.Estimation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GCPCPage extends BasePage{

    @FindBy(xpath = "//iframe[@allow]")
    WebElement firstFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    WebElement secondFrame;
    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement instances;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']//div[@class='md-text']")
    WebElement operatingSystemSoftwareMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']//div[@class='md-text']")
    WebElement provisioningModelMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.family']//div[@class='md-text']")
    WebElement machineFamilyMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.series']//div[@class='md-text ng-binding']")
    WebElement seriesNameMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']//div[@class='md-text ng-binding']")
    WebElement machineTypeMenu;
    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs' and contains(@ng-model, 'computeServer')]")
    WebElement checkAddGPU;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    WebElement gpuTypeMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    WebElement amountOfGPUs;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    WebElement localSSDMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    WebElement datacenterLocationMenu;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    WebElement committedUsageMenu;
    @FindBy(xpath = "//button[contains(text(),'Add to Estimate') and contains(@ng-disabled,'ComputeEngine')]")
    WebElement estimateButton;
    @FindBy(xpath = "//button[@id='email_quote']")
    WebElement emailEstimate;

    public void comeInFrame(){
        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(secondFrame);
    }
    public GCPCPage(WebDriver driver){
        super(driver);
    }
    public void insertAmountOfInstances(Estimation estimation){
        instances.sendKeys(estimation.getNumberOfInstances());
    }
    public void insertOperatingSystemSoftware(Estimation estimation){
        operatingSystemSoftwareMenu.click();
        driver.findElement(By.xpath("//md-option/div[contains(text(),'" + estimation.getOperatingSystemSoftware() + "')]")).click();
//        driver.findElement(By.xpath("//md-option/div[@class='md-text' and contains(text(),'" + estimation.getOperatingSystemSoftware() + "')]/parent::md-option")).click();
    }
    public void insertProvisioningModel(Estimation estimation){
        provisioningModelMenu.click();
        driver.findElement(By.xpath("//md-option/div[@class='md-text' and contains(text(),'" + estimation.getProvisioningModel() + "')]")).click();
    }
    public void insertMachineFamily(Estimation estimation){
        machineFamilyMenu.click();
        driver.findElement(By.xpath("//md-option/div[@class='md-text' and contains(text(),'" + estimation.getMachineFamily() + "')]")).click();
    }
    public void insertSeries(Estimation estimation){
        seriesNameMenu.click();
        driver.findElement(By.xpath("//md-option/div[@class='md-text ng-binding' and contains(text(),'" + estimation.getSeries() + "')]")).click();
    }
    public void insertMachineType(Estimation estimation){
        machineTypeMenu.click();
        driver.findElement(By.xpath("//md-option/div[@class='md-text ng-binding' and contains(text(),'" + estimation.getMachineType() + "')]")).click();
    }
    public void setCheckAddGPU(){
        checkAddGPU.click();
    }
    public void insertGpuType(Estimation estimation){
        gpuTypeMenu.click();
        driver.findElement(By.xpath("//md-option/div[@class='md-text ng-binding' and contains(text(),'" + estimation.getGpuType() + "')]")).click();
    }
    public void insertAmountOfGPUs(Estimation estimation){
        amountOfGPUs.sendKeys(estimation.getAmountOfGPUs());
    }
    public void insertLocalSSD(Estimation estimation){
        localSSDMenu.click();
        driver.findElement(By.xpath("//md-option/div[@class='md-text ng-binding' and contains(text(),'" + estimation.getLocalSSD() + "')]")).click();
    }
    public void insertDatacenterLocation(Estimation estimation){
        datacenterLocationMenu.click();
        driver.findElement(By.xpath("(//md-option/div[@class='md-text ng-binding' and contains(text(),'" + estimation.getDatacenterLocation() + "')])[3]")).click();
    }
    public void insertCommittedUsage(Estimation estimation){
        committedUsageMenu.click();
        driver.findElement(By.xpath("(//md-option/div[@class='md-text' and contains(text(),'" + estimation.getCommittedUsage() + "')])[2]")).click();
    }
    public void clickEstimate(){
        estimateButton.click();
    }
    public WebElement getEmailEstimate(){
        return emailEstimate;
    }
    public void clickEmailEstimate(){
        emailEstimate.click();
    }
}
