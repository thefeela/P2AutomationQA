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

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

/*WebUI.click(findTestObject('Object Repository/GeneralAction/API Search'))
WebUI.sendKeys(findTestObject('Object Repository/GeneralAction/API Search'),'ora_pos')*/

WebUI.navigateToUrl('https://polaris2--'+GlobalVariable.Environment +'.lightning.force.com/lightning/o/ORA_PO__c/list?filterName=Recent')

/*WebUI.click(findTestObject('Finance/ORAPOs/Page_Lightning Experience  Salesforce/div_View profile_slds-r5'))

WebUI.click(findTestObject('Finance/ORAPOs/Page_JB0000267194  Salesforce/p_ORA_POs'))*/
WebUI.delay(2)
WebUI.click(findTestObject('Finance/ORAPOs/Page_Recently Viewed  ORA_POs  Salesforce/a_2409818'))

//WebUI.click(findTestObject('Finance/ORAPOs/Page_2409818  Salesforce/a_PO Reservations'))

WebUI.click(findTestObject('Finance/ORAPOs/EditPOStatus'))
WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Finance/ORAPOs/ScrollORa'),10)
//WebUI.executeJavaScript('document.body.style.zoom=\'80%\'', null)

WebUI.verifyElementVisible(findTestObject('Finance/ORAPOs/EditPOStatusInput'))