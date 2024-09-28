package PlaywritePractice;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutomaticLogin_auth1 {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();
	    Page page=brContext.newPage();
		
		page.navigate("http://www.automationpractice.pl/index.php");
		page.click("a:has-text('Sign in')");
		page.fill("#email", "testrigornaveen@gmail.com");
		page.fill("#passwd", "testrigor123");
		page.click("#SubmitLogin");
		
		brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
		

	}

}
