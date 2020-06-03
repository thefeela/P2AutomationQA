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


public class HomePageXpathLocators {
	//	private static Logger logger = LogManager.getLogger(HomePageXpathLocators.class.getCanonicalName());

	static Map<String, String> userHomeMap = new HashMap<String, String>();

	boolean configLoaded1 = false;
	Properties prop = new  Properties()

	public static boolean loadConfig() {

		boolean configLoaded1 = false;
		Properties prop = new  Properties()

		FileInputStream fip = new FileInputStream("./Resource/TaskManagement.Properties");
		prop.load(fip);
		userHomeMap.putAll(prop.entrySet().stream().collect());
		configLoaded1 = true;
		//println	TaskManagementMap.get("next").value;
		return configLoaded1;
	}

	// Get P2Project Xpath
	public static String getP2Project() {
		return userHomeMap.get("p2_project");
	}

	// Get P2Project Xpath
	public static String getCreateP2Project() {
		return userHomeMap.get("createProject");
	}
	// Get P2Project Xpath
	public static String getNewProjectWindowTitle() {
		return userHomeMap.get("newProjectWindowTitle");
	}
	// Get Jobs Xpath
	public static String getJob() {
		return userHomeMap.get("jobs");
	}

	// Get Permit Xpath
	public static String getPermit() {
		return userHomeMap.get("permit");
	}
	// Get Permit Xpath
	public static String getInputDesc() {
		return userHomeMap.get("inputDesc");
	}
	// Get Permit Xpath
	public static String getImportNodes() {
		return userHomeMap.get("importNodes");
	}
	// Get P2Project Xpath
	public static String getSurveys() {
		return userHomeMap.get("surveys");
	}
	// Get Invoices Xpath
	public static String getInvoices() {
		return userHomeMap.get("invoices");
	}

	public static String getDashboard() {
		return userHomeMap.get("dashboard");
	}

	public static String getReports() {
		return userHomeMap.get("reports");
	}

	public static String getP2() {
		return userHomeMap.get("p2");
	}

	public static String getApproval() {
		return userHomeMap.get("approval");
	}

	public static String getLabor() {
		return userHomeMap.get("labor");
	}
	public static String getHomeTabList() {
		return userHomeMap.get("homeTab");
	}
	public static String getActiveElementt() {
		return userHomeMap.get("activeElement");
	}

	//Get Search Xpath
	public static String getSearch() {
		return userHomeMap.get("search");
	}

	// Get Invoices Xpath
	public static String getNcpHubSearch() {
		return userHomeMap.get("ncpHubSearch");
	}

	// Get Home Xpath
	public static String getHome() {
		return userHomeMap.get("home");
	}
	// Get Project Name Xpath
	public static String getInputType() {
		return userHomeMap.get("inputeType");
	}
	// Get Warehouse Xpath
	public static String getWarehouse() {
		return userHomeMap.get("warehouse_Project");
	}
	// Get First list of job list view xpath
	public static String getFirstID_JobsListView() {
		return userHomeMap.get("jobsList_firstid");
	}
	// Get Warehouse Xpath
	public static String getCreatPhase() {
		return userHomeMap.get("creatPhase");
	}
	// Get Warehouse Xpath
	public static String getParentNodesTab() {
		return userHomeMap.get("parentNodesTab");
	}
	// Get Warehouse Xpath
	public static String getNoofParentNodes() {
		return userHomeMap.get("noofParentNodes");
	}
	// Get Warehouse Xpath
	public static String getJobCheckBox() {
		return userHomeMap.get("jobCheckBox");
	}
	// Get Warehouse Xpath
	public static String getJobid_Get() {
		return userHomeMap.get("jobid_Get");
	}
	// Get Warehouse Xpath
	public static String getBtn_Assign_Phase() {
		return userHomeMap.get("btn_Assign_Phase");
	}
	// Get Warehouse Xpath
	public static String getDropdown_assignPhase() {
		return userHomeMap.get("dropdown_assignPhase");
	}
	// Get Warehouse Xpath
	public static String getBtn_CreateJob() {
		return userHomeMap.get("btn_CreateJob");
	}
	// Get chatter Xpath
	public static String getChatter() {
		return userHomeMap.get("chatter");
	}
	// Get chatter Xpath
	public static String getP2Project_Val() {
		return userHomeMap.get("p2project_val");
	}
	// Get Save button Xpath
	public static String getPopupSaveBtn() {
		return userHomeMap.get("popupSaveBtn");
	}
	// Get Save button Xpath
	public static String getSaveBtn_NewProject() {
		return userHomeMap.get("saveBtn");
	}
	// Get App Lanucher
	public static String getAppLauncher() {
		return userHomeMap.get("appLauncher");
	}

