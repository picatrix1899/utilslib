package cmn.picatrix1899.utilslib.essentials;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

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
	
	public static class SHA
	{
		
	}
}
