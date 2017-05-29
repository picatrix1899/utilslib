import cmn.utilslib.essentials.Maths;

public class Main
{

	public static void main(String[] args)
	{

		String s = "<|Test|>Test";

		System.out.println(s);
		
		s = s.replaceAll("<\\|Test\\|>", "BLA");
		
		System.out.println(s);
		
	}

	
}
