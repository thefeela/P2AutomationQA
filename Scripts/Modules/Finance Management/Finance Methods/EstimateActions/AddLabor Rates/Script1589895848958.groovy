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

WebUI.callTestCase(findTestCase('Modules/LoginMethos/Login -OffshoreAdmin'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/div_View profile_slds-r3'))

WebUI.click(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/button_View All'))

//WebUI.scrollToElement(findTestObject('Finance/ORAPO Creation/Page_Home  Salesforce/p_ORA_POs'),10)
WebUI.navigateToUrl(('https://polaris2--' + GlobalVariable.Environment.toString()) + '.lightning.force.com/lightning/o/National_Labor_Rates__c/list?filterName=Recent')
 
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Finance/Labor creation/NewLabor'))

WebUI.delay(2)

Integer numCnt = GlobalVariable.Incrementer + 1

WebUI.sendKeys(findTestObject('Object Repository/Finance/Labor rate creation/LaborRateCardName'), LaborRateCard.toString())

WebUI.sendKeys(findTestObject('Object Repository/Finance/Labor rate creation/LaborNameSearch'), LaborName.toString())

WebUI.sendKeys(findTestObject('Object Repository/Finance/Labor creation/LaborCodeSys Labor Code'), LaborName.toString())

WebUI.click(findTestObject('Object Repository/Finance/Labor creation/LaborCodeSOWConstruction InitialClick'))

WebUI.click(findTestObject('Object Repository/Finance/Labor creation/LaborCodeSOWConstruction', [('ItemIndex') : ('text()=\'' + 
            SOW.toString()) + '\'']))

WebUI.click(findTestObject('Object Repository/Finance/Labor creation/LaborCodeUOM - Initial Click'))

WebUI.click(findTestObject('Object Repository/Finance/Labor creation/LaborCodeUOM', [('ItemIndex') : ('text()=\'' + UOM.toString()) + 
            '\'']))

//WebUI.click(findTestObject('Object Repository/Finance/Labor creation/LaborCodeSaveBtn'))
WebUI.delay(5)

