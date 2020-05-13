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

WebUI.callTestCase(findTestCase('Modules/JobManagement/Job Methods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/AddEstimate/AddConstructionLabor - quoted'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/ApproveJustification'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login - JO'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
WebUI.navigateToUrl(GlobalVariable.LoadURL)
WebUI.delay(5)
WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/SubmitForApproval'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(5)
//WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.verifyElementClickable(findTestObject('Finance/EditLaborQty/EditQty'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Finance/EditLaborQty/EditQty'), FailureHandling.STOP_ON_FAILURE)

if(WebUI.getText(findTestObject('Finance/EditLaborQty/QuantityEdit'), FailureHandling.STOP_ON_FAILURE).length()==0)
{
	FailureHandling.STOP_ON_FAILURE
}