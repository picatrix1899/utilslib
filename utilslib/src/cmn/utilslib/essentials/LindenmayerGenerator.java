package cmn.utilslib.essentials;

import java.util.ArrayList;

import cmn.utilslib.vector.Vec2f;

public class LindenmayerGenerator
{
	
	public double initDir = -85.0d;
	public int initDepth = 5;
	public double initRot = 27.1d;
	public double initStepLength = 4.0d;
	
	private double cDir;
	private int cDepth;
	private double cRot;
	private double cStepLength;
	private Vec2f a;
	private Vec2f b;	
	
	
	private ArrayList<Vec2f> points;
	

	
	private String sequence;
	
	public int count = 0;
	
	public void init()
	{
		cDir = initDir;
		cDepth = initDepth;
		cRot = initRot;
		cStepLength = initStepLength;
		
		a = new Vec2f();
		b = new Vec2f();
		
		points = new ArrayList<Vec2f>();
	}
	
	public void generate(String axiom, String... way)
	{
		sequence = axiom;
		
		for(int i = 0; i < cDepth; i++)
		{
			sequence = sequence.replaceAll("F", way[0]);
			sequence = sequence.replaceAll("X", way[1]);
		}
		
		char c;
		
		ArrayList<Vec2f> lastA = new ArrayList<Vec2f>();
		ArrayList<Vec2f> lastB = new ArrayList<Vec2f>();
		ArrayList<Double> lastDir = new ArrayList<Double>();
		
		for(int i = 0; i < sequence.length(); i++)
		{
			c = sequence.charAt(i);
			
			if(c == '-')
			{
				cDir -= cRot;
			}
			else if(c == '+')
			{
				cDir += cRot;
			}
			else if(c == '[')
			{
				lastA.add(a.clone());
				lastB.add(b.clone());
				lastDir.add(cDir);
			}
			else if(c == ']')
			{
				a = lastA.get(lastA.size() - 1);
				b = lastB.get(lastB.size() - 1);
				cDir = lastDir.get(lastDir.size() - 1);
				lastA.remove(lastA.size() - 1);
				lastB.remove(lastB.size() - 1);
				lastDir.remove(lastDir.size() - 1);
				
			}
			else
			{
				double rad = cDir * Maths.DEG_TO_RAD;
				
				int p = (int) (cStepLength * Math.cos(rad));
				int q = (int) (cStepLength * Math.sin(rad));
				
				b = new Vec2f(a.x + p, a.y + q);
				
				points.add(a.clone());
				points.add(b.clone());
				
				a = b.clone();
			}
		}
	}
	
	
	public Vec2f[] get()
	{
		Vec2f[] out;
		out = new Vec2f[points.size()];
		for (int i = 0; i < points.size(); i++)
		{
			out[i] = points.get(i);
		}
		
		return out;
	}
	
}
