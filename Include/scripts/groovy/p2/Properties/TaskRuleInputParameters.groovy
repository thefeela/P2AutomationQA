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

public class TaskRuleInputParameters {
	private static Logger logger = LogManager.getLogger(TaskRuleInputParameters.class.getCanonicalName());
	
		// static Map<String, String> userHomeMap = new HashMap<String, String>();
		public static Map<String, String> getLoginMap() {
			return loginMap;
		}
	
		static Map<String, String> loginMap = new HashMap<String, String>();
	
		public boolean loadConfig() {
			boolean configLoaded = false;
			Properties prop = new Properties();
			try {
				FileInputStream fip = new FileInputStream("./Resource//taskRule.Properties");
				prop.load(fip);
			//	loginMap.putAll(prop.entrySet().stream()
				//		.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));
				loginMap.putAll(prop.entrySet().stream().collect());
				configLoaded = true;
			} catch (FileNotFoundException e1) {
				logger.error("error loading file " + e1.getMessage());
			} catch (IOException e1) {
				logger.error("error loading file IOException " + e1.getMessage());
			}
			return configLoaded;
		}
	
		public static String getAssign_task() {
			return loginMap.get("Assign_task");
		}
	
		public static String getReassign_task() {
			return loginMap.get("Reassign_task");
		}
	
		public static String getNotRequired_task() {
			return loginMap.get("NotRequired_task");
		}
	
		public static String getChangeDate_task() {
			return loginMap.get("ChangeDate_task");
		}
	
		public static String getProvideInfo_task() {
			return loginMap.get("ProvideInfo_task");
		}
	
		public static String getRework_task() {
			return loginMap.get("Rework_task");
		}
	
		public static String getApprove_task() {
			return loginMap.get("Approve_task");
		}
	
		public static String getTaskpageclose() {
			return loginMap.get("taskpageclose");
		}
	
		public static String getAssign_bussinesspatner() {
			return loginMap.get("Assign_bussinesspatner");
		}
	
		public static String getAssign_input() {
			return loginMap.get("Assign_input");
		}
	
		public static String getAssign_save() {
			return loginMap.get("Assign_save");
		}
	
		public static String getAssign_cancel() {
			return loginMap.get("Assign_cancel");
		}
	
		public static String gettask_TextArea() {
			return loginMap.get("task_TextArea");
		}
	
		public static String gettask_expt_date() {
			return loginMap.get("task_expt_date");
		}
	
		public static String getp2task_table() {
			return loginMap.get("p2task_table");
		}
	
		public static String getP2task_checkbox() {
			return loginMap.get("p2task_checkbox");
		}
	
		public static String getP2_bussinesspatner() {
			return loginMap.get("p2_bussinesspatner");
		}
	
		public static String getP2_bussinessxpath() {
			return loginMap.get("p2_bussinessxpath");
		}
	
		public static String getP2task_datepicker() {
			return loginMap.get("p2task_datepicker");
		}
	
		public static String getp2task_date() {
			return loginMap.get("p2task_date");
		}
	
		public static String getReason_code() {
			return loginMap.get("reason_code");
		}
	
		public static String gettextarea_p2task() {
			return loginMap.get("textarea_p2task");
		}
	
		public static String getsave_reassign() {
			return loginMap.get("save_reassign");
		}
	
		public static String getNeedinfo_bptask() {
			return loginMap.get("Needinfo_bptask");
		}
	
		public static String getaccept_bptask() {
			return loginMap.get("accept_bptask");
		}
	
