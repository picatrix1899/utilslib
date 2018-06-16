package cmn.utilslib.dmap.dmappings.api;

import java.util.Comparator;

import cmn.utilslib.dmap.dmaps.api.IDMap4Base;

public interface IDMapping4<A,B,C,D> extends IDMapping4Base<A,B,C,D>
{


	IDMapping4<A,B,C,D> set(int index, A a, B b, C c, D d);
	IDMapping4<A,B,C,D> set(int index, IDMap4Base<A,B,C,D> entry);
	IDMapping4<A,B,C,D> setA(int index, A a);
	IDMapping4<A,B,C,D> setB(int index, B b);
	IDMapping4<A,B,C,D> setC(int index, C c);
	IDMapping4<A,B,C,D> setD(int index, D d);
	
	
	
	IDMapping4<A,B,C,D> add(A a, B b, C c, D d);
	IDMapping4<A,B,C,D> add(IDMap4Base<A,B,C,D> entry);
	
	

	IDMapping4<A,B,C,D> remove(int index);
	
	IDMapping4<A,B,C,D> remove(A a, B b, C c, D d);
	IDMapping4<A,B,C,D> remove(IDMap4Base<A,B,C,D> entry);
	IDMapping4<A,B,C,D> removeByA(A a);
	IDMapping4<A,B,C,D> removeByB(B b);
	IDMapping4<A,B,C,D> removeByC(C c);
	IDMapping4<A,B,C,D> removeByD(D d);
	
	
	
	IDMapping4<A,B,C,D> removeFirst(A a, B b, C c, D d);
	IDMapping4<A,B,C,D> removeFirst(IDMap4Base<A,B,C,D> p);
	IDMapping4<A,B,C,D> removeFirstByA(A a);
	IDMapping4<A,B,C,D> removeFirstByB(B b);
	IDMapping4<A,B,C,D> removeFirstByC(C c);
	IDMapping4<A,B,C,D> removeFirstByD(D d);
	
	
	
	IDMapping4<A,B,C,D> sortByA(Comparator<? super A> comp);
	IDMapping4<A,B,C,D> sortByB(Comparator<? super B> comp);
	IDMapping4<A,B,C,D> sortByC(Comparator<? super C> comp);
	IDMapping4<A,B,C,D> sortByD(Comparator<? super D> comp);

	
	
	IDMapping4<A,B,C,D> clear();	

}
