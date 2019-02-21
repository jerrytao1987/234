package swing;

import java.awt.*;

import javax.swing.JFrame;

public class Menu01 {
	public static void main(String args[])
	 {  MenuBar mb=new MenuBar();   
	       Menu m1=new Menu("文件"); 
	        MenuItem m11=new MenuItem("Open");
	        MenuItem m12=new MenuItem("SavaAs");
	       m1.add(m11);    m1.add(m12);
	       Menu m2=new Menu("编辑");   
	        MenuItem m21=new MenuItem("Patse");
	        MenuItem m22=new MenuItem("Copy");
	       m2.add(m21);  m2.add(m22);
	    mb.add(m1) ; mb.add(m2) ;
	    Frame f=new Frame("MyMenu");
	    f.setMenuBar(mb);
	    f.setSize(200,130);
	    f.setVisible(true);
	    }

}
