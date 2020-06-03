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
import internal.GlobalVariable
import p2.Properties.TaskmanagementProperties


public class TaskmanagementProperties {

	static Map<String, String> TaskManagementMap = new HashMap<String, String>();

	public static boolean loadConfig() {

		boolean configLoaded1 = false;
		Properties prop = new  Properties()

		FileInputStream fip = new FileInputStream("./Resource/TaskManagement.Properties");
		prop.load(fip);
		TaskManagementMap.putAll(prop.entrySet().stream().collect());
		configLoaded1 = true;
		//println	TaskManagementMap.get("next").value;
		return configLoaded1;
	}

	public static String getInternalGroup() {
		return TaskManagementMap.get("InternalGroup");
	}
	public static String getTestIG() {
		return TaskManagementMap.get("TestIG");
	}
	public static String getBusinessPartner() {
		return TaskManagementMap.get("BusinessPartner");
	}
	public static String getccg() {
		return TaskManagementMap.get("ccg");
	}
	public static String getmathijoreg() {
		return TaskManagementMap.get("mathijoreg");
	}
	public static String getmathijotraining() {
		return TaskManagementMap.get("mathijotraining");
	}
	public static String getmathiigtraining() {
		return TaskManagementMap.get("mathiigtraining");
	}
	public static String getmathibptraining() {
		return TaskManagementMap.get("mathibptraining");
	}

	public static String getmathiigreg() {
		return TaskManagementMap.get("mathiigreg");
	}
	public static String getpassword() {
		return TaskManagementMap.get("password");
	}
	public static String getmathibpreg() {
		return TaskManagementMap.get("mathibpreg");
	}
	public static String getPVC() {
		return TaskManagementMap.get("PVC");
	}
	public static String getAccept() {
		return TaskManagementMap.get("Accept");
	}
	public static String getComplete() {
		return TaskManagementMap.get("Complete");
	}
	public static String getApprove() {
		return TaskManagementMap.get("Approve");
	}
	public static String getAssignFromJO() {
		return TaskManagementMap.get("AssignFromJO");
	}
	public static String getdropdown() {
		return TaskManagementMap.get("dropdown");
	}
	public static String getdropdownBuisnesspartner() {
		return TaskManagementMap.get("dropdownBuisnesspartner");
	}
	public static String getselectcompany() {
		return TaskManagementMap.get("selectcompany");
	}
	public static String getexpectedDate() {
		return TaskManagementMap.get("expectedDate");
	}
	public static String getReassignFromJO() {
		return TaskManagementMap.get("ReassignFromJO");
	}
	public static String getdropdownInternalGroup() {
		return TaskManagementMap.get("dropdownInternalGroup");
	}
	public static String getdeleteOldPopulatedCompany() {
		return TaskManagementMap.get("deleteOldPopulatedCompany");
	}
	public static String getReason() {
		return TaskManagementMap.get("Reason");
	}
	public static String getReasonNotes() {
		return TaskManagementMap.get("ReasonNotes");
	}
	public static String getClickTask1() {
		return TaskManagementMap.get("ClickTask1");
	}
	public static String getClickTask2() {
		return TaskManagementMap.get("ClickTask2");
	}
	public static String gethref() {
		return TaskManagementMap.get("href");
	}
	public static String getprofileLogout() {
		return TaskManagementMap.get("profileLogout");
	}
	public static String getlogout() {
		return TaskManagementMap.get("logout");
	}
	public static String getAssignToFieldFromIG() {
		return TaskManagementMap.get("AssignToFieldFromIG");
	}
	public static String getselectcompanyIntial() {
		return TaskManagementMap.get("selectcompanyIntial");
	}
	public static String getSave() {
		return TaskManagementMap.get("Save");
	}
	public static String getReassignfromIG() {
		return TaskManagementMap.get("ReassignfromIG");
	}
	public static String getAssignfromIG() {
		return TaskManagementMap.get("AssignfromIG");
	}
	public static String getChangeDate() {
		return TaskManagementMap.get("ChangeDate");
	}
	public static String getReasonAssignedinError() {
		return TaskManagementMap.get("ReasonAssignedinError");
	}
	public static String getReasonAnchorTagAssignedinError() {
		return TaskManagementMap.get("ReasonAnchorTagAssignedinError");
	}
	public static String getNeedInfo() {
		return TaskManagementMap.get("NeedInfo");
	}
	public static String getprovideInfo() {
		return TaskManagementMap.get("provideInfo");
	}
	public static String getnotRequired() {
		return TaskManagementMap.get("notRequired");
	}
	public static String getNewTask() {
		return TaskManagementMap.get("new");
	}
	public static String getNewTaskDropdown() {
		return TaskManagementMap.get("newTaskDropdown");
	}
	public static String getNewTaskFooter() {
		return TaskManagementMap.get("newTask");
	}
	public static String getDesignValidationMessage() {
		return TaskManagementMap.get("DesignValidationMessage");
	}
	public static String getDesignErrorMessage() {
		return TaskManagementMap.get("DesignErrorMessage");
	}
	public static String getCancel() {
		return TaskManagementMap.get("Cancel");
	}
	public static String getEditArchitecture() {
		return TaskManagementMap.get("EditArchitecture");
	}
	public static String getNext() {
		return TaskManagementMap.get("next");
	}
	public static String getOption1() {
		return TaskManagementMap.get("Option1");
	}
	public static String getOption2() {
		return TaskManagementMap.get("Option2");
	}
	public static String getArchitectureType() {
		return TaskManagementMap.get("ArchitectureType");
	}
	public static String getTaskSave() {
		return TaskManagementMap.get("TaskSave");
	}
	public static String getDesignValidationWithoutUploads() {
		return TaskManagementMap.get("DesignValidationWithoutUploads");
	}
}
