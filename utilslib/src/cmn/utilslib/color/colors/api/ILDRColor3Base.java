
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PLDRColor4;



public interface ILDRColor3Base extends IColor3Base
{
	
	/**  */
	public static final PLDRColor4 WHITE =		PLDRColor4.gen(255, 255, 255, 255);
	/**  */
	public static final PLDRColor4 BLACK =		PLDRColor4.gen(000, 000, 000, 255);
	/**  */
	public static final PLDRColor4 RED =		PLDRColor4.gen(255, 000, 000, 255);
	/**  */
	public static final PLDRColor4 GREEN =		PLDRColor4.gen(000, 255, 000, 255);
	/**  */
	public static final PLDRColor4 BLUE =		PLDRColor4.gen(000, 000, 255, 255);
	/**  */
	public static final PLDRColor4 YELLOW =		PLDRColor4.gen(255, 255, 000, 255);

	
	
	@Override
	ILDRColor3Base clone();
	
}
