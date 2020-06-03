package p2.validator

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

/*import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import p2.util.ActionUtils
import p2.Properties.HomePageXpathLocators
import p2.util.ListDataType

import internal.GlobalVariable

public class HomeValidator {
	ListDataType cvList = new ListDataType();
	//private static Logger logger = LogManager.getLogger(HomeValidator.class.getCanonicalName());
	KeywordLogger loggerKey = new KeywordLogger()
	public static boolean isP2ProjectDisplayed_JO(RemoteWebDriver driver) {
		boolean p2ProjectStatus = false;
		//p2ProjectStatus = ActionUtils.isElementPresent_Xpath(driver, HomePageXpathLocators.getP2Project_Val());
		//logger.logInfo("")
		//logger.logDebug("P2 Project screen load status: " + p2ProjectStatus);
		return p2ProjectStatus;
	}

	public static boolean isNewProjectWindowDisplayed_JO(RemoteWebDriver driver) {
		boolean newProjectWindow = false;
		newProjectWindow = ActionUtils.isElementPresent_Xpath(driver, HomePageXpathLocators.getSaveBtn_NewProject());
		//	logger.logDebug("New P2 Project Window displayed status: " + newProjectWindow);
		return newProjectWindow;
	}

	public boolean isSearchBoxDisplayed(RemoteWebDriver driver) {
		boolean searchBxStatus= false;

		searchBxStatus = ActionUtils.isElementPresent_Xpath(driver, HomePageXpathLocators.getSearch());
		logger.logDebug("Search Box Displayed Status: "+searchBxStatus);
		test.log(Status.INFO, MarkupHelper.createLabel("Search Box Displayed Status: "+searchBxStatus, ExtentColor.BROWN));
		return searchBxStatus;
	}

	public String getActiveElementName(RemoteWebDriver driver) {
		ActionUtils.waitFor2Seconds();
		String getTxt = null;
		WebElement ele = driver.findElement(By.cssSelector(HomePageXpathLocators.getActiveElementt()));
		getTxt = ele.getText();
		logger.logDebug("Active Element Name: "+getTxt);
		test.log(Status.INFO, MarkupHelper.createLabel("By Default Highlighted Tab Name: "+getTxt, ExtentColor.BROWN));
		return getTxt;

	}

	// home page tab vlaidation for JO
	public boolean homePageTabValidation_JO(RemoteWebDriver driver) {
		boolean homeTabStatus = false;
		ArrayList<String> homePageMenuElements = cvList.homePageMenuitems_JO();
		ArrayList<String> homePageElements = new ArrayList<String>();
		List<WebElement> allElements = driver.findElements(By.xpath(HomePageXpathLocators.getHomeTabList()));
		for (WebElement element: allElements) {
			logger.logDebug("Tab Name: " +element.getText());
			homePageElements.add(element.getText());
		}
		if(homePageMenuElements.equals(homePageElements)) {
			logger.logDebug("All Elements are displayed. " +homePageElements);
			test.log(Status.PASS, MarkupHelper.createLabel("All Elements are displayed. " +homePageElements, ExtentColor.GREEN));
			homeTabStatus = true;
		}else {
			homePageElements.removeAll(homePageMenuElements);
			logger.logDebug("Few Elements are not displayed. " +homePageElements);
			test.log(Status.FAIL, MarkupHelper.createLabel("Few Elements are not displayed or Extra Elements displayed: " +homePageElements, ExtentColor.RED));
			homeTabStatus = false;
		}
		return homeTabStatus;

	}

	// home page tab vlaidation for BP
	public boolean homePageTabValidation_BP(RemoteWebDriver driver) {
		boolean homeTabStatusBP = false;
		ArrayList<String> homePageMenuElements = cvList.homePageMenuitems_BP();
		ArrayList<String> homePageElements = new ArrayList<String>();
		List<WebElement> allElements = driver.findElements(By.xpath(HomePageXpathLocators.getHomeTabList()));
		for (WebElement element: allElements) {
			logger.logDebug("Tab Name: " +element.getText());
			homePageElements.add(element.getText());
		}
		if(homePageMenuElements.equals(homePageElements)) {
			logger.logDebug("All Elements are displayed. " +homePageElements);
			test.log(Status.PASS, MarkupHelper.createLabel("All Elements are displayed. " +homePageElements, ExtentColor.GREEN));
			homeTabStatusBP = true;
		}else {
			logger.logDebug("Few Elements are not displayed. " +homePageElements);
			test.log(Status.FAIL, MarkupHelper.createLabel("Few Elements are not displayed or Extra Elements displayed: " +homePageElements, ExtentColor.RED));
			homeTabStatusBP = false;
		}
		return homeTabStatusBP;

	}

	public boolean isJoHomePageLoaded(RemoteWebDriver driver) {
		boolean joHomePagestatus = false;
		try {
			List<WebElement> list = driver.findElements(By.cssSelector(HomePageXpathLocators.getRecentitems()));
			boolean myJobsStatus = ActionUtils.isElementPresent_LinkText_Driver(getDriver(), HomePageXpathLocators.getHome_myjobs());
			logger.logDebug("My Jobs Component Status: " +myJobsStatus);
			test.log(Status.INFO, MarkupHelper.createLabel("My Jobs Component Status: " +myJobsStatus, ExtentColor.BROWN));
			boolean homeAllStatus = ActionUtils.isElementPresent_LinkText_Driver(getDriver(), HomePageXpathLocators.getHome_all());
			logger.logDebug("All Component Status: " +homeAllStatus);
			test.log(Status.INFO, MarkupHelper.createLabel("All Component Status: " +homeAllStatus, ExtentColor.BROWN));
			boolean moreStatus = ActionUtils.isElementPresent_LinkText_Driver(getDriver(), HomePageXpathLocators.getMore());
			logger.logDebug("More Component Status: " +moreStatus);
			test.log(Status.INFO, MarkupHelper.createLabel("More Component Status: " +moreStatus, ExtentColor.BROWN));

			if(!list.isEmpty() && myJobsStatus && homeAllStatus && moreStatus) {
				logger.logDebug("RecentItems, MyJobs, All, More components are displayed as expected");
				joHomePagestatus = true;
			}else {
				logger.logDebug("Components are not displayed as expeced: My Jobs Component Status: " +myJobsStatus
						+ "All Component Status: " +homeAllStatus + "More Component Status: " +moreStatus);
				joHomePagestatus = false;
			}

		} catch (Exception e) {
			logger.logDebug("Exception occured at" + e.getMessage());
			joHomePagestatus = false;
		}
		return joHomePagestatus;
	}
}
