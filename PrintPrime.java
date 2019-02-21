public class PrintPrime{
	public static void main(String[] args){
		printPrime(100);
	}
	public static void printPrime(int n){
		int count = 0;
		int countNoChange = 0;
		boolean flag = false;
		for(int i=2;i<n;i++){
			for(int j=2;j<=i/2;j++){
				if(i%j==0){
					flag = true;
					countNoChange = count;
					break;
				}
			}
			if(!flag){
				System.out.print(i+" ");
				count++;
			}else{
				flag =false;
			}
			if(countNoChange!=count&&count%5==0){
				System.out.println();
			}
		}
	}
}