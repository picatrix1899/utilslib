
import cmn.utilslib.geometry.Graph;

public class Main
{

	public static void main(String[] args)
	{
		Graph graph = new Graph();
		
		graph.insert(0.0d, 0.0d);
		graph.insert(50.0d, 50.0d);
		graph.insert(100.0d, 0.0d);
		graph.insert(25, 0);
		
		System.out.println(graph.get(26.0d) + "t");
	}

}
