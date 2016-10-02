package kNNProblem;

public class ObjectToUse {

	double A;
	double B;
	double C;
	double D;
	String expertFlag;
	String knnFlag;
	double[] distance;
	
	public ObjectToUse(){
		
	}

	public ObjectToUse(double A, double B, double C, double D, String expertFlag) {
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
		this.expertFlag = expertFlag;
	}
	
	void calculateDistance(){
		
	}
	
	
	@Override
	public String toString() {
		return this.A + ", "+this.B + ", "+this.C + ", "+this.D + ", "+this.expertFlag;
	}
	
}
