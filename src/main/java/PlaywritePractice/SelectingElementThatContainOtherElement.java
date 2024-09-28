package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectingElementThatContainOtherElement {

	public static void main(String[] args) {
Playwright playerite = Playwright.create();
		
		Browser browser=playerite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt=browser.newContext();
		Page page=brxt.newPage();
		//page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.navigate("https://practice.expandtesting.com/dropdown/");
		
		
		Locator countryNames = page.locator(("div.container:has(select[id='country'])"));
		
		System.out.println("*******************************************");
		countryNames.allInnerTexts().forEach(countryName->System.out.println(countryName));


	}

}
