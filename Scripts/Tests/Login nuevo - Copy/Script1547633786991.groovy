import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://executeautomation.com/demosite/Login.html')

//WebUI.setText(findTestObject('Object Repository/Page_Execute Automation/input_Login_UserName'), user)
//WebUI.setText(findTestObject('Object Repository/Page_Execute Automation/input_Login_UserName'), findTestData('Datos importados/datos').getValue(1, 1))
//WebUI.setText(findTestObject('Object Repository/Page_Execute Automation/input_Login_Password'), pass)
for (def rowNum = 1; rowNum <= findTestData('Datos importados/datos').getRowNumbers(); rowNum++) {
    WebUI.setText(findTestObject('Object Repository/Page_Execute Automation/input_Login_UserName'), findTestData('Datos importados/datos').getValue(
            1, rowNum))

    WebUI.setText(findTestObject('Object Repository/Page_Execute Automation/input_Login_Password'), findTestData('Datos importados/datos').getValue(
            2, rowNum))

    Thread.sleep(3000)
}

WebUI.click(findTestObject('Object Repository/Page_Execute Automation/input_Login_Login'))

WebUI.closeBrowser()

WebUI.verifyCheckpoint(findCheckpoint('Checkpoints/Checkpoint'), true)

