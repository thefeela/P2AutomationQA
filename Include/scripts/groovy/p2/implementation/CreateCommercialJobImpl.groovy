package p2.implementation

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
import java.util.ArrayList;
import java.util.List;
import internal.GlobalVariable
import p2.p2base.P2Base

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import  p2.p2base.P2Base;
import p2.action.BettermentJobAction;
import p2.action.CommercialJobAction;
import p2.action.LoginAction;
import p2.dataType.TestStepStatus;
import p2.util.ActionUtils;
import p2.util.CommonUtils;
public class CreateCommercialJobImpl  extends P2Base{
	LoginAction login = new LoginAction();
	List<TestStepStatus> stepResult = new ArrayList<TestStepStatus>();
CommercialJobAction commercialJobAction=new CommercialJobAction();
BettermentJobAction bettermentJobAction=new BettermentJobAction();
public static String jobtype_Metro;
public static String jobtype_subtype;
TestStepStatus result;

	public void step1(TestStepStatus status) throws InterruptedException {
		driverSetup();
		login.loadUrl(getDriver(), testUrl);
		login.login(getDriver(), usrName_jo, password_jo);
		ActionUtils.waitFor5Seconds();
	
		status.setPass(true);
		// test.log(Status.PASS,MarkupHelper.createLabel("Login page validated and
		// loaded successfully", ExtentColor.GREEN));
		Assert.assertTrue(true);
	}

	public void step2(TestStepStatus status) throws InterruptedException {
		commercialJobAction.ClickonJobRequest(getDriver());
	}

	public void step3(TestStepStatus status) throws InterruptedException {
		commercialJobAction.JobcategoryInputs(getDriver());
	}

	public void step4(TestStepStatus status) throws InterruptedException {
		commercialJobAction.selectAddress(getDriver());
	}

	public void step5(TestStepStatus status) throws InterruptedException {

		try {
			
			commercialJobAction.provideJobDetails(getDriver(),jobtype_subtype);
			if(jobtype_subtype.contains("Fiber")||jobtype_subtype.contains("EoHFC")) {
				commercialJobAction.connections(getDriver());
			}
			/*else {
				commercialJobAction.connections(getDriver()
			}
*/
				
				
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TestStepStatus step6(TestStepStatus status) throws InterruptedException {
		return CommonUtils.verifyQuickActionButtons(getDriver());
	//	commercialJobAction.verifyJobDetails(getDriver());
	}

	public TestStepStatus step7(TestStepStatus status) throws InterruptedException {
		if(jobtype_Metro.contains("Metro-E")){
			result=CommonUtils.verifyCommercialMetroConnectionJobTabs(getDriver());
		}
		else {
		 result =CommonUtils.verifyCommercialJobTabs(getDriver());
		}
		return result;
		
	}
	public void step8(TestStepStatus status) throws InterruptedException {
	//	ActionUtils.waitFor5Seconds();
	//	commercialJobAction.validateJobDetailsfields(getDriver());
	
}
	public TestStepStatus step10(TestStepStatus status) throws InterruptedException {
		ActionUtils.waitFor1Seconds();
		return CommonUtils.verifyHighlightPanel(getDriver());
		
	
}
	public TestStepStatus step9(TestStepStatus status) throws InterruptedException {
		//ActionUtils.waitFor1Seconds();
		TestStepStatus result =CommonUtils.jobActionButtonValidation(getDriver());
	getDriver().quit();
	return result;
		
	
}
	public void step11(TestStepStatus status) throws InterruptedException {
		ActionUtils.waitFor3Seconds();
		commercialJobAction.JobUploadAction(getDriver());
	
}
	public void Job_Commercial_WithoutSubtype(TestStepStatus step3Status, String jobtype) {
		//ActionUtils.waitFor2Seconds();
		jobtype_Metro=jobtype;
		jobtype_subtype="NA";
		commercialJobAction.Job_Commercial_WithoutSubtype(getDriver(),jobtype);
		
	}
	public void Job_Commercial_WithSubtype(TestStepStatus step3Status,  String jobtype, String subtype) {
		//ActionUtils.waitFor2Seconds();
		jobtype_subtype=subtype;
		jobtype_Metro=jobtype;
		commercialJobAction.Job_Commercial_WithSubtype(getDriver(),jobtype,subtype);
		
	}



}
