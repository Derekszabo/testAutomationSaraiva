package br.com.saraiva.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.saraiva.core.webdriver.PageMaker;
import lombok.Getter;

@Getter
public class HomePage implements PageMaker {

	private static final String HOMEPAGELINK = "https://www.saraiva.com.br/";

	@FindBy(xpath = "//a[@id='link-account']")
	WebElement btnLogin;

	@FindBy(id = "vtexIdUI-saraiva-oauth")
	WebElement btnEntreOuCadastreSe;

	@FindBy(xpath = "//header/div[1]/div[3]/div[1]/div[1]/linx-impulse-autocomplete[1]")
	WebElement fldBusca;

	public static String getHomepagelink() {
		return HOMEPAGELINK;
	}

}
