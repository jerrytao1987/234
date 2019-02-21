package filedownload;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class URLConnectionUtils {

	public static HttpsURLConnection getHttpsURLConnection(String uri, String method) throws IOException {

		SSLContext ctx = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			ctx = SSLContext.getInstance("TLS");// 返回实现指定安全套接字协议的 SSLContext 对象
			/*
			 * 初始化此上下文,初始化此上下文。前两个参数都可以为
			 * null，在这种情况下将搜索装入的安全提供者来寻找适当工厂的最高优先级实现。同样，安全的 random 参数也可以为
			 * null，在这种情况下将使用默认的实现.
			 * 只有数组中的第一个特定密钥和/或信任管理器实现类型的实例被使用。（例如，只有数组中的第一个
			 * javax.net.ssl.X509KeyManager 被使用。） KeyManager - 验证密钥源或
			 * nul,KeyManager 负责管理用于验证到同位体的本地 SSLSocket
			 * 的密钥内容。如果没有密钥内容可以使用，则套接字将不能提供验证证书。 TrustManager - 同位体验证信任决策源或
			 * null,TrustManager负责管理做出信任决定时使用的的信任材料，也负责决定是否接受同位体提供的证书。
			 * SecureRandom - 此生成器的随机源或 null,此类提供强加密随机数生成器 (RNG)。
			 * 
			 */
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = ctx.getSocketFactory();

		URL url = new URL(uri);
		HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
		// 设置当此实例为安全 https URL 连接创建套接字时使用的 SSLSocketFactory。
		httpsConn.setSSLSocketFactory(ssf);
		/*
		 * 设置此实例的 HostnameVerifier。 
		 * 此类是用于主机名验证的基接口。
		 * 在握手期间，如果 URL 的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口的实现程序来确定是否应该允许此连接。
		 * 策略可以是基于证书的或依赖于其他验证方案。
		 * 当验证 URL 主机名使用的默认规则失败时使用这些回调。
		 * 
		 */
		httpsConn.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});
		// 设置请求方式（GET/POST）
		httpsConn.setRequestMethod(method);
		//将此 URLConnection 的 doInput 字段的值设置为指定的值。
		httpsConn.setDoInput(true);
		//将此 URLConnection 的 doOutput 字段的值设置为指定的值。
		httpsConn.setDoOutput(true);
		return httpsConn;
	}

	public static HttpURLConnection getHttpURLConnection(String uri, String method) throws IOException {
		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(1000);
		conn.setRequestMethod(method);
		return conn;
	}
}
