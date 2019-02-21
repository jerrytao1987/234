package bjava22;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MyMenuDemo {
	private Frame f;
	private MenuBar mb;
	private Menu m,subMenu;
	private MenuItem closeItem,subItem,openItem,saveItem;
	private FileDialog openDia,saveDia;
	private TextArea ta;
	private File file;
	
	MyMenuDemo(){
		init();
	}
	private void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		//f.setLayout(new FlowLayout());
		
		mb = new MenuBar();
		m = new Menu("文件");
		subMenu = new Menu("子菜单");
		subItem = new MenuItem("子条目");
		closeItem = new MenuItem("退出");
		
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		m.add(openItem);
		m.add(saveItem);
		openDia = new FileDialog(f, "我要打开", FileDialog.LOAD);
		saveDia = new FileDialog(f, "我要打开", FileDialog.SAVE);
		
		ta = new TextArea();
		
		subMenu.add(subItem);
		
		m.add(subMenu);
		m.add(closeItem);
		mb.add(m);
		
		f.setMenuBar(mb);
		f.add(ta);
		MyEvent();
		
		f.setVisible(true);
	}
	private void MyEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				System.out.println(dirPath+"..."+fileName);
				if(dirPath==null || fileName==null){
					return;
				}
				ta.setText("");
				file = new File(dirPath,fileName);
				try {
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while((line=bufr.readLine())!=null){
						ta.append(line+"\r\n");
					}
					bufr.close();
				} catch (Exception e2) {
					throw new RuntimeException("读取失败！");
				}
			}
		});
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(file==null){
					saveDia.setVisible(true);
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if(dirPath==null || fileName==null){
						return;
					}
					file = new File(dirPath,fileName);
				}
				try {
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					bufw.write(text);
					bufw.close();
				} catch (Exception e) {
					throw new RuntimeException();
				}
				
			}
		});
	}
	public static void main(String[] args) {
		new MyMenuDemo();
	}
}