		public static String getcomplete_bptask() {
			return loginMap.get("complete_bptask");
		}
		public static String getNeedinfo_reason() {
			return loginMap.get("Needinfo_reason");
		}
		public static String getrework_reason() {
			return loginMap.get("rework_reason");
		}
		public static String getjo_notrequired_save() {
			return loginMap.get("jo_notrequired_save");
		}
		public static String getbp_accept_save() {
			return loginMap.get("bp_accept_save");
		}
		public static String gettask_validation_msg() {
			return loginMap.get("task_validation_msg");
		}
		public static String getrework_jo() {
			return loginMap.get("rework_jo");
		}
		public static String getDetails_Tasktype() {
			return loginMap.get("details_Tasktype");
		}
		public static String getInputtype_text() {
			return loginMap.get("inputtype_text");
		}
		public static String getCancel_button() {
			return loginMap.get("cancel_button");
		}
		public static String getInputtype_bussinesspatner() {
			return loginMap.get("inputtype_bussinesspatner");
		}
		public static String getDateChange_code() {
			return loginMap.get("dateChange_code");
		}
		public static String getaccept_Task() {
			return loginMap.get("accept_Task");
		}
		public static String getbp_Jobid() {
			return loginMap.get("bp_Jobid");
		}
		public static String getbpalltask_id() {
			return loginMap.get("bpalltask_id");
		}
		public static String getneed_task() {
			return loginMap.get("need_task");
		}
		public static String getcomplete_task() {
			return loginMap.get("complete_task");
		}
		public static String getselect_needinfo() {
			return loginMap.get("select_needinfo");
		}
		public static String gettextarea_needinfo() {
			return loginMap.get("textarea_needinfo");
		}
		public static String getneedinfo_reasoncode() {
			return loginMap.get("needinfo_reasoncode");
		}
		public static String getneedinfo_save() {
			return loginMap.get("needinfo_save");
		}
		public static String getp2task_list() {
			return loginMap.get("p2task_list");
		}
		public static String getaccepttask_link() {
			return loginMap.get("accepttask_link");
		}
		public static String getcomplete_task_save() {
			return loginMap.get("complete_task_save");
		}
		public static String getcompleteTask_link() {
			return loginMap.get("completeTask_link");
		}
		public static String getapprove_task_save() {
			return loginMap.get("approve_task_save");
		}
		public static String getHeadEndDesign_taskname() {
			return loginMap.get("HeadEndDesign_taskname");
		}
		public static String getcoax_taskname() {
			return loginMap.get("coax_taskname");
		}
		public static String getassigned_select() {
			return loginMap.get("assigned_select");
		}
		public static String getassigned_bp() {
			return loginMap.get("assigned_bp");
		}
		
		public static String getfieldqc_taskname() {
			return loginMap.get("fieldqc_taskname");
		}
		public static String getUnassigned() {
			return loginMap.get("Unassigned");
		}
		public static String getInfo_Requested() {
			return loginMap.get("Info_Requested");
		}
		public static String getApproved() {
			return loginMap.get("Approved");
		}
		public static String getDate_Changed() {
			return loginMap.get("Date_Changed");
		}
		public static String getReassigned() {
			return loginMap.get("Reassigned");
		}
		public static String getInfo_Provided() {
			return loginMap.get("Info_Provided");
		}
		public static String getAssigned() {
			return loginMap.get("Assigned");
		}
		public static String getAccepted() {
			return loginMap.get("Accepted");
		}
		public static String getCompleted() {
			return loginMap.get("Completed");
		}
		
		public static String getWalkout() {
			return loginMap.get("Walkout");
		}
		public static String getDesktop() {
			return loginMap.get("Desktop");
		}
		public static String getSearch_p2task() {
			return loginMap.get("search_p2task");
		}
		public static String getNodeSpoting_task() {
			return loginMap.get("NodeSpoting_task");
		}
		public static String getUpdateasBuilt_task() {
			return loginMap.get("UpdateasBuilt_task");
		}
		public static String getUpdatemapinspatial_task() {
			return loginMap.get("Updatemapinspatial_task");
		}
		public static String getInvoicereconcilation_task() {
			return loginMap.get("invoicereconcilation_task");
		}
		public static String getcoax_design_task() {
			return loginMap.get("coax_design_task");
		}
		public static String getwalkout_task() {
			return loginMap.get("walkout_task");
		}
		public static String getDesktop_task() {
			return loginMap.get("Desktop_task");
		}
		public static String getopticaldesign_task() {
			return loginMap.get("opticaldesign_task");
		}
		public static String getFilter_task() {
			return loginMap.get("filter_task");
		}
		public static String getaddressList_task() {
			return loginMap.get("addressList_task");
		}
		public static String getnodespotting() {
			return loginMap.get("nodespotting");
		}
		public static String getfieldqc_provideInfo() {
			return loginMap.get("fieldqc_provideInfo");
		}
		public static String getfiberRouting_task() {
			return loginMap.get("fiberRouting_task");
		}
		public static String getinputtype_datetext() {
			return loginMap.get("inputtype_datetext");
		}
		
}
