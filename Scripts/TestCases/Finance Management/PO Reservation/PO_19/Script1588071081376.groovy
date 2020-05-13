import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.util
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

WebUI.click(findTestObject('Finance/EditLaborQty/UpdateEstimateQty'))
WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> rowsInTable = driver.findElements(By.xpath("//table[contains(@class,'slds-table slds-table_fixed-layout slds-table_bordered slds-table_header-fixed')]/thead/tr  |   //div[contains(@class,\'slds-scrollable_y')]/table/thead/tr"))
int rowsCount = rowsInTable.size()

WebUI.comment("rowsCount=$rowsCount")
//WebElement[] rowsInTable = ((table.findElements(By.tagName('th'))) as WebElement[])

//int rowsCount = rowsInTable.length

//List<WebElement> headers = th.findElements(By.tagName('tr'))

WebUI.comment("rowsCount=$rowsCount")

for (int r = 0; r < rowsCount; r++) {
	WebElement[] columnsInRow = ((rowsInTable[r].findElements(By.tagName('div'))) as WebElement[])

	 int columnsCount = columnsInRow.length

	//	WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
	for (int c = 0; c < columnsCount; c++) {
		String UpdatedQty="0"
		if(c==5)
		{
			UpdatedQty= columnsInRow[c].getText().trim()
		}
		if (c == 6) {
			String cellText = columnsInRow[c].getText().trim()
	int QtyVal= int.parseInt(GlobalVariable.ReservedQty.toString()) -	int.parseInt(cellText)	

			if((int.parseInt(updatedQty)-QtyVal)!=0)
{
	FailureHandling.STOP_ON_FAILURE
	
	}
		}
		
		
	}
}



