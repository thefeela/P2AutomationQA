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
WebUI.navigateToUrl(GlobalVariable.LoadURL)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/SubmitForApproval'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)


WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login - JO'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.LoadURL)

WebUI.delay(5)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.delay(5)

WebUI.verifyElementClickable(findTestObject('Finance/ReservationButtons/ReservePO'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Finance/ReservationButtons/UndoReservation'), 10)

WebUI.verifyElementClickable(findTestObject('Object Repository/links/CloseReservation'), 10)

WebUI.verifyElementClickable(findTestObject('Object Repository/links/Re-price'), 10)

