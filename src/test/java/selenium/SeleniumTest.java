package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SeleniumTest {

	private WebDriver driver;

	private String baseUrl;

	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setup() {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://localhost:8080/helloweb";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testOpeningHomePage() throws Exception {
		this.driver.get("http://www.google.com/");

		List<WebElement> elements = this.driver.findElements(By.name("btnK"));

		System.out.println("elements: " + elements);

		assertTrue("Page not loaded", elements.size() > 0);
	}

	@Ignore
	@Test
	public void test() throws Exception {
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.id("reg:memberForm:name")).clear();
		this.driver.findElement(By.id("reg:memberForm:name")).sendKeys("Brian Leathem");
		this.driver.findElement(By.id("reg:memberForm:email")).clear();
		this.driver.findElement(By.id("reg:memberForm:email")).sendKeys("bleathem@test.ca");
		this.driver.findElement(By.id("reg:memberForm:phoneNumber")).clear();
		this.driver.findElement(By.id("reg:memberForm:phoneNumber")).sendKeys("234234234235");
		this.driver.findElement(By.id("reg:register")).click();

		Thread.sleep(2000);

		try {
			assertEquals("Brian Leathem", this.driver.findElement(By.id("reg:memberTable:0:member_name")).getText());
		} catch (Error e) {
			this.verificationErrors.append(e.toString());
		}
	}

	@After
	public void teardown() {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	// check is element is present on page, fail otherwise
	private void checkElementPresent(By by, String errorMsg) {
		try {
			assertTrue(errorMsg, this.driver.findElement(by) != null);
		} catch (NoSuchElementException e) {
			fail(errorMsg);
		}
	}

	// check is element is present on page, fail otherwise
	private WebElement getElement(By by) {
		try {
			return this.driver.findElement(by);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

}
