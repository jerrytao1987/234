	public class Demo
		{
			public static void main(String[] args) 
			{
				System.out.println(15);
				System.out.println(0B1111);
				System.out.println(0xF);
				System.out.println(017);
				
				System.out.println(true);
				System.out.println(false);
				int x = 2,y=3;

				switch(x)
				{
					default:
						y++;
					case 3:
						y++;
						break;
					case 4:
						y++;
				}

				System.out.println("y="+y);
	
			}
		}
