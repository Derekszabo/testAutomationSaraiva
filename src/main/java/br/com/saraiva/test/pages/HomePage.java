package br.com.saraiva.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.saraiva.core.webdriver.PageMaker;
import lombok.Getter;

@Getter
public class HomePage implements PageMaker {

	@FindBy(id = "link-account")
	WebElement btnLogin;

	@FindBy(id = "vtexIdUI-saraiva-oauth")
	WebElement btnEntreOuCadastreSe;
}
