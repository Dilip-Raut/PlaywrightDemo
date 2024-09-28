package PlaywritePractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JsPopupHandle {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.onDialog(dialog->{
			String text=dialog.message();
			System.out.println(text);
			dialog.accept("Hi This is Alert Created By Dilip");
			//dialog.accept();
			//dialog.dissmiss();
		});
		
		//JS alert,Prompt,Confirmation Prompt
		page.locator("//button[@onclick='jsAlert()']").click();
		System.out.println(page.locator("//p[@id='result']").textContent());
		
		page.locator("//button[@onclick='jsConfirm()']").click();
		System.out.println(page.locator("//p[@id='result']").textContent());
		
		page.locator("//button[@onclick='jsPrompt()']").click();
		System.out.println(page.locator("//p[@id='result']").textContent());
		
		page.close();
		browser.close();
		playwright.close();


	}

}
