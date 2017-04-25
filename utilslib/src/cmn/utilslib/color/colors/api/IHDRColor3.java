package cmn.utilslib.color.colors.api;


public interface IHDRColor3 extends IHDRColor3Base, IColor3
{

	/** {@inheritDoc}} */ @Override
	default IHDRColor3 set(IColor3Base color) { return (IHDRColor3) setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	/** {@inheritDoc}} */ @Override
	default IHDRColor3 set(int r, int g, int b) { return (IHDRColor3) setR(r).setG(g).setB(b); }
	
	
	
	/** {@inheritDoc}} */ @Override
	default IHDRColor3 setUnity(float r, float g, float b) { return (IHDRColor3) setUnityR(r).setUnityG(g).setUnityB(b); }
	

	
	@Override
	IHDRColor3 clone();
	
}

