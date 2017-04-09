package cmn.utilslib.dmap;

import java.util.Comparator;

public interface IDMapping2<A,B>
extends IDMapping2Base<A,B>
{

	public IDMapping2<A,B> set(int index, A a, B b);
	public IDMapping2<A,B> set(int index, IDMap2Base<A,B> entry);
	public IDMapping2<A,B> setA(int index, A a);
	public IDMapping2<A,B> setB(int index, B b);
	
	
	
	public IDMapping2<A,B> add(A a, B b);
	public IDMapping2<A,B> add(IDMap2Base<A,B> entry);
	
	

	public IDMapping2<A,B> remove(int index);
	
	public IDMapping2<A,B> remove(A a, B b);
	public IDMapping2<A,B> remove(IDMap2Base<A,B> entry);
	public IDMapping2<A,B> removeByA(A a);
	public IDMapping2<A,B> removeByB(B b);
	
	
	
	public IDMapping2<A,B> removeFirst(A a , B b);
	public IDMapping2<A,B> removeFirst(IDMap2Base<A,B> p);
	public IDMapping2<A,B> removeFirstByA(A a);
	public IDMapping2<A,B> removeFirstByB(B b);
	
	
	
	public IDMapping2<A,B> sortByA(Comparator<? super A> comp);
	public IDMapping2<A,B> sortByB(Comparator<? super B> comp);

	
	
	public IDMapping2<A,B> clear();	

}
