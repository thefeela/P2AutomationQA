package p2.util

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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * @author Guna
 */

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import p2.Properties.JobcategoryInputParameters;
import p2.action.BettermentJobAction;
import p2.common.ConstantValues;
import internal.GlobalVariable;
import p2.dataType.TestStepStatus 
public class CommonUtils {
	protected static final char[] CHARSET_aZ = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	protected static final char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	protected static final char[] CHARSET_HEX = "0123456789ABCDEF".toCharArray();
	protected static final char[] CHARSET_SPECIAL =   "!AB".toCharArray()

	static boolean flag=false
	private static Logger logger = LogManager.getLogger(CommonUtils.class.getCanonicalName());

	public String randomString(char[] characterSet, int length) {
		Random random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		return new String(result);
	}

	public static String endDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, YYYY");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 10);
		String endDate = sdf.format(c.getTime());
		return endDate;

	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = (System.getProperty("user.dir") + "/report/" + screenshotName + dateName + ".png");
		// String dest ="../FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void switchtab(RemoteWebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		ActionUtils.waitFor3Seconds();
	}

	public void closeTab(RemoteWebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(ConstantValues.TAB_STEP_0));
		ActionUtils.waitFor5Seconds();

	}

	public static TestStepStatus verifyQuickActionButtons(RemoteWebDriver driver) {
		TestStepStatus testStepStatus = new TestStepStatus();
		ActionUtils.waitFor5Seconds();
		WebElement element = driver.findElement(By.cssSelector(JobcategoryInputParameters.getp2task_checkbox()));

		Actions actions = new Actions(driver);

		actions.moveToElement(element).click().perform();
		//driver.findElements(By.cssSelector(JobcategoryInputParameters.getp2task_checkbox())).get(1).click();

		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(1)
		.isDisplayed()) {
			logger.info("New  Button Button Not loaded  in the Job page-->"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(1)
					.isDisplayed());
			if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getassignbutton())).isDisplayed()) {
				logger.info("AssignBp/IG  Button Button Not loaded  in the Job page-->" + driver
						.findElement(By.cssSelector(JobcategoryInputParameters.getassignbutton())).isDisplayed());
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(2)
				.isDisplayed()) {
					logger.info("Schedule Date  Button Button Not loaded  in the Job page-->"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
							.get(2).isDisplayed());
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(3)
					.isDisplayed()) {
						logger.info("ChangeDate  Button Button Not loaded  in the Job page-->" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(3)
								.isDisplayed());
						if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
						.get(4).isDisplayed()) {
							logger.info("ChangeBP/Ig  Button Button Not loaded  in the Job page-->" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
									.get(4).isDisplayed());
							if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getapprovebutton()))
							.isDisplayed()) {
								ActionUtils.waitFor2Seconds();
								logger.info("Approve  Button Button Not loaded  in the Job page-->" + driver
										.findElement(By.cssSelector(JobcategoryInputParameters.getapprovebutton()))
										.isDisplayed());
								if (driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getnotRequiredButton()))
								.get(0).isDisplayed()) {
									logger.info("Not Required  Button Button Not loaded  in the Job page-->" + driver
											.findElements(
											By.cssSelector(JobcategoryInputParameters.getnotRequiredButton()))
											.get(0).isDisplayed());
									testStepStatus.setElementstatus("All Job level Action Buttons loaded");
									testStepStatus.setElementName("All Job level Action Buttons");
								} else {
									logger.info("Not Required Button Not loaded  in the Job page-->" + driver
											.findElements(
											By.cssSelector(JobcategoryInputParameters.getnotRequiredButton()))
											.get(4).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("Not Rquired Button Not loaded");
									testStepStatus.setElementName("Not Rquired");

								}
							} else {
								logger.info("Approve Button Not loaded  in the Job page-->" + driver
										.findElement(By.cssSelector(JobcategoryInputParameters.getapprovebutton()))
										.isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("Approve Button Not loaded");
								testStepStatus.setElementName("Approve Button");

							}
						} else {
							logger.info("ChangeBP/Ig Button Not loaded  in the Job page-->" + driver
									.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons()))
									.get(3).isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("ChangeBP/Ig Button Not loaded");
							testStepStatus.setElementName("ChangeBP/Ig Button");
						}
					} else {
						logger.info("ChangeDate Button Not loaded  in the Job page-->" + driver
								.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(2)
								.isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("ChangeDate Button Not loaded");
						testStepStatus.setElementName("ChangeDate Button");
					}

				} else {
					logger.info("Schedule Date Button Not loaded  in the Job page-->"
							+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getapprovebutton())).get(1)
							.isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("Schedule Date Button Not loaded");
					testStepStatus.setElementName("Schedule Date  Button");

				}
			} else {
				logger.info("AssignBp/IG Button Not loaded  in the Job page-->" + driver
						.findElement(By.cssSelector(JobcategoryInputParameters.getassignbutton())).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("AssignBp/IG Button Not loaded");
				testStepStatus.setElementName("AssignBp/IG Button");
			}

		} else {
			logger.info("New  Button Not loaded  in the Job page-->"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getquickActionbuttons())).get(0)
					.isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("New  Button Not loaded");
			testStepStatus.setElementName("New  Button");

		}

		return testStepStatus;

	}
	public static TestStepStatus jobActionButtonValidation(RemoteWebDriver driver) {
		TestStepStatus testStepStatus = new TestStepStatus();
		driver.findElements(By.cssSelector("div[class='uiMenu']")).get(0).click();
		/*	System.out.println("values in the compact layout is--"
		 + driver.findElements(By.cssSelector(JobcategoryInputParameters.getjobActionButtonValidation())).get(0)
		 .getText());*/
		if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getedit_compactlayot())).getText()
		.equals(JobcategoryInputParameters.getEdit())) {
			logger.info("Edit Button loaded  in the Job page--->"
					+ driver.findElement(By.cssSelector(JobcategoryInputParameters.getedit_compactlayot())).isDisplayed());
			if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getchangedate_compactlayot())).getText()
			.equals(JobcategoryInputParameters.getChangeDate())) {
				logger.info("Change Date Button loaded  in the Job page--->" + driver.findElement(By.cssSelector(JobcategoryInputParameters.getchangedate_compactlayot())).isDisplayed());
				if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getMaterials_compactlayot())).getText()
				.equals(JobcategoryInputParameters.getAddMaterials())) {
					logger.info("Add Materials Button loaded  in the Job page--->"
							+ driver.findElement(By.cssSelector(JobcategoryInputParameters.getMaterials_compactlayot())).isDisplayed());
					if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getContract_compactlayot()))
					.getText().equals(JobcategoryInputParameters.getAddContractLabor())) {
						logger.info("Add Contract Labor Button loaded  in the Job page--->" +driver.findElement(By.cssSelector(JobcategoryInputParameters.getContract_compactlayot())).isDisplayed());
						if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getFootage_compactlayot()))
						.getText().equals(JobcategoryInputParameters.getAddConstructedFootage())) {
							logger.info("Add Constructed Footage Button Not loaded  in the Job page--->" + driver.findElement(By.cssSelector(JobcategoryInputParameters.getFootage_compactlayot())).isDisplayed());
							if (driver.findElement(By.cssSelector(JobcategoryInputParameters.getHold_compactlayot()))
							.getText().equals(JobcategoryInputParameters.getHold_Unhold())) {
								logger.info("Hold/UnHold Button Not loaded  in the Job page--->" + driver.findElement(By.cssSelector(JobcategoryInputParameters.getHold_compactlayot())).isDisplayed());
								if (driver
								.findElement(By.cssSelector(JobcategoryInputParameters.getclose_compactlayot()))
								.getText().equals(JobcategoryInputParameters.getClose())) {
									logger.info("Close Button Not loaded  in the Job page--->" + driver.findElement(By.cssSelector(JobcategoryInputParameters.getclose_compactlayot())).isDisplayed());
									if (driver
									.findElement(By
									.cssSelector(JobcategoryInputParameters.getapproval_compactlayot()))
									.getText().equals(JobcategoryInputParameters.getSubmit_for_Approval())) {
										logger.info(" Submit for Approval Button Not loaded  in the Job page--->" + driver.findElement(By.cssSelector(JobcategoryInputParameters.getapproval_compactlayot())).isDisplayed());
										if (driver
										.findElement(By.cssSelector(
										JobcategoryInputParameters.getcancel_compactlayot()))
										.getText().equals(JobcategoryInputParameters.getCancel())) {
											logger.info("Cancel Button Not loaded  in the Job page--->" + driver.findElement(By.cssSelector(JobcategoryInputParameters.getcancel_compactlayot()))
													.isDisplayed());
											testStepStatus.setElementstatus("All Job level Action Buttons loaded");
											testStepStatus.setElementName("All Job level Action Buttons");
										} else {
											logger.info("Cancel Button Not loaded  in the Job page--->" + driver
													.findElement(By.cssSelector(
													JobcategoryInputParameters.getcancel_compactlayot()))
													.isDisplayed());
											flag = false;
											testStepStatus.setElementstatus("Cancel Button Not loaded");
											testStepStatus.setElementName("Cancel Button");
										}
									} else {
										logger.info("Submit for Approval Button Not loaded  in the Job page--->" + driver
												.findElement(By.cssSelector(
												JobcategoryInputParameters.getapproval_compactlayot()))
												.isDisplayed());
										flag = false;
										testStepStatus.setElementstatus("Submit for Approval Button Not loaded");
										testStepStatus.setElementName("Submit for Approval Button");
									}
								} else {
									logger.info("Close Button Not loaded  in the Job page--->" + driver
											.findElement(
											By.cssSelector(JobcategoryInputParameters.getclose_compactlayot()))
											.isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("Close Button Not loaded");
									testStepStatus.setElementName("Close Button");
								}
							} else {
								logger.info("Hold/Unhold Not loaded  in the Job page--->" + driver
										.findElement(By.cssSelector(JobcategoryInputParameters.getHold_compactlayot()))
										.isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("Hold/Unhold Button Not loaded");
								testStepStatus.setElementName("Hold/Unhold Button");
							}
						} else {
							logger.info("Add Constructed Footage Button Not loaded  in the Job page--->" + driver
									.findElement(By.cssSelector(JobcategoryInputParameters.getFootage_compactlayot()))
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("Add Constructed Footage Button Not loaded");
							testStepStatus.setElementName("Add Constructed Footage Button");
						}
					} else {
						logger.info("Add Contract Labor Button Not loaded  in the Job page--->" + driver
								.findElement(By.cssSelector(JobcategoryInputParameters.getContract_compactlayot()))
								.isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("Add Contract Labor Button Not loaded");
						testStepStatus.setElementName("Add Contract Labor Button");
					}

				} else {
					logger.info("Add Materials Button Not loaded  in the Job page--->"
							+ driver.findElement(By.cssSelector(JobcategoryInputParameters.getMaterials_compactlayot()))
							.isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("Add Materials Button Not loaded");
					testStepStatus.setElementName("Add Materials Button");

				}
			} else {
				logger.info("Change Date Button Not loaded  in the Job page--->"
						+ driver.findElement(By.cssSelector(JobcategoryInputParameters.getchangedate_compactlayot()))
						.isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("Change Date Button Not loaded");
				testStepStatus.setElementName("Change Date Button");
			}

		} else {
			logger.info("Edit Button Not loaded  in the Job page--->" + driver
					.findElement(By.cssSelector(JobcategoryInputParameters.getedit_compactlayot())).isDisplayed());
			flag = false;
			// testStepStatus.setflag(flag);
			testStepStatus.setElementstatus("Edit Button Not loaded");
			testStepStatus.setElementName("Edit Button");

		}

		return testStepStatus;

	}
	/*public static TestStepStatus jobActionButtonValidation(RemoteWebDriver driver) {
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
	 logger.info("Submit for Approval Button Not loaded  in the Job page-->" + driver
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
	 }*/

	public static TestStepStatus verifyJobTabs(RemoteWebDriver driver) throws AWTException {

		TestStepStatus testStepStatus = new TestStepStatus();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);




		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("ESTIMATES")).getText()
					.equals(JobcategoryInputParameters.getestimates())) {
						logger.info("ESTIMATES loaded  in the Job Tab-->" + driver.findElement(By.linkText("ESTIMATES")).isDisplayed());
						if (driver.findElement(By.linkText("PAYBACK")).getText()
						.equals(JobcategoryInputParameters.getpayback())) {
							logger.info("PAYBACK loaded  in the Job Tab-->"
									+ driver.findElement(By.linkText("PAYBACK"))
									.isDisplayed());
							if (driver.findElement(By.linkText("ADDRESSES")).getText()
							.equals(JobcategoryInputParameters.getaddress())) {
								logger.info("ADDRESSES loaded  in the Job Tab-->"
										+ driver.findElement(By.linkText("ADDRESSES"))
										.isDisplayed());
								if (driver.findElement(By.linkText("PERMITS")).getText().equals(JobcategoryInputParameters.getpermits())) {
									logger.info("PERMITS loaded  in the Job Tab-->" + driver.findElement(By.linkText("PERMITS"))
											.isDisplayed());
									if (driver.findElement(By.linkText("INVOICE LINES")).getText().equals(JobcategoryInputParameters.getinvoic_lines())) {
										logger.info("INVOICE LINES loaded  in the Job Tab-->" + driver.findElement(By.linkText("INVOICE LINES"))
												.isDisplayed());

										ActionUtils.waitFor2Seconds();
										if (driver.findElement(By.linkText("CONSTRUCTED FT")).getText().equals(JobcategoryInputParameters.getconstructed_ft())) {
											/*logger.info("CONSTRUCTED FT loaded  in the Job Tab-->" + driver
											 .findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
											 .get(0).isDisplayed());*/
											driver.findElement(By.cssSelector("button[title='More Tabs']")).click();
											ActionUtils.waitFor5Seconds();
											if (driver.findElement(By.cssSelector("a[role='menuitem']")).getText().equals(JobcategoryInputParameters.getjobdetails())) {
												/*	logger.info("JOB DETAILS loaded  in the Job Tab-->" + driver
												 .findElements(
												 By.cssSelector("li[data-aura-class='uiMenuItem']"))
												 .get(1).isDisplayed());*/
												if (driver.findElement(By.linkText("FILE UPLOAD TEMPLATES")).getText().equals("FILE UPLOAD TEMPLATES")) {
													/*	logger.info("File upload templates loaded  in the Job Tab-->" + driver
													 .findElements(
													 By.cssSelector("li[data-aura-class='uiMenuItem']"))
													 .get(3).isDisplayed());*/
													if (driver.findElement(By.linkText("ATTACHMENTS")).getText().equals(JobcategoryInputParameters.getattachments())) {
														/*logger.info("ATTACHMENTS loaded  in the Job Tab-->" + driver
														 .findElements(
														 By.cssSelector("li[data-aura-class='uiMenuItem']"))
														 .get(2).isDisplayed());*/
														/*System.out.println(driver
														 .findElements(
														 By.cssSelector("li[data-aura-class='uiMenuItem']"))
														 .get(4).getText());*/

														System.out.println(driver.findElement(By.linkText("JOB DETAILS")).getText());

														if (driver.findElement(By.linkText("HISTORY")).getText().equals(JobcategoryInputParameters.gethistory())) {
															/*	logger.info("HISTORY loaded  in the Job Tab-->" + driver
															 .findElements(By.cssSelector(
															 "li[data-aura-class='uiMenuItem']"))
															 .get(4).isDisplayed());*/
															flag = true;
															testStepStatus.setElementstatus("JOB Tabs loaded");
															testStepStatus.setElementName("JOB Tabs");
														} else {
															logger.info("HISTORY Not loaded  in the Job Tab" + driver
																	.findElements(By.cssSelector(
																	"li[data-aura-class='uiMenuItem']"))
																	.get(4).isDisplayed());
															flag = false;
															testStepStatus.setElementstatus("HISTORY Not loaded");
															testStepStatus.setElementName("HISTORY");
														}
													} else {
														logger.info("ATTACHMENTS Not loaded  in the Job Tab-->" + driver
																.findElements(
																By.cssSelector("li[data-aura-class='uiMenuItem']"))
																.get(2).isDisplayed());

														flag = false;
														testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
														testStepStatus.setElementName("ATTACHMENTS");
													}
												} else {
													logger.info("File Upload Template Not loaded  in the Job Tab" + driver
															.findElements(By.cssSelector(
															"li[data-aura-class='uiMenuItem']"))
															.get(3).isDisplayed());
													flag = false;
													testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
													testStepStatus.setElementName("ATTACHMENTS");
												}

											} else {
												logger.info("JOB DETAILS Not loaded  in the Job Tab-->" + driver
														.findElements(
														By.cssSelector("li[data-aura-class='uiMenuItem']"))
														.get(1).isDisplayed());

												testStepStatus.setElementstatus("JOB DETAILS Not loaded");
												testStepStatus.setElementName("JOB DETAILS");
											}
										} else {
											logger.info("CONSTRUCTED FT Not loaded  in the Job Tab-->" + driver
													.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
													.get(0).isDisplayed());
											flag = false;
											testStepStatus.setElementstatus("CONSTRUCTED FT Not loaded");
											testStepStatus.setElementName("CONSTRUCTED FT");
										}
									} else {
										logger.info("INVOICE LINES Not loaded  in the Job Tab-->"
												+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
												.get(7).isDisplayed());
										flag = false;
										testStepStatus.setElementstatus("INVOICE LINES Not loaded");
										testStepStatus.setElementName("INVOICE LINES");
									}
								} else {
									logger.info("PERMITS Not loaded  in the Job Tab-->"
											+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
											.get(6).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("PERMITS Not loaded");
									testStepStatus.setElementName("PERMITS");
								}
							} else {
								logger.info("ADDRESSES Not loaded  in the Job Tab-->"
										+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5)
										.isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("ADDRESSES Not loaded");
								testStepStatus.setElementName("ADDRESSES");
							}
						} else {
							logger.info("PAYBACK Not loaded  in the Job Tab-->"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4)
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("PAYBACK Not loaded");
							testStepStatus.setElementName("PAYBACK");
						}
					} else {
						logger.info("ESTIMATES Not loaded  in the Job Tab-->" + driver
								.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3).isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("ESTIMATES Not loaded");
						testStepStatus.setElementName("ESTIMATES");
					}
				} else {
					logger.info("SURVEYS Not loaded  in the Job Tab-->" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("SURVEYS Not loaded");
					testStepStatus.setElementName("SURVEYS");
				}
			} else {
				logger.info("CHATTER Not loaded  in the Job Tab-->"
						+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("CHATTER Not loaded");
				testStepStatus.setElementName("CHATTER");
			}
		} else {
			logger.info("TASKS Not loaded  in the Job Tab-->"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("TASKS Not loaded");
			testStepStatus.setElementName("TASKS");
		}
		return testStepStatus;
	}
	public static TestStepStatus verifyCommercialJobTabs(RemoteWebDriver driver) {
		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("ESTIMATES")).getText()
					.equals(JobcategoryInputParameters.getestimates())) {
						logger.info("ESTIMATES loaded  in the Job Tab-->" + driver.findElement(By.linkText("ESTIMATES")).isDisplayed());
						if (driver.findElement(By.linkText("PAYBACK")).getText()
						.equals(JobcategoryInputParameters.getpayback())) {
							logger.info("PAYBACK loaded  in the Job Tab-->"
									+ driver.findElement(By.linkText("PAYBACK"))
									.isDisplayed());
							if (driver.findElement(By.linkText("ADDRESSES")).getText()
							.equals(JobcategoryInputParameters.getaddress())) {
								logger.info("ADDRESSES loaded  in the Job Tab-->"
										+ driver.findElement(By.linkText("ADDRESSES"))
										.isDisplayed());
								if (driver.findElement(By.linkText("PERMITS")).getText().equals(JobcategoryInputParameters.getpermits())) {
									logger.info("PERMITS loaded  in the Job Tab-->" + driver.findElement(By.linkText("PERMITS"))
											.isDisplayed());
									if (driver.findElement(By.linkText("INVOICE LINES")).getText().equals(JobcategoryInputParameters.getinvoic_lines())) {
										logger.info("INVOICE LINES loaded  in the Job Tab-->" + driver.findElement(By.linkText("INVOICE LINES"))
												.isDisplayed());

										ActionUtils.waitFor2Seconds();
										if (driver.findElement(By.linkText("CONSTRUCTED FT")).getText().equals(JobcategoryInputParameters.getconstructed_ft())) {
											/*logger.info("CONSTRUCTED FT loaded  in the Job Tab-->" + driver
											 .findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
											 .get(0).isDisplayed());*/
											driver.findElement(By.cssSelector("button[title='More Tabs']")).click();
											ActionUtils.waitFor2Seconds();
											if (driver.findElement(By.linkText("JOB DETAILS")).getText().equals(JobcategoryInputParameters.getjobdetails())) {
												if (driver.findElement(By.linkText("FILE UPLOAD TEMPLATES")).getText().equals("FILE UPLOAD TEMPLATES")) {
													/*	logger.info("File upload templates loaded  in the Job Tab-->" + driver
													 .findElements(
													 By.cssSelector("li[data-aura-class='uiMenuItem']"))
													 .get(3).isDisplayed());*/
													if (driver.findElement(By.linkText("ATTACHMENTS")).getText().equals(JobcategoryInputParameters.getattachments())) {
														/*logger.info("ATTACHMENTS loaded  in the Job Tab-->" + driver
														 .findElements(
														 By.cssSelector("li[data-aura-class='uiMenuItem']"))
														 .get(2).isDisplayed());*/
														/*System.out.println(driver
														 .findElements(
														 By.cssSelector("li[data-aura-class='uiMenuItem']"))
														 .get(4).getText());*/

														System.out.println(driver.findElement(By.linkText("JOB DETAILS")).getText());

														if (driver.findElement(By.linkText("HISTORY")).getText().equals(JobcategoryInputParameters.gethistory())) {
															/*	logger.info("HISTORY loaded  in the Job Tab-->" + driver
															 .findElements(By.cssSelector(
															 "li[data-aura-class='uiMenuItem']"))
															 .get(4).isDisplayed());*/
															flag = true;
															testStepStatus.setElementstatus("JOB Tabs loaded");
															testStepStatus.setElementName("JOB Tabs");
														}else {
															logger.info("HISTORY Not loaded  in the Job Tab" + driver
																	.findElements(By.cssSelector(
																	"li[data-aura-class='uiMenuItem']"))
																	.get(4).isDisplayed());
															flag = false;
															testStepStatus.setElementstatus("HISTORY Not loaded");
															testStepStatus.setElementName("HISTORY");
														}
													}
													else {
														logger.info("ATTACHMENTS Not loaded  in the Job Tab-->" + driver
																.findElements(
																By.cssSelector("li[data-aura-class='uiMenuItem']"))
																.get(2).isDisplayed());

														flag = false;
														testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
														testStepStatus.setElementName("ATTACHMENTS");
													}
												}

												else {
													logger.info("File Upload Template Not loaded  in the Job Tab" + driver
															.findElements(By.cssSelector(
															"li[data-aura-class='uiMenuItem']"))
															.get(3).isDisplayed());
													flag = false;
													testStepStatus.setElementstatus("HISTORY Not loaded");
													testStepStatus.setElementName("HISTORY");
												}
											}  else {
												logger.info("JOB DETAILS Not loaded  in the Job Tab-->" + driver
														.findElements(
														By.cssSelector("li[data-aura-class='uiMenuItem']"))
														.get(1).isDisplayed());

												testStepStatus.setElementstatus("JOB DETAILS Not loaded");
												testStepStatus.setElementName("JOB DETAILS");
											}
										} else {
											logger.info("CONSTRUCTED FT Not loaded  in the Job Tab-->" + driver
													.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
													.get(0).isDisplayed());
											flag = false;
											testStepStatus.setElementstatus("CONSTRUCTED FT Not loaded");
											testStepStatus.setElementName("CONSTRUCTED FT");
										}
									} else {
										logger.info("INVOICE LINES Not loaded  in the Job Tab-->"
												+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
												.get(7).isDisplayed());
										flag = false;
										testStepStatus.setElementstatus("INVOICE LINES Not loaded");
										testStepStatus.setElementName("INVOICE LINES");
									}
								} else {
									logger.info("PERMITS Not loaded  in the Job Tab-->"
											+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
											.get(6).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("PERMITS Not loaded");
									testStepStatus.setElementName("PERMITS");
								}
							} else {
								logger.info("ADDRESSES Not loaded  in the Job Tab-->"
										+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5)
										.isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("ADDRESSES Not loaded");
								testStepStatus.setElementName("ADDRESSES");
							}
						} else {
							logger.info("PAYBACK Not loaded  in the Job Tab-->"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4)
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("PAYBACK Not loaded");
							testStepStatus.setElementName("PAYBACK");
						}
					} else {
						logger.info("ESTIMATES Not loaded  in the Job Tab-->" + driver
								.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3).isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("ESTIMATES Not loaded");
						testStepStatus.setElementName("ESTIMATES");
					}
				} else {
					logger.info("SURVEYS Not loaded  in the Job Tab-->" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("SURVEYS Not loaded");
					testStepStatus.setElementName("SURVEYS");
				}
			} else {
				logger.info("CHATTER Not loaded  in the Job Tab-->"
						+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("CHATTER Not loaded");
				testStepStatus.setElementName("CHATTER");
			}
		} else {
			logger.info("TASKS Not loaded  in the Job Tab-->"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("TASKS Not loaded");
			testStepStatus.setElementName("TASKS");
		}
		return testStepStatus;
	}

	public static TestStepStatus verifyJobTabsResidential(RemoteWebDriver driver) {

		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("ESTIMATES")).getText()
					.equals(JobcategoryInputParameters.getestimates())) {
						logger.info("ESTIMATES loaded  in the Job Tab-->" + driver.findElement(By.linkText("ESTIMATES")).isDisplayed());
						if (driver.findElement(By.linkText("PAYBACK")).getText()
						.equals(JobcategoryInputParameters.getpayback())) {
							logger.info("PAYBACK loaded  in the Job Tab-->"
									+ driver.findElement(By.linkText("PAYBACK"))
									.isDisplayed());
							if (driver.findElement(By.linkText("ADDRESSES")).getText()
							.equals(JobcategoryInputParameters.getaddress())) {
								logger.info("ADDRESSES loaded  in the Job Tab-->"
										+ driver.findElement(By.linkText("ADDRESSES"))
										.isDisplayed());
								if (driver.findElement(By.linkText("PERMITS")).getText().equals(JobcategoryInputParameters.getpermits())) {
									logger.info("PERMITS loaded  in the Job Tab-->" + driver.findElement(By.linkText("PERMITS"))
											.isDisplayed());
									if (driver.findElement(By.linkText("INVOICE LINES")).getText().equals(JobcategoryInputParameters.getinvoic_lines())) {
										logger.info("INVOICE LINES loaded  in the Job Tab-->" + driver.findElement(By.linkText("INVOICE LINES"))
												.isDisplayed());

										ActionUtils.waitFor2Seconds();
										if (driver.findElement(By.linkText("CONSTRUCTED FT")).getText().equals(JobcategoryInputParameters.getconstructed_ft())) {
											/*logger.info("CONSTRUCTED FT loaded  in the Job Tab-->" + driver
											 .findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
											 .get(0).isDisplayed());*/
											driver.findElement(By.cssSelector("button[title='More Tabs']")).click();
											ActionUtils.waitFor2Seconds();
											if (driver.findElement(By.linkText("JOB DETAILS")).getText().equals(JobcategoryInputParameters.getjobdetails())) {
												/*	logger.info("JOB DETAILS loaded  in the Job Tab-->" + driver
												 .findElements(
												 By.cssSelector("li[data-aura-class='uiMenuItem']"))
												 .get(1).isDisplayed());*/
												if (driver.findElement(By.linkText("UPLOAD FILE TEMPLATES")).getText().equals("UPLOAD FILE TEMPLATES")) {
													/*	logger.info("File upload templates loaded  in the Job Tab-->" + driver
													 .findElements(
													 By.cssSelector("li[data-aura-class='uiMenuItem']"))
													 .get(3).isDisplayed());*/
													if (driver.findElement(By.linkText("ATTACHMENTS")).getText().equals(JobcategoryInputParameters.getattachments())) {
														/*logger.info("ATTACHMENTS loaded  in the Job Tab-->" + driver
														 .findElements(
														 By.cssSelector("li[data-aura-class='uiMenuItem']"))
														 .get(2).isDisplayed());*/
														/*System.out.println(driver
														 .findElements(
														 By.cssSelector("li[data-aura-class='uiMenuItem']"))
														 .get(4).getText());*/

														System.out.println(driver.findElement(By.linkText("JOB DETAILS")).getText());

														if (driver.findElement(By.linkText("HISTORY")).getText().equals(JobcategoryInputParameters.gethistory())) {
															/*	logger.info("HISTORY loaded  in the Job Tab-->" + driver
															 .findElements(By.cssSelector(
															 "li[data-aura-class='uiMenuItem']"))
															 .get(4).isDisplayed());*/
															flag = true;
															testStepStatus.setElementstatus("JOB Tabs loaded");
															testStepStatus.setElementName("JOB Tabs");
														} else {
															logger.info("HISTORY Not loaded  in the Job Tab" + driver
																	.findElements(By.cssSelector(
																	"li[data-aura-class='uiMenuItem']"))
																	.get(4).isDisplayed());
															flag = false;
															testStepStatus.setElementstatus("HISTORY Not loaded");
															testStepStatus.setElementName("HISTORY");
														}
													}else {
														logger.info("UPLOAD FILE TEMPLATES Not loaded  in the Job Tab" + driver
																.findElements(By.cssSelector(
																"li[data-aura-class='uiMenuItem']"))
																.get(3).isDisplayed());
														flag = false;
														testStepStatus.setElementstatus("UPLOAD FILE TEMPLATES Not loaded");
														testStepStatus.setElementName("UPLOAD FILE TEMPLATES");
													}
												}
												else {
													logger.info("ATTACHMENTS Not loaded  in the Job Tab" + driver
															.findElements(
															By.cssSelector("li[data-aura-class='uiMenuItem']"))
															.get(2).isDisplayed());

													flag = false;
													testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
													testStepStatus.setElementName("ATTACHMENTS");
												}
											} else {
												logger.info("JOB DETAILS Not loaded  in the Job Tab" + driver
														.findElements(
														By.cssSelector("li[data-aura-class='uiMenuItem']"))
														.get(1).isDisplayed());

												testStepStatus.setElementstatus("JOB DETAILS Not loaded");
												testStepStatus.setElementName("JOB DETAILS");
											}
										} else {
											logger.info("CONSTRUCTED FT Not loaded  in the Job Tab" + driver
													.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
													.get(0).isDisplayed());
											flag = false;
											testStepStatus.setElementstatus("CONSTRUCTED FT Not loaded");
											testStepStatus.setElementName("CONSTRUCTED FT");
										}
									} else {
										logger.info("INVOICE LINES Not loaded  in the Job Tab"
												+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
												.get(7).isDisplayed());
										flag = false;
										testStepStatus.setElementstatus("INVOICE LINES Not loaded");
										testStepStatus.setElementName("INVOICE LINES");
									}
								} else {
									logger.info("PERMITS Not loaded  in the Job Tab"
											+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
											.get(6).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("PERMITS Not loaded");
									testStepStatus.setElementName("PERMITS");
								}
							} else {
								logger.info("ADDRESSES Not loaded  in the Job Tab"
										+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5)
										.isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("ADDRESSES Not loaded");
								testStepStatus.setElementName("ADDRESSES");
							}
						} else {
							logger.info("ESTIMATES Not loaded  in the Job Tab"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3)
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("ESTIMATES Not loaded");
							testStepStatus.setElementName("ESTIMATES");
						}
					} else {
						logger.info("PAYBACK Not loaded  in the Job Tab" + driver
								.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4).isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("PAYBACK Not loaded");
						testStepStatus.setElementName("PAYBACK");
					}

				} else {
					logger.info("SURVEYS Not loaded  in the Job Tab" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("SURVEYS Not loaded");
					testStepStatus.setElementName("SURVEYS");
				}
			} else {
				logger.info("CHATTER Not loaded  in the Job Tab"
						+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("CHATTER Not loaded");
				testStepStatus.setElementName("CHATTER");
			}
		} else {
			logger.info("TASKS Not loaded  in the Job Tab"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("TASKS Not loaded");
			testStepStatus.setElementName("TASKS");
		}
		return testStepStatus;
	}

	public static TestStepStatus verifyJobTabsScalable(RemoteWebDriver driver) {
		System.out.println("Inside the VerifyJobscalable");
		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("ESTIMATES")).getText()
					.equals(JobcategoryInputParameters.getestimates())) {
						logger.info("ESTIMATES loaded  in the Job Tab-->" + driver.findElement(By.linkText("ESTIMATES")).isDisplayed());
						/*if (driver.findElement(By.linkText("CHILD NODES")).getText()
						 .equals("CHILD NODES")) {
						 logger.info("CHILD NODES loaded  in the Job Tab-->"
						 + driver.findElement(By.linkText("CHILD NODES"))
						 .isDisplayed());*/
						/*if (driver.findElement(By.linkText("ADDRESSES")).getText()
						 .equals(JobcategoryInputParameters.getaddress())) {
						 logger.info("ADDRESSES loaded  in the Job Tab-->"
						 + driver.findElement(By.linkText("ADDRESSES"))
						 .isDisplayed());*/
						if (driver.findElement(By.linkText("PERMITS")).getText().equals(JobcategoryInputParameters.getpermits())) {
							logger.info("PERMITS loaded  in the Job Tab-->" + driver.findElement(By.linkText("PERMITS"))
									.isDisplayed());
							if (driver.findElement(By.linkText("INVOICE LINES")).getText().equals(JobcategoryInputParameters.getinvoic_lines())) {
								logger.info("INVOICE LINES loaded  in the Job Tab-->" + driver.findElement(By.linkText("INVOICE LINES"))
										.isDisplayed());

								ActionUtils.waitFor2Seconds();
								if (driver.findElement(By.linkText("CONSTRUCTED FT")).getText().equals(JobcategoryInputParameters.getconstructed_ft())) {
									/*logger.info("CONSTRUCTED FT loaded  in the Job Tab-->" + driver
									 .findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
									 .get(0).isDisplayed());*/
									driver.findElement(By.cssSelector("button[title='More Tabs']")).click();
									ActionUtils.waitFor2Seconds();
									if (driver.findElement(By.linkText("JOB DETAILS")).getText().equals(JobcategoryInputParameters.getjobdetails())) {
										/*	logger.info("JOB DETAILS loaded  in the Job Tab-->" + driver
										 .findElements(
										 By.cssSelector("li[data-aura-class='uiMenuItem']"))
										 .get(1).isDisplayed());*/
										if (driver.findElement(By.linkText("FILE UPLOAD TEMPLATES")).getText().equals("FILE UPLOAD TEMPLATES")) {
											/*	logger.info("File upload templates loaded  in the Job Tab-->" + driver
											 .findElements(
											 By.cssSelector("li[data-aura-class='uiMenuItem']"))
											 .get(3).isDisplayed());*/
											if (driver.findElement(By.linkText("ATTACHMENTS")).getText().equals(JobcategoryInputParameters.getattachments())) {
												/*logger.info("ATTACHMENTS loaded  in the Job Tab-->" + driver
												 .findElements(
												 By.cssSelector("li[data-aura-class='uiMenuItem']"))
												 .get(2).isDisplayed());*/
												/*System.out.println(driver
												 .findElements(
												 By.cssSelector("li[data-aura-class='uiMenuItem']"))
												 .get(4).getText());*/

												System.out.println(driver.findElement(By.linkText("JOB DETAILS")).getText());

												if (driver.findElement(By.linkText("HISTORY")).getText().equals(JobcategoryInputParameters.gethistory())) {
													/*	logger.info("HISTORY loaded  in the Job Tab-->" + driver
													 .findElements(By.cssSelector(
													 "li[data-aura-class='uiMenuItem']"))
													 .get(4).isDisplayed());*/
													flag = true;
													testStepStatus.setElementstatus("JOB Tabs loaded");
													testStepStatus.setElementName("JOB Tabs");
												} else {
													logger.info("HISTORY Not loaded  in the Job Tab" + driver
															.findElements(By.cssSelector(
															"li[data-aura-class='uiMenuItem']"))
															.get(4).isDisplayed());
													flag = false;
													testStepStatus.setElementstatus("HISTORY Not loaded");
													testStepStatus.setElementName("HISTORY");
												}
											}else {
												logger.info("UPLOAD FILE TEMPLATES Not loaded  in the Job Tab" + driver
														.findElements(By.cssSelector(
														"li[data-aura-class='uiMenuItem']"))
														.get(3).isDisplayed());
												flag = false;
												testStepStatus.setElementstatus("UPLOAD FILE TEMPLATES Not loaded");
												testStepStatus.setElementName("UPLOAD FILE TEMPLATES");
											}
										}
										else {
											logger.info("ATTACHMENTS Not loaded  in the Job Tab" + driver
													.findElements(
													By.cssSelector("li[data-aura-class='uiMenuItem']"))
													.get(2).isDisplayed());

											flag = false;
											testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
											testStepStatus.setElementName("ATTACHMENTS");
										}
									} else {
										logger.info("JOB DETAILS Not loaded  in the Job Tab" + driver
												.findElements(
												By.cssSelector("li[data-aura-class='uiMenuItem']"))
												.get(1).isDisplayed());

										testStepStatus.setElementstatus("JOB DETAILS Not loaded");
										testStepStatus.setElementName("JOB DETAILS");
									}
								} else {
									logger.info("CONSTRUCTED FT Not loaded  in the Job Tab" + driver
											.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
											.get(0).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("CONSTRUCTED FT Not loaded");
									testStepStatus.setElementName("CONSTRUCTED FT");
								}
							} else {
								logger.info("INVOICE LINES Not loaded  in the Job Tab"
										+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
										.get(7).isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("INVOICE LINES Not loaded");
								testStepStatus.setElementName("INVOICE LINES");
							}
						} /*else {
						 logger.info("PERMITS Not loaded  in the Job Tab"
						 + driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
						 .get(6).isDisplayed());
						 flag = false;
						 testStepStatus.setElementstatus("PERMITS Not loaded");
						 testStepStatus.setElementName("PERMITS");
						 }
						 }*/ /*else {
						 logger.info("ADDRESSES Not loaded  in the Job Tab"
						 + driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5)
						 .isDisplayed());
						 flag = false;
						 testStepStatus.setElementstatus("ADDRESSES Not loaded");
						 testStepStatus.setElementName("ADDRESSES");
						 }
						 }*/ else {
							logger.info("ESTIMATES Not loaded  in the Job Tab"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3)
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("ESTIMATES Not loaded");
							testStepStatus.setElementName("ESTIMATES");
						}
					} else {
						logger.info("PAYBACK Not loaded  in the Job Tab" + driver
								.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4).isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("PAYBACK Not loaded");
						testStepStatus.setElementName("PAYBACK");
					}

				} else {
					logger.info("SURVEYS Not loaded  in the Job Tab" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("SURVEYS Not loaded");
					testStepStatus.setElementName("SURVEYS");
				}
			} else {
				logger.info("CHATTER Not loaded  in the Job Tab"
						+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("CHATTER Not loaded");
				testStepStatus.setElementName("CHATTER");
			}
		} else {
			logger.info("TASKS Not loaded  in the Job Tab"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("TASKS Not loaded");
			testStepStatus.setElementName("TASKS");
		}
		return testStepStatus;
	}

	/*
	 * public static TestStepStatus verifyJobTabsBetterments(RemoteWebDriver driver)
	 * {
	 *
	 * TestStepStatus testStepStatus=new TestStepStatus(); if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0
	 * ).getText().equals("TASKS")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1
	 * ).getText().equals("CHATTER")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2
	 * ).getText().equals("SURVEYS")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3
	 * ).getText().equals("ESTIMATES")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4
	 * ).getText().equals("PAYBACK")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5
	 * ).getText().equals("ADDRESSES")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(6
	 * ).getText().equals("PERMITS")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(7
	 * ).getText().equals("INVOICE LINES")) {
	 * driver.findElements(By.cssSelector("div[class='uiMenu']")).get(1).click();
	 * ActionUtils.waitFor1Seconds(); if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(
	 * 0).getText().equals("CONSTRUCTED FT")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(
	 * 1).getText().equals("JOB DETAILS")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(
	 * 2).getText().equals("ATTACHMENTS")) { if
	 * (driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(
	 * 3).getText().equals("HISTORY")) { flag=true;
	 * testStepStatus.setElementstatus("JOB Tabs loaded");
	 * testStepStatus.setElementName("JOB Tabs"); } else {
	 * logger.info("HISTORY Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(3
	 * ).isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("HISTORY Not loaded");
	 * testStepStatus.setElementName("HISTORY"); } } else {
	 * logger.info("ATTACHMENTS Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(2
	 * ).isDisplayed());
	 *
	 * flag = false; testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
	 * testStepStatus.setElementName("ATTACHMENTS"); } } else {
	 * logger.info("JOB DETAILS Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(1
	 * ).isDisplayed());
	 *
	 * testStepStatus.setElementstatus("JOB DETAILS Not loaded");
	 * testStepStatus.setElementName("JOB DETAILS"); } } else {
	 * logger.info("CONSTRUCTED FT Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(0
	 * ).isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("CONSTRUCTED FT Not loaded");
	 * testStepStatus.setElementName("CONSTRUCTED FT"); } } else {
	 * logger.info("INVOICE LINES Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(7)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("INVOICE LINES Not loaded");
	 * testStepStatus.setElementName("INVOICE LINES"); } } else {
	 * logger.info("PERMITS Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(6)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("PERMITS Not loaded");
	 * testStepStatus.setElementName("PERMITS"); } } else {
	 * logger.info("ADDRESSES Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("ADDRESSES Not loaded");
	 * testStepStatus.setElementName("ADDRESSES"); } } else {
	 * logger.info("PAYBACK Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("PAYBACK Not loaded");
	 * testStepStatus.setElementName("PAYBACK"); } } else {
	 * logger.info("ESTIMATES Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("ESTIMATES Not loaded");
	 * testStepStatus.setElementName("ESTIMATES"); } } else {
	 * logger.info("SURVEYS Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("SURVEYS Not loaded");
	 * testStepStatus.setElementName("SURVEYS"); } } else {
	 * logger.info("CHATTER Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("CHATTER Not loaded");
	 * testStepStatus.setElementName("CHATTER"); } } else {
	 * logger.info("TASKS Not loaded  in the Job Tab" +
	 * driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0)
	 * .isDisplayed()); flag = false;
	 * testStepStatus.setElementstatus("TASKS Not loaded");
	 * testStepStatus.setElementName("TASKS"); } return testStepStatus; }
	 */
	public static TestStepStatus verifyRequestTabsResi_Bet(RemoteWebDriver driver) {

		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("SURVEYS")).getText()
					.equals("SURVEYS")) {
						if (driver.findElement(By.linkText("PAYBACK")).getText()
						.equals(JobcategoryInputParameters.getpayback())) {
							logger.info("PAYBACK loaded  in the Job Tab-->"
									+ driver.findElement(By.linkText("PAYBACK"))
									.isDisplayed());
							if (driver.findElement(By.linkText("RELATED JOBS")).getText()
							.equals("RELATED JOBS")) {

								if (driver.findElement(By.linkText("ATTACHMENTS")).getText().equals(JobcategoryInputParameters.getattachments())) {
									flag = true;
									testStepStatus.setElementstatus("Request Tabs loaded");
									testStepStatus.setElementName("Request Tabs");
								} else {
									logger.info("ATTACHMENTS Not loaded  in the Request Tab"
											+ driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
											.get(1).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
									testStepStatus.setElementName("ATTACHMENTS");
								}
							} else {
								logger.info("RELATED JOBS Not loaded  in the Request Tab"
										+ driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(0)
										.isDisplayed());

								flag = false;
								testStepStatus.setElementstatus("RELATED JOBS Not loaded");
								testStepStatus.setElementName("RELATED JOBS");
							}
						} else {
							logger.info("ATTACHMENTS Not loaded  in the Request Tab"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4)
									.isDisplayed());

							flag = false;
							testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
							testStepStatus.setElementName("ATTACHMENTS");
						}
					} else {
						logger.info("CHATTER Not loaded  in the Job Tab" + driver
								.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3).isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("CHATTER Not loaded");
						testStepStatus.setElementName("CHATTER");
					}

				} else {
					logger.info("PAYBACK Not loaded  in the Request Tab" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("PAYBACK Not loaded");
					testStepStatus.setElementName("PAYBACK");
				}

			} else {
				logger.info("SURVEYS Not loaded  in the Request Tab"
						+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("SURVEYS Not loaded");
				testStepStatus.setElementName("SURVEYS");
			}

		} else {
			logger.info("TASKS Not loaded  in the Request Tab"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("TASKS Not loaded");
			testStepStatus.setElementName("TASKS");
		}
		return testStepStatus;
	}

	public static TestStepStatus verifyRequestTabsComm_Betterments(RemoteWebDriver driver) {
		ActionUtils.waitFor3Seconds();
		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("RELATED JOBS")).getText()
					.equals("RELATED JOBS")) {
						logger.info("ESTIMATES loaded  in the Job Tab-->" + driver.findElement(By.linkText("RELATED JOBS")).isDisplayed());
						/*if (driver.findElement(By.linkText("HISTORY")).getText()
						 .equals("HISTORY")) {
						 logger.info("HISTORY loaded  in the Job Tab-->"
						 + driver.findElement(By.linkText("HISTORY"))
						 .isDisplayed());*/
						if (driver.findElement(By.linkText("ATTACHMENTS")).getText()
						.equals("ATTACHMENTS")) {
							logger.info("ATTACHMENTS loaded  in the Job Tab-->"
									+ driver.findElement(By.linkText("ATTACHMENTS")));
							testStepStatus.setElementstatus("Request Tabs loaded");
							testStepStatus.setElementName("Request Tabs");
						} else {
							logger.info("PAYBACK Not loaded  in the Request Tab"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
									.get(2).isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("PAYBACK Not loaded");
							testStepStatus.setElementName("PAYBACK");
						}
					}
					/*} else {
					 logger.info("HISTORY Not loaded  in the Request Tab"
					 + driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(1)
					 .isDisplayed());
					 flag = false;
					 testStepStatus.setElementstatus("HISTORY Not loaded");
					 testStepStatus.setElementName("HISTORY");
					 }
					 }*/ else {
						logger.info("RELATED JOBS Not loaded  in the Request Tab"
								+ driver.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']")).get(0)
								.isDisplayed());

						flag = false;
						testStepStatus.setElementstatus("RELATED JOBS Not loaded");
						testStepStatus.setElementName("RELATED JOBS");
					}
				} else {
					logger.info("ATTACHMENTS Not loaded  in the Request Tab" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4).isDisplayed());

					flag = false;
					testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
					testStepStatus.setElementName("ATTACHMENTS");
				}
			} else {
				logger.info("CHATTER Not loaded  in the Job Tab" + driver
						.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("CHATTER Not loaded");
				testStepStatus.setElementName("CHATTER");
			}

		} else {
			logger.info("SURVEYS Not loaded  in the Request Tab"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("SURVEYS Not loaded");
			testStepStatus.setElementName("SURVEYS");
		}

		return testStepStatus;
	}

	public static TestStepStatus verifyHighlightPanel(RemoteWebDriver driver) {
		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(0)
		.isDisplayed()) {
			logger.info("Category - Type - Sub Type loaded"
					+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
					.get(0).isDisplayed());
			if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(1)
			.isDisplayed()) {
				logger.info("Description loaded"
						+ driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
						.get(1).isDisplayed());
				driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(0)
						.isDisplayed();
				if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText())).get(3)
				.getText().contains(JobcategoryInputParameters.getUnfunded())) {
					if (driver.findElements(By.cssSelector(JobcategoryInputParameters.getverifyHighlightPanelText()))
					.get(4).getText().contains(JobcategoryInputParameters.getOpened())) {
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

	}
	public static TestStepStatus verifyCommercialMetroConnectionJobTabs(RemoteWebDriver driver) {
		TestStepStatus testStepStatus = new TestStepStatus();
		if (driver.findElement(By.linkText("TASKS")).getText().equals(JobcategoryInputParameters.gettasks())) {
			logger.info(BettermentJobAction.Jobtype +"--"+"TASKS loaded  in the Job Tab-->"
					+driver.findElement(By.linkText("TASKS")).isDisplayed());
			if (driver.findElement(By.linkText("CHATTER")).getText()
			.equals(JobcategoryInputParameters.getchatter())) {
				logger.info("CHATTER loaded  in the Job Tab-->"
						+ driver.findElement(By.linkText("CHATTER")).isDisplayed());
				if (driver.findElement(By.linkText("SURVEYS")).getText()
				.equals(JobcategoryInputParameters.getsurveys())) {
					logger.info("SURVEYS loaded  in the Job Tab-->" +driver.findElement(By.linkText("SURVEYS")).isDisplayed());
					if (driver.findElement(By.linkText("ESTIMATES")).getText()
					.equals(JobcategoryInputParameters.getestimates())) {
						logger.info("ESTIMATES loaded  in the Job Tab-->" + driver.findElement(By.linkText("ESTIMATES")).isDisplayed());
						if (driver.findElement(By.linkText("PAYBACK")).getText()
						.equals(JobcategoryInputParameters.getpayback())) {
							logger.info("PAYBACK loaded  in the Job Tab-->"
									+ driver.findElement(By.linkText("PAYBACK"))
									.isDisplayed());
							if (driver.findElement(By.linkText("ADDRESSES")).getText()
							.equals(JobcategoryInputParameters.getaddress())) {
								logger.info("ADDRESSES loaded  in the Job Tab-->"
										+ driver.findElement(By.linkText("ADDRESSES"))
										.isDisplayed());
								if (driver.findElement(By.linkText("PERMITS")).getText().equals(JobcategoryInputParameters.getpermits())) {
									logger.info("PERMITS loaded  in the Job Tab-->" + driver.findElement(By.linkText("PERMITS"))
											.isDisplayed());
									if (driver.findElement(By.linkText("INVOICE LINES")).getText().equals(JobcategoryInputParameters.getinvoic_lines())) {
										logger.info("INVOICE LINES loaded  in the Job Tab-->" + driver.findElement(By.linkText("INVOICE LINES"))
												.isDisplayed());

										ActionUtils.waitFor2Seconds();
										if (driver.findElement(By.linkText("CONSTRUCTED FT")).getText().equals(JobcategoryInputParameters.getconstructed_ft())) {
											/*logger.info("CONSTRUCTED FT loaded  in the Job Tab-->" + driver
											 .findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
											 .get(0).isDisplayed());*/
											driver.findElement(By.cssSelector("button[title='More Tabs']")).click();
											ActionUtils.waitFor2Seconds();
											if (driver.findElement(By.linkText("FILE UPLOAD TEMPLATES")).getText().equals("FILE UPLOAD TEMPLATES")) {
												/*logger.info("File upload templates loaded  in the Job Tab-->" + driver
												 .findElements(
												 By.cssSelector("li[data-aura-class='uiMenuItem']"))
												 .get(2).isDisplayed());	*/
												if (driver
												.findElement(By.linkText("CONNECTIONS")).getText().equals("CONNECTIONS"))
													System.out.println("conections displayed -->"+driver
															.findElement(By.linkText("CONNECTIONS")).getText());

												if (driver
												.findElement
												(By.linkText("ATTACHMENTS")).getText().equals(JobcategoryInputParameters.getattachments())) {
													/*logger.info("ATTACHMENTS loaded  in the Job Tab-->" + driver
													 .findElements(
													 By.cssSelector("li[data-aura-class='uiMenuItem']"))
													 .get(3).isDisplayed());*/
													if (driver
													.findElement(
													By.linkText("HISTORY"))
													.getText().equals(JobcategoryInputParameters.gethistory())) {
														/*logger.info("HISTORY loaded  in the Job Tab-->" + driver
														 .findElements(By.cssSelector(
														 "li[data-aura-class='uiMenuItem']"))
														 .get(4).isDisplayed());*/
														flag = true;
														testStepStatus.setElementstatus("JOB Tabs loaded");
														testStepStatus.setElementName("JOB Tabs");
													} else {
														logger.info("HISTORY Not loaded  in the Job Tab" + driver
																.findElements(By.cssSelector(
																"li[data-aura-class='uiMenuItem']"))
																.get(4).isDisplayed());
														flag = false;
														testStepStatus.setElementstatus("HISTORY Not loaded");
														testStepStatus.setElementName("HISTORY");
													}
												}
												else {
													logger.info("ATTACHMENTS Not loaded  in the Job Tab-->" + driver
															.findElements(
															By.cssSelector("li[data-aura-class='uiMenuItem']"))
															.get(2).isDisplayed());

													flag = false;
													testStepStatus.setElementstatus("ATTACHMENTS Not loaded");
													testStepStatus.setElementName("ATTACHMENTS");
												}
											}

											else {
												logger.info("File Upload Template Not loaded  in the Job Tab" + driver
														.findElements(By.cssSelector(
														"li[data-aura-class='uiMenuItem']"))
														.get(3).isDisplayed());
												flag = false;
												testStepStatus.setElementstatus("Files Not loaded");
												testStepStatus.setElementName("HISTORY");
											}
										}  else {
											logger.info("JOB DETAILS Not loaded  in the Job Tab-->" + driver
													.findElements(
													By.cssSelector("li[data-aura-class='uiMenuItem']"))
													.get(1).isDisplayed());

											testStepStatus.setElementstatus("JOB DETAILS Not loaded");
											testStepStatus.setElementName("JOB DETAILS");
										}
									} else {
										logger.info("CONSTRUCTED FT Not loaded  in the Job Tab-->" + driver
												.findElements(By.cssSelector("li[data-aura-class='uiMenuItem']"))
												.get(0).isDisplayed());
										flag = false;
										testStepStatus.setElementstatus("CONSTRUCTED FT Not loaded");
										testStepStatus.setElementName("CONSTRUCTED FT");
									}
								} else {
									logger.info("INVOICE LINES Not loaded  in the Job Tab-->"
											+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
											.get(7).isDisplayed());
									flag = false;
									testStepStatus.setElementstatus("INVOICE LINES Not loaded");
									testStepStatus.setElementName("INVOICE LINES");
								}
							} else {
								logger.info("PERMITS Not loaded  in the Job Tab-->"
										+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']"))
										.get(6).isDisplayed());
								flag = false;
								testStepStatus.setElementstatus("PERMITS Not loaded");
								testStepStatus.setElementName("PERMITS");
							}
						} else {
							logger.info("ADDRESSES Not loaded  in the Job Tab-->"
									+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(5)
									.isDisplayed());
							flag = false;
							testStepStatus.setElementstatus("ADDRESSES Not loaded");
							testStepStatus.setElementName("ADDRESSES");
						}
					} else {
						logger.info("PAYBACK Not loaded  in the Job Tab-->"
								+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(4)
								.isDisplayed());
						flag = false;
						testStepStatus.setElementstatus("PAYBACK Not loaded");
						testStepStatus.setElementName("PAYBACK");
					}
				} else {
					logger.info("ESTIMATES Not loaded  in the Job Tab-->" + driver
							.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(3).isDisplayed());
					flag = false;
					testStepStatus.setElementstatus("ESTIMATES Not loaded");
					testStepStatus.setElementName("ESTIMATES");
				}
			} else {
				logger.info("SURVEYS Not loaded  in the Job Tab-->" + driver
						.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(2).isDisplayed());
				flag = false;
				testStepStatus.setElementstatus("SURVEYS Not loaded");
				testStepStatus.setElementName("SURVEYS");
			}
		} else {
			logger.info("CHATTER Not loaded  in the Job Tab-->"
					+ driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(1).isDisplayed());
			flag = false;
			testStepStatus.setElementstatus("CHATTER Not loaded");
			testStepStatus.setElementName("CHATTER");
		}
		/*} else {
		 logger.info("TASKS Not loaded  in the Job Tab-->"
		 + driver.findElements(By.cssSelector("li[data-aura-class='uiTabItem']")).get(0).isDisplayed());
		 flag = false;
		 testStepStatus.setElementstatus("TASKS Not loaded");
		 testStepStatus.setElementName("TASKS");
		 }*/
		return testStepStatus;
	}
	public static int randomNumber() {
		Random rand = new Random();
		// Generate random integers in range 0 to 999
		int rand_int1 = rand.nextInt(1000);
		return rand_int1;
	}
}
