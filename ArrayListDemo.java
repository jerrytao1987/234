import java.util.ArrayList;
public class ArrayListDemo{
		public static void main(String[] args){
			/*ArrayList<String> array = new ArrayList<String>();
			array.add("abc");
			array.add("itcast");
			array.add("love");
			array.add("java");
			int size = array.size();
			System.out.println(size);
			for(int i = 0;i<size;i++){
				System.out.println(array.get(i));
			}
			for(String element:array){
				System.out.println(element);
			}*/
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.add(121);
			array.add(125);
			array.add(123);
			array.add(120);
			array.add(128);
			
			//array.add(1,7);
			//array.set(1,10);
			//array.remove(3);
			//array.clear();
			for(int i = 0;i<array.size();i++){
				System.out.println(array.get(i));
			}
		}
}