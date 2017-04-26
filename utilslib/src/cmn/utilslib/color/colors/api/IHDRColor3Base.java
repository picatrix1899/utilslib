
package cmn.utilslib.color.colors.api;



import cmn.utilslib.color.colors.PHDRColor3;



public interface IHDRColor3Base extends IColor3Base
{
	
	/**  */
	public static final PHDRColor3 WHITE =		PHDRColor3.gen(255, 255, 255);
	/**  */
	public static final PHDRColor3 BLACK =		PHDRColor3.gen(000, 000, 000);
	/**  */
	public static final PHDRColor3 RED =		PHDRColor3.gen(255, 000, 000);
	/**  */
	public static final PHDRColor3 GREEN =		PHDRColor3.gen(000, 255, 000);
	/**  */
	public static final PHDRColor3 BLUE =		PHDRColor3.gen(000, 000, 255);
	/**  */
	public static final PHDRColor3 YELLOW =		PHDRColor3.gen(255, 255, 000);

	
	
	IHDRColor3Base clone();
	
}
