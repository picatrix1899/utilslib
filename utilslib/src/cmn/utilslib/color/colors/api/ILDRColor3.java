package cmn.utilslib.color.colors.api;


public interface ILDRColor3 extends ILDRColor3Base, IColor3
{
	
	/** {@inheritDoc}} */ @Override
	default ILDRColor3 set(IColor3Base color) { return (ILDRColor3) setR(color.getR()).setG(color.getG()).setB(color.getB()); }
	/** {@inheritDoc}} */ @Override
	default ILDRColor3 set(int r, int g, int b) { return (ILDRColor3) setR(r).setG(g).setB(b); }
	
	
	
	/** {@inheritDoc}} */ @Override
	default ILDRColor3 setUnity(float r, float g, float b) { return (ILDRColor3) setUnityR(r).setUnityG(g).setUnityB(b); }
	
	
	

	

	
	@Override
	ILDRColor3 clone();
	
}

