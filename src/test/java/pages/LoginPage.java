package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userEmail")
	private WebElement txtEmail;

	@FindBy(name = "userPassword")
	private WebElement txtPassword;

	@FindBy(css = ".primary-btn.login-btn")
	private WebElement btnLogin;

	public void setUserName(String userName) {
		txtEmail.sendKeys(userName);
	}

	public void setPassword(String passWord) {
		txtPassword.sendKeys(passWord);
	}

	public void clickonSubmit() {
		btnLogin.click();
	}

	public void login(String userName, String passWord) {
		setUserName(userName);
		setPassword(passWord);
		clickonSubmit();
	}

}
