package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.IHDRColor3Base;

public interface IHDRGradient3 extends IHDRGradient3Base
{
	IHDRGradient3 insert(double index, IHDRColor3Base value);
}
