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
import internal.GlobalVariable as GlobalVariable
WebUI.openBrowser('www.test.salesforce.com')

WebUI.callTestCase(findTestCase('CommonMethods/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(10)

WebUI.click(findTestObject('FullFlowLabor/ApproveEstimate/JobInput/input_Search_by_Job'))
WebUI.delay(2)
WebUI.setText(findTestObject('FullFlowLabor/ApproveEstimate/JobInput/input_Search_by_Job'), 
    GlobalVariable.SearchJobID)

WebUI.delay(5)

WebUI.click(findTestObject('FullFlowLabor/Page_Home  Salesforce/Select_RecentJob'))

WebUI.click(findTestObject('FullFlowLabor/ApproveEstimate/lightning-primitive-icon'))

WebUI.click(findTestObject('FullFlowLabor/ApproveEstimate/span_HISTORY'))

WebUI.click(findTestObject('FullFlowLabor/ApproveEstimate/button_Approve'))

WebUI.click(findTestObject('Object Repository/FullFlowLabor/ApproveEstimate/ButtonAction/button_Approve_1'))

