
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PHDRColor4;



public interface IHDRColor4Base extends IHDRColor3Base, IColor4Base
{
	
	/**  */
	public static final IHDRColor4Base WHITE =		PHDRColor4.gen(255, 255, 255, 255);
	/**  */
	public static final IHDRColor4Base BLACK =		PHDRColor4.gen(000, 000, 000, 255);
	/**  */
	public static final IHDRColor4Base RED =		PHDRColor4.gen(255, 000, 000, 255);
	/**  */
	public static final IHDRColor4Base GREEN =		PHDRColor4.gen(000, 255, 000, 255);
	/**  */
	public static final IHDRColor4Base BLUE =		PHDRColor4.gen(000, 000, 255, 255);
	/**  */
	public static final IHDRColor4Base YELLOW =		PHDRColor4.gen(255, 255, 000, 255);
	
	public static final IHDRColor4Base PURPLE =		PHDRColor4.gen(128, 0, 128, 255);
	
	public static final IHDRColor4Base GOLD =		PHDRColor4.gen(255, 215, 0, 255);
	
	public static final IHDRColor4Base ORANGE =		PHDRColor4.gen(255, 140, 0, 255);
	
	public static final IHDRColor4Base GREY =		PHDRColor4.gen(128, 128, 128, 255);
	
	@Override
	IHDRColor4Base clone();
	
}

