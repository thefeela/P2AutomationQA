package p2.Properties

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import internal.GlobalVariable

public class TaskPageXpathLocators {
		private static Logger logger = LogManager.getLogger(TaskPageXpathLocators.class.getCanonicalName());

	static Map<String, String> taskMap = new HashMap<String, String>();

	public boolean loadConfig() {

		boolean configLoaded = false;
		Properties prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream("./src/main/resources/TaskPage.Properties");
			prop.load(fip);
			//taskMap.putAll(prop.entrySet().stream()
				//	.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
				appLaunchMap.putAll(prop.entrySet().stream().collect());
				
				configLoaded = true;
		} catch (FileNotFoundException e1) {
			logger.error("error loading file " + e1.getMessage());
		} catch (IOException e1) {
			logger.error("error loading file IOException " + e1.getMessage());
		}
		return configLoaded;

	}

	// Get Assign Button Xpath
	public static String getAssignBtn() {
		return taskMap.get("assignBtn");
	}
	// Get BP text box Xpath
	public static String getTxtBx_BP() {
		return taskMap.get("txtBx_BP");
	}
	// Get Select BP Xpath
	public static String getSelect_BP() {
		return taskMap.get("select_BP");
	}
	// Get Input Date Xpath
	public static String getInput_Date() {
		return taskMap.get("input_Date");
	}
	// Get Save Button Assign Xpath
	public static String getSaveBtn_Assign() {
		return taskMap.get("saveBtn_Assign");
	}
	// Get Save Button Assign Xpath
	public static String getInputType_BP() {
		return taskMap.get("inputType_BP");
	}
	// Get Save Button Assign Xpath
	public static String getClkTask() {
		return taskMap.get("clkTask");
	}	
	// Get Save Button Assign Xpath
	public static String getTaskStatus() {
		return taskMap.get("taskStatus");
	}	
	// Get Accept Button Assign Xpath
	public static String getAcceptBtn() {
		return taskMap.get("acceptBtn");
	}
	// Get Save Button Assign Xpath
	public static String getSaveBtn_Accept() {
		return taskMap.get("saveBtn_Accept");
	}
	// Get Save Button Assign Xpath
	public static String getTaskStatus_BP() {
		return taskMap.get("taskStatus_BP");
	}
	// Get Save Button Assign Xpath
	public static String getField_SurveyDesign() {
		return taskMap.get("surveyDesignField");
	}	
	// Get Save Button Assign Xpath
	public static String getField_QCField() {
		return taskMap.get("QCField");
	}	
	// Get Save Button Assign Xpath
	public static String getTaskFieldVal() {
		return taskMap.get("taskFieldVal");
	}
	
	
	// Get Save Button Assign Xpath
	public static String getField_Construct() {
		return taskMap.get("constructField");
	}		
	// Get Save Button Assign Xpath
	public static String getField_Permit() {
		return taskMap.get("permitField");
	}	
	
	// Get Save Button Assign Xpath
	public static String getWalkoutTask() {
		return taskMap.get("walkoutTask");
	}
	// Get Save Button Assign Xpath
	public static String getDesktopTask() {
		return taskMap.get("desktopTask");
	}	
	// Get Save Button Assign Xpath
	public static String getRFDesginTask() {
		return taskMap.get("rfDesginTask");
	}	
	// Get Accept Button Assign Xpath
	public static String getOpticalTask() {
		return taskMap.get("opticalTask");
	}
	// Get Save Button Assign Xpath
	public static String getNodeSpottingTask() {
		return taskMap.get("nodeSpottingTask");
	}
	// Get Save Button Assign Xpath
	public static String getAddressTask() {
		return taskMap.get("addressTask");
	}
	// Get Save Button Assign Xpath
	public static String getDetermineTask() {
		return taskMap.get("determineTask");
	}	
	// Get Save Button Assign Xpath
	public static String getObtainTask() {
		return taskMap.get("obtainTask");
	}		
	// Get Save Button Assign Xpath
	public static String getCoaxTask() {
		return taskMap.get("coaxTask");
	}	

	
	// Get Save Button Assign Xpath
	public static String getFiberTask() {
		return taskMap.get("fiberTask");
	}	
	// Get Save Button Assign Xpath
	public static String getPowerSupplyTask() {
		return taskMap.get("powerSupplyTask");
	}
	// Get Save Button Assign Xpath
	public static String getInstallNodesTask() {
		return taskMap.get("installNodesTask");
	}
	// Get Save Button Assign Xpath
	public static String getOptimzationTask() {
		return taskMap.get("optimzationTask");
	}	
	// Get Save Button Assign Xpath
	public static String getActTask() {
		return taskMap.get("actTask");
	}		
	// Get Save Button Assign Xpath
	public static String getAsBuiltTask() {
		return taskMap.get("asBuiltTask");
	}
	// Get Save Button Assign Xpath
	public static String getMapSpatialTask() {
		return taskMap.get("mapSpatialTask");
	}	
	// Get Save Button Assign Xpath
	public static String getFieldQCTask() {
		return taskMap.get("fieldQCTask");
	}		
	// Get Save Button Assign Xpath
	public static String getInvoiceTask() {
		return taskMap.get("invoiceTask");
	}	
	// Get Save Button Assign Xpath
	public static String getStatus_TaskViewPage() {
		return taskMap.get("status_TaskViewPage");
	}	

	// Get Save Button Assign Xpath
	public static String getUnassigned_Status() {
		return taskMap.get("unassigned_Status");
	}
	// Get Save Button Assign Xpath
	public static String getAssigned_Status() {
		return taskMap.get("assigned_Status");
	}	
	// Get Save Button Assign Xpath
	public static String getReassign_Status() {
		return taskMap.get("reassign_Status");
	}		
	// Get Save Button Assign Xpath
	public static String getDateChange_Status() {
		return taskMap.get("dateChange_Status");
	}	
	// Get Save Button Assign Xpath
	public static String getApprove_Status() {
		return taskMap.get("approve_Status");
	}
	// Get Save Button Assign Xpath
	public static String getAccepted_Status() {
		return taskMap.get("accepted_Status");
	}	
	// Get Save Button Assign Xpath
	public static String getProvideInfoBtn() {
		return taskMap.get("provideInfoBtn");
	}
	// Get Save Button Assign Xpath
	public static String getNeedInfoBtn() {
		return taskMap.get("needInfoBtn");
	}
	// Get Save Button Assign Xpath
	public static String getDynamicselect() {
		return taskMap.get("dynamicselect");
	}	
	
	
	// Get Save Button Assign Xpath
	public static String getCompleteBtn() {
		return taskMap.get("completeBtn");
	}
	// Get Save Button Assign Xpath
	public static String getCompletedStatus() {
		return taskMap.get("completedStatus");
	}
	// Get Save Button Assign Xpath
	public static String getApproveBtn() {
		return taskMap.get("approveBtn");
	}	
	
	
	public static String getNeedinfo_reason() {
		return taskMap.get("Needinfo_reason");
	}	
	public static String getReason_popUP() {
		return taskMap.get("textarea_description");
	}	
	// Get Save Button Assign Xpath
	public static String getInfoRequestedStatus() {
		return taskMap.get("infoRequestedStatus");
	}	
	// Get Summary and BOM
	public static String getSummaryBOM() {
		return taskMap.get("summaryBOM");
	}
	// Get Upload Button
	public static String getUplodBtn() {
		return taskMap.get("uplodBtn");
	}	
	//Get Provide Info Status
	public static String getChooseFile() {
		return taskMap.get("chooseFile");
	}	
	//Get Provide Info Status
	public static String getUploadFile() {
		return taskMap.get("uploadFile");
	}
	//Get Provide Info Status
	public static String getToastMsg() {
		return taskMap.get("toastMsg");
	}
	//Get Provide Info Status
	public static String getVersion_ErrorTxt() {
		return taskMap.get("version_ErrorTxt");
	}
	//Get Provide Info Status
	public static String getProvidedInfoStatus() {
		return taskMap.get("providedInfoStatus");
	}	
	
}
