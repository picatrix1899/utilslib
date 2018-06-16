package cmn.utilslib.math.vector;

//import cmn.utilslib.math.vector.api.Vec3dBase;
//import cmn.utilslib.math.vector.api.Vec3fBase;

public class Vector3fErp
{
//	/*
//	############################
//	##                        ##
//	##  VECTOR INTERPOLATION  ##
//	##                        ##
//	############################
//	 */
//
//	/** {@inheritDoc} */
// 	public Vector3f lerp(Vec3fBase v, float f)
//	{
//		this.x = this.x + (v.getX() - this.x) * f;
//		this.y = this.y + (v.getY() - this.y) * f;
//		this.z = this.z + (v.getZ() - this.z) * f;
//
//		return this;
//	}
// 	
// 	/** {@inheritDoc} */
//	public Vector3f lerp(Vec3dBase v, float f)
//	{
//		this.x = this.x + ((float)v.getX() - this.x) * f;
//		this.y = this.y + ((float)v.getY() - this.y) * f;
//		this.z = this.z + ((float)v.getZ() - this.z) * f;
//
//		return this;
//	}
// 	
//	/** {@inheritDoc} */
//	public Vector3f lerp(Vec3fBase v, double f)
//	{
//		this.x = this.x + (v.getX() - this.x) * (float)f;
//		this.y = this.y + (v.getY() - this.y) * (float)f;
//		this.z = this.z + (v.getZ() - this.z) * (float)f;
//
//		return this;
//	}
//
//	/** {@inheritDoc} */
//	public Vector3f lerp(Vec3dBase v, double f)
//	{
//		this.x = this.x + ((float)v.getX() - this.x) * (float)f;
//		this.y = this.y + ((float)v.getY() - this.y) * (float)f;
//		this.z = this.z + ((float)v.getZ() - this.z) * (float)f;
//
//		return this;
//	}
//	
//	
//	
//	/** {@inheritDoc} */
// 	public Vector3f slerp(Vec3fBase v, double f)
//	{
//		double angle = angleRad(v);
//		
//		double sinAngle = Math.sin(angle);
//
//		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
//		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
//		float x = (float) (x_1 + x_2);
//		
//		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
//		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
//		float y = (float) (y_1 + y_2);
//		
//		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
//		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
//		float z = (float) (z_1 + z_2);
//		
//		this.x = x;
//		this.y = y; 
//		this.z = z;
//		
//		return this;
//	}
//	
// 	/** {@inheritDoc} */
//	public Vector3f slerp(Vec3dBase v, double f)
//	{
//		double angle = angleRad(v);
//		
//		double sinAngle = Math.sin(angle);
//
//		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
//		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
//		float x = (float) (x_1 + x_2);
//		
//		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
//		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
//		float y = (float) (y_1 + y_2);
//		
//		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
//		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
//		float z = (float) (z_1 + z_2);
//		
//		this.x = x;
//		this.y = y; 
//		this.z = z;
//		
//		return this;
//	}
//	
//	/** {@inheritDoc} */
//	public Vector3f slerp(Vec3fBase v, float f)
//	{
//		double angle = angleRad(v);
//		
//		double sinAngle = Math.sin(angle);
//
//		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
//		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
//		float x = (float) (x_1 + x_2);
//		
//		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
//		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
//		float y = (float) (y_1 + y_2);
//		
//		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
//		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
//		float z = (float) (z_1 + z_2);
//		
//		this.x = x;
//		this.y = y; 
//		this.z = z;
//		
//		return this;
//	}
//
//	/** {@inheritDoc} */
//	public Vector3f slerp(Vec3dBase v, float f)
//	{
//		double angle = angleRad(v);
//		
//		double sinAngle = Math.sin(angle);
//
//		double x_1 = ((1 - f)	* sinAngle) / (sinAngle * this.x);
//		double x_2 = (f			* sinAngle) / (sinAngle * v.getX());
//		float x = (float) (x_1 + x_2);
//		
//		double y_1 = ((1 - f)	* sinAngle) / (sinAngle * this.y);
//		double y_2 = (f			* sinAngle) / (sinAngle * v.getY());
//		float y = (float) (y_1 + y_2);
//		
//		double z_1 = ((1 - f)	* sinAngle) / (sinAngle * this.z);
//		double z_2 = (f			* sinAngle) / (sinAngle * v.getZ());
//		float z = (float) (z_1 + z_2);
//		
//		this.x = x;
//		this.y = y; 
//		this.z = z;
//		
//		return this;
//	}
//	
//	
//	
//	/** {@inheritDoc} */
//	public Vector3f lerpN(Vec3fBase v, float f) { return clone().lerp(v, f); }
//	
//	/** {@inheritDoc} */
//	public Vector3f lerpN(Vec3dBase v, float f) { return clone().lerp(v, f); }
//	
//	/** {@inheritDoc} */
//	public Vector3f lerpN(Vec3fBase v, double f) { return clone().lerp(v, f); }
//	
//	/** {@inheritDoc} */
//	public Vector3f lerpN(Vec3dBase v, double f) { return clone().lerp(v, f); }
//
//	
//	
//	/** {@inheritDoc} */
//	public Vector3f slerpN(Vec3fBase v, float f) { return clone().slerp(v, f); }
//	
//	/** {@inheritDoc} */
//	public Vector3f slerpN(Vec3dBase v, float f) { return clone().slerp(v, f); }
//	
//	/** {@inheritDoc} */
//	public Vector3f slerpN(Vec3fBase v, double f) { return clone().slerp(v, f); }
//	
//	/** {@inheritDoc} */
//	public Vector3f slerpN(Vec3dBase v, double f) { return clone().slerp(v, f); }
}
