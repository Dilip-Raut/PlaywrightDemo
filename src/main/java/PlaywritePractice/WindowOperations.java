package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowOperations {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwrite = Playwright.create();

		Browser browser = playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt1 = browser.newContext();
		BrowserContext brxt2 = browser.newContext();
		
		//1 - open New tab/window/popup after clicking on link on parent page:
		Page page1=brxt1.newPage();
		page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
		Page popup=page1.waitForPopup(()->{
			page1.click("//a[contains(text(),'OrangeHRM, Inc')]");	
		});
		
		System.out.println("PopUp Window title : "+popup.title());
		Thread.sleep(2000);
		popup.close();
		System.out.println("Main/parent Window title : "+page1.title());
		Thread.sleep(2000);
		page1.close();
		
		
		//2 - open New tab/window/popup and enter new url:
		Page page2=brxt2.newPage();
		page2.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);
	
		Page popup2=page2.waitForPopup(()->{
			page2.click("a[target='_blank']");	
		});
		 
		popup2.waitForLoadState();
		popup2.navigate("https://www.flipkart.com");
		Thread.sleep(4000);
		System.out.println("PopUp Window title - Context 2 : "+popup2.title());
		Thread.sleep(2000);
		popup2.close();
		System.out.println("Main/parent Window title - Context 2: "+page2.title());
		Thread.sleep(2000);
		page2.close();
		
		brxt1.close();
		brxt2.close();
		playwrite.close();
		
		
		
		


	}

}
