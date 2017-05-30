package cmn.utilslib.exp.vector.api;


public interface Vector3fE<A extends Vector3fE<A>> extends Vector3fBaseE<A>
{
	
	A setX(float x);
	A setY(float y);
	A setZ(float z);
	
	default A set(Vector3fBaseE<?> v) { return set(v.getX(), v.getY(), v.getZ()); }
	
	default A set(float scalar) { return set(scalar, scalar, scalar); }
	default A set(float x, float y, float z) { return setX(x).setY(y).setZ(z); }

	default A add(Vector3fBaseE<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	default A add(float scalar) { return add(scalar, scalar, scalar); }
	default A add(float x, float y, float z) { return set(getX() + x, getY() + y, getZ() + z); }

	default A sub(Vector3fBaseE<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	default A sub(float scalar) { return add(scalar, scalar, scalar); }
	default A sub(float x, float y, float z) { return set(getX() - x, getY() - y, getZ() - z); }
	
	default A mul(Vector3fBaseE<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	default A mul(float scalar) { return add(scalar, scalar, scalar); }
	default A mul(float x, float y, float z) { return set(getX() * x, getY() * y, getZ() * z); }
	
	default A div(Vector3fBaseE<?> v) { return add(v.getX(), v.getY(), v.getZ()); }
	default A div(float scalar) { return add(scalar, scalar, scalar); }
	default A div(float x, float y, float z) { return set(getX() / x, getY() / y, getZ() / z); }
}
