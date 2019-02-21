package bjava22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * 创建图形化界面：
 * import java.awt.*
 * import java.awt.event.*
 */
public class AwtDemo {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");
		f.setSize(500, 500);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());
		
		Button b = new Button("我是一个按钮");
		f.add(b);
		
		WindowListener l = new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("我活了");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("我关");
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("我被打开了");
			}
			
			
		};
		f.addWindowListener(l );
		
		f.setVisible(true);
		//System.out.println("hello world!");
	}
}

/*class MyWin extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		//System.out.println("window closing--"+e.toString());
		System.exit(0);
	}
}*/
