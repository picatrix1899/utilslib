package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class VE_isInRangeMulti extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_isInRangeMulti(int stackreduction, int min, int max, int... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.newArrayList(); 
		ArrayList<Integer> vals = Auto.newArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
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
			this.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRangeMulti(int stackreduction, long min, long max, long... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.newArrayList(); 
		ArrayList<Long> vals = Auto.newArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
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
				builder2.append(vals.get(i) + "L").append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isInRangeMulti(int stackreduction, float min, float max, float... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.newArrayList(); 
		ArrayList<Float> vals = Auto.newArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
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
				builder2.append(vals.get(i) + "F").append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}

	public VE_isInRangeMulti(int stackreduction, double min, double max, double... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.newArrayList(); 
		ArrayList<Double> vals = Auto.newArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notInRange(min, max, values[i]))
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
				builder2.append(vals.get(i) + "D").append(i == vals.size() - 1 ? "" : ", ");
				
			this.details.add("failed indices(1 based): " + "[" + builder1.toString() + "]");
			this.details.add("failed values: [" + builder2.toString() + "]");
			this.details.add("total failed: " + indices.size());
			this.details.add("expected inclusive limits: [min: " + min + "L, max: " + max + "L]");
			
			super.handle(stackreduction);
		}
	}
	
	
	
	private VE_isInRangeMulti() { super("isInRange(Multi)", "At least one of the values is not in range!"); }
	
}
