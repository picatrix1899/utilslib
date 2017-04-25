
package cmn.utilslib.color.colors.api;


public interface IHDRColor4 extends IHDRColor4Base, IColor4
{
	
	/** {@inheritDoc}} */ @Override
	default IHDRColor4 set(IColor4Base color) { return (IHDRColor4) setR(color.getR()).setG(color.getG()).setB(color.getB()).setA(color.getA()); }
	/** {@inheritDoc}} */ @Override
	default IHDRColor4 set(int r, int g, int b, int a) { return (IHDRColor4) setR(r).setG(g).setB(b).setA(a); }
	
	
	
	/** {@inheritDoc}} */ @Override
	default IHDRColor4 setUnity(float r, float g, float b, float a) { return (IHDRColor4) setUnityR(r).setUnityG(g).setUnityB(b).setUnityA(a); }
	
	
	@Override
	IHDRColor4 clone();
	
}

