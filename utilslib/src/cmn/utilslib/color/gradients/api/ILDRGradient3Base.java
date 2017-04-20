package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.ILDRColor3Base;

public interface ILDRGradient3Base extends IGradient3Base
{
	ILDRColor3Base get(double index);
}
