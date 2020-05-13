import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Home  Salesforce/span_Reports'))

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Reports  Salesforce/div_New Report'))

WebUI.setText(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/input_Search Report Types_modal-search-input'),
	'ora_')

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/a_ORA_POs'))

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/button_Continue'))

WebUI.setText(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/input_Add column_xtrnJ8u23'),
	'po stat')

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/span_PO Status'))

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/button_Run'))

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> rowsInTable = driver.findElements(By.xpath("//table[contains(@class,'slds-table slds-table_fixed-layout slds-table_bordered slds-table_header-fixed')]/thead/tr  |   //div[contains(@class,\'slds-scrollable_y')]/table/thead/tr"))
int rowsCount = rowsInTable.size()

WebElement table = driver.findElement(findTestObject('Finance/Labor headers/LaborTable'))
//WebElement table = driver.findElement(findTestObject('Finance/Reports/PO Reports/ORAPO_Table'))

WebElement[] rowsInTable = ((table.findElements(By.tagName('tr'))) as WebElement[])

int rowsCount = rowsInTable.length

/*List<WebElement> headers = rowsInTable.findElements(By.tagName('td'))

WebUI.comment("rowsCount=$rowsCount")

for (int r = 0; r < rowsCount; r++) {
	WebElement[] columnsInRow = ((rowsInTable[r].findElements(By.tagName('div'))) as WebElement[])

	 int columnsCount = columnsInRow.length

	//	WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
	for (int c = 0; c < columnsCount; c++) {
		if (c == 3) {
			String cellText = columnsInRow[c].findElements(By.tagName('div')).getText().trim()

			if ((cellText != 'Pending') || (cellText != 'Partially Reserved') || (cellText !='Canceled') || (cellText != 'Canceled W/ Reservations')
				|| (cellText != 'Closed' 				 ){
				FailureHandling.CONTINUE_ON_FAILURE
			}
		}
	}
}



*/