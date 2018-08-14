package com.dp.qa.common;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dp.qa.base.TestBase;
import com.dp.qa.pages.HomePage;
import com.dp.qa.pages.SettingPage;

public class TuringONorOffEmailActivation extends TestBase {

	
	@Test(description = "Turing Off Email Activation Functionality")
	@Parameters({"checkBoxValue"})
	public void turningOnorOFFEmailActivation(String checkBoxValue) {
		HomePage homePage = new HomePage();
		SettingPage settingPage = new SettingPage();

		settingPage.openDpSettingURL();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Admin_Username"), props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(props.getProperty("Admin_Username"));

		settingPage.isUserNavigateTo("DpSetting - Edit");
		settingPage.checkBooleanValueCheckbox(checkBoxValue);
		settingPage.clickOnSubmitButton();
		settingPage.isSettingSaved();
		settingPage.clickOnReloadSettings();
	}

}
