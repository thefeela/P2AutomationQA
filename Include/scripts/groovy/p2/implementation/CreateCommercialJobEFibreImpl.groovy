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

import org.testng.Assert;
import p2.p2base.P2Base

import p2.action.BettermentJobAction;
import p2.action.CommercialJobActionEFibre;
import p2.implementation.CreateCommercialJobEFibreImpl;
import p2.action.TaskmanagementAction;
import p2.action.TaskValidationAction;
import p2.dataType.TestStepStatus;
import p2.util.ActionUtils;
import p2.util.CommonUtils;
import p2.action.LoginAction
import internal.GlobalVariable

public class CreateCommercialJobEFibreImpl {
	//TaskmanagementAction taskmanagementAction=new TaskmanagementAction();
	//	TaskValidationAction taskValidationAction=new TaskValidationAction();
	//LoginAction login = new LoginAction();
	List<TestStepStatus> stepResult = new ArrayList<TestStepStatus>();
	//	//CommercialJobActionEFibre CommercialJobActionEFibre=new CommercialJobActionEFibre();
	//	BettermentJobAction bettermentJobAction=new BettermentJobAction();
	public static String jobtype_Metro;
	public static String jobtype_subtype;
	TestStepStatus result;

	@Keyword
	public void step1(TestStepStatus status)  {
	WebUI.callTestCase(findTestCase('Test Cases/Modules/LoginMethos/Login - JO'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(2)
		//login.login("","");
		//WebUI.navigateToUrl(testUrl)
		//login.login(getDriver(), usrName_jo, password_jo);
		ActionUtils.waitFor5Seconds();
		//	 driver.findElement(By.xpath(JobcategoryInputParameters.getrequest_option())).click();
		status.setPass(true);
		// test.log(Status.PASS,MarkupHelper.createLabel("Login page validated and
		// loaded successfully", ExtentColor.GREEN));

		WebUI.click(findTestObject('Finance/FullFlowLabor/Page_Home  Salesforce/span_RequestsJobs'))
		//
		WebUI.delay(5)


		Assert.assertTrue(true);
	}
	@Keyword
	public void step2(TestStepStatus status)  {
		(new p2.action.CommercialJobActionEFibre()).ClickonJobRequest();
		//(new p2.action.CommercialJobActionEFibre()).ClickonJobRequest();
	}
	@Keyword public void step3(TestStepStatus status) throws InterruptedException {
		(new p2.action.CommercialJobActionEFibre()).JobcategoryInputs();
	}
	@Keyword public void step4(TestStepStatus status) throws InterruptedException {
		(new p2.action.CommercialJobActionEFibre()).selectAddress();
	}
	@Keyword public void step5(TestStepStatus status) throws InterruptedException {
		try {
			(new p2.action.CommercialJobActionEFibre()).provideJobDetails(jobtype_subtype);
			if(jobtype_subtype.contains("Fiber")) {
			}
			else {
				(new p2.action.CommercialJobActionEFibre()).connections();
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Keyword
	public TestStepStatus step6(TestStepStatus status) throws InterruptedException {
		return CommonUtils.verifyQuickActionButtons();
		//(new p2.action.CommercialJobActionEFibre()).verifyJobDetails();
	}
	@Keyword
	public TestStepStatus step7(TestStepStatus status) throws InterruptedException {
		if(jobtype_Metro.contains("Metro-E")){
			result=CommonUtils.verifyCommercialMetroConnectionJobTabs();
		}
		else {
			result =CommonUtils.verifyCommercialJobTabs();
		}
		return result;
	}
	@Keyword
	public void step8(TestStepStatus status) throws InterruptedException {
		//	ActionUtils.waitFor5Seconds();
		(new p2.action.CommercialJobActionEFibre()).validateJobDetailsfields();
	}
	@Keyword
	public TestStepStatus step10(TestStepStatus status) throws InterruptedException {
		ActionUtils.waitFor1Seconds();
		return CommonUtils.verifyHighlightPanel();
	}
	@Keyword
	public TestStepStatus step9(TestStepStatus status) throws InterruptedException {
		//ActionUtils.waitFor1Seconds();
		TestStepStatus result =CommonUtils.jobActionButtonValidation();
		//getDriver().quit();
		return result;
	}
	@Keyword
	public void step11(TestStepStatus status) throws InterruptedException {
		ActionUtils.waitFor3Seconds();
		(new p2.action.CommercialJobActionEFibre()).JobUploadAction();
	}
	@Keyword
	public void Job_Commercial_WithoutSubtype(TestStepStatus step3Status, String jobtype) {
		//ActionUtils.waitFor2Seconds();
		jobtype_Metro=jobtype;
		jobtype_subtype="NA";
		(new p2.action.CommercialJobAction()).Job_Commercial_WithoutSubtype(jobtype);
	}
	@Keyword
	public void Job_Commercial_WithSubtype(TestStepStatus step3Status,  String jobtype, String subtype) {
		//ActionUtils.waitFor2Seconds();
		jobtype_subtype=subtype;
		jobtype_Metro=jobtype;
		(new p2.action.CommercialJobActionEFibre()).Job_Commercial_WithSubtype(jobtype,subtype);
		//(new p2.action.CommercialJobActionEFibre()).SurveyPresentValidation();
	}
	@Keyword
	public void job_survey_click_Object_Browser() throws Exception {
		(new p2.action.CommercialJobActionEFibre()).SurveyPresentValidation();
	}
	@Keyword
	public void job_survey_TypeVerification() throws Exception {
		(new p2.action.CommercialJobActionEFibre()).SurveyTypeValidation();
	}
	@Keyword
	public void NoOFTasksJobLevel() throws Exception {
		(new p2.action.CommercialJobActionEFibre()).VerifyNoOfTasksJobsJob();
	}
	@Keyword
	public void VerifyQuickActionJobLevel() throws Exception {
		(new p2.action.CommercialJobActionEFibre()).VerifyNoQuickActionButtonsJob();
	}
	/*	 @Keyword
	 public void SurveyPrecondition() throws Throwable {
	 WebDriver driver = DriverFactory.getWebDriver();
	 for(int i=0;i<14;i++) {
	 ActionUtils.waitFor2Seconds();
	 JavascriptExecutor jse = (JavascriptExecutor)driver;provideJobDetailsjobtype_subtype
	 jse.executeScript("window.scrollBy(0,250)", "");
	 ActionUtils.waitFor2Seconds();
	 taskmanagementAction.CreateNewTaskAction(driver, "Survey", "Survey");
	 ActionUtils.waitFor2Seconds();
	 jse.executeScript("window.scrollBy(0,250)", "");
	 ActionUtils.waitFor2Seconds();
	 driver.findElement(By.cssSelector("button[title='Edit Survey Type']")).click();
	 ActionUtils.waitFor3Seconds();
	 driver.findElements(By.cssSelector("input[class='slds-input slds-combobox__input']")).get(2).click();
	 ActionUtils.waitFor2Seconds();
	 Actions action = new Actions(driver);
	 action.moveToElement( driver.findElement(By.xpath("//*[contains(text(),'Walkout')]"))).click().build().perform();
	 ActionUtils.waitFor2Seconds();
	 driver.findElement(By.cssSelector("button[title='Save']")).click();
	 ActionUtils.waitFor3Seconds();
	 jse.executeScript("window.scrollBy(0,-250)", "");
	 ActionUtils.waitFor2Seconds();
	 action.moveToElement( driver.findElements(By.xpath("//a[contains(text(),'SURVEYS')]")).get(1)).click().build().perform();
	 ActionUtils.waitFor3Seconds();
	 action.moveToElement( driver.findElement(By.xpath("//button[contains(text(),'New/Existing')]"))).click().build().perform();
	 ActionUtils.waitFor3Seconds();
	 action.moveToElement( driver.findElement(By.cssSelector("input[placeholder='Search Existing Surveys...']"))).click().build().perform();
	 ActionUtils.waitFor3Seconds();
	 action.moveToElement( driver.findElement(By.cssSelector("input[placeholder='Search Existing Surveys...']"))).sendKeys("Sur").build().perform();
	 ActionUtils.waitFor5Seconds();
	 action.moveToElement( driver.findElements(By.cssSelector("span[class='slds-checkbox--faux']")).get(12)).click().build().perform();
	 ActionUtils.waitFor5Seconds();
	 action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Associate')]"))).click().build().perform();
	 ActionUtils.waitFor3Seconds();
	 driver.get(TaskmanagementAction.JobURL);
	 ActionUtils.waitFor5Seconds();
	 }
	 }
	 */
}
