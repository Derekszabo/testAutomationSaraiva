package br.com.saraiva.test.support;

import br.com.saraiva.core.utils.EvidencesGenerator;
import br.com.saraiva.core.utils.SeleniumActions;
import br.com.saraiva.core.webdriver.DriverManager;
import br.com.saraiva.core.webdriver.DriverManagerFactory;

public class Context {
	private static SeleniumActions web;
	private static EvidencesGenerator gen;
	private static DriverManager driverManager;
	private static String testName;

	public static void setup() {
		driverManager = DriverManagerFactory.getDriver();
		web = new SeleniumActions(driverManager.getDriver());
	}

	public static SeleniumActions web() {
		if (web == null)
			throw new RuntimeException("Context was not setup, call Context.setup()");
		return web;
	}

	public static EvidencesGenerator gen() {
		if (gen == null)
			throw new RuntimeException("Unable to create evidence");
		return gen;
	}
}
