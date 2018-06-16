
package cmn.utilslib.color.colors.api;


public interface ILDRColor3 extends ILDRColor3Base, IColor3
{
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setR(int r);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setG(int g);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setB(int b);
	
	
	ILDRColor3 setUnityR(float r);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setUnityG(float g);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setUnityB(float b);
	
	
	/** {@inheritDoc}} */ @Override
	ILDRColor3 set(int brightness);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 set(IColor3Base color);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 set(int r, int g, int b);
	
	
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setUnity(float brightness);
	/** {@inheritDoc}} */ @Override
	ILDRColor3 setUnity(float r, float g, float b);
	
	
	@Override
	ILDRColor3 clone();
}

