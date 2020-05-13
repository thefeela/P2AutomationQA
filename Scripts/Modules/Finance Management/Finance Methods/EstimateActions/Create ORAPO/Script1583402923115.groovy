import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/div_View profile_slds-r3'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/button_View All'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/p_ORA_POs'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Recently Viewed  ORA_POs  Salesforce/div_New'))

WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/PO NOinput'),GlobalVariable.ORAPO_Number)

WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Status'), GlobalVariable.OraPOStatus.toString())
WebUI.doubleClick(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Oracle PO Total Amount_832774a'))
WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Oracle PO Total Amount_832774a'), 
 GlobalVariable.ORAPO_OracleAmt)
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_NORTHEAST DIVISION'))
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Select ORA Division'))
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/a_REGION'))
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Select ORA Region'))

//WebUI.scrollToPosition(100,100)
//WebUI.delay(3)
WebUI.scrollToElement(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Scroll_1'), 10)
WebUI.scrollToElement(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Scroll1'), 10)
WebUI.delay(4)
GlobalVariable.PreviousORAPO=GlobalVariable.ORAPO_Number
GlobalVariable.ORAPO_Number= GlobalVariable.ORAPO_Number+ 1

WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Oracle Project Name'), 
    GlobalVariable.ORAPO_Number.toString())
WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Oracle PO Number'),
	 GlobalVariable.ORAPO_Number.toString())
WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Oracle Project Number'), 
    GlobalVariable.ORAPO_Number.toString())
WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Business Partner Name'), 
    'COMMUNICATIONS CONSTRUCTION GROUP LLC')
WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Business Partner Number'),
	GlobalVariable.ORAPO_Number.toString())
WebUI.sendKeys(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Business Partner'),
	'COMMUNICATIONS CONSTRUCTION GROUP LLC')
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/SelectBP'))
WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/span_Save'))
WebUI.closeBrowser()

