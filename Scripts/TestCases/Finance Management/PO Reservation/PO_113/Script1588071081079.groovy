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

WebUI.refresh()
WebUI.navigateToUrl(GlobalVariable.LoadURL)


WebUI.delay(10)

WebUI.executeJavaScript('document.body.style.zoom=\'50%\'', null)

//GlobalVariable.SearchJobID=WebUI.getText(findTestObject('Object Repository/GeneralAction/GetJobID'))
WebUI.delay(10)

WebUI.click(findTestObject('Finance/links/History_Lnk'))

WebUI.delay(2)



WebUI.click(findTestObject('Finance/FullFlowLabor/ApproveEstimate/ButtonAction/Recall'))

WebUI.click(findTestObject('Finance/FullFlowLabor/ApproveEstimate/ButtonAction/RecallFinal'))



WebUI.click(findTestObject('Finance/links/INVOICE_LINES_lnk'))
WebUI.delay(2)


WebUI.verifyElementText(findTestObject('Finance/ReservePO/RemaininQtyInline'),'10')