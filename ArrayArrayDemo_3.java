public class ArrayArrayDemo_3{
	public static void main(String[] args){
		//int[][] arr = new int[][]{{1,3,5},{3,6,7}};
		int[][] arr = {{11,12},{21,22,23},{31,32,33,34}};
		int sum=0,groupSum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				groupSum +=arr[i][j];
			}
			System.out.println("��"+(i+1)+"��С��������۶�:"+groupSum);
			sum += groupSum;
			groupSum =0;
		}
		System.out.println("������˾�����۶�:"+sum);
	}
}