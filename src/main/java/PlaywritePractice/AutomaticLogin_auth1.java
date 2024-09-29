package PlaywritePractice;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutomaticLogin_auth1 {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brContext = browser.newContext();
	    Page page=brContext.newPage();
		
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		page.fill("//input[@name='username']", "Admin");
		Thread.sleep(3000);
		page.fill("//input[@name='password']", "admin123");
		Thread.sleep(3000);
		page.click("//button[@type='submit']");
		Thread.sleep(3000);
		
		brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));
		
		Thread.sleep(2000);
		page.close();
		browser.close();
		playwright.close();
	}

}