	public static String getRecentitems() {
		return userHomeMap.get("recentitems");
	}

	public static String getHome_all() {
		return userHomeMap.get("home_all");
	}

	public static String getHome_myjobs() {
		return userHomeMap.get("home_myjobs");
	}

	public static String getMore() {
		return userHomeMap.get("more");
	}
	// Get Permit Xpath
	public static String getAllTasks() {
		return userHomeMap.get("allTasks");
	}
	// Get Task Edit field Xpath
	public static String getTaskEditField() {
		return userHomeMap.get("taskEditField");
	}
	// Get Scroll to Bottom of the page
	public static String getScrollToBottom() {
		return userHomeMap.get("scrollToBottom");
	}
	// Get Scroll to some position of the page
	public static String getScrollToPosition() {
		return userHomeMap.get("scrollToPosition");
	}
	// Get Scroll to some position of the page
	public static String getTaskName_P2Task() {
		return userHomeMap.get("TaskName_P2Task");
	}
	public static String getRequestJobsTab() {
		return userHomeMap.get("RequestJobsTab");
	}
	public static String getDetails() {
		return userHomeMap.get("Details");
	}
	public static String getNasdascope() {
		return userHomeMap.get("Nasdascope");
	}
	public static String getPhase() {
		return userHomeMap.get("Phase");
	}
	public static String getHub() {
		return userHomeMap.get("Hub");
	}
	public static String getParentNodes() {
		return userHomeMap.get("ParentNodes");
	}
	public static String getJobdetails() {
		return userHomeMap.get("JobDetails");
	}
	public static String getprojecthistory() {
		return userHomeMap.get("projecthistory");
	}
	public static String getInput() {
		return userHomeMap.get("Input");
	}
	public static String getTextarea() {
		return userHomeMap.get("Textarea");
	}
	public static String getSavebutton() {
		return userHomeMap.get("Savebutton");
	}
	public static String getInputAsIg() {
		return userHomeMap.get("InputAsIg");
	}
	public static String getClickCreatedPhase() {
		return userHomeMap.get("ClickCreatedPhase");
	}
	public static String getDetailsTabInPhase() {
		return userHomeMap.get("DetailsTabInPhase");
	}
	public static String getJobTabInPhase() {
		return userHomeMap.get("JobTabInPhase");
	}
	public static String getNodesTabInPhase() {
		return userHomeMap.get("NodesTabInPhase");
	}
	public static String getLinkTextinPhase() {
		return userHomeMap.get("LinkTextinPhase");
	}
	public static String getDateinPhase() {
		return userHomeMap.get("DateinPhase");
	}
	public static String getEditPhase() {
		return userHomeMap.get("EditPhase");
	}
	public static String getSaveAfterEditPhase() {
		return userHomeMap.get("SaveAfterEditPhase");
	}
	public static String getPhaseA13() {
		return userHomeMap.get("PhaseA13");
	}
	public static String getNewPhaseDescriptionTest() {
		return userHomeMap.get("NewPhaseDescriptionTest");
	}

}
