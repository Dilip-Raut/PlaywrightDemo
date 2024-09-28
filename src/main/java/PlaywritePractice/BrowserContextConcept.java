package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {
		
		Playwright playwrite=Playwright.create();
		
		Browser browser=playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brxt1=browser.newContext();
		Page page=brxt1.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.fill("input[placeholder='Username']", "Dilip");
		System.out.println("Title of browser 1 is - "+page.title());
		
		BrowserContext brxt2=browser.newContext();
		Page page2=brxt2.newPage();
		page2.navigate("http://www.automationpractice.pl/index.php");
		page2.fill("#search_query_top", "Dilip");
		System.out.println("Title of browser 2 is - "+page2.title());
		
		BrowserContext brxt3=browser.newContext();
		Page page3=brxt3.newPage();
		page3.navigate("http://www.google.co.in");
		System.out.println("Title of browser 3 is - "+page3.title());
		
		
		  page.close();
		  brxt1.close();
		  
		  page2.close();
		  brxt2.close();
		  
		  page3.close();
		  brxt3.close();
		 
		

	}

}
