package cmn.picatrix1899.utilslib.essentials;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 

 * @author picatrix1899
 *
 */
public class ListUtils
{
	public static <A> int[] indicesOf(ArrayList<A> list, A a)
	{
	
		Validate.notEmpty(list);
		
		if(ListUtils.occurrencesOf(list, a) == 0) return null;
		
		int[] out = new int[ListUtils.occurrencesOf(list, a)]; 
		
		int index = 0;
		
		for(int i = 0; i < list.size(); i++)
		{
			
			if(list.get(i).equals(a) || list.get(i) == a)
			{
				out[index] = i;
				index++;
			}		
			
		}
		
		return out;
	}
	
	public static <A> int occurrencesOf(ArrayList<A> list, A a)
	{
		
		Validate.notEmpty(list);
		
		int i = 0;
		
		for(A val : list)
		{
			if(val.equals(a) || val == a)
			{
				i++;
			}
		}
		
		return i;
	}
	
	public static <A> A[] ListToArray(ArrayList<A> list, Class<A> c)
	{
		
		@SuppressWarnings("unchecked")
		A[] out = (A[]) Array.newInstance(c, list.size());
		
		out = list.<A>toArray(out);
		
		return out;
		
	}
	
	public static int[] toIntArray(ArrayList<Integer> a)
	{
		int[] out = new int[a.size()];
		
		for(int i = 0; i < a.size(); i++)
		{
			out[i] = a.get(i);
		}
		
		return out;
	}
	
	public static byte[] toByteArray(ArrayList<Byte> a)
	{
		byte[] out = new byte[a.size()];
		
		for(int i = 0; i < a.size(); i++)
		{
			out[i] = a.get(i);
		}
		
		return out;
	}
	
	public static float[] toFloatArray(ArrayList<Float> a)
	{
		float[] out = new float[a.size()];
		
		for(int i = 0; i < a.size(); i++)
		{
			out[i] = a.get(i);
		}
		
		return out;
	}
}