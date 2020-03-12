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


WebUI.delay(2)

WebUI.refresh()
WebUI.click(findTestObject('links/Esimate_Lnk'))

WebUI.click(findTestObject('links/Labor_Lnk'))

WebElement[] EstimatenamesLABORGrid = driver.findElements(findTestObject('Object Repository/ReservePO/EstimatePONo')) as WebElement[]

WebElement[] imgInGrid = ((EstimatenamesLABORGrid.findElements(By.tagName('img'))) as WebElement[])

int columnsCount = rowsInTable.length

for (int c = 0; c < columnsCount; c++) {
WebUI.verifyElementAttributeValue(imgInGrid[c],'alt','Green',10)

	}

