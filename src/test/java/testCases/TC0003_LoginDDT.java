package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC0003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp) {
		logger.info("***starting TC0003_LoginDDT") ;
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clkLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			
		}
		logger.info("***Finished TC0003_LoginDDT") ;
		
		
	}

}
