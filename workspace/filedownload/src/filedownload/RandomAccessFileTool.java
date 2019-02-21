package filedownload;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.net.ssl.HttpsURLConnection;

public class RandomAccessFileTool {
	//private static int count = 4;

	public static int fileDownload(int count,String uri, String destSrc) {
		try {
			ExecutorService pool = Executors.newFixedThreadPool(count);
			HttpURLConnection conn = null;
			if (uri.indexOf("http:") != -1) {
				conn = URLConnectionUtils.getHttpURLConnection(uri, "GET");
			} else {
				conn = URLConnectionUtils.getHttpsURLConnection(uri, "GET");
			}
			/*
			 * User Agent中文名为用户代理，简称 UA，它是一个特殊字符串头，使得服务器能够识别客户使用的操作系统及版本、CPU类型、浏览器及版本、浏览器渲染引擎、浏览器语言、浏览器插件等。 
			 * 一些网站常常通过判断 UA来给不同的操作系统、不同的浏览器发送不同的页面，因此可能造成某些页面无法在某个浏览器中正常显示，但通过伪装 UA 可以绕过检测。
			 */
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");
//			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//			conn.setRequestProperty("Connection", "keep-alive");
			conn.connect();
			int code = conn.getResponseCode();
			int position = uri.lastIndexOf("/");
			String fileName = uri.substring(position + 1);// 文件名
			if (!(destSrc.endsWith("/") || destSrc.endsWith("\\"))) {
				destSrc += destSrc.endsWith("/") ? "/" : "\\";
			}
			File file = new File(destSrc);
			if (!file.exists()) {
				file.mkdirs();
			}
			if(code==301||code==302){
				//得到重定向的地址
				uri = conn.getHeaderField("Location");
				if (uri.indexOf("http:") != -1) {
					conn = URLConnectionUtils.getHttpURLConnection(uri, "GET");
				} else {
					conn = URLConnectionUtils.getHttpsURLConnection(uri, "GET");
				}
				code = conn.getResponseCode();
			}
			if (code == 200) {
				RandomAccessFile rafWrite = new RandomAccessFile(destSrc + fileName, "rw");
				// long length = conn.getContentLength();
				long length = conn.getContentLengthLong();
				rafWrite.setLength(length);
				// System.out.println(length);
				rafWrite.close();

				HttpURLConnection conn1 = null;
				if (uri.indexOf("http:") != -1) {
					conn1 = URLConnectionUtils.getHttpURLConnection(uri, "GET");
				} else {
					conn1 = URLConnectionUtils.getHttpsURLConnection(uri, "GET");
				}
				conn1.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");
				// 请求文件段
				conn1.setRequestProperty("Range", "bytes=" + 1 + "-" + (length - 1));
				int code1 = conn1.getResponseCode();
				// 206表示文件分段请求,而不是整个文件请求
				if (code1 == 206) {
					// 执行多线程
					ArrayList<Future<Integer>> list = new ArrayList<>();
					long d = (long) Math.ceil(length / count);
					for (long i = 0; i < count; i++) {
						if (i == count - 1) {
							Future<Integer> f = pool
									.submit(new MyCallable(uri, d * i, length - d * i - 1, length, destSrc + fileName));
							list.add(f);
							break;
						}
						Future<Integer> f = pool
								.submit(new MyCallable(uri, d * i, d, d * i + d - 1, destSrc + fileName));
						list.add(f);
					}
					/*
					 * while(list.size()<4){ try { Thread.sleep(1000); } catch
					 * (InterruptedException e) { e.printStackTrace(); } }
					 */
					for (Future<Integer> future : list) {
						if (future.get() == -1) {
							pool.shutdownNow();
							return -1;
						}
					}
					pool.shutdownNow();
					return 1;
					/*
					 * if(list.get(0).get()==1&&list.get(1).get()==1&&list.get(2
					 * ).get()==1&&list.get(3).get()==1){ pool.shutdown();
					 * return 1; }else{ pool.shutdown(); return -1; }
					 */
				} else {
					// 执行单线程
					Future<Integer> f = pool.submit(new MySingleCallable(uri, destSrc + fileName));
					/*
					 * while(true){ Thread.sleep(1000); }
					 */
					if (f.get() == 1) {
						pool.shutdown();
						return 1;
					} else {
						pool.shutdown();
						return -1;
					}
				}
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		String url = "https://qqrjtu.xy1758.com/mirrors/xp/2211/windows_xp_professional_SP3_x86_2018.iso";
		String destSrc = "D:/";
		//fileDownload(url, destSrc);
	}
}
