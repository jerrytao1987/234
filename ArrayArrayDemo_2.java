public class ArrayArrayDemo_2{
	public static void main(String[] args){
		//int[][] arr = new int[][]{{1,3,5},{3,6,7}};
		int[][] arr = {{1,3,5},{3,6,7}};
		/*for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.println(arr[i][j]);
			}
		}*/
		for(int j=0;j<3;j++){
			for(int i=0;i<arr.length;i++){
				System.out.println(arr[i][j]);
			}
		}
	}
}