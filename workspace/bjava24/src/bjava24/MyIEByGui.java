package bjava24;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class MyIEByGui {
	private Frame f;
	private TextField tf;
	private Button btn;
	private TextArea ta;
	
	private Dialog d;
	private Label lab;
	private Button okBtn;
	
	MyIEByGui(){
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(60);
		btn = new Button("转到");
		ta = new TextArea(25,70);
		
		d = new Dialog(f, "提示信息-self", true);
		d.setBounds(400, 200, 240, 100);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBtn = new Button("确定");
		d.add(lab);
		d.add(okBtn);
		
		f.add(tf);
		f.add(btn);
		f.add(ta);
		
		myEvent();
		f.setVisible(true);
	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDir();
			}

			
		});
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					showDir();
				}
			}
		});
		
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		
	}
	
	/*public void showDir() {
		//String text = tf.getText();
		String dirPath = tf.getText();
		File dir = new File(dirPath);
		if(dir.exists() && dir.isDirectory()){
			ta.setText("");
			String[] names = dir.list();
			for(String name:names){
				ta.append(name+"\r\n");
			}
		}else{
			String info = "您输入的信息："+dirPath+"是错误的，请重新输入！";
			lab.setText(info);
			d.setVisible(true);
		}
		//ta.setText(text);
		tf.setText("");
		//System.out.println(text);
	}*/
	/*public void showDir() {
		try {
			ta.setText("");
			String url = tf.getText();//http://192.168.0.106/ssh_easyUI/
			int index1=0;
			if(url.indexOf("//")!=-1){
				index1 = url.indexOf("//")+2;
			}
			int index2 = url.indexOf("/",index1);
			
			String str = url.substring(index1, index2);
			String[] arr = str.split(":");
			String host = str;
			int port = 80;
			if(str.indexOf(":",index1)!=-1){
				host=arr[0];
				port = Integer.parseInt(arr[1]);
			}
			String path = url.substring(index2);
			Socket s = new Socket(host,port);
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			out.println("GET "+path+" HTTP/1.1");
			out.println("Accept: application/x-ms-application, image/jpeg, application/xaml+xml, image/gif, image/pjpeg, application/x-ms-xbap, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, *");
			out.println("User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.2; Shuame)User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.2; Shuame)");
			out.println("Accept-Language: zh-CN");
			out.println("Host: "+host);
			out.println("Connection: closed");
			out.println();
			out.println();
			BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line = null;
			while((line=bufr.readLine())!=null){
				ta.append(line+"\r\n");
			}
			s.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}*/
	public void showDir() {
		try {
			ta.setText("");
			String urlPath = tf.getText();//http://192.168.0.106/ssh_easyUI/
			URL url = new URL(urlPath);
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			byte[] buff = new byte[1024];
			//int len = in.read(buff);
			int len = -1;
			while((len=in.read(buff))!=-1){
				ta.append(new String(buff, 0, len));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MyIEByGui();
	}
}
