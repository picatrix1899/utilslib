package cmn.utilslib.dmap;

import java.util.Comparator;

public interface IMapping2Foundation<RI extends IMapping2Foundation<?,?,?,A,B>,
									 R extends IPair2Base<A,B>,
									 P extends IPair2Base<A,B>,
									 A,B>
extends IMapping2FoundationBase<R,P,A,B>
{

	
	
	public RI set(int index, P entry);
	
	public RI setA(int index, A a);
	public RI setB(int index, B b);
	
	public RI add(P entry);
	
	public RI remove(int index);
	public RI remove(P entry);
	public RI removeByA(A a);
	public RI removeByB(B b);
	public RI removeFirstByA(A a);
	public RI removeFirstByB(B b);
	
	public RI sortByA(Comparator<? super A> comp);
	public RI sortByB(Comparator<? super B> comp);
	
	public RI clear();
	
	
	
	public boolean equals(RI subject);
	
	
	
	public static interface IMapping2Extended<RI extends IMapping2Extended<?,?,?,A,B>,
											  R extends IPair2Base<A,B>,
											  P extends IPair2Base<A,B>,
											  A,B>
	extends IMapping2ExtendedBase<R,P,A,B>, IMapping2Foundation<RI,R,P,A,B>
	{

	}
	
	
	
	
	
	
	public static interface IMapping2<RI extends IMapping2<?,A,B>,
									  A,B>
	extends IMapping2Base<A,B>, IMapping2Extended<RI,IPair2Base<A,B>,IPair2Base<A,B>,A,B>
	{ }

}
