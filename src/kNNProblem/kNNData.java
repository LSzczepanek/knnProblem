package kNNProblem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class kNNData {

	public double A;
	public double B;
	public double C;
	public double D;
	public String expertFlag;
	public String knnFlag;
	Map<Integer, Double> distanceList;
	public int[] listOfTheClosestObjects;

	public kNNData() {

	}

	public kNNData(double A, double B, double C, double D, String expertFlag, int sizeOfTable) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.expertFlag = expertFlag;
		distanceList = new LinkedHashMap<Integer, Double>();
	}

	String getExpertFlag() {
		return expertFlag;
	}

	String getKNNFlag() {
		return knnFlag;
	}

	void giveFlag(kNNData[] Objects, ArrayList<String> listOfFlag) {

		int[] flags = new int[listOfFlag.size()];
		double[] sumFlags = new double[listOfFlag.size()];

		for (int j = 0; j < listOfFlag.size(); j++) {
			for (int i = 0; i < listOfTheClosestObjects.length; i++) {
				if (listOfFlag.get(j).equals(Objects[this.listOfTheClosestObjects[i]].expertFlag)) {
					flags[j] += 1;
				}

			}
		}

		for (int i = 0; i < listOfFlag.size(); i++) {
			sumFlags[i] = (double) ((flags[i] / (double) listOfTheClosestObjects.length) * 100);
		}
		for (int i = 0; i < listOfFlag.size(); i++) {
			if (sumFlags[i] > 50) {
				this.knnFlag = new String(listOfFlag.get(i));
			} else if (this.knnFlag == null) {
				this.knnFlag = "Nie do okreslenia";

			}
		}
	}

	@Override
	public String toString() {
		return this.A + ", " + this.B + ", " + this.C + ", " + this.D + ", " + this.expertFlag + ", " + this.knnFlag;
	}

}
