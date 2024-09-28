package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelector_selectingAnyOneCondition {

	public static void main(String[] args) {
		Playwright playerite = Playwright.create();

		Browser browser = playerite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt = browser.newContext();
		Page page = brxt.newPage();
		// page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.navigate("https://automationexercise.com/");
		
		//page.locator("a:has-text('Signup')," + "a:has-text('Login')").click();
		
		//Using Xpath Union
		page.locator("//a[contains(text(),' Login')]|//a[contains(text(),' Signup')]").click();

	}

}
