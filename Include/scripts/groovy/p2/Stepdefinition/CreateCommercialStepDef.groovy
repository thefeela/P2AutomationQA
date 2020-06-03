package p2.Stepdefinition

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

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import p2.p2base.P2Base

import p2.Properties.JobcategoryInputParameters;
import p2.action.BettermentJobAction;
import p2.action.LoginAction;
import p2.action.CommercialJobAction;
import p2.dataType.TestStepStatus;
import p2.implementation.CreateCommercialJobEFibreImpl;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import internal.GlobalVariable

public class CreateCommercialStepDef extends P2Base{
	LoginAction login = new LoginAction();
	TestStepStatus step1Status = new TestStepStatus();
	TestStepStatus step2Status = new TestStepStatus();
	TestStepStatus step3Status = new TestStepStatus();
	TestStepStatus step4Status = new TestStepStatus();
	TestStepStatus step5Status = new TestStepStatus();
	TestStepStatus step6Status = new TestStepStatus();
	TestStepStatus step7Status = new TestStepStatus();
	TestStepStatus step8Status = new TestStepStatus();
	TestStepStatus step9Status = new TestStepStatus();
	TestStepStatus step10Status = new TestStepStatus();
	TestStepStatus step11Status = new TestStepStatus();
	TestStepStatus stepSurveyStatus = new TestStepStatus();
	List<TestStepStatus> stepResult = new ArrayList<TestStepStatus>();
	CommercialJobAction CommercialJobAction = new CommercialJobAction();
	CreateCommercialJobEFibreImpl createCommercialJobEFibreImpl = new CreateCommercialJobEFibreImpl();
	private static Logger logger = LogManager.getLogger(CreateCommercialStepDef.class.getCanonicalName());

	//Step1
	@Given("navigate to Request and Jobs page_CommercialJob")
	public void navigatetoRequestandJobspage() throws Throwable {
		createCommercialJobEFibreImpl.step1(step1Status);
		BettermentJobAction.SubTypeOrWithout = false;
		BettermentJobAction.Jobtype = "";
		BettermentJobAction.Subtype = "";
	}
//Step2
	@When("I click on New Job Creation_CommercialJob")
	public void clickonNewJobCreation() throws Throwable {
		createCommercialJobEFibreImpl.step2(step2Status);
	}

	
	//Step 3

	@Then("Job creation with Commercial category , MetroERetail jobtype and Fiber subtype")
	public void Job_Commercial_MetroERetail_Fiber() throws Throwable {
		createCommercialJobEFibreImpl.Job_Commercial_WithSubtype(step3Status,
				JobcategoryInputParameters.getjobtype_commercial_Metro_E_Retail(),
				JobcategoryInputParameters.getsubtype_commercial_Metro_E_Retail_Fiber());
		BettermentJobAction.SubTypeOrWithout = false;
		BettermentJobAction.Jobtype = "MDU";
		BettermentJobAction.Subtype = "";
	}

	
//Step4 - Fill Address &  fill Job details

	@Then("I Select the Address_CommercialJob")
	public void selectAddress() throws Throwable {
		createCommercialJobEFibreImpl.step4(step4Status);
	}

	@And("I Provide Input for CommercialJob")
	public void JobInput() throws Throwable {
		createCommercialJobEFibreImpl.step5(step5Status);
		//createCommercialJobEFibreImpl.step11(step11Status);
	}
// Click Next after job
	@Then("Click Next after Job Details Entered_CommercialJob")
	public void Nextbutton_JobDetails() throws Throwable {
		createCommercialJobEFibreImpl.step11(step11Status);
		createCommercialJobEFibreImpl.step11(step11Status);
		//createCommercialJobEFibreImpl.sur
	}

	@And("verify Quick Action Buttons_CommercialJob")
	public void Quick_Action_Buttons() throws Throwable {
		TestStepStatus StepStatusResult = createCommercialJobEFibreImpl.step6(step6Status);
		assertEquals(StepStatusResult.getElementstatus(), StepStatusResult.getElementName() + " loaded");
	}

	@Then("Verify Job details_CommercialJob")
	public void Jobdetails_Classifications_Validations() throws Throwable {
		TestStepStatus StepStatusResult = createCommercialJobEFibreImpl.step7(step7Status);
		assertEquals(StepStatusResult.getElementstatus(), StepStatusResult.getElementName() + " loaded");
	}

	@Then("Verify value in Job details_CommercialJob")
	public void Jobdetails_Validations() throws Throwable {
	 createCommercialJobEFibreImpl.step8(step8Status);
	}

	@Then("Verify JobActionbuttons_CommercialJob")
	public void JobActionbuttons() throws Throwable {
		TestStepStatus StepStatusResult = createCommercialJobEFibreImpl.step9(step9Status);
		assertEquals(StepStatusResult.getElementstatus(), StepStatusResult.getElementName() + " loaded");

	}
	

	@Then("Verify value in HighlightPanel_CommercialJob")
	public void HighlightPanel_Validations() throws Throwable {
		//TestStepStatus	 StepStatusResult=createCommercialJobEFibreImpl.step10(step10Status);
		//assertEquals(StepStatusResult.getElementstatus(),StepStatusResult.getElementName()+" loaded");

	}
	
	 
	@Then("Verify QuickACtionButtonsJobLevel")
	public void QuickActionJobLevel() throws Throwable{
		//TestStepStatus	 StepStatusResult=createCommercialJobEFibreImpl.(stepSurveyStatus);
		createCommercialJobEFibreImpl.VerifyQuickActionJobLevel();
	}
	@Then("Verify NoOFTasksJobLevel")
	public void NoOFTasksJobLevel() throws Throwable{
		//TestStepStatus	 StepStatusResult=createCommercialJobEFibreImpl.(stepSurveyStatus);
		createCommercialJobEFibreImpl.NoOFTasksJobLevel();
	}
		 
	@Then("Verify JobTaskSurvey&QuickButton")
	public void Survey() throws Throwable{
		//TestStepStatus	 StepStatusResult=createCommercialJobEFibreImpl.(stepSurveyStatus);
		createCommercialJobEFibreImpl.job_survey_click_Object_Browser();
	}
	@Then("Verify SurveyType")
	public void SurveyTypeVerify() throws Throwable{
		//TestStepStatus	 StepStatusResult=createCommercialJobEFibreImpl.(stepSurveyStatus);
		createCommercialJobEFibreImpl.job_survey_TypeVerification();
	}
	
	
}
