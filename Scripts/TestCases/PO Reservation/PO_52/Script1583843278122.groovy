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

WebUI.callTestCase(findTestCase('CommonMethods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('links/Esimate_Lnk'))

WebUI.click(findTestObject('links/Labor_Lnk'))

WebUI.click(findTestObject('ReservationButtons/ReservePO'))

WebUI.delay(2)

WebUI.click(findTestObject('ReservePO/selectALLPO'))

WebUI.delay(2)

//WebUI.click(findTestObject('Object Repository/ReservePO/InputQtyPOReserveOverlay'))
WebUI.sendKeys(findTestObject('Object Repository/ReservePO/PO_Search'), '24')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/SeectReservePONO'))

WebUI.delay(2)

WebUI.verifyElementNotClickable(findTestObject('Object Repository/EditLaborQty/EditQty'), FailureHandling.STOP_ON_FAILURE)


WebElement[] contentsPOFund = driver.findElements(findTestObject('Object Repository/PO to Reserve Funding/PO to Reserve Funding')) as WebElement[]


int rowsCount = contentsPOFund.length


WebUI.comment("rowsCount=$rowsCount")

//for (int r = 0; r < rowsCount; r++) {
		String ContentString=""
			ContentString= contentsPOFund[2].getText().trim()
			if(ContentString.length()<1){FailureHandling.CONTINUE_ON_FAILURE}
			
			
	//	}








