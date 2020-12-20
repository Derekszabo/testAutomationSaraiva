package br.com.saraiva.test.yaml.model;

import br.com.saraiva.core.yaml.entity.TestData;
import lombok.Data;

@Data
public class MassaYaml implements TestData {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private String telefone;
	private String CEP;
	private String numeroCasa;
}
