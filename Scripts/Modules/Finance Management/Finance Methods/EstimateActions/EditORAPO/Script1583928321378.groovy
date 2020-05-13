import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.google.common.collect.Multimaps.Keys.KeysEntrySet
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

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/div_View profile_slds-r3'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/button_View All'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/p_ORA_POs'))

WebUI.click(findTestObject('Finance/ORAPOs/SearchOraPO'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Finance/ORAPOs/SearchOraPO'), GlobalVariable.ORAPO_Number.toString())

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Finance/ORAPOs/SearchOraPO'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/recent ORA'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/recent ORA - Edit'))

WebUI.delay(2)

//WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/PO NOinput'), '23232323')

WebUI.setText(findTestObject('Finance/ORAPO Creation/Edit PO status'), GlobalVariable.OraPOStatus.toString())

WebUI.setText(findTestObject('Finance/ORAPO Creation/Page_New ORA_PO  Salesforce/Edit ORA amount'), 
    GlobalVariable.ORAPO_OracleAmt)


WebUI.click(findTestObject('Finance/ORAPOs/EditOraSave'))