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

WebUI.navigateToUrl('https://polaris2--qa2.lightning.force.com/lightning/r/Job__c/a0JL0000004XwY0MAK/view')

WebUI.delay(5)

WebUI.click(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/div_Add Contract Labor'))

WebUI.delay(1)

WebUI.click(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/InputBP_Labor'))

WebUI.sendKeys(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/InputBP_Labor'), 'ccg')

WebUI.delay(1)

WebUI.click(findTestObject('FullFlowLabor/RadioBPSelect'))

WebUI.delay(2)

WebUI.click(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/InputLaborCode'))

WebUI.sendKeys(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/InputLaborCode'), 'a1')

WebUI.delay(1)

WebUI.click(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/Radio_LaborSelect'))

WebUI.delay(1)

WebUI.click(findTestObject('FullFlowLabor/InputQuantity'))

WebUI.sendKeys(findTestObject('FullFlowLabor/InputQuantity'), '10')
//WebUI.focus('FullFlowLabor/Page_AddLabor Salesforce/button_Save')
WebUI.delay(2)
WebUI.click(findTestObject('FullFlowLabor/Page_AddLabor Salesforce/button_Save'))

WebUI.delay(2)

