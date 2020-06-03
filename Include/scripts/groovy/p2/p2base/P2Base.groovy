package p2.p2base

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

import internal.GlobalVariable

import java.net.MalformedURLException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

//import com.aventstack.extentreports.ExtentReports;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/
//import com.comcast.p2.test.XpathLocators.AppLauncherPageXpathLocators;
//import com.comcast.p2.test.XpathLocators.ApplauncherInputParameters;
//import com.comcast.p2.test.XpathLocators.CommonXpathLocators;
import p2.Properties.HomePageXpathLocators;
//import com.comcast.p2.test.XpathLocators.InputParameterXapthLocators;
//import com.comcast.p2.test.XpathLocators.InvoiceinputParameters;
import p2.Properties.JobcategoryInputParameters;
//import com.comcast.p2.test.XpathLocators.JobsPageXpathLocators;
import p2.Properties.LoginPageXpathLocators;
//import com.comcast.p2.test.XpathLocators.NewImportInputParameters;
//import com.comcast.p2.test.XpathLocators.NewJobInputparameters;
//import com.comcast.p2.test.XpathLocators.NewPhaseInputparameters;
//import com.comcast.p2.test.XpathLocators.NewProjectInputParameters;
//import com.comcast.p2.test.XpathLocators.POReservationinputParams;
//import com.comcast.p2.test.XpathLocators.PermitInputparameters;
import p2.Properties.TaskmanagementProperties;
import p2.Properties.TaskPageXpathLocators;
import p2.Properties.TaskRuleInputParameters
import p2.dataType.TestCaseResult;
import p2.dataType.TestStepStatus;
public class P2Base {
	public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	protected ThreadLocal<RemoteWebDriver> driver_seq = new ThreadLocal<>();
	protected InternetExplorerDriver driver1 = null;
	protected String testUrl = null;
	protected String usrName_jo = null;
	protected String usrName_bp = null;
	protected String usrName_ig = null;
	protected String usrName_sa = null;
	protected String password_jo = null;
	protected String password_bp = null;
	protected String password_sa = null;
	protected String password_ig = null;
	protected String hostIp = null;
	protected String hostIp_Seq = null;
	protected String btnLogin = null;
	protected String browser_Info = null;
	protected String single_loginInfo = null;
	protected String report;
	protected String count_Info = null;
	protected String reason = null;
	protected static String JobName = null;
	protected static String JobID = null;
	protected TestCaseResult testCaseStatus = new TestCaseResult();
	protected static List<TestCaseResult> testStatus;
	protected static List<TestStepStatus> stepResult = new ArrayList<TestStepStatus>();
	private static Logger logger = LogManager.getLogger(P2Base.class.getCanonicalName());
	//protected static ExtentHtmlReporter htmlReporter;
//	protected static ExtentReports extent;
//	protected static ExtentTest test;
	protected static String walkoutTaskID;
	protected DesiredCapabilities capabilities = null;
	protected char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	protected static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	protected static StringBuilder postSlackMessage = new StringBuilder();
	protected static StringBuilder PlayVideosFailure = new StringBuilder();
	protected static int passStatus = 0;
	protected static int failStatus = 0;
	protected static int otherStatus = 0;
	static byte[] bytesArray;
	private static final String BROWSER = "browser";
	private static final String HOST = "host";
	private static final String URL = "url";
	protected static final String USR_JO = "usrname_jo";
	private static final String USR_BP = "usrname_bp";
	protected static final String USR_IG = "usrname_ig";
	private static final String USR_SA = "usrname_sa";
	protected static final String PWD_JO = "pwd_jo";
	private static final String PWD_BP = "pwd_bp";
	private static final String PWD_IG = "pwd_ig";
	private static final String PWD_SA = "pwd_sa";
	private static final String SINGLE_LOGIN = "single_login";
	
	
	@BeforeSuite
	public void setupReporting() {

		/*logger.debug("Before suite ----->");
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/report/Polaris_Execution.html");
		// htmlReporter = new
		// ExtentHtmlReporter("C:/Apache/webapps/examples/hcheck/CMS_healthCheck.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Host Name", "Polaris QA");
		extent.setSystemInfo("User Name", "Guna");

		htmlReporter.config().setDocumentTitle(" Ploaris 2");
		htmlReporter.config().setReportName("Execution Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(false);*/

	}


