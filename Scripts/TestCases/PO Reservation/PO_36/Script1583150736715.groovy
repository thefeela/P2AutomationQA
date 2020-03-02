import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Reports/PO Reports/Page_Home  Salesforce/span_Reports'))

WebUI.click(findTestObject('Reports/PO Reports/Page_Reports  Salesforce/div_New Report'))

WebUI.setText(findTestObject('Reports/PO Reports/Page_Report Builder  Salesforce/input_Search Report Types_modal-search-input'), 
    'ora_')

WebUI.click(findTestObject('Reports/PO Reports/Page_Report Builder  Salesforce/a_ORA_POs'))

WebUI.click(findTestObject('Reports/PO Reports/Page_Report Builder  Salesforce/button_Continue'))

WebUI.setText(findTestObject('Reports/PO Reports/Page_Report Builder  Salesforce/input_Add column_xtrnJ8u23'), 
    'po stat')

WebUI.click(findTestObject('Reports/PO Reports/Page_Report Builder  Salesforce/span_PO Status'))

WebUI.click(findTestObject('Reports/PO Reports/Page_Report Builder  Salesforce/button_Run'))

