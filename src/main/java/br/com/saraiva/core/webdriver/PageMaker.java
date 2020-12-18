package br.com.saraiva.core.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public interface PageMaker {
	public static <T extends PageMaker> T getInstance(Class<T> pageClass, WebDriver driver) {
		try {
			T pageObject = pageClass.getDeclaredConstructor().newInstance();
				PageFactory.initElements(driver, pageObject);
			return pageObject;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
