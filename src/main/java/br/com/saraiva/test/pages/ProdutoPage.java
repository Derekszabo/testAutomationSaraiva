package br.com.saraiva.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.saraiva.core.webdriver.PageMaker;
import lombok.Getter;

@Getter
public class ProdutoPage implements PageMaker {

	private static final String LIVROSDIGITAISLINK = "https://www.saraiva.com.br/produtos-digitais/livro-digital";

	@FindBy(xpath = "//body/div[@id='app']/div[3]/div[2]/div[1]/div[1]/div[1]/div[7]/div[2]/ul[1]/li[1]/div[1]/a[1]/img[1]")
	WebElement imgPrimeiroItemBuscaLivroFisico;

	@FindBy(xpath = "//body/div[@id='app']/div[3]/div[1]/div[1]/div[5]/section[1]/div[2]/div[1]/div[2]/div[3]/div[1]/ul[1]/li[1]/div[1]/div[1]")
	WebElement imgPrimeiroItemBuscaLivroDigital;

	@FindBy(xpath = "//a[contains(text(),'Produto Físico')]")
	WebElement linkAbaProdutoFisico;

	@FindBy(xpath = "//a[contains(text(),'Produto Digital')]")
	WebElement linkAbaProdutoDigital;

	@FindBy(xpath = "//a[@id='btn-cta-pdp']")
	WebElement btnComprarLivroFisico;

	@FindBy(xpath = "//body/main[@id='pdp-app']/div[9]/div[1]/div[1]/div[3]/a[1]")
	WebElement btnComprarLivroDigital;

	@FindBy(xpath = "//div[@id='descricao']")
	WebElement txtDescricao;

	@FindBy(xpath = "//body/main[@id='pdp-app']/div[3]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement txtCaracteristicas;

	public static String getLivrosdigitaislink() {
		return LIVROSDIGITAISLINK;
	}
}
