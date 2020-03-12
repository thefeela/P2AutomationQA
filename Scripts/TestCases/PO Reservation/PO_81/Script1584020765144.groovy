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

WebUI.click(findTestObject('Object Repository/ORAPO Creation/Page_Home  Salesforce/div_View profile_slds-r3'))

WebUI.callTestCase(findTestCase('CommonMethods/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/ORAPO Creation/Page_Home  Salesforce/button_View All'))

WebUI.click(findTestObject('Object Repository/ORAPO Creation/Page_Home  Salesforce/p_ORA_POs'))



WebElement[] ORAPOGrid = driver.findElements(findTestObject('Object Repository/ORAPOs/OraPONoLine in ORAList')) as WebElement[]
int rowsCount=ORAPOGrid.length

for (int r = 0; r < rowsCount; r++) {

if(	WebUI.verifyElementAttributeValue(ORAPOGrid[r],'title',GlobalVariable.ORAPO_Number,10) == true)
{
	WebUI.click(ORAPOGrid[r])
	}
	}

WebUI.delay(2)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/ORAPO Creation/Page_New ORA_PO  Salesforce/input_Oracle PO Total Amount_832774a'),'title',GlobalVariable.ORAPO_OracleAmt,10)


