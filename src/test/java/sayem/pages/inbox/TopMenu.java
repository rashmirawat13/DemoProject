package sayem.pages.inbox;

import org.openqa.selenium.By;
import sayem.base.BaseClass;

public class TopMenu {
	BaseClass base = new BaseClass();
	public void Logout(){
		BaseClass.driver.findElement(By.xpath(BaseClass.OR.getProperty("top_menu_list"))).click();
		BaseClass.driver.findElement(By.xpath(BaseClass.OR.getProperty("top_menu_logout"))).click();
	}
	public void search(String searchText){
		
	}
	public LandingPage gotoLandingPage(){
		//BaseClass.driver.findElement(By.xpath(BaseClass.CONFIG.getProperty("homePage_link"))).click();
		base.click("homePage_link");
		return new LandingPage();
	}
}
