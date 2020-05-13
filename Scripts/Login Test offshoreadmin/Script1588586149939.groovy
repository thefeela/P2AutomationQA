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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://test.salesforce.com/')

WebUI.click(findTestObject('Object Repository/Login Test/Page_Login  Salesforce/div_0 Saved UsernamesEdit ListSaveCancel   _951e1a'))

WebUI.setText(findTestObject('Object Repository/Login Test/Page_Login  Salesforce/input_Username_username'), 'offshoreadmin@p2.com.regression')

WebUI.setEncryptedText(findTestObject('Object Repository/Login Test/Page_Login  Salesforce/input_Password_pw'), 'AHzSUGJgRo0vGsyF0UWnJA==')

WebUI.click(findTestObject('Object Repository/Login Test/Page_Login  Salesforce/input_Password_Login'))

WebUI.click(findTestObject('Object Repository/Login Test/Page_Home  Salesforce/div_All_listbox-selections-unique-id'))

