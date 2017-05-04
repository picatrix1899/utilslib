package cmn.utilslib.essentials;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JList;

import cmn.utilslib.dmap.LinkedValue;
import cmn.utilslib.dmap.dmappings.DMapping2;
import cmn.utilslib.dmap.dmappings.DMapping3;
import cmn.utilslib.dmap.dmappings.DMapping4;
import cmn.utilslib.dmap.dmaps.DMap2;
import cmn.utilslib.dmap.dmaps.DMap3;
import cmn.utilslib.dmap.dmaps.DMap4;
import cmn.utilslib.dmap.dmaps.LinkedDMap2;
import cmn.utilslib.dmap.dmaps.LinkedDMap3;
import cmn.utilslib.dmap.dmaps.LinkedDMap4;
import cmn.utilslib.dmap.dmaps.api.IDMap2Base;
import cmn.utilslib.dmap.dmaps.api.IDMap3Base;
import cmn.utilslib.dmap.dmaps.api.IDMap4Base;
import cmn.utilslib.exceptions.IErrorHandler;
import cmn.utilslib.exceptions.SimpleErrorHandler;
import cmn.utilslib.plugin.IPluginSystem;
import cmn.utilslib.plugin.IPluginSystemTemplate;
import cmn.utilslib.plugin.PluginSystem;
import cmn.utilslib.plugin.PluginSystemFactory;
import cmn.utilslib.plugin.PluginSystemTemplate;
import cmn.utilslib.reflection.FieldRef;
import cmn.utilslib.reflection.ManagedFieldRef;

public class Auto
{
	
	private static IErrorHandler handler = new SimpleErrorHandler();
	
	public static void setErrorHandler(IErrorHandler h)
	{
		Auto.handler = h;
	}
	
	public static void resetErrorHandler()
	{
		Auto.handler = new SimpleErrorHandler();
	}
	
	public static <T> SimpleMemoryIterator<T> SimpleMemoryIterator(Function<Void,Integer> f_size, Function<Integer,T> f_get)
	{ return new SimpleMemoryIterator<T>(f_size, f_get); }
	

	
	public static <T,P> LinkedValue<T,P> LinkedValue(P p)
	{ return new LinkedValue<T,P>(p); }
	
	public static <T,P> LinkedValue<T,P> LinkedValue(P p, T t)
	{ return new LinkedValue<T,P>(p); }
	

	
	public static <A,B> LinkedDMap2<A,B> LinkedDMap2()
	{ return new LinkedDMap2<A,B>(); }
	
	public static <A,B> LinkedDMap2<A,B> LinkedDMap2(A a, B b)
	{ return new LinkedDMap2<A,B>(a, b); }
	
	public static <A,B> LinkedDMap2<A,B> LinkedDMap2(IDMap2Base<A,B> dmap)
	{ return new LinkedDMap2<A,B>(dmap); }
	
	public static <A,B,C> LinkedDMap3<A,B,C> LinkedDMap3()
	{ return new LinkedDMap3<A,B,C>();}
	
	public static <A,B,C> LinkedDMap3<A,B,C> LinkedDMap3(A a, B b, C c)
	{ return new LinkedDMap3<A,B,C>(a, b, c); }
	
	public static <A,B,C> LinkedDMap3<A,B,C> LinkedDMap3(IDMap3Base<A,B,C> dmap)
	{ return new LinkedDMap3<A,B,C>(dmap); }
	
	public static <A,B,C,D> LinkedDMap4<A,B,C,D> LinkedDMap4()
	{ return new LinkedDMap4<A,B,C,D>(); }
	
	public static <A,B,C,D> LinkedDMap4<A,B,C,D> LinkedDMap4(A a, B b, C c, D d)
	{ return new LinkedDMap4<A,B,C,D>(a, b, c, d); }
	
	public static <A,B,C,D> LinkedDMap4<A,B,C,D> LinkedDMap4(IDMap4Base<A,B,C,D> dmap)
	{ return new LinkedDMap4<A,B,C,D>(dmap); }
	
	public static <A,B> DMap2<A,B> DMap2()
	{ return new DMap2<A,B>(); }
	
	public static <A,B> DMap2<A,B> DMap2(A a, B b)
	{ return new DMap2<A,B>(a, b); }
	
	public static <A,B> DMap2<A,B> DMap2(IDMap2Base<A,B> dmap)
	{ return new DMap2<A,B>(dmap); }
	
	public static <A,B,C> DMap3<A,B,C> DMap3()
	{ return new DMap3<A,B,C>(); }
	
	public static <A,B,C> DMap3<A,B,C> DMap3(A a, B b, C c)
	{ return new DMap3<A,B,C>(a, b, c); }
	
	public static <A,B,C> DMap3<A,B,C> DMap3(IDMap3Base<A,B,C> dmap)
	{ return new DMap3<A,B,C>(dmap); }
	
