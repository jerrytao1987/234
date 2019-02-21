package cn.itcast.hotel;

public class Test {

	public static void main(String[] args) {
		JingLi jl = new JingLi("小名","jl001",123456.43);
		jl.work();
		FuWuYuan f = new FuWuYuan("翠花","f001");
		f.work();
		f.services();
		ChuShi c = new ChuShi("老干妈","c001");
		c.work();
		c.services();
		
	}

}
