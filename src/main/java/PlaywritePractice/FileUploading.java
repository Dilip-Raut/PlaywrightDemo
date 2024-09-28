package PlaywritePractice;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploading {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//Selecting One File
//		page.setInputFiles("input#filesToUpload",Paths.get("applogin.json"));
//		Thread.sleep(3000);
//		page.setInputFiles("input#filesToUpload",new Path[0]);
//		Thread.sleep(3000);
		
		//Uploading Multiple Files
		page.setInputFiles("input#filesToUpload",new Path[] {
											Paths.get("applogin.json"),
											Paths.get("C:\\Users\\Shree\\Downloads\\image.png"),
											Paths.get("applogin2.json"),
				
		});
		
		Thread.sleep(3000);
		page.setInputFiles("input#filesToUpload",new Path[0]);
		Thread.sleep(3000);
		
		//RunTime File uploading
		page.setInputFiles("input#filesToUpload",new FilePayload("Dilip.txt", "text/plain","This Is Dilip Here".getBytes(StandardCharsets.UTF_8)));
		Thread.sleep(3000);
		
		page.close();
		browser.close();
		playwright.close();


	}

}
