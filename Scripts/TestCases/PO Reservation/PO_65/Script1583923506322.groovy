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

WebUI.refresh()

WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionNonSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('EstimateActions/SubmitForApproval'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('ReservationButtons/ReservePO'))

WebUI.delay(2)

WebUI.click(findTestObject('ReservePO/selectALLPO'))

WebUI.delay(2)

//WebUI.click(findTestObject('Object Repository/ReservePO/InputQtyPOReserveOverlay'))
WebUI.sendKeys(findTestObject('Object Repository/ReservePO/PO_Search'), GlobalVariable.ORAPO_Number)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/SeectReservePONO'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/FinalReserveButtonwithPO'))
WebUI.refresh()
WebUI.delay(2)


WebElement table = driver.findElement(findTestObject('Object Repository/Labor headers/LaborTable'))

WebElement[] rowsInTable = ((table.findElements(By.tagName('tr'))) as WebElement[])

int rowsCount = rowsInTable.length

List<WebElement> headers = th.findElements(By.tagName('td'))

WebUI.comment("rowsCount=$rowsCount")

for (int r = 0; r < rowsCount; r++) {
	WebElement[] columnsInRow = ((rowsInTable[r].findElements(By.tagName('div'))) as WebElement[])
	int cellcnt=columnsInRow.length
	
	for (int n = 0; n < cellcnt; n++) {
	WebElement[] columnsInRow = ((columnsInRow[r].findElements(By.tagName('b'))) as WebElement[])
	if(columnsInRow.length==0){FailureHandling.CONTINUE_ON_FAILURE}
	}

}
WebElement[] EstimatenamesLABORGrid = driver.findElements(findTestObject('Object Repository/ReservePO/EstimatePONo')) as WebElement[]

WebElement[] imgInGrid = ((EstimatenamesLABORGrid.findElements(By.tagName('img'))) as WebElement[])

int columnsCount = rowsInTable.length

if(rowsInTable.length==0)
{FailureHandling.CONTINUE_ON_FAILURE}
