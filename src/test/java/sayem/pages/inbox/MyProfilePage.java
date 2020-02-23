package sayem.pages.inbox;
import sayem.base.BaseClass;

public class MyProfilePage extends BaseClass {
	public void changePic(String newPicPath){
		click("edit_profile_pic");
		input("file_upload", newPicPath);
	}
	public FriendList loadFriendList(){
		click("friends_link");
		return new FriendList();
	}
}
