package cmn.utilslib.geometry;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;

public class Graph
{
	
	private ArrayList<GraphNode> nodes = Auto.ArrayList();

	public void insert(double index, double value)
	{
		GraphNode node = new GraphNode();
		node.index = index;
		node.value = value;
		
		int ind = 0;
		
		for(int i = 0; i < this.nodes.size(); i++)
		{
			if(index >= this.nodes.get(i).index)
			{
				ind++;
			}
			else
			{
				break;
			}
		}

		this.nodes.add(ind, node);
	}
	
	public double get(double index)
	{
		int ind = 0;
		
		for(int i = 0; i < this.nodes.size(); i++)
		{
			if(index > this.nodes.get(i).index)
			{
				ind++;
			}
			else
			{
				break;
			}
		}
		
		GraphNode a = this.nodes.get(ind - 1);
		GraphNode b = this.nodes.get(ind);
		
		if(index == a.index)
		{
			return a.value;
		}
		
		if(index == b.index)
		{
			return b.value;
		}
		
		double transformedIndex = index - a.index;
		
		double span = b.index * 1.0d - a.index * 1.0d;
		
		double normalizedIndex = transformedIndex / span * 1.0d;

		return linearize(a.value, b.value, normalizedIndex);
	}
	
	private static class GraphNode
	{
		public double value;
		public double index;
	}
	
	private double linearize(double a, double b, double t)
	{
		return (1.0d - t) * a + t * b;
	}
}
