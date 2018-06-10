
package cmn.utilslib.color.colors.api;



public interface ILDRColor4 extends ILDRColor4Base, IColor4
{
	
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setR(int r);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setG(int g);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setB(int b);
	
	
	ILDRColor4 setUnityR(float r);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setUnityG(float g);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setUnityB(float b);
	
	
	/** {@inheritDoc}} */ @Override
	ILDRColor4 set(int brightness);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 set(IColor4Base color);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 set(int r, int g, int b, int a);
	
	
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setUnity(float brightness);
	/** {@inheritDoc}} */ @Override
	ILDRColor4 setUnity(float r, float g, float b, float a);
	

	
	/** {@inheritDoc}} */ @Override
	ILDRColor4 clone();
	
}

