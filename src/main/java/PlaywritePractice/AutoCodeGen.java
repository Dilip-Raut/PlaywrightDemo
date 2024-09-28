package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoCodeGen {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://www.google.co.in/");
			page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
			page.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("jai Shree ganesha");
		}
	}
}