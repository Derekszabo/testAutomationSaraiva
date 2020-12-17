package br.com.saraiva.core.webdriver;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupChrome extends DriverManager{
	
	@Override
	void createDriver() {
		WebDriverManager.chromedriver().setup();
		try {
			webDriver = new ChromeDriver(setupChromeOptions());
			webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	private static ChromeOptions setupChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setCapability("applicationCacheEnabled", false);
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("useAutomationExtension", false);
		options.setExperimentalOption("prefs", preferences);
		options.addArguments("--test-name", "--test-type", "--no-check-default-driver", "--reduce-security-for-testing",
				"--allow-running-insecure-content", // Aceita certificados SSL self-signed
				"--disable-web-security", // Permite chamadas Ajax CORS
				"--no-first-run", // Evita que o chrome abra popups na inicialização
				"--disable-popup-blocking", "--disable-infobars", "--testing-fixed-https-port", "--start-maximized",
				"--disable-extensions");
		return options;
	}
	
	@Override
	public void tearDown() {
		super.tearDown();
		try {
			Runtime.getRuntime().exec("wmic process where name=\"chromedriver.exe\" call terminate").waitFor();
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
