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

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_Home  Salesforce/span_RequestsJobs'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_Recently Viewed  RequestsJobs  Salesforce/div_New'))

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/button_Next'))

WebUI.delay(10)

WebUI.click(findTestObject('Object Repository/CreateJB/Page_New RequestJob  Salesforce/Category-Scalable'))

WebUI.delay(4)

WebUI.selectOptionByValue(findTestObject('Object Repository/CreateJB/Page_New RequestJob  Salesforce/Type-XNET'), 
    'XNET Fiber Deep', true)

WebUI.delay(4)

WebUI.selectOptionByValue(findTestObject('Object Repository/CreateJB/Page_New RequestJob  Salesforce/SubType-XNET'), 
    'XNET Fiber Deep', true)

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/button_Next_1'))

WebUI.delay(2)

WebUI.click(findTestObject('FullFlowLabor/Page_New RequestJob  Salesforce/input_icon_1023904a'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/input_icon_1023904a'), '19050')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/span_19050'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('FullFlowLabor/Page_New RequestJob  Salesforce/input_icon_1723904a'), 1)

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/input_icon_1723904a'))

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/span_FD_JOB_Nov2019'))

WebUI.scrollToElement(findTestObject('FullFlowLabor/Page_New RequestJob  Salesforce/button_Save'), 1)

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_New RequestJob  Salesforce/button_Save'))

WebUI.delay(3)

WebUI.click(findTestObject('FullFlowLabor/Page_New RequestJob  Salesforce/button_Next_1'))
