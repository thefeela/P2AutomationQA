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

public class JobcategoryInputParameters {
	private static Logger logger = LogManager.getLogger(JobcategoryInputParameters.class.getCanonicalName());

	static Map<String, String> appLaunchMap = new HashMap<String, String>();

	public boolean loadConfig() {

		boolean configLoaded = false;
		Properties prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream("./src/main/resources/Jobcategory.Properties");
			prop.load(fip);
			//appLaunchMap.putAll(prop.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
			appLaunchMap.putAll(prop.entrySet().stream().collect());
			configLoaded = true;
		} catch (FileNotFoundException e1) {
			logger.error("error loading file " + e1.getMessage());
		} catch (IOException e1) {
			logger.error("error loading file IOException " + e1.getMessage());
		}
		return configLoaded;
	}
	public static String getjob_requests() {
		return appLaunchMap.get("job_requests");
	}
	public static String getjobcreation_new() {
		return appLaunchMap.get("jobcreation_new");
	}
	public static String getnextbutton() {
		return appLaunchMap.get("nextbutton");
	}
	public static String getnext_categorybutton() {
		return appLaunchMap.get("next_categorybutton");
	}
	public static String gettotalPrePostCalcJobFlow() {
		return appLaunchMap.get("totalPrePostCalcJobFlow");
	}

	public static String getcategory_select() {
		return appLaunchMap.get("category_select");
	}
	public static String getoption_category() {
		return appLaunchMap.get("option_category");
	}
	public static String getresidential_category() {
		return appLaunchMap.get("residential_category");
	}
	public static String getjobtype_residential_MDU() {
		return appLaunchMap.get("jobtype_residential_MDU");
	}
	public static String getjobtype_residential_SDU() {
		return appLaunchMap.get("jobtype_residential_SDU");
	}
	public static String getsubtype_residential_MDU_FTTB() {
		return appLaunchMap.get("subtype_residential_MDU_FTTB");
	}
	public static String getsubtype_residential_MDU_FTTU() {
		return appLaunchMap.get("subtype_residential_MDU_FTTU");
	}
	public static String getsubtype_residential_MDU_HFC() {
		return appLaunchMap.get("subtype_residential_MDU_HFC");
	}

	public static String getsubtype_commercial_Cell_Backhaul_SmallCell() {
		return appLaunchMap.get("subtype_commercial_Cell_Backhaul_SmallCell");
	}
	public static String getjobtype_commercial_Dark_Fiber() {
		return appLaunchMap.get("jobtype_commercial_Dark_Fiber");
	}
	public static String getsubtype_commercial_Dark_Fiber_IRU() {
		return appLaunchMap.get("subtype_commercial_Dark_Fiber_IRU");
	}
	public static String getjobtype_commercial_Hyperbuild() {
		return appLaunchMap.get("jobtype_commercial_Hyperbuild");
	}
	public static String getsubtype_commercial_Hyperbuild_Metro_Core() {
		return appLaunchMap.get("subtype_commercial_Hyperbuild_Metro_Core");
	}
	public static String getsubtype_commercial_Hyperbuild_Probuild() {
		return appLaunchMap.get("subtype_commercial_Hyperbuild_Probuild");
	}
	public static String getsubtype_commercial_Hyperbuild_Smartbuild() {
		return appLaunchMap.get("subtype_commercial_Hyperbuild_Smartbuild");
	}
	public static String getjobtype_commercial_Metro_E_Retail() {
		return appLaunchMap.get("jobtype_commercial_Metro_E_Retail");
	}
	public static String getsubtype_commercial_Metro_E_Retail_EoHFC() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Retail_EoHFC");
	}
	public static String getsubtype_commercial_Metro_E_Retail_Fiber() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Retail_Fiber");
	}
	public static String getjobtype_commercial_Metro_E_Wholesale() {
		return appLaunchMap.get("jobtype_commercial_Metro_E_Wholesale");
	}
	public static String getsubtype_commercial_Metro_E_Wholesale_EoHFC() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Wholesale_EoHFC");
	}
	public static String getsubtype_commercial_Metro_E_Wholesale_Fiber() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Wholesale_Fiber");
	}
	public static String getjobtype_commercial_SMB() {
		return appLaunchMap.get("jobtype_commercial_SMB");
	}

	public static String getcreateJob_compactlayot() {
		return appLaunchMap.get("createJob_compactlayot");
	}



	public static String getjobtype_commercial_Cell_Backhaul() {
		return appLaunchMap.get("jobtype_commercial_Cell_Backhaul");
	}
	public static String getcommercial_category() {
		return appLaunchMap.get("commercial_category");
	}
	public static String getsubtype_residential_SDU_FTTP() {
		return appLaunchMap.get("subtype_residential_SDU_FTTP");
	}
	public static String getsubtype_residential_SDU_HFC() {
		return appLaunchMap.get("subtype_residential_SDU_HFC");
	}

	public static String getjobtype_AerialMakeReady() {
		return appLaunchMap.get("jobtype_AerialMakeReady");
	}
	public static String getjobtype_MDURewiring() {
		return appLaunchMap.get("jobtype_MDURewiring");
	}
	public static String getjobtype_SpanReplacements() {
		return appLaunchMap.get("jobtype_SpanReplacements");
	}
	public static String getjobtype_LineExtension() {
		return appLaunchMap.get("jobtype_LineExtension");
	}
	public static String getsubtype_LineExtension_Coax() {
		return appLaunchMap.get("subtype_LineExtension_Coax");
	}
	public static String getsubtype_LineExtension_Coax_Fiber() {
		return appLaunchMap.get("subtype_LineExtension_Coax_Fiber");
	}
	public static String getsubtype_LineExtension_Fiber() {
		return appLaunchMap.get("subtype_LineExtension_Fiber");
	}
	public static String getsubtype_MDURewiring_HFC() {
		return appLaunchMap.get("subtype_MDURewiring_HFC");
	}
	public static String getsubtype_MDURewiring_FTTP() {
		return appLaunchMap.get("subtype_MDURewiring_FTTP");
	}
	public static String getinputaddress() {
		return appLaunchMap.get("inputaddress");
	}
	public static String getinputaddress_click() {
		return appLaunchMap.get("inputaddress_click");
	}
	public static String getinputaddress_value() {
		return appLaunchMap.get("inputaddress_value");
	}
	public static String getneedByField() {
		return appLaunchMap.get("needByField");
	}
	public static String getcommentsField() {
		return appLaunchMap.get("commentsField");
	}
	public static String getcommentsField_value() {
		return appLaunchMap.get("commentsField_value");
	}
	public static String getcifawarehouse() {
		return appLaunchMap.get("cifawarehouse");
	}
	public static String getcifawarehouse_value() {
		return appLaunchMap.get("cifawarehouse_value");
	}

	public static String getnextbuttonJobInputFlow() {
		return appLaunchMap.get("nextbuttonJobInputFlow");
	}
	public static String getsubtype_AerialMakeReady_PoleTransfers() {
		return appLaunchMap.get("subtype_AerialMakeReady_PoleTransfers");
	}
	public static String getjobtype_ForcedRelocates() {
		return appLaunchMap.get("jobtype_ForcedRelocates");
	}
	public static String getsubtype_ForcedRelocates_NonReimbursable() {
		return appLaunchMap.get("subtype_ForcedRelocates_NonReimbursable");
	}
	public static String getsubtype_ForcedRelocates_Reimbursable() {
		return appLaunchMap.get("subtype_ForcedRelocates_Reimbursable");
	}
	public static String getjobtype_ManholeReplacement() {
		return appLaunchMap.get("jobtype_ManholeReplacement");
	}
	public static String getjobActionButtonValidation() {
		return appLaunchMap.get("jobActionButtonValidation");
	}
	public static String getverifyHighlightPanelFieldTextArea() {
		return appLaunchMap.get("verifyHighlightPanelFieldTextArea");
	}
	public static String getcifawarehose_Select() {
		return appLaunchMap.get("cifawarehose_Select");
	}
	public static String getjobDetail_Select() {
		return appLaunchMap.get("jobDetail_Select");
	}
	public static String getscrolldowntosavebutton() {
		return appLaunchMap.get("scrolldowntosavebutton");
	}
	public static String getUnfunded_Text() {
		return appLaunchMap.get("Unfunded");
	}
	public static String getDescription_check() {
		return appLaunchMap.get("Description_check");
	}
	public static String getlaborZone() {
		return appLaunchMap.get("laborZone");
	}
	public static String getverifyHighlightPanelText() {
		return appLaunchMap.get("verifyHighlightPanelText");
	}
	public static String getnotRequiredButton() {
		return appLaunchMap.get("notRequiredButton");
	}
	public static String getjobdetails() {
		return appLaunchMap.get("jobdetails");
	}
	public static String getmore() {
		return appLaunchMap.get("more");
	}
	public static String getvalidateReadOnlyJobFields() {
		return appLaunchMap.get("validateReadOnlyJobFields");
	}

	public static String getvalidatejobfields() {
		return appLaunchMap.get("validatejobfields");
	}
	public static String getp2task_checkbox() {
		return appLaunchMap.get("p2task_checkbox");
	}
	public static String getquickActionbuttons() {
		return appLaunchMap.get("quickActionbuttons");
	}
	public static String getassignbutton() {
		return appLaunchMap.get("assignbutton");
	}
	public static String getapprovebutton() {
		return appLaunchMap.get("approvebutton");
	}

	public static String getedit_compactlayot() {
		return appLaunchMap.get("edit_compactlayot");
	}
	public static String getchangedate_compactlayot() {
		return appLaunchMap.get("changedate_compactlayot");
	}
	public static String getMaterials_compactlayot() {
		return appLaunchMap.get("Materials_compactlayot");
	}
	public static String getContract_compactlayot() {
		return appLaunchMap.get("Contract_compactlayot");
	}
	public static String getFootage_compactlayot() {
		return appLaunchMap.get("Footage_compactlayot");
	}
	public static String getHold_compactlayot() {
		return appLaunchMap.get("Hold_compactlayot");
	}
	public static String getclose_compactlayot() {
		return appLaunchMap.get("close_compactlayot");
	}
	public static String getapproval_compactlayot() {
		return appLaunchMap.get("approval_compactlayot");
	}
	public static String getcancel_compactlayot() {
		return appLaunchMap.get("cancel_compactlayot");
	}

	public static String getexternalsysId() {
		return appLaunchMap.get("externalsysId");
	}
	public static String getinitiatedByEmail() {
		return appLaunchMap.get("initiatedByEmail");
	}
	public static String getinitiatedBy() {
		return appLaunchMap.get("initiatedBy");
	}

	public static String getsitedevelopmentpropname() {
		return appLaunchMap.get("sitedevelopmentpropname");
	}
	public static String getcustomername() {
		return appLaunchMap.get("customername");
	}
	public static String getcustomercontactname() {
		return appLaunchMap.get("customercontactname");
	}
	public static String getcustomercontactemail() {
		return appLaunchMap.get("customercontactemail");
	}
	public static String getcustomercontactphone() {
		return appLaunchMap.get("customercontactphone");
	}
	public static String getlocalcontactname() {
		return appLaunchMap.get("localcontactname");
	}
	public static String getlocalcontactemail() {
		return appLaunchMap.get("localcontactemail");
	}
	public static String getCustomerdropdown() {
		return appLaunchMap.get("Customerdropdown");
	}
	public static String getoktoContact() {
		return appLaunchMap.get("oktoContact");
	}
	public static String getDonotContact() {
		return appLaunchMap.get("DonotContact");
	}
	public static String getscrolldown() {
		return appLaunchMap.get("scrolldown");
	}
	public static String getjobDetails() {
		return appLaunchMap.get("jobDetails");
	}
	public static String getncpnodesearch() {
		return appLaunchMap.get("ncpnodesearch");
	}
	public static String getoption_category_scalable() {
		return appLaunchMap.get("option_category_scalable");
	}
	public static String getjobtype_NodeSegmentation() {
		return appLaunchMap.get("jobtype_NodeSegmentation");
	}
	public static String getsubtype_FiberBuildAdditional() {
		return appLaunchMap.get("subtype_FiberBuildAdditional");
	}
	public static String getncpnodevalue() {
		return appLaunchMap.get("ncpnodevalue");
	}
	public static String getproactive_select() {
		return appLaunchMap.get("proactive_select");
	}
	public static String getoption_proactive() {
		return appLaunchMap.get("option_proactive");
	}
	public static String getoption_Reactive() {
		return appLaunchMap.get("option_Reactive");
	}
	public static String getoption_Standard() {
		return appLaunchMap.get("option_Standard");
	}
	public static String getoption_High() {
		return appLaunchMap.get("option_High");
	}
	public static String getbutton_selectdate() {
		return appLaunchMap.get("button_selectdate");
	}
	public static String getsubtype_NodeReplacementOptics() {
		return appLaunchMap.get("subtype_NodeReplacementOptics");
	}
	public static String getsubtype_OpticsOnly() {
		return appLaunchMap.get("subtype_OpticsOnly");
	}
	public static String getsubtype_OpticsCoaxConstruction() {
		return appLaunchMap.get("subtype_OpticsCoaxConstruction");
	}
	public static String getsubtype_rebalance() {
		return appLaunchMap.get("subtype_rebalance");
	}
	public static String getjobtype_Upgrade_Rebuild() {
		return appLaunchMap.get("jobtype_Upgrade_Rebuild");
	}
	public static String getjobtype_Backbone() {
		return appLaunchMap.get("jobtype_Backbone");
	}
	public static String getjobtype_cran() {
		return appLaunchMap.get("jobtype_cran");
	}
	public static String getjobtype_Fiber_Redundancy() {
		return appLaunchMap.get("jobtype_Fiber_Redundancy");
	}
	public static String getjobtype_INET() {
		return appLaunchMap.get("jobtype_INET");
	}
	public static String getjobtype_Wifioutdoor() {
		return appLaunchMap.get("jobtype_Wifioutdoor");
	}
	public static String getinput_Zipcode() {
		return appLaunchMap.get("input_Zipcode");
	}
	public static String getdropdownvalue() {
		return appLaunchMap.get("dropdownvalue");
	}
	public static String getinput_jobdesc() {
		return appLaunchMap.get("input_jobdesc");
	}
	public static String getzipcode() {
		return appLaunchMap.get("zipcode");
	}

	public static String getDRMA_select() {
		return appLaunchMap.get("DRMA_select");
	}
	public static String getjobtype_fiberdeep() {
		return appLaunchMap.get("jobtype_fiberdeep");
	}
	public static String getProject_name() {
		return appLaunchMap.get("Project_name");
	}
	public static String getselect_request() {
		return appLaunchMap.get("select_request");
	}
	public static String getrequest_option() {
		return appLaunchMap.get("request_option");
	}
	public static String gettotalPrePostCalcJobFlow_value1() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_value1");
	}
	public static String gettotalPrePostCalcJobFlow_value2() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_value2");
	}
	public static String gettotalPrePostCalcJobFlow_value3() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_value3");
	}
	public static String getcifa_value_select() {
		return appLaunchMap.get("cifa_value_select");
	}
	public static String getCustomernamevalue() {
		return appLaunchMap.get("Customernamevalue");
	}
	public static String getintiatedby_value() {
		return appLaunchMap.get("intiatedby_value");
	}
	public static String getintiatedbyid_value() {
		return appLaunchMap.get("intiatedbyid_value");
	}
	public static String getSite_Development_value() {
		return appLaunchMap.get("Site_Development_value");
	}
	public static String getexternalid_value() {
		return appLaunchMap.get("externalid_value");
	}
	public static String getcustomer_contact_email_value() {
		return appLaunchMap.get("customer_contact_email_value");
	}
	public static String getphne_value() {
		return appLaunchMap.get("phne_value");
	}
	public static String getcustomer_Contact_value() {
		return appLaunchMap.get("customer_Contact_value");
	}
	public static String getEdit() {
		return appLaunchMap.get("Edit");
	}
	public static String getChangeDate() {
		return appLaunchMap.get("ChangeDate");
	}
	public static String getAddMaterials() {
		return appLaunchMap.get("AddMaterials");
	}
	public static String getAddContractLabor() {
		return appLaunchMap.get("AddContractLabor");
	}
	public static String getAddConstructedFootage() {
		return appLaunchMap.get("AddConstructedFootage");
	}
	public static String getHold_Unhold() {
		return appLaunchMap.get("Hold_Unhold");
	}
	public static String getClose() {
		return appLaunchMap.get("Close");
	}
	public static String getSubmit_for_Approval() {
		return appLaunchMap.get("Submit_for_Approval");
	}
	public static String getUnfunded() {
		return appLaunchMap.get("Unfunded");
	}
	public static String getOpened() {
		return appLaunchMap.get("Opened");
	}
	public static String getCreateJob() {
		return appLaunchMap.get("CreateJob");
	}
	public static String getPending() {
		return appLaunchMap.get("Pending");
	}
	public static String getCancel() {
		return appLaunchMap.get("Cancel");
	}
	public static String getsubtype_scalable_Design() {
		return appLaunchMap.get("subtype_scalable_Design");
	}
	public static String getsubtype_scalable_Fiber_Transport() {
		return appLaunchMap.get("subtype_scalable_Fiber_Transport");
	}
	public static String getsubtype_scalable_Headend() {
		return appLaunchMap.get("subtype_scalable_Headend");
	}
	public static String getsubtype_scalable_Permit_Traffic() {
		return appLaunchMap.get("subtype_scalable_Permit_Traffic");
	}
	public static String getsubtype_scalable_Walkout() {
		return appLaunchMap.get("subtype_scalable_Walkout");
	}
	public static String getoption_milestone() {
		return appLaunchMap.get("option_milestone");
	}
	public static String getTasktype_Milestone() {
		return appLaunchMap.get("Tasktype_Milestone");
	}
	public static String getmilestone_select() {
		return appLaunchMap.get("milestone_select");
	}
	public static String getmilestonenext_button() {
		return appLaunchMap.get("milestonenext_button");
	}
	public static String getinput_taskname() {
		return appLaunchMap.get("input_taskname");
	}
	public static String getJobid_click() {
		return appLaunchMap.get("Jobid_click");
	}
	public static String getsubtype_value_subtype() {
		return appLaunchMap.get("subtype_value_subtype");
	}
	public static String getfinish_button() {
		return appLaunchMap.get("finish_button");
	}
	public static String gettasks() {
		return appLaunchMap.get("tasks");
	}
	public static String getchatter() {
		return appLaunchMap.get("chatter");
	}
	public static String getsurveys() {
		return appLaunchMap.get("surveys");
	}
	public static String getestimates() {
		return appLaunchMap.get("estimates");
	}
	public static String getpayback() {
		return appLaunchMap.get("payback");
	}
	public static String getaddress() {
		return appLaunchMap.get("address");
	}
	public static String getpermits() {
		return appLaunchMap.get("permits");
	}
	public static String getinvoic_lines() {
		return appLaunchMap.get("invoic_lines");
	}
	public static String getconstructed_ft() {
		return appLaunchMap.get("constructed_ft");
	}
	public static String getattachments() {
		return appLaunchMap.get("attachments");
	}
	public static String gethistory() {
		return appLaunchMap.get("history");
	}
	public static String getlocalcontactphone() {
		return appLaunchMap.get("localcontactphone");
	}
	public static String getExternalid() {
		return appLaunchMap.get("Externalid");
	}
	public static String getbetterment_nextbutton() {
		return appLaunchMap.get("betterment_nextbutton");
	}
}
