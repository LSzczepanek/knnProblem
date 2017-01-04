package kNNProblem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class KNNAlgorythm {

	private static ArrayList<String> listOfFlag;

	static void calculateAllDistancesToTheAllPoints(kNNData[] listOfObjects, int kValue) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distanceList.put(null, (double) 0);
					continue;
				}
				listOfObjects[i].distanceList.put(j,
						KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
			}
			getLowestforObject(listOfObjects[i], kValue);
		}

		for (int i = 0; i < listOfObjects.length; i++) {
			listOfObjects[i].giveFlag(listOfObjects, getListOfFlag(listOfObjects));
		}

	}

	private static double calculateEuklidesDistance(kNNData firstObject, kNNData secondObject) {
		double sum = 0;
		sum += Math.pow((firstObject.A - secondObject.A), 2);
		sum += Math.pow((firstObject.B - secondObject.B), 2);
		sum += Math.pow((firstObject.C - secondObject.C), 2);
		sum += Math.pow((firstObject.D - secondObject.D), 2);
		Math.sqrt(sum);
		return Math.sqrt(sum);
	}

	private static void getLowestforObject(kNNData object, int kValue) {
		int testValueToBreak = 0;
		int valueForClosest = 0;

		object.listOfTheClosestObjects = new int[kValue];
		Map<Integer, Double> sortedDistanceList = MapUtil.sortByValue(object.distanceList);

		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : (sortedDistanceList.entrySet())) {
			if (testValueToBreak == kValue) {
				break;
			}
			if (entry.getKey() == null) {
				continue;
			} else {
				object.listOfTheClosestObjects[valueForClosest] = (int) entry.getKey();
				valueForClosest++;
			}
			testValueToBreak++;
		}
	}

	private static ArrayList<String> getListOfFlag(kNNData[] listOfObjects) {
		HashSet<String> getTheFlags = new HashSet<String>();

		for (kNNData Object : listOfObjects) {
			getTheFlags.add(Object.expertFlag);
		}

		listOfFlag = new ArrayList<>(getTheFlags);

		return listOfFlag;

	}

	private static int[] getAmountOfFlag(kNNData[] listOfObjects, ArrayList<String> listOfFlag) {
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

	static String checkAccuracyAndPrecision(kNNData[] listOfObjects, int kValue) {

		int generalAccuracy = 0;
		int generalTP = 0;
		int generalFP = 0;
		double finalGeneralAccuracy = 0;
		double finalGeneralPrecision = 0;
		

		ArrayList<String> listOfFlag = getListOfFlag(listOfObjects);
		int[] amountOfFlag = getAmountOfFlag(listOfObjects, listOfFlag);
		int[] tp = new int[listOfFlag.size()];
		int[] tn = new int[listOfFlag.size()];
		int[] fp = new int[listOfFlag.size()];
		double[] finalFlagAccuracy = new double[listOfFlag.size()];
		double[] finalFlagPrecision = new double[listOfFlag.size()];

		System.out.println("Ilosc flag to: " + listOfFlag.size());
		System.out.print("Posiadane flagi to: ");
		for (int i = 0; i < listOfFlag.size(); i++) {
			System.out.print(listOfFlag.get(i) + "(" + amountOfFlag[i] + ")" + ", ");
		}

		for (int i = 0; i < listOfFlag.size(); i++) {
			generalAccuracy = 0;
			for (kNNData Object : listOfObjects) {
				if (Object.expertFlag.equals(Object.knnFlag)) {
					generalAccuracy++;
				}
				if (Object.expertFlag.equals(Object.knnFlag) && Object.expertFlag.equals(listOfFlag.get(i))
						&& Object.knnFlag.equals(listOfFlag.get(i))) {
					tp[i] += 1;
					generalTP += 1;
				}
				if (!(Object.knnFlag.equals(listOfFlag.get(i))) && !(Object.expertFlag.equals(listOfFlag.get(i)))) {
					tn[i] += 1;
				}
				if (Object.knnFlag.equals(listOfFlag.get(i)) && !(Object.expertFlag.equals(listOfFlag.get(i)))) {
					fp[i] += 1;
					generalFP += 1;
				}
			}
		}

		for (int i = 0; i < listOfFlag.size(); i++) {
			finalFlagAccuracy[i] = ((tp[i] + tn[i]) / (double) listOfObjects.length) * 100;
			finalFlagPrecision[i] = ((double) tp[i] / (tp[i] + fp[i])) * 100;
		}
		finalGeneralAccuracy = ((double) generalAccuracy / listOfObjects.length) * 100;
		finalGeneralPrecision = ((double) generalTP / (generalTP + generalFP)) * 100;

		DecimalFormat df2 = new DecimalFormat(".##");
		String result = "\nOstateczna, ogolna dokladnosc dla k=" + kValue + " to: " + df2.format(finalGeneralAccuracy)+
				"\nZas ogolna precyzja wynosi: "+df2.format(finalGeneralPrecision);
		for (int i = 0; i < listOfFlag.size(); i++) {
			result += "\n\nDokladnosc dla flagi " + listOfFlag.get(i) + ": " + df2.format(finalFlagAccuracy[i]);
			result += "\nPrecyzja dla flagi " + listOfFlag.get(i) + ": " + df2.format(finalFlagPrecision[i]);
			result += "\nTP dla flagi= "+tp[i];
			result += "\nFP dla flagi= "+fp[i];
			result += "\nTN dla flagi= "+tn[i];
			result += "\nFN dla flagi= "+(listOfObjects.length-tp[i]-fp[i]-tn[i]);
			}

		return result;

	}

}
