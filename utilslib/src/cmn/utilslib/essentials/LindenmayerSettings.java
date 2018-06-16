package cmn.utilslib.essentials;

import cmn.utilslib.math.Quaternion;
import cmn.utilslib.math.vector.Vector3f;

public class LindenmayerSettings
{
	public int depth;
	public double stepLength;
	public Vector3f dir;
	public Quaternion rot;
	
	public LindenmayerSettings(int depth, double stepLength, Vector3f dir, Quaternion rot)
	{
		this.depth = depth;
		this.stepLength = stepLength;
		this.dir = dir;
		this.rot = rot;
	}
	
	public LindenmayerSettings clone()
	{
		return new LindenmayerSettings(this.depth, this.stepLength, this.dir, this.rot);
	}
}


