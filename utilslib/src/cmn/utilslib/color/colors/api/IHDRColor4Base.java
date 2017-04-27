
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PHDRColor4;



public interface IHDRColor4Base extends IHDRColor3Base, IColor4Base
{
	
	/**  */
	public static final PHDRColor4 WHITE =		PHDRColor4.gen(255, 255, 255, 255);
	/**  */
	public static final PHDRColor4 BLACK =		PHDRColor4.gen(000, 000, 000, 255);
	/**  */
	public static final PHDRColor4 RED =		PHDRColor4.gen(255, 000, 000, 255);
	/**  */
	public static final PHDRColor4 GREEN =		PHDRColor4.gen(000, 255, 000, 255);
	/**  */
	public static final PHDRColor4 BLUE =		PHDRColor4.gen(000, 000, 255, 255);
	/**  */
	public static final PHDRColor4 YELLOW =		PHDRColor4.gen(255, 255, 000, 255);
	
	
	
	@Override
	IHDRColor4Base clone();
	
}

