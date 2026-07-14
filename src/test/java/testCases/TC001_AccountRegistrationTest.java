package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	/*@AfterClass
	public void tearDown() {
		driver.quit();
	*/
	@Test(groups={"Regression","Master"})
	public void verify_account_registrtion() {
		
		
		logger.info("*** starting TC001_AccountRegistrationTest*** ");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("Clicked on my account");
		
		hp.clickRegister();
		logger.info("Clicked on register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setPassword(randomAlphaNumeric());
		String pwd = randomAlphaNumeric();

	    regpage.setConfirmPassword(pwd);
		regpage.setPrivatePolicy();
		regpage.clickContinue();
		
		logger.info("validating expected message");
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed",e);
			logger.debug("Debug logs");
			Assert.fail(e.getMessage());
		}
		logger.info("Finished");
		
	}
	
	
	


}
