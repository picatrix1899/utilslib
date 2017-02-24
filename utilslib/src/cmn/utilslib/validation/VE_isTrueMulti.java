package cmn.utilslib.validation;

import java.util.ArrayList;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.essentials.Check;

public class VE_isTrueMulti extends ValidationException
{

	private static final long serialVersionUID = 1L;
	
	
	
	public VE_isTrueMulti(int stackreduction, boolean... values)
	{
		this();
		
		ArrayList<Integer> indices = Auto.ArrayList(); 
		
		for(int i = 0; i < values.length; i++)
			if(Check.notTrue(values[i]))
				indices.add(i);
		
		if(indices.size() > 0)
		{
			StringBuilder builder = new StringBuilder();
			
			for(int i = 0; i < indices.size(); i++)
				builder.append(indices.get(i) + 1).append(i == indices.size() - 1 ? "" : ", ");
			
			this.details.add("failed indices(1 based): " + "[" + builder.toString() + "]");
			this.details.add("total failed: " + indices.size());
			
			super.handle(stackreduction);
		}
	}
	
	private VE_isTrueMulti() { super("isTrue(Multi)", "At least one of the values is not true!"); }
	
}
