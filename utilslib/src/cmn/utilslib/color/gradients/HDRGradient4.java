package cmn.utilslib.color.gradients;

import java.util.ArrayList;

import cmn.utilslib.color.colors.PHDRColor4;
import cmn.utilslib.color.colors.api.IHDRColor4Base;

import cmn.utilslib.color.gradients.api.IHDRGradient4;
import cmn.utilslib.essentials.Auto;

public class HDRGradient4 implements IHDRGradient4
{
	
	private ArrayList<HDRGradient4Node> nodes = Auto.ArrayList();

	@Override
	public IHDRGradient4 insert(double index, IHDRColor4Base value)
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
		
		return this;
	}
	
	@Override
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
	

	
	private IHDRColor4Base linearize(IHDRColor4Base a, IHDRColor4Base b, double t)
	{
		int _r = (int)Math.round((1.0d - t) * a.getR() + t * b.getR());
		int _g = (int)Math.round((1.0d - t) * a.getG() + t * b.getG());
		int _b = (int)Math.round((1.0d - t) * a.getB() + t * b.getB());
		int _a = (int)Math.round((1.0d - t) * a.getA() + t * b.getA());

		return PHDRColor4.gen(_r, _g, _b, _a);
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
	public int getA(double index)
	{
		return get(index).getA();
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
	public float getUnityA(double index)
	{
		return get(index).getUnityA();
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

	private static class HDRGradient4Node
	{
		public IHDRColor4Base value;
		public double index;
	}

}
