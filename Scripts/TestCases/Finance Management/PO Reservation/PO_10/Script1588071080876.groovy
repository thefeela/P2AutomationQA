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

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login - JO'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Modules/JobManagement/Job Methods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/AddEstimate/AddNonConstructionNonSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)
WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))
WebUI.delay(2)
WebUI.click(findTestObject('Finance/links/Labor_Lnk'))
WebUI.delay(2)
WebDriver driver = DriverFactory.getWebDriver()


WebUI.click(findTestObject('Finance/ReservationButtons/ReservePO'))

WebUI.delay(2)
// check overy lay items


/*

List<WebElement> rowsInTable = driver.findElements(By.xpath('//table[contains(@class,\'slds-table slds-table_fixed-layout slds-table_bordered slds-table_header-fixed\')]/thead/tr  |   //div[contains(@class,\'slds-scrollable_y\')]/table/thead/tr'))

int rowsCount = rowsInTable.size()

WebUI.comment("rowsCount=$rowsCount")

for (int r = 0; r < rowsCount; r++) {
    List<WebElement> columnsInRow = rowsInTable[r].findElements(By.tagName('div'))

    int columnsCount = columnsInRow.size()

    for (int c = 0; c < columnsCount; c++) {
        if (c == 3) {
            String cellText = columnsInRow[c].getText().trim()

            if ((cellText != 'Pending') || (cellText != 'Partially Reserved')) {
                FailureHandling.CONTINUE_ON_FAILURE
            }
        }
    }
}

*/