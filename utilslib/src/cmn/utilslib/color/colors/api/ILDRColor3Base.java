
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PLDRColor4;



public interface ILDRColor3Base extends IColor3Base
{
	
	/**  */
	public static final ILDRColor4Base WHITE =		PLDRColor4.gen(255, 255, 255, 255);
	/**  */
	public static final ILDRColor4Base BLACK =		PLDRColor4.gen(000, 000, 000, 255);
	/**  */
	public static final ILDRColor4Base RED =		PLDRColor4.gen(255, 000, 000, 255);
	/**  */
	public static final ILDRColor4Base GREEN =		PLDRColor4.gen(000, 255, 000, 255);
	/**  */
	public static final ILDRColor4Base BLUE =		PLDRColor4.gen(000, 000, 255, 255);
	/**  */
	public static final ILDRColor4Base YELLOW =		PLDRColor4.gen(255, 255, 000, 255);

	
	
	@Override
	ILDRColor3Base clone();
	
}
