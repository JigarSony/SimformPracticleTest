package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(css = "div.form-control.dropdown-input")
	private WebElement dropDown;

	@FindBy(css = "div.dropdown-content.profile-dropdown")
	private WebElement ddProfile;

	@FindBy(css = "div.block")
	private WebElement ddProfileText;

	public void selectProfile() {
		dropDown.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ddProfile));
		wait.until(ExpectedConditions.visibilityOf(ddProfileText));
		ddProfileText.click();
	}

	public void selectProfileText() {
		Select profile = new Select(ddProfile);
		profile.selectByVisibleText("Profile");
	}
}
