package sayem.testcases;

import sayem.base.BaseClass;
import sayem.pages.inbox.LandingPage;
import sayem.pages.inbox.MyProfilePage;
import sayem.pages.login.LoginPage;
import sayem.util.TestUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ChangePicTest {
	
	@Test
	public void changePic(){
		
		if(!TestUtil.isExecutable("ChangePicTest", BaseClass.xls1))
			 throw new SkipException("Runmode set to NO");
		LandingPage landingPage=null;
		if(!BaseClass.isLoggedIn){
			LoginPage loginPage = new LoginPage();
			landingPage= loginPage.doLogin();
		}else{

		}
		
		MyProfilePage profilePage = landingPage.gotoProfile();
	}

}
