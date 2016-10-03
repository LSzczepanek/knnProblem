package kNNProblem;

import java.util.Arrays;

public class KNNAlgorythm {

	public void calculateAllDistancesToTheAllPoints(kNNData[] listOfObjects) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distance[i] = 0;
					continue;
				}

				listOfObjects[i].distance[j] = KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i],
						listOfObjects[j]);
			}
			listOfObjects[i].closest = getThreeLowest(listOfObjects[i].distance);
		}

	}

	static double calculateEuklidesDistance(kNNData firstObject, kNNData secondObject) {
		double sum = 0;
		sum += Math.pow((firstObject.A - secondObject.A), 2);
		sum += Math.pow((firstObject.B - secondObject.B), 2);
		sum += Math.pow((firstObject.C - secondObject.C), 2);
		sum += Math.pow((firstObject.D - secondObject.D), 2);
		Math.sqrt(sum);
		return Math.sqrt(sum);
	}

	private static double[] getThreeLowest(double[] distance) {
		double[] lowestValues = new double[5];
		Arrays.fill(lowestValues, Integer.MAX_VALUE);

		for (double n : distance) {
			if (n < lowestValues[2]) {
				lowestValues[2] = n;
				Arrays.sort(lowestValues);
			}
		}
		return lowestValues;
	}
}
