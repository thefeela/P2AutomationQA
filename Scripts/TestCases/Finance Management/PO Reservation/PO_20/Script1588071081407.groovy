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

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/SubmitForApproval'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.verifyElementNotClickable(findTestObject('Finance/EditLaborQty/EditQty'), FailureHandling.STOP_ON_FAILURE)


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
float totalEstimate=0
	//	WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
	for (int c = 0; c < columnsCount; c++) {
		String UpdatedQty="0"
		if(c==8)
		{totalEstimate+= float.parseFloat(columnsInRow[c].getText().trim().replace('','0'))
			if(columnsInRow[c].getText().trim().indexOf(".")<=0)
			{
				FailureHandling.STOP_ON_FAILURE
			}
		}
	
		}
	GlobalVariable.TotalEstimate_Header=totalEstimate
		
		
	
}