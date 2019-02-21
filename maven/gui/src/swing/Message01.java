package swing;

import javax.swing.JOptionPane;

public class Message01 {
	  public static void main(String[] args){
		   for(;;) {
		       try
		        { String input=JOptionPane.showInputDialog("请输入第一个整数：");
		           int a=Integer.parseInt(input);
		           input=JOptionPane.showInputDialog("请输入第二个整数：");
		           int b=Integer.parseInt(input);
		           int sum=a+b;
		           System.out.println("sum="+sum);System.exit(0);   //循环出口
		        }
		       catch (NumberFormatException e)
		           { JOptionPane.showMessageDialog(null,"输入数据错误1");
			continue;    }
		      }  //end for
		  }

}
