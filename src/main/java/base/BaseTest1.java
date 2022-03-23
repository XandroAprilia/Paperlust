package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest1 extends BaseElement{
	By inputSearch = By.xpath("//input[@title='Search']");
	By clickCheckBox = By.xpath("//label[@for='thank-you-cards']");
	
	String txt = "//q[normalize-space()='wedding invitations']";
	String txtCB = "//em[@class='mr-2 mb-3 text-capitalize btn-sm borders bg-secondary text-white']";
	
	public BaseTest1(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void inSearch(String s) {
		clickAndWaitByXpath(inputSearch);
		setText(inputSearch, s);
		enterTextByXpath(inputSearch);
	}
	
	public String getTextSearch(String t) {
		By finalXpath = By.xpath(String.format(txt, t));
		return getText(finalXpath);
	}
	
	public void checkBox() {
		clickAndWaitByXpath(clickCheckBox);
	}
	
	public String getTextCB(String tcb) {
		By finalXpath = By.xpath(String.format(txtCB, tcb));
		return getText(finalXpath);
	}
	
}
