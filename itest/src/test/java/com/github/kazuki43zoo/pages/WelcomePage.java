package com.github.kazuki43zoo.pages;


import com.github.kazuki43zoo.parts.LanguagePullDown;
import com.github.kazuki43zoo.parts.LeftMenu;
import com.github.kazuki43zoo.parts.UserMenuPullDown;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.github.kazuki43zoo.utils.PageOperations.loadNextPage;
import static com.github.kazuki43zoo.utils.WebElementOperations.input;

@Getter
public class WelcomePage implements Page<WelcomePage> {

	private final WebDriver driver;

	@CacheLookup
	@FindBy(id = "username")
	private WebElement username;

	@CacheLookup
	@FindBy(id = "password")
	private WebElement password;

	@CacheLookup
	@FindBy(id = "loginBtn")
	private WebElement loginBtn;

	@CacheLookup
	@FindBy(className = "alert")
	private WebElement alert;

	@CacheLookup
	@FindBy(id = "welcomeMessage")
	private WebElement welcomeMessage;

	private UserMenuPullDown<WelcomePage> userMenuPullDown;
	private LanguagePullDown<WelcomePage> languagePullDown;
	private LeftMenu<WelcomePage> leftMenu;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		reload();
	}

	@Override
	public WelcomePage reload() {
		PageFactory.initElements(driver, this);
		this.userMenuPullDown = new UserMenuPullDown<>(driver, this);
		this.languagePullDown = new LanguagePullDown<>(driver, this);
		this.leftMenu = new LeftMenu<>(driver, this);
		return this;
	}

	public WelcomePage username(String value) {
		return input(this, this.username, value);
	}

	public WelcomePage password(String value) {
		return input(this, this.password, value);
	}

	public WelcomePage login() {
		return login(WelcomePage.class);
	}

	public <T extends Page<T>> T login(Class<T> nextPage) {
		this.loginBtn.click();
		return loadNextPage(this, nextPage, driver);
	}

}
