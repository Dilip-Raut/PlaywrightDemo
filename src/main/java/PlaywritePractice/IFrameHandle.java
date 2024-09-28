package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IFrameHandle {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
		Thread.sleep(2000);
		page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8").fill("Dilip Raut");
		Thread.sleep(5000);
		browser.close();
	

	}

}
