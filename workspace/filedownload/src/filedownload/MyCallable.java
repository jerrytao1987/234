package filedownload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

import javax.net.ssl.HttpsURLConnection;

public class MyCallable implements Callable<Integer> {
	private String uri;
	private long start;
	private long length;
	private long end;
	private String destSrc;
	

	public MyCallable(String uri, long start, long length, long end, String destSrc) {
		this.uri = uri;
		this.start = start;
		this.length = length;
		this.end = end;
		this.destSrc = destSrc;
	}

	@Override
	public Integer call() {
		try {
			//long startTime = System.currentTimeMillis();
			HttpURLConnection conn=null;
			if(uri.indexOf("http:")!=-1){
				conn = URLConnectionUtils.getHttpURLConnection(uri, "GET");
			}else{
				conn = URLConnectionUtils.getHttpsURLConnection(uri, "GET");
			}
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");
			//请求文件段
			conn.setRequestProperty("Range", "bytes="+start+"-"+end);
			int code = conn.getResponseCode();
			//206表示文件分段请求,而不是整个文件请求
			if(code==206){
				//InputStream in = conn.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				RandomAccessFile raf = new RandomAccessFile(destSrc, "rw");
				raf.seek(start);
				byte[] b=null;
				if(length<=1024*1024){
					b = new byte[(int) length];
				}else{
					b = new byte[1024*1024];
				}
				int len = -1;
				while((len=bis.read(b))!=-1){
					raf.write(b, 0, len);
				}
				raf.close();
				bis.close();
				//System.out.println("线程" + Thread.currentThread().getName() + "下载完毕！！");
				//long endTime = System.currentTimeMillis();
				//System.out.println(endTime-startTime);
				return 1;
			}else{
				//System.out.println("不支持分段下载");
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}
}
