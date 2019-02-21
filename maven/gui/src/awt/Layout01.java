package awt;

import java.awt.*;

public class Layout01 {
	
	public static void main(String args[])
	 {   Frame f=new Frame("This is a window!");
	      f.setLocation(100,200);
	      f.setSize(200,200);
	      //流式布局
	      f.setLayout(new FlowLayout());

	     Button[] jb=new Button[10];
	     for(int i=0;i<jb.length;i++)
	      {   jb[i]=new Button();
	          jb[i].setLabel(String.valueOf(i));
	          f.add(jb[i]);  }
	     f.setVisible(true);
	 }

}
