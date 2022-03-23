package runTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest1;
import base.BaseTest2;
import base.BaseTest3;
import utils.TestUtility;

public class RunnerPaperlust extends WebBase{

	BaseTest1 bp = new BaseTest1(driver, explicitWait);
	BaseTest2 bp2 = new BaseTest2(driver, explicitWait);
	BaseTest3 bp3 = new BaseTest3(driver, explicitWait);
	
	@Test(priority = 1)
	public void RunnerTest1() {
		String inSearch = "wedding invitations";
		String txtCB = "Thank You Cards";
		
		bp.inSearch(inSearch);
		TestUtility.hardWait(1);
		String actualTextSearch = bp.getTextSearch(inSearch);
		assertEquals(actualTextSearch, inSearch);
		TestUtility.hardWait(1);
		
		bp.checkBox();
		TestUtility.hardWait(3);
		String actualTextCB = bp.getTextCB(txtCB);
		assertEquals(actualTextCB, txtCB);
		TestUtility.hardWait(3);
		
		bp2.runJavaScriptCommand();
		TestUtility.hardWait(10);	
	}
	
	@Test(priority = 2)
	public void RunnerTest2() {
		String firstN = "firstname";
		String lastN = "lastname";
		String email = "ini email";
		String mp = "asdfgh";
		String pass = "1234";
		
		bp3.clsIklan();
		bp3.clickLogin();
		TestUtility.hardWait(3);
		bp3.clickSignUp();
		TestUtility.hardWait(3);
		//Get Error
		bp3.getErrNotif();
		TestUtility.hardWait(1);
		//Input Data
		bp3.inputDataFN(firstN);
		TestUtility.hardWait(1);
		bp3.clickSignUp();
		TestUtility.hardWait(1);
		
		bp3.inputDataLN(lastN);
		TestUtility.hardWait(1);
		bp3.clickSignUp();
		TestUtility.hardWait(1);
		
		bp3.inputDataE(email);
		TestUtility.hardWait(1);
		bp3.clickSignUp();
		TestUtility.hardWait(1);
		
		bp3.inputDataMP(mp);
		TestUtility.hardWait(1);
		bp3.clickSignUp();
		TestUtility.hardWait(3);
		
		bp3.inputDataP(pass);
		TestUtility.hardWait(1);
		bp3.clickSignUp();
		TestUtility.hardWait(1);
		//Pastikan Error
		bp3.delErrNotif();
		TestUtility.hardWait(3);
	}

}
