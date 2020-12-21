#language: pt
#SARAIVA
@Cadastro
Funcionalidade: Cadastro

  Contexto: 
    Dado que o usuario entre no site
    E entre na area de cadastro de cliente

  @SAR_0100 @CadastroCliente
  Cenário: SAR_0100-Cadastro_de_cliente
  	Quando eu clico no botão de cadastrar novo cliente
    E entro os dados de cadastro de cliente
    E submeto o cadastro
    Então valido o cadastro de cliente com sucesso

  @SAR_0101 @ValidaCores
  Cenário: SAR_0101-Valida_cores_pagina
    Então valido as cores da página

  @SAR_0102 @CamposObrigatorios
  Cenário: SAR_0102-Cadastro_de_cliente_incompleto
    Quando eu clico no botão de cadastrar novo cliente
    E entro os dados incompletos na página
    E submeto o cadastro
    Então valido os asteriscos vermelhos em campos obrigatórios
    
  @SAR_0102_BUG @CamposObrigatorios
  Cenário: SAR_0102_BUG-Cadastro_de_cliente_incompleto_CPF
    Quando eu clico no botão de cadastrar novo cliente
    E entro os dados incompletos na página
    E submeto o cadastro
    Então valido os a grafia correta do campo de CPF

  @SAR_0103 @VerificaRadio
  Cenário: SAR_0103-Cadastro_de_cliente_verificar_radio_button
  	Quando eu clico no botão de cadastrar novo cliente
    E entro os dados de cadastro de cliente
    Então valido o radio button de receber ou não ofertas

  @SAR_0104 @ClienteJaCadastrado
  Cenário: SAR_0104-Cadastro_de_cliente_ja_cadastrado
  	Quando eu clico no botão de cadastrar novo cliente
    E entro os dados de cadastro de cliente ja cadastrado
    E submeto o cadastro
    Então valido a mensagem de erro apresentada na tela
    
####### CENÁRIOS ALTERNATIVOS - CASO O CASE APRESENTADO ESTEJA DESATUALIZADO #######

  @SAR_0105 @CamposObrigatorios
  Cenário: SAR_0105-Cadastro_de_cliente_campos_obrigatorios
    Quando eu clico no botão de cadastrar novo cliente
    E entro os dados incompletos na página
    E submeto o cadastro
    Então valido os campos obrigatórios com escritas em vermelho abaixo
    
  @SAR_0106 @CadastroCliente
  Cenário: SAR_0106-Cadastro_de_cliente_verificar_check
  	Quando eu clico no botão de cadastrar novo cliente
    E entro os dados de cadastro de cliente
    Então valido o checkbox de receber ofertas
