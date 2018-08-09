package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class ValidateTrue
{
	static void isTrue(int stackreduction, boolean value)
	{
		if(Check.notTrue(value))
		{
			ValidationError error = new ValidationError("isTrue", "The value is false!");
			
			error.throwError(stackreduction);
		}
	}
	
	static void isTrue(int stackreduction, boolean... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		
		for(int i = 0; i < values.length; i++)
			if(Check.notTrue(values[i]))
				indices.add(i);
		
		if(indices.size() > 0)
		{
			StringBuilder builder = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			ValidationError error = new ValidationError("isTrue(Multi)", "At least one of the values is false!");
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + indices.size());
			
			error.throwError(stackreduction);
		}
	}
	
	static void isTrueOOO(int stackreduction, boolean... values)
	{
		if(Check.notTrue(values))
		{
			ValidationError error = new ValidationError("isTrue(One Out Of)", "All the values are false!");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notTrue(int stackreduction, boolean value)
	{
		if(Check.isTrue(value))
		{
			ValidationError error = new ValidationError("notTrue", "The value is true!");
			
			error.throwError(stackreduction);
		}
	}
	
	static void notTrue(int stackreduction, boolean... values)
	{
		ArrayList<Integer> indices = Auto.ArrayList(); 
		
		for(int i = 0; i < values.length; i++)
			if(Check.isTrue(values[i]))
				indices.add(i);
		
		if(indices.size() > 0)
		{
			StringBuilder builder = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			ValidationError error = new ValidationError("notTrue(Multi)", "At least one of the values is true!");
			
			error.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			error.details.add("total failed: " + indices.size());
			
			error.throwError(stackreduction);
		}
	}
	
	static void notTrueOOO(int stackreduction, boolean... values)
	{
		if(Check.isTrue(values))
		{
			ValidationError error = new ValidationError("notTrue(One Out Of)", "All the values are true!");
			
			error.throwError(stackreduction);
		}
	}
}
