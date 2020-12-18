package br.com.saraiva.test.runners;

import br.com.saraiva.test.runners.hooks.TestNGHooks;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/main/resources/features", //
		glue = "steps", //
		tags = "@Cadastro", //
		plugin = { "json:target/cucumber-report/cucumber.json" }, //
		monochrome = true, //
		snippets = SnippetType.CAMELCASE //

)
public class CadastroRunner extends TestNGHooks {

}