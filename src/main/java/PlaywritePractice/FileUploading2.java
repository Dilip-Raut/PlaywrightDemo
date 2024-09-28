package PlaywritePractice;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploading2 {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//RunTime File uploading and Verifying Content Of File
				page.setInputFiles("//input[@name='upfile']",new FilePayload("Dilip.txt", "text/plain","This Is Dilip Here".getBytes(StandardCharsets.UTF_8)));
				Thread.sleep(3000);
				
				page.locator("//input[@value='Press']").click();
				Thread.sleep(3000);
				
				page.close();
				browser.close();
				playwright.close();



	}
	
}
