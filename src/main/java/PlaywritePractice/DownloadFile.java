package PlaywritePractice;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		Download download = page.waitForDownload(()->{
			page.click("a:has-text('chromedriver_win32.zip')");
		});
		
		System.out.println(download.url());
		
		System.out.println(download.path().toString());
		
		download.saveAs(Paths.get("Dilip.zip"));
//		page.close();
//		browser.close();
//		playwright.close();


	}

}
