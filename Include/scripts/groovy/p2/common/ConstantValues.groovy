package p2.common

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

public class ConstantValues {
	// Browser
	public static final String BROWSER_IE = "internet explorer";
	public static final String BROWSER_NOT_SUPPORTED = "Your browser is not supported.";
	public static final String BROWSER = "browser";
	public static final String HOST = "host";
	public static final String TESTCASE_PASS = "pass";
	public static final String TESTCASE_FAIL = "fail";

	// wait time
	public static final int ONE_SECOND_IN_MILLISECONDS = 1000;
	public static final int TWO_SECOND_IN_MILLISECONDS = 2000;
	public static final int THREE_SECONDS_IN_MILLISECONDS = 3000;
	public static final int FIVE_SECONDS_IN_MILLISECONDS = 5000;
	public static final int TEN_SECONDS_IN_MILLISECONDS = 10000;
	public static final int THIRTEEN_SECONDS_IN_MILLISECONDS = 30000;
	public static final int FIFTEEN_SECONDS_IN_MILLISECONDS = 15000;

	// Test steps
	public static final int TEST_STEP_1 = 1;
	public static final int TEST_STEP_2 = 2;
	public static final int TEST_STEP_3 = 3;
	public static final int TEST_STEP_4 = 4;
	public static final int TEST_STEP_5 = 5;
	public static final int TEST_STEP_6 = 6;
	public static final int TEST_STEP_7 = 7;
	public static final int TEST_STEP_8 = 8;
	public static final int TEST_STEP_9 = 9;
	public static final int TEST_STEP_10 = 10;
	public static final int TEST_STEP_11 = 11;
	public static final int TEST_STEP_12 = 12;
	public static final int TEST_STEP_13 = 13;

	//P2 Project Creation
	public static final String FD_JOBTYPE = "Fiber Deep";
	public static final String NE_DIVISION = "NORTHEAST DIVISION";
	public static final String BELT_REGION = "BELTWAY";
	public static final String NE_MARKET = "BELTWAY CENTRAL";
	public static final String D04_WAREHOUSE = "D04";
	public static final String NONE = "--None--";
	public static final String PROJECT_INFO = "Automation_Test Project";
	public static final String AUTOMATION = "Automation_";
	public static final String LEV_HUB = "Levittown";

	//Task
	public static final String WALKOUT_TASK = "_Walkout";
	public static final String RFOSP_TASK = "_RF/OSP Design";
	public static final String OPTICAL_TASK = "_Optical Design";
	public static final String NODE_TASK = "_Node Spotting";




	//General
	public static final String INNERHTML = "innerHTML";
	public static final String SORT="Sort";
	public static final String YES="Yes";
	public static final String NO="No";
	//BP Company

	public static final String CCG_BP = "COMMUNICATIONS CONSTRUCTION GROUP LLC";

	//Task Status
	public static final String ASSIGNED = "Assigned";
	public static final String ACCEPTED = "Accepted";

	//Task Page
	public static final String EDIT = "Edit";
	public static final String EDIT_TASK_TYPE = "Edit Task Type";
	public static final String EDIT_P2_TASK_NAME = "Edit P2 Task Name";
	public static final String EDIT_CHILD_NAME = "Edit Child Node";


	public static final String BP="Bussiness Patner";
	public static final String JO="Job Owner";
	public static final int TAB_STEP_0 = 0;
	public static final int TAB_STEP_1 = 1;
	public static final int TAB_STEP_2 = 2;
	public static final int TAB_STEP_3 = 3;
	public static final int TAB_STEP_4 = 4;
	public static final int TAB_STEP_5 = 5;
	public static final int TAB_STEP_6 = 6;
	public static final int DIV_STEP_0 = 0;
	public static final int DIV_STEP_1 = 1;
	public static final int DIV_STEP_2 = 2;
	public static final int DIV_STEP_3 = 3;
	public static final int DIV_STEP_4 = 4;
	public static final int DIV_STEP_5 = 5;
	public static final int DIV_STEP_6 = 6;
	public static final int DIV_STEP_7 = 7;
	public static final int DIV_STEP_8 = 8;
	public static final int DIV_STEP_9 = 9;
	public static final int DIV_STEP_15 =15;
	public static final int DIV_STEP_16=16;
	public static final int DIV_STEP_21 =21;
	public static final int DIV_STEP_22 =22;
	public static final int DIV_STEP_23=23;
	public static final int DIV_STEP_24=24;
	public static final String TASK_SELECTION_BEFORE="Before Task Selection";
	public static final String TASK_SELECTION_AFTER="After Task Selection";



}
