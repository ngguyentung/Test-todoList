package script.test;

import org.openqa.selenium.WebDriver;
import libs.clients.WebKeywords;
import testData.UserData;

/**
 * Procedure:
1. Login using your github account. 
2. create 10 to do list with random strings 
3. upon completion log out. 
4. Login again with the same account. 
5. Delete your list from 5 - 10. 
6. Logout upon completion
 * 
 * @author TungNguyen
 * Complete
 */



public class Test {

	static UserData userdata = new UserData();
	WebKeywords webKeyword = new WebKeywords();
	static WebDriver webDriver;
	
	public static void main(String[] args) throws Exception {
		
		webDriver = WebKeywords.createChromeDriver(userdata.URL);
		WebKeywords.login(webDriver, userdata.USERNAME, userdata.PASS);
		WebKeywords.addToDoList(webDriver, userdata.NUM_TO_ADD);
		WebKeywords.logout(webDriver);
		WebKeywords.loginAgain(webDriver);
		WebKeywords.deleteLastToDoList(webDriver, userdata.NUM_TO_DELETE);
		WebKeywords.logout(webDriver);
	}
}


