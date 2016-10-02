package kNNProblem;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testFile = null;
		ObjectToUse[] testFiles = new ObjectToUse[25];
		System.out.println("Program will show how good or how bad the kNN Algorythm it is for such a data like IRYS");
		try {
			testFile = FileHelper.readFile("G:\\ProjektyEclipse\\kNNProblem\\src\\resources\\test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testFile = testFile.replaceAll("\\r", ",");
		testFile = testFile.replaceAll("\\n", "");
		System.out.println(testFile);
		String[] separatedString = testFile.split(",");
		//testFiles[0] = new ObjectToUse();
		
//		System.out.println(separatedString2[0]);
//		System.out.println(separatedString2[1]);
//		System.out.println(separatedString2[2]);
		for (int i=0 , j=0; j <25; i+=3, j++) {
			testFiles[j] = new ObjectToUse(Double.parseDouble(separatedString[i]),
					Double.parseDouble(separatedString[i+1]), 
					0.0, 
					0.0, 
					separatedString[i+2]);
		}
		
		for (ObjectToUse t : testFiles)
		System.out.println(t.toString());
	}

}
