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

//WebUI.openBrowser('www.test.salesforce.com')
GlobalVariable.LoadURL = WebUI.getUrl()

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.navigateToUrl(GlobalVariable.LoadURL)

WebUI.delay(10)

WebUI.executeJavaScript('document.body.style.zoom=\'50%\'', null)

//GlobalVariable.SearchJobID=WebUI.getText(findTestObject('Object Repository/GeneralAction/GetJobID'))
WebUI.delay(10)

WebUI.click(findTestObject('Finance/links/History_Lnk'))

//WebUI.click(findTestObject('Finance/FullFlowLabor/ApproveEstimate/JobInput/input_Search_by_Job'))
//WebUI.delay(2)
//WebUI.setText(findTestObject('Finance/FullFlowLabor/ApproveEstimate/JobInput/input_Search_by_Job'), 
//   GlobalVariable.SearchJobID)
//WebUI.delay(2)
//WebUI.click(findTestObject('FullFlowLabor/Page_Home  Salesforce/Select_RecentJob'))
//WebUI.click(findTestObject('Finance/FullFlowLabor/ApproveEstimate/ButtonAction/button_MoreTabs'))
//WebUI.waitForElementPresent(findTestObject('FullFlowLabor/ApproveEstimate/span_HISTORY'), 0, FailureHandling.STOP_ON_FAILURE)
//WebUI.click(findTestObject('FullFlowLabor/ApproveEstimate/span_HISTORY'))
//WebUI.click(findTestObject('Finance/FullFlowLabor/ApproveEstimate/ButtonAction/span_HISTORY'))
if (WebUI.verifyElementNotPresent(findTestObject('Finance/FullFlowLabor/ApproveEstimate/ButtonAction/button_Approve_1'), 
    10)) {
    WebUI.refresh()

    WebUI.delay(5)
}

WebUI.click(findTestObject('Finance/FullFlowLabor/ApproveEstimate/ButtonAction/button_Approve_1'))

WebUI.delay(5)
WebUI.executeJavaScript('document.body.style.zoom=\'100%\'', null)

//GlobalVariable.SearchJobID=WebUI.getText(findTestObject('Object Repository/GeneralAction/GetJobID'))
WebUI.delay(5)

WebUI.focus(findTestObject('Test Cases/EstimateActions/RejectEstimate'))

//WebUI.executeJavaScript('document.body.style.zoom=\'100%\'', null)

//GlobalVariable.SearchJobID=WebUI.getText(findTestObject('Object Repository/GeneralAction/GetJobID'))
WebUI.delay(10)

WebUI.click(findTestObject('Test Cases/EstimateActions/RejectEstimate_1'))

WebUI.delay(20)

