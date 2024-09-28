package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeCssSelector {

	static Page page;
	public static void main(String[] args) {
		Playwright playerite = Playwright.create();
		Browser browser = playerite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt = browser.newContext();
	    page = brxt.newPage();
		// page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		//page.locator(("input[type='checkbox']:left-of(:text('Joe.Root'))")).first().click();
		selectUser("Joe.Root");
		selectUser("Jasmine.Morgan");
		
		
//		String role=page.locator(("td:right-of(:text('Joe.Root'))")).first().textContent();
//		System.out.println(role);
		
		System.out.println("User Role is "+getUserRole("Joe.Root"));	
	}
	
	public static void selectUser(String userName) {
		page.locator(("input[type='checkbox']:left-of(:text('"+userName+"'))")).first().click();
	}

	public static String getUserRole(String userName) {
		return page.locator(("td:right-of(:text('"+userName+"'))")).first().textContent();
	}
}
