package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.IHDRColor3Base;

public interface IHDRGradient3Base extends IGradient3Base
{
	IHDRColor3Base get(double index);
}
