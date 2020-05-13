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

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.Click(findTestObject('Finance/ReservationButtons/CloseReservation'))





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

WebUI.verifyElementPresent(findTestObject('Finance/Labor headers/Estimates'), 10)

WebUI.verifyElementPresent(findTestObject('Finance/Labor headers/Description'), 10)
WebElement table = driver.findElement(findTestObject('Finance/Labor headers/LaborTable'))
WebElement[] rowsInTable = table.findElements(By.tagName('th')) as WebElement[]
// To calculate number of rows in the table
int rowsCount = rowsInTable.length
List<WebElement> headers = th.findElements(By.tagName('th'))
WebUI.comment("rowsCount=${rowsCount}")
// Iterate over all the rows of the table
for (int r = 0; r < rowsCount; r++) {
	// To locate columns(cells) of that specific row
	WebElement[] columnsInRow = rowsInTable[r].findElements(By.tagName('span')) as WebElement[]
	int columnsCount = columnsInRow.length
	WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
	for (int c = 0; c < columnsCount; c++) {
		int contentLength=GlobalVariable.LaborTableHeader.size()
		string status="n"
		for(int d=0;c<contentLength;d++)
		{
		String cellText = columnsInRow[c].getText()
		if(cellText==GlobalVariable.LaborTableHeader[d].toString())
				{
					status="y"
				}
		}
		if(status!="y")
		{
			WebUI.comment("Missing the header value '${cellText}'")
			FailureHandling.CONTINUE_ON_FAILURE
		}
		status="n"
	}
}