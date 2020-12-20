package br.com.saraiva.test.steps.support;

import br.com.saraiva.core.utils.EvidencesGenerator;
import br.com.saraiva.core.utils.SeleniumActions;
import br.com.saraiva.core.webdriver.DriverManager;
import br.com.saraiva.core.webdriver.DriverManagerFactory;
import br.com.saraiva.core.yaml.entity.TestData;
import br.com.saraiva.test.yaml.model.MassaYaml;

public class Context {
	private static SeleniumActions web;
	private static EvidencesGenerator gen;
	private static DriverManager driverManager;
	private static String testName;
	private static TestData testData;
	private static MassaYaml massa;

	public static void setup() {
		driverManager = DriverManagerFactory.getDriver();
		web = new SeleniumActions(driverManager.getDriver());
		massa = (MassaYaml) Context.testData();
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

	public static void setTestData(TestData td) {
		testData = td;
	}

	public static TestData testData() {
		if (testData == null)
			throw new RuntimeException("Test data is empty");
		return testData;
	}
}
