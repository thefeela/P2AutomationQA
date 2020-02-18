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

WebUI.click(findTestObject('GeneralAction/UserIcon'))

WebUI.click(findTestObject('GeneralAction/LogOutLnk'))

WebUI.delay(5)

WebUI.navigateToUrl('https://test.salesforce.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/FullFlowLabor/Page_Login  Salesforce/input_Username_username'), 'sushmi.ig@p2.com.qa2')

WebUI.setEncryptedText(findTestObject('Object Repository/FullFlowLabor/Page_Login  Salesforce/input_Password_pw'), '0R0v8FYzmxcuI+dqWgPyZw==')

WebUI.click(findTestObject('Object Repository/FullFlowLabor/Page_Login  Salesforce/input_Password_Login'))

WebUI.delay(5)

WebUI.navigateToUrl('https://polaris2--qa2.lightning.force.com/lightning/r/Job__c/a0JL0000004XuaaMAC/view')

WebUI.delay(2)

