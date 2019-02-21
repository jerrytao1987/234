package cn.itcast.web.servlet;

public class MyServletImpl implements IMyServlet {

	@Override
	public void init() {
		System.out.println("啊，俺来也.....");
	}

	@Override
	public void serverce() {
		System.out.println("我可以为你服务....");
	}

	@Override
	public void destory() {
		System.out.println("啊，俺去也......");
	}

}
