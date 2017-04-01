package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class VE_isAboveMulti extends ValidationException
{

	private static final long serialVersionUID = 1L;

	
	
	public VE_isAboveMulti(int stackreduction, int min, int... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Integer> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
			this.details.add("exclusive minimum threshold: " + min);
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAboveMulti(int stackreduction, long min, long... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Long> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
			this.details.add("exclusive minimum threshold: " + min + "L");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAboveMulti(int stackreduction, float min, float... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Float> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
			this.details.add("exclusive minimum threshold: " + min + "F");
			
			super.handle(stackreduction);
		}
	}
	
	public VE_isAboveMulti(int stackreduction, double min, double... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		ArrayList<Double> vals = Auto.ArrayList();
		
		for(int i = 0; i < values.length; i++)
			if(Check.notAbove(min, values[i]))
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
			this.details.add("exclusive minimum threshold: " + min + "D");
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isAboveMulti() { super("isAbove(Multi)", "At least one of the values is not above exclusive minimum threshold!"); }
	
}
