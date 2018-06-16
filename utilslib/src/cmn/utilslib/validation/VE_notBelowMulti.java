package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class VE_notBelowMulti extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_notBelowMulti(int stackreduction, int max, int... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Integer> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("exclusive maximum threshold: " + max);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelowMulti(int stackreduction, long max, long... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Long> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("exclusive maximum threshold: " + max + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelowMulti(int stackreduction, float max, float... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Float> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("exclusive maximum threshold: " + max + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_notBelowMulti(int stackreduction, double max, double... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Double> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.isBelow(max, values[i]))
			{
				indices.add(i);
				vals.add(values[i]);
			}
		
		if(indices.size() > 0)
		{
			StringBuilder builder1 = new StringBuilder();
			StringBuilder builder2 = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder1.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			for(int i = 0; i < vals.size(); i++)
				builder2.append(vals.get(i)).append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("exclusive maximum threshold: " + max + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_notBelowMulti() { super("notBelow(Multi)", "At least one of the values is below exclusive maximum threshold!"); }
	
}
