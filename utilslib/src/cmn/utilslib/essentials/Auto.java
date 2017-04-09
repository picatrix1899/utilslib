package cmn.utilslib.essentials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import cmn.utilslib.dmap.DMap2;
import cmn.utilslib.dmap.DMap3;
import cmn.utilslib.dmap.DMap4;
import cmn.utilslib.dmap.DMapping2;
import cmn.utilslib.dmap.DMapping3;
import cmn.utilslib.dmap.DMapping4;
import cmn.utilslib.dmap.IDMap2Base;
import cmn.utilslib.dmap.IDMap3Base;
import cmn.utilslib.dmap.IDMap4Base;
import cmn.utilslib.dmap.LinkedDMap2;
import cmn.utilslib.dmap.LinkedDMap3;
import cmn.utilslib.dmap.LinkedDMap4;
import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.plugin.IPluginSystem;
import cmn.utilslib.plugin.IPluginSystemTemplate;
import cmn.utilslib.plugin.PluginSystem;
import cmn.utilslib.plugin.PluginSystemFactory;
import cmn.utilslib.plugin.PluginSystemTemplate;
import cmn.utilslib.reflection.ManagedFieldRef;

public class Auto
{
	
	
	public static <T> SimpleMemoryIterator<T> SimpleMemoryIterator(Function<Void,Integer> f_size, Function<Integer,T> f_get)
	{
		return new SimpleMemoryIterator<T>(f_size, f_get);
	}
	

	
	public static <T,P> LinkedValue<T,P> LinkedValue(P p)
	{
		return new LinkedValue<T,P>(p);
	}
	
		public static <T,P> LinkedValue<T,P> LinkedValue(P p, T t)
	{
		return new LinkedValue<T,P>(p);
	}
	

	
	public static <A,B> LinkedDMap2<A,B> LinkedDMap2()
	{
		return new LinkedDMap2<A,B>();
	}
	
	public static <A,B> LinkedDMap2<A,B> LinkedDMap2(A a, B b)
	{
		return new LinkedDMap2<A,B>(a, b);
	}
	
	public static <A,B> LinkedDMap2<A,B> LinkedDMap2(IDMap2Base<A,B> dmap)
	{
		return new LinkedDMap2<A,B>(dmap);
	}
	
	public static <A,B,C> LinkedDMap3<A,B,C> LinkedDMap3()
	{
		return new LinkedDMap3<A,B,C>();
	}
	
	public static <A,B,C> LinkedDMap3<A,B,C> LinkedDMap3(A a, B b, C c)
	{
		return new LinkedDMap3<A,B,C>(a, b, c);
	}
	
	public static <A,B,C> LinkedDMap3<A,B,C> LinkedDMap3(IDMap3Base<A,B,C> dmap)
	{
		return new LinkedDMap3<A,B,C>(dmap);
	}
	
	public static <A,B,C,D> LinkedDMap4<A,B,C,D> LinkedDMap4()
	{
		return new LinkedDMap4<A,B,C,D>();
	}
	
	public static <A,B,C,D> LinkedDMap4<A,B,C,D> LinkedDMap4(A a, B b, C c, D d)
	{
		return new LinkedDMap4<A,B,C,D>(a, b, c, d);
	}
	
	public static <A,B,C,D> LinkedDMap4<A,B,C,D> LinkedDMap4(IDMap4Base<A,B,C,D> dmap)
	{
		return new LinkedDMap4<A,B,C,D>(dmap);
	}
	
	public static <A,B> DMap2<A,B> DMap2()
	{
		return new DMap2<A,B>();
	}
	
	public static <A,B> DMap2<A,B> DMap2(A a, B b)
	{
		return new DMap2<A,B>(a, b);
	}
	
	public static <A,B> DMap2<A,B> DMap2(IDMap2Base<A,B> dmap)
	{
		return new DMap2<A,B>(dmap);
	}
	
	public static <A,B,C> DMap3<A,B,C> DMap3()
	{
		return new DMap3<A,B,C>();
	}
	
	public static <A,B,C> DMap3<A,B,C> DMap3(A a, B b, C c)
	{
		return new DMap3<A,B,C>(a, b, c);
	}
	
	public static <A,B,C> DMap3<A,B,C> DMap3(IDMap3Base<A,B,C> dmap)
	{
		return new DMap3<A,B,C>(dmap);
	}
	
	public static <A,B,C,D> DMap4<A,B,C,D> DMap4()
	{
		return new DMap4<A,B,C,D>();
	}
	
	public static <A,B,C,D> DMap4<A,B,C,D> DMap4(A a, B b, C c, D d)
	{
		return new DMap4<A,B,C,D>(a, b, c, d);
	}
	
	public static <A,B,C,D> DMap4<A,B,C,D> DMap4(IDMap4Base<A,B,C,D> dmap)
	{
		return new DMap4<A,B,C,D>(dmap);
	}
	
	
	
	public static <A,B> DMapping2<A,B> DMapping2()
	{
		return new DMapping2<A,B>();
	}
	
	public static <A,B,C> DMapping3<A,B,C> DMapping3()
	{
		return new DMapping3<A,B,C>();
	}
	
	public static <A,B,C,D> DMapping4<A,B,C,D> DMapping4()
	{
		return new DMapping4<A,B,C,D>();
	}
	
	
	
	public static <K,V> HashMap<K,V> HashMap()
	{
		return new HashMap<K,V>();
	}
	
	public static <K,V> HashMap<K,V> HashMap(Map<? extends K, ? extends V> m)
	{
		return new HashMap<K,V>(m);
	}
	
	
	public static <V> ArrayList<V> ArrayList()
	{
		return new ArrayList<V>();
	}
	
	
	public static <V> ArrayList<V> ArrayList(Collection<? extends V> c)
	{
		return new ArrayList<V>(c);
	}
	
	
	public static <A> IPluginSystem<A> PluginSystem(A a)
	{
		return new PluginSystem<A>(a);
	}
	
	public static <A> IPluginSystemTemplate<A> PluginSystemTemplate()
	{
		return new PluginSystemTemplate<A>();
	}
	
	public static <A> PluginSystemFactory<A> PluginSystemFactory()
	{
		return new PluginSystemFactory<A>();
	}
	
	public static <A> ManagedFieldRef<A> ManagedFieldRef(String field, Class<?> clazz, Object obj)
	{
		
		return new ManagedFieldRef<A>(field, clazz, obj);
		
	}
	
}
