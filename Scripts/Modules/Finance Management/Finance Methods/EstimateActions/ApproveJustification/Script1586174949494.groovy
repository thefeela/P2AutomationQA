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

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.LoadURL)

WebUI.delay(5)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.scrollToElement(findTestObject('Finance/links/Labor_Lnk'), 10)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> rowsInTable = driver.findElements(By.xpath('//div/tr/td//a'))

int rowsCount = rowsInTable.size()

WebUI.comment("rowsCount=$rowsCount")
for (int r = 0; r < rowsCount; r++) {
//WebElement CtrlElement=	((rowsInTable[r]) as WebElement[])
//CtrlElement.click()
	//TestObject CtrlElement=fromElement(rowsInTable[r])
	//WebUI.click(CtrlElement)
String UrlPO=	rowsInTable[r].getAttribute("href")

	WebUI.navigateToUrl(UrlPO)
	//WebUI.executeJavaScript("arguments[0].click", Arrays.asList(rowsInTable[r]))
	WebUI.delay(2)
	
	WebUI.scrollToElement(findTestObject('Finance/FullFlowLabor/ScrollPostion PO'),10)
	WebUI.delay(10)
	WebUI.scrollToElement(findTestObject('Finance/FullFlowLabor/Scroll PO 2'),10)
	WebUI.delay(10)
	//WebUI.switchToWindowIndex(1)
/*WebElement editJus=	driver.findElements(By.xpath("//button[contains(@title,'Edit Justification')][contains(@class,'test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare')]"))
editJus.click()*/
WebUI.click(findTestObject('Finance/FullFlowLabor/Justification/EditJustfication'))
WebUI.delay(2)
//WebElement DropdownJus=	driver.findElements(By.xpath("(//input[contains(@class,'slds-input slds-combobox__input')][contains(@role,'textbox')])[12]"))
WebUI.click(findTestObject('Finance/FullFlowLabor/Justification/EditJustificationDropdown'))
WebUI.delay(2)

WebUI.sendKeys(findTestObject('Finance/FullFlowLabor/Justification/EditJustificationDropdown'),'Added')

//WebUI.selectOptionByIndex(findTestObject('Finance/FullFlowLabor/Justification/EditJustificationDropdown'),0)
WebUI.delay(2)
WebUI.click(findTestObject('Finance/FullFlowLabor/Justification/ClickAdded'))
WebUI.delay(2)
//WebUI.selectOptionByValue(DropdownJus,"Added")
WebUI.click(findTestObject('Finance/FullFlowLabor/Justification/JustificationSave'))
WebUI.delay(2)
WebUI.click(findTestObject('Finance/FullFlowLabor/Justification/JustificationApprove'))
WebUI.delay(2)

WebUI.click(findTestObject('Finance/FullFlowLabor/Justification/JustificationSave1'))
WebUI.delay(2)

WebUI.navigateToUrl(GlobalVariable.LoadURL)

WebUI.delay(5)

WebUI.click(findTestObject('Finance/links/Esimate_Lnk'))

WebUI.click(findTestObject('Finance/links/Labor_Lnk'))

WebUI.delay(5)


WebUI.scrollToElement(findTestObject('Finance/links/Labor_Lnk'), 10)
 rowsInTable = driver.findElements(By.xpath('//div/tr/td//a'))
	}

