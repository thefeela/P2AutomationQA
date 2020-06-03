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

int LaborIncrementor =  GlobalVariable.Incrementer+1 
//String SOWType='Constructor'
for (int r = 0; r < 4; r++) {
WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.ConsSTD+LaborIncrementor.toString()
        , ('SOW') : 'Construction', ('UOM') : 'Foot'], FailureHandling.STOP_ON_FAILURE)
LaborIncrementor+=1
}
for (int r = 0; r < 4; r++) {
	WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.ConsSTD+LaborIncrementor.toString()
			, ('SOW') : 'Construction', ('UOM') : 'HOUR'], FailureHandling.STOP_ON_FAILURE)
	LaborIncrementor+=1
	}
LaborIncrementor=1
for (int r = 0; r < 4; r++) {
	WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.NonConsSTD+LaborIncrementor.toString()
			, ('SOW') : 'Non Construction', ('UOM') : 'Foot'], FailureHandling.STOP_ON_FAILURE)
	LaborIncrementor+=1
	}
for (int r = 0; r < 4; r++) {
	WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.NonConsSTD+LaborIncrementor.toString()
			, ('SOW') : 'Non Construction', ('UOM') : 'HOUR'], FailureHandling.STOP_ON_FAILURE)
	LaborIncrementor+=1
	}
//Quote
LaborIncrementor=1
for (int r = 0; r < 4; r++) {
	WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.ConsSTD+LaborIncrementor.toString()
			, ('SOW') : 'Construction', ('UOM') : 'QUOTE'], FailureHandling.STOP_ON_FAILURE)
	LaborIncrementor+=1
	}
	for (int r = 0; r < 4; r++) {
		WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.ConsSTD+LaborIncrementor.toString()
				, ('SOW') : 'Construction', ('UOM') : 'QUOTE'], FailureHandling.STOP_ON_FAILURE)
		LaborIncrementor+=1
		}
	LaborIncrementor=1
	for (int r = 0; r < 4; r++) {
		WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.NonConsSTD+LaborIncrementor.toString()
				, ('SOW') : 'Non Construction', ('UOM') : 'QUOTE'], FailureHandling.STOP_ON_FAILURE)
		LaborIncrementor+=1
		}
	for (int r = 0; r < 4; r++) {
		WebUI.callTestCase(findTestCase('Modules/Finance Management/Finance Methods/EstimateActions/AddLabor'), [('LaborName') : GlobalVariable.NonConsSTD+LaborIncrementor.toString()
				, ('SOW') : 'Non Construction', ('UOM') : 'QUOTE'], FailureHandling.STOP_ON_FAILURE)
		LaborIncrementor+=1
		}
