package cmn.utilslib.math.geometry;

import cmn.utilslib.math.matrix.Matrix4f;

public interface Shape3f
{

	AABB3f getAABBf();
	AABB3f getAABBf(AABB3f aabb);
	AABB3f getAABBf(Matrix4f t);
	AABB3f getAABBf(Matrix4f t, AABB3f aabb);
	
	OBB3f getOBBf();
	OBB3f getOBBf(OBB3f obb);
	OBB3f getOBBf(Matrix4f t, Matrix4f r);
	OBB3f getOBBf(Matrix4f t, Matrix4f r, OBB3f obb);
	
	BoundingSpheref getBoundingSpheref();
	BoundingSpheref getBoundingSpheref(BoundingSpheref s);
	BoundingSpheref getBoundingSpheref(Matrix4f t);
	BoundingSpheref getBoundingSpheref(Matrix4f t, BoundingSpheref s);
	
	BoundingElipsoidf getBoundingElisoidf();
	BoundingElipsoidf getBoundingElisoidf(BoundingElipsoidf e);
	BoundingElipsoidf getBoundingElipsoidf(Matrix4f t);
	BoundingElipsoidf getBoundingElipsoidf(Matrix4f t, BoundingElipsoidf e);
	
}
