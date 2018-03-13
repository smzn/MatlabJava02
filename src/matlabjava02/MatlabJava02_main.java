package matlabjava02;

import java.util.Arrays;

public class MatlabJava02_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double a[][] = { { 1.0000, 0.5000, 0.3333, 0.2500 }, { 0.5000, 1.0000, 0.6667, 0.5000 }, { 0.3333, 0.6667, 1.0000, 0.7500 }, { 0.2500, 0.5000, 0.7500, 1.0000 }};
		MatlabJava02_lib mlib = new MatlabJava02_lib(a);
		mlib.getEIG();
		System.out.println("v = "+Arrays.deepToString(mlib.getV()));
		System.out.println("d = "+Arrays.deepToString(mlib.getD()));
	}

}
