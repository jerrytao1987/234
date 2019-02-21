package bjava18;

import java.io.IOException;

public class RuntimeDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("notepad test.txt");
		Thread.sleep(4000);
		//p.destroy();
	}
}
