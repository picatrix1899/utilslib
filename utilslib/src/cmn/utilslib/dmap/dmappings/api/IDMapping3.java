package cmn.utilslib.dmap.dmappings.api;

import java.util.Comparator;

import cmn.utilslib.dmap.dmaps.api.IDMap3Base;

public interface IDMapping3<A,B,C> extends IDMapping3Base<A,B,C>
{

	public IDMapping3<A,B,C> set(int index, A a, B b, C c);
	public IDMapping3<A,B,C> set(int index, IDMap3Base<A,B,C> entry);
	public IDMapping3<A,B,C> setA(int index, A a);
	public IDMapping3<A,B,C> setB(int index, B b);
	public IDMapping3<A,B,C> setC(int index, C c);
	
	
	
	public IDMapping3<A,B,C> add(A a, B b, C c);
	public IDMapping3<A,B,C> add(IDMap3Base<A,B,C> entry);
	
	

	public IDMapping3<A,B,C> remove(int index);
	
	public IDMapping3<A,B,C> remove(A a, B b, C c);
	public IDMapping3<A,B,C> remove(IDMap3Base<A,B,C> entry);
	public IDMapping3<A,B,C> removeByA(A a);
	public IDMapping3<A,B,C> removeByB(B b);
	public IDMapping3<A,B,C> removeByC(C c);
	
	
	
	public IDMapping3<A,B,C> removeFirst(A a, B b, C c);
	public IDMapping3<A,B,C> removeFirst(IDMap3Base<A,B,C> p);
	public IDMapping3<A,B,C> removeFirstByA(A a);
	public IDMapping3<A,B,C> removeFirstByB(B b);
	public IDMapping3<A,B,C> removeFirstByC(C c);
	
	
	
	public IDMapping3<A,B,C> sortByA(Comparator<? super A> comp);
	public IDMapping3<A,B,C> sortByB(Comparator<? super B> comp);
	public IDMapping3<A,B,C> sortByC(Comparator<? super C> comp);

	
	
	public IDMapping3<A,B,C> clear();	

}
