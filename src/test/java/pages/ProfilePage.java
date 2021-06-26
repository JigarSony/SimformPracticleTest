package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.basic-details-section a.profile_edit")
	private WebElement btnBasicEdit;

	@FindBy(css = "img.upload-image")
	private WebElement btnPlusImageUpload;

	@FindBy(css = "button.primary-btn-outline.profile_update.active")
	private WebElement btnUpload;

	@FindBy(css = "img.profile")
	private WebElement imgProfile;

	@FindBy(css = "div.header-socialmedia > ul > li:nth-child(1) > a:nth-child(2) > img")
	private WebElement iconFacebook;

	public void clickonBasicEditButton() {
		btnBasicEdit.click();
	}

	public void clickonPlusImageUploadButton() {
		btnPlusImageUpload.click();
	}

	public void uploadImage() {
		String projectPath = System.getProperty("user.dir");
		String filepath = projectPath + "/src/test/java/resources/sample.jpeg";
		// btnPlusImageUpload.sendKeys(filepath);
		btnPlusImageUpload.sendKeys("/Users/jigarsony/Desktop/sample.jpeg");
		// Users/jigarsony/Desktop
		btnPlusImageUpload.sendKeys(Keys.ENTER);
	}

	public void clickonSubmit() {
		btnUpload.click();
	}

	public String imgProfile() {
		return imgProfile.getAttribute("src");
	}

	public void clickonFbIcon() {
		iconFacebook.click();
		// sendKeys(Keys.COMMAND + "t");
	}

	public void backToPriviousTab() {
		iconFacebook.sendKeys(Keys.CONTROL + "" + Keys.TAB);
	}

}
