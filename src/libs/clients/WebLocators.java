package libs.clients;

import org.openqa.selenium.By;

public class WebLocators {
	//LOGIN PAGE
	public By USER_ID_TXT													=	By.xpath("//*[@id='login_field'][@class='form-control input-block js-login-field']");
	public By PASSWORD_TXT													=	By.id("password");
	public By LOGON_GIT														=	By.xpath("//*[@class='btn btn-social btn-github']");
	public By LOGON_BTN														=	By.xpath("//*[@type='submit'][@name='commit']");

	//LOGOUT PAGE
	public By LOGOUT_BTN													=	By.xpath("//span[text()='Log Out']");
	//ADD + DELETE LIST
	public By TODO_LIST												 		=	By.xpath("//*[@type='text'][@ng-model='home.list']");
	public By ADD_BTN														=	By.xpath("//*[@ng-click='home.list && home.add()']");
	public By DELETE_BTN													=	By.xpath("//li[@class=\"disney1 ng-scope\"][last()]/descendant::button");
	
}
