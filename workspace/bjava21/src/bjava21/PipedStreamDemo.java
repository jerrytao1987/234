package bjava21;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
	
	public static void main(String[] args) throws IOException {
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
	}
}
class Read implements Runnable{
	private PipedInputStream in;
	Read(PipedInputStream i){
		this.in=i;
	}
	@Override
	public void run() {
		try {
			byte[] buf = new byte[1024];
			System.out.println("读取前...没有数据阻塞");
			int len = in.read(buf);
			System.out.println("读到数据...阻塞结束");
			String s = new String(buf, 0, len);
			System.out.println(s);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("管道读取流失败");
		}
	}
	
}
class Write implements Runnable{
	private PipedOutputStream out;
	Write(PipedOutputStream out){
		this.out=out;
	}
	@Override
	public void run() {
		try {
			System.out.println("开始写入数据，等待6秒后");
			Thread.sleep(6000);
			out.write("piped lai le".getBytes());
			out.close();
		} catch (Exception e) {
			throw new RuntimeException("管道输出流失败");
		}
	}
	
}