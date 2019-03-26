package filecopy;

import java.io.IOException;
import java.time.Clock;
import java.util.Calendar;

public class TestCopyFile {
	public static void main(String[] args) throws IOException {
		String source = "d:/PowerEnterABC32.exe";
		String target = "E:/abc.exe";
		/*long start = Calendar.getInstance().getTimeInMillis();
		FileCopyUtils.NIOCopyFile(source, target);
		long end = Clock.systemDefaultZone().millis();
		System.out.println(end-start);*/
		long start1 = System.currentTimeMillis();
		FileCopyUtils.copyFile(source, target);
		long end1 = Clock.systemDefaultZone().millis();
		System.out.println(end1-start1);
	}
}
