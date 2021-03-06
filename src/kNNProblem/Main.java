package kNNProblem;

public class Main {

	public static void main(String[] args) {

		String[] preparedString = FileHelper.getPreparedFile();
		kNNData[] testFiles = new kNNData[preparedString.length / FileHelper.AMOUNT_OF_PARAMETERS];
		
		int kValue = 3;
		
		System.out.println("Liczba argumentow to: "+ FileHelper.AMOUNT_OF_PARAMETERS);

		for (int i = 0, j = 0; j < testFiles.length; i += FileHelper.AMOUNT_OF_PARAMETERS, j++) {
			testFiles[j] = new kNNData(Double.parseDouble(preparedString[i]), Double.parseDouble(preparedString[i + 1]),
					Double.parseDouble(preparedString[i + 2]), Double.parseDouble(preparedString[i + 3]),
					preparedString[i + 4], testFiles.length);
		}
		KNNAlgorythm.calculateAllDistancesToTheAllPoints(testFiles, kValue);

		System.out.println(KNNAlgorythm.checkAccuracyAndPrecision(testFiles, kValue));
		
	}

}
