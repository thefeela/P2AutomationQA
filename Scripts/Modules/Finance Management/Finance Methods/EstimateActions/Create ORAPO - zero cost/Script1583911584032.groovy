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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://test.salesforce.com/')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_Login  Salesforce/input_Username_username'), 'offshoreadmin@p2.com.qa1')

WebUI.setEncryptedText(findTestObject('Finance/ORAPO Creation/Page_Login  Salesforce/input_Password_pw'), 'AHzSUGJgRo2WraS2IheaOA==')

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Login  Salesforce/input_Password_Login'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/div_View profile_slds-r3'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/button_View All'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/p_ORA_POs'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Recently Viewed  ORA_POs  Salesforce/div_New'))

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/PO NOinput'), '23232323')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Status'), 'Open')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Oracle PO Total Amount_832774a'), 
    '0')

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_--None--'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_NORTHEAST DIVISION'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Amount Billed_1512774a'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_--None--'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_FREEDOM'))

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_PO Status_3892774a'), 'Open')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Oracle Project Name'), 
    'Oracle Project Test')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Oracle PO Number'), '232323')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Oracle Project Number'), 
    '232323')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Business Partner Name_5152774a'), 
    'BP CCG')

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Oracle Business Partner Number_5312774a'))

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Oracle Business Partner Number_5312774a'), 
    '2323')

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Business Partner_5612774a'))

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Business Partner_5612774a'), 
    'ccg')

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/span_ccg in Business Partners'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/td_COMMUNICATIONS CONSTRUCTION GROUP LLC'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_COMMUNICATIONS CONSTRUCTION GROUP LLC'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/span_Save'))

WebUI.closeBrowser()

