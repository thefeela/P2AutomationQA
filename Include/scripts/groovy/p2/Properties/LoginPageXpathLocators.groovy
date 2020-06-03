package p2.Properties

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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

public class LoginPageXpathLocators {
	private static Logger logger = LogManager.getLogger(LoginPageXpathLocators.class.getCanonicalName());
	
		static Map<String, String> loginMap = new HashMap<String, String>();
	
		public boolean loadConfig() {
	
			boolean configLoaded = false;
			Properties prop = new Properties();
			try {
				FileInputStream fip = new FileInputStream("./src/main/resources/loginPage.Properties");
				prop.load(fip);
				//loginMap.putAll(prop.entrySet().stream()
					//	.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
				loginMap.putAll(prop.entrySet().stream().collect());
				configLoaded = true;
			} catch (FileNotFoundException e1) {
				logger.error("error loading file " + e1.getMessage());
			} catch (IOException e1) {
				logger.error("error loading file IOException " + e1.getMessage());
			}
			return configLoaded;
	
		}
	
		// home screen logo
		public static String getHomeScreenLogo() {
			return loginMap.get("homeLogo");
		}
	
		// home screen logo
		public static String getUSernameTxtBx() {
			return loginMap.get("userTxtBx");
		}
	
		// home screen logo
		public static String getLoginBtn() {
			return loginMap.get("loginBtn");
		}
	
		// home screen logo
		public static String getPassTxtBx() {
			return loginMap.get("passTxtBx");
		}
		public static String getUsername() {
			return loginMap.get("username");
		}
		public static String getForgotpassword() {
			return loginMap.get("forgotpassword");
		}
		public static String getContinue() {
			return loginMap.get("continue");
		}
		public static String getCancel() {
			return loginMap.get("cancel");
		}
		public static String getInvalidJo_username() {
			return loginMap.get("invalidJo_username");
		}
		public static String getInvalidJo_password() {
			return loginMap.get("invalidJo_password");
		}
		public static String getInvalidBp_username() {
			return loginMap.get("invalidBp_username");
		}
		
		public static String getInvalidBp_password() {
			return loginMap.get("invalidBp_password");
		}
		public static String getError_id() {
			return loginMap.get("error_id");
		}
		
	
		
		// home screen logo
		public static String getLogin_error() {
			return loginMap.get("login_error");
		}
}
