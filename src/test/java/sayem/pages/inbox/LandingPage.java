package sayem.pages.inbox;

import sayem.base.BaseClass;

public class LandingPage extends BaseClass {
	public MyProfilePage gotoProfile(){
     click("go_to_profile");
     return new MyProfilePage();
	
	}
}
