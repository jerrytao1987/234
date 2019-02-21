package filedownload;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class FileDownloadGUI {
	private JFrame f;
	private JTextField tf, tfDest,tf2;
	private JLabel la, laDest, la1, lab,la2;
	private JButton b, b1, okBtn;
	private JPanel p1, p2, p3;
	private JDialog d;

	private FileDownloadGUI() {
		init();
	}

	private void init() {
		// 设置窗体
		Font font = new Font("黑体", 0, 16);
		f = new JFrame("文件下载");
		f.setBounds(300, 100, 600, 200);
		f.setResizable(false);
		GridLayout gridLayout = new GridLayout(3, 3);
		f.setLayout(gridLayout);
		// 设置用户在此窗体上发起 "close" 时默认执行的操作。
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

		// 设置网址输入栏
		la = new JLabel("请输入网址:");
		la.setFont(font);
		la.setBounds(32, 18, 100, 30);
		tf = new JTextField(40);
		tf.setBounds(130, 20, 440, 26);

		// 设置保存路径栏
		laDest = new JLabel("保存的路径:");
		laDest.setFont(font);
		laDest.setBounds(32, 10, 100, 30);
		tfDest = new JTextField(34);
		tfDest.setBounds(130, 12, 320, 26);
		b1 = new JButton("浏览");
		b1.setFont(font);
		b1.setBounds(470, 12, 100, 26);
		
		la2 = new JLabel("线程数：");
		la2.setFont(font);
		la2.setBounds(32, 10, 100, 30);
		tf2 = new JTextField("4",20);
		tf2.setBounds(130, 12, 320, 26);
		
		
		b = new JButton("开始下载");
		b.setFont(font);
		b.setBounds(470, 10, 100, 26);

		p1 = new JPanel(null);
		p2 = new JPanel(null);
		p3 = new JPanel(null);
		p1.add(la);
		p1.add(tf);
		p2.add(laDest);
		p2.add(tfDest);
		p2.add(b1);
		p3.add(la2);
		p3.add(tf2);
		p3.add(b);

		// 设置弹窗提示
		d = new JDialog(f, "提示信息", true);
		d.setBounds(450, 125, 300, 150);
		d.setLayout(null);
		lab = new JLabel();
		lab.setFont(font);
		lab.setBounds(30, 20, 280, 30);
		okBtn = new JButton("确定");
		okBtn.setFont(font);
		okBtn.setBounds(100, 60, 80, 30);
		d.add(lab);
		d.add(okBtn);

		/*
		 * f.add(la); f.add(tf); f.add(laDest); f.add(tfDest); f.add(b1);
		 * f.add(b);
		 */
		f.add(p1);
		f.add(p2);
		f.add(p3);

		myEvent();

		f.setVisible(true);
	}

	/**
	 * 绑定相关事件
	 */
	private void myEvent() {
		/*
		 * f.addWindowListener(new WindowAdapter() {
		 * 
		 * @Override public void windowClosing(WindowEvent arg0) {
		 * System.exit(0); }
		 * 
		 * });
		 */
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == b1) {
					JFileChooser fileChooser = new JFileChooser("D:\\");
					// 设置弹窗选择模式为文件夹目录
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					/*
					 * 弹出一个 "Open File" 文件选择器对话框。
					 * 该文件选择器被弹下时的返回状态： 
					 * JFileChooser.CANCEL_OPTION 选择 cancel 后的返回该值
					 * JFileChooser.APPROVE_OPTION 选择确认（yes、ok）后返回该值
					 * JFileChooser.ERROR_OPTION 如果发生错误或者该对话框已被解除
					 */
					int returnVal = fileChooser.showOpenDialog(fileChooser);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						String filePath = fileChooser.getSelectedFile().getAbsolutePath();// 这个就是你选择的文件夹的路径
						tfDest.setText(filePath);
					}
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
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String srcUrl = tf.getText();
				String fileDest = tfDest.getText();
				String countStr = tf2.getText();
				String reg = "http[s]?://(.*?)\\.\\w+";
				String reg1 = "[a-zA-Z]:.+";
				String reg2 = "[1-9][0-9]*";
				if (!srcUrl.matches(reg)) {
					lab.setText("您输入的网址有误，请重新输入");
					d.setVisible(true);
					return;
				}
				if (!fileDest.matches(reg1)) {
					lab.setText("保存路径不正确，请重新输入");
					d.setVisible(true);
					return;
				}
				if(!countStr.matches(reg2)){
					lab.setText("线程数不正确，请重新输入");
					d.setVisible(true);
					return;
				}
				int count = Integer.parseInt(countStr);
				int flag = RandomAccessFileTool.fileDownload(count,srcUrl, fileDest);
				if (flag == 1) {
					lab.setText("下载成功");
					d.setVisible(true);
					return;
				} else {
					lab.setText("下载失败");
					d.setVisible(true);
					return;
				}
			}
		});
	}

	public static void main(String[] args) {
		new FileDownloadGUI();
	}
}
