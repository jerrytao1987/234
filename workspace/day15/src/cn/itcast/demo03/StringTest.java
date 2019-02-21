package cn.itcast.demo03;

public class StringTest {

	public static void main(String[] args) {
		String str = "adf23DKJA23azZ/";
		getCount(str);
		
		System.out.println(toConvert(str));
		getCount1("hellojava,nihaojavajavazhenbangjava", "java");
	}
	public static void getCount1(String str,String str1){
		/*int count = 0;
		int i = 0;
		while(str.indexOf(str1,i)!=-1){
			count++;
			i = str.indexOf(str1,i);
			i += str1.length();			
		}
		System.out.println(count);*/
		int count = 0;
		int index = 0;
		while((index = str.indexOf(str1))!=-1){
			count++;
			str = str.substring(index+str1.length());
		}
		System.out.println(count);
	}
	public static String toConvert(String str){
		String str1 = str.substring(0,1);
		String str2 = str.substring(1);
		str1 = str1.toUpperCase();
		str2 = str2.toLowerCase();
		return str1+str2;
	}
	public static void getCount(String str){
		int uper = 0;
		int lower = 0;
		int digit = 0;
		for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='A' && c<=90){
				uper++;
			}else if(c>=97 && c<='z'){
				lower++;
			}else if(c>=48 && c<='9'){
				digit++;
			}
		}
		System.out.println(uper+" "+lower+" "+digit);
	}

}
