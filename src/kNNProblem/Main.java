package kNNProblem;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KNNAlgorythm testVersion = new KNNAlgorythm();
		String testFile = null;
		System.out.println("Program will show how good or how bad the kNN Algorythm it is for such a data like IRYS");
		try {
			testFile = FileHelper
					.readFile("C:/eclipse-java-neon-1-win32-x86_64/workspace/knnProblem/src/resources/test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testFile = testFile.replaceAll("\\r", ",");
		testFile = testFile.replaceAll("\\n", "");
		System.out.println(testFile);
		String[] separatedString = testFile.split(",");

		kNNData[] testFiles = new kNNData[separatedString.length / 3];

		// kNNData[] test2 = new kNNData[2];
		// test2[0] = new kNNData(4,0,0,0,"D");
		// test2[1] = new kNNData(0,0,0,0,"D");
		// System.out.println(KNNAlgorythm.calculateEuklidesDistance(testData,
		// testData2));

		// testFiles[0] = new ObjectToUse();

		// System.out.println(separatedString2[0]);
		// System.out.println(separatedString2[1]);
		// System.out.println(separatedString2[2]);
		for (int i = 0, j = 0; j < testFiles.length; i += 3, j++) {
			testFiles[j] = new kNNData(Double.parseDouble(separatedString[i]),
					Double.parseDouble(separatedString[i + 1]), 0.0, 0.0, separatedString[i + 2], testFiles.length);
		}

		testVersion.calculateAllDistancesToTheAllPoints(testFiles);
		int i = -1;
		for (double n : testFiles[0].distance) {
			System.out.println(++i + ". : " + n);

		}
		for (int z = 0; z < 5; z++)
			System.out.println(testFiles[0].closest[z]);

		// System.out.println(testFiles[0].closest[3]);

		// for (kNNData t : testFiles)
		// System.out.println(t.toString());
	}

}
