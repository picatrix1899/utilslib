package cmn.utilslib.color.gradients;

import java.util.ArrayList;

import cmn.utilslib.color.colors.PLDRColor4;
import cmn.utilslib.color.colors.api.ILDRColor4Base;
import cmn.utilslib.essentials.Auto;

public class LDRGradient4
{
	
	private ArrayList<LDRGradient4Node> nodes = Auto.ArrayList();

	public void insert(double index, ILDRColor4Base value)
	{
		LDRGradient4Node node = new LDRGradient4Node();
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
	
	public ILDRColor4Base get(double index)
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
		
		LDRGradient4Node a = this.nodes.get(ind - 1);
		LDRGradient4Node b = this.nodes.get(ind);
		
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
	
	private static class LDRGradient4Node
	{
		public ILDRColor4Base value;
		public double index;
	}
	
	private ILDRColor4Base linearize(ILDRColor4Base a, ILDRColor4Base b, double t)
	{
		int _r = (int)Math.round((1.0d - t) * a.getR() + t * b.getR());
		int _g = (int)Math.round((1.0d - t) * a.getG() + t * b.getG());
		int _b = (int)Math.round((1.0d - t) * a.getB() + t * b.getB());
		int _a = (int)Math.round((1.0d - t) * a.getA() + t * b.getA());

		return PLDRColor4.gen(_r, _g, _b, _a);
	}
	
}
