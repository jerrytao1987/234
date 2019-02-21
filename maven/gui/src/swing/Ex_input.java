package swing;

import javax.swing.JOptionPane;

public class Ex_input {
	 public static void main(String[] args){
		 String input=JOptionPane.showInputDialog("请输入第一个整数：");
		 int a=Integer.parseInt(input);
		 input=JOptionPane.showInputDialog("请输入第二个整数：");
		 int b=Integer.parseInt(input);
		 int sum=a+b;
		 System.out.println("sum="+sum);
		 }

}
