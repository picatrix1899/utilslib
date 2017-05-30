package cmn.utilslib.exp.vector.api;


public interface Vector3fBaseE<T extends Vector3fE<T>>
{
	float getX();
	float getY();
	float getZ();
	
	default T addN(float x, float y, float z) { return clone().add(x, y, z); }

	default T subN(float x, float y, float z) { return clone().sub(x, y, z); }

	default T mulN(float x, float y, float z) { return clone().mul(x, y, z); }

	default T divN(float x, float y, float z) { return clone().div(x, y, z); }

	
	T clone();

	
	
	default T addN(Vector3fBaseE<?> v) { return addN(v.getX(), v.getY(), v.getZ()); }
	default T addN(float scalar) { return addN(scalar, scalar, scalar); }
	
	default T subN(Vector3fBaseE<?> v) { return subN(v.getX(), v.getY(), v.getZ()); }
	default T subN(float scalar) { return subN(scalar, scalar, scalar); }
	
	default T mulN(Vector3fBaseE<?> v) { return mulN(v.getX(), v.getY(), v.getZ()); }
	default T mulN(float scalar) { return mulN(scalar, scalar, scalar); }
	
	default T divN(Vector3fBaseE<?> v) { return divN(v.getX(), v.getY(), v.getZ()); }
	default T divN(float scalar) { return divN(scalar, scalar, scalar); }
}
