package cmn.utilslib.color.gradients.api;

import cmn.utilslib.color.colors.api.ILDRColor3Base;

public interface ILDRGradient3 extends ILDRGradient3Base
{
	ILDRGradient3 insert(double index, ILDRColor3Base value);
}
