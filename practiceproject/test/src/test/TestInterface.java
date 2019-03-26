package test;

public interface TestInterface {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
