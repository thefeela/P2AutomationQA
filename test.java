


package com.comcast.p2.test.actions;

import com.comcast.p2.test.P2Base;
import com.comcast.p2.test.XpathLocators.JobcategoryInputParameters;
import com.comcast.p2.test.XpathLocators.LoginPageXpathLocators;
import com.comcast.p2.util.ActionUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Guna
 */
public class LoginAction extends P2Base{
	//final static Logger logger = Logger.getLogger(classname.class);
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
