package p2.util

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

public class UtilConstants {
	public static String APP_LAUNCHER="span[class='slds-assistive-text']";
	public static String P2="span[title='P2']";
	public static String TRUE="true";
	public static String FALSE="false";
	public static String WALKOUT="Walkout";
	public static String TASK_ASSIGN="Assign_Task_Validation";
	public static String TASK_REASSIGN="Testing Reassign";
	public static String TASK_REASSIGN_VAL="Re_Assign_Task_Validation";
	public static String TASK_CHANGE_DATE="Change Date Testing Reassign";
	public static String TASK_CHANGE_DATE_VAL="changedate_Assign_Task_Validation";
	public static String TASK_NOT_REQUIRED="Not Required Task Testing";
	public static String TASK_NOT_REQUIRED_Val="Not_Required_Task";
	public static String TASK_NOT_REWORK_TESTING="Rework Task Testing";
	public static String TASK_NOT_REWORK="Rework_Task";
	public static String TASK_PROVIDE_INFO_TESTING="Provide Info Testing";
	public static String TASK_PROVIDE_INFO="Provide_Task";
	public static String TASK_APPROVE="Approve_Task";
}
