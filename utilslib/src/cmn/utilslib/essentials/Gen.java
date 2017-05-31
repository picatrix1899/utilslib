package cmn.utilslib.essentials;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import cmn.utilslib.vector.Vector2f;

/**
 * 

 * @author picatrix1899
 *
 */
public class Gen
{
	public static class RND
	{
		
		private static Random rnd = new Random();
		
		public static int getRandomInt(int min, int max)
		{
			return rnd.nextInt() * (max - min) + min;
		}
		
		public static float getRandomFloat(float min, float max)
		{
			return rnd.nextFloat() * (max - min) + min;
		}
		
		public static void setSeed(long seed)
		{
			rnd.setSeed(seed);
		}
	}
	
	public static class ID
	{
		private static ArrayList<UUID> uuids = new ArrayList<UUID>();
		
		public static UUID getUUID()
		{
			UUID id = UUID.randomUUID();
			
			if(uuids.contains(id))
			{
				return getUUID();
			}
			
			uuids.add(id);
			
			return id;
		}
	}
	
	public static class Lindenmayer
	{
		public static final double DEFAULT_ROT = 27.1d;
		public static final int DEFAULT_DEPTH = 6;
		public static final int DEFAULT_STEPLENGTH = 3;
		public static final double DEFAULT_START_DIR = -85.0d;
		
		public static final String DEFAULT_WAY = "F[+F]F[-F]F";
		public static final String DEFAULT_AXIOM = "F";
		
		public static double rot = DEFAULT_ROT;
		public static int initDepth = DEFAULT_DEPTH;
		public static int stepLength = DEFAULT_STEPLENGTH;
		public static double initDir = DEFAULT_START_DIR;
		
		private static ArrayList<Vector2f> points;
		private static int depth;
		private static double dir;
		private static Vector2f a, b;
		
		public static Vector2f[] generate2D(String axiom, String way)
		{
			points = new ArrayList<Vector2f>();
			Vector2f[] out;

			depth = initDepth;
			dir = initDir;
			
			a = new Vector2f();
			
			calcPoint(axiom, way);
			
			
			out = new Vector2f[points.size()];
			for (int i = 0; i < points.size(); i++)
			{
				out[i] = points.get(i);
			}
			
			return out;
		}
		
		private static void calcPoint(String axiom, String way)
		{
			if(depth == 0) return;
			depth--;
			
			Vector2f aMark = new Vector2f();
			double dirMark = 0.0d;
			
			int i;
			char c;
			
			for(i = 0; i < axiom.length(); i++)
			{
				c = axiom.charAt(i);
				
				if(c == 'F')
				{
					calcPoint(way, way);
					
					if(depth == 0)
					{
						double rad = dir * Maths.DEG_TO_RAD;
						
						int p = (int) (stepLength * Math.cos(rad));
						int q = (int) (stepLength * Math.sin(rad));
						
						b = new Vector2f(a.x + p, a.y + q);
						
						points.add(a.clone());
						points.add(b.clone());
						
						a = b;
					}
				}
				else if(c =='+')
				{
					dir += rot;
				}
				else if(c == '-')
				{
					dir -= rot;
				}
				else if(c == '[')
				{
					aMark = a;
					dirMark = dir;
				}
				else if(c == ']')
				{
					a = aMark;
					dir = dirMark;
				}
			}
		}
		
	}

	
	
	
	
	
	
}
