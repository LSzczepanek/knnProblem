package kNNProblem;

public class kNNData {

	public double A;
	public double B;
	public double C;
	public double D;
	public String expertFlag;
	public String knnFlag;
	public double[] distance;
	public double[] closest;
	
	public kNNData(){
		
	}

	public kNNData(double A, double B, double C, double D, String expertFlag, int sizeOfTable) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.expertFlag = expertFlag;
		this.distance = new double[sizeOfTable];
	}
	
	void calculateDistance(){
		
	}
	
	
	@Override
	public String toString() {
		return this.A + ", "+this.B + ", "+this.C + ", "+this.D + ", "+this.expertFlag;
	}
	
}
