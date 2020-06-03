package p2.util

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.time.StopWatch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable
import p2.Properties.HomePageXpathLocators;
import p2.Properties.TaskPageXpathLocators
import p2.validator.HomeValidator
import p2.common.ConstantValues
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ActionUtils {
	private static Logger logger = LogManager.getLogger(ActionUtils.class.getCanonicalName());
	//KeywordLogger logger = new KeywordLogger()
 	 String JobName="";
	public static void webDriveWait(RemoteWebDriver driver) {
		new WebDriverWait(driver, 30);
	}
	//public static void webDriveWait(RemoteWebDriver driver) {


	public static boolean verifIsElementPresent(RemoteWebDriver driver, String xpathValue) {

		driver.findElement(By.xpath(xpathValue));
		return true;

	}

	public static boolean P2Project_clk(RemoteWebDriver driver) {
		boolean isP2ProjectLoaded = false;
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(HomePageXpathLocators.getP2Project())))
				.click();
		isP2ProjectLoaded = HomeValidator.isP2ProjectDisplayed_JO(driver);
		//logger.Debug(isP2ProjectLoaded)
		logger.Debug("P2 project laoded Status: " + isP2ProjectLoaded);
		return isP2ProjectLoaded;
		//logger.logInfo(isP2ProjectLoaded)

	}

	public WebElement explicitWaitForElement_id(RemoteWebDriver driver, String element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement ele = null;
		try {
			ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
		} catch (Exception e) {
			logger.debug("Exception Occured " + e);
		}
		return ele;
	}

	public WebElement explicitWaitForElement_linkText(RemoteWebDriver driver, String element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement ele = null;
		try {
			ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(element)));
		} catch (Exception e) {
			logger.debug("Exception Occured " + e);
		}
		return ele;
	}

	public void createExcelSheet(RemoteWebDriver driver, String filename) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			FileOutputStream out = new FileOutputStream(
					new File(System.getProperty("user.dir") + "/Upload/" + filename));
			workbook.write(out);
			out.close();
			//workbook.close();
			logger.debug("createworkbook.csv written successfully");
		} catch (Exception e) {

		}

	}

	public void createExcelWithData(RemoteWebDriver driver, String filename) {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
		double lat = 4.2033;
		double laong = -76.1945;

		/*Object[][] datatypes = { { "Child_Node_Version2" },
		 { "ParentNode", "ChildNode", "JobType", "ChildNodeLatitude", "ChildNodeLongitude",
		 "DesignedBandwidthMhz", "MUXIdentifier", "DEMUXIdentifier", "ChannelUpstreamWavelength",
		 "ChannelDownstreamWavelength", "AerialResidentialPassings", "UGResidentialPassings",
		 "AerialCommercialPassings", "UGCommercialPassings", "AerialMDUPassings", "UGMDUPassings",
		 "TransferrableCommercialPassings", "TotalFeet1.2Ghz", "TotalAerialPlantFeet",
		 "TotalUGPlantFeet", "AerialNewCoaxPublic", "AerialNewCoaxPrivate", "UndergroundNewCoaxPublic",
		 "UndergroundNewCoaxPrivate", "AerialNewFiberPublic", "AerialNewFiberPrivate",
		 "UndergroundNewFiberPublic", "UndergroundNewFiberPrivate",
		 "ExistingAerialRoutewithNewCoaxPublic", "ExistingAerialRoutewithNewCoaxPrivate",
		 "ExistingAerialRoutewithNewFiberPublic", "ExistingAerialRoutewithNewFiberPrivate",
		 "ExistingUndergroundRoutewithNewCoaxPublic", "ExistingUndergroundRoutewithNewCoaxPrivate",
		 "ExistingUndergroundRoutewithNewFiberPublic", "ExistingUndergroundRoutewithNewFiberPrivate",
		 "VerticalFootage", "RightOfWayFootage", "PrivatePropertyFootage", "EasementsFootage" },
		 { "NCPNODERT", "TECZ0U76612", "Fiber Deep", lat, laong, 100, "abcd", "efgh", "ijkl", "mnop", 0,
		 106, 107, 108, 109, 110, 1100, 111, 112, 113, 114, 1114, 115, 1115, 114, 0, 115, 1115, 118,
		 1118, 119, 1201, 120, 12, 120, 120, 120, 120, 120, 120, },
		 { "float", "Primitive", 4 }, { "double", "Primitive", 8 }, { "char", "Primitive", 1 },
		 { "String", "Non-Primitive", "No fixed size", "abc" } };*/

		int rowNum = 0;
		System.out.println("Creating excel");

		for (Object[] datatype : datatypes) {
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (Object field : datatype) {
				Cell cell = row.createCell(colNum++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				} else if (field instanceof Double) {
					cell.setCellValue((Double) field);
				}
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(
					System.getProperty("user.dir") + "/Upload/" + filename);
			workbook.write(outputStream);

			//workbook.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}

	public void fileUpload(RemoteWebDriver driver, String filename) {
		try {
			ActionUtils.waitFor3Seconds();
			driver.findElement(By.cssSelector(TaskPageXpathLocators.getChooseFile()))
					.sendKeys(System.getProperty("user.dir") + "/Upload/" + filename);
			ActionUtils.waitFor3Seconds();
			driver.findElement(By.cssSelector(TaskPageXpathLocators.getUploadFile())).click();
			StopWatch pageLoad = new StopWatch();
			pageLoad.start();
			WebDriverWait wait12 = new WebDriverWait(driver, 400);
			wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TaskPageXpathLocators.getToastMsg())));
			pageLoad.stop();
			long pageLoadTime_ms = pageLoad.getTime();
			long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
			logger.debug("Total Page Load Time: " + pageLoadTime_ms + " ms");
			test.log(Status.INFO,
					MarkupHelper.createLabel("Total Page Load Time: " + pageLoadTime_ms + " ms", ExtentColor.BROWN));
			logger.debug("Total Page Load Time: " + pageLoadTime_Seconds + " s");
			test.log(Status.INFO, MarkupHelper.createLabel("Total Page Load Time: " + pageLoadTime_Seconds + " s",
					ExtentColor.BROWN));

		} catch (Exception e) {

		}
	}

	public WebElement explicitWaitForElement_Xpath(RemoteWebDriver driver, String element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement ele = null;
		try {
			ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
		} catch (Exception e) {
			logger.debug("Exception Occured " + e);
		}
		return ele;
	}

	public static String getText_Xpath(RemoteWebDriver driver, String path) {
		String getTxt = null;
		try {
			WebElement element = driver.findElement(By.xpath(path));
			getTxt = element.getText();
			logger.debug("Text: " + getTxt);
		} catch (Exception e) {
			logger.debug("Excpetion occured: " + e);
		}

		return getTxt;

	}

	public static String getText_LinkTxt(RemoteWebDriver driver, String linkTxt) {
		WebElement element = driver.findElement(By.linkText(linkTxt));
		String getTxt = element.getText();

		return getTxt;

	}

	public void switchTab(RemoteWebDriver driver) {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		ActionUtils.waitFor3Seconds();
	}



	public void switchtoParentTab(RemoteWebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(ConstantValues.TAB_STEP_0));
		ActionUtils.waitFor5Seconds();

	}

	public static String getText_ClassName(RemoteWebDriver driver, String classname) {
		WebElement element = driver.findElement(By.className(classname));
		String getTxt = element.getText();

		return getTxt;

	}

	public static String getAttribute_ClassName(RemoteWebDriver driver, String classname, String atrributeName) {
		WebElement element = driver.findElement(By.className(classname));
		String getTxt = element.getAttribute(atrributeName);

		return getTxt;

	}

	public static String getText_CssSelector(RemoteWebDriver driver, String cssSelector) {

		String getTxt = null;
		try {
			WebElement element = driver.findElement(By.cssSelector(cssSelector));
			getTxt = element.getText();
		} catch (NoSuchElementException ex) {
			logger.debug("Exception occured: Element not found " + cssSelector);
			getTxt = null;
		}
		return getTxt;

	}

	public static boolean isElementPresent_linktext(RemoteWebDriver driver, String linkText) {
		boolean isElementPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			if (wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).isDisplayed()) {
				isElementPresent = true;
				logger.debug("Element " + linkText + " isElementFound : true ");
			}
			waitForLoad(driver);

			if (wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).isDisplayed()) {
				isElementPresent = true;
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element " + linkText + " isElementFound : false ");
			isElementPresent = false;
		}
		return isElementPresent;
	}

	public static boolean isElementPresent_id(RemoteWebDriver driver, String id) {
		boolean isElementPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			if (wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).isDisplayed()) {
				isElementPresent = true;
				logger.debug("Element " + id + " isElementFound : true ");
			}
			waitForLoad(driver);

			if (wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).isDisplayed()) {
				isElementPresent = true;
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element" + id + "isElementFound : false ");
			isElementPresent = false;
		}
		return isElementPresent;
	}

	public static boolean isElementPresent_LinkText_Driver(RemoteWebDriver driver, String xpath) {
		boolean isElementPresent = false;
		try {
			if (driver.findElement(By.linkText(xpath)).isDisplayed()) {
				isElementPresent = true;
				logger.debug("Element " + xpath + " isElementFound : true ");
			} else {
				isElementPresent = false;
				waitForLoad(driver);
				// Check for element after the wait time
				if (driver.findElement(By.linkText(xpath)).isDisplayed()) {
					isElementPresent = true;
				}
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element " + xpath + " isElement Found : false ");
			isElementPresent = false;
		}
		return isElementPresent;
	}

	public static boolean isElementPresent_Xpath(RemoteWebDriver driver, String xpath) {
		boolean isElementPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).isDisplayed()) {
				isElementPresent = true;
				logger.debug("Element " + xpath + " isElementFound : true ");
			} else {
				waitForLoad(driver);
				// Check for element after the wait time
				if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).isDisplayed()) {
					isElementPresent = true;
				}
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element " + xpath + "i sElementFound : false ");
			isElementPresent = false;
		}
		return isElementPresent;
	}

	public static boolean isElementPresent_XpathDr(RemoteWebDriver driver, String xpath) {
		boolean isElementPresent = false;

		try {
			if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
				isElementPresent = true;
				logger.debug("Element " + xpath + " isElementFound : true ");
			} else {
				waitForLoad(driver);
				// Check for element after the wait time
				if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
					isElementPresent = true;
				}
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element " + xpath + " isElementFound : false ");
			isElementPresent = false;
		}
		return isElementPresent;
	}

	public static boolean isElementEnabled_XpathDr(RemoteWebDriver driver, String xpath) {
		boolean isElementEnabled = false;

		try {
			if (driver.findElement(By.xpath(xpath)).isEnabled()) {
				isElementEnabled = true;
				logger.debug("Element " + xpath + " isElementFound : true ");
			} else {
				waitForLoad(driver);
				// Check for element after the wait time
				if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
					isElementEnabled = true;
				}
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element " + xpath + " isElementFound : false ");
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	public static boolean isElementEnabled_CssSelectorDr(RemoteWebDriver driver, String cssSelector) {
		boolean isElementEnabled = false;

		try {
			if (driver.findElement(By.cssSelector(cssSelector)).isEnabled()) {
				isElementEnabled = true;
				logger.debug("Element " + cssSelector + " isElementFound : true ");
			} else {
				waitForLoad(driver);
				// Check for element after the wait time
				if (driver.findElement(By.cssSelector(cssSelector)).isDisplayed()) {
					isElementEnabled = true;
				}
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			logger.debug("Element " + cssSelector + " isElementFound : false ");
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	public static void waitForLoad(RemoteWebDriver driver) {
		logger.debug("wait time start " + System.currentTimeMillis());
		long start = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver wd) {
						logger.debug("condition  " + ((JavascriptExecutor) wd).executeScript("return document.readyState"));
						// this will tel if page is loaded
						return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
					}
				};
		WebDriverWait wait = new WebDriverWait(driver, 60);
		// wait for page complete
		wait.until(pageLoadCondition);
		// lower implicitly wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		logger.debug(
				"wait time end " + System.currentTimeMillis() + "total time " + (System.currentTimeMillis() - start));
	}

	public static void clckImportNodes(RemoteWebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(HomePageXpathLocators.getImportNodes())))
				.click();
	}

	public static void clckElement_Lnktxt(RemoteWebDriver driver, String linktext) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linktext))).click();
	}

	public static void clckElement_Lnktxt_dr(RemoteWebDriver driver, String linktext) {
		try {
			driver.findElement(By.linkText(linktext)).click();
			logger.debug("Element clicked successfully");
		} catch (Exception e) {
			logger.debug("Exception Occured");
		}

	}

	public static void slct_BP(RemoteWebDriver driver, String bp) {
		TaskPageXpathLocators.getTxtBx_BP()
		driver.findElement(By.xpath(TaskPageXpathLocators.getTxtBx_BP())).click();
		ActionUtils.waitFor1Seconds();
		WebElement element = driver.findElement(By.xpath(TaskPageXpathLocators.getInputType_BP()));
		element.sendKeys(bp);
		ActionUtils.waitFor1Seconds();
		driver.findElement(By.xpath(TaskPageXpathLocators.getSelect_BP())).click();

	}

	public static void clkElement_Xpath(RemoteWebDriver driver, String xpath) {
		try {
			driver.findElement(By.xpath(xpath)).click();
			waitFor2Seconds();
			logger.debug("Element clicked successfully");

		} catch (Exception e) {
			logger.debug("Exception occured");
		}

	}

	public static void clkElement_cssSelector(RemoteWebDriver driver, String cssSelector) {

		try {
			driver.findElement(By.cssSelector(cssSelector)).click();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			logger.debug("Excpetion occured");
		}

	}

	public static void clkElement_id(RemoteWebDriver driver, String id) {
		driver.findElement(By.id(id)).click();

	}

	public static void clckCreatePhase(RemoteWebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(HomePageXpathLocators.getCreatPhase()))).click();
	}

	public static void assignTask(RemoteWebDriver driver, String bp, int count) throws Exception {

		clckElement_Lnktxt_dr(driver, TaskPageXpathLocators.getAssignBtn());
		waitFor3Seconds();

		String getTxt = ActionUtils.getText_CssSelector(driver, "span[class='pillText']");
		System.err.println(getTxt);
		if (getTxt != null && !getTxt.isEmpty()) {
			clkElement_cssSelector(driver, "span[class='deleteIcon']");
			slct_BP(driver, bp);
		} else {
			slct_BP(driver, bp);
		}
		driver.findElement(By.xpath(TaskPageXpathLocators.getInput_Date())).sendKeys(addCurrentdate(count));
		driver.findElement(By.xpath(TaskPageXpathLocators.getSaveBtn_Assign())).click();
		waitFor1Seconds();
		String screenshotPath = CommonUtils.getScreenshot(driver, "Task Assignment");
		//test.addScreenCaptureFromPath(screenshotPath);

	}

	public static void clkTask(RemoteWebDriver driver, String taskName) {
		clckElement_Lnktxt(driver,   taskName);
	 	//clckElement_Lnktxt(driver, JobName.toString() + taskName);
		// driver.findElement(By.linkText(JobName+taskName)).click();

	}

	public static void clkscroll_linkText(RemoteWebDriver driver, String inpuElement) {
		waitFor2Seconds();
		// Actions actions = new Actions(driver);
		JavascriptExecutor je = driver;
		WebElement element = driver.findElement(By.linkText(inpuElement));

		je.executeScript("arguments[0].scrollIntoView();", element);
		je.executeScript("scroll(0,250);");
		element.click();
		waitFor2Seconds();

	}

	public static void clkscroll_Xpath(RemoteWebDriver driver, String inpuElement) {
		waitFor2Seconds();
		// Actions actions = new Actions(driver);
		JavascriptExecutor je = driver;
		WebElement element = driver.findElement(By.xpath(inpuElement));

		je.executeScript("arguments[0].scrollIntoView();", element);
		je.executeScript("scroll(0,250);");
		element.click();
		waitFor2Seconds();

	}

	public static void createJob(RemoteWebDriver driver) throws Exception {
		WebElement el = driver.findElement(By.xpath(TaskPageXpathLocators.getTaskStatus_BP()));
		el.getAttribute("title");
	//	test.log(Status.PASS, MarkupHelper.createLabel("Task Status: " + el.getAttribute("title"), ExtentColor.GREEN));
		logger.info(el.getAttribute("title"));
		int i = 1;
		String itempath = HomePageXpathLocators.getJobCheckBox();
		boolean checkBoxStatus = false;
		WebElement elem = driver.findElement(By.className(HomePageXpathLocators.getNoofParentNodes()));
		String innerHTML = elem.getAttribute(ConstantValues.INNERHTML);
		logger.debug("Inside Class Element: " + innerHTML);
		//test.log(Status.PASS, MarkupHelper.createLabel("Inside Class Element: " + innerHTML, ExtentColor.GREEN));
		String insideTxt = elem.getText();
		logger.debug("No of Parent Nodes:  " + insideTxt);
		//test.log(Status.INFO, MarkupHelper.createLabel("No of Parent Nodes:  " + insideTxt, ExtentColor.BROWN));
		String noOfParentNodes = insideTxt.substring(26, insideTxt.length());
		logger.debug(noOfParentNodes);
		for (i = 1; i <= noOfParentNodes.length(); i++) {
			itempath = HomePageXpathLocators.getJobCheckBox().replace("tr[input]", "tr[" + i + "]");
			logger.debug(itempath);
			checkBoxStatus = driver.findElement(By.xpath(itempath)).isEnabled();
			logger.debug("Is Checkbox displayed: " + checkBoxStatus);
		//	test.log(Status.INFO,
		//			MarkupHelper.createLabel("Is Checkbox displayed: " + checkBoxStatus, ExtentColor.BROWN));
			if (checkBoxStatus) {

				driver.findElement(By.xpath(itempath.replace("/input", "/span[1]"))).click();
				driver.findElement(By.xpath(HomePageXpathLocators.getBtn_Assign_Phase())).click();
				Select oSelect = new Select(
						driver.findElement(By.cssSelector(HomePageXpathLocators.getDropdown_assignPhase())));
				oSelect.selectByIndex(1);
				waitFor10Seconds();
				WebElement jobElement = driver.findElement(By.xpath(HomePageXpathLocators.getBtn_CreateJob()));
				jobElement.click();
				waitFor3Seconds();
				String screenshotPath = CommonUtils.getScreenshot(driver, "JobCreation Message");
				//test.log(Status.PASS, MarkupHelper.createLabel("Job created successfully", ExtentColor.GREEN));
				//test.addScreenCaptureFromPath(screenshotPath);
				waitFor15Seconds();
				String jobItemPath = HomePageXpathLocators.getJobid_Get().replace("tr[input]", "tr[" + i + "]");
				WebElement jobId = driver.findElement(By.xpath(jobItemPath));
			//	JobName = jobId.getAttribute("title");
			//	logger.debug("Created Job Name: " + JobName);
			//	test.log(Status.INFO, MarkupHelper.createLabel("Created Job Name: " + JobName, ExtentColor.BROWN));
				driver.findElement(By.xpath(jobItemPath + "/a")).click();

				waitFor15Seconds();
				waitFor15Seconds();

				break;
			} else {
				/*
				 * if(i<=noOfParentNodes.length()) { Actions actions = new Actions(driver);
				 * JavascriptExecutor je = (JavascriptExecutor) driver; WebElement element =
				 * driver.findElement(By.xpath("//*[@id='popUpTable1']")); element.click();
				 * je.executeScript("arguments[0].scrollIntoView();" ,element);
				 * je.executeScript("scroll(0,250);"); actions.moveToElement(element).perform();
				 * }else { }
				 */

			}

		}

	}

	public static String currentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}

	public static String addCurrentdate(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

	public static void waitFor3Seconds() {
		try {
			Thread.sleep(ConstantValues.THREE_SECONDS_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

	public static void waitFor1Seconds() {
		try {
			Thread.sleep(ConstantValues.ONE_SECOND_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

	public static void waitFor10Seconds() {
		try {
			Thread.sleep(ConstantValues.TEN_SECONDS_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

	public static void waitFor15Seconds() {
		try {
			Thread.sleep(ConstantValues.FIFTEEN_SECONDS_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

	public static void waitFor30Seconds() {
		try {
			Thread.sleep(ConstantValues.THIRTEEN_SECONDS_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

	public static void waitFor5Seconds() {
		try {
			Thread.sleep(ConstantValues.FIVE_SECONDS_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

	public static void waitFor2Seconds() {
		try {
			Thread.sleep(ConstantValues.TWO_SECOND_IN_MILLISECONDS);
		} catch (InterruptedException e) {
			logger.debug("Exception: " + e.getMessage());
		}
	}

}
