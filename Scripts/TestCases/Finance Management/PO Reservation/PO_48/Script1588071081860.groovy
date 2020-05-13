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


WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login - JO'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/JobManagement/Job Methods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)
WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.click(findTestObject('Finance/ReservationButtons/ReservePO'))

WebUI.delay(2)

WebUI.click(findTestObject('Finance/ReservePO/selectALLPO'))

WebUI.delay(2)

//WebUI.click(findTestObject('Finance/ReservePO/InputQtyPOReserveOverlay'))
WebUI.sendKeys(findTestObject('Finance/ReservePO/PO_Search'), '24')

WebUI.delay(2)

WebUI.click(findTestObject('Finance/ReservePO/SeectReservePONO'))

WebUI.delay(2)

WebUI.click(findTestObject('Finance/ReservePO/FinalReserveButtonwithPO'))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Finance/ErrorMsgLabor/90percent reservation warning'), 10)

WebUI.delay(2)

