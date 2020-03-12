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

WebUI.callTestCase(findTestCase('CommonMethods/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)
GlobalVariable.ORAPO_Number=GlobalVariable.ORAPO_Number+1
GlobalVariable.ORAPO_OracleAmt=0
WebUI.callTestCase(findTestCase('EstimateActions/Create ORAPO'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CommonMethods/LogOff'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CommonMethods/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CommonMethods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)
GlobalVariable.LaborQty=10
WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('EstimateActions/SubmitForApproval'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ReservationButtons/ReservePO'))

WebUI.delay(2)

WebUI.click(findTestObject('ReservePO/selectALLPO'))

WebUI.delay(2)

//WebUI.click(findTestObject('Object Repository/ReservePO/InputQtyPOReserveOverlay'))
WebUI.sendKeys(findTestObject('Object Repository/ReservePO/PO_Search'), GlobalVariable.ORAPO_Number)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/SeectReservePONO'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/FinalReserveButtonwithPO'))
WebUI.verifyElementVisible(findTestObject('Object Repository/ErrorMsgLabor/NoFundWarningMsg'))