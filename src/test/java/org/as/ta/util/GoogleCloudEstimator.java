package org.as.ta.util;

import org.as.ta.model.Estimation;
import org.as.ta.pages.EmailPage;
import org.as.ta.pages.GCPCPage;
import org.as.ta.pages.HomePage;
import org.as.ta.pages.SearchResultPage;

import static org.as.ta.driver.DriverSingleton.getDriver;

public class GoogleCloudEstimator {
    private static final String SEARCH_WORD = "Google Cloud Platform Pricing Calculator";
    private static final String HOME_URL = "https://cloud.google.com/";

    public static void openingHomePage(){
        getDriver().get(HOME_URL);
    }
    public static HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public static SearchResultPage getSearchResultPage() {
        return new SearchResultPage(getDriver());
    }
    public static GCPCPage getGCPCPage(){
        return new GCPCPage(getDriver());
    }
    public static EmailPage getEmailPage(){
        return new EmailPage(getDriver());
    }

    public static void openGCPCalculator(long waitTime){
        openingHomePage();
        getHomePage().waitForPageLoadComplete(waitTime);
        getHomePage().isVisibleSearchSign();
        getHomePage().searchByKeyword(SEARCH_WORD);
        getHomePage().waitForPageLoadComplete(waitTime);
        getSearchResultPage().waitForVisibility(waitTime, getSearchResultPage().getCalculator());
        getSearchResultPage().chooseCalculator();
        getGCPCPage().waitForPageLoadComplete(waitTime);
    }
    public static String insertDataInTheCalculatorAndEstimate(long waitTime, String email, Estimation estimation){
        getGCPCPage().comeInFrame();
        getGCPCPage().insertAmountOfInstances(estimation);
        getGCPCPage().waitForPageLoadComplete(waitTime);
        getGCPCPage().insertOperatingSystemSoftware(estimation);
        getGCPCPage().waitForPageLoadComplete(waitTime);
        getGCPCPage().insertProvisioningModel(estimation);
        getGCPCPage().waitForPageLoadComplete(waitTime);
        getGCPCPage().insertMachineFamily(estimation);
        getGCPCPage().insertSeries(estimation);
        getGCPCPage().insertMachineType(estimation);
        getGCPCPage().setCheckAddGPU();
        getGCPCPage().insertGpuType(estimation);
        getGCPCPage().insertAmountOfGPUs(estimation);
        getGCPCPage().insertLocalSSD(estimation);
        getGCPCPage().insertDatacenterLocation(estimation);
        getGCPCPage().insertCommittedUsage(estimation);
        getGCPCPage().clickEstimate();
        getGCPCPage().waitForVisibility(waitTime, getGCPCPage().getEmailEstimate());
        getGCPCPage().clickEmailEstimate();
        getEmailPage().inputEmail(email);
        getEmailPage().clickSendEmail();
        return getEmailPage().getEstimation();
    }
}
