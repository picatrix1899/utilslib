package cmn.utilslib.math.vector.api;

import cmn.utilslib.math.Maths;
import cmn.utilslib.math.vector.PVector2f;

public interface Vec2fConstants
{
	/*
	########################
	##                    ##
	##  CONSTANT VECTORS  ##
	##                    ##
	########################
	 */
	
	/** Default Vector all initialized by 0 */
	static final PVector2f ZERO =		PVector2f.gen(0.0f, 0.0f);
	
	/** Default Vector all initialized by 1 */
	static final PVector2f ONE =		PVector2f.gen(1.0f, 1.0f);
	
	/*
	####################
	##                ##
	##  AXIS-NORMALS  ##
	##                ##
	####################
	 */
	
	/** The positive X-Axis-Normal */
	static final PVector2f aX =			PVector2f.gen(1.0f                    , 0.0f                    );
	
	/** The positive Y-Axis-Normal */
	static final PVector2f aY =			PVector2f.gen(0.0f                    , 1.0f                    );
	
	
	
	/** The positive XY-Axis-Normal */
	static final PVector2f aXY =		PVector2f.gen((float) Maths.INV_SQRT2 , (float) Maths.INV_SQRT2 );

	
	
	/** The negative X-Axis-Normal */
	static final PVector2f aNX =		PVector2f.gen(-1.0f                   ,  0.0f                   );

	/** The negative Y-Axis-Normal */
	static final PVector2f aNY =		PVector2f.gen( 0.0f                   , -1.0f                   );
	
	
	
	/** The Axis-Normal from the composition of negative X-Axis and positive Y-Axis */
	static final PVector2f aNXY =		PVector2f.gen((float) -Maths.INV_SQRT2, (float) Maths.INV_SQRT2 );
	
	/** The Axis-Normal from the composition of positive X-Axis and negative Z-Axis */
	static final PVector2f aXNY =		PVector2f.gen((float) Maths.INV_SQRT2 , (float) -Maths.INV_SQRT2);
	
	/** The negative XY-Axis-Normal */
	static final PVector2f aNXNY =		PVector2f.gen((float) -Maths.INV_SQRT2, (float) -Maths.INV_SQRT2);
}
