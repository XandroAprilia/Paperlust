package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest3 extends BaseElement{
	By buttonCls = By.xpath("//span[@class='glyphicon glyphicon-remove pull-right close-international-pl']");
	By buttonJ = By.xpath("//div[@role='button'][normalize-space()='join']");
	By buttonSI = By.xpath("//form[@id='register']//button[@type='submit']");
	By inFN = By.xpath("//input[@id='signup-firstname']");
	By inLN = By.xpath("//input[@id='signup-lastname']");
	By inEm = By.xpath("//input[@id='signup-email']");
	By inMbl = By.xpath("//input[@id='signup-mobile']");
	By inPass = By.xpath("//input[@id='signup-password']");
	
	public BaseTest3(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	public void clsIklan() {
		clickAndWaitByXpath(buttonCls);
	}

	public void clickLogin() {
		clickAndWaitByXpath(buttonJ);
	}
	
	public void clickSignUp() {
		clickAndWaitByXpath(buttonSI);
	}
	
	public void getErrNotif() {		
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		
		WebElement fn = driver.get().findElement(By.xpath("//input[@id='signup-firstname']"));
		WebElement ln = driver.get().findElement(By.xpath("//input[@id='signup-lastname']"));
		WebElement em = driver.get().findElement(By.xpath("//input[@id='signup-email']"));
		WebElement mbl = driver.get().findElement(By.xpath("//input[@id='signup-mobile']"));
		WebElement pss = driver.get().findElement(By.xpath("//input[@id='signup-password']"));
		
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", fn);
		System.out.println("Input First Name");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", ln);
		System.out.println("Input Last Name");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", em);
		System.out.println("Input Email");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", mbl);
		System.out.println("Input Mobile Phone");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", pss);
		System.out.println("Input Password");
	}
	
	public void inputDataFN(String f) {
		clickAndWaitByXpath(inFN);
		setText(inFN, f);
	}
	
	public void inputDataLN(String l) {
		clickAndWaitByXpath(inLN);
		setText(inLN, l);
	}
	
	public void inputDataE(String e) {
		clickAndWaitByXpath(inEm);
		setText(inEm, e);
	}
	
	public void inputDataMP(String m) {
		clickAndWaitByXpath(inMbl);
		setText(inMbl, m);
	}
	
	public void inputDataP(String p) {
		clickAndWaitByXpath(inPass);
		setText(inPass, p);
	}
	
	public void delErrNotif() {		
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		
		WebElement fn = driver.get().findElement(By.xpath("//input[@id='signup-firstname']"));
		WebElement ln = driver.get().findElement(By.xpath("//input[@id='signup-lastname']"));
		WebElement em = driver.get().findElement(By.xpath("//input[@id='signup-email']"));
		WebElement mbl = driver.get().findElement(By.xpath("//input[@id='signup-mobile']"));
		WebElement pss = driver.get().findElement(By.xpath("//input[@id='signup-password']"));
		WebElement pssText = driver.get().findElement(By.xpath("//div[contains(text(),'Please enter at least 5 characters.')]"));
		
		js.executeScript("arguments[0].setAttribute('aria-invalid',false);", fn);
		System.out.println("Input First Name Berhasil");
		js.executeScript("arguments[0].setAttribute('aria-invalid',false);", ln);
		System.out.println("Input Last Name Berhasil");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", em);
		System.out.println("Input Email Gagal");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", mbl);
		System.out.println("Input Mobile Phone Gagal");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", pss);
		System.out.println("Input Password");
		js.executeScript("arguments[0].setAttribute('aria-invalid',true);", pssText);
		System.out.println(pssText.getText());
	}
	
}
