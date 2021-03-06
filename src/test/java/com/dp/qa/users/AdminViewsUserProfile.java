package com.dp.qa.users;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dp.qa.base.GlobalVars;
import com.dp.qa.base.TestBase;
import com.dp.qa.pages.HomePage;
import com.dp.qa.pages.RegisterationPage;
import com.dp.qa.pages.SettingPage;
import com.dp.qa.pages.MyAccount.MyAccountPage;

public class AdminViewsUserProfile extends TestBase {
	protected HomePage homePage;
	protected RegisterationPage registerationPage;
	protected MyAccountPage myAccountPage;
	protected SettingPage settingPage;

	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		myAccountPage = new MyAccountPage();
		settingPage = new SettingPage();
		registerationPage = new RegisterationPage();
	}

	@Test(description = "How an admin user would view a user's profile when they do not have permission to edit profiles. ")
	public void adminViewsUserProfile() {
		homePage.clickOnLoginFromHeader();
		homePage.clickOnRegisterLink();

		registerationPage.isUserNavigateTo("Create Account");
		registerationPage.enterUserName();
		registerationPage.enterPassword(props.getProperty("Admin_Password"));
		registerationPage.enterConfirmPassword(props.getProperty("Admin_Password"));
		registerationPage.enterFirstName();
		registerationPage.enterLasttName();
		registerationPage.enterEmailAddress(props.getProperty("User_EmailDomain"));
		registerationPage.enterConfirmEmailAddress();
		registerationPage.enterForumUserName();
		registerationPage.enterAddress(props.getProperty("User_Address"));
		registerationPage.enterCity(props.getProperty("User_City"));
		registerationPage.selectStateName(props.getProperty("User_State"));
		registerationPage.enterPostalCode(props.getProperty("User_PostalCode"));
		registerationPage.selectCountryName(props.getProperty("User_Country"));
		registerationPage.acceptTermsAndCondition();
		registerationPage.clickOnSubmitButton();
		settingPage.isUserNavigateTo("Company Registration (Matches Found)");
		registerationPage.clickOnSelectLink();
		myAccountPage.isUserNavigateTo("Company Association Confirmation");
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Admin_Username"), props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(props.getProperty("Admin_Username"));
		homePage.waitToLoaderRemove();
		myAccountPage.clickMyAccountAtHeader();
		myAccountPage.clickSearchUserByHoverCompaniesAndUsers();
		myAccountPage.enterKeywords(props.getProperty("Site_Admin_Username"));
		myAccountPage.clickOnSearchButton();
		myAccountPage.isUserNavigateTo("User Search Results");
		myAccountPage.openSearchedResult();
		settingPage.isUserNavigateTo("Edit My Profile");
		myAccountPage.removalAllAddedRole();
		myAccountPage.assignRoleToUser("DEVELOPER_SUPPORT");
		myAccountPage.assignRoleToUser("TESTING_MANAGER");
		myAccountPage.assignRoleToUser("TECH_REVIEWER");
		myAccountPage.assignRoleToUser("FINANCIAL_ADMIN");
		myAccountPage.assignRoleToUser("FINANCIAL_USER");
		myAccountPage.assignRoleToUser("TESTING_ENGINEER ");
		myAccountPage.clickOnUpdateButton();
		myAccountPage.alertSuccessMessage("Your changes have been saved successfully");
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Site_Admin_Username"), props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(props.getProperty("Site_Admin_Username"));
		homePage.waitToLoaderRemove();

		myAccountPage.clickMyAccountAtHeader();
		myAccountPage.clickSearchUserByHoverCompaniesAndUsers();
		settingPage.isUserNavigateTo("Search Users");
		myAccountPage.enterKeywords(GlobalVars.registerUserName);

		myAccountPage.clickOnSearchButton();
		myAccountPage.isUserNavigateTo("User Search Results");
		myAccountPage.openSearchedResult();

		settingPage.isUserNavigateTo("View Profile");
		myAccountPage.noTextFieldAvailable("firstName");
		myAccountPage.noTextFieldAvailable("confirmEmail");
		myAccountPage.noButtonAvailable("Update");
		myAccountPage.noButtonAvailable("Cancel");
		myAccountPage.noButtonAvailable("Delete");
		myAccountPage.forumAdminLinkNotAvailable();
		myAccountPage.noLinkAvailable("Update Your Password");

		myAccountPage.noLinkAvailable("Send Forgot Password Email");
		myAccountPage.noLinkAvailable("Update Your Password");
		myAccountPage.noLinkAvailable("Contact History");
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Admin_Username"), props.getProperty("Admin_Password"));
		homePage.waitToLoaderRemove();
		homePage.isUserLoggedIn(props.getProperty("Admin_Username"));

		myAccountPage.clickMyAccountAtHeader();
		myAccountPage.clickSearchUserByHoverCompaniesAndUsers();
		settingPage.isUserNavigateTo("Search Users");
		myAccountPage.enterKeywords(GlobalVars.registerUserName);
		myAccountPage.clickOnSearchButton();
		myAccountPage.isUserNavigateTo("User Search Results");
		myAccountPage.clickOnFirstRowLinkUnderAdminColumn();
		myAccountPage.alertSuccessMessage("Your item has been deleted successfully");

		homePage.logOutFromApplication();
	}
}
