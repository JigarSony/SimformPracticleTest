package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.DashboardPage;
//import pages.HomePage;
import pages.LoginPage;
import pages.OfferPage;
import pages.ProfilePage;

public class GreenHogTestSuite extends BaseClass {

	// private HomePage homePage;
	private LoginPage loginPage;
	private DashboardPage dashbordPage;
	private ProfilePage profilePage;
	private OfferPage offerPage;

	@Test
	public void test1() {
		// homePage = new HomePage(driver);
		// homePage.clickonLoginLink();
		driver.get("https://stage.greenhog.com/#/login");
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));
		staticWait(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

	@Test
	public void test2() {
		dashbordPage = new DashboardPage(driver);
		dashbordPage.selectProfile();
		// dashbordPage.selectProfileText();
		staticWait(5000);
		profilePage = new ProfilePage(driver);
		profilePage.clickonBasicEditButton();
		staticWait(2000);
		profilePage.clickonPlusImageUploadButton();
		staticWait(2000);
		profilePage.uploadImage();
		staticWait(2000);
		profilePage.clickonSubmit();
		Assert.assertTrue(profilePage.imgProfile().contains("sample.jpeg"));
	}

	@Test
	public void test3() {
		profilePage.clickonFbIcon();
		profilePage.backToPriviousTab();
		Assert.assertTrue(driver.getCurrentUrl().contains("profile"));
	}

	@Test
	public void test4() {
		driver.get("https://stage.greenhog.com/#/app/my-offers");
		offerPage = new OfferPage(driver);
		offerPage.clickonShare();
		offerPage.getLinkText();
		offerPage.clickonCloseIcon();
		offerPage.enterSearchbox();
	}
}
