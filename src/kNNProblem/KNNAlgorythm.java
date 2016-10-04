package kNNProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class KNNAlgorythm {
	
	static ArrayList<String> listOfFlag;

	public void calculateAllDistancesToTheAllPoints(kNNData[] listOfObjects) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distanceList.put(null, (double) 0);
					continue;
				}
				listOfObjects[i].distanceList.put(j,
						KNNAlgorythm.calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
			}
			getLowestforObject(listOfObjects[i], 3);
			
		}
		
		for (int i = 0; i < listOfObjects.length; i++){
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
		object.closest = new int[kValue];
		System.out.println("before: ");
		System.out.println(object.distanceList);
		Map<Integer, Double> sortedDistanceList = MapUtil.sortByValue(object.distanceList);
		System.out.println("after sort old object: ");
		System.out.println(object.distanceList);
		System.out.println("after sort new object: ");
		System.out.println(sortedDistanceList);
		for (Map.Entry entry : (sortedDistanceList.entrySet())) {
			if (testValueToBreak == kValue) {
				break;
			}
			if (entry.getKey() == null) {
				continue;
			} else {
				object.closest[valueForClosest] = (int) entry.getKey();
				valueForClosest++;
			}
			// System.out.println(entry.getKey() + ", " + entry.getValue());
			testValueToBreak++;
		}
	}

	
	
	
	static ArrayList<String> getListOfFlag(kNNData[] listOfObjects){
		HashSet<String> getTheFlags = new HashSet<String>();

		for (kNNData Object : listOfObjects) {
			getTheFlags.add(Object.expertFlag);
		}

		listOfFlag = new ArrayList<>(getTheFlags);
		

		
		return listOfFlag;
		
	}
	
	
	static int[] getAmountOfFlag(kNNData[] listOfObjects, ArrayList<String> listOfFlag){
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

		ArrayList<String> listOfFlag  = getListOfFlag(listOfObjects);
		int[] amountOfFlag = getAmountOfFlag(listOfObjects, listOfFlag);
		
		System.out.println("Ilosc flag to: " + listOfFlag.size());
		System.out.print("Posiadane flagi to: ");
		for (int i = 0; i < listOfFlag.size(); i++) {
			System.out.print(listOfFlag.get(i) + "(" + amountOfFlag[i] + ")" + ", ");
		}

		for (kNNData Object : listOfObjects) {
			if (Object.expertFlag.equals(Object.knnFlag)) {
				generalPrecision++;
			}
			if (Object.expertFlag.equals("K")) {
				// firstFlag++;

			}
			if (Object.expertFlag.equals("Z")) {
				// secondFlag++;
			}
			finalGeneralPrecision = (double) (generalPrecision / listOfObjects.length) * 100;
			// finalFirstFlagPrecision = (generalPrecision /
			// listOfObjects.length) * 100;
			// finalSecomdFlagPrecision = (generalPrecision /
			// listOfObjects.length) * 100;
		}

		return "Ostateczna, pelna precyzja to: " + finalGeneralPrecision;

	}

}
