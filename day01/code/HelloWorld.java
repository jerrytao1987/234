/*
    ʵ����һ��Java��HelloWord��
	ʵ�ֲ��裺
	1.����һ����
	2.����������
	3.һ���������̨�����HelloWorld
*/
public class HelloWorld{
	//main���������̶���ʽ���������ڵ�
	public static void main(String[] args){
		//ϵͳ ��� ��ӡ  ��ӡ������
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