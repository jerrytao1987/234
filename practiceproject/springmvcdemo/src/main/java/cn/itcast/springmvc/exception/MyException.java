package cn.itcast.springmvc.exception;

public class MyException extends Exception {
	//private String msg;

	public MyException() {
		super();
	}

	public MyException(String msg) {
		super(msg);
		//this.msg = msg;
	}

	/*public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}*/
	
}
