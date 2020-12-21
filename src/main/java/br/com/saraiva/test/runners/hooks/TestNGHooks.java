package br.com.saraiva.test.runners.hooks;

import static br.com.saraiva.test.steps.support.Context.gen;
import static br.com.saraiva.test.steps.support.Context.web;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apiguardian.api.API;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.saraiva.core.webdriver.DriverManagerFactory;
import br.com.saraiva.core.yaml.entity.TestData;
import br.com.saraiva.test.steps.support.Context;
import br.com.saraiva.test.yaml.YamlDataManager;
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

	@Test(groups = "cucumber", description = "Cucumber IBPF Scenarios", dataProvider = "mergedScenariosTestData")
	public void runScenario(TestData testData, PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper)
			throws Throwable {
		testName = pickleWrapper.toString().replace("\"", "");
		Context.setTestData(testData);
		Context.setup();
		System.out.println(featureWrapper.toString() + ": " + testName);
		testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
	}

	@AfterMethod(alwaysRun = true)
	public void afterScenario(ITestResult result, ITestContext context) throws Exception {
		String status = "Passed";
		if (!result.isSuccess()) {
			status = "Failed";
		}
		System.out.println("Test Status: " + status);
		gen().saveEvidence(testName, status.toString().toUpperCase(), web().getScreenshot());
		web().closeAllOtherTabs();
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

	/**
	 * Data provider que combina os cenários vindos do data provider padrão do
	 * cucumber com o data provider da massa de dados para execução de todos
	 * cenários para todas massas
	 * 
	 * @return array com os cenários e massas
	 */
	@DataProvider(name = "mergedScenariosTestData")
	public Object[][] mergedScenariosMassaDeDados() {
		Object[][] combined = combine(testData(), scenarios());
		System.out.println("Total de testes a serem executados: " + combined.length);
		return combined;
	}

	@DataProvider(name = "scenariosCucumber")
	public Object[][] scenarios() {
		if (testNGCucumberRunner == null) {
			return new Object[0][0];
		}
		return testNGCucumberRunner.provideScenarios();
	}

	/**
	 * Data provider que usa o leitor de yaml para capturar as massas
	 * 
	 * @return array com as massas no arquivo
	 */
	@DataProvider(name = "testData")
	public Object[][] testData() {
		try {
			// aqui está passando o nome da classe runner, para que seja feito o
			// carregamento do property
			return YamlDataManager.getTestData(this.getClass().getSimpleName());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Método para combinar dois arrays em um só
	 * 
	 * @param a1
	 * @param a2
	 * @return array com a combinação dos dois arrays
	 */
	protected static Object[][] combine(Object[][] a1, Object[][] a2) {
		List<Object[]> objectCodesList = new LinkedList<>();
		for (Object[] o : a1) {
			for (Object[] o2 : a2) {
				objectCodesList.add(concatAll(o, o2));
			}
		}
		return objectCodesList.toArray(new Object[0][0]);
	}

	@SafeVarargs
	protected static <T> T[] concatAll(T[] first, T[]... rest) {
		// calculate the total length of the final object array after the concat
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}

		// copy the first array to result array and then copy each array completely to
		// result
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}

		return result;
	}

}
