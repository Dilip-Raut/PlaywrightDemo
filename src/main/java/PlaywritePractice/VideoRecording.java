package PlaywritePractice;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class VideoRecording {

	public static void main(String[] args) {
	       	Playwright playwright = Playwright.create();
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		      
		      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
		    		  									.setRecordVideoDir(Paths.get("myVideos/")).setRecordVideoSize(640, 480));
		      
		      Page page = context.newPage();
		      page.navigate("https://www.automationexercise.com/");
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login")).click();
		      page.getByPlaceholder("Name").click();
		      page.getByPlaceholder("Name").fill("Dilip");
		      page.locator("form").filter(new Locator.FilterOptions().setHasText("Signup")).getByPlaceholder("Email Address").fill("Dilip@gmail.com");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Signup")).click();
		      page.getByLabel("Mr.").check();
		      page.getByLabel("Password *").click();
		      page.getByLabel("Password *").fill("12345");
		      page.getByLabel("First name *").click();
		      page.getByLabel("First name *").fill("Dilip");
		      page.getByLabel("Last name *").click();
		      page.getByLabel("Last name *").fill("Raut");
		      page.getByLabel("Address * (Street address, P.").click();
		      page.getByLabel("Address * (Street address, P.").fill("ABC");
		      page.getByLabel("State *").click();
		      page.getByLabel("State *").fill("MH");
		      page.getByLabel("City *").click();
		      page.getByLabel("City *").fill("CH");
		      page.locator("#zipcode").click();
		      page.locator("#zipcode").fill("122345");
		      page.getByLabel("Mobile Number *").click();
		      page.getByLabel("Mobile Number *").fill("123456");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create Account")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Continue")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Delete Account")).click();


		      context.close();
				page.close();
				playwright.close();
	}

}
