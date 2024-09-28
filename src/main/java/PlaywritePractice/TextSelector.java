package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//BrowserContext browserContext=browser.newContext();
		Page page=browser.newPage();
		
		page.navigate("https://demo-opencart.com/index.php?route=account/login&language=en-gb");
		
		//String Header =page.locator("h2:has-text('New Customer')").textContent();
		String Header =page.locator("div.container h2:has-text('New Customer')").textContent();
		System.out.println(Header);
		
		String rtcust = page.locator("'Returning Customer'").textContent();
		System.out.println(rtcust);
		
		//button
		page.locator("form button:has-text('Login')").click();
		
		
		Thread.sleep(5000);
		browser.close();
		
		
	}
	

}
