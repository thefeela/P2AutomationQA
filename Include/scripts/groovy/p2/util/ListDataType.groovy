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

import java.util.ArrayList;

/**
 * @author Guna
 */
import p2.Properties.HomePageXpathLocators;
public class ListDataType {
	public ArrayList<String> homePageMenuitems_JO() {
		ArrayList<String> homepageListJO=new ArrayList<String>();
		homepageListJO.add(HomePageXpathLocators.getHome());
		homepageListJO.add(HomePageXpathLocators.getChatter());
		homepageListJO.add(HomePageXpathLocators.getP2Project());
		homepageListJO.add(HomePageXpathLocators.getJob());
		homepageListJO.add(HomePageXpathLocators.getAllTasks());
		homepageListJO.add(HomePageXpathLocators.getSurveys());
		homepageListJO.add(HomePageXpathLocators.getPermit());
		homepageListJO.add(HomePageXpathLocators.getInvoices());
		homepageListJO.add(HomePageXpathLocators.getReports());
		homepageListJO.add(HomePageXpathLocators.getDashboard());
		homepageListJO.add(HomePageXpathLocators.getApproval());
		return homepageListJO;
	}
	
	// Home Page tab for BP
	public ArrayList<String> homePageMenuitems_BP() {
		ArrayList<String> homepageListBP=new ArrayList<String>();
		homepageListBP.add(HomePageXpathLocators.getHome());
		homepageListBP.add(HomePageXpathLocators.getChatter());
		homepageListBP.add(HomePageXpathLocators.getJob());
		homepageListBP.add(HomePageXpathLocators.getAllTasks());
		homepageListBP.add(HomePageXpathLocators.getSurveys());
		homepageListBP.add(HomePageXpathLocators.getPermit());
		homepageListBP.add(HomePageXpathLocators.getInvoices());
		homepageListBP.add(HomePageXpathLocators.getReports());
		homepageListBP.add(HomePageXpathLocators.getDashboard());
		return homepageListBP;
	}
	
	
	//Jobs Page for JO
	
	public ArrayList<String> jobsPageMenuitems_JO() {
		ArrayList<String> jobsPageTableJO=new ArrayList<String>();
		jobsPageTableJO.add(HomePageXpathLocators.getHome());
		jobsPageTableJO.add(HomePageXpathLocators.getChatter());
		jobsPageTableJO.add(HomePageXpathLocators.getJob());
		jobsPageTableJO.add(HomePageXpathLocators.getSurveys());
		jobsPageTableJO.add(HomePageXpathLocators.getPermit());
		jobsPageTableJO.add(HomePageXpathLocators.getInvoices());
		jobsPageTableJO.add(HomePageXpathLocators.getReports());
		jobsPageTableJO.add(HomePageXpathLocators.getDashboard());
		return jobsPageTableJO;
	}
	
}
