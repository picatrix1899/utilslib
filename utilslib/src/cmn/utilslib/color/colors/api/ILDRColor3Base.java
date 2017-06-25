
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PLDRColor3;



public interface ILDRColor3Base extends IColor3Base
{
	
	/**  */
	public static final ILDRColor3Base WHITE =		PLDRColor3.gen(255, 255, 255);
	/**  */
	public static final ILDRColor3Base BLACK =		PLDRColor3.gen(000, 000, 000);
	/**  */
	public static final ILDRColor3Base RED =		PLDRColor3.gen(255, 000, 000);
	/**  */
	public static final ILDRColor3Base GREEN =		PLDRColor3.gen(000, 255, 000);
	/**  */
	public static final ILDRColor3Base BLUE =		PLDRColor3.gen(000, 000, 255);
	/**  */
	public static final ILDRColor3Base YELLOW =		PLDRColor3.gen(255, 255, 000);

	
	
	@Override
	ILDRColor3Base clone();
	
}
