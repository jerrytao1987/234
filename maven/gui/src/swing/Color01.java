package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class Color01 {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("LocalColor v1.0");
        final Container content = frame.getContentPane();   //创建容器（目录框）
        content.setLayout(new GridBagLayout());
        JButton button = new JButton("Change color...");
        content.add(button);
       
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {    //事件处理方法体
                   Color c = JColorChooser.showDialog(frame,"Choose a color",
                   content.getBackground());   //用颜色选择器返回颜色对象 c
                   if(c != null) 
                    content.setBackground(c);
                  }
             });
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
