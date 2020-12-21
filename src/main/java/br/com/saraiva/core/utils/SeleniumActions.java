package br.com.saraiva.core.utils;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SeleniumActions {

	private static final Integer DEFAULTPOLLINGSECONDS = 1;
	private static final Integer DEFAULTTIMEOUTSECONDS = 15;
	private WebDriver driver;

	public SeleniumActions(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	private WebElement fluentlyWaitUntilClickable(WebElement element, Integer timeoutInSeconds,
			Integer pollingInSeconds) {
		return (new FluentWait<WebDriver>(driver)) //
				.withTimeout(Duration.ofSeconds(timeoutInSeconds)) //
				.pollingEvery(Duration.ofSeconds(pollingInSeconds)) //
				.ignoring(StaleElementReferenceException.class) //
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement fluentlyWaitUntilClickable(WebElement element) {
		return fluentlyWaitUntilClickable(element, DEFAULTTIMEOUTSECONDS, DEFAULTPOLLINGSECONDS);
	}

	public void click(WebElement webElement) {
		webElement = fluentlyWaitUntilClickable(webElement);
		webElement.click();
	}

	public void insertText(WebElement element, String value) {
		this.waitForElementToBeDisplayed(element);
		element.clear();
		element.sendKeys(value);
	}

	public Boolean waitForElementToBeDisplayed(WebElement element) {
		return fluentlyWaitUntilClickable(element).isDisplayed();
	}

	public Boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String readFromElement(WebElement element) {
		return element.getText();
	}

	public void switchToWindow(int indiceDaAba) {
		try {
			List<String> abas = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(abas.get(indiceDaAba));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds");
		}
	}

	public void closeCurrentWindow() {
		driver.close();
	}

	public File getScreenshot() {
		try {
			return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE);
		} catch (Exception e) {
			System.out.println("screeshot failed");
			return null;
		}
	}

	public Boolean waitForElementToDissapear(WebElement element, Integer secondsTimeout) {
		lowerTimeouts();
		Boolean dissapeared = false;
		Integer counter = 0;
		try {
			while (counter < secondsTimeout && Boolean.FALSE.equals(dissapeared)) {
				if (!element.isDisplayed()
						|| (element.getSize().getWidth() == 0 && element.getSize().getHeight() == 0)) {
					dissapeared = true;
				}
				sleep(1);
				counter++;
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			dissapeared = true;
		}
		raiseTimeouts();
		return dissapeared;
	}

	public void sleep(Integer seconds) {
		try {
			Thread.sleep(seconds * 1000l);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	public void raiseTimeouts() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void lowerTimeouts() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
	}

	public void validate(boolean variable) {
		assertTrue(variable);
	}

	public void validate(WebElement element) {
		waitForElementToBeDisplayed(element);
		assertTrue(isDisplayed(element));
	}

	public void insertKey(WebElement element, Keys key) {
		this.fluentlyWaitUntilClickable(element).sendKeys(key);
	}

	public void sendTab(WebElement element) {
		insertKey(element, Keys.TAB);
	}

	public void closeAllOtherTabs() {
		try {
			Set<String> tabs = driver.getWindowHandles();
			Iterator<String> iter = tabs.iterator();
			String[] tabNames = new String[tabs.size()];
			int i = 0;
			while (iter.hasNext()) {
				tabNames[i] = iter.next();
				i++;
			}

			if (tabNames.length > 1) {
				for (i = tabNames.length; i > 1; i--) {
					driver.switchTo().window(tabNames[i - 1]);
					driver.close();
				}
			}
			driver.switchTo().window(tabNames[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void failTest() {
		fail();
	}

	public void scroll(WebElement element) {
		executeJS("arguments[0].scrollIntoView(true);", element);
	}

	public Object executeJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}
}
