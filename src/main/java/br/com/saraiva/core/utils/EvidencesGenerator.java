package br.com.saraiva.core.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;

public class EvidencesGenerator {

	public void saveEvidence(String testName, String status, File file) throws IOException {
		File srcFile = createDirectoryIfDontExists();
		String fileName = srcFile.toString() + "/" + testName + "_" + getFormattedDate("yyyyMMdd") + "_"
				+ getFormattedDate("HHmm") + "_" + status + ".jpg";
		FileUtils.copyFile(file, new File(fileName));

	}

	private File createDirectoryIfDontExists() {

		File fileDirectory = new File("./evidences");
		if (!fileDirectory.exists()) {
			fileDirectory.mkdir();
		}
		return fileDirectory;
	}

	public static String getFormattedDate(String pattern) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}

}
