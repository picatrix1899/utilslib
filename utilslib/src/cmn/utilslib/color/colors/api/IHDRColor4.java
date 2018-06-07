
package cmn.utilslib.color.colors.api;


public interface IHDRColor4 extends IHDRColor4Base, IColor4
{
	
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setR(int r);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setG(int g);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setB(int b);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setA(int a);
	
	
	IHDRColor4 setUnityR(float r);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setUnityG(float g);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setUnityB(float b);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setUnityA(float a);
	
	
	/** {@inheritDoc}} */ @Override
	IHDRColor4 set(int brightness);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 set(IColor4Base color);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 set(int r, int g, int b, int a);
	
	
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setUnity(float brightness);
	/** {@inheritDoc}} */ @Override
	IHDRColor4 setUnity(float r, float g, float b, float a);
	
	
	
	
	/** {@inheritDoc}} */ @Override
	IHDRColor4 clone();
	
}

