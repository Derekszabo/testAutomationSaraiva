#language: pt
#SARAIVA
@BuscaProduto
Funcionalidade: BuscaProduto
	Eu como cliente do site saraiva.com.br
	Quero pesquisar livros digitais e fisicos
	Para que eu possa adicioná-los ao carrinho e comprá-los

  Contexto: 
    Dado que o usuario entre no site
    E entre na area de cadastro de cliente
    E efetue login
    

  @SAR_TESTE @BuscaLivro
  Cenário: SAR_TESTE-Busca_livro_fisico
  	Quando busco pelo livro "harry poter" e submeto
    E clico no primeiro resultado apresentado de livros fisicos
    Então valido a opção de livro digital ao lado da opcao livro fisico
    Quando busco por livros digitais
    E clico no primeiro resultado apresentado de livros digitais
    E adiciono no carrinho o livro "digital"
    Quando busco pelo livro "harry poter" e submeto
    E clico no primeiro resultado apresentado de livros fisicos
    E adiciono no carrinho o livro "fisico"
    Então testo isso

  @SAR_0200 @BuscaLivro
  Cenário: SAR_0200-Busca_livro_fisico
  	Quando busco pelo livro "harry poter" e submeto
    E clico no primeiro resultado apresentado de livros fisicos
    Então valido a opção de livro digital ao lado da opcao livro fisico

  @SAR_0201 @BuscaLivroDigital
  Cenário: SAR_0201-Busca_livro_digital
  	Quando busco por livros digitais
    E clico no primeiro resultado apresentado de livros digitais
    Então valido a opção de livro fisico ao lado da opcao livro digital

  @SAR_0202 @BuscaLivroDigital
  Cenário: SAR_0202-Busca_livro_digital_descricao
  	Quando busco por livros digitais
    E clico no primeiro resultado apresentado de livros digitais
    Então valido a descrição do produto

  @SAR_0203 @BuscaLivroDigital
  Cenário: SAR_0203-Busca_livro_digital_caracteristicas
  	Quando busco por livros digitais
    E clico no primeiro resultado apresentado de livros digitais
    Então valido as caracteristicas do produto

  @SAR_0204 @ValidaBug
  Cenário: SAR_0203-Busca_livro_digital_caracteristicas
  	Quando busco por livros digitais
    E clico no primeiro resultado apresentado de livros digitais
    E adiciono no carrinho o livro "digital"
    Quando busco pelo livro "harry poter" e submeto
    E clico no primeiro resultado apresentado de livros fisicos
    E adiciono no carrinho o livro "fisico"
    Então valido que não posso ter um produto fisico e um digital no mesmo carrinho

