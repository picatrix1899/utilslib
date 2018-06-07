
package cmn.utilslib.color.colors.api;


public interface IHDRColor3 extends IHDRColor3Base, IColor3
{
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setR(int r);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setG(int g);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setB(int b);
	
	
	IHDRColor3 setUnityR(float r);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setUnityG(float g);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setUnityB(float b);
	
	
	/** {@inheritDoc}} */ @Override
	IHDRColor3 set(int brightness);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 set(IColor3Base color);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 set(int r, int g, int b);
	
	
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setUnity(float brightness);
	/** {@inheritDoc}} */ @Override
	IHDRColor3 setUnity(float r, float g, float b);
	
	
	@Override
	IHDRColor3 clone();
}

