#language: pt
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Funcionalidade: Cadastro de cliente
  Eu como cliente gostaria de efetuar o cadastro
  Para comprar na loja virtual da Saraiva
  Então a página deve seguir os critérios de aceitação requeridos

  Contexto: Possibilidade de se cadastrar no sistema
    Dado que o usuário entre no site
    E entre na área de cadastro de cliente

  @tag1
  Cenario: SAR_001-Cadastro_de_cliente
  Quando eu entro os dados
  

  @tag2
  Esquema do Cenario: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step
    
    Examples: 
      | CEP  | numeroCasa |
      | 06050150 |     83 |
      | 11702-850 |     3604 | 

