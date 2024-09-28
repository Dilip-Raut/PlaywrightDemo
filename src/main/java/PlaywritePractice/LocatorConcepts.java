package PlaywritePractice;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcepts {

	public static void main(String[] args) {
		Playwright playerite = Playwright.create();
		
		Browser browser=playerite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brxt=browser.newContext();
		Page page=brxt.newPage();
		//page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.navigate("https://practice.expandtesting.com/dropdown/");
		
		//Handling Single Elements
		/*
		 * Locator login=page.locator("text=Forgot your password?"); 
		 * login.hover();
		 * login.click();
		 */
		
		/*
		 * Locator loginBtn=page.locator("text=Login");
		 *  int totalLoginBtn=loginBtn.count();
		 * System.out.println("totalLoginBtn - "+totalLoginBtn);
		 * loginBtn.last().click();
		 */
		
		//Handling Multiple Elements
		Locator countryOptions= page.locator("select#country option");
		System.out.println(countryOptions.count());
		
		/*
		 * for(int i=0;i<countryOptions.count();i++) { 
		 * String countryNames=countryOptions.nth(i).textContent();
		 * System.out.println(countryNames); }
		 */
		
		List<String> countryNames= countryOptions.allTextContents();
//		for(String countryName:countryNames) {
//			System.out.println(countryName);
//		}
//		
		System.out.println("*******************************************");
		countryNames.forEach(countryName->System.out.println(countryName));
		
	}

}
