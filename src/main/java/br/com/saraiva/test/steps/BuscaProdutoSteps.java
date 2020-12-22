package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.CarrinhoLogic;
import br.com.saraiva.test.logic.HomeLogic;
import br.com.saraiva.test.logic.ProdutoLogic;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class BuscaProdutoSteps {

	ProdutoLogic prod;
	CarrinhoLogic car;
	HomeLogic home;

	public BuscaProdutoSteps() {
		prod = new ProdutoLogic();
		car = new CarrinhoLogic();
		home = new HomeLogic();
	}

	@Quando("busco pelo livro {string} e submeto")
	public void busco_pelo_livro_e_submeto(String livro) {
		home.buscaProduto(livro);
	}

	@Quando("clico no primeiro resultado apresentado de livros fisicos")
	public void clico_no_primeiro_resultado_apresentado_de_livros_fisicos() {
		prod.clicaPrimeiroLivroFisico();
	}

	@Quando("clico no primeiro resultado apresentado de livros digitais")
	public void clico_no_primeiro_resultado_apresentado_de_livros_digitais() {
		prod.clicaPrimeiroLivroDigital();
	}

	@Quando("busco por livros digitais")
	public void busco_por_livros_digitais() {
		prod.buscaLivroDigital();
	}

	@Quando("adiciono no carrinho o livro {string}")
	public void adiciono_no_carrinho_o_livro(String midia) {
		prod.adicionaNoCarrinho(midia);
	}

	@Então("testo isso")
	public void testo_isso() {
		car.testoIsso();
	}

	@Então("valido a opção de livro digital ao lado da opcao livro fisico")
	public void valido_a_opção_de_livro_digital_ao_lado_da_opcao_livro_fisico() {
		prod.validaAbaLivroDigital();
	}

	@Então("valido a opção de livro fisico ao lado da opcao livro digital")
	public void valido_a_opção_de_livro_fisico_ao_lado_da_opcao_livro_digital() {
		prod.validaAbaLivroFisico();
	}

	@Então("valido a descrição do produto")
	public void valido_a_descrição_do_produto() {
		prod.validaDescricao();
	}

	@Então("valido as caracteristicas do produto")
	public void valido_as_caracteristicas_do_produto() {
		prod.validaCaracteristicas();
	}

	@Então("valido que não posso ter um produto fisico e um digital no mesmo carrinho")
	public void valido_que_não_posso_ter_um_produto_fisico_e_um_digital_no_mesmo_carrinho() {
		car.validaErroProdutosCarrinho();
	}

}
