package br.com.saraiva.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.saraiva.core.webdriver.PageMaker;
import lombok.Getter;

@Getter
public class LoginPage implements PageMaker {

	@FindBy(xpath = "//input[@id='username']")
	WebElement fldEmailLogin;

	@FindBy(xpath = "//input[@id='password']")
	WebElement fldSenhaLogin;

	@FindBy(xpath = "//a[contains(text(),'CADASTRAR')]")
	WebElement btnCadastrar;

	@FindBy(xpath = "//button[@id='submit-1']")
	WebElement btnEntrar;

	@FindBy(xpath = "//button[@id='submit-1']")
	WebElement btnEntrarOuCadastrar;

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

	@FindBy(xpath = "//label[contains(text(),'Feminino')]")
	WebElement rbFeminino;

	@FindBy(xpath = "//input[@id='InputDataNascimento1']")
	WebElement fldDataNascimento;

	@FindBy(xpath = "//input[@id='InputCep1']")
	WebElement fldCEP;

	@FindBy(xpath = "//input[@id='InputNumero1']")
	WebElement fldNumeroCasa;

	@FindBy(xpath = "//input[@id='InputCelular1']")
	WebElement fldCelular;

	@FindBy(xpath = "//input[@id='InputTelefone1']")
	WebElement fldTelefone;

	@FindBy(xpath = "//button[@id='FinalizarCadastro1']")
	WebElement btnFinalizarCadastro;

	@FindBy(xpath = "//body/div[2]")
	WebElement header;

	@FindBy(xpath = "//header/h1[1]/a[1]/*[1]")
	WebElement btnHeader;

	@FindBy(xpath = "/html/body/div[1]/img")
	WebElement imgLoadScreen;

	@FindBy(xpath = "//p[contains(text(),'Usuário Cadastrado com sucesso')]")
	WebElement popValidacao;

	@FindBy(xpath = "//div[contains(text(),'Desculpe houve um erro no seu cadastro tente novam')]")
	WebElement msgErroCadastro;

	@FindBy(xpath = "//small[contains(text(),'*')]")
	WebElement lblAsterisco;

	@FindBy(xpath = "//input[@id='InputOfertasPromocionais1']")
	WebElement chkOfertas;

	/* LABELS VERMELHAS ABAIXO DOS CAMPOS */

	@FindBy(xpath = "//small[contains(text(),'Informe o nome')]")
	WebElement lblErroNome;

	@FindBy(xpath = "//small[contains(text(),'Informe o sobrenome')]")
	WebElement lblErroSobrenome;

	@FindBy(xpath = "//small[contains(text(),'Informe um e-mail válido')]")
	WebElement lblErroEmail;

	@FindBy(xpath = "//small[contains(text(),'Informe uma senha')]")
	WebElement lblErroSenha;

	@FindBy(xpath = "//small[contains(text(),'Confirme a senha')]")
	WebElement lblErroConfirmeSenha;

	@FindBy(xpath = "//small[contains(text(),'Inform um CPF válido')]")
	WebElement lblErroCPFErrado;

	@FindBy(xpath = "//small[contains(text(),'Escolha uma opção')]")
	WebElement lblErroSexo;

	@FindBy(xpath = "//small[contains(text(),'Informe uma data válida')]")
	WebElement lblErroData;

	@FindBy(xpath = "//small[contains(text(),'Informe um número de telefone válido')]")
	WebElement lblErroTelefone;

	@FindBy(xpath = "//small[contains(text(),'Informe um CEP válido')]")
	WebElement lblErroCEP;

}
