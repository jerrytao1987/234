package awt;

import java.awt.*;

import javax.swing.JPanel;

public class Layout02 extends Frame {
	public Layout02(){
	       super("Test");
	       setBackground(Color.BLACK);
	       //网格布局
	       setLayout(new GridLayout(6,6,2,2));
	       for ( int i=0;i<36; i++){
	         JPanel jPanel = new JPanel();
	         jPanel.setBackground(new Color (
	            (int)(Math.random()*16777215)));
	         add(jPanel);    
	         }
	       setSize(400,400);
	       setVisible(true);     
	}
	public static void main(String[] args)
	{  
	   new Layout02();     
	}

}
