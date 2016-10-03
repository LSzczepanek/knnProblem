package kNNProblem;

import java.util.Arrays;
import java.util.Map;

public class KNNAlgorythm {

	public void calculateAllDistancesToTheAllPoints(kNNData[] listOfObjects) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distance[i] = 0;
					listOfObjects[i].testDistannce.put(null, (double) 0);
					continue;
				}

				listOfObjects[i].distance[j] = KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i],
						listOfObjects[j]);
				listOfObjects[i].testDistannce.put(j,
						KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
			}
			getLowestforObject(listOfObjects[i], 3);
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
			if(entry.getKey() == null){
				continue;
			}
			else {
				Objects.closest[valueForClosest] = (int) entry.getKey();
				valueForClosest++;
			}
			//System.out.println(entry.getKey() + ", " + entry.getValue());
			testValueToBreak++;
		}
	}
}
