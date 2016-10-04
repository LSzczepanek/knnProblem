package kNNProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHelper {

	static int AMOUNT_OF_PARAMETERS;
	public static String readFile(String fileName) throws IOException {
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
//			 testFile = FileHelper
//			 .readFile("C:/eclipse-java-neon-1-win32-x86_64/workspace/knnProblem/src/resources/test2.txt");
			testFile = FileHelper.readFile("G:/ProjektyEclipse/kNNProblem/src/resources/dane.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
