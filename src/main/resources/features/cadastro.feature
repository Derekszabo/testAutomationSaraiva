#language: pt

@Cadastro
Funcionalidade: Cadastro de cliente
  Eu como cliente gostaria de efetuar o cadastro
  Para comprar na loja virtual da Saraiva
  Então a página deve seguir os critérios de aceitação requeridos

  Contexto: Possibilidade de se cadastrar no sistema
    Dado que o usuário entre no site
    E entre na área de cadastro de cliente

  @SAR_001 @CadastroCliente
  Esquema do Cenario: SAR_001-Cadastro_de_cliente
  Quando eu entro os dados incluindo CEP <cep> e Número da casa <numeroCasa>
  E submeto o cadastro
  Então valido o cadastro de cliente com sucesso
  
  @SAR_001A @ValidaCores
  Esquema do Cenario: SAR_001A-Valida_cores_pagina
    Então valido as cores da página
    
  @SAR_001B @CadastroClienteIncompleto
  Esquema do Cenario: SAR_001B-Cadastro_de_cliente_incompleto
  Quando eu entro os dados incompletos na página
  E submeto o cadastro
  Então valido os asteriscos vermelhos em campos obrigatórios
  
  @SAR_001C @CadastroCliente
  Esquema do Cenario: SAR_001C-Cadastro_de_cliente_verificar_radio_button
  Quando eu entro os dados incluindo CEP <cep> e Número da casa <numeroCasa>
  Então valido o radio button de receber ou não ofertas
    
    Exemplos: 
      | CEP  | numeroCasa |
      | 06050150 |     83 |
      | 11702850 |     3604 | 

