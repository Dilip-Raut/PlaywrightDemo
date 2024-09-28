package PlaywritePractice;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElement {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://www.amazon.in/");

		List<String> allLinks = page.locator("a:visible").allInnerTexts();

		for (int i = 0; i < allLinks.size(); i++) {
			System.out.println(allLinks.get(i));
		}

		// Using xpath
		int allImages = page.locator("//img>>visible=true").count();
		System.out.println(allImages);

		List<String> allLinkss = page.locator("a:has-text('Amazon')").allInnerTexts();

		for (int i = 0; i < allLinkss.size(); i++) {
			System.out.println("****" + allLinkss.get(i));
		}

	}

}
