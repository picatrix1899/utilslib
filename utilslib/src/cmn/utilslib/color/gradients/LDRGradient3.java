package cmn.utilslib.color.gradients;

import java.util.ArrayList;

import cmn.utilslib.color.colors.PLDRColor3;
import cmn.utilslib.color.colors.api.ILDRColor3Base;
import cmn.utilslib.color.gradients.api.ILDRGradient3;
import cmn.utilslib.essentials.Auto;

public class LDRGradient3 implements ILDRGradient3
{
	
	private ArrayList<LDRGradient3Node> nodes = Auto.ArrayList();

	public LDRGradient3 insert(double index, ILDRColor3Base value)
	{
		LDRGradient3Node node = new LDRGradient3Node();
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
		
		return this;
	}
	
	public ILDRColor3Base get(double index)
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
		
		LDRGradient3Node a = this.nodes.get(ind - 1);
		LDRGradient3Node b = this.nodes.get(ind);
		
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
	

	
	private ILDRColor3Base linearize(ILDRColor3Base a, ILDRColor3Base b, double t)
	{
		int _r = (int)Math.round((1.0d - t) * a.getR() + t * b.getR());
		int _g = (int)Math.round((1.0d - t) * a.getG() + t * b.getG());
		int _b = (int)Math.round((1.0d - t) * a.getB() + t * b.getB());

		return PLDRColor3.gen(_r, _g, _b);
	}
	
	@Override
	public int getR(double index)
	{
		return get(index).getR();
	}

	@Override
	public int getG(double index)
	{
		return get(index).getG();
	}

	@Override
	public int getB(double index)
	{
		return get(index).getB();
	}

	@Override
	public float getUnityR(double index)
	{
		return get(index).getUnityR();
	}

	@Override
	public float getUnityG(double index)
	{
		return get(index).getUnityG();
	}

	@Override
	public float getUnityB(double index)
	{
		return get(index).getUnityB();
	}
	

	@Override
	public int nodes()
	{
		return this.nodes.size();
	}

	@Override
	public double minIndex()
	{
		if(this.nodes.size() > 0)
		{
			return this.nodes.get(0).index;
		}
		else
		{
			return 0.0d;
		}
	}

	@Override
	public double maxIndex()
	{
		if(this.nodes.size() > 0)
		{
			return this.nodes.get(this.nodes.size() - 1).index;
		}
		else
		{
			return 0.0d;
		}
	}
	
	private static class LDRGradient3Node
	{
		public ILDRColor3Base value;
		public double index;
	}

}
