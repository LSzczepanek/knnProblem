package kNNProblem;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testFile = null;
		ObjectToUse[] testFiles = new ObjectToUse[20];
		System.out.println("Program will show how good or how bad the kNN Algorythm it is for such a data like IRYS");
		try {
			testFile = FileHelper.readFile("G:\\ProjektyEclipse\\kNNProblem\\test.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] ses;
		String[] separatedString = testFile.split("\\n");
		for (int i =0; i<separatedString.length; i++)
		ses[] = separatedString[i].split(",");
		//String[] separatedString2 = testFile.split("\\n");
		//testFiles[0] = new ObjectToUse();
		
//		System.out.println(separatedString2[0]);
//		System.out.println(separatedString2[1]);
//		System.out.println(separatedString2[2]);
		for (int i=0 , j=0; i<60 || j <20; i+=3, j++) {
			System.out.println(i +"+"+separatedString2[i]);
			System.out.println(i +1+"+"+separatedString2[i+1]);
			System.out.println(i +2+"+"+separatedString2[i+2]);
			testFiles[j] = new ObjectToUse(Double.parseDouble(separatedString2[i]),
					Double.parseDouble(separatedString2[i+1]), 
					0.0, 
					0.0, 
					separatedString2[i+2]);
		}
		
		for (ObjectToUse t : testFiles)
		System.out.println(t);
	}

}
