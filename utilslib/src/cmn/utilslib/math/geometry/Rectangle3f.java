package cmn.utilslib.math.geometry;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rectangle3f implements ConvexPolygonalShape3f
{

	@Override
	public Point3f[] getPoints()
	{
		throw new NotImplementedException();
	}

	public AABB3f getAABBf(Shape3f s)
	{
		return null;
	}

}
