package awt;

import java.awt.*;

public class LoginFrame extends Frame {
	public LoginFrame(){
		super("用户登录");
		this.setSize(200,120);
		this.setLocation(300,240);
		this.setBackground(Color.lightGray);
		this.setLayout(new FlowLayout());
        
		this.add(new Label("userid"));
		this.add(new TextField("user1",10));
		this.add(new Label("password"));
		this.add(new TextField(10));
		this.add(new Button("ok"));
		this.add(new Button("cancel"));
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
}
