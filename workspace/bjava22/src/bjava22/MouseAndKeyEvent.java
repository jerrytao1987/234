package bjava22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseAndKeyEvent {

	// 定义该图形中所需的组件的引用
	private Frame f;
	private Button btn;
	private TextField tf;

	public MouseAndKeyEvent() {
			init();
		}

	public void init() {
		f = new Frame("my frame");
		// 对frame进行基本设置
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		btn = new Button("my button");
		// 将组件添加到frame中
		f.add(btn);
		
		tf=new TextField(20);
		f.add(tf);
		// 加载一下窗体上事件
		myEvent();

		// 显示窗体
		f.setVisible(true);
	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 让按钮具备退出程序的功能
		/*
		 * 按钮就是事件源 那么选择哪个监听器呢？ 通过关闭窗体示例了解到，想要知道哪个组件具备什么样的特有监听器 需要查看该组件对象的功能
		 * 通过查阅button的描述，发现按钮支持一个特有监听addActionListener
		 */
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed ok");
				//System.exit(0);
			}
		});
		btn.addMouseListener(new MouseAdapter() {
			private int count=1;
			private int clickCount=1;
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标进入到该组件"+count++);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					System.out.println("双击动作");
				}
				System.out.println("点击动作"+clickCount++);
			}
			
		});
		btn.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"......"+e.getKeyChar()+"......"+e.getKeyCode());
				/*if(e.getKeyCode()==KeyEvent.VK_ESCAPE){//Esc-27-VK_ESCAPE
					System.exit(0);
				}*/
				if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("ctrl+enter is run");
				}
			}
			
		});
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)){
					System.out.println(code+"...是非法的");
					e.consume();
				}
			}
			
		});
	}

	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}
}
