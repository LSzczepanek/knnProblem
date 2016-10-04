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
	// public double[] distance;
	Map<Integer, Double> distanceList;
	public int[] closest;

	public kNNData() {

	}

	public kNNData(double A, double B, double C, double D, String expertFlag, int sizeOfTable) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.expertFlag = expertFlag;
		// this.distance = new double[sizeOfTable];
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
			for (int i = 0; i < closest.length; i++) {
				if (Objects[closest[i]].expertFlag.equals(listOfFlag.get(j))) {
					flags[j] += 1;
				}

			}
		}
		
		System.out.println("Flaga "+listOfFlag.get(0)+":"+flags[0]);
		System.out.println("Flaga "+listOfFlag.get(1)+":"+flags[1]);
		
		//Need Change to way how the flas is assigned
		for (int i = 0; i < listOfFlag.size(); i++) {
			sumFlags[i] = (double) (flags[i] / closest.length) * 100;
		}
		// sumK = (double) (K_Flag / closest.length) * 100;
		// sumZ = (double) (Z_Flag / closest.length) * 100;

		for (int i = 0; i < listOfFlag.size(); i++) {
			if (sumFlags[i] > 50) {
				System.out.println("Suma dla flagi: "+listOfFlag.get(i)+" to "+sumFlags[i]);
				this.knnFlag = new String(listOfFlag.get(i));
			} else {
				this.knnFlag = new String("test: "+listOfFlag.get(1));
			}
		}
	}

	@Override
	public String toString() {
		return this.A + ", " + this.B + ", " + this.C + ", " + this.D + ", " + this.expertFlag + ", " + this.knnFlag;
	}

}
