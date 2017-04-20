package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.IHDRColor4Base;

public interface IHDRGradient4 extends IHDRGradient4Base
{
	IHDRGradient4 insert(double index, IHDRColor4Base value);
}
