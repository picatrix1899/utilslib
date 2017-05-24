import cmn.utilslib.color.colors.HDRColor3;
import cmn.utilslib.color.colors.api.IColor3;
import cmn.utilslib.color.colors.api.IColor3Base;
import cmn.utilslib.color.colors.api.IHDRColor3;
import cmn.utilslib.color.colors.api.IHDRColor3Base;

public class HDRColor3Examples
{
	/**
	 * Examples for the different constructors
	 */
	public static void Test1()
	{
		HDRColor3 color1 = new HDRColor3();
		HDRColor3 color2 = new HDRColor3(50, 100, 200);
		HDRColor3 color3 = new HDRColor3(0.0f, 1.0f, 0.5f);
		
		System.out.println(color1);
		System.out.println(color2);
		System.out.println(color3);
	}
	
	/**
	 * Examples for different cloning scenarios
	 */
	public static void Test2()
	{
		
		IColor3Base color1 = new HDRColor3();
		IColor3 color2 = new HDRColor3();
		IHDRColor3Base color3 = new HDRColor3();
		IHDRColor3 color4 = new HDRColor3();
		HDRColor3 color5 = new HDRColor3();
		
		System.out.println(color1);
		System.out.println(color2);
		System.out.println(color3);
		System.out.println(color4);
		System.out.println(color5);
		
		System.out.println();
		
		IColor3Base color1_ = color1.clone();
		IColor3 color2_ = color2.clone();
		IHDRColor3Base color3_ = color3.clone();
		IHDRColor3 color4_ = color4.clone();
		IHDRColor3 color5_ = color5.clone();
		
		System.out.println(color1_);
		System.out.println(color2_);
		System.out.println(color3_);
		System.out.println(color4_);
		System.out.println(color5_);
		
		System.out.println();
		
		IColor3Base color1_l1 = color1.clone();
		IColor3 color1_l2 = (IColor3) color1.clone();
		IHDRColor3Base color1_l3 = (IHDRColor3Base) color1.clone();
		IHDRColor3 color1_l4 = (IHDRColor3) color1.clone();
		HDRColor3 color1_l5 = (HDRColor3) color1.clone();
		
		System.out.println(color1_l1);
		System.out.println(color1_l2);
		System.out.println(color1_l3);
		System.out.println(color1_l4);
		System.out.println(color1_l5);
		
	}
	
	/**
	 * 
	 */
	public static void Test3()
	{
		IHDRColor3Base color = HDRColor3.BLACK;
		
		System.out.println(color);
		
		color = color.clone();
		
		System.out.println(color);

	}
	
	public static void Test4()
	{
		
		IHDRColor3Base color = HDRColor3.YELLOW;
		
		System.out.println("R: " + color.getR() + " G: " + color.getG() + " B: "+ color.getB());
		System.out.println("Ru: " + color.getUnityR() + " Gu: " + color.getUnityG() + " B: " + color.getUnityB());
		
	}
	
	public static void Test5()
	{
		IHDRColor3 color = (IHDRColor3) HDRColor3.RED.clone();
		
		color.setR(100).setG(50).setB(200);
		
		System.out.println(color);
		
		color.set(23, 85, 102);
		
		System.out.println(color);
		
		IHDRColor3 color2 = (IHDRColor3) HDRColor3.BLACK.clone();
		
		System.out.println(color2);
		
		color2.set(color);
		
		System.out.print(color2);
		
	}
	
	
}
