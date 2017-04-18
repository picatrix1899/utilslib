package cmn.utilslib.geometry;

public class DoubleGraph
{

	private DoubleGraphNode graph;
	
	public double getNearestIndex(double in)
	{
		
	}
	
	public void insert(double index, double value)
	{
		DoubleGraphNode node = graph;
		
		while(node.next.index < index)
		{
			node = node.next;
		}
		
		DoubleGraphNode next = node.next;
	}
	
	
}
