package br.com.saraiva.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.saraiva.core.webdriver.PageMaker;

public class CadastroPage implements PageMaker {

	@FindBy(xpath = "//a[contains(text(),'CADASTRAR')]")
	WebElement btnCadastrar;

	@FindBy(xpath = "//input[@id='InputNome1']")
	WebElement fldNome;

	@FindBy(xpath = "//input[@id='InputSobrenome1']")
	WebElement fldSobrenome;

	@FindBy(xpath = "//input[@id='InputEmail1']")
	WebElement fldEmail;

	@FindBy(xpath = "//input[@id='InputSenha1']")
	WebElement fldSenha;

	@FindBy(xpath = "//input[@id='InputConfirmeSenha1']")
	WebElement fldConfirmaSenha;

	@FindBy(xpath = "//input[@id='InputCpf1']")
	WebElement fldCPF;

	@FindBy(xpath = "//label[contains(text(),'Masculino')]")
	WebElement rbMasculino;

	@FindBy(xpath = "//input[@id='InputDataNascimento1']")
	WebElement fldDataNascimento;

	@FindBy(xpath = "//input[@id='InputCep1']")
	WebElement fldCEP;

	@FindBy(xpath = "//input[@id='InputNumero1']")
	WebElement fldNumeroCasa;

	@FindBy(xpath = "//input[@id='InputTelefone1']")
	WebElement fldTelefone;

	@FindBy(xpath = "//button[@id='FinalizarCadastro1']")
	WebElement btnFinalizarCadastro;

}
