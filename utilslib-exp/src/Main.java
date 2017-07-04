

public class Main
{

	public static void main(String[] args)
	{
		//         xxxxxxxxxxxxxxx x
		double a = 987654321987654.1;
		
		//         xx xxxxxxxxxxxxxx
		double b = 15.123465789123456789123456789;
		double c = a + b;
		
		double d = 4.54345434543;
		
		double r1 = c / d;
		double _r21 = a / d;
		double _r22 = b / d;
		double r2 = _r21 + _r22; 
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(r1);
		System.out.println(r2);
	}

}
