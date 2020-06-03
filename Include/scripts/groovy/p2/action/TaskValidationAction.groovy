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
import com.kms.katalon.core.testdata.reader.CSVReader
//import com.kms.katalon.core.
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.AbstractCSVWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
//import com.comcast.p2.test.P2Base;
import p2.Properties.TaskmanagementProperties;
import p2.action.TaskmanagementAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import p2.util.ActionUtils;
import com.opencsv.*;
import internal.GlobalVariable
import p2.p2base.P2Base
public class TaskValidationAction extends P2Base{
	boolean flag;
	private static Logger logger = LogManager.getLogger(TaskValidationAction.class.getCanonicalName());
	public static boolean SubTypeOrWithout = false;
	public static String Jobtype = "";
	public static String Subtype = "";
	TaskmanagementAction taskmanagementAction=new TaskmanagementAction();


	public void SurveyPreconditionForScenarios(RemoteWebDriver driver) throws Throwable {
		for(int i=0;i<3;i++) {
			ActionUtils.waitFor2Seconds();
			JavascriptExecutor jse = driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			ActionUtils.waitFor2Seconds();
			taskmanagementAction.CreateNewTaskAction(driver, "Survey", "Survey");
			ActionUtils.waitFor2Seconds();


			driver.get(TaskmanagementAction.JobURL);
			ActionUtils.waitFor5Seconds();
		}
	}
	public void SurveyPrecondition(RemoteWebDriver driver) throws Throwable {
		for(int i=0;i<14;i++) {
			ActionUtils.waitFor2Seconds();
			JavascriptExecutor jse = driver;
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


	public void SurveyWithSubTypeScenarioWithBP(RemoteWebDriver driver,String AssignToBP) throws Exception {
		System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		//driver.findElements(By.linkText("Survey")).get(0).click();
		action.moveToElement(driver.findElements(By.linkText("Survey")).get(0)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[title='Edit Survey Type']")).click();
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[class='slds-input slds-combobox__input']")).get(2).click();
		ActionUtils.waitFor2Seconds();
		// driver.findElement(By.("Walkout")).click();
		action.moveToElement( driver.findElement(By.xpath("//*[contains(text(),'Walkout')]"))).click().build().perform();
		// driver.findElement(By.cssSelector("a[title='Walkout']")).click();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector("button[title='Save']")).click();
		ActionUtils.waitFor3Seconds();

		taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getBusinessPartner(), TaskManagementInputParameters.getccg());
		ActionUtils.waitFor2Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();
		/*	 System.out.println(driver.findElementByCssSelector("div[class='genericNotification']").getAttribute("innerText"));
		 System.out.println(driver.findElementByCssSelector("div[class='genericNotification']").isDisplayed());
		 if(driver.findElementByCssSelector("div[class='genericNotification']").isDisplayed()){
		 throw new Exception("Survey Task Assigned to BP without Changing Survey Type");
		 }*/


	}
	public void SurveyWithSubTypeScenarioWithIG(RemoteWebDriver driver,String AssignToIG) throws Exception {
		System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Survey")).get(1)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[title='Edit Survey Type']")).click();
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[class='slds-input slds-combobox__input']")).get(2).click();
		ActionUtils.waitFor2Seconds();
		action.moveToElement( driver.findElement(By.xpath("//*[contains(text(),'Walkout')]"))).click().build().perform();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector("button[title='Save']")).click();
		ActionUtils.waitFor3Seconds();

		taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
		ActionUtils.waitFor2Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();
		/* if(driver.findElementByCssSelector("div[class='genericNotification']").isDisplayed()){
		 throw new Exception("Survey Task Not able to Assign without Changing Survey Type");
		 }*/

	}
	public void SurveyWithoutSubTypeScenarioWithBP(RemoteWebDriver driver,String AssignTo) throws Exception {
		System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Survey")).get(2)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();


		taskmanagementAction.AssignFromJOSurveyWithoutSubtype(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
		ActionUtils.waitFor2Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();
		/* if(driver.findElement(By.cssSelector(TaskManagementInputParameters.getSave())).isDisplayed()){
		 throw new Exception("Survey Task Not able to Assign without Changing Survey Type");
		 }*/


	}

	public void SurveyWithoutSubTypeScenarioWithIG(RemoteWebDriver driver,String AssignTo) throws Exception {
		System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Survey")).get(3)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();

		taskmanagementAction.AssignFromJOSurveyWithoutSubtype(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
		ActionUtils.waitFor2Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();
		/*		 if(driver.findElement(By.cssSelector(TaskManagementInputParameters.getSave())).isDisplayed()){
		 throw new Exception("Survey Task Not able to Assign without Changing Survey Type");
		 }*/
	}



	public void SurveyValidation(RemoteWebDriver driver,String AssignTo) throws Exception {
		System.out.println("Request getting text - Before 10 sec");
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		/*		driver.findElement(By.linkText("Survey")).click();
		 ActionUtils.waitFor2Seconds();
		 ActionUtils.waitFor2Seconds();
		 if(AssignTo.equals("Buisness Partner")) {
		 taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getBusinessPartner(), TaskManagementInputParameters.getccg());
		 ActionUtils.waitFor2Seconds();
		 System.out.println(driver.findElementByCssSelector("div[class='genericNotification']").getAttribute("innerText"));
		 System.out.println(driver.findElementByCssSelector("div[class='genericNotification']").isDisplayed());
		 if(!driver.findElementByCssSelector("div[class='genericNotification']").isDisplayed()){
		 throw new Exception("Survey Task Assigned to BP without Changing Survey Type");
		 }
		 }
		 else if((AssignTo.equals("Internal Group"))){
		 taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
		 ActionUtils.waitFor2Seconds();
		 if(driver.findElement(By.cssSelector(TaskManagementInputParameters.getSave())).isDisplayed()){
		 throw new Exception("Survey Task Not able to Assign without Changing Survey Type");
		 }
		 }
		 driver.get(TaskmanagementAction.JobURL);*/
		ActionUtils.waitFor3Seconds();
		taskmanagementAction.CreateNewTask(driver, "Survey", "Survey");
		ActionUtils.waitFor3Seconds();
		//taskmanagementAction.SearchTaskAndClickwithIndex(getDriver(),"Survey",1);

		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector("button[title='Edit Survey Type']")).click();
		ActionUtils.waitFor3Seconds();
		driver.findElements(By.cssSelector("input[class='slds-input slds-combobox__input']")).get(2).click();
		ActionUtils.waitFor2Seconds();
		Actions action = new Actions(driver);
		action.moveToElement( driver.findElement(By.xpath("//*[contains(text(),'Walkout')]"))).click().build().perform();
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector("button[title='Save']")).click();
		ActionUtils.waitFor3Seconds();
		if(AssignTo.equals("Buisness Partner")) {
			taskmanagementAction.AssignFromJOAfterTaskCreated(driver, TaskManagementInputParameters.getBusinessPartner(), TaskManagementInputParameters.getccg());
			if(driver.findElement(By.cssSelector(TaskManagementInputParameters.getSave())).isDisplayed()){
				throw new Exception("Survey Task Assigned to BP without Changing Survey Type");
			}
		}
		else if((AssignTo.equals("Internal Group"))){
			taskmanagementAction.AssignFromJOAfterTaskCreated(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
			if(driver.findElementByCssSelector("div[class='genericNotification']").isDisplayed()){
				throw new Exception("Survey Task Not able to Assign without Changing Survey Type");
			}
		}
	}
	public void SelectSurveyTasks(RemoteWebDriver driver) {
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector("input[name='enter-search']")).click();
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector("input[name='enter-search']")).sendKeys("Survey");
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector("span[title='status']")).click();

	}


	public void DesignPreconditionForScenarios(RemoteWebDriver driver) throws Throwable {
		for(int i=0;i<3;i++) {
			ActionUtils.waitFor2Seconds();
			JavascriptExecutor jse = driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			ActionUtils.waitFor2Seconds();
			taskmanagementAction.CreateNewTaskAction(driver, "Design", "Design");
			ActionUtils.waitFor2Seconds();


			driver.get(TaskmanagementAction.JobURL);
			ActionUtils.waitFor5Seconds();
		}
	}

	public void DesignWithArchitectureAssignBP(RemoteWebDriver driver, String businessPartner) throws Exception {
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Design")).get(0)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector(TaskManagementInputParameters.getEditArchitecture())).click();
		ActionUtils.waitFor3Seconds();
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,10)");
		driver.findElements(By.cssSelector(TaskManagementInputParameters.getdropdown())).get(1).click();;
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector(TaskManagementInputParameters.getArchitectureType())).click();
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector(TaskManagementInputParameters.getTaskSave())).click();;
		ActionUtils.waitFor5Seconds();

		taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getBusinessPartner(), TaskManagementInputParameters.getccg());
		ActionUtils.waitFor2Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();

	}

	public void DesignWithArchitectureAssignIG(RemoteWebDriver driver, String internalGroup) throws Exception {

		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Design")).get(1)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector(TaskManagementInputParameters.getEditArchitecture())).click();
		ActionUtils.waitFor3Seconds();
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,10)");
		driver.findElements(By.cssSelector(TaskManagementInputParameters.getdropdown())).get(1).click();;
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector(TaskManagementInputParameters.getArchitectureType())).click();
		ActionUtils.waitFor3Seconds();
		driver.findElement(By.cssSelector(TaskManagementInputParameters.getTaskSave())).click();;
		ActionUtils.waitFor5Seconds();

		taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getBusinessPartner(), TaskManagementInputParameters.getccg());
		ActionUtils.waitFor2Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();
	}

	public void DesignWithoutArchitectureAssignBP(RemoteWebDriver driver, String businessPartner) throws Exception {
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Design")).get(3)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();


		taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor5Seconds();
		String errormsg = driver.findElement(By.cssSelector(TaskManagementInputParameters.getDesignErrorMessage())).getText();
		if(errormsg.equals(TaskManagementInputParameters.getDesignValidationMessage())) {
			driver.findElement(By.cssSelector(TaskManagementInputParameters.getCancel())).click();
		}
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();

	}


	public void DesignWithoutArchitectureAssignIG(RemoteWebDriver driver, String internalGroup) throws Exception {
		ActionUtils.waitFor15Seconds();
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElements(By.linkText("Design")).get(2)).click().build().perform();

		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor2Seconds();


		taskmanagementAction.AssignFromJO(driver, TaskManagementInputParameters.getInternalGroup(), TaskManagementInputParameters.getTestIG());
		ActionUtils.waitFor2Seconds();
		ActionUtils.waitFor5Seconds();
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();

	}

	public void DesignPrecondition(RemoteWebDriver driver) throws Throwable {
		for(int i=0;i<14;i++) {
			ActionUtils.waitFor2Seconds();
			JavascriptExecutor jse = driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			ActionUtils.waitFor2Seconds();
			taskmanagementAction.CreateNewTaskAction(driver, "Design", "Design");
			ActionUtils.waitFor2Seconds();

			jse.executeScript("window.scrollBy(0,250)", "");
			ActionUtils.waitFor2Seconds();

			ActionUtils.waitFor5Seconds();
			driver.findElement(By.cssSelector(TaskManagementInputParameters.getEditArchitecture())).click();
			ActionUtils.waitFor3Seconds();
			JavascriptExecutor js = driver;
			js.executeScript("window.scrollBy(0,10)");
			driver.findElements(By.cssSelector(TaskManagementInputParameters.getdropdown())).get(1).click();;
			ActionUtils.waitFor3Seconds();
			driver.findElement(By.cssSelector(TaskManagementInputParameters.getArchitectureType())).click();
			ActionUtils.waitFor3Seconds();
			driver.findElement(By.cssSelector(TaskManagementInputParameters.getTaskSave())).click();;
			ActionUtils.waitFor5Seconds();

			driver.get(TaskmanagementAction.JobURL);
			ActionUtils.waitFor5Seconds();
		}
	}

	public void UploadPassingFile(RemoteWebDriver driver, String filename) {
		ActionUtils.waitFor5Seconds();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("button[title='Upload']"))).click().build().perform();
		ActionUtils.waitFor15Seconds();
		//driver.findElement(By.cssSelector("label[class='slds-file-selector__body']")).sendKeys("D:\\Sushmi\\Polaris\\uploads\\Design+AsBuilt_BAU+XNET.csv");
		String excelFilePath = (System.getProperty("user.dir") + "\\Upload\\" +filename);
		driver.findElement(By.cssSelector("input[class='slds-file-selector__input slds-assistive-text']")).sendKeys(excelFilePath);
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button--neutral ok uiButton--default uiButton--brand uiButton']")).click();
		ActionUtils.waitFor5Seconds();
		/*Select dropdown = new Select(driver.findElement(By.cssSelector("class='slds-select'")));
		 dropdown.selectByVisibleText("Footage & Passings Summary BAU");*/
		driver.findElement(By.cssSelector("div[class='slds-select_container']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Footage & Passings Summary BAU')]")).click();
		driver.findElement(By.cssSelector("footer[class='slds-modal__footer']")).click();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("div[class='slds-col slds-size_1-of-1 slds-p-around_medium']"))).click().build().perform();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		/*EventFiringWebDriver scroller = new EventFiringWebDriver(driver);
		 scroller.executeScript("document.querySelector('div[class*=\"slds-modal__content slds-p-around_medium\"]').scrollTop=500");*/
		Actions scrollAction = new Actions(driver);
		scrollAction.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		ActionUtils.waitFor2Seconds();
		action.moveToElement(driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']"))).click().build().perform();
		ActionUtils.waitFor2Seconds();
	}


	public void DesignValidationWithoutUploads(RemoteWebDriver driver) throws Exception {
		ActionUtils.waitFor5Seconds();
		taskmanagementAction.SearchTaskAndClickwithIndex(getDriver(),"Design",4);
		taskmanagementAction.AssignFromJO(driver, "Business Partner", "CCG");
		taskmanagementAction.AcceptTask(driver);
		taskmanagementAction.CompleteTaskBP(driver);
		String errormsg = driver.findElement(By.cssSelector(TaskManagementInputParameters.getDesignErrorMessage())).getText();
		if(errormsg.equals(TaskManagementInputParameters.getDesignValidationWithoutUploads())) {

			driver.findElement(By.cssSelector(TaskManagementInputParameters.getCancel())).click();
		}
		driver.get(TaskmanagementAction.JobURL);
		ActionUtils.waitFor5Seconds();

	}

	public void InvalidDesignFileValidation(RemoteWebDriver driver, String invalidfile) {
		ActionUtils.waitFor5Seconds();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("button[title='Upload']"))).click().build().perform();
		ActionUtils.waitFor15Seconds();
		//driver.findElement(By.cssSelector("label[class='slds-file-selector__body']")).sendKeys("D:\\Sushmi\\Polaris\\uploads\\Design+AsBuilt_BAU+XNET.csv");
		String excelFilePath = (System.getProperty("user.dir") + "\\Upload\\" +invalidfile);
		driver.findElement(By.cssSelector("input[class='slds-file-selector__input slds-assistive-text']")).sendKeys(excelFilePath);
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button--neutral ok uiButton--default uiButton--brand uiButton']")).click();
		ActionUtils.waitFor5Seconds();
		/*Select dropdown = new Select(driver.findElement(By.cssSelector("class='slds-select'")));
		 dropdown.selectByVisibleText("Footage & Passings Summary BAU");*/
		driver.findElement(By.cssSelector("div[class='slds-select_container']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'BOM')]")).click();
		driver.findElement(By.cssSelector("footer[class='slds-modal__footer']")).click();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']")).click();
		driver.findElement(By.cssSelector("div[class='slds-modal__content slds-p-around_medium']")).click();

		String errormsg = driver.findElement(By.cssSelector("div[class='slds-col slds-size_1-of-1 slds-p-around_medium']")).getText();
		if(errormsg.equals("Please correct the issues below and try uploading again.")) {

			driver.findElement(By.cssSelector(TaskManagementInputParameters.getCancel())).click();
		}

	}

	public void OrderValidationUploadFiles(RemoteWebDriver driver, String passing, String BOM) {
		ActionUtils.waitFor5Seconds();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("button[title='Upload']"))).click().build().perform();
		ActionUtils.waitFor15Seconds();
		//driver.findElement(By.cssSelector("label[class='slds-file-selector__body']")).sendKeys("D:\\Sushmi\\Polaris\\uploads\\Design+AsBuilt_BAU+XNET.csv");
		String excelFilePath = (System.getProperty("user.dir") + "\\Upload\\" +BOM);
		driver.findElement(By.cssSelector("input[class='slds-file-selector__input slds-assistive-text']")).sendKeys(excelFilePath);
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button--neutral ok uiButton--default uiButton--brand uiButton']")).click();
		ActionUtils.waitFor5Seconds();
		/*Select dropdown = new Select(driver.findElement(By.cssSelector("class='slds-select'")));
		 dropdown.selectByVisibleText("Footage & Passings Summary BAU");*/
		driver.findElement(By.cssSelector("div[class='slds-select_container']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'BOM')]")).click();
		driver.findElement(By.cssSelector("footer[class='slds-modal__footer']")).click();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']")).click();
		driver.findElement(By.cssSelector("div[class='slds-modal__content slds-p-around_medium']")).click();

		String errormsg = driver.findElement(By.cssSelector("div[class='slds-cell-wrap']")).getText();
		if(errormsg.equals("Please Upload The Footage And Passings Summary First")) {

			driver.findElement(By.cssSelector(TaskManagementInputParameters.getCancel())).click();
		}

	}
	public static void excelUpdate(RemoteWebDriver driver, String filename) {
		ActionUtils.waitFor10Seconds();
		String excelFilePath = (System.getProperty("user.dir") + "\\Upload\\" +filename);
		System.out.println(excelFilePath);
		ActionUtils.waitFor5Seconds();
		//String JobID = driver.findElement(By.partialLinkText("JB0000")).getText();
		String JobID = driver.findElements(By.cssSelector("a[data-refid='recordId']")).get(0).getText();
		System.out.println(JobID);
		File inputFile = new File(excelFilePath);
		try {

			CSVReader readers = new CSVReader(new FileReader(inputFile),',');
			List<String[]> csvBody = readers.readAll();
			csvBody.get(2)[0]=JobID;
			readers.close();

			CSVWriter writer = new CSVWriter(new FileWriter(inputFile),',');
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void UploadBOMFile(RemoteWebDriver driver, String filename) {
		ActionUtils.waitFor5Seconds();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,0)");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("button[title='Upload']"))).click().build().perform();
		ActionUtils.waitFor15Seconds();
		//driver.findElement(By.cssSelector("label[class='slds-file-selector__body']")).sendKeys("D:\\Sushmi\\Polaris\\uploads\\Design+AsBuilt_BAU+XNET.csv");
		String excelFilePath = (System.getProperty("user.dir") + "\\Upload\\" +filename);
		driver.findElement(By.cssSelector("input[class='slds-file-selector__input slds-assistive-text']")).sendKeys(excelFilePath);
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button--neutral ok uiButton--default uiButton--brand uiButton']")).click();
		ActionUtils.waitFor5Seconds();
		/*Select dropdown = new Select(driver.findElement(By.cssSelector("class='slds-select'")));
		 dropdown.selectByVisibleText("Footage & Passings Summary BAU");*/
		driver.findElement(By.cssSelector("div[class='slds-select_container']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'BOM')]")).click();
		driver.findElement(By.cssSelector("footer[class='slds-modal__footer']")).click();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']")).click();
		driver.findElement(By.cssSelector("div[class='slds-modal__content slds-p-around_medium']")).click();

		jse.executeScript("window.scrollBy(0,500)", "");
		/*EventFiringWebDriver scroller = new EventFiringWebDriver(driver);
		 scroller.executeScript("document.querySelector('div[class*=\"slds-modal__content slds-p-around_medium\"]').scrollTop=500");*/
		ActionUtils.waitFor2Seconds();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']")).click();

	}
	public void UploadFileXNET(RemoteWebDriver driver, String filename) {
		excelUpdate(getDriver(),"DesignSummary_XNET_FD.csv");
		ActionUtils.waitFor5Seconds();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("button[title='Upload']"))).click().build().perform();
		ActionUtils.waitFor15Seconds();
		//driver.findElement(By.cssSelector("label[class='slds-file-selector__body']")).sendKeys("D:\\Sushmi\\Polaris\\uploads\\Design+AsBuilt_BAU+XNET.csv");
		String excelFilePath = (System.getProperty("user.dir") + "\\Upload\\" +filename);
		driver.findElement(By.cssSelector("input[class='slds-file-selector__input slds-assistive-text']")).sendKeys(excelFilePath);
		ActionUtils.waitFor5Seconds();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button--neutral ok uiButton--default uiButton--brand uiButton']")).click();
		ActionUtils.waitFor5Seconds();
		/*Select dropdown = new Select(driver.findElement(By.cssSelector("class='slds-select'")));
		 dropdown.selectByVisibleText("Footage & Passings Summary BAU");*/
		driver.findElement(By.cssSelector("div[class='slds-select_container']")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Footage & Passings Summary BAU')]")).click();
		driver.findElement(By.cssSelector("footer[class='slds-modal__footer']")).click();
		driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("div[class='slds-col slds-size_1-of-1 slds-p-around_medium']"))).click().build().perform();
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		/*EventFiringWebDriver scroller = new EventFiringWebDriver(driver);
		 scroller.executeScript("document.querySelector('div[class*=\"slds-modal__content slds-p-around_medium\"]').scrollTop=500");*/
		Actions scrollAction = new Actions(driver);
		scrollAction.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		ActionUtils.waitFor2Seconds();
		action.moveToElement(driver.findElement(By.cssSelector("button[class='slds-button slds-button_brand']"))).click().build().perform();
		ActionUtils.waitFor2Seconds();

	}
	//verify whether survey is present, if not create new one
	public void SurveyPresentValidation(RemoteWebDriver driver) throws Exception {
		JavascriptExecutor jse = driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		ActionUtils.waitFor5Seconds();
		Actions action=new Actions(driver);

		boolean setResultSurvey=true;
		if(driver.findElements(By.linkText("Survey")).size()==0) {
			setResultSurvey=false;
		}
		if(setResultSurvey==false)
		{
			taskmanagementAction.CreateNewTaskAction(driver, "Survey", "Survey");
			taskmanagementAction.SearchTaskAndClick(driver,"Survey");
		}
		else
		{
			taskmanagementAction.SearchTaskAndClick(driver,"Survey");
		}
	}
}

