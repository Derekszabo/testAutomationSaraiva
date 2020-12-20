package br.com.saraiva.test.yaml.service;

import java.util.ArrayList;
import java.util.List;

import br.com.saraiva.core.utils.PropertyReader;
import br.com.saraiva.core.yaml.entity.TestData;
import br.com.saraiva.core.yaml.reader.YamlReader;
import br.com.saraiva.test.yaml.model.MassaYaml;

public abstract class MassaYamlService {

	private static final Class<? extends TestData> DATA_OBJECT = MassaYaml.class;
	private static final String MASSAS_YAML_FILE_PATH = "test-data/massas.yaml";
	private PropertyReader propertyReader;

	protected MassaYamlService(String filePath) {
		this.propertyReader = new PropertyReader(filePath);
	}

	public Object[][] getTestData() {
		List<Object> massas = new ArrayList<>();

		YamlReader reader = new YamlReader(DATA_OBJECT, MASSAS_YAML_FILE_PATH);
		List<TestData> entries = reader.readAllEntries();

		List<Integer> idsMassa = getIdsFromPropertiesFile();

		for (Integer id : idsMassa) {
			massas.add(getEntryById(entries, id));
		}

		return listToArray(massas);
	}

	private TestData getEntryById(List<TestData> entries, Integer id) {
		for (TestData testData : entries) {
			if ((testData instanceof MassaYaml) && (id.equals(((MassaYaml) testData).getId()))) {
				return testData;
			}
		}

		throw new RuntimeException("Massa não encontrada.");
	}

	private List<Integer> getIdsFromPropertiesFile() {
		String property = propertyReader.getProperty("ids");

		if ("".equals(property)) {
			throw new RuntimeException("Properties não tem ids para massa");
		}

		List<Integer> intList = new ArrayList<>();

		String[] split = property.replace(" ", "").split(",");
		for (String string : split) {
			intList.add(Integer.parseInt(string));
		}

		return intList;
	}

	private Object[][] listToArray(List<? extends Object> listaMassaDeDados) {
		Object[][] arrayMassa = new Object[listaMassaDeDados.size()][];

		for (int i = 0; i < listaMassaDeDados.size(); i++)
			arrayMassa[i] = new Object[] { listaMassaDeDados.get(i) };

		return arrayMassa;
	}
}
