public class ASCIIDemo{
	public static void main(String[] args){
		char c = 'a';
		int i = c+1;
		System.out.println(i);
		
		int j = 90;
		char h = (char)j;
		System.out.println(h);
		System.out.println((char)6);
		
		char k = 'Äã';
		System.out.println(k);
		
		System.out.println((char)48);
		System.out.println((char)65);
		System.out.println((char)97);
		System.out.println((int)Character.MAX_VALUE);
		/*for(int l=48;l<=57;l++){
			System.out.println((char)l);
		}
		for(int m=65;m<=90;m++){
			System.out.println((char)m);
		}
		for(int n=97;n<=122;n++){
			System.out.println((char)n);
		}*/
		char d='A';
		char x='a';
		for(int o=1;o<=26;o++){
			System.out.println(d+" "+x);
			d++;
			x++;
		}
		System.out.println('a'+2);
	}
}