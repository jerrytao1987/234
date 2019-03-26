package test;

public class Child implements TestInterface {

	@Override
	public double calculate(int a) {
		return sqrt(a * 100);
	}

}
