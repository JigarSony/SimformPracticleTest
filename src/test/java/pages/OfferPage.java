package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {

	public OfferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".secondary-btn-outline.share-btn")
	private WebElement btnShare;

	@FindBy(css = "input.form-control.disabled")
	private WebElement txtLinkText;

	@FindBy(css = "a.class")
	private WebElement iconClose;

	@FindBy(css = ".form-control.search-offer")
	private WebElement txtSearch;

	public void clickonShare() {
		btnShare.click();
	}

	public String getLinkText() {
		txtLinkText.click();
		return txtLinkText.getAttribute("value");
	}

	public void clickonCloseIcon() {
		iconClose.click();
	}

	String lt = getLinkText();

	public void enterSearchbox() {
		txtSearch.sendKeys(lt);
	}
}
