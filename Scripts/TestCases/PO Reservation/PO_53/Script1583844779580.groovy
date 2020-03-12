WebUI.callTestCase(findTestCase('CommonMethods/CreateXNETJob'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AddEstimate/AddConstructionSTDLabor'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('EstimateActions/ApproveEstimate'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.click(findTestObject('links/Esimate_Lnk'))

WebUI.click(findTestObject('links/Labor_Lnk'))

WebUI.click(findTestObject('ReservationButtons/ReservePO'))

WebUI.delay(2)

WebUI.click(findTestObject('ReservePO/selectALLPO'))

WebUI.delay(2)

//WebUI.click(findTestObject('Object Repository/ReservePO/InputQtyPOReserveOverlay'))
WebUI.sendKeys(findTestObject('Object Repository/ReservePO/PO_Search'), '24')

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/SeectReservePONO'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/ReservePO/FinalReserveButtonwithPO'))

WebUI.delay(2)

//WebUI.verifyElementPresent(findTestObject('Object Repository/ErrorMsgLabor/90percent reservation warning'), 10)

//WebUI.delay(2)

