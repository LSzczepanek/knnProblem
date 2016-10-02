package kNNProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHelper {

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

}
