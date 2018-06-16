package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.IHDRColor4Base;

public interface IHDRGradient4Base extends IHDRGradient3Base, IGradient4Base
{
	IHDRColor4Base get(double index);
}
