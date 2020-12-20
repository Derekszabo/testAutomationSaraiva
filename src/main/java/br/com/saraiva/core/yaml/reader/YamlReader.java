package br.com.saraiva.core.yaml.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import br.com.saraiva.core.yaml.entity.TestData;

public class YamlReader {

	private Yaml yaml;
	private String yamlFile;

	public YamlReader(Class<? extends TestData> dataObject, String yamlFile) {
		this.yamlFile = yamlFile;
		this.yaml = new Yaml(new Constructor(dataObject));
	}

	public List<TestData> readAllEntries() {
		ArrayList<TestData> list = new ArrayList<>();
		try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(yamlFile)) {
			for (Object m : yaml.loadAll(is)) {
				list.add((TestData) m);
			}

		} catch (Exception e) {
			throw new RuntimeException("Error reading file: " + e.getMessage());
		}

		return list;
	}
}