package p2.action

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.comcast.p2.test.P2Base;
import p2.Properties.JobcategoryInputParameters;
import p2.dataType.TestStepStatus;
import  p2.util.ActionUtils;
import  p2.util.CommonUtils;
import internal.GlobalVariable
import java.awt.AWTException
import p2.p2base.P2Base
public class BettermentJobAction extends P2Base{
	boolean flag;
	private static Logger logger = LogManager.getLogger(BettermentJobAction.class.getCanonicalName());
	public static boolean SubTypeOrWithout = false;
	public static String Jobtype = "";
	public static String Subtype = "";

	public void ClickonJobRequest(RemoteWebDriver driver) {
		//	System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor10Seconds();
		driver.findElement(By.linkText(JobcategoryInputParameters.getjobcreation_new())).click();
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getbetterment_nextbutton())).click();
		ActionUtils.waitFor3Seconds();
	}

	public void JobcategoryInputs(RemoteWebDriver driver) {
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_AerialMakeReady())).click();
		ActionUtils.waitFor3Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();
		ActionUtils.waitFor3Seconds();
	}

	/*
	 * public void JobcategoryBettermentsSpanReplacementInputs(RemoteWebDriver
	 * driver) { driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(0).click(); ActionUtils.waitFor2Seconds(); //
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getoption_Betterments_category())).click(); ActionUtils.waitFor1Seconds();
	 * driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(1).click(); ActionUtils.waitFor3Seconds();
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getjobtype_SpanReplacement())).click(); ActionUtils.waitFor3Seconds();
	 * driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(2).click(); ActionUtils.waitFor2Seconds();
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getsubtype_SpanReplacement_HFC())).click(); ActionUtils.waitFor3Seconds();
	 * driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton
	 * ())).click(); }
	 */
	public void selectAddress(RemoteWebDriver driver) {
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinputaddress())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinputaddress_click()))
				.sendKeys(JobcategoryInputParameters.getinputaddress_value());
		ActionUtils.waitFor1Seconds();
		// ActionUtils.waitFor3Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();
		ActionUtils.waitFor1Seconds();
	}

	/*
	 * public void validateJobDetails(RemoteWebDriver driver) throws AWTException {
	 * if
	 * (driver.findElement(By.cssSelector("input[class='field input']")).isDisplayed
	 * ()) { ActionUtils.waitFor1Seconds();
	 * driver.findElement(By.cssSelector("input[class='field input']")).sendKeys("")
	 * ; if
	 * (driver.findElement(By.cssSelector("textarea[class='slds-textarea textarea']"
	 * )).isDisplayed()) {
	 * driver.findElement(By.cssSelector("textarea[class='slds-textarea textarea']")
	 * ).click();
	 * driver.findElement(By.cssSelector("textarea[class='slds-textarea textarea']")
	 * ).sendKeys(""); if (driver.findElement(By.cssSelector(
	 * "input[class='slds-lookup__search-input slds-input leftPaddingClass input uiInput uiInputText uiInput--default uiInput--input']"
	 * )) .isDisplayed()) { ActionUtils.waitFor1Seconds(); if
	 * (driver.findElement(By.cssSelector("textarea[class='slds-textarea textarea']"
	 * )).isDisplayed()) { ActionUtils.waitFor1Seconds();
	 * driver.findElement(By.cssSelector("textarea[class='slds-textarea textarea']"
	 * )) .sendKeys("Automation job Creation Flow"); ActionUtils.waitFor1Seconds();
	 * if (driver.findElement(By.cssSelector(
	 * "input[class='slds-lookup__search-input slds-input leftPaddingClass input uiInput uiInputText uiInput--default uiInput--input']"
	 * )) .isDisplayed()) { ActionUtils.waitFor1Seconds(); JavascriptExecutor js =
	 * (JavascriptExecutor) getDriver();
	 * js.executeScript(HomePageXpathLocators.getScrollToBottom());
	 * ((JavascriptExecutor) getDriver()).executeScript("0", "200"); if
	 * (driver.findElements(By.cssSelector("input[class='slds-input']")).get(4).
	 * isDisplayed()) { ActionUtils.waitFor1Seconds(); if
	 * (driver.findElements(By.cssSelector("input[class='slds-input']")).get(5)
	 * .isDisplayed()) { ActionUtils.waitFor1Seconds(); } } } } } } }
	 *
	 * }
	 */
	public void provideJobDetails(RemoteWebDriver driver) throws AWTException {
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getneedByField())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getneedByField())).sendKeys(CommonUtils.endDate());
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommentsField())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommentsField()))
				.sendKeys(JobcategoryInputParameters.getcommentsField_value());
		ActionUtils.waitFor1Seconds();


		/* -----------> cifa look up value in Qa Env <----------------------
		 WebElement ele12 = driver.findElement(By.cssSelector("div[class='slds-select_container']"));
		 System.out.println("Element value is "+ele12.getText());
		 Actions actionslist = new Actions(driver);
		 actionslist.moveToElement(ele12).click().perform();
		 System.out.println("After scroll bar");
		 //System.out.println("test in progress---"+driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehouse())).getText());
		 /*WebElement element=driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehouse()));
		 ActionUtils.waitFor3Seconds();
		 element.click();
		 ActionUtils.waitFor3Seconds();
		 System.out.println("input parameter search---");
		 element.findElement(By.cssSelector("input[type='search']")).sendKeys("D04");
		 //System.out.println("test in progress"+driver.findElement(By.cssSelector(JobcategoryInputParameters.getcifawarehouse())).getText());
		 //cifa driver.findElement(By.cssSelector("span[class='slds-radio_faux']")).click();
		 */
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getexternalsysId())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getexternalsysId())).sendKeys(JobcategoryInputParameters.getexternalid_value());
		ActionUtils.waitFor1Seconds();



		WebElement ele = driver.findElements(By.cssSelector("div[class='slds-grid slds-wrap']")).get(0);
		System.out.println("Element value is " + ele.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslist = new Actions(driver);
		actionslist.moveToElement(ele).click().perform();
		System.out.println("after scroll bar");
		ActionUtils.waitFor1Seconds();
		System.out.println("before the cifa ware house");
		driver.findElements(By.cssSelector("input[type='search']")).get(3).click();
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[type='search']")).get(3)
				.sendKeys(JobcategoryInputParameters.getcifawarehouse_value());
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[type='search']")).get(3).sendKeys("4");
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.xpath("//*[@id=\"modal-content-id-1\"]/article/div/div[2]/div/div/div[4]/div[1]/div/div[2]/lightning-datatable/div[2]/div/div/div/table/tbody/tr/td[1]/lightning-primitive-cell-checkbox/span/label/span[1]")).click();
		ActionUtils.waitFor5Seconds();
		/*
		 * driver.findElement(By.cssSelector("input[type='number']")).click();
		 * ActionUtils.waitFor2Seconds();
		 * driver.findElement(By.cssSelector("input[type='number']")).sendKeys("2");
		 * ActionUtils.waitFor2Seconds();
		 */

		//		js.executeScript(HomePageXpathLocators.getScrollToBottom());
		//		((JavascriptExecutor) getDriver()).executeScript("0", "200");
		//		js.executeScript("window.scrollBy(0,300)", "");
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement lastele = driver.findElements(By.cssSelector("div[class='slds-grid slds-wrap']")).get(3);
		System.out.println("Element value is " + lastele.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslistele = new Actions(driver);
		actionslistele.moveToElement(lastele).click().perform();
		System.out.println("after scroll bar");
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(6).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(6)
				.sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value1());
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(7).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(7)
				.sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value2());
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(8).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(8)
				.sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value3());
		ActionUtils.waitFor1Seconds();
		scrollbartosavebutton(driver);
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).get(1).click();
		ActionUtils.waitFor3Seconds();
	}

	/* cifa ware house look up logic
	 public void provideJobDetails(RemoteWebDriver driver) throws AWTException {
	 try {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 ActionUtils.waitFor3Seconds();
	 driver.findElement(By.cssSelector(JobcategoryInputParameters.getneedByField())).click();
	 ActionUtils.waitFor1Seconds();
	 driver.findElement(By.cssSelector(JobcategoryInputParameters.getneedByField())).sendKeys(CommonUtils.endDate());
	 ActionUtils.waitFor1Seconds();
	 driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommentsField())).click();
	 ActionUtils.waitFor1Seconds();
	 driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommentsField()))
	 .sendKeys(JobcategoryInputParameters.getcommentsField_value());
	 ActionUtils.waitFor2Seconds();
	 cifa look up value in Qa Env
	 WebElement ele12 = driver.findElement(By.cssSelector("div[class='slds-select_container']"));
	 System.out.println("Element value is "+ele12.getText());
	 Actions actionslist = new Actions(driver);
	 actionslist.moveToElement(ele12).click().perform();
	 System.out.println("After scroll bar");
	 //System.out.println("test in progress---"+driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehouse())).getText());
	 /*WebElement element=driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehouse()));
	 ActionUtils.waitFor3Seconds();
	 element.click();
	 ActionUtils.waitFor3Seconds();
	 System.out.println("input parameter search---");
	 element.findElement(By.cssSelector("input[type='search']")).sendKeys("D04");
	 WebElement element=driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehouse()));
	 ActionUtils.waitFor3Seconds();
	 element.click();
	 ActionUtils.waitFor3Seconds();
	 element.findElement(By.cssSelector("input[class='slds-input']")).sendKeys("D0");
	 ActionUtils.waitFor3Seconds();
	 driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehouse())).sendKeys("4");
	 ActionUtils.waitFor3Seconds();
	 //System.out.println("test in progress"+driver.findElement(By.cssSelector(JobcategoryInputParameters.getcifawarehouse())).getText());
	 //cifa driver.findElement(By.cssSelector("span[class='slds-radio_faux']")).click();
	 driver.findElement(By.xpath(JobcategoryInputParameters.getcifawarehose_Select())).click();
	 ActionUtils.waitFor1Seconds();
	 WebElement ele = driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow()))
	 .get(6);
	 //	System.out.println("Element value is " + ele.getText());
	 ActionUtils.waitFor1Seconds();
	 Actions actionslist1 = new Actions(driver);
	 actionslist1.moveToElement(ele).click().perform();
	 //System.out.println("after scroll bar");
	 ActionUtils.waitFor1Seconds();
	 * driver.findElement(By.cssSelector("input[type='number']")).click();
	 * ActionUtils.waitFor2Seconds();
	 * driver.findElement(By.cssSelector("input[type='number']")).sendKeys("2");
	 * ActionUtils.waitFor2Seconds();
	 //		js.executeScript(HomePageXpathLocators.getScrollToBottom());
	 //		((JavascriptExecutor) getDriver()).executeScript("0", "200");
	 //		js.executeScript("window.scrollBy(0,300)", "");
	 //		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 js.executeScript("arguments[0].scrollIntoView();", ele);
	 driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(5).click();
	 ActionUtils.waitFor1Seconds();
	 driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(5)
	 .sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value1());
	 ActionUtils.waitFor1Seconds();
	 driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(6).click();
	 ActionUtils.waitFor1Seconds();
	 driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(6)
	 .sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value2());
	 ActionUtils.waitFor1Seconds();
	 driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(7).click();
	 ActionUtils.waitFor1Seconds();
	 driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(7)
	 .sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value3());
	 ActionUtils.waitFor1Seconds();
	 scrollbartosavebutton(driver);
	 ActionUtils.waitFor1Seconds();
	 driver.findElements(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).get(1).click();
	 ActionUtils.waitFor3Seconds();
	 }
	 catch(Exception e) {
	 System.out.println("exception occured"+e.getMessage());
	 }
	 }*/

	public void scrollbartosavebutton(RemoteWebDriver driver) {

		WebElement ele = driver.findElement(By.cssSelector(JobcategoryInputParameters.getscrolldown()));
		//	System.out.println("Element value is " + ele.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslist = new Actions(driver);
		actionslist.moveToElement(ele).click().perform();
		//	System.out.println("after scroll bar");
		ActionUtils.waitFor1Seconds();
	}

	public void verifyJobDetails(RemoteWebDriver driver) {
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getmore())).get(5).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.xpath(JobcategoryInputParameters.getjobDetails())).get(1).click();
		// driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobdetails())).click();
		// driver.findElements(By.cssSelector(JobcategoryInputParameters.getjobDetail_Select())).get(1).click();
		ActionUtils.waitFor2Seconds();

	}

	public  TestStepStatus verifyHighlightPanel(RemoteWebDriver driver) {
		TestStepStatus testStepStatus =new TestStepStatus();
		/*WebElement element = 	driver.findElement(By.cssSelector("input[title='Search Salesforce']"));
		 ((JavascriptExecutor) driver).executeScript(
		 "arguments[0].scrollIntoView(true);", element);*/
		driver.navigate().refresh();
		ActionUtils.waitFor10Seconds();
		System.out.println("Elements in the Highlight panel -"+driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(0).getText());
		System.out.println("Elements in the Highlight panel -"+driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(1).getText());
		System.out.println("Elements in the Highlight panel -"+driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(2).getText());
		System.out.println("Elements in the Highlight panel -"+driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(3).getText());
		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(0)
		.isDisplayed()) {
			System.out.println("Elements in the Highlight panel -"+driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(0).getText());
			logger.info("Category - Type - Sub Type Not loaded  in the Job page-->"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
					.get(0).isDisplayed());
			if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(1)
			.isDisplayed()) {
				logger.info("Description Not loaded  in the Job page-->"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
						.get(1).isDisplayed());
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(3)
				.getText().equals("Funding Request Status")) {
					logger.info("Funding Request Status  loaded  in the Job page-->" + driver
							.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
							.get(2).isDisplayed());
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
					.get(4).getText().equals("Status")) {
						flag = true;
						testStepStatus.setElementstatus("Highlight Panel Details loaded");
						testStepStatus.setElementName("Highlight Panel Details");
					} else {
						logger.info("Status Not loaded  in the Job page" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
								.get(4).isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("Status Not loaded");
						testStepStatus.setElementName("Status");
					}
				} else {
					logger.info("Funding Request Status Not loaded  in the Job page-->" + driver
							.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
							.get(2).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("Funding Request Status Not loaded");
					testStepStatus.setElementName("Funding Request Status");

				}
			} else {
				logger.info("Description Not loaded  in the Job page-->"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
						.get(1).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("Description Not loaded");
				testStepStatus.setElementName("Description");
			}

		} else {
			logger.info("Category - Type - Sub Type Not loaded  in the Job page-->"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
					.get(0).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("Category - Type - Sub Not loaded");
			testStepStatus.setElementName("Category - Type - Sub");
		}

		return testStepStatus;

	}
	/*public TestStepStatus verifyHighlightPanel(RemoteWebDriver driver) {
	 TestStepStatus testStepStatus = new TestStepStatus();
	 if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(0)
	 .isDisplayed()) {
	 if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(1)
	 .isDisplayed()) {
	 if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(3)
	 .getText().equals("Unfunded")) {
	 if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
	 .get(4).getText().equals("Opened")) {
	 flag = true;
	 testStepStatus.setElementstatus("Highlight Panel Details loaded");
	 testStepStatus.setElementName("Highlight Panel Details");
	 } else {
	 logger.info("Status Not loaded  in the Job page" + driver
	 .findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
	 .get(4).isDisplayed());
	 flag = false;
	 testStepStatus.setElementstatus("Status Not loaded");
	 testStepStatus.setElementName("Status");
	 }
	 } else {
	 logger.info("Funding Request Status Not loaded  in the Job page" + driver
	 .findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
	 .get(2).isDisplayed());
	 flag = false;
	 testStepStatus.setElementstatus("Funding Request Status Not loaded");
	 testStepStatus.setElementName("Funding Request Status");
	 }
	 } else {
	 logger.info("Description Not loaded  in the Job page"
	 + driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
	 .get(1).isDisplayed());
	 flag = false;
	 testStepStatus.setElementstatus("Description Not loaded");
	 testStepStatus.setElementName("Description");
	 }
	 } else {
	 logger.info("Category - Type - Sub Type Not loaded  in the Job page"
	 + driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
	 .get(0).isDisplayed());
	 flag = false;
	 testStepStatus.setElementstatus("Category - Type - Sub Not loaded");
	 testStepStatus.setElementName("Category - Type - Sub");
	 }
	 return testStepStatus;
	 }*/

	public boolean validateJobDetailsfields(RemoteWebDriver driver) {
		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(0)
		.isDisplayed()) {
			logger.info("JOb id loaded in the details page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(0)
					.isDisplayed());
			if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields())).get(0)
			.isDisplayed()) {
				logger.info("Owner loaded in the details page"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
						.get(0).isDisplayed());
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(3)
				.getAttribute("innerText").contains(CommonUtils.endDate())) {
					logger.info("Need by date loaded in the details page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(3).getAttribute("innerText"));
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
					.get(2).getAttribute("innerText").contains(JobcategoryInputParameters.getUnfunded_Text())) {
						logger.info("Funding Request Status in the details page" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
								.get(2).getAttribute("innerText"));
						if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
						.get(4).getAttribute("innerText")
						.contains(JobcategoryInputParameters.getDescription_check())) {
							logger.info("Description in the details page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(4).getAttribute("innerText"));
							if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(7).getAttribute("innerText")
							.contains(JobcategoryInputParameters.getcommentsField_value())) {
								logger.info("comments loaded in the details page" + driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(7).getAttribute("innerText"));
								if (driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
								.get(8).getAttribute("innerText")
								.contains(JobcategoryInputParameters.getcifawarehouse_value())) {
									logger.info("cifa loaded in the details page" + driver
											.findElements(
											By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
											.get(8).getAttribute("innerText"));
									if (driver
									.findElements(
									By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(9).getAttribute("innerText")
									.contains(JobcategoryInputParameters.getlaborZone())) {
										logger.info("Labor Zone loaded in the details page" + driver
												.findElements(By
												.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
												.get(9).getAttribute("innerText"));
										flag = true;

									} else {
										logger.info("Labor Zone  Not loaded in the details page" + driver
												.findElements(By
												.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
												.get(13).isDisplayed());
										flag = false;

									}
								} else {
									logger.info("cifa Not loaded in the details page" + driver
											.findElements(
											By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
											.get(11).isDisplayed());
									flag = false;
								}
							} else {
								logger.info("comments Warehouse loaded in the details page" + driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(10).isDisplayed());
								flag = false;
							}
						} else {
							logger.info("Description Not in the details page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(7).isDisplayed());
							flag = false;
						}
					} else {
						logger.info("Funding Request Status  Not in the details page" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
								.get(2).isDisplayed());
						flag = false;

					}
				} else {
					logger.info("Need by date Not loaded in the details page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(4).isDisplayed());
					flag = false;
				}
			} else {
				logger.info("Owner Not loaded in the details page"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(1)
						.isDisplayed());
				flag = false;
			}
		} else {
			logger.info("JOb id Not loaded in the details page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(0)
					.isDisplayed());
			flag = false;

		}
		return flag;
	}

	public boolean verifyclassification(RemoteWebDriver driver) {
		if (SubTypeOrWithout == true) {
			return verifyclassificationBettermentsSubtype(driver);
		} else {
			return verifyclassificationBettermentsWithoutSubtype(driver);
		}
	}

	public boolean verifyclassificationBettermentsSubtype(RemoteWebDriver driver) {
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(0)
				.getAttribute("innerText"));

		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(3)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(4)
				.getAttribute("innerText"));

		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(7)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(8)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(9)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(49).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(51).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(52).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(53).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(54).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(55).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(56).getAttribute("innerText"));

		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(57).getAttribute("innerText"));

		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(0).getAttribute("innerText") + " dummy");

		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(37).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(35).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(36).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(38).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(39).getAttribute("innerText") + " dummy");
		boolean main = false;
		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields())).get(36)
		.getAttribute("innerText").equals("Betterments")) {
			logger.info("Job category in the details page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
					.get(36).getAttribute("innerText"));
			if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields())).get(37)
			.getAttribute("innerText").equals(BettermentJobAction.Jobtype)) {
				logger.info("JobType in the details page"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
						.get(37).getAttribute("innerText"));
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(66)
				.getAttribute("innerText").equals(BettermentJobAction.Subtype)) {
					logger.info("JobSubType in the details page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(66).getAttribute("innerText"));
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(68)
					.isDisplayed()) {
						logger.info("Division in the details page"
								+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
								.get(68).isDisplayed());
						if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
						.get(69).isDisplayed()) {
							logger.info("Region in the details page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(69).isDisplayed());
							if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(70).isDisplayed()) {
								logger.info("Market in the details page" + driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(70).isDisplayed());
								if (driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
								.get(71).isDisplayed()) {
									logger.info("Area in the details page" + driver
											.findElements(
											By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
											.get(71).isDisplayed());
									if (driver
									.findElements(By.cssSelector(
									JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
									.get(38).isDisplayed()) {

										logger.info("Default Spa in the details page" + driver
												.findElements(By.cssSelector(
												JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
												.get(38).isDisplayed());
										if (driver
										.findElements(By
										.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(72).isDisplayed()) {
											logger.info("Principle in the details page" + driver
													.findElements(By.cssSelector(
													JobcategoryInputParameters.getvalidatejobfields()))
													.get(72).isDisplayed());
											if (driver
											.findElements(By.cssSelector(
											JobcategoryInputParameters.getvalidatejobfields()))
											.get(73).isDisplayed()) {
												logger.info("System in the details page" + driver
														.findElements(By.cssSelector(
														JobcategoryInputParameters.getvalidatejobfields()))
														.get(73).isDisplayed());
												if (driver
												.findElements(By.cssSelector(
												JobcategoryInputParameters.getvalidatejobfields()))
												.get(74).isDisplayed()) {
													logger.info("Agent in the details page" + driver
															.findElements(By.cssSelector(
															JobcategoryInputParameters.getvalidatejobfields()))
															.get(74).isDisplayed());
													if (driver
													.findElements(By.cssSelector(JobcategoryInputParameters
													.getvalidateReadOnlyJobFields()))
													.get(40).isDisplayed()) {
														logger.info("Created By in the details page" + driver
																.findElements(By.cssSelector(JobcategoryInputParameters
																.getvalidateReadOnlyJobFields()))
																.get(40).isDisplayed());
														if (driver
														.findElements(By.cssSelector(JobcategoryInputParameters
														.getvalidateReadOnlyJobFields()))
														.get(39).isDisplayed()) {
															logger.info("Last Modified  By in the details page" + driver
																	.findElements(
																	By.cssSelector(JobcategoryInputParameters
																	.getvalidateReadOnlyJobFields()))
																	.get(39).isDisplayed());
															flag = true;
														} else {
															logger.info(
																	"Last Modified  By Not loaded  in the details page"
																	+ driver.findElements(By.cssSelector(
																	JobcategoryInputParameters
																	.getvalidateReadOnlyJobFields()))
																	.get(39).isDisplayed());
															flag = false;
														}
													} else {
														logger.info("Created By Not loaded in the details page" + driver
																.findElements(By.cssSelector(JobcategoryInputParameters
																.getvalidateReadOnlyJobFields()))
																.get(40).isDisplayed());
														flag = false;
													}
												} else {
													logger.info("Agent Not loaded  in the details page" + driver
															.findElements(By.cssSelector(
															JobcategoryInputParameters.getvalidatejobfields()))
															.get(74).isDisplayed());
													flag = false;
												}
											} else {
												logger.info("System Not loaded  in the details page" + driver
														.findElements(By.cssSelector(
														JobcategoryInputParameters.getvalidatejobfields()))
														.get(73).isDisplayed());
												flag = false;
											}
										} else {
											logger.info("Principle Not loaded  in the details page" + driver
													.findElements(By.cssSelector(
													JobcategoryInputParameters.getvalidatejobfields()))
													.get(72).isDisplayed());
											flag = false;
										}
									} else {
										logger.info("Default Spa Not loaded  in the details page" + driver
												.findElements(By.cssSelector(
												JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
												.get(38).isDisplayed());
										flag = false;
									}
								} else {
									logger.info("Area Not loaded  in the details page" + driver
											.findElements(
											By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
											.get(71).isDisplayed());
									flag = false;
								}
							} else {
								logger.info("Market Not loaded  in the details page" + driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(70).isDisplayed());
								flag = false;
							}
						} else {
							logger.info("Region Not loaded  in the details page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(69).isDisplayed());
							flag = false;
						}
					} else {
						logger.info("Division Not loaded  in the details page"
								+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
								.get(68).isDisplayed());
						flag = false;
					}
				} else {
					logger.info("JobSubType  Not loaded  in the details page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(66).isDisplayed());
					flag = false;
				}
			} else {
				logger.info("Job Type Not loaded in the details page"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
						.get(37).isDisplayed());
				flag = false;
			}

		} else {
			logger.info("Job Category  Not loaded  in the details page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
					.get(36).isDisplayed());
			flag = false;
		}

		return flag;
	}

	public boolean verifyclassificationBettermentsWithoutSubtype(RemoteWebDriver driver) {
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(0)
				.getAttribute("innerText"));

		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(3)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(4)
				.getAttribute("innerText"));

		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(7)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(8)
				.getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(9)
				.getAttribute("innerText"));
		// System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(66).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(68).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(69).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(70).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(71).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(72).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(73).getAttribute("innerText"));
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(74).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(0).getAttribute("innerText") + " dummy");
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(38).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(37).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(36).getAttribute("innerText"));
		System.out
				.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
				.get(39).getAttribute("innerText") + " dummy");
		boolean main = false;
		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields())).get(36)
		.getAttribute("innerText").equals("Betterments")) {
			logger.info("Job category in the details page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
					.get(36).getAttribute("innerText"));
			if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields())).get(37)
			.getAttribute("innerText").equals(BettermentJobAction.Jobtype)) {
				logger.info("JobType in the details page"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
						.get(37).getAttribute("innerText"));
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(68)
				.isDisplayed()) {
					logger.info("Division in the details page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(68).isDisplayed());
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(69)
					.isDisplayed()) {
						logger.info("Region in the details page"
								+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
								.get(69).isDisplayed());
						if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
						.get(70).isDisplayed()) {
							logger.info("Market in the details page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(70).isDisplayed());
							if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(71).isDisplayed()) {
								logger.info("Area in the details page" + driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(71).isDisplayed());
								if (driver
								.findElements(By
								.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
								.get(38).isDisplayed()) {

									logger.info("Default Spa in the details page" + driver
											.findElements(By.cssSelector(
											JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
											.get(38).isDisplayed());
									if (driver
									.findElements(
									By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(72).isDisplayed()) {
										logger.info("Principle in the details page" + driver
												.findElements(By
												.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
												.get(72).isDisplayed());
										if (driver
										.findElements(By
										.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(73).isDisplayed()) {
											logger.info("System in the details page" + driver
													.findElements(By.cssSelector(
													JobcategoryInputParameters.getvalidatejobfields()))
													.get(73).isDisplayed());
											if (driver
											.findElements(By.cssSelector(
											JobcategoryInputParameters.getvalidatejobfields()))
											.get(74).isDisplayed()) {
												logger.info("Agent in the details page" + driver
														.findElements(By.cssSelector(
														JobcategoryInputParameters.getvalidatejobfields()))
														.get(74).isDisplayed());
												if (driver
												.findElements(By.cssSelector(JobcategoryInputParameters
												.getvalidateReadOnlyJobFields()))
												.get(40).isDisplayed()) {
													logger.info("Created By in the details page" + driver
															.findElements(By.cssSelector(JobcategoryInputParameters
															.getvalidateReadOnlyJobFields()))
															.get(40).isDisplayed());
													if (driver
													.findElements(By.cssSelector(JobcategoryInputParameters
													.getvalidateReadOnlyJobFields()))
													.get(39).isDisplayed()) {
														logger.info("Last Modified  By in the details page" + driver
																.findElements(By.cssSelector(JobcategoryInputParameters
																.getvalidateReadOnlyJobFields()))
																.get(39).isDisplayed());
														flag = true;
													} else {
														logger.info("Last Modified  By Not loaded  in the details page"
																+ driver.findElements(
																By.cssSelector(JobcategoryInputParameters
																.getvalidateReadOnlyJobFields()))
																.get(39).isDisplayed());
														flag = false;
													}
												} else {
													logger.info("Created By Not loaded in the details page" + driver
															.findElements(By.cssSelector(JobcategoryInputParameters
															.getvalidateReadOnlyJobFields()))
															.get(40).isDisplayed());
													flag = false;
												}
											} else {
												logger.info("Agent Not loaded  in the details page" + driver
														.findElements(By.cssSelector(
														JobcategoryInputParameters.getvalidatejobfields()))
														.get(74).isDisplayed());
												flag = false;
											}
										} else {
											logger.info("System Not loaded  in the details page" + driver
													.findElements(By.cssSelector(
													JobcategoryInputParameters.getvalidatejobfields()))
													.get(73).isDisplayed());
											flag = false;
										}
									} else {
										logger.info("Principle Not loaded  in the details page" + driver
												.findElements(By
												.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
												.get(72).isDisplayed());
										flag = false;
									}
								} else {
									logger.info("Default Spa Not loaded  in the details page" + driver
											.findElements(By.cssSelector(
											JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
											.get(38).isDisplayed());
									flag = false;
								}
							} else {
								logger.info("Area Not loaded  in the details page" + driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
										.get(71).isDisplayed());
								flag = false;
							}
						} else {
							logger.info("Market Not loaded  in the details page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
									.get(70).isDisplayed());
							flag = false;
						}
					} else {
						logger.info("Region Not loaded  in the details page"
								+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
								.get(69).isDisplayed());
						flag = false;
					}
				} else {
					logger.info("Division Not loaded  in the details page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
							.get(68).isDisplayed());
					flag = false;
				}

			} else {
				logger.info("JobType Not loaded in the details page"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
						.get(37).isDisplayed());
				flag = false;
			}

		} else {
			logger.info("Job Category  Not loaded  in the details page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidateReadOnlyJobFields()))
					.get(36).isDisplayed());
			flag = false;
		}

		return flag;
	}

	public void JobUploadAction(RemoteWebDriver driver) {
		ActionUtils.waitFor3Seconds();
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnextbutton())).click();
		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor3Seconds();
	}

	public boolean verifyValuesInJobDetails(RemoteWebDriver driver) {

		boolean flag = false;
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields())).get(119).isDisplayed();
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(17).isDisplayed());
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(17).getText());
		System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getvalidatejobfields()))
				.get(18).getText());
		return flag;

	}

	public void Job_Betterments_AerialMakeReady_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_AerialMakeReady())).click();
		ActionUtils.waitFor2Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_MDURewiring_HFC_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();
		Jobtype=driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_MDURewiring())).getText();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_MDURewiring())).click();
		ActionUtils.waitFor1Seconds();

		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();

		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_MDURewiring_HFC())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();


	}

	public void Job_Betterments_SpanReplacement_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_SpanReplacements())).click();
		ActionUtils.waitFor2Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_LineExtension_Coax_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_LineExtension())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_LineExtension_Coax())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_MDURewiring_FTTP_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_MDURewiring())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_MDURewiring_FTTP())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_MDURewiring_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_MDURewiring())).click();
		ActionUtils.waitFor2Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_LineExtension_Coax_Fiber_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_LineExtension())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_LineExtension_Coax_Fiber())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_LineExtension_Fiber_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_LineExtension())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_LineExtension_Fiber())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_LineExtension_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_LineExtension())).click();
		ActionUtils.waitFor2Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_AerialMakeReady_PoleTransfers_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_AerialMakeReady())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_AerialMakeReady_PoleTransfers()))
				.click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_ForcedRelocates_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_ForcedRelocates())).click();
		ActionUtils.waitFor2Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_ForcedRelocates_Reimbursable_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_ForcedRelocates())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_ForcedRelocates_Reimbursable()))
				.click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_ForcedRelocates_NonReimbursable_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_ForcedRelocates())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsubtype_ForcedRelocates_NonReimbursable()))
				.click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void Job_Betterments_ManholeReplacement_Select(RemoteWebDriver driver) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoption_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobtype_ManholeReplacement())).click();
		ActionUtils.waitFor2Seconds();

		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}


}
