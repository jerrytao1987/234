package awt;

import java.awt.Color;
import java.awt.Frame;

public class Ex6_2 extends Frame {
	  public static void main(String args[])
	  {
	   Frame MyFrame=new Frame("MyTest");
	   MyFrame.setSize(200,200);           //设置框架大小
	   MyFrame.setBackground(Color.red);   //背景颜色,用Color类常量
	   MyFrame.setBackground(new Color(255,100,240));   //背景颜色,用
	   MyFrame.setVisible(true);           //将窗口显示出来
	  }

}
