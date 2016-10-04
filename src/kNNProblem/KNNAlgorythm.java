package kNNProblem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class KNNAlgorythm {

	static ArrayList<String> listOfFlag;

	public void calculateAllDistancesToTheAllPoints(kNNData[] listOfObjects, int kValue) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distanceList.put(null, (double) 0);
					continue;
				}
				listOfObjects[i].distanceList.put(j,
						KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
			}
			System.out.println("Obiekt nr: " + i);
			getLowestforObject(listOfObjects[i], kValue);

		}

		for (int i = 0; i < listOfObjects.length; i++) {
			listOfObjects[i].giveFlag(listOfObjects, getListOfFlag(listOfObjects));
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

	private void getLowestforObject(kNNData object, int kValue) {
		int testValueToBreak = 0;
		int valueForClosest = 0;
		object.listOfTheClosestObjects = new int[kValue];
		Map<Integer, Double> sortedDistanceList = MapUtil.sortByValue(object.distanceList);
		for (Map.Entry entry : (sortedDistanceList.entrySet())) {
			if (testValueToBreak == kValue) {
				break;
			}
			if (entry.getKey() == null) {
				continue;
			} else {
				object.listOfTheClosestObjects[valueForClosest] = (int) entry.getKey();
				valueForClosest++;
			}
			// System.out.println(entry.getKey() + ", " + entry.getValue());
			testValueToBreak++;
		}
	}

	static ArrayList<String> getListOfFlag(kNNData[] listOfObjects) {
		HashSet<String> getTheFlags = new HashSet<String>();

		for (kNNData Object : listOfObjects) {
			getTheFlags.add(Object.expertFlag);
		}

		listOfFlag = new ArrayList<>(getTheFlags);

		return listOfFlag;

	}

	static int[] getAmountOfFlag(kNNData[] listOfObjects, ArrayList<String> listOfFlag) {
		int[] amountOfFlag = new int[listOfFlag.size()];
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfFlag.size(); j++) {
				if (listOfObjects[i].expertFlag.equals(listOfFlag.get(j))) {
					amountOfFlag[j] += 1;
				}
			}

		}
		return amountOfFlag;
	}

	static String checkPrecision(kNNData[] listOfObjects) {

		int generalPrecision = 0;
		double finalGeneralPrecision = 0;

		ArrayList<String> listOfFlag = getListOfFlag(listOfObjects);
		int[] amountOfFlag = getAmountOfFlag(listOfObjects, listOfFlag);
		int[] hitOfFlag = new int[listOfFlag.size()];
		double[] finalFlagPrecision = new double[listOfFlag.size()];

		System.out.println("Ilosc flag to: " + listOfFlag.size());
		System.out.print("Posiadane flagi to: ");
		for (int i = 0; i < listOfFlag.size(); i++) {
			System.out.print(listOfFlag.get(i) + "(" + amountOfFlag[i] + ")" + ", ");
		}

		for (int i = 0; i < listOfFlag.size(); i++) {
			generalPrecision = 0;
			for (kNNData Object : listOfObjects) {
				if (Object.expertFlag.equals(Object.knnFlag)) {
					generalPrecision++;
				}
				if (Object.expertFlag.equals(Object.knnFlag) && Object.expertFlag.equals(listOfFlag.get(i))) {
					hitOfFlag[i] += 1;
				}
			}
		}
		
		for (int i = 0; i < listOfFlag.size(); i++) {
			finalFlagPrecision[i] = ((double) hitOfFlag[i] / amountOfFlag[i]) * 100;
		}
		finalGeneralPrecision = ((double) generalPrecision / listOfObjects.length) * 100;

		DecimalFormat df2 = new DecimalFormat(".##");
		String result = "Ostateczna, pelna precyzja to: " + df2.format(finalGeneralPrecision);
		for (int i = 0; i < listOfFlag.size(); i++) {
			result += ", precyzja dla flagi " + listOfFlag.get(i) + ": " + df2.format(finalFlagPrecision[i]);
		}
		
		return result;
//		return "Ostateczna, pelna precyzja to: " + finalGeneralPrecision + ", precyzja dla flagi " + listOfFlag.get(0)
//				+ ": " + finalFlagPrecision[0] + ", precyzja dla flagi " + listOfFlag.get(1) + ": "
//				+ finalFlagPrecision[1];

	}

}
