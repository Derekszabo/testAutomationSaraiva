#language: pt
#SARAIVA
@Cadastro
Funcionalidade: Cadastro

  Contexto: 
    Dado que o usuario entre no site
    E entre na area de cadastro de cliente

  @SAR_001 @CadastroCliente
  Cenário: SAR_001-Cadastro_de_cliente
    Quando eu entro os dados de cadastro de cliente
    E submeto o cadastro
    Então valido o cadastro de cliente com sucesso

  @SAR_001A @ValidaCores
  Cenário: SAR_001A-Valida_cores_pagina
    Então valido as cores da página

  @SAR_001B @CadastroClienteIncompleto
  Cenário: SAR_001B-Cadastro_de_cliente_incompleto
    Quando eu entro os dados incompletos na página
    E submeto o cadastro
    Então valido os asteriscos vermelhos em campos obrigatórios

  @SAR_001C @CadastroCliente
  Cenário: SAR_001C-Cadastro_de_cliente_verificar_radio_button
    Quando eu entro os dados de cadastro de cliente
    Então valido o radio button de receber ou não ofertas
