package p2.Properties

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.stream.Collectors;
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


import java.awt.Rectangle;
import java.text.MessageFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import internal.GlobalVariable

@Keyword public class JobcategoryInputParameters {
	private static Logger logger = LogManager.getLogger(JobcategoryInputParameters.class.getCanonicalName());

	public static Map<String, String> appLaunchMap = new HashMap<String, String>();

	@Keyword
	public static  boolean loadConfig() {

		boolean configLoaded = false;
		Properties prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream("./Resource/Jobcategory.Properties");
			prop.load(fip);
			//appLaunchMap.putAll(prop.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.get().toString())));
			appLaunchMap.putAll(prop.entrySet().stream().collect());
			configLoaded = true;
			//	println appLaunchMap.get("category_select");
		} catch (FileNotFoundException e1) {
			logger.error("error loading file " + e1.getMessage());
		} catch (IOException e1) {
			logger.error("error loading file IOException " + e1.getMessage());
		}
		return configLoaded;
	}
	@Keyword
	public static String getjob_requests() {
		return appLaunchMap.get("job_requests");
	}
	@Keyword
	public static String getjobcreation_new() {
		return appLaunchMap.get("jobcreation_new");
	}
	@Keyword
	def public static String getnextbutton() {
		return appLaunchMap.get("nextbutton");
	}
	@Keyword
	public static String getnext_categorybutton() {
		return appLaunchMap.get("next_categorybutton");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow() {
		return appLaunchMap.get("totalPrePostCalcJobFlow");
	}
	@Keyword
	def  public static String getcategory_select() {
		return appLaunchMap.get("category_select");
	}
	@Keyword
	public static String getoption_category() {
		return appLaunchMap.get("option_category");
	}
	@Keyword
	public static String getresidential_category() {
		return appLaunchMap.get("residential_category");
	}
	@Keyword
	public static String getjobtype_residential_MDU() {
		return appLaunchMap.get("jobtype_residential_MDU");
	}
	@Keyword
	public static String getjobtype_residential_SDU() {
		return appLaunchMap.get("jobtype_residential_SDU");
	}
	@Keyword
	public static String getsubtype_residential_MDU_FTTB() {
		return appLaunchMap.get("subtype_residential_MDU_FTTB");
	}
	@Keyword
	public static String getsubtype_residential_MDU_FTTU() {
		return appLaunchMap.get("subtype_residential_MDU_FTTU");
	}
	@Keyword
	public static String getsubtype_residential_MDU_HFC() {
		return appLaunchMap.get("subtype_residential_MDU_HFC");
	}

	@Keyword
	public static String getsubtype_commercial_Cell_Backhaul_SmallCell() {
		return appLaunchMap.get("subtype_commercial_Cell_Backhaul_SmallCell");
	}
	@Keyword
	public static String getjobtype_commercial_Dark_Fiber() {
		return appLaunchMap.get("jobtype_commercial_Dark_Fiber");
	}
	@Keyword
	public static String getsubtype_commercial_Dark_Fiber_IRU() {
		return appLaunchMap.get("subtype_commercial_Dark_Fiber_IRU");
	}
	@Keyword
	public static String getjobtype_commercial_Hyperbuild() {
		return appLaunchMap.get("jobtype_commercial_Hyperbuild");
	}
	@Keyword
	public static String getsubtype_commercial_Hyperbuild_Metro_Core() {
		return appLaunchMap.get("subtype_commercial_Hyperbuild_Metro_Core");
	}
	@Keyword
	public static String getsubtype_commercial_Hyperbuild_Probuild() {
		return appLaunchMap.get("subtype_commercial_Hyperbuild_Probuild");
	}
	@Keyword
	public static String getsubtype_commercial_Hyperbuild_Smartbuild() {
		return appLaunchMap.get("subtype_commercial_Hyperbuild_Smartbuild");
	}
	@Keyword
	public static String getjobtype_commercial_Metro_E_Retail() {
		return appLaunchMap.get("jobtype_commercial_Metro_E_Retail");
	}
	@Keyword
	public static String getsubtype_commercial_Metro_E_Retail_EoHFC() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Retail_EoHFC");
	}
	@Keyword
	public static String getsubtype_commercial_Metro_E_Retail_Fiber() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Retail_Fiber");
	}
	@Keyword
	public static String getjobtype_commercial_Metro_E_Wholesale() {
		return appLaunchMap.get("jobtype_commercial_Metro_E_Wholesale");
	}
	@Keyword
	public
	static String getsubtype_commercial_Metro_E_Wholesale_EoHFC() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Wholesale_EoHFC");
	}
	@Keyword
	public static String getsubtype_commercial_Metro_E_Wholesale_Fiber() {
		return appLaunchMap.get("subtype_commercial_Metro_E_Wholesale_Fiber");
	}
	@Keyword
	public static String getjobtype_commercial_SMB() {
		return appLaunchMap.get("jobtype_commercial_SMB");
	}

	@Keyword
	public static String getcreateJob_compactlayot() {
		return appLaunchMap.get("createJob_compactlayot");
	}



	@Keyword
	public static String getjobtype_commercial_Cell_Backhaul() {
		return appLaunchMap.get("jobtype_commercial_Cell_Backhaul");
	}
	@Keyword
	public static String getcommercial_category() {
		return appLaunchMap.get("commercial_category");
	}
	@Keyword
	public static String getsubtype_residential_SDU_FTTP() {
		return appLaunchMap.get("subtype_residential_SDU_FTTP");
	}
	@Keyword
	public static String getsubtype_residential_SDU_HFC() {
		return appLaunchMap.get("subtype_residential_SDU_HFC");
	}

	@Keyword
	public static String getjobtype_AerialMakeReady() {
		return appLaunchMap.get("jobtype_AerialMakeReady");
	}
	@Keyword
	public static String getjobtype_MDURewiring() {
		return appLaunchMap.get("jobtype_MDURewiring");
	}
	@Keyword
	public static String getjobtype_SpanReplacements() {
		return appLaunchMap.get("jobtype_SpanReplacements");
	}
	@Keyword
	public static String getjobtype_LineExtension() {
		return appLaunchMap.get("jobtype_LineExtension");
	}
	@Keyword
	public static String getsubtype_LineExtension_Coax() {
		return appLaunchMap.get("subtype_LineExtension_Coax");
	}
	@Keyword
	public static String getsubtype_LineExtension_Coax_Fiber() {
		return appLaunchMap.get("subtype_LineExtension_Coax_Fiber");
	}
	@Keyword
	public static String getsubtype_LineExtension_Fiber() {
		return appLaunchMap.get("subtype_LineExtension_Fiber");
	}
	@Keyword
	public static String getsubtype_MDURewiring_HFC() {
		return appLaunchMap.get("subtype_MDURewiring_HFC");
	}
	@Keyword
	public static String getsubtype_MDURewiring_FTTP() {
		return appLaunchMap.get("subtype_MDURewiring_FTTP");
	}
	@Keyword
	public static String getinputaddress() {
		return appLaunchMap.get("inputaddress");
	}
	@Keyword
	public static String getinputaddress_click() {
		return appLaunchMap.get("inputaddress_click");
	}
	@Keyword
	public static String getinputaddress_() {
		return appLaunchMap.get("inputaddress_");
	}
	@Keyword
	public static String getneedByField() {
		return appLaunchMap.get("needByField");
	}
	@Keyword
	public static String getcommentsField() {
		return appLaunchMap.get("commentsField");
	}
	@Keyword
	public static String getcommentsField_() {
		return appLaunchMap.get("commentsField_");
	}
	@Keyword
	public static String getcifawarehouse() {
		return appLaunchMap.get("cifawarehouse");
	}
	@Keyword
	public static String getcifawarehouse_() {
		return appLaunchMap.get("cifawarehouse_");
	}

	@Keyword
	public static String getnextbuttonJobInputFlow() {
		return appLaunchMap.get("nextbuttonJobInputFlow");
	}
	@Keyword
	public static String getsubtype_AerialMakeReady_PoleTransfers() {
		return appLaunchMap.get("subtype_AerialMakeReady_PoleTransfers");
	}
	@Keyword
	public static String getjobtype_ForcedRelocates() {
		return appLaunchMap.get("jobtype_ForcedRelocates");
	}
	@Keyword
	public static String getsubtype_ForcedRelocates_NonReimbursable() {
		return appLaunchMap.get("subtype_ForcedRelocates_NonReimbursable");
	}
	@Keyword
	public static String getsubtype_ForcedRelocates_Reimbursable() {
		return appLaunchMap.get("subtype_ForcedRelocates_Reimbursable");
	}
	@Keyword
	public static String getjobtype_ManholeReplacement() {
		return appLaunchMap.get("jobtype_ManholeReplacement");
	}
	@Keyword
	public static String getjobActionButtonValidation() {
		return appLaunchMap.get("jobActionButtonValidation");
	}
	@Keyword
	public static String getverifyHighlightPanelFieldTextArea() {
		return appLaunchMap.get("verifyHighlightPanelFieldTextArea");
	}
	@Keyword
	public static String getcifawarehose_Select() {
		return appLaunchMap.get("cifawarehose_Select");
	}
	@Keyword
	public static String getjobDetail_Select() {
		return appLaunchMap.get("jobDetail_Select");
	}
	@Keyword
	public static String getscrolldowntosavebutton() {
		return appLaunchMap.get("scrolldowntosavebutton");
	}
	@Keyword
	public static String getUnfunded_Text() {
		return appLaunchMap.get("Unfunded");
	}
	@Keyword
	public static String getDescription_check() {
		return appLaunchMap.get("Description_check");
	}
	@Keyword
	public static String getlaborZone() {
		return appLaunchMap.get("laborZone");
	}
	@Keyword
	public static String getverifyHighlightPanelText() {
		return appLaunchMap.get("verifyHighlightPanelText");
	}
	@Keyword
	public static String getnotRequiredButton() {
		return appLaunchMap.get("notRequiredButton");
	}
	@Keyword
	public static String getjobdetails() {
		return appLaunchMap.get("jobdetails");
	}
	@Keyword
	public static String getmore() {
		return appLaunchMap.get("more");
	}
	@Keyword
	public static String getvalidateReadOnlyJobFields() {
		return appLaunchMap.get("validateReadOnlyJobFields");
	}

	@Keyword
	public static String getvalidatejobfields() {
		return appLaunchMap.get("validatejobfields");
	}
	@Keyword
	public static String getp2task_checkbox() {
		return appLaunchMap.get("p2task_checkbox");
	}
	@Keyword
	public static String getquickActionbuttons() {
		return appLaunchMap.get("quickActionbuttons");
	}
	@Keyword
	public static String getassignbutton() {
		return appLaunchMap.get("assignbutton");
	}
	@Keyword
	public static String getapprovebutton() {
		return appLaunchMap.get("approvebutton");
	}

	@Keyword
	public static String getedit_compactlayot() {
		return appLaunchMap.get("edit_compactlayot");
	}
	@Keyword
	public static String getchangedate_compactlayot() {
		return appLaunchMap.get("changedate_compactlayot");
	}
	@Keyword
	public static String getMaterials_compactlayot() {
		return appLaunchMap.get("Materials_compactlayot");
	}
	@Keyword
	public static String getContract_compactlayot() {
		return appLaunchMap.get("Contract_compactlayot");
	}
	@Keyword
	public static String getFootage_compactlayot() {
		return appLaunchMap.get("Footage_compactlayot");
	}
	@Keyword
	public static String getHold_compactlayot() {
		return appLaunchMap.get("Hold_compactlayot");
	}
	@Keyword
	public static String getclose_compactlayot() {
		return appLaunchMap.get("close_compactlayot");
	}
	@Keyword
	public static String getapproval_compactlayot() {
		return appLaunchMap.get("approval_compactlayot");
	}
	@Keyword
	public static String getcancel_compactlayot() {
		return appLaunchMap.get("cancel_compactlayot");
	}

	@Keyword
	public static String getexternalsysId() {
		return appLaunchMap.get("externalsysId");
	}
	@Keyword
	public static String getinitiatedByEmail() {
		return appLaunchMap.get("initiatedByEmail");
	}
	@Keyword
	public static String getinitiatedBy() {
		return appLaunchMap.get("initiatedBy");
	}

	@Keyword
	public static String getsitedevelopmentpropname() {
		return appLaunchMap.get("sitedevelopmentpropname");
	}
	@Keyword
	public static String getcustomername() {
		return appLaunchMap.get("customername");
	}
	@Keyword
	public static String getcustomercontactname() {
		return appLaunchMap.get("customercontactname");
	}
	@Keyword
	public static String getcustomercontactemail() {
		return appLaunchMap.get("customercontactemail");
	}
	@Keyword
	public static String getcustomercontactphone() {
		return appLaunchMap.get("customercontactphone");
	}
	@Keyword
	public static String getlocalcontactname() {
		return appLaunchMap.get("localcontactname");
	}
	@Keyword
	public static String getlocalcontactemail() {
		return appLaunchMap.get("localcontactemail");
	}
	@Keyword
	public static String getCustomerdropdown() {
		return appLaunchMap.get("Customerdropdown");
	}
	@Keyword
	public static String getoktoContact() {
		return appLaunchMap.get("oktoContact");
	}
	@Keyword
	public static String getDonotContact() {
		return appLaunchMap.get("DonotContact");
	}
	@Keyword
	public static String getscrolldown() {
		return appLaunchMap.get("scrolldown");
	}
	@Keyword
	public static String getjobDetails() {
		return appLaunchMap.get("jobDetails");
	}
	@Keyword public static String getncpnodesearch() {
		return appLaunchMap.get("ncpnodesearch");
	}
	@Keyword
	public static String getoption_category_scalable() {
		return appLaunchMap.get("option_category_scalable");
	}
	@Keyword
	public static String getjobtype_NodeSegmentation() {
		return appLaunchMap.get("jobtype_NodeSegmentation");
	}
	@Keyword
	public static String getsubtype_FiberBuildAdditional() {
		return appLaunchMap.get("subtype_FiberBuildAdditional");
	}
	@Keyword
	public static String getncpnode() {
		return appLaunchMap.get("ncpnode");
	}
	@Keyword
	public static String getproactive_select() {
		return appLaunchMap.get("proactive_select");
	}
	@Keyword
	public static String getoption_proactive() {
		return appLaunchMap.get("option_proactive");
	}
	@Keyword
	public static String getoption_Reactive() {
		return appLaunchMap.get("option_Reactive");
	}
	@Keyword
	public static String getoption_Standard() {
		return appLaunchMap.get("option_Standard");
	}
	@Keyword
	public static String getoption_High() {
		return appLaunchMap.get("option_High");
	}
	@Keyword
	public static String getbutton_selectdate() {
		return appLaunchMap.get("button_selectdate");
	}
	@Keyword
	public static String getsubtype_NodeReplacementOptics() {
		return appLaunchMap.get("subtype_NodeReplacementOptics");
	}
	@Keyword
	public static String getsubtype_OpticsOnly() {
		return appLaunchMap.get("subtype_OpticsOnly");
	}
	@Keyword
	public static String getsubtype_OpticsCoaxConstruction() {
		return appLaunchMap.get("subtype_OpticsCoaxConstruction");
	}
	@Keyword
	public static String getsubtype_rebalance() {
		return appLaunchMap.get("subtype_rebalance");
	}
	@Keyword
	public static String getjobtype_Upgrade_Rebuild() {
		return appLaunchMap.get("jobtype_Upgrade_Rebuild");
	}
	@Keyword
	public static String getjobtype_Backbone() {
		return appLaunchMap.get("jobtype_Backbone");
	}
	@Keyword
	public static String getjobtype_cran() {
		return appLaunchMap.get("jobtype_cran");
	}
	@Keyword
	public static String getjobtype_Fiber_Redundancy() {
		return appLaunchMap.get("jobtype_Fiber_Redundancy");
	}
	@Keyword
	public static String getjobtype_INET() {
		return appLaunchMap.get("jobtype_INET");
	}
	@Keyword
	public static String getjobtype_Wifioutdoor() {
		return appLaunchMap.get("jobtype_Wifioutdoor");
	}
	@Keyword
	public static String getinput_Zipcode() {
		return appLaunchMap.get("input_Zipcode");
	}
	@Keyword
	public static String getdropdown() {
		return appLaunchMap.get("dropdown");
	}
	@Keyword
	public static String getinput_jobdesc() {
		return appLaunchMap.get("input_jobdesc");
	}
	@Keyword
	public static String getzipcode() {
		return appLaunchMap.get("zipcode");
	}

	@Keyword
	public static String getDRMA_select() {
		return appLaunchMap.get("DRMA_select");
	}
	@Keyword
	public static String getjobtype_fiberdeep() {
		return appLaunchMap.get("jobtype_fiberdeep");
	}
	@Keyword
	public static String getProject_name() {
		return appLaunchMap.get("Project_name");
	}
	@Keyword
	public static String getselect_request() {
		return appLaunchMap.get("select_request");
	}
	@Keyword
	public static String getrequest_option() {
		return appLaunchMap.get("request_option");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow_1() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_1");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow_2() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_2");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow_3() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_3");
	}
	@Keyword
	public static String getcifa__select() {
		return appLaunchMap.get("cifa__select");
	}
	@Keyword
	public static String getCustomername() {
		return appLaunchMap.get("Customername");
	}
	@Keyword
	public static String getintiatedby_() {
		return appLaunchMap.get("intiatedby_");
	}
	@Keyword
	public static String getintiatedbyid_() {
		return appLaunchMap.get("intiatedbyid_");
	}
	@Keyword
	public static String getSite_Development_() {
		return appLaunchMap.get("Site_Development_");
	}
	@Keyword
	public static String getexternalid_() {
		return appLaunchMap.get("externalid_");
	}
	@Keyword
	public static String getcustomer_contact_email_() {
		return appLaunchMap.get("customer_contact_email_");
	}
	@Keyword
	public static String getphne_() {
		return appLaunchMap.get("phne_");
	}
	@Keyword
	public static String getcustomer_Contact_() {
		return appLaunchMap.get("customer_Contact_");
	}
	@Keyword
	public static String getEdit() {
		return appLaunchMap.get("Edit");
	}
	@Keyword
	public static String getChangeDate() {
		return appLaunchMap.get("ChangeDate");
	}
	@Keyword
	public static String getAddMaterials() {
		return appLaunchMap.get("AddMaterials");
	}
	@Keyword
	public static String getAddContractLabor() {
		return appLaunchMap.get("AddContractLabor");
	}
	@Keyword
	public static String getAddConstructedFootage() {
		return appLaunchMap.get("AddConstructedFootage");
	}
	@Keyword
	public static String getHold_Unhold() {
		return appLaunchMap.get("Hold_Unhold");
	}
	@Keyword
	public static String getClose() {
		return appLaunchMap.get("Close");
	}
	@Keyword
	public static String getSubmit_for_Approval() {
		return appLaunchMap.get("Submit_for_Approval");
	}
	@Keyword
	public static String getUnfunded() {
		return appLaunchMap.get("Unfunded");
	}
	@Keyword
	public static String getOpened() {
		return appLaunchMap.get("Opened");
	}
	@Keyword
	public static String getCreateJob() {
		return appLaunchMap.get("CreateJob");
	}
	@Keyword
	public static String getPending() {
		return appLaunchMap.get("Pending");
	}
	@Keyword
	public static String getCancel() {
		return appLaunchMap.get("Cancel");
	}
	@Keyword
	public static String getsubtype_scalable_Design() {
		return appLaunchMap.get("subtype_scalable_Design");
	}
	@Keyword
	public static String getsubtype_scalable_Fiber_Transport() {
		return appLaunchMap.get("subtype_scalable_Fiber_Transport");
	}
	@Keyword
	public static String getsubtype_scalable_Headend() {
		return appLaunchMap.get("subtype_scalable_Headend");
	}
	@Keyword
	public static String getsubtype_scalable_Permit_Traffic() {
		return appLaunchMap.get("subtype_scalable_Permit_Traffic");
	}
	@Keyword
	public static String getsubtype_scalable_Walkout() {
		return appLaunchMap.get("subtype_scalable_Walkout");
	}
	@Keyword
	public static String getoption_milestone() {
		return appLaunchMap.get("option_milestone");
	}
	@Keyword
	public static String getTasktype_Milestone() {
		return appLaunchMap.get("Tasktype_Milestone");
	}
	@Keyword
	public static String getmilestone_select() {
		return appLaunchMap.get("milestone_select");
	}
	@Keyword
	public static String getmilestonenext_button() {
		return appLaunchMap.get("milestonenext_button");
	}
	@Keyword
	public static String getinput_taskname() {
		return appLaunchMap.get("input_taskname");
	}
	@Keyword
	public static String getJobid_click() {
		return appLaunchMap.get("Jobid_click");
	}
	@Keyword
	public static String getsubtype__subtype() {
		return appLaunchMap.get("subtype__subtype");
	}
	@Keyword
	public static String getfinish_button() {
		return appLaunchMap.get("finish_button");
	}
	@Keyword
	public static String gettasks() {
		return appLaunchMap.get("tasks");
	}
	@Keyword
	public static String getchatter() {
		return appLaunchMap.get("chatter");
	}
	@Keyword
	public static String getsurveys() {
		return appLaunchMap.get("surveys");
	}
	@Keyword
	public static String getestimates() {
		return appLaunchMap.get("estimates");
	}
	@Keyword
	public static String getpayback() {
		return appLaunchMap.get("payback");
	}
	@Keyword
	public static String getaddress() {
		return appLaunchMap.get("address");
	}
	@Keyword
	public static String getpermits() {
		return appLaunchMap.get("permits");
	}
	@Keyword
	public static String getinvoic_lines() {
		return appLaunchMap.get("invoic_lines");
	}
	@Keyword
	public static String getconstructed_ft() {
		return appLaunchMap.get("constructed_ft");
	}
	@Keyword
	public static String getattachments() {
		return appLaunchMap.get("attachments");
	}
	@Keyword
	public static String gethistory() {
		return appLaunchMap.get("history");
	}
	@Keyword
	public static String getlocalcontactphone() {
		return appLaunchMap.get("localcontactphone");
	}
	@Keyword
	public static String getExternalid() {
		return appLaunchMap.get("Externalid");
	}
	@Keyword
	public static String getbetterment_nextbutton() {
		return appLaunchMap.get("betterment_nextbutton");
	}
	@Keyword
	public static String getinputaddress_value() {
		return appLaunchMap.get("inputaddress_value");
	}
	@Keyword
	public static String getintiatedby_value() {
		return appLaunchMap.get("intiatedby_value");
	}
	@Keyword
	public static String getintiatedbyid_value() {
		return appLaunchMap.get("intiatedbyid_value");
	}
	@Keyword
	public static String getcommentsField_value() {
		return appLaunchMap.get("commentsField_value");
	}
	@Keyword
	public static String getcifawarehouse_value() {
		return appLaunchMap.get("cifawarehouse_value");
	}
	@Keyword
	public static String getCustomernamevalue() {
		return appLaunchMap.get("Customernamevalue");
	}
	@Keyword
	public static String getSite_Development_value() {
		return appLaunchMap.get("Site_Development_value");
	}
	@Keyword
	public static String getcustomer_Contact_value() {
		return appLaunchMap.get("customer_Contact_value");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow_value1() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_value1");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow_value2() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_value2");
	}
	@Keyword
	public static String gettotalPrePostCalcJobFlow_value3() {
		return appLaunchMap.get("totalPrePostCalcJobFlow_value3");
	}
}
