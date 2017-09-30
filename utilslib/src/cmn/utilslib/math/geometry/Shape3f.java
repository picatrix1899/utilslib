package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix4f;

public interface Shape3f
{

	AABB3f getAABBf(AABB3f aabb);
	
	AABB3f getAABBf(Matrix4f t, AABB3f aabb);
	
	OBB3f getOBBf();
	
	OBB3f getOBBf(Matrix4f t);
	
	BoundingSpheref getBoundingSpheref();
	
	BoundingSpheref getBoundingSpheref(Matrix4f t);
	
	BoundingElipsoidf getBoundingElisoidf();
	
	BoundingElipsoidf getBoundingElipsoidf(Matrix4f t);
}
