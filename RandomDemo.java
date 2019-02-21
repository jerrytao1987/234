import java.util.Random;
public class RandomDemo{
	public static void main(String[] args){
		Random r = new Random();
		//int i = r.nextInt(10);
		//System.out.println(i);
		//double d = r.nextDouble();
		//System.out.println(d);
		double d1;
		do{
			d1=r.nextDouble();
			if(d1==0.0){
				System.out.println(0);
			}
			System.out.println(d1);
		}while(d1!=0.0);
	}
}