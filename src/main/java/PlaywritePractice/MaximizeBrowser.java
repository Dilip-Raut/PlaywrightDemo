package PlaywritePractice;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		Dimension  size =Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int) size.getWidth();
		int height =(int) size.getHeight();
		System.out.println("Width is -> "+width+" Height is -> "+height);
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		Page page=brxt.newPage();
		
		page.navigate("https://www.google.co.in");
		
		Thread.sleep(4000);
		
		page.close();
		browser.close();
		playwright.close();


	}

}
