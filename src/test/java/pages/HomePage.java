package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@routerlinkactive = \"router-link-active\"][@href = \"#/login\"]")
	private WebElement btnLogin;

	public void clickonLoginLink() {
		btnLogin.click();
	}

}
