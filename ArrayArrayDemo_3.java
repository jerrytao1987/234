public class ArrayArrayDemo_3{
	public static void main(String[] args){
		//int[][] arr = new int[][]{{1,3,5},{3,6,7}};
		int[][] arr = {{11,12},{21,22,23},{31,32,33,34}};
		int sum=0,groupSum=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				groupSum +=arr[i][j];
			}
			System.out.println("第"+(i+1)+"个小组的总销售额:"+groupSum);
			sum += groupSum;
			groupSum =0;
		}
		System.out.println("整个公司的销售额:"+sum);
	}
}