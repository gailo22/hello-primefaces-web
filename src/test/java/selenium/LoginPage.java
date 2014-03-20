package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage loginAs(String username, String password) {
		this.driver.findElement(By.id("username")).sendKeys(username);
		this.driver.findElement(By.id("passwd")).sendKeys(password);
		this.driver.findElement(By.id("login")).submit();

		return new HomePage(this.driver);
	}
}
