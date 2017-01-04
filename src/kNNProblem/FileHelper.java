package kNNProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHelper {

	static int AMOUNT_OF_PARAMETERS;
	private static String readFile(String fileName) throws IOException {
		BufferedReader br;

		br = new BufferedReader(new FileReader(fileName));

		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		String everything = sb.toString();

		br.close();
		return everything;

	}

	static String[] getPreparedFile() {
		String testFile = null;
		try {
			testFile = FileHelper.readFile("src/resources/daneNorm.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String [] amountOfObjects = testFile.split("\\n");
		testFile = testFile.replaceAll("\\r", ",");
		testFile = testFile.replaceAll("\\n", "");
		String[] separatedString = testFile.split(",");
		AMOUNT_OF_PARAMETERS = separatedString.length/amountOfObjects.length;
		return separatedString;
	}

}
