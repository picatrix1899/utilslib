package cmn.utilslib.dmap.dmappings.api;

import java.util.Comparator;

import cmn.utilslib.dmap.dmaps.api.IDMap2Base;

public interface IDMapping2<A,B> extends IDMapping2Base<A,B>
{

	IDMapping2<A,B> set(int index, A a, B b);
	IDMapping2<A,B> set(int index, IDMap2Base<A,B> entry);
	IDMapping2<A,B> setA(int index, A a);
	IDMapping2<A,B> setB(int index, B b);
	
	
	
	IDMapping2<A,B> add(A a, B b);
	IDMapping2<A,B> add(IDMap2Base<A,B> entry);
	
	

	IDMapping2<A,B> remove(int index);
	
	IDMapping2<A,B> remove(A a, B b);
	IDMapping2<A,B> remove(IDMap2Base<A,B> entry);
	IDMapping2<A,B> removeByA(A a);
	IDMapping2<A,B> removeByB(B b);
	
	
	
	IDMapping2<A,B> removeFirst(A a , B b);
	IDMapping2<A,B> removeFirst(IDMap2Base<A,B> p);
	IDMapping2<A,B> removeFirstByA(A a);
	IDMapping2<A,B> removeFirstByB(B b);
	
	
	
	IDMapping2<A,B> sortByA(Comparator<? super A> comp);
	IDMapping2<A,B> sortByB(Comparator<? super B> comp);

	
	
	IDMapping2<A,B> clear();	

}
