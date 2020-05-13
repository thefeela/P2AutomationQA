import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Home  Salesforce/span_Reports'))
//WebUI.navigateToUrl('https://polaris2--regression.lightning.force.com/one/one.app#eyJjb21wb25lbnREZWYiOiJyZXBvcnRzOnJlcG9ydEJ1aWxkZXIiLCJhdHRyaWJ1dGVzIjp7InJlY29yZElkIjoiIiwibmV3UmVwb3J0QnVpbGRlciI6dHJ1ZX0sInN0YXRlIjp7fX0%3D')
WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Reports  Salesforce/div_New Report'))
WebUI.delay(5)
WebUI.executeJavaScript('document.body.style.zoom=\'100%\'', null) 
//WebUI.delay(5)
///WebUI.switchToFrame(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/iframe_Show actions_builder-1583150979131-844827 - Copy'), 10)
//WebUI.delay(5)
WebDriver driver = DriverFactory.getWebDriver()
int size = driver.findElements(By.tagName("iframe")).size();
System.out.println(size)
/*WebElement searchElements= driver.findElement(By.xpath("//input[contains(@id,'modal-search-input')]"))
searchElements.sendKeys("ora_")*/
if(size>1)
{
driver.switchTo().frame(1)
}
WebUI.delay(2)
/*driver.findElement(By.xpath("/html/body/div[10]/div/div/section/div/div/div/div[2]/form/div/div/input")).sendKeys('ora_')

////html/body/div[10]/div/div/section/div/div/div/div[2]/form/div/div/input
//WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/input_Search Report Types_modal-search-input'))
	
//WebUI.sendKeys(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/input_Search Report Types_modal-search-input'), 
   // 'ora_')
WebUI.delay(2)

driver.findElement(By.xpath("/html/body/div[10]/div/div/section/div/div/div/div[2]/div/ul/li[1]/a")).click()

driver.findElement(By.xpath("/html/body/div[10]/div/div/section/div/footer/button[2]")).click()
WebUI.delay(5)
//WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/a_ORA_POs'))

//WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/button_Continue'))
driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/div/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div/div/input")).sendKeys('po stat')
WebUI.setText(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/input_Add column_xtrnJ8u23'), 
    'po stat')
//WebUI.delay(3)
//driver.findElement(By.xpath("/html/body/span")).click()
WebUI.executeJavaScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/span")))
//WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/span_PO Status'))
driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/div[7]/button")).click()
//WebUI.click(findTestObject('Finance/Reports/PO Reports/Page_Report Builder  Salesforce/button_Run'))

*/