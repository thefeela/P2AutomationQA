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

//WebUI.callTestCase(findTestCase('Modules/JobManagement/Job Methods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('Modules/LoginMethos/LogOff'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)
WebUI.callTestCase(findTestCase('Modules/JobManagement/Job Methods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)
GlobalVariable.LoadURL=WebUI.getUrl()
WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login - BP'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)
String StrUrl = "https://polaris2--regression.lightning.force.com/lightning/r/Job__c/a0JM0000008yjDIMAY/view"//GlobalVariable.LoadURL
//WebUI.refresh()
WebUI.delay(2)
//WebUI.callTestCase(findTestCase('Modules/JobManagement/Job Methods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl(StrUrl)
//println(StrUrl) 
WebUI.delay(5)
WebUI.refresh()
WebUI.delay(5)
WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.verifyElementNotPresent(findTestObject('Finance/ReservationButtons/ReservePO'), 10)

WebUI.verifyElementNotPresent(findTestObject('Finance/ReservationButtons/UndoReservation'), 10)

WebUI.verifyElementNotPresent(findTestObject('Finance/ReservationButtons/CloseReservation'), 10)

