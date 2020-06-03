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
import p2.p2base.P2Base
import internal.GlobalVariable

import java.awt.AWTException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


//import p2.p2base.P2Base
import p2.Properties.JobcategoryInputParameters;
import p2.dataType.TestStepStatus;
import  p2.util.ActionUtils;
import  p2.util.CommonUtils;


public class CommercialJobActionEFibre extends P2Base{
	boolean flag;
	private static Logger logger = LogManager.getLogger(BettermentJobAction.class.getCanonicalName());
	public static boolean SubTypeOrWithout = false;
	public static String Jobtype = "";
	public static String Subtype = "";

	public void ClickonJobRequest(RemoteWebDriver driver) {
		System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor5Seconds();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.linkText(JobcategoryInputParameters.getjobcreation_new())).click();
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnextbutton())).click();
		ActionUtils.waitFor2Seconds();
	}

	public void JobcategoryInputs(RemoteWebDriver driver) {
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

	/*
	 * public void JobcategoryBettermentsSpanReplacementInputs(RemoteWebDriver
	 * driver) { driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(0).click(); ActionUtils.waitFor1Seconds(); //
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getoption_Betterments_category())).click(); ActionUtils.waitFor5Seconds();
	 * driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(1).click(); ActionUtils.waitFor3Seconds();
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getjobtype_SpanReplacement())).click(); ActionUtils.waitFor3Seconds();
	 * driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(2).click(); ActionUtils.waitFor1Seconds();
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getsubtype_SpanReplacement_HFC())).click(); ActionUtils.waitFor3Seconds();
	 * driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton
	 * ())).click(); }
	 */
	public void selectAddress(RemoteWebDriver driver) {
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinputaddress())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinputaddress_click()))
				.sendKeys(JobcategoryInputParameters.getinputaddress_value());
		ActionUtils.waitFor2Seconds();
		// ActionUtils.waitFor3Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();
		ActionUtils.waitFor1Seconds();
	}

	public void provideJobDetails(RemoteWebDriver driver, String subtype) throws AWTException {
		System.out.println("Entered into the Provide job details");
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinitiatedBy())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinitiatedBy()))
				.sendKeys(JobcategoryInputParameters.getintiatedby_value());
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinitiatedByEmail())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getinitiatedByEmail()))
				.sendKeys(JobcategoryInputParameters.getintiatedbyid_value());
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getExternalid())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getExternalid())).sendKeys("1234");
		ActionUtils.waitFor1Seconds();
		WebElement ele = driver.findElement(By.cssSelector(JobcategoryInputParameters.getsitedevelopmentpropname()));
		System.out.println("Element value is " + ele.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslist = new Actions(driver);
		actionslist.moveToElement(ele).click().perform();
		System.out.println("After scroll bar");
		ActionUtils.waitFor1Seconds();
		JavascriptExecutor js = driver;

		js.executeScript("arguments[0].scrollIntoView();", ele);
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcustomername())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcustomername()))
				.sendKeys(JobcategoryInputParameters.getCustomernamevalue());
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsitedevelopmentpropname())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getsitedevelopmentpropname()))
				.sendKeys(JobcategoryInputParameters.getSite_Development_value());
		ActionUtils.waitFor1Seconds();
		WebElement element = driver.findElement(By.cssSelector(JobcategoryInputParameters.getlocalcontactname()));
		System.out.println("Element value is " + element.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslist1 = new Actions(driver);
		actionslist1.moveToElement(element).click().perform();
		System.out.println("After scroll bar");
		ActionUtils.waitFor3Seconds();
		JavascriptExecutor js1 = driver;

		js1.executeScript("arguments[0].scrollIntoView();", element);
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getlocalcontactname())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getlocalcontactname()))
				.sendKeys(JobcategoryInputParameters.getcustomer_Contact_value());
		ActionUtils.waitFor1Seconds();

		/*
		 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
		 * getlocalcontactemail())).click(); ActionUtils.waitFor1Seconds();
		 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
		 * getlocalcontactemail())).sendKeys(JobcategoryInputParameters.
		 * getcustomer_contact_email_value()); ActionUtils.waitFor2Seconds();
		 */

		driver.findElements(By.cssSelector(JobcategoryInputParameters.getlocalcontactphone())).get(16).sendKeys("123");
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getlocalcontactphone())).get(17).sendKeys("456");
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getlocalcontactphone())).get(18).sendKeys("7890");

		driver.findElements(By.cssSelector(JobcategoryInputParameters.getCustomerdropdown())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getoktoContact())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getCustomerdropdown())).get(1).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getDonotContact())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getneedByField())).get(1).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getneedByField())).get(1)
				.sendKeys(CommonUtils.endDate());
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommentsField())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommentsField()))
				.sendKeys(JobcategoryInputParameters.getcommentsField_value());
		ActionUtils.waitFor1Seconds();

		WebElement element1 = driver
				.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(20);
		System.out.println("Element value is " + element1.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslist2 = new Actions(driver);
		actionslist2.moveToElement(element1).click().perform();
		System.out.println("After scroll bar");
		ActionUtils.waitFor1Seconds();
		/*
		 * JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 *
		 * js1.executeScript("arguments[0].scrollIntoView();", element1);
		 */ ActionUtils.waitFor1Seconds();

		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(20)
				.sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value1());
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(21)
				.sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value2());
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.gettotalPrePostCalcJobFlow())).get(22)
				.sendKeys(JobcategoryInputParameters.gettotalPrePostCalcJobFlow_value3());
		ActionUtils.waitFor2Seconds();
		WebElement element2 = driver.findElements(By.cssSelector("div[class='slds-grid slds-wrap']")).get(12);
		ActionUtils.waitFor3Seconds();
		Actions actionslist3 = new Actions(driver);
		actionslist3.moveToElement(element2).click().perform();
		System.out.println("At cifa");
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[type='search']")).get(3).click();
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[type='search']")).get(3)
				.sendKeys(JobcategoryInputParameters.getcifawarehouse_value());
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[type='search']")).get(3).sendKeys("4");
		ActionUtils.waitFor5Seconds();

		driver.findElement(By.cssSelector("span[class='slds-radio_faux']")).click();
		// driver.findElement(By.xpath("//*[@id=\"modal-content-id-1\"]/article/div/div[2]/div/div/div[4]/div[1]/div/div[2]/lightning-datatable/div[2]/div/div/div/table/tbody/tr/td[1]/lightning-primitive-cell-checkbox/span/label/span[1]")).click();
		ActionUtils.waitFor5Seconds();

		// scrollbartosavebutton(driver);
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).get(1).click();
		ActionUtils.waitFor10Seconds();

	}

	public void connections(RemoteWebDriver driver) {

		driver.findElement(
				By.cssSelector("input[class='slds-input input uiInput uiInputText uiInput--default uiInput--input']"))
				.click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(
				By.cssSelector("input[class='slds-input input uiInput uiInputText uiInput--default uiInput--input']"))
				.sendKeys("connection_1");
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector("select[class='slds-select']")).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector("option[value='10']")).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.xpath("//*[@id=\"modal-content-id-1\"]/article/div/div[2]/div/div/div[2]/button"))
				.click();
		ActionUtils.waitFor5Seconds();
		// driver.findElement(By.xpath(JobcategoryInputParameters.getnextbutton())).click();

	}

	public void uploadnext(RemoteWebDriver driver) {
		// slds-button slds-button_brand
		ActionUtils.waitFor2Seconds();
		// driver.findElement(By.xpath("//*[@id=\"modal-content-id-1\"]/article/div/div[2]/div/div/div[2]/button")).click();
		// nextbutton=//button[@class='slds-button slds-button_brand']
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		// driver.findElement(By.xpath("input[@type='button']")).click();
		ActionUtils.waitFor5Seconds();

	}

	public void scrollbartosavebutton(RemoteWebDriver driver) {

		WebElement ele = driver.findElement(By.cssSelector(JobcategoryInputParameters.getscrolldown()));
		System.out.println("Element value is " + ele.getText());
		ActionUtils.waitFor1Seconds();
		Actions actionslist = new Actions(driver);
		actionslist.moveToElement(ele).click().perform();
		System.out.println("after scroll bar");
		ActionUtils.waitFor1Seconds();
	}

	public void verifyJobDetails(RemoteWebDriver driver) {
		ActionUtils.waitFor5Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getmore())).get(5).click();
		ActionUtils.waitFor5Seconds();
		driver.findElements(By.xpath(JobcategoryInputParameters.getjobDetails())).get(1).click();
		// driver.findElement(By.cssSelector(JobcategoryInputParameters.getjobdetails())).click();
		// driver.findElements(By.cssSelector(JobcategoryInputParameters.getjobDetail_Select())).get(1).click();
		ActionUtils.waitFor1Seconds();

	}

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

	public boolean verifyHighlightPanel(RemoteWebDriver driver) {
		driver.navigate().refresh();
		ActionUtils.waitFor5Seconds();
		System.out.println(driver.findElements(By.cssSelector("div[class='slds-form-element__static slds-truncate']"))
				.get(0).getText());
		System.out.println(driver.findElements(By.cssSelector("div[class='slds-form-element__static slds-truncate']"))
				.get(1).getText());
		System.out.println(driver.findElements(By.cssSelector("div[class='slds-form-element__static slds-truncate']"))
				.get(2).getText());
		System.out.println(driver.findElements(By.cssSelector("div[class='slds-form-element__static slds-truncate']"))
				.get(3).getText());
		System.out.println(driver.findElements(By.cssSelector("div[class='slds-form-element__static slds-truncate']"))
				.get(4).getText());
		System.out.println(driver.findElements(By.cssSelector("div[class='slds-form-element__static slds-truncate']"))
				.get(5).getText());

		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelFieldTextArea()))
				.get(0).isDisplayed()) {
			if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelFieldTextArea()))
					.get(1).getText().contains(JobcategoryInputParameters.getUnfunded())) {
				if (driver
						.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelFieldTextArea()))
						.get(2).getText().contains(JobcategoryInputParameters.getOpened())) {
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
							.get(0).isDisplayed()) {
						if (driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
								.get(1).isDisplayed()) {
							flag = true;
						} else {
							logger.info("Description Not loaded  in the Job page" + driver
									.findElements(
											By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
									.get(1).isDisplayed());
							flag = false;
						}
					} else {
						logger.info("Job ID Not loaded  in the Job page" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
								.get(0).isDisplayed());
						flag = false;
					}

				} else {
					logger.info("Status Not loaded  in the Job page" + driver
							.findElements(
									By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelFieldTextArea()))
							.get(2).isDisplayed());
					flag = false;

				}
			} else {
				logger.info("Funding Status Not loaded  in the Job page" + driver
						.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelFieldTextArea()))
						.get(1).isDisplayed());
				flag = false;
			}

		} else {
			logger.info("Job Type Not loaded  in the Job page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
							.get(1).isDisplayed());
			flag = false;
		}

		return flag;

	}

	public static TestStepStatus jobActionButtonValidation(RemoteWebDriver driver) {
		boolean flag = false;
		TestStepStatus testStepStatus = new TestStepStatus();
		System.out.println("values in the compact layout is--"
				+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getjobActionButtonValidation())).get(0)
						.getText());
		if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getedit_compactlayot())).getText()
				.equals(JobcategoryInputParameters.getEdit())) {
			if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getchangedate_compactlayot())).getText()
					.equals(JobcategoryInputParameters.getChangeDate())) {
				if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getMaterials_compactlayot())).getText()
						.equals(JobcategoryInputParameters.getAddMaterials())) {
					if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getContract_compactlayot()))
							.getText().equals(JobcategoryInputParameters.getAddContractLabor())) {
						if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getFootage_compactlayot()))
								.getText().equals(JobcategoryInputParameters.getAddConstructedFootage())) {
							if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getHold_compactlayot()))
									.getText().equals(JobcategoryInputParameters.getHold_Unhold())) {
								if (driver
										.findElement(By.cssSelector(JobcategoryInputParameters.getclose_compactlayot()))
										.getText().equals(JobcategoryInputParameters.getClose())) {
									if (driver
											.findElement(By
													.cssSelector(JobcategoryInputParameters.getapproval_compactlayot()))
											.getText().equals(JobcategoryInputParameters.getSubmit_for_Approval())) {
										if (driver
												.findElement(By.cssSelector(
														JobcategoryInputParameters.getcancel_compactlayot()))
												.getText().equals(JobcategoryInputParameters.getCancel())) {
											testStepStatus.setElementstatus("All Job level Action Buttons loaded");
											testStepStatus.setElementName("All Job level Action Buttons");
										} else {
											logger.info("Cancel Button Not loaded  in the Job page" + driver
													.findElement(By.cssSelector(
															JobcategoryInputParameters.getcancel_compactlayot()))
													.isDisplayed());
											flag = false;
											testStepStatus.setElementstatus("Cancel Button Not loaded");
											testStepStatus.setElementName("Cancel Button");
										}
									} else {
										logger.info("Submit for Approval Button Not loaded  in the Job page" + driver
												.findElement(By.cssSelector(
														JobcategoryInputParameters.getapproval_compactlayot()))
												.isDisplayed());
										flag = false;
										testStepStatus.setElementstatus("Submit for Approval Button Not loaded");
										testStepStatus.setElementName("Submit for Approval Button");
									}
								} else {
									logger.info("Close Button Not loaded  in the Job page" + driver
											.findElement(
													By.cssSelector(JobcategoryInputParameters.getclose_compactlayot()))
											.isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("Close Button Not loaded");
									testStepStatus.setElementName("Close Button");
								}
							} else {
								logger.info("Hold/Unhold Not loaded  in the Job page" + driver
										.findElement(By.cssSelector(JobcategoryInputParameters.getHold_compactlayot()))
										.isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("Hold/Unhold Button Not loaded");
								testStepStatus.setElementName("Hold/Unhold Button");
							}
						} else {
							logger.info("Add Constructed Footage Button Not loaded  in the Job page" + driver
									.findElement(By.cssSelector(JobcategoryInputParameters.getFootage_compactlayot()))
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("Add Constructed Footage Button Not loaded");
							testStepStatus.setElementName("Add Constructed Footage Button");
						}
					} else {
						logger.info("Add Contract Labor Button Not loaded  in the Job page" + driver
								.findElement(By.cssSelector(JobcategoryInputParameters.getContract_compactlayot()))
								.isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("Add Contract Labor Button Not loaded");
						testStepStatus.setElementName("Add Contract Labor Button");
					}

				} else {
					logger.info("Add Materials Button Not loaded  in the Job page"
							+ driver.findElement(By.cssSelector(JobcategoryInputParameters.getMaterials_compactlayot()))
									.isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("Add Materials Button Not loaded");
					testStepStatus.setElementName("Add Materials Button");

				}
			} else {
				logger.info("Change Date Button Not loaded  in the Job page"
						+ driver.findElement(By.cssSelector(JobcategoryInputParameters.getchangedate_compactlayot()))
								.isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("Change Date Button Not loaded");
				testStepStatus.setElementName("Change Date Button");
			}

		} else {
			logger.info("Edit Button Not loaded  in the Job page" + driver
					.findElement(By.cssSelector(JobcategoryInputParameters.getedit_compactlayot())).isDisplayed());
			flag = false;
			// testStepStatus.setflag(flag);
			testStepStatus.setElementstatus("Edit Button Not loaded");
			testStepStatus.setElementName("Edit Button");

		}

		return testStepStatus;

	}

	public void JobUploadAction(RemoteWebDriver driver) {
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnextbutton())).click();
		ActionUtils.waitFor3Seconds();
	}

	public boolean verifyQuickActionButtons(RemoteWebDriver driver) {
		System.out.println("Quick action button validation for task level");
		ActionUtils.waitFor3Seconds();
		// ActionUtils.waitFor10Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getp2task_checkbox())).get(1).click();

		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(0)
				.isDisplayed()) {
			System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
					.get(0).getAttribute("innerText"));
			System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
					.get(1).getAttribute("innerText"));
			System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
					.get(2).getAttribute("innerText"));
			System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
					.get(3).getAttribute("innerText"));
			System.out.println(
					driver.findElement(By.cssSelector(JobcategoryInputParameters.getapprovebutton())).getText());
			System.out.println(driver.findElements(By.cssSelector(JobcategoryInputParameters.getnotRequiredButton()))
					.get(0).getAttribute("innerText"));
			if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getassignbutton())).isDisplayed()) {
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(1)
						.isDisplayed()) {
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(2)
							.isDisplayed()) {
						if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
								.get(3).isDisplayed()) {
							if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getapprovebutton()))
									.isDisplayed()) {
								ActionUtils.waitFor1Seconds();
								if (driver
										.findElements(By.cssSelector(JobcategoryInputParameters.getnotRequiredButton()))
										.get(0).isDisplayed()) {
									flag = true;
								} else {
									logger.info("Not Required Button Not loaded  in the Job page" + driver
											.findElements(
													By.cssSelector(JobcategoryInputParameters.getnotRequiredButton()))
											.get(4).isDisplayed());
									flag = false;

								}
							} else {
								logger.info("Approve Button Not loaded  in the Job page" + driver
										.findElement(By.cssSelector(JobcategoryInputParameters.getapprovebutton()))
										.isDisplayed());
								flag = false;

							}
						} else {
							logger.info("ChangeBP/Ig Button Not loaded  in the Job page" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
									.get(3).isDisplayed());
							flag = false;
						}
					} else {
						logger.info("ChangeDate Button Not loaded  in the Job page" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(2)
								.isDisplayed());
						flag = false;
					}

				} else {
					logger.info("Schedule Date Button Not loaded  in the Job page"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getapprovebutton())).get(1)
									.isDisplayed());
					flag = false;

				}
			} else {
				logger.info("AssignBp/IG Button Not loaded  in the Job page" + driver
						.findElement(By.cssSelector(JobcategoryInputParameters.getassignbutton())).isDisplayed());
				flag = false;
			}

		} else {
			logger.info("New  Button Not loaded  in the Job page"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(0)
							.isDisplayed());
			flag = false;
		}

		return flag;

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

	/*
	 *
	 * public void Job_Commercial_WithoutSubtype(RemoteWebDriver driver, String
	 * jobType) { driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(0).click(); ActionUtils.waitFor1Seconds();
	 * driver.findElement(By.cssSelector(JobcategoryInputParameters.
	 * getcommercial_category())).click(); ActionUtils.waitFor1Seconds();
	 * driver.findElements(By.cssSelector(JobcategoryInputParameters.
	 * getcategory_select())).get(1).click(); ActionUtils.waitFor1Seconds();
	 * driver.findElement(By.cssSelector(jobType)).click();
	 *
	 * ActionUtils.waitFor1Seconds();
	 *
	 *
	 * driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton
	 * ())).click();
	 *
	 * }
	 */
	public void Job_Commercial_WithSubtype(RemoteWebDriver driver, String jobType, String subtype) {
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(0).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(JobcategoryInputParameters.getcommercial_category())).click();
		ActionUtils.waitFor1Seconds();
		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(1).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.cssSelector(jobType)).click();
		ActionUtils.waitFor1Seconds();

		driver.findElements(By.cssSelector(JobcategoryInputParameters.getcategory_select())).get(2).click();
		ActionUtils.waitFor1Seconds();

		driver.findElement(By.cssSelector(subtype)).click();
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.xpath(JobcategoryInputParameters.getnext_categorybutton())).click();

	}

	public void SurveyPresentValidation(RemoteWebDriver driver) throws Exception {
		ActionUtils.waitFor10Seconds();
		System.out.println("Survey job started");
		// driver.navigate().refresh();
		// System.out.println("Page Refreshed");
		ActionUtils.waitFor10Seconds();
		System.out.println(
				driver.findElement(By.xpath("//*/div/div/footer/div/div/table/tbody/tr[1]/td[2]/div")).getText());
		if (driver.findElement(By.xpath("//*/div/div/footer/div/div/table/tbody/tr[1]/td[2]/div")).getText()
				.trim() != "Survey") {
			CreateNewTaskAction(driver, "Survey", "Survey");

		} else {
			System.out.println("survey start");
			ActionUtils.waitFor10Seconds();
			System.out.println(
					driver.findElement(By.xpath("//*/div/div/footer/div/div/table/tbody/tr[1]/td[1]/div/div/label"))
							.getSize());
			ActionUtils.waitFor10Seconds();
			driver.findElement(By.xpath("//*/div/div/footer/div/div/table/tbody/tr[1]/td[1]/div/div/label")).click();
			System.out.println("survey- clicked");
			ActionUtils.waitFor10Seconds();
			System.out.println(
					driver.findElements(By.xpath("//*/div/div/header/div[2]/header/div[3]/div[2]/button")).size());
			ActionUtils.waitFor10Seconds();
		def	 LstButtons = [ "Assign to BP/ IG", "Accept", "Schedule Date", "Change Date", "Change BP/ IG",
					"Approve", "Not Required" ];
			System.out.println(LstButtons.length);
			for (int i = 0; i < LstButtons.length; i++) {
				// System.out.println(i);
				for (int j = 0; j < driver
						.findElements(By.xpath("//*/div/div/header/div[2]/header/div[3]/div[2]/button")).size(); j++) {
					System.out.println(
							driver.findElements(By.xpath("//*/div/div/header/div[2]/header/div[3]/div[2]/button"))
									.get(j).getText());
					if (driver.findElements(By.xpath("//*/div/div/header/div[2]/header/div[3]/div[2]/button")).get(j)
							.getText().toString().trim() == LstButtons[i].toString().trim()) {
						System.out.println(LstButtons[i] + "  Button is presented");
						break;
					} else {
						System.out.println(LstButtons[i] + "  Button is not presented");
						break;
					}
				}
			}
		}

		System.out.println("survey clicked");

	}

	public void SurveyTypeValidation(RemoteWebDriver driver) {
		System.out.println("Survey Type validation");
		ActionUtils.waitFor10Seconds();
		driver.findElement(By.xpath("//*/div/div/footer/div/div/table/tbody/tr[1]/td[3]/div/a")).click();
		ActionUtils.waitFor10Seconds();
		System.out.println(driver.findElement(By.xpath("//*/div/div[3]/div[2]/div/div[2]/span/span")).getText());
		System.out.println("Survey type validation finished");
	}

	public void VerifyNoQuickActionButtonsJob(RemoteWebDriver driver) {
		System.out.println("Quick action button validation for job level");
		def LstButtons =[ "Edit", "Add Contract Labor", "Add Material", "Add Track Estimate",
				"Submit For Approval", "Change Date", "Add Contract Footage", "Edit DMRA" ];
		System.out.println(LstButtons.length);
		for (int i = 0; i < LstButtons.length; i++) {
			// System.out.println(i);
			for (int j = 0; j < driver.findElements(By.xpath(
					"//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/header/div[2]/div/div[2]/ul"))
					.size(); j++) {
				System.out.println(driver.findElements(By.xpath(
						"//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/header/div[2]/div/div[2]/ul/li["
								+ i + "]/a/div"))
						.get(0).getText());
				if (driver.findElements(By.xpath(
						"//*[@id=\"brandBand_1\"]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/header/div[2]/div/div[2]/ul/li["
								+ i + "]/a/div"))
						.get(0).getText().toString().trim() == LstButtons[i].toString().trim()) {
					System.out.println(LstButtons[i] + "  Button is presented");
					break;
				} else {
					System.out.println(LstButtons[i] + "  Button is not presented");
					break;
				}
			}
		}
		System.out.println("Job Level quick buttons verified");
	}

	public void VerifyNoOfTasksJobsJob(RemoteWebDriver driver) {
		ActionUtils.waitFor10Seconds();
		System.out.println(driver.findElements(By.xpath("//*/div/div/footer/div/div/table/tbody/tr")).size());
		//System.out.println(driver.findElements(By.xpath("//*/div/div/header/div[2]/header/div[3]/div[2]/button")).size());
		
		ActionUtils.waitFor10Seconds();
		driver.findElement(
				By.xpath("//*/div/div[1]/div[3]/div[1]/div/div[1]/div[1]/header/div[2]/div/div[1]/div[2]/h1/div/span"))
				.getText();
		System.out.println("No Of Task in the job - "
				+ driver.findElement(By.xpath(
						"//*/div/div[1]/div[3]/div[1]/div/div[1]/div[1]/header/div[2]/div/div[1]/div[2]/h1/div/span"))
						.getText()
				+ " - " + driver.findElements(By.xpath("//*/div/div/footer/div/div/table/tbody/tr")).size());

	}

	public boolean SearchTaskAndClick(RemoteWebDriver driver, String Task) {
		ActionUtils.waitFor15Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		WebElement webElement = driver.findElement(By.linkText(Task));
		jse.executeScript("arguments[0].scrollIntoView();", webElement);
		ActionUtils.waitFor5Seconds();
		// driver.findElement(By.xpath("//*[@id=\"modal-content-id-1\"]/article/div/div[2]/div/div/div[2]/button")).click();
		System.out.println(
				driver.findElements(By.cssSelector("slds-checkbox--faux")).get(0).getAttribute("name").toString());
		driver.findElements(By.cssSelector("slds-checkbox--faux")).get(0).click();
		System.out.println("survey clicked");

		return flag;
	}

	public void CreateNewTaskAction(RemoteWebDriver driver, String milestone, String taskType) {
		ActionUtils.waitFor5Seconds();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'New')]"))).click().build()
				.perform();
