package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseClass {

	public Browser browser;
	public BrowserContext browserContext;
	public Page page;

	@BeforeMethod
	public void setUP() {
		Playwright playerite = Playwright.create();
		Browser browser = playerite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
	}

	@AfterMethod
	public void tearDown() {
		browserContext.close();
		page.close();
	}
}
