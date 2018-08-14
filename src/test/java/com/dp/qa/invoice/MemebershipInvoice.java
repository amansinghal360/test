package com.dp.qa.invoice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dp.qa.base.GlobalVars;
import com.dp.qa.base.TestBase;
import com.dp.qa.pages.HomePage;
import com.dp.qa.pages.NavTabAndUserAssociationsOnMyAccountPage;
import com.dp.qa.pages.RegisterationPage;
import com.dp.qa.pages.SettingPage;
import com.dp.qa.pages.MyAccount.CompanyPage;
import com.dp.qa.pages.MyAccount.InvoicesPage;
import com.dp.qa.pages.MyAccount.MyAccountPage;
import com.dp.qa.pages.ProgramTools.ProgramToolsPage;

public class MemebershipInvoice extends TestBase {
	protected HomePage homePage;
	protected RegisterationPage registerationPage;
	protected MyAccountPage myAccountPage;
	protected SettingPage settingPage;
	protected InvoicesPage invoicePage;
	protected CompanyPage companyPage;
	protected ProgramToolsPage programToolPage;
	protected NavTabAndUserAssociationsOnMyAccountPage navTabOnMyAccountPage;

	@BeforeMethod
	public void setUp() {
		homePage = new HomePage();
		registerationPage = new RegisterationPage();
		myAccountPage = new MyAccountPage();
		settingPage = new SettingPage();
		invoicePage = new InvoicesPage();
		companyPage = new CompanyPage();
		programToolPage = new ProgramToolsPage();
		navTabOnMyAccountPage = new NavTabAndUserAssociationsOnMyAccountPage();
	}

