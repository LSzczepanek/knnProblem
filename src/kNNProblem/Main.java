package kNNProblem;

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

		testVersion.calculateAllDistancesToTheAllPoints(testFiles, 3);
		// System.out.println("Table:");
		// System.out.println(testFiles[0].distance.length);
		// for (double n : testFiles[0].distance) {
		// System.out.println(++i + ". : " + n);
		//
		// }
		System.out.println("Map: ");
		for (kNNData object : testFiles) {
			System.out.println(object);
		}

		System.out.println(testFiles[1].distanceList);
		for (int i = 0; i < testFiles.length; i++) {
			for (int k : testFiles[i].closest) {
				System.out.println(i+".Wartosc najblizsza: " + k);
				System.out.println(i+".Wartosc flagi eksperckiej: " + testFiles[i].expertFlag);
				System.out.println(i+".Wartosc flagi kNN: " + testFiles[i].knnFlag);

			}
		}
		System.out.println(KNNAlgorythm.checkPrecision(testFiles));
		
	}

}