	public void driverSetup() {
		
		 String browser_Value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(BROWSER);
		 String host_Value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(HOST);
			 testUrl = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(URL);
			 usrName_ig = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(USR_IG);
			usrName_jo = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(USR_JO);
			usrName_bp = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(USR_BP);
			usrName_sa = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(USR_SA);
			password_jo = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(PWD_JO);
			password_bp = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(PWD_BP);
			password_sa = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(PWD_SA);
			password_ig = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(PWD_IG);
			hostIp = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(HOST);
			hostIp_Seq = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(BROWSER);
			browser_Info = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(BROWSER);
			single_loginInfo = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(SINGLE_LOGIN);
		 
		if (browser_Value.equals("firefox")) {
			new DesiredCapabilities();
			capabilities = DesiredCapabilities.firefox();
			FirefoxProfile profile = new FirefoxProfile();
			// Accept Untrusted Certificates
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			// Use No Proxy Settings
			profile.setPreference("network.proxy.type", 0);
			// Set Firefox profile to capabilities
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			// chrome proifle setting
		} else if (browser_Value.equals("chrome")) {
			new DesiredCapabilities();
			capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--use-fake-ui-for-media-stream=1");
			options.addArguments("--disable-notifications");
			// options.addArguments("--use-fake-device-for-media-stream=1");
			// options.addArguments(
			// "--disable-user-media-security,--use-fake-ui-for-media-stream',
			// --use-fake-device-for-media-stream', --disable-web-security',
			// --reduce-security-for-testing");

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		}
		// Set Platform
		capabilities.setPlatform(Platform.ANY);
		// Set BrowserName
		capabilities.setCapability("browserName", browser_Value);
		try {
			driver.set(new RemoteWebDriver(new URL("http://" + host_Value + "/wd/hub"), capabilities));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loadConfig();
	}
	
	// Loads all configs that needs to be read from file
		public void loadConfig() {

			if (!new HomePageXpathLocators().loadConfig() || !new JobcategoryInputParameters().loadConfig() || !new LoginPageXpathLocators().loadConfig()
					|| !new TaskPageXpathLocators().loadConfig() 
					/*|| !new CommonXpathLocators().loadConfig()
					|| !new JobsPageXpathLocators().loadConfig()
					|| !new InputParameterXapthLocators().loadConfig()
					|| !new AppLauncherPageXpathLocators().loadConfig()
					||!new NewProjectInputParameters().loadConfig()
					|| !new NewPhaseInputparameters().loadConfig() 
					|| !new NewImportInputParameters().loadConfig() ||
					//!new NewJobInputparameters().loadConfig()
*/					//|| !new PermitInputparameters().loadConfig() ||
				//	!new InvoiceinputParameters().loadConfig() 
					//|| !new ApplauncherInputParameters().loadConfig() 
					||	!new TaskRuleInputParameters().loadConfig()
					 //|| !new TaskManagementInputParameters().loadConfig()
					 //||!new POReservationinputParams().loadConfig()
					) {
				throw new SkipException("Config file loading failed");

			}

		}
	public RemoteWebDriver getDriver() {
				
		return driver.get();
	}

	public RemoteWebDriver getDriver_Seq() {
		return driver_seq.get();
	}

	/*@AfterMethod
	public void tearDown() throws Exception {
		logger.debug("After class is called");
		logger.debug("Test case status " + testCaseStatus.getBrowser() + "-> " + testCaseStatus.getTestCasestatus()
				+ " ->" + testCaseStatus.getTestCaseFailReason() + " -> " + testCaseStatus.getStepFailed());
		String testStatus = testCaseStatus.getTestCasestatus();
		if (testStatus.equals("fail")) {
			failStatus = failStatus + 1;
		} else if (testStatus.equals("pass")) {
			passStatus = passStatus + 1;
		} else {
			otherStatus = otherStatus + 1;
		}

		getDriver().quit();
	}*/
	/*@AfterTest
	public void endReport() {
		extent.flush();
		logger.debug("After class is called");
		getDriver().quit();
		// getDriver_Seq().quit();
	}*/
/*
	@AfterClass
	public void afterclass() {
		 extent.flush();
		logger.debug("After class is called");
		getDriver().quit();
	}
*/
	}
