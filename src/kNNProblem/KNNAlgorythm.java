package kNNProblem;

import java.util.HashSet;
import java.util.Map;

public class KNNAlgorythm {

	public void calculateAllDistancesToTheAllPoints(kNNData[] listOfObjects) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].testDistannce.put(null, (double) 0);
					continue;
				}
				listOfObjects[i].testDistannce.put(j,
						KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
			}
			getLowestforObject(listOfObjects[i], 3);
			listOfObjects[i].giveFlag(listOfObjects);
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

	private void getLowestforObject(kNNData Objects, int kValue) {
		int testValueToBreak = 0;
		int valueForClosest = 0;
		Objects.closest = new int[kValue];
		Objects.testDistannce = MapUtil.sortByValue(Objects.testDistannce);
		for (Map.Entry entry : (Objects.testDistannce.entrySet())) {
			if (testValueToBreak == kValue) {
				break;
			}
			if (entry.getKey() == null) {
				continue;
			} else {
				Objects.closest[valueForClosest] = (int) entry.getKey();
				valueForClosest++;
			}
			// System.out.println(entry.getKey() + ", " + entry.getValue());
			testValueToBreak++;
		}
	}

	static String checkPrecision(kNNData[] listOfObjects) {

		int generalPrecision = 0;
		int firstFlag = 0;
		int secondFlag = 0;
		int finalGeneralPrecision = 0;
		int finalFirstFlagPrecision = 0;
		int finalSecomdFlagPrecision = 0;
		HashSet<String> listOfFlag = new HashSet<String>();
		for (kNNData Object : listOfObjects) {
			listOfFlag.add(Object.expertFlag);
		}
		System.out.println("Iloœæ flag to: "+listOfFlag.size());
	
		for (kNNData Object : listOfObjects) {
			if (Object.expertFlag.equals(Object.knnFlag)) {
				generalPrecision++;
			}
			if (Object.expertFlag.equals("K")) {
				firstFlag++;
				
			}
			if (Object.expertFlag.equals("Z")) {
				secondFlag++;
			}
			finalGeneralPrecision = (generalPrecision / listOfObjects.length) * 100;
			finalFirstFlagPrecision = (generalPrecision / listOfObjects.length) * 100;
			finalSecomdFlagPrecision = (generalPrecision / listOfObjects.length) * 100;
		}

		return "Ostateczna, pelna precyzja to: " + finalGeneralPrecision;

	}

}
