package kNNProblem;

import java.util.LinkedHashMap;
import java.util.Map;

public class kNNData {

	public double A;
	public double B;
	public double C;
	public double D;
	public String expertFlag;
	public String knnFlag;
	public double[] distance;
	Map<Integer, Double> testDistannce;
	public int[] closest;
	
	public kNNData(){
		
	}

	public kNNData(double A, double B, double C, double D, String expertFlag, int sizeOfTable) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.expertFlag = expertFlag;
		this.distance = new double[sizeOfTable];
		testDistannce = new LinkedHashMap<Integer, Double>();
	}
	
	String getExpertFlag(){
		return expertFlag;
	}
	
	String getKNNFlag(){
		return knnFlag;
	}
	
	
	void giveFlag(kNNData[] Objects) {
		int K_Flag = 0;
		int Z_Flag = 0;
		double sumK;
		double sumZ;
		for (int i = 0; i < closest.length; i++) {
			if (Objects[closest[i]].expertFlag.equals("K")) {
				K_Flag++;
			} else {
				Z_Flag++;
			}

		}
		sumK = (double) (K_Flag / closest.length) * 100;
		sumZ = (double) (Z_Flag / closest.length) * 100;
		
		if(sumK > 50){
			knnFlag = "K";
		}else if (sumZ > 50){
			knnFlag = "Z";
		}else {
			knnFlag = "Nie do okreslenia";
		}

	}
	
	@Override
	public String toString() {
		return this.A + ", "+this.B + ", "+this.C + ", "+this.D + ", "+this.expertFlag;
	}
	
}
