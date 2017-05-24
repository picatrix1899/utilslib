import cmn.utilslib.essentials.Maths;

public class Main
{

	public static void main(String[] args)
	{
		float pos = 25.0f;
		
		float minPos = 0.0f;
		float minVal = 0.0f;
		float maxPos = 100.0f;
		float maxVal = 200.0f;
		
		float out = 0.0f;
		
		
		System.out.println("Pos: " + pos);
		
		out = Maths.img(pos, maxPos, maxVal);
		
		System.out.println("Val: " + out);
		
		out = Maths.rimg(out, maxPos, maxVal);
		
		System.out.println("Pos: " + out);
	}

	
}