	public static <A,B,C,D> DMap4<A,B,C,D> DMap4()
	{ return new DMap4<A,B,C,D>(); }
	
	public static <A,B,C,D> DMap4<A,B,C,D> DMap4(A a, B b, C c, D d)
	{ return new DMap4<A,B,C,D>(a, b, c, d); }
	
	public static <A,B,C,D> DMap4<A,B,C,D> DMap4(IDMap4Base<A,B,C,D> dmap)
	{ return new DMap4<A,B,C,D>(dmap); }
	
	
	
	public static <A,B> DMapping2<A,B> DMapping2()
	{ return new DMapping2<A,B>(); }
	
	public static <A,B,C> DMapping3<A,B,C> DMapping3()
	{ return new DMapping3<A,B,C>(); }
	
	public static <A,B,C,D> DMapping4<A,B,C,D> DMapping4()
	{ return new DMapping4<A,B,C,D>(); }
	
	
	
	public static <K,V> HashMap<K,V> HashMap()
	{ return new HashMap<K,V>(); }
	
	public static <K,V> HashMap<K,V> HashMap(Map<? extends K, ? extends V> m)
	{ return new HashMap<K,V>(m); }
	
	
	public static <V> ArrayList<V> ArrayList()
	{ return new ArrayList<V>(); }
	
	
	public static <V> ArrayList<V> ArrayList(Collection<? extends V> c)
	{ return new ArrayList<V>(c); }
	
	
	@SuppressWarnings("unchecked")
	public static <V> ArrayList<V> ArrayList(V... args)
	{
		ArrayList<V> out = ArrayList();
		
		Collections.addAll(out, args);
		
		return out;
	}
	
	public static <A> PluginSystem<A> PluginSystem(A a)
	{ return new PluginSystem<A>(a); }
	
	public static <A> PluginSystemTemplate<A> PluginSystemTemplate()
	{ return new PluginSystemTemplate<A>(); }
	
	public static <A> PluginSystemFactory<A> PluginSystemFactory()
	{ return new PluginSystemFactory<A>(); }
	
	public static <A> FieldRef<A> FieldRef(String field, Class<?> clazz, Object obj) throws Exception
	{
		return new FieldRef<A>(field, clazz, obj);
	}
	
	public static <A> ManagedFieldRef<A> ManagedFieldRef(String field, Class<?> clazz, Object obj)
	{ return new ManagedFieldRef<A>(field, clazz, obj);	 }
	
	
	public static DataInputStream DataInputStream(InputStream stream)
	{ return new DataInputStream(stream); }
	
	public static DataInputStream DataInputStream(Socket socket)
	{
		try
		{
			return new DataInputStream(socket.getInputStream());
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	public static DataInputStream DataInputStream(File file)
	{
		try
		{
			return new DataInputStream(new FileInputStream(file));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}

	public static DataOutputStream DataOutputStream(OutputStream stream)
	{ return new DataOutputStream(stream); }
	
	public static DataOutputStream DataOutputStream(Socket socket)
	{
		try
		{
			return new DataOutputStream(socket.getOutputStream());
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	public static DataOutputStream DataOutputStream(File file)
	{
		try
		{
			return new DataOutputStream(new FileOutputStream(file));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	
	public static BufferedInputStream BufferedInputStream(InputStream stream)
	{ return new BufferedInputStream(stream); }
	
	public static BufferedInputStream BufferedInputStream(Socket socket)
	{
		try
		{
			return new BufferedInputStream(socket.getInputStream());
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		return null;
	}
	
	public static BufferedInputStream BufferedInputStream(File file)
	{
		try
		{
			return new BufferedInputStream(new FileInputStream(file));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		return null;
	}
	
	public static BufferedOutputStream BufferedOutputStream(OutputStream stream)
	{ return new BufferedOutputStream(stream); }
	
	public static BufferedOutputStream BufferedOutputStream(Socket socket)
	{
		try
		{
			return new BufferedOutputStream(socket.getOutputStream());
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		return null;
	}
	
	public static BufferedOutputStream BufferedOutputStream(File file)
	{
		try
		{
			return new BufferedOutputStream(new FileOutputStream(file));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		return null;
	}
	
	public static BufferedReader BufferedReader(InputStream stream)
	{
		try
		{
			return new BufferedReader(new InputStreamReader(stream));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	public static BufferedReader BufferedReader(File file)
	{
		try
		{
			return new BufferedReader(new FileReader(file));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	public static BufferedWriter BufferedWriter(OutputStream stream)
	{
		try
		{
			return new BufferedWriter(new OutputStreamWriter(stream));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	public static BufferedWriter BufferedWriter(File file)
	{
		try
		{
			return new BufferedWriter(new FileWriter(file));
		}
		catch(Exception e)
		{
			handler.handle(e);
		}
		
		return null;
	}
	
	public static <A> JList<A> JList()
	{ return new JList<A>(); }
	
	
}
