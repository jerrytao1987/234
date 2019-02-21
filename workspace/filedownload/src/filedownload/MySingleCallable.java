package filedownload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;

public class MySingleCallable implements Callable<Integer> {
	
	private String uri;
	private String destSrc;
	

	public MySingleCallable(String uri, String destSrc) {
		this.uri = uri;
		this.destSrc = destSrc;
	}
	
	@Override
	public Integer call() {
		try {
			HttpURLConnection conn=null;
			if(uri.indexOf("http:")!=-1){
				conn = URLConnectionUtils.getHttpURLConnection(uri, "GET");
			}else{
				conn = URLConnectionUtils.getHttpsURLConnection(uri, "GET");
			}
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");
			int code = conn.getResponseCode();
			if(code==200){
				//InputStream in1 = conn1.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destSrc));
				byte[] b = new byte[1024*1024];
				int len = -1;
				while((len=bis.read(b))!=-1){
					bos.write(b, 0, len);
				}
				bos.close();
				bis.close();
				return 1;
			}else{
				return -1;
			}
		} catch (Exception e) {
			return -1;
		}
	}

}
