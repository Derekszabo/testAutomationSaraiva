package br.com.saraiva.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.saraiva.core.webdriver.PageMaker;
import lombok.Getter;

@Getter
public class CarrinhoPage implements PageMaker {

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]")
	WebElement imgCarrinhoItem1;

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]")
	WebElement imgCarrinhoItem2;

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]")
	List<WebElement> tblCarrinho;

}
