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
import com.kms.katalon.core.logging.KeywordLogger
KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://test.salesforce.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Finance/FullFlowLabor/Page_Login  Salesforce/input_Username_username'), 'thefeela.jo@p2.com.regression')

WebUI.setEncryptedText(findTestObject('Finance/FullFlowLabor/Page_Login  Salesforce/input_Password_pw'), '0R0v8FYzmxcuI+dqWgPyZw==')

WebUI.click(findTestObject('Finance/FullFlowLabor/Page_Login  Salesforce/input_Password_Login'))

WebUI.delay(5)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/GeneralAction/Login_FinishButton'), 10)) {
    WebUI.click(findTestObject('Object Repository/GeneralAction/Login_FinishButton'))
}

//WebUI.navigateToUrl('https://polaris2--qa2.lightning.force.com/lightning/r/Job__c/a0JL0000004XuaaMAC/view')
//WebUI.navigateToUrl('https://polaris2--regression.lightning.force.com/lightning/r/Job__c/a0JM00000095BxWMAU/view')
WebUI.delay(2)
logger.logInfo("Jo login success")
