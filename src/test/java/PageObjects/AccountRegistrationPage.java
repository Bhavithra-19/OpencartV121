package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		

    }
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;
@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;
@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;
@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement btnContinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;
@FindBy(id="input-confirm")
WebElement txtConfirmPassword;

public void setFirstname(String fname) {
	txtFirstname.sendKeys(fname);
}
public void setLastname(String lname) {
	txtLastname.sendKeys(lname);
	
}
public void setEmail(String email) {
	txtEmail.sendKeys(email);
	
}
public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void setPrivatePolicy() {
	// TODO Auto-generated method stub
	//chkPolicy.click();
	Actions act=new Actions(driver);
	act.moveToElement(chkPolicy).click().perform();
	
	
}
public void clickContinue() {
	// TODO Auto-generated method stub
	//btnContinue.click();
	//Actions act=new Actions(driver);
	//t.moveToElement(btnContinue).click().perform();
	btnContinue.sendKeys(Keys.RETURN);
	
}
public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	}
	catch(Exception e) {
		return(e.getMessage());
		
	}
}
public void setConfirmPassword(String pwd) {
    txtConfirmPassword.sendKeys(pwd);
}






}
