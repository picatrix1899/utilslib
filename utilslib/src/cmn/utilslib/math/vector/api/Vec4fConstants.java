package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.vector.PVector4f;

public class Vec4fConstants
{
	/*
	 * ==============
	 * AXIS-NORMALS
	 * ==============
	 */
	static final PVector4f ZERO = PVector4f.gen(0.0f, 0.0f, 0.0f, 0.0f);
	static final PVector4f ONE = PVector4f.gen(1.0f, 1.0f, 1.0f, 0.0f);
	static final PVector4f aX = PVector4f.gen(1.0f, 0.0f, 0.0f, 0.0f);
	static final PVector4f aY = PVector4f.gen(0.0f, 1.0f, 0.0f, 0.0f);
	static final PVector4f aZ = PVector4f.gen(0.0f, 0.0f, 1.0f, 0.0f);
	static final PVector4f aNX = PVector4f.gen(-1.0f, 0.0f, 0.0f, 0.0f);
	static final PVector4f aNY = PVector4f.gen(0.0f, -1.0f, 0.0f, 0.0f);
	static final PVector4f aNZ = PVector4f.gen(0.0f, 0.0f, -1.0f, 0.0f);
}
