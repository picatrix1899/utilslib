package cmn.utilslib.essentials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import cmn.utilslib.dmap.Pair2;
import cmn.utilslib.dmap.Pair3;
import cmn.utilslib.dmap.Pair4;
import cmn.utilslib.dmap.DMapping2;
import cmn.utilslib.dmap.DMapping3;
import cmn.utilslib.dmap.DMapping4;
import cmn.utilslib.plugin.IPluginSystem;
import cmn.utilslib.plugin.IPluginSystemTemplate;
import cmn.utilslib.plugin.PluginSystem;
import cmn.utilslib.plugin.PluginSystemFactory;
import cmn.utilslib.plugin.PluginSystemTemplate;
import cmn.utilslib.reflection.ManagedFieldRef;

public class Auto
{
	public static <A,B> Pair2<A,B> Pair2()
	{
		return new Pair2<A,B>();
	}
	
	public static <A,B> Pair2<A,B> Pair2(A a, B b)
	{
		return new Pair2<A,B>(a, b);
	}
	
	public static <A,B,C> Pair3<A,B,C> Pair3()
	{
		return new Pair3<A,B,C>();
	}
	
	public static <A,B,C> Pair3<A,B,C> Pair3(A a, B b, C c)
	{
		return new Pair3<A,B,C>(a, b, c);
	}
	
	public static <A,B,C,D> Pair4<A,B,C,D> Pair4()
	{
		return new Pair4<A,B,C,D>();
	}
	
	public static <A,B,C,D> Pair4<A,B,C,D> Pair4(A a, B b, C c, D d)
	{
		return new Pair4<A,B,C,D>(a, b, c, d);
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
