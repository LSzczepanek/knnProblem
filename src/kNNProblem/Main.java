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
		String[] preparedString = FileHelper.getPreparedFile();
		kNNData[] testFiles = new kNNData[preparedString.length / 5];

		for (int i = 0, j = 0; j < testFiles.length; i += 5, j++) {
			testFiles[j] = new kNNData(Double.parseDouble(preparedString[i]), Double.parseDouble(preparedString[i + 1]),
					Double.parseDouble(preparedString[i + 2]), Double.parseDouble(preparedString[i + 3]),
					preparedString[i + 4], testFiles.length);
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
	
		System.out.println(testFiles[16].testDistannce);
		for (int k : testFiles[16].closest) {
			System.out.println("Wartosc najblizsza: " + k);
			System.out.println("Wartosc flagi eksperckiej: " + testFiles[16].expertFlag);
			System.out.println("Wartosc flagi kNN: " + testFiles[16].knnFlag);
			System.out.println(KNNAlgorythm.checkPrecision(testFiles));
		}

	
	}

}
