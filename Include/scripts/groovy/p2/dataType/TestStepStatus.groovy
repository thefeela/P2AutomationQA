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

import internal.GlobalVariable

public class TestStepStatus implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	
		private boolean pass;
		private String failureReason;
		private int stepNum;
		private String elementstatus;
		private String elementName;
		
		public String getElementName() {
			return elementName;
		}
	
		public void setElementName(String elementName) {
			this.elementName = elementName;
		}
	
			public String getElementstatus() {
				return elementstatus;
			}
	
			public void setElementstatus(String elementstatus) {
				this.elementstatus = elementstatus;
			}
	
		public boolean isPass() {
			return pass;
		}
	
		public void setPass(boolean pass) {
			this.pass = pass;
		}
	
		public String getFailureReason() {
			return failureReason;
		}
	
		public void setFailureReason(String failureReason) {
			this.failureReason = failureReason;
		}
	
		public int getStepNum() {
			return stepNum;
		}
	
		public void setStepNum(int stepNum) {
			this.stepNum = stepNum;
		}
	
}
