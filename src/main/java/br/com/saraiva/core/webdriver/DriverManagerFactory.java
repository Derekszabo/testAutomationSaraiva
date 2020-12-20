package br.com.saraiva.core.webdriver;

public class DriverManagerFactory {

	private DriverManagerFactory() {

	}

	private static DriverManager driverManager;

	public static DriverManager getDriver() {
		driverManager = new SetupChrome();
		return driverManager;

	}

	public static void tearDownCurrentManagerIfExistent() {
		if (driverManager != null) {
			driverManager.tearDown();
		}
	}

}