//		driver.findElements(By.cssSelector("input[type='checkbox']")).get(1).click();
//		ActionUtils.waitFor5Seconds();
		ActionUtils.waitFor5Seconds();
//		driver.findElement(By.cssSelector("button[class='slds-button slds-button_neutral']")).click();
		ActionUtils.waitFor5Seconds();
		action.moveToElement(driver.findElements(By.cssSelector("select[class='dynamic select']")).get(0)).click()
				.build().perform();
		// driver.findElements(By.cssSelector("select[class='dynamic
		// select']")).get(0).click();
		ActionUtils.waitFor5Seconds();
		// action.moveToElement(driver.findElement(By.cssSelector("option[value='"+milestone+"']"))).click().build().perform();
		driver.findElement(By.cssSelector("option[label='" + milestone + "']")).click();
		ActionUtils.waitFor5Seconds();
		action.moveToElement(driver.findElement(By.cssSelector("div[class='slds-modal__footer']"))).click().build()
				.perform();
		// driver.findElement(By.cssSelector("div[class='slds-modal__footer']")).click();
		ActionUtils.waitFor5Seconds();
		action.moveToElement(driver.findElements(By.cssSelector("select[class='dynamic select']")).get(1)).click()
				.build().perform();
		// driver.findElements(By.cssSelector("select[class='dynamic
		// select']")).get(1).click();
		ActionUtils.waitFor5Seconds();
		// action.moveToElement(driver.findElement(By.cssSelector("button[class='slds-button
		// slds-button_neutral']"))).click().build().perform();
		if (milestone.equals(taskType)) {
			// action.moveToElement(driver.findElements(By.cssSelector("option[value='"+taskType+"']")).get(0)).click().build().perform();
			driver.findElements(By.cssSelector("option[label='" + taskType + "']")).get(1).click();
			ActionUtils.waitFor5Seconds();
		} else {
			action.moveToElement(driver.findElements(By.cssSelector("option[label='" + taskType + "']")).get(0)).click()
					.build().perform();
			// driver.findElements(By.cssSelector("option[label='"+taskType+"']")).get(0).click();
			ActionUtils.waitFor5Seconds();
		}
		action.moveToElement(driver.findElement(By.cssSelector("div[class='slds-modal__footer']"))).click().build()
				.perform();

		ActionUtils.waitFor5Seconds();
		action.moveToElement(
				driver.findElements(By.cssSelector("button[class='slds-button slds-button--brand']")).get(1)).click()
				.build().perform();

		ActionUtils.waitFor5Seconds();
		action.moveToElement(
				driver.findElements(By.cssSelector("button[class='slds-button slds-button--brand']")).get(1)).click()
				.build().perform();

		ActionUtils.waitFor5Seconds();
	}
}
