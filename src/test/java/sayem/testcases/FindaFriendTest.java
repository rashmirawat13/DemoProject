package sayem.testcases;

import sayem.base.BaseClass;
import sayem.pages.inbox.FriendList;
import sayem.pages.inbox.LandingPage;
import sayem.pages.inbox.MyProfilePage;
import sayem.pages.login.LoginPage;
import sayem.util.TestUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class FindaFriendTest {
	
	@Test
	public void findFriend(){
		String friendName="xxxxxx";
		System.out.println("findFriend");
		if(!TestUtil.isExecutable("FindaFriendTest", BaseClass.xls1))
			 throw new SkipException("Runmode set to NO");
		LandingPage landingPage=null;
		if(!BaseClass.isLoggedIn){
			LoginPage loginPage = new LoginPage();
			landingPage= loginPage.doLogin();
		}else{
			landingPage =  BaseClass.topMenu.gotoLandingPage();
		}
		MyProfilePage prof = landingPage.gotoProfile();
		FriendList fs = prof.loadFriendList();
		Assert.assertTrue(fs.searchFriend(friendName), friendName +" - Friend Not Present");
	}
	
	@Test(dependsOnMethods = { "findFriend" })
	public void messageFriend(){
		System.out.println("messageFriend");

	}
}
