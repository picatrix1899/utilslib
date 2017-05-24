
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PHDRColor3;



public interface IHDRColor3Base extends IColor3Base
{
	
	/**  */
	public static final IHDRColor3Base WHITE =		PHDRColor3.gen(255, 255, 255);
	/**  */
	public static final IHDRColor3Base BLACK =		PHDRColor3.gen(000, 000, 000);
	/**  */
	public static final IHDRColor3Base RED =		PHDRColor3.gen(255, 000, 000);
	/**  */
	public static final IHDRColor3Base GREEN =		PHDRColor3.gen(000, 255, 000);
	/**  */
	public static final IHDRColor3Base BLUE =		PHDRColor3.gen(000, 000, 255);
	/**  */
	public static final IHDRColor3Base YELLOW =		PHDRColor3.gen(255, 255, 000);

	
	
	IHDRColor3Base clone();
	
}