	@Test(description = "Create Membership Invoice from EditMyCompany Section", priority = 1)
	public void createMembershipInvoiceFromEditMyCompany() {
		homePage.clickOnLoginFromHeader();
		homePage.clickOnRegisterLink();
		registerationPage.isUserNavigateTo("Create Account");
		registerationPage.enterUserName();
		registerationPage.enterPassword(props.getProperty("Admin_Password"));
		registerationPage.enterConfirmPassword(props.getProperty("Admin_Password"));
		registerationPage.enterFirstName();
		registerationPage.enterLasttName();
		registerationPage.enterEmailAddress(GlobalVars.registerUserName + ".com");
		registerationPage.enterConfirmEmailAddress();
		registerationPage.enterForumUserName();
		registerationPage.enterAddress(props.getProperty("User_Address"));
		registerationPage.enterCity(props.getProperty("User_City"));
		registerationPage.selectStateName(props.getProperty("User_State"));
		registerationPage.enterPostalCode(props.getProperty("User_PostalCode"));
		registerationPage.selectCountryName(props.getProperty("User_Country"));
		registerationPage.enterCompanyName(GlobalVars.registerUserName);
		registerationPage.acceptTermsAndCondition();
		registerationPage.clickOnSubmitButton();
		settingPage.isUserNavigateTo("Company Registration");
		companyPage.enterCompanyAddress(props.getProperty("User_Address"));
		registerationPage.enterCity(props.getProperty("User_City"));
		registerationPage.selectStateName(props.getProperty("User_State"));
		registerationPage.selectCountryName(props.getProperty("User_Country"));
		companyPage.enterCompanyPhone(props.getProperty("MainPhone"));
		companyPage.enterCompanyURL(GlobalVars.registerUserName);
		companyPage.selectCompanySize("51-100");
		companyPage.selectProgram("Program 3");
		companyPage.selectMultiSelectBoxLabel("Test1");
		registerationPage.acceptTermsAndCondition();
		programToolPage.clickOnSubmitInputType();
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Admin_Username"), props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(props.getProperty("Admin_Username"));
		homePage.waitToLoaderRemove();
		myAccountPage.clickMyAccountAtHeader();
		myAccountPage.clickSearchUserByHoverCompaniesAndUsers();
		myAccountPage.enterKeywords(GlobalVars.registerUserName);
		myAccountPage.clickOnSearchButton();
		myAccountPage.isUserNavigateTo("User Search Results");
		myAccountPage.openSearchedResult();
		settingPage.isUserNavigateTo("Edit My Profile");
		myAccountPage.assignRoleToUser("SITE_ADMIN");
		myAccountPage.clickOnUpdateButton();
		myAccountPage.alertSuccessMessage("Your changes have been saved successfully");
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(GlobalVars.registerUserName, props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(GlobalVars.registerUserName);
		homePage.waitToLoaderRemove();
		homePage.clickOnEditMyCompany();
		companyPage.selectMembershipLevel("Testing Only");
		companyPage.clickOnUpdateBttnAfterScrollingUp();
		myAccountPage.alertSuccessMessage("Your changes have been saved successfully");
		companyPage.clickOnMenerateMembershipInvoiceLink();
		settingPage.isUserNavigateTo("Create Membership Invoice");
		invoicePage.selectBDM(props.getProperty("BDM"));
		invoicePage.enterGrantSupportHours(props.getProperty("SupportHours"));
		invoicePage.enterStartEndDate("9", "25");
		invoicePage.enterInvoiceDescription("Testing Only Membership\r\n"
				+ "Includes 50.0 support hours, 10 test days\r\n" + "Marketing Benefits: Not Included");
		invoicePage.enterQuotedPrice(props.getProperty("QuotedPRice"));
		invoicePage.enterAddress(props.getProperty("User_Address"));
		invoicePage.enterCityName(props.getProperty("User_City"));
		invoicePage.selectStateName(props.getProperty("StateName"));
		invoicePage.enterPostalCode(props.getProperty("User_PostalCode"));
		invoicePage.selectCountry(props.getProperty("User_Country"));
		invoicePage.enterMainPhone(props.getProperty("MainPhone"));
		invoicePage.enterBillingContactName(props.getProperty("BillingContactName"));
		invoicePage.enterBillingContactPhone(props.getProperty("BillingContactPhone"));
		invoicePage.enterbillingContactEmail(props.getProperty("BillingContactEmail"));
		invoicePage.clickOnCreateInvoice();
		settingPage.isUserNavigateTo("Verify Invoice");
		invoicePage.clickOnApproveInvoice();
		myAccountPage
				.alertSuccessMessage("The invoice has been created and user has been sent notification of billing.");
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
		homePage.clickOnHomeLink();
		myAccountPage.clickMyAccountAtHeader();
		myAccountPage.clickSearchUCompanyByHoverCompaniesAndUsers();
		settingPage.isUserNavigateTo("Search Companies");
		myAccountPage.enterKeywords(GlobalVars.registerUserName);
		myAccountPage.clickOnSearchButton();
		settingPage.isUserNavigateTo("Company Search Results");
		companyPage.clickOnDeleteLinkAndAcceptPopUpAtSearchResult();
		myAccountPage.alertSuccessMessage("Your item has been deleted successfully");
		homePage.logOutFromApplication();
	}

	@Test(description = "Create Membership Invoice FOR USER COLORBOX", priority = 2)
	public void createMembershipInvoiceFrom() {
		homePage.clickOnLoginFromHeader();
		homePage.clickOnRegisterLink();
		registerationPage.isUserNavigateTo("Create Account");
		registerationPage.enterUserName();
		registerationPage.enterPassword(props.getProperty("Admin_Password"));
		registerationPage.enterConfirmPassword(props.getProperty("Admin_Password"));
		registerationPage.enterFirstName();
		registerationPage.enterLasttName();
		registerationPage.enterEmailAddress(GlobalVars.registerUserName + ".com");
		registerationPage.enterConfirmEmailAddress();
		registerationPage.enterForumUserName();
		registerationPage.enterAddress(props.getProperty("User_Address"));
		registerationPage.enterCity(props.getProperty("User_City"));
		registerationPage.selectStateName(props.getProperty("User_State"));
		registerationPage.enterPostalCode(props.getProperty("User_PostalCode"));
		registerationPage.selectCountryName(props.getProperty("User_Country"));
		registerationPage.enterCompanyName(GlobalVars.registerUserName);
		registerationPage.acceptTermsAndCondition();
		registerationPage.clickOnSubmitButton();
		settingPage.isUserNavigateTo("Company Registration");
		companyPage.enterCompanyAddress(props.getProperty("User_Address"));
		registerationPage.enterCity(props.getProperty("User_City"));
		registerationPage.selectStateName(props.getProperty("User_State"));
		registerationPage.selectCountryName(props.getProperty("User_Country"));
		companyPage.enterCompanyPhone(props.getProperty("MainPhone"));
		companyPage.enterCompanyURL(GlobalVars.registerUserName);
		companyPage.selectCompanySize("51-100");
		companyPage.selectProgram("Program 3");
		companyPage.selectMultiSelectBoxLabel("Test1");
		registerationPage.acceptTermsAndCondition();
		programToolPage.clickOnSubmitInputType();
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(props.getProperty("Admin_Username"), props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(props.getProperty("Admin_Username"));
		homePage.waitToLoaderRemove();
		myAccountPage.clickMyAccountAtHeader();
		myAccountPage.clickSearchUserByHoverCompaniesAndUsers();
		myAccountPage.enterKeywords(GlobalVars.registerUserName);
		myAccountPage.clickOnSearchButton();
		myAccountPage.isUserNavigateTo("User Search Results");
		myAccountPage.openSearchedResult();
		settingPage.isUserNavigateTo("Edit My Profile");
		myAccountPage.assignRoleToUser("SITE_ADMIN");
		myAccountPage.clickOnUpdateButton();
		myAccountPage.alertSuccessMessage("Your changes have been saved successfully");
		homePage.logOutFromApplication();

		homePage.clickOnLoginFromHeader();
		homePage.loginWithCredentails(GlobalVars.registerUserName, props.getProperty("Admin_Password"));
		homePage.isUserLoggedIn(GlobalVars.registerUserName);
		homePage.waitToLoaderRemove();
		homePage.clickOnEditMyCompany();
		companyPage.selectMembershipLevel("Partner");
		companyPage.clickOnUpdateBttnAfterScrollingUp();
		myAccountPage.alertSuccessMessage("Your changes have been saved successfully");
		homePage.clickOnEditMyProfile();
		settingPage.isUserNavigateTo("Edit My Profile");
		myAccountPage.clickOnCreateForUserLink();
		navTabOnMyAccountPage.isUserNavigateToModal("Create for User");
		navTabOnMyAccountPage.clickOnCreateMembershipInvoiceLink();

		settingPage.isUserNavigateTo("Create Membership Invoice");
		invoicePage.selectBDM(props.getProperty("BDM"));
		invoicePage.selectMembershipPackage(props.getProperty("MembershipPackage"));
		invoicePage.enterGrantSupportHours(props.getProperty("SupportHours"));
		invoicePage.enterTestDays(props.getProperty("TestDays"));
		invoicePage.enterStartEndDate("9", "25");
		invoicePage.enterInvoiceDescription("Testing Only Membership\r\n"
				+ "Includes 50.0 support hours, 10 test days\r\n" + "Marketing Benefits: Included");
		invoicePage.enterQuotedPrice(props.getProperty("QuotedPRice"));
		invoicePage.enterAddress(props.getProperty("User_Address"));
		invoicePage.enterCityName(props.getProperty("User_City"));
		invoicePage.selectStateName(props.getProperty("StateName"));
		invoicePage.enterPostalCode(props.getProperty("User_PostalCode"));
		invoicePage.selectCountry(props.getProperty("User_Country"));
		invoicePage.enterMainPhone(props.getProperty("MainPhone"));
		invoicePage.enterBillingContactName(props.getProperty("BillingContactName"));
		invoicePage.enterBillingContactPhone(props.getProperty("BillingContactPhone"));
		invoicePage.enterbillingContactEmail(props.getProperty("BillingContactEmail"));
		invoicePage.clickOnCreateInvoice();
		settingPage.isUserNavigateTo("Verify Invoice");
		invoicePage.clickOnApproveInvoice();
		myAccountPage
				.alertSuccessMessage("The invoice has been created and user has been sent notification of billing.");
		homePage.clickOnEditMyCompany();
		myAccountPage.clickOnDeleteBttnAtEditMyProfile();
		homePage.clickOnEditMyProfile();
		myAccountPage.clickOnDeleteBttnAtEditMyProfile();
		myAccountPage.alertSuccessMessage("Your item has been deleted successfully");
		homePage.logOutFromApplication();
	}
}
