package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.vector.PVector3f;

public interface Vec3fConstants
{
	/*
	########################
	##                    ##
	##  CONSTANT VECTORS  ##
	##                    ##
	########################
	 */
	
	/** Default Vector all initialized by 0 */
	static final PVector3f ZERO =		PVector3f.gen(0.0f, 0.0f, 0.0f);
	
	/** Default Vector all initialized by 1 */
	static final PVector3f ONE =		PVector3f.gen(1.0f, 1.0f, 1.0f);
	
	/*
	####################
	##                ##
	##  AXIS-NORMALS  ##
	##                ##
	####################
	 */
	
	/** The positive X-Axis-Normal */
	static final PVector3f aX =			PVector3f.gen(1.0f                    , 0.0f                    , 0.0f                    );
	
	/** The positive Y-Axis-Normal */
	static final PVector3f aY =			PVector3f.gen(0.0f                    , 1.0f                    , 0.0f                    );
	
	/** The positive Z-Axis-Normal */
	static final PVector3f aZ =			PVector3f.gen(0.0f                    , 0.0f                    , 1.0f                    );
	
	
	
	/** The positive XY-Axis-Normal */
	static final PVector3f aXY =		PVector3f.gen((float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 , 0.0f                    );
	
	/** The positive XZ-Axis-Normal */
	static final PVector3f aXZ =		PVector3f.gen((float) Maths.INV_SQRT2 , 0.0f                    , (float) Maths.INV_SQRT2 );
	
	/** The positive YZ-Axis-Normal */
	static final PVector3f aYZ =		PVector3f.gen(0.0f                    , (float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 );
	
	
	
	/** The positive XYZ-Axis-Normal */
	static final PVector3f aXYZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 );
	
	
	
	/** The negative X-Axis-Normal */
	static final PVector3f aNX =		PVector3f.gen(-1.0f                   ,  0.0f                   ,  0.0f                   );
	
	/** The negative Y-Axis-Normal */
	static final PVector3f aNY =		PVector3f.gen( 0.0f                   , -1.0f                   ,  0.0f                   );
	
	/** The negative Z-Axis-Normal */
	static final PVector3f aNZ =		PVector3f.gen( 0.0f                   ,  0.0f                   , -1.0f                   );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Y-Axis */
	static final PVector3f aNXY =		PVector3f.gen((float) -Maths.INV_SQRT2, (float) Maths.INV_SQRT2 , 0.0f                    );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector3f aXNY =		PVector3f.gen((float) Maths.INV_SQRT2 , (float) -Maths.INV_SQRT2, 0.0f                    );
	
	/** The negative XY-Axis-Normal */
	static final PVector3f aNXNY =		PVector3f.gen((float) -Maths.INV_SQRT2, (float) -Maths.INV_SQRT2, 0.0f                    );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Z-Axis */
	static final PVector3f aNXZ =		PVector3f.gen((float) -Maths.INV_SQRT2, 0.0f                    , (float) Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector3f aXNZ =		PVector3f.gen((float) Maths.INV_SQRT2 , 0.0f                    , (float) -Maths.INV_SQRT2);
	
	/** The negative XZ-Axis-Normal */
	static final PVector3f aNXNZ =		PVector3f.gen((float) -Maths.INV_SQRT2, 0.0f                    , (float) -Maths.INV_SQRT2);
	
	
	
	/** The Axis-Normal from the composition of negative Y-Axis and positive Z-Axis */
	static final PVector3f aNYZ =		PVector3f.gen(0.0f                    , (float) -Maths.INV_SQRT2, (float) Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive Y-Axis and negative Z-Axis */
	static final PVector3f aYNZ =		PVector3f.gen(0.0f                    , (float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 );
	
	/** The negative YZ-Axis-Normal */
	static final PVector3f aNYNZ =		PVector3f.gen(0.0f                    , (float) -Maths.INV_SQRT2, (float) -Maths.INV_SQRT2);
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis, positive Y-Axis and positive Z-Axis */
	static final PVector3f aNXYZ =		PVector3f.gen((float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of positive X-Axis, negative Y-Axis and positive Z-Axis */
	static final PVector3f aXNYZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of positive X-Axis, positive Y-Axis and negative Z-Axis */
	static final PVector3f aXYNZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3);
	
	/** The Axis-Normal from the composition of negative X-Axis, negative Y-Axis and positive Z-Axis */
	static final PVector3f aNXNYZ =		PVector3f.gen((float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 );
	
	/** The Axis-Normal from the composition of negative X-Axis, positive Y-Axis and negative Z-Axis */
	static final PVector3f aNXYNZ =		PVector3f.gen((float) -Maths.INV_SQRT3, (float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3);
	
	/** The Axis-Normal from the composition of positive X-Axis, negative Y-Axis and negative Z-Axis */
	static final PVector3f aXNYNZ =		PVector3f.gen((float) Maths.INV_SQRT3 , (float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3);
	
	/** The negative XYZ-Axis-Normal */
	static final PVector3f aNXNYNZ =	PVector3f.gen((float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3, (float) -Maths.INV_SQRT3);

}
