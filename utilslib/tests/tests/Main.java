package tests;

import cmn.utilslib.reflection.ManagedFieldRef;

public class Main
{

	public static void main(String[] args)
	{
		A a = new A();
		B b = new B();
		C c = new C();
		
		ManagedFieldRef<Integer> ref = new ManagedFieldRef<Integer>("b", A.class, b);
		
		System.out.println(ref.get());
	}
	

}
