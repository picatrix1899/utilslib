package cmn.utilslib.dmap;

import java.util.Comparator;

public interface IDMapping4<A,B,C,D> extends IDMapping4Base<A,B,C,D>
{

	public IDMapping4<A,B,C,D> set(int index, A a, B b, C c, D d);
	public IDMapping4<A,B,C,D> set(int index, IDMap4Base<A,B,C,D> entry);
	public IDMapping4<A,B,C,D> setA(int index, A a);
	public IDMapping4<A,B,C,D> setB(int index, B b);
	public IDMapping4<A,B,C,D> setC(int index, C c);
	public IDMapping4<A,B,C,D> setD(int index, D d);
	
	
	
	public IDMapping4<A,B,C,D> add(A a, B b, C c, D d);
	public IDMapping4<A,B,C,D> add(IDMap4Base<A,B,C,D> entry);
	
	

	public IDMapping4<A,B,C,D> remove(int index);
	
	public IDMapping4<A,B,C,D> remove(A a, B b, C c, D d);
	public IDMapping4<A,B,C,D> remove(IDMap4Base<A,B,C,D> entry);
	public IDMapping4<A,B,C,D> removeByA(A a);
	public IDMapping4<A,B,C,D> removeByB(B b);
	public IDMapping4<A,B,C,D> removeByC(C c);
	public IDMapping4<A,B,C,D> removeByD(D d);
	
	
	
	public IDMapping4<A,B,C,D> removeFirst(A a, B b, C c, D d);
	public IDMapping4<A,B,C,D> removeFirst(IDMap4Base<A,B,C,D> p);
	public IDMapping4<A,B,C,D> removeFirstByA(A a);
	public IDMapping4<A,B,C,D> removeFirstByB(B b);
	public IDMapping4<A,B,C,D> removeFirstByC(C c);
	public IDMapping4<A,B,C,D> removeFirstByD(D d);
	
	
	
	public IDMapping4<A,B,C,D> sortByA(Comparator<? super A> comp);
	public IDMapping4<A,B,C,D> sortByB(Comparator<? super B> comp);
	public IDMapping4<A,B,C,D> sortByC(Comparator<? super C> comp);
	public IDMapping4<A,B,C,D> sortByD(Comparator<? super D> comp);

	
	
	public IDMapping4<A,B,C,D> clear();	

}
