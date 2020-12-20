package br.com.saraiva.test.yaml;

import br.com.saraiva.test.yaml.service.CadastroTestData;
import br.com.saraiva.test.yaml.service.CompraTestData;

public class YamlDataManager {
	private YamlDataManager() {
	}

	public static Object[][] getTestData(String simpleName) {
		String dataName = simpleName.replace("Runner", "");

		switch (dataName.toUpperCase()) {
		case "CADASTRO":
			return new CadastroTestData().getTestData();
		case "COMPRA":
			return new CompraTestData().getTestData();
		default:
			throw new RuntimeException(
					"Arquivo de massa " + simpleName + " não encontrada, verificar nome da classe Runner");
		}
	}
}
