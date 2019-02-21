/*
    实现了一个Java的HelloWord类
	实现步骤：
	1.定义一个类
	2.定义主方法
	3.一条命令，控制台输出了HelloWorld
*/
public class HelloWorld{
	//main主方法，固定格式，程序的入口点
	public static void main(String[] args){
		//系统 输出 打印  打印的内容
		System.out.println("HelloWorld");
		int a = 5;
 int b = 3;
 int c = 1;
int n2 = (a>b && b>c) ? (c++) : (++c);
System.out.println(b);
System.out.println(c);
System.out.println(n2);

	}
}