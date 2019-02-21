package bjava25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 网页爬虫（蜘蛛）
 */
public class RegexTest2 {
	
	public static void main(String[] args) throws Exception{
		getMails_1();
	}
	public static void getMails_1() throws Exception{
		URL url = new URL("https://uland.taobao.com/sem/tbsearch?refpid=mm_26632258_3504122_32538762&keyword=%E5%A5%B3%E8%A3%85&clk1=96949cc9d10a1b8bda32a9b1dd726c13&upsid=96949cc9d10a1b8bda32a9b1dd726c13");
		URLConnection conn = url.openConnection();
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = null;
		String mailreg = "<(img|IMG)(.*?)(/>|>|</img>)";//<img src="">
		Pattern p = Pattern.compile(mailreg);
		ArrayList<String> list = new ArrayList<>();
		while((line=bufIn.readLine())!=null){
			Matcher m = p.matcher(line);
			while(m.find()){
				//System.out.println(m.group());
				list.add(m.group());
			}
		}
		/*if(list.size()>0){
			String srcReg = "src=(.*?)[ >]";
			Pattern p1 = Pattern.compile(srcReg);
			for (int i = 0; i < list.size(); i++) {
				Matcher m = p1.matcher(list.get(i));
				if(m.find()){
					list.set(i, m.group());
				}
				System.out.println(list.get(i));
				
			}
		}*/
		System.out.println(list);
	}
	public static void getMails() throws Exception {
		BufferedReader buff = new BufferedReader(new FileReader("mail.txt"));
		String line = null;
		String mailreg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(mailreg);
		while((line=buff.readLine())!=null){
			Matcher m = p.matcher(line);
			while(m.find()){
				System.out.println(m.group());
			}
		}
	}
}
