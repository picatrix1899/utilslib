package cmn.utilslib.exp.vector;

import cmn.utilslib.exp.vector.api.Vector3fE;

public class TestVec implements Vector3fE<TestVec>
{

	public float x = 0.0f;
	public float y = 0.0f;
	public float z = 0.0f;
	

	public float getX() { return this.x; }
	public float getY() { return this.y; }
	public float getZ() { return this.z; }


	public TestVec setX(float x) { this.x = x; return this; }
	public TestVec setY(float y) { this.y = y; return this; } 
	public TestVec setZ(float z) { this.z = z; return this; }
	
	

	/** {@inheritDoc} */
	@Override
	public TestVec clone() { return new TestVec().setX(getX()).setY(getY()).setZ(getZ()); }
}
