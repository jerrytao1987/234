package awt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

public class Ex6_1 {
	static Frame frm=new Frame("这是个AWT程序"); 
	  public static void main(String args[])
	  {
	    Label lab=new Label("我是一个标签"); //创建一个标签对象lab
	    lab.setFont(new Font("黑体", 0, 36));
	    frm.setSize(180,140);               //设置框架大小
	    frm.setBackground(Color.yellow);    //设置框架背景颜色
	    frm.setLocation(250,150);            //设置窗口的位置
	    frm.add(lab);              //将标签对象lab加入窗口中
	    frm.setVisible(true);      //将窗口显示出来
	  }

}
