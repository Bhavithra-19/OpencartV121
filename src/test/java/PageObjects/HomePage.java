package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement lnkMyaccount;
@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Register']")
WebElement lnkregister;
@FindBy(linkText="Login")
WebElement linkLogin;

public void clickMyaccount() {
	lnkMyaccount.click();
}
public void clickRegister() {
	lnkregister.click();
}
public void clickLogin() {
	linkLogin.click();
}

}
