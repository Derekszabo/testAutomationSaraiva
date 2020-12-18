package br.com.saraiva.test.support;

import br.com.saraiva.core.utils.SeleniumActions;
import br.com.saraiva.core.webdriver.DriverManager;
import br.com.saraiva.core.webdriver.DriverManagerFactory;

public class Context {
	private static SeleniumActions web;
	private static DriverManager driverManager;
	
	public void setup() {
		driverManager = DriverManagerFactory.getDriver();
		web = new SeleniumActions(driverManager.getDriver());
	}
	
	public static SeleniumActions web() {
		if (web == null)
			throw new RuntimeException("Context was not setup, call Context.setup()");
		return web;
	}
}
