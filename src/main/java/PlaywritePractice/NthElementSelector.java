package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {

	public static void main(String[] args) {
        Playwright playerite = Playwright.create();
		
		Browser browser=playerite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt=browser.newContext();
		Page page=brxt.newPage();
		page.navigate("https://www.bigbasket.com/");
		
		String FirstElement = page.locator(("div.container ul a>>nth=0")).textContent();
		System.out.println("FirstElement  "+FirstElement);
		
		String LastElement = page.locator(("div.container ul a>>nth=-1")).textContent();
		System.out.println("LastElement  "+LastElement);
	

	}

}
