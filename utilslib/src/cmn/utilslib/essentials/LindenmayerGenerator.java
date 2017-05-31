package cmn.utilslib.essentials;

import java.util.ArrayList;

import cmn.utilslib.vector.Vector2f;

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
	private Vector2f a;
	private Vector2f b;	
	
	
	private ArrayList<Vector2f> points;
	

	
	private String sequence;
	
	public int count = 0;
	
	public void init()
	{
		cDir = initDir;
		cDepth = initDepth;
		cRot = initRot;
		cStepLength = initStepLength;
		
		a = new Vector2f();
		b = new Vector2f();
		
		points = new ArrayList<Vector2f>();
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
		
		ArrayList<Vector2f> lastA = new ArrayList<Vector2f>();
		ArrayList<Vector2f> lastB = new ArrayList<Vector2f>();
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
				
				b = new Vector2f(a.x + p, a.y + q);
				
				points.add(a.clone());
				points.add(b.clone());
				
				a = b.clone();
			}
		}
	}
	
	
	public Vector2f[] get()
	{
		Vector2f[] out;
		out = new Vector2f[points.size()];
		for (int i = 0; i < points.size(); i++)
		{
			out[i] = points.get(i);
		}
		
		return out;
	}
	
}
