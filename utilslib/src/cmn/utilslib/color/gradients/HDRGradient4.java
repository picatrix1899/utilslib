package cmn.utilslib.color.gradients;

import java.util.ArrayList;

import cmn.utilslib.color.colors.PHDRColor4;
import cmn.utilslib.color.colors.api.IHDRColor4Base;
import cmn.utilslib.essentials.Auto;

public class HDRGradient4
{
	
	private ArrayList<HDRGradient4Node> nodes = Auto.ArrayList();

	public void insert(double index, IHDRColor4Base value)
	{
		HDRGradient4Node node = new HDRGradient4Node();
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
	
	public IHDRColor4Base get(double index)
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
		
		HDRGradient4Node a = this.nodes.get(ind - 1);
		HDRGradient4Node b = this.nodes.get(ind);
		
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
	
	private static class HDRGradient4Node
	{
		public IHDRColor4Base value;
		public double index;
	}
	
	private IHDRColor4Base linearize(IHDRColor4Base a, IHDRColor4Base b, double t)
	{
		int _r = (int)Math.round((1.0d - t) * a.getR() + t * b.getR());
		int _g = (int)Math.round((1.0d - t) * a.getG() + t * b.getG());
		int _b = (int)Math.round((1.0d - t) * a.getB() + t * b.getB());
		int _a = (int)Math.round((1.0d - t) * a.getA() + t * b.getA());

		return PHDRColor4.gen(_r, _g, _b, _a);
	}
	
}
