package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","Master"})
	public void verify_login()
	{
		logger.info(" ** starting TC_002_ LoginTest");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clkLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		Assert.assertTrue(targetPage);
		}
		//catch(Exception e) {
			//Assert.fail();
		//}
		catch(Exception e) {
		    logger.error("Test failed", e);
		    Assert.fail(e.getMessage());
		}
		logger.info("**Finished TC002_LoginTest ");
		
	}

}
