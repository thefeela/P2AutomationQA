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
import com.kms.katalon.core.model.FailureHandling
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import com.comcast.p2.test.P2Base;
import p2.Properties.JobcategoryInputParameters
import p2.Properties.LoginPageXpathLocators;
import p2.util.ActionUtils;
import p2.p2base.P2Base


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
public class LoginAction extends P2Base{
	private static Logger logger = LogManager.getLogger(LoginAction.class.getCanonicalName());
	public void loadUrl(RemoteWebDriver driver, String url) {
		driver.get(url);
		//driver.get("https://polaris2--regression.cs26.my.salesforce.com");
		//	driver.get("https://www.google.com/search?q=goo&rlz=1C1GGRV_enIN763IN763&oq=goo&aqs=chrome..69i57j69i60l4j69i59.1633j0j9&sourceid=chrome&ie=UTF-8");
		driver.manage().window().maximize();
		ActionUtils.waitFor5Seconds();
		logger.debug("URL loaded into the browser");
		logger.info("URL loaded into the browser");
		logger.error("URL loaded into the browser");
		//	driver.findElement(By.linkText("https://www.google.com/"));
		//	driver.findElements(By.cssSelector("h3[class='LC20lb']")).get(0).click();
		//	ActionUtils.waitFor10Seconds();
	}

	public void login(RemoteWebDriver driver, String username, String pass) {
		driver.findElement(By.id(LoginPageXpathLocators.getUSernameTxtBx())).sendKeys(username);
		driver.findElement(By.id(LoginPageXpathLocators.getPassTxtBx())).sendKeys(pass);
		driver.findElement(By.id(LoginPageXpathLocators.getLoginBtn())).click();

		if(username.contains("p2.com.training")){
			System.out.println("Finish button");
			ActionUtils.waitFor5Seconds();
			ActionUtils.waitFor5Seconds();
			driver.findElement(By.cssSelector(JobcategoryInputParameters.getfinish_button())).click();
			ActionUtils.waitFor5Seconds();
		}else {
			ActionUtils.waitFor30Seconds();
			ActionUtils.waitFor30Seconds();
		}
	}
}
