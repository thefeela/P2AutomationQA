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

//WebUI.navigateToUrl("https://polaris2--training.lightning.force.com/lightning/r/Job__c/a0J2f000000NoDgEAK/view")
WebUI.delay(4)
def text =WebUI.getText(findTestObject('Finance/FundsStatus/Page_FundStatus Salesforce/FundAfterStatus'))
WebUI.verifyMatch(text, '^Pending.*', true, FailureHandling.STOP_ON_FAILURE) 
/*if(WebUI.verifyElementText(findTestObject('Finance/FundsStatus/Page_FundStatus Salesforce/FundAfterStatus'), 'Approved')|| WebUI.verifyElementText(findTestObject('Finance/FundsStatus/Page_FundStatus Salesforce/FundAfterStatus'), 'Pending Approval 1'))
{
	println ('success')
}*/


