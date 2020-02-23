package sayem.pages.inbox;

import sayem.base.BaseClass;

public class FriendList extends BaseClass {
	public boolean searchFriend(String friendName){
		input("friend_search_name", friendName);
		return isLinkPresent(friendName);
	}
}
