package br.com.saraiva.test.runners.hooks;

import org.apiguardian.api.API;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.saraiva.core.webdriver.DriverManagerFactory;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@API(status = API.Status.STABLE)
public abstract class TestNGHooks {
	String testName;
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		System.out.println("Before class...");
		try {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		} catch (Exception e) {
			System.out.println("Error instantiating TestNGCucumberRunner: " + e.getMessage());
		}
	}

	@Test(groups = "cucumber", description = "Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
		// testName = pickleWrapper.toString();
		// Context.setup();
		// System.out.println(featureWrapper.toString() + ": " + testName);
		testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
	}

	@AfterMethod(alwaysRun = true)
	public void afterScenario(ITestResult result, ITestContext context) throws Exception {
		String status = "Passed";
		if (!result.isSuccess()) {
			status = "Failed";
		}
		System.out.println("Test Status: " + status);
		// gen().saveEvidence(testName, status.toString().toUpperCase());
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		System.out.println("After Class...");
		if (testNGCucumberRunner == null) {
			return;
		}
		testNGCucumberRunner.finish();
		System.out.println("Tearing down Driver Manager...");
		DriverManagerFactory.tearDownCurrentManagerIfExistent();
	}

	@DataProvider
	public Object[][] scenarios() {
		if (testNGCucumberRunner == null) {
			return new Object[0][0];
		}
		return testNGCucumberRunner.provideScenarios();
	}

}
