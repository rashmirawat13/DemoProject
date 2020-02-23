package sayem.testcases;

import sayem.base.BaseClass;
import sayem.pages.inbox.LandingPage;
import sayem.pages.login.LoginPage;
import sayem.util.ErrorUtil;
import sayem.util.TestUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest {

	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data){
		if(!TestUtil.isExecutable("LoginTest", BaseClass.xls1))
		 throw new SkipException("Runmode set to NO");
		if(!data.get("Runmode").equals("Y"))
			 throw new SkipException("Runmode set to NO for the data set");
		System.out.println(data.get("Runmode")+" -- "+data.get("Username") +" -- "+data.get("Password"));

		if(BaseClass.isLoggedIn){
			BaseClass.topMenu.Logout();
			BaseClass.isLoggedIn=false;
		}
		String testDataType=data.get("Flag");
		LoginPage loginPage = new LoginPage();
		
		
		LandingPage page= loginPage.doLogin(data.get("Username"), data.get("Password"));
		if(testDataType.equals("Y") & page==null){
			try{
			Assert.assertTrue(false, "Not able to login with correct data ");
			}catch(Throwable t){
				BaseClass.takeScreenshot("Login");
				ErrorUtil.addVerificationFailure(t);
			}
			BaseClass.isLoggedIn=false;
			return;
		}
		else if(!testDataType.equals("Y") & page!=null ){
			Assert.assertTrue(false, "Able to login with incorrect data ");
			BaseClass.isLoggedIn=false;	
			return;
		}
		
		if(testDataType.equals("Y"))
			BaseClass.isLoggedIn=true;
		else
			BaseClass.isLoggedIn=false;

	}
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("LoginTest", BaseClass.xls1);
	}
}
