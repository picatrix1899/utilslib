package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.ILDRColor4Base;

public interface ILDRGradient4 extends ILDRGradient4Base
{
	ILDRGradient4 insert(double index, ILDRColor4Base value);
}
