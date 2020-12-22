package br.com.saraiva.test.runners;

import br.com.saraiva.test.runners.hooks.TestNGHooks;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "classpath:features", //
		glue = "br.com.saraiva.test.steps", //
		tags = "@SAR_0101", //
		plugin = { "json:target/cucumber-report/cucumber.json" }, //
		monochrome = true, //
		dryRun = false, //
		snippets = SnippetType.CAMELCASE //

)
public class CadastroRunner extends TestNGHooks {

}
