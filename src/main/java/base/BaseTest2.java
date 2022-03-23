package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest2 extends BaseElement {
	boolean x;
	String res = "//em[normalize-space()='110']";

	public BaseTest2(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver.get(), this);
	}
	
	public String getTextRes(String tRes) {
		By finalXpath = By.xpath(String.format(res, tRes));
		return getText(finalXpath);
	}
	
	public void runJavaScriptCommand() {
		WebElement button = driver.get().findElement(By.xpath("//a[normalize-space()='Show more']"));
		String actualText = getTextRes(res);
		int act = Integer.parseInt(actualText);
		
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("window.scrollBy(0,170)");
		button.click();
		
		try {
			if (button.isDisplayed()) {
				for(int u = 0; u < act; u++) {
					js.executeScript("window.scrollBy(0,88)");
		    		button.click();
					if (u == act) {
			    	}	
		    	}
			}
		} catch (Exception e) {
			// TODO: handle exception
			int itemFrame = driver.get().findElements(By.tagName("h5")).size();
			System.out.println("Hasil Jumlah Result CheckBox : "+act);
    		System.out.println("Hasil Jumlah Grid : "+itemFrame);
		}
		
	}
	
}
