package tests.tools;

import java.util.ArrayList;
import java.util.List;

import cmn.utilslib.essentials.Auto;
import cmn.utilslib.exceptions.IErrorHandler;

public class CaptureErrorHandler implements IErrorHandler
{
	private int count;
	private ArrayList<Class<? extends Exception>> types = Auto.ArrayList();
	private ArrayList<Exception> exceptions = Auto.ArrayList();
	
	
	public int getCount()
	{
		return this.count;
	}
	
	public List<Class<? extends Exception>> getTypes()
	{
		return this.types;
	}
	
	public Class<? extends Exception> getType(int index)
	{
		return this.types.get(index);
	}
	
	public List<Exception> getExceptions()
	{
		return this.exceptions;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Exception> T getException(int index, Class<T> clazz)
	{
		return (T) this.exceptions.get(index);
	}
	
	public void reset()
	{
		this.count = 0;
		this.types.clear();
		this.exceptions.clear();
	}

	public void handle(Exception e)
	{
		this.count++;
		this.exceptions.add(e);
		this.types.add(e.getClass());
	}
}
