package cmn.utilslib.color.colors.api;

public interface ILDRColor4 extends ILDRColor4Base, IColor4
{
	
	/** {@inheritDoc}} */ @Override
	default ILDRColor4 set(IColor4Base color) { return (ILDRColor4) setR(color.getR()).setG(color.getG()).setB(color.getB()).setA(color.getA()); }
	/** {@inheritDoc}} */ @Override
	default ILDRColor4 set(int r, int g, int b, int a) { return (ILDRColor4) setR(r).setG(g).setB(b).setA(a); }
	
	
	
	/** {@inheritDoc}} */ @Override
	default ILDRColor4 setUnity(float r, float g, float b, float a) { return (ILDRColor4) setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	

	
	
	@Override
	ILDRColor4 clone();
	

}

