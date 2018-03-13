package matlabjava02;

import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import com.mathworks.engine.MatlabExecutionException;
import com.mathworks.engine.MatlabSyntaxException;

public class MatlabJava02_lib {
	
	//MATLAB を Java から非同期的に起動します。
	Future<MatlabEngine> eng;
	double a[][], v[][], d[][] ; //v:固有ベクトル、d:固有値
	MatlabEngine ml;

	public MatlabJava02_lib(double a[][]) {
		this.a = a;
		eng = MatlabEngine.startMatlabAsync();
		try {
			//返された Future オブジェクトの get メソッドを使用して、MatlabEngine オブジェクトが返されるのを待ちます。
			ml = eng.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getEIG() {
		try {
			ml.putVariableAsync("a", a);
			ml.putVariableAsync("v", v);
			ml.putVariableAsync("d", d);
			ml.eval("[v,d] = eig(a);");
			
			Future<double[][]> futureEval_v = ml.getVariableAsync("v");
			v = futureEval_v.get();
			Future<double[][]> futureEval_d = ml.getVariableAsync("d");
			d = futureEval_d.get();
			
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public double[][] getV() {
		return v;
	}

	public double[][] getD() {
		return d;
	}

}
