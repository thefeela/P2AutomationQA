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

WebUI.click(findTestObject('Object Repository/ORAPOs/Page_Lightning Experience  Salesforce/div_View profile_slds-r5'))

WebUI.click(findTestObject('Object Repository/ORAPOs/Page_JB0000267194  Salesforce/p_ORA_POs'))

WebUI.click(findTestObject('Object Repository/ORAPOs/Page_Recently Viewed  ORA_POs  Salesforce/a_2409818'))

WebUI.click(findTestObject('Object Repository/ORAPOs/Page_2409818  Salesforce/a_PO Reservations'))

WebUI.click(findTestObject('ORAPOs/EditPOStatus'))

WebUI.delay(2)

WebUI.verifyElementVisible(findTestObject('Object Repository/ORAPOs/EditPOStatusInput'), 10)

WebUI.sendkeys(findTestObject('Object Repository/ORAPOs/EditPOStatusInput'), 'Canceled W/ Reservations Canceled')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ORAPOs/SaveORA_PO'))

WebUI.callTestCase(findTestCase('CommonMethods/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CommonMethods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ReservationButtons/ReservePO'))

WebUI.delay(2)

WebUI.click(findTestObject('ReservePO/selectALLPO'))

WebUI.delay(2)

//WebUI.click(findTestObject('Object Repository/ReservePO/InputQtyPOReserveOverlay'))
WebUI.sendKeys(findTestObject('Object Repository/ReservePO/PO_Search'), '24')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/SeectReservePONO'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/ReservePO/FinalReserveButtonwithPO'))
WebUI.delay(2)
WebUI.verifyElementVisible(findTestObject('Object Repository/ErrorMsgLabor/Page_JB0000151607  Salesforce/div_ErrorBusiness Partner and Labor Code are required fields'))