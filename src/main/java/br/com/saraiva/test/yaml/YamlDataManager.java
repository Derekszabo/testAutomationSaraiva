package br.com.saraiva.test.yaml;

import br.com.saraiva.test.yaml.service.BuscaProdutoTestData;
import br.com.saraiva.test.yaml.service.CadastroTestData;

public class YamlDataManager {
	private YamlDataManager() {
	}

	public static Object[][] getTestData(String simpleName) {
		String dataName = simpleName.replace("Runner", "");

		switch (dataName.toUpperCase()) {
		case "CADASTRO":
			return new CadastroTestData().getTestData();
		case "BUSCAPRODUTO":
			return new BuscaProdutoTestData().getTestData();
		default:
			throw new RuntimeException(
					"Arquivo de massa " + simpleName + " não encontrada, verificar nome da classe Runner");
		}
	}
}
