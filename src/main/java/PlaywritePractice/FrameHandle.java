package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//BrowserContext browserContext=browser.newContext();
		Page page=browser.newPage();
		
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		
//		String frameText =page.frameLocator("frame[name='main']").locator("h2").textContent();
//		System.out.println(frameText);
		
//		String frameText =page.frame("main").locator("h2").textContent();
//		System.out.println(frameText);
		
		String frameText =page.frameLocator("//frame[@name='main']").locator("h2").textContent();
		System.out.println(frameText);
		
		
		Thread.sleep(5000);
		browser.close();
	

	}

}
