package cmn.utilslib.color.gradients;

import java.util.ArrayList;

import cmn.utilslib.color.colors.PHDRColor3;
import cmn.utilslib.color.colors.api.IHDRColor3Base;
import cmn.utilslib.essentials.Auto;

public class HDRGradient3
{
	
	private ArrayList<HDRGradient3Node> nodes = Auto.ArrayList();

	public void insert(double index, IHDRColor3Base value)
	{
		HDRGradient3Node node = new HDRGradient3Node();
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
	
	public IHDRColor3Base get(double index)
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
		
		HDRGradient3Node a = this.nodes.get(ind - 1);
		HDRGradient3Node b = this.nodes.get(ind);
		
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
	
	private static class HDRGradient3Node
	{
		public IHDRColor3Base value;
		public double index;
	}
	
	private IHDRColor3Base linearize(IHDRColor3Base a, IHDRColor3Base b, double t)
	{
		int _r = (int)Math.round((1.0d - t) * a.getR() + t * b.getR());
		int _g = (int)Math.round((1.0d - t) * a.getG() + t * b.getG());
		int _b = (int)Math.round((1.0d - t) * a.getB() + t * b.getB());

		return PHDRColor3.gen(_r, _g, _b);
	}
	
}
