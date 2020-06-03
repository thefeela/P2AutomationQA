package p2.dataType

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
/**
 * @author Guna
 */
import java.util.List;

/*
 * Datatype to hold the testcase status.
 */
import internal.GlobalVariable

public class TestCaseResult implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
		private String testCase;
		private String host;
		private String browser;
		private String testCaseStatus;
		private String testCaseFailReason;
		private int stepFailed;
		private List<TestStepStatus> stepStatus;
	
		public String getTestCasestatus() {
			return testCaseStatus;
		}
	
		public void setTestCasestatus(String testCaseStatus) {
			this.testCaseStatus = testCaseStatus;
		}
	
		public String getTestCaseFailReason() {
			return testCaseFailReason;
		}
	
		public void setTestCaseFailReason(String testCaseFailReason) {
			this.testCaseFailReason = testCaseFailReason;
		}
	
		public String getTestCase() {
			return testCase;
		}
	
		public void setTestCase(String testCase) {
			this.testCase = testCase;
		}
	
		public String getHost() {
			return host;
		}
	
		public void setHost(String host) {
			this.host = host;
		}
	
		public String getBrowser() {
			return browser;
		}
	
		public void setBrowser(String browser) {
			this.browser = browser;
		}
	
		public int getStepFailed() {
			return stepFailed;
		}
	
		public void setStepFailed(int stepFailed) {
			this.stepFailed = stepFailed;
		}
	
		public List<TestStepStatus> getStepStatus() {
			return stepStatus;
		}
	
		public void setStepStatus(List<TestStepStatus> stepStatus) {
			this.stepStatus = stepStatus;
		}
}
