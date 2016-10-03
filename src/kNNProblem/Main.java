package kNNProblem;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KNNAlgorythm testVersion = new KNNAlgorythm();
		String testFile = null;
		System.out.println("Program will show how good or how bad the kNN Algorythm it is for such a data like IRYS");
		try {
			// testFile = FileHelper
			// .readFile("C:/eclipse-java-neon-1-win32-x86_64/workspace/knnProblem/src/resources/test.txt");
			testFile = FileHelper.readFile("G:/ProjektyEclipse/kNNProblem/src/resources/test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testFile = testFile.replaceAll("\\r", ",");
		testFile = testFile.replaceAll("\\n", "");
		System.out.println(testFile);
		String[] separatedString = testFile.split(",");

		kNNData[] testFiles = new kNNData[separatedString.length / 3];

		for (int i = 0, j = 0; j < testFiles.length; i += 3, j++) {
			testFiles[j] = new kNNData(Double.parseDouble(separatedString[i]),
					Double.parseDouble(separatedString[i + 1]), 0.0, 0.0, separatedString[i + 2], testFiles.length);
		}

		testVersion.calculateAllDistancesToTheAllPoints(testFiles);
		int i = -1;
		System.out.println("Table:");
		System.out.println(testFiles[0].distance.length);
		for (double n : testFiles[0].distance) {
			System.out.println(++i + ". : " + n);

		}
		System.out.println("Map: ");

		System.out.println(testFiles[0].testDistannce);
		// testFiles[0].testDistannce =
		// MapUtil.sortByValue(testFiles[0].testDistannce);
		System.out.println(testFiles[16].testDistannce);
		for (int k : testFiles[16].closest) {
			System.out.println("Wartosc najblizsza: " + k);
			System.out.println("Wartosc flagi eksperckiej: " + testFiles[16].expertFlag);
			System.out.println("Wartosc flagi kNN: " + testFiles[16].knnFlag);
			System.out.println(KNNAlgorythm.checkPrecision(testFiles));
		}

		// Map<Integer, Double> testDistannce=new TreeMap<Integer, Double>();
		// testDistannce.put(0, 5.0);
		// testDistannce.put(3, 2.0);
		// testDistannce.put(2, 3.0);
		// testDistannce.put(1, 4.0);
		// testDistannce.put(5, 1.0);
		//
		// System.out.println(testDistannce);

		// for (int z = 0; z < 5; z++)
		// System.out.println(testFiles[0].closest[z]);

		// System.out.println(testFiles[0].closest[3]);

		// for (kNNData t : testFiles)
		// System.out.println(t.toString());
	}

}
