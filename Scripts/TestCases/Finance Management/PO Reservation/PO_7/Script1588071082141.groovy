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

//WebUI.navigateToUrl('https://polaris2--regression.lightning.force.com/lightning/r/Job__c/a0JM00000095BxWMAU/view')
WebUI.delay(5)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.delay(2)

WebUI.verifyElementClickable(findTestObject('Finance/ReservationButtons/ReservePO'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Finance/ReservationButtons/UndoReservation'), 10)

WebUI.verifyElementNotPresent(findTestObject('Finance/ReservationButtons/CloseReservation'), 10)

WebUI.delay(2)

GlobalVariable.CommonJobID = WebUI.getText(findTestObject('Object Repository/GeneralAction/GetJobID'))

GlobalVariable.LoadURL = WebUI.getUrl()

