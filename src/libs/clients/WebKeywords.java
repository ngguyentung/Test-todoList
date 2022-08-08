package libs.clients;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebKeywords {
	
	static WebLocators webLocators = new WebLocators();
	
	public static WebDriver createChromeDriver(String url) throws Exception {
		String projectPath =System.getProperty("user.dir");
		System.out.println("Project path is: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/jars/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);
		Thread.sleep(3000);
		return driver;
	}
	
	public static void login(WebDriver driver, CharSequence user, CharSequence pass) throws Exception {
		driver.findElement(webLocators.LOGON_GIT).click();
		Thread.sleep(4000);

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);


		// Perform the actions on new window
		WebElement username = driver.findElement(webLocators.USER_ID_TXT);
		username.sendKeys(user);
		WebElement password = driver.findElement(webLocators.PASSWORD_TXT);
		password.sendKeys(pass);

		WebElement login =  driver.findElement(webLocators.LOGON_BTN);
		login.click();
		// Close the new window, if that window no more required
		//driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		Thread.sleep(3000);
	}
	
	public static void addToDoList(WebDriver driver, int num) throws Exception {
		
		for (int i = 1; i <= num; i++) {

			// create a string of uppercase and lowercase characters and numbers
			String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
			String numbers = "0123456789";

			// combine all strings
			String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

			// create random string builder
			StringBuilder sb = new StringBuilder();

			// create an object of Random class
			Random random = new Random();

			// specify length of random string
			int length = 10;

			for(int j = 0; j < length; j++) {

				// generate random index number
				int index = random.nextInt(alphaNumeric.length());

				// get character specified by index
				// from the string
				char randomChar = alphaNumeric.charAt(index);

				// append the character to string builder
				sb.append(randomChar);
			}

			String randomString = sb.toString();

			//Add list 
			WebElement list = driver.findElement(By.xpath("//input[@type='text'][@ng-model='home.list']"));
			list.sendKeys(i+randomString);
			WebElement buttonadd = driver.findElement(By.xpath("//*[@ng-click='home.list && home.add()']"));
			buttonadd.click();
			Thread.sleep(1000);
		}
	}
	
	public static void logout(WebDriver driver) throws Exception {
		driver.findElement(By.xpath("//*[@ng-click='home.signOut()']")).click();
		Thread.sleep(3000);
	}
	
	public static void deleteLastToDoList(WebDriver driver, int num) throws Exception {
		Thread.sleep(3000);
		for(int index = 1; index <= num; index++) {
			WebElement delete = driver.findElement(By.xpath("//li[@class=\"disney1 ng-scope\"][last()]/descendant::button"));
			delete.click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
	}
		public static void loginAgain(WebDriver driver) throws Exception {
			driver.findElement(webLocators.LOGON_GIT).click();
			Thread.sleep(2000);
		}
	
}
