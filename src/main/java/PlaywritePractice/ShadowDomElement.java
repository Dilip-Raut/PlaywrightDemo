package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://books-pwakit.appspot.com/explore?q=");
		
		page.locator("//book-app[@apptitle='BOOKS']").locator("#input").fill("Dilip Raut");
		
		String text = page.locator("//book-app[@apptitle='BOOKS']").locator(".books-desc").first().textContent();
		System.out.println(text);
		


	}

}
