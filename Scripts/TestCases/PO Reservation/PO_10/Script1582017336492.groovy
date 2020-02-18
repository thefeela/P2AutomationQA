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
import com.kms.katalon.core.logging.KeywordLogger

keyworLogger log = keywrodLogger()
WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AddEstimate/AddNonConstructionNonSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('links/Esimate_Lnk'))

WebUI.click(findTestObject('links/Labor_Lnk'))


WebElement table = driver.findElement(findTestObject('Object Repository/Labor headers/LaborTable'))
WebElement[] rowsInTable = table.findElements(By.tagName('th')) as WebElement[]
int rowsCount = rowsInTable.length
List<WebElement> headers = th.findElements(By.tagName('tr'))
WebUI.comment("rowsCount=${rowsCount}")
for (int r = 0; r < rowsCount; r++) {
	WebElement[] columnsInRow = rowsInTable[r].findElements(By.tagName('div')) as WebElement[]
	int columnsCount = columnsInRow.length
	for (int c = 0; c < columnsCount; c++) {
		if(c==3)
		{
		
		String cellText = columnsInRow[c].getText().trim()
		if(cellText!="Pending" || cellText!="Partially Reserved")
			{
					FailureHandling.CONTINUE_ON_FAILURE
	
			}
		
		}
	}
}

