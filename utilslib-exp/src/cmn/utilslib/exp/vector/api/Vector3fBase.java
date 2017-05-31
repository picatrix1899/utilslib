package cmn.utilslib.exp.vector.api;


public interface Vector3fBase
{
	float getX();
	float getY();
	float getZ();
	
	Vector3fBase addN(float x, float y, float z);

	Vector3fBase subN(float x, float y, float z);

	Vector3fBase mulN(float x, float y, float z);

	Vector3fBase divN(float x, float y, float z);
	
	Vector3fBase clone();

	default Vector3fBase addN(Vector3fBase v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default Vector3fBase addN(float scalar) { return addN(scalar, scalar, scalar); }
	
	default Vector3fBase subN(Vector3fBase v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default Vector3fBase subN(float scalar) { return subN(scalar, scalar, scalar); }
	
	default Vector3fBase mulN(Vector3fBase v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default Vector3fBase mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	
	default Vector3fBase divN(Vector3fBase v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default Vector3fBase divN(float scalar) { return divN(scalar, scalar, scalar); }
}
