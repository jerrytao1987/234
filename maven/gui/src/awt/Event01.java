package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event01 extends Frame implements ActionListener {

	static Event01 frm = new Event01();
	static Button bt = new Button("设置字体颜色");
	static TextArea ta = new TextArea("字体颜色", 5, 20);

	public static void main(String args[]) {
		bt.addActionListener(frm); // 监听者frm向事件源bt注册
		frm.setTitle("操作事件");
		frm.setLayout(new FlowLayout());
		frm.setSize(260, 170);
		frm.add(ta);
		frm.add(bt);
		frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) // 覆盖事件处理
	{
		ta.setForeground(Color.red); // 把文本设置为红色
	}

}
