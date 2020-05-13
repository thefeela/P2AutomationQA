import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

//WebUI.refresh()

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login - JO'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.delay(5)
WebUI.navigateToUrl(GlobalVariable.LoadURL)
//WebUI.navigateToUrl('https://polaris2--regression.lightning.force.com/lightning/r/Job__c/a0JM00000095CtVMAU/view')
WebUI.delay(2)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))


WebUI.click(findTestObject('Finance/links/Labor_Lnk'))
WebUI.delay(5)
//WebUI.verifyElementPresent(findTestObject('Finance/Labor headers/Estimates'), 10)
//WebUI.scrollToElement(findTestObject('Finance/links/Labor_Lnk'), 10)
//WebUI.verifyElementPresent(findTestObject('Finance/Labor headers/Description'), 10)
WebDriver driver = DriverFactory.getWebDriver()//TestObject to = 

List<WebElement> rowsInTable = driver.findElements(By.xpath("//table[contains(@class,'slds-table slds-table_fixed-layout slds-table_bordered slds-table_header-fixed')]/thead/tr/th/span  |   //div[contains(@class,'slds-scrollable_y')]/table/thead/tr/th/span"))
//findTestObject('Finance/Labor headers/LaborTable')
//WebElement[] rowsInTable = table.findElements(By.xpath("//th")) as WebElement[]
// To calculate number of rows in the table


//List<WebElement> rowsInTable = table.findElements(By.xpath('//thead/tr/th '))

int rowsCount = rowsInTable.size()
WebUI.comment("rowsCount=${rowsCount}")
List<String> laborheader=GlobalVariable.LaborTableHeader
int contentLength=laborheader.size()
// Iterate over all the rows of the table
for (int r = 0; r < rowsCount; r++) {
	// To locate columns(cells) of that specific row
	List<WebElement> columnsInRow = rowsInTable//[r].findElements(By.tagName('span')) 
	int columnsCount = columnsInRow.size()
	WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
//	System.out.println("Number of cells in row ${r} are ${columnsInRow[r].getText().toString()}")
		String status='n'
		String cellText = columnsInRow[r].getText()
		for(int d=0;d<contentLength;d++)
		{
		
		if(cellText.trim().toUpperCase().equals(GlobalVariable.LaborTableHeader[d].toString().trim().toUpperCase()))
				{
					status='y'
				}
		}
		if(status.trim().equals('n'))
		{
			WebUI.comment("Missing the header value ${cellText}")
			FailureHandling.CONTINUE_ON_FAILURE
		}
		status="n"
	
}