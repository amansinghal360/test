package com.dp.qa.common;

import org.testng.annotations.Test;
import com.dp.qa.base.TestBase;
import com.dp.qa.pages.HomePage;

public class MyLoginTest extends TestBase {

	@Test(description = "Login with User in dPEngine")
	public void myLoginTest() {
		HomePage homePage = new HomePage();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Admin_Username"), props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(props.getProperty("Admin_Username"));
		homePage.logOutFromApplication();
	}
}
