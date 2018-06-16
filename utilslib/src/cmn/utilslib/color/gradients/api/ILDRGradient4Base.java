package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.ILDRColor4Base;

public interface ILDRGradient4Base extends IGradient4Base
{
	ILDRColor4Base get(double index);
}
