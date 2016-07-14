package cmn.picatrix1899.utilslib.essentials;

import java.util.List;

import cmn.picatrix1899.utilslib.exceptions.Exceptions;
import cmn.picatrix1899.utilslib.vector.Vector2d;
import cmn.picatrix1899.utilslib.vector.Vector2f;
import cmn.picatrix1899.utilslib.vector.Vector3d;
import cmn.picatrix1899.utilslib.vector.Vector3f;

/**
 * 

 * @author picatrix1899
 *
 */
public abstract class Validate
{
	
	public static void isTrue(boolean exp) { Validate.isTrue(exp, "Validate isTrue: expression results in false!"); }
	
	public static void isTrue(boolean exp, String msg) { Validate.isTrue(exp, msg, Exceptions.IllegalArgument); }
	
	public static void isTrue(boolean exp, String msg, Exceptions e) { if(Check.notTrue(exp)) Exceptions.handle(e, msg); }
	
	public static void isTrue(boolean exp, String msg, Class<? extends RuntimeException> e) { if(Check.notTrue(exp)) Exceptions.handle(e, msg); }
	

	
	public static void isFalse(boolean exp) { Validate.isFalse(exp, "Validate isFalse: expression results in true!"); }
	
	public static void isFalse(boolean exp, String msg) { Validate.isFalse(exp, msg, Exceptions.IllegalArgument); }
	
	public static void isFalse(boolean exp, String msg, Exceptions e) { if(Check.notFalse(exp)) Exceptions.handle(e, msg); }
	
	public static void isFalse(boolean exp, String msg, Class<? extends RuntimeException> e) { if(Check.notFalse(exp)) Exceptions.handle(e, msg); }
	
	
	
	public static void isNull(Object obj) { Validate.isNull(obj, "Validate isNull: object obj is not null!"); }
	
	public static void isNull(Object obj, String msg) { Validate.isNull(obj, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(Object obj, String msg, Exceptions e) { if(Check.notNull(obj)) Exceptions.handle(e, msg); }
	
	public static void isNull(Object obj, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(obj)) Exceptions.handle(e, msg); }
	
	public static void isNull(String str) { Validate.isNull(str, "Validate isNull: string str is not null!"); }
	
	public static void isNull(String str, String msg) { Validate.isNull(str, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(String str, String msg, Exceptions e) { if(Check.notNull(str)) Exceptions.handle(e, msg); }
	
	public static void isNull(String str, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(str)) Exceptions.handle(e, msg); }
	
	public static void isNull(byte b) { Validate.isNull(b, "Validate isNull: value i is not null!"); }
	
	public static void isNull(byte b, String msg) { Validate.isNull(b, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(byte b, String msg, Exceptions e) { if(Check.notNull(b)) Exceptions.handle(e, msg); }
	
	public static void isNull(byte b, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(b)) Exceptions.handle(e, msg); }

	public static void isNull(short s) { Validate.isNull(s, "Validate isNull: value i is not null!"); }
	
	public static void isNull(short s, String msg) { Validate.isNull(s, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(short s, String msg, Exceptions e) { if(Check.notNull(s)) Exceptions.handle(e, msg); }
	
	public static void isNull(short s, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(s)) Exceptions.handle(e, msg); }	
	
	public static void isNull(int i) { Validate.isNull(i, "Validate isNull: value i is not null!"); }
	
	public static void isNull(int i, String msg) { Validate.isNull(i, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(int i, String msg, Exceptions e) { if(Check.notNull(i)) Exceptions.handle(e, msg); }
	
	public static void isNull(int i, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(i)) Exceptions.handle(e, msg); }
	
	public static void isNull(long l) { Validate.isNull(l, "Validate isNull: value i is not null!"); }
	
	public static void isNull(long l, String msg) { Validate.isNull(l, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(long l, String msg, Exceptions e) { if(Check.notNull(l)) Exceptions.handle(e, msg); }
	
	public static void isNull(long l, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(l)) Exceptions.handle(e, msg); }
	
	public static void isNull(float f) { Validate.isNull(f, "Validate isNull: value i is not null!"); }
	
	public static void isNull(float f, String msg) { Validate.isNull(f, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(float f, String msg, Exceptions e) { if(Check.notNull(f)) Exceptions.handle(e, msg); }
	
	public static void isNull(float f, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(f)) Exceptions.handle(e, msg); }
	
	public static void isNull(double d) { Validate.isNull(d, "Validate isNull: value i is not null!"); }
	
	public static void isNull(double d, String msg) { Validate.isNull(d, msg, Exceptions.IllegalArgument); }
	
	public static void isNull(double d, String msg, Exceptions e) { if(Check.notNull(d)) Exceptions.handle(e, msg); }
	
	public static void isNull(double d, String msg, Class<? extends RuntimeException> e) { if(Check.notNull(d)) Exceptions.handle(e, msg); }
	
	
	
	public static void isInBetween(byte b, byte min, byte max) { Validate.isInBetween(b, min, max, "Validate isInBetween: value i is not between borders!"); }
	
	public static void isInBetween(byte b, byte min, byte max, String msg) { Validate.isInBetween(b, min ,max, msg, Exceptions.IllegalArgument); }
	
	public static void isInBetween(byte b, byte min, byte max, String msg, Exceptions e) { if(Check.notInBetween(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(byte b, byte min, byte max, String msg, Class<? extends RuntimeException> e) { if(Check.notInBetween(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(short s, short min, short max) { Validate.isInBetween(s, min, max, "Validate isInBetween: value i is not between borders!"); }
	
	public static void isInBetween(short s, short min, short max, String msg) { Validate.isInBetween(s, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInBetween(short s, short min, short max, String msg, Exceptions e) { if(Check.notInBetween(s, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(short s, short min, short max, String msg, Class<? extends RuntimeException> e) { if(Check.notInBetween(s, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(int i, int min, int max) { Validate.isInBetween(i, min, max, "Validate isInBetween: value i is not between borders!"); }
	
	public static void isInBetween(int i, int min, int max, String msg) { Validate.isInBetween(i, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInBetween(int i, int min, int max, String msg, Exceptions e) { if(Check.notInBetween(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(int i, int min, int max, String msg, Class<? extends RuntimeException> e) { if(Check.notInBetween(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(long l, long min, long max) { Validate.isInBetween(l, min, max, "Validate isInBetween: value i is not between borders!"); }
	
	public static void isInBetween(long l, long min, long max, String msg) { Validate.isInBetween(l, min ,max, msg, Exceptions.IllegalArgument); }
	
	public static void isInBetween(long l, long min, long max, String msg, Exceptions e) { if(Check.notInBetween(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(long l, long min, long max, String msg, Class<? extends RuntimeException> e) { if(Check.notInBetween(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(float f, float min, float max) { Validate.isInBetween(f, min, max, "Validate isInBetween: value i is not between borders!"); }
	
	public static void isInBetween(float f, float min ,float max, String msg) { Validate.isInBetween(f, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInBetween(float f, float min, float max, String msg, Exceptions e) { if(Check.notInBetween(f, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(float f, float min, float max, String msg, Class<? extends RuntimeException> e) { if(Check.notInBetween(f, min, max)) Exceptions.handle(e, msg); }	
	
	public static void isInBetween(double d, double min, double max) { Validate.isInBetween(d, min, max, "Validate isInBetween: value i is not between borders!"); }
	
	public static void isInBetween(double d, double min, double max, String msg) { Validate.isInBetween(d, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInBetween(double d, double min, double max, String msg, Exceptions e) { if(Check.notInBetween(d, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInBetween(double d, double min, double max, String msg, Class<? extends RuntimeException> e) { if(Check.notInBetween(d, min, max)) Exceptions.handle(e, msg); }
	
	
	
	public static void isInRange(byte b, byte min, byte max) { Validate.isInRange(b, min, max, "Validate isInRange: value i is not in range!"); }
	
	public static void isInRange(byte b, byte min, byte max, String msg) { Validate.isInRange(b, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInRange(byte b, byte min, byte max, String msg, Exceptions e) { if(Check.notInRange(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(byte b, byte min, byte max, String msg, Class<? extends RuntimeException> e) { if(Check.notInRange(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(short s, short min, short max) { Validate.isInRange(s, min, max, "Validate isInRange: value i is not in range!"); }
	
	public static void isInRange(short s, short min, short max, String msg) { Validate.isInRange(s, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInRange(short s, short min, short max, String msg, Exceptions e) { if(Check.notInRange(s, min, max)) Exceptions.handle(e, msg); }	
	
	public static void isInRange(short s, short min, short max, String msg, Class<? extends RuntimeException> e) { if(Check.notInRange(s, min, max)) Exceptions.handle(e, msg); }	
	
	public static void isInRange(int i, int min, int max) { Validate.isInRange(i, min, max, "Validate isInRange: value i is not in range!"); }
	
	public static void isInRange(int i, int min, int max, String msg) { Validate.isInRange(i, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInRange(int i, int min, int max, String msg, Exceptions e) { if(Check.notInRange(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(int i, int min, int max, String msg, Class<? extends RuntimeException> e) { if(Check.notInRange(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(long l, long min, long max) { Validate.isInRange(l, min, max, "Validate isInRange: value i is not in range!"); }
	
	public static void isInRange(long l, long min, long max, String msg) { Validate.isInRange(l, min ,max, msg, Exceptions.IllegalArgument); }
	
	public static void isInRange(long l, long min, long max, String msg, Exceptions e) { if(Check.notInRange(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(long l, long min, long max, String msg, Class<? extends RuntimeException> e) { if(Check.notInRange(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(float f, float min, float max) { Validate.isInRange(f, min, max, "Validate isInRange: value i is not in range!"); }
	
	public static void isInRange(float f, float min, float max, String msg) { Validate.isInRange(f, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInRange(float f, float min, float max, String msg, Exceptions e) { if(Check.notInRange(f, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(float f, float min, float max, String msg, Class<? extends RuntimeException> e) { if(Check.notInRange(f, min, max)) Exceptions.handle(e, msg); }	
	
	public static void isInRange(double d, double min, double max) { Validate.isInRange(d, min, max, "Validate isInRange: value i is not in range!"); }
	
	public static void isInRange(double d, double min, double max, String msg) { Validate.isInRange(d, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void isInRange(double d, double min, double max, String msg, Exceptions e) { if(Check.notInRange(d, min, max)) Exceptions.handle(e, msg); }
	
	public static void isInRange(double d, double min, double max, String msg, Class<? extends RuntimeException> e) { if(Check.notInRange(d, min, max)) Exceptions.handle(e, msg); }
	
	

	public static void isBelow(byte b, byte max) { Validate.isBelow(b, max, "Validate isBelow: value byte b is not below min!"); }
	
	public static void isBelow(byte b, byte max, String msg) { Validate.isBelow(b, max, msg, Exceptions.IllegalArgument); }
	
	public static void isBelow(byte b, byte max, String msg, Exceptions e) { if(Check.notBelow(b, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(byte b, byte max, String msg, Class<? extends RuntimeException> e) { if(Check.notBelow(b, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(short s, short max) { Validate.isBelow(s, max, "Validate isBelow: value short s is not below min!"); }
	
	public static void isBelow(short s, short max, String msg) { Validate.isBelow(s, max, msg, Exceptions.IllegalArgument); }
	
	public static void isBelow(short s, short max, String msg, Exceptions e) { if(Check.notBelow(s, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(short s, short max, String msg, Class<? extends RuntimeException> e) { if(Check.notBelow(s, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(int i, int max) { Validate.isBelow(i, max, "Validate isBelow: value int i is not below min!"); }
	
	public static void isBelow(int i, int max, String msg) { Validate.isBelow(i, max, msg, Exceptions.IllegalArgument); }
	
	public static void isBelow(int i, int max, String msg, Exceptions e) { if(Check.notBelow(i, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(int i, int max, String msg, Class<? extends RuntimeException> e) { if(Check.notBelow(i, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(long l, long max) { Validate.isBelow(l, max, "Validate isBelow: value long l is not below min!"); }
	
	public static void isBelow(long l, long max, String msg) { Validate.isBelow(l, max, msg, Exceptions.IllegalArgument); }
	
	public static void isBelow(long l, long max, String msg, Exceptions e) { if(Check.notBelow(l, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(long l, long max, String msg, Class<? extends RuntimeException> e) { if(Check.notBelow(l, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(float f, float max) { Validate.isBelow(f, max, "Validate isBelow: value float f is not below min!"); }
	
	public static void isBelow(float f, float max, String msg) { Validate.isBelow(f, max, msg, Exceptions.IllegalArgument); }
	
	public static void isBelow(float f, float max, String msg, Exceptions e) { if(Check.notBelow(f, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(float f, float max, String msg, Class<? extends RuntimeException> e) { if(Check.notBelow(f, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(double d, double max) { Validate.isBelow(d, max, "Validate isBelow: value double d is not below min!"); }
	
	public static void isBelow(double d, double max, String msg) { Validate.isBelow(d, max, msg, Exceptions.IllegalArgument); }
	
	public static void isBelow(double d, double max, String msg, Exceptions e) { if(Check.notBelow(d, max)) Exceptions.handle(e, msg); }
	
	public static void isBelow(double d, double max, String msg, Class<? extends RuntimeException> e) { if(Check.notBelow(d, max)) Exceptions.handle(e, msg); }
	

	
	public static void isAbove(byte b, byte min) { Validate.isAbove(b, min, "Validate isAbove: value byte b is not above min!"); }
	
	public static void isAbove(byte b, byte min, String msg) { Validate.isAbove(b, min, msg, Exceptions.IllegalArgument); }
	
	public static void isAbove(byte b, byte min, String msg, Exceptions e) { if(Check.notAbove(b, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(byte b, byte min, String msg, Class<? extends RuntimeException> e) { if(Check.notAbove(b, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(short s, short min) { Validate.isAbove(s, min, "Validate isAbove: value short s is not above min!"); }
	
	public static void isAbove(short s, short min, String msg) { Validate.isAbove(s, min, msg, Exceptions.IllegalArgument); }
	
	public static void isAbove(short s, short min, String msg, Exceptions e) { if(Check.notAbove(s, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(short s, short min, String msg, Class<? extends RuntimeException> e) { if(Check.notAbove(s, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(int i, int min) { Validate.isAbove(i, min, "Validate isAbove: value int i is not above min!"); }
	
	public static void isAbove(int i, int min, String msg) { Validate.isAbove(i, min, msg, Exceptions.IllegalArgument); }
	
	public static void isAbove(int i, int min, String msg, Exceptions e) { if(Check.notAbove(i, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(int i, int min, String msg, Class<? extends RuntimeException> e) { if(Check.notAbove(i, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(long l, long min) { Validate.isAbove(l, min, "Validate isAbove: value long l is not above min!"); }
	
	public static void isAbove(long l, long min, String msg) { Validate.isAbove(l, min, msg, Exceptions.IllegalArgument); }
	
	public static void isAbove(long l, long min, String msg, Exceptions e) { if(Check.notAbove(l, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(long l, long min, String msg, Class<? extends RuntimeException> e) { if(Check.notAbove(l, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(float f, float min) { Validate.isAbove(f, min, "Validate isAbove: value float f is not above min!"); }
	
	public static void isAbove(float f, float min, String msg) { Validate.isAbove(f, min, msg, Exceptions.IllegalArgument); }
	
	public static void isAbove(float f, float min, String msg, Exceptions e) { if(Check.notAbove(f, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(float f, float min, String msg, Class<? extends RuntimeException> e) { if(Check.notAbove(f, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(double d, double min) { Validate.isAbove(d, min, "Validate isAbove: value double d is not above min!"); }
	
	public static void isAbove(double d, double min, String msg) { Validate.isAbove(d, min, msg, Exceptions.IllegalArgument); }
	
	public static void isAbove(double d, double min, String msg, Exceptions e) { if(Check.notAbove(d, min)) Exceptions.handle(e, msg); }
	
	public static void isAbove(double d, double min, String msg, Class<? extends RuntimeException> e) { if(Check.notAbove(d, min)) Exceptions.handle(e, msg); }
	
	
	
	public static void isEmpty(String str) { Validate.isEmpty(str, "Validate isEmpty: string str is not empty!"); }
	
	public static void isEmpty(String str, String msg) { Validate.isEmpty(str, msg, Exceptions.IllegalArgument); }
	
	public static void isEmpty(String str, String msg, Exceptions e) { if(Check.notEmpty(str)) Exceptions.handle(e, msg); }
	
	public static void isEmpty(String str, String msg, Class<? extends RuntimeException> e) { if(Check.notEmpty(str)) Exceptions.handle(e, msg); }
	
	public static void isEmpty(Object[] arg) { Validate.isEmpty(arg, "Validate isEmpty: array arg is not empty!"); }
	
	public static void isEmpty(Object[] arg, String msg) { Validate.isEmpty(arg, msg, Exceptions.IllegalArgument); }
	
	public static void isEmpty(Object[] arg, String msg, Exceptions e) { if(Check.notEmpty(arg)) Exceptions.handle(e, msg); }
	
	public static void isEmpty(Object[] arg, String msg, Class<? extends RuntimeException> e) { if(Check.notEmpty(arg)) Exceptions.handle(e, msg); }
	
	public static void isEmpty(List<?> list) { Validate.isEmpty(list, "Validate isEmpty: list list is not empty!"); }
	
	public static void isEmpty(List<?> list, String msg) { if(Check.notEmpty(list)) Validate.isEmpty(list, msg, Exceptions.IllegalArgument); }
	
	public static void isEmpty(List<?> list, String msg, Exceptions e) { if(Check.notEmpty(list)) Exceptions.handle(e, msg); }
	
	public static void isEmpty(List<?> list, String str, String msg, Class<? extends RuntimeException> e) { if(Check.notEmpty(list)) Exceptions.handle(e, msg); }
	
	
	
	
	
	
	public static void notTrue(boolean exp) { Validate.notTrue(exp, "Validate notTrue: expression results in true!"); }
	
	public static void notTrue(boolean exp, String msg) { Validate.notTrue(exp, msg, Exceptions.IllegalArgument); }
	
	public static void notTrue(boolean exp, String msg, Exceptions e) { if(Check.isTrue(exp)) Exceptions.handle(e, msg); }
	
	public static void notTrue(boolean exp, String msg, Class<? extends RuntimeException> e) { if(Check.isTrue(exp)) Exceptions.handle(e, msg); }
	

	
	public static void notFalse(boolean exp) { Validate.notFalse(exp, "Validate notFalse: expression results in false!"); }
	
	public static void notFalse(boolean exp, String msg) { Validate.notFalse(exp, msg, Exceptions.IllegalArgument); }
	
	public static void notFalse(boolean exp, String msg, Exceptions e) { if(Check.isFalse(exp)) Exceptions.handle(e, msg); }
	
	public static void notFalse(boolean exp, String msg, Class<? extends RuntimeException> e) { if(Check.isFalse(exp)) Exceptions.handle(e, msg); }
	
	
	
	public static void notNull(Object obj) { Validate.notNull(obj, "Validate notNull: object obj is null!"); }
	
	public static void notNull(Object obj, String msg) { Validate.notNull(obj, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(Object obj, String msg, Exceptions e) { if(Check.isNull(obj)) Exceptions.handle(e, msg); }
	
	public static void notNull(Object obj, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(obj)) Exceptions.handle(e, msg); }
	
	public static void notNull(String str) { Validate.notNull(str, "Validate notNull: string str is null!"); }
	
	public static void notNull(String str, String msg) { Validate.notNull(str, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(String str, String msg, Exceptions e) { if(Check.isNull(str)) Exceptions.handle(e, msg); }
	
	public static void notNull(String str, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(str)) Exceptions.handle(e, msg); }
	
	public static void notNull(byte b) { Validate.notNull(b, "Validate notNull: value i is null!"); }
	
	public static void notNull(byte b, String msg) { Validate.notNull(b, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(byte b, String msg, Exceptions e) { if(Check.isNull(b)) Exceptions.handle(e, msg); }
	
	public static void notNull(byte b, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(b)) Exceptions.handle(e, msg); }

	public static void notNull(short s) { Validate.notNull(s, "Validate notNull: value i is null!"); }
	
	public static void notNull(short s, String msg) { Validate.notNull(s, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(short s, String msg, Exceptions e) { if(Check.isNull(s)) Exceptions.handle(e, msg); }
	
	public static void notNull(short s, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(s)) Exceptions.handle(e, msg); }	
	
	public static void notNull(int i) { Validate.notNull(i, "Validate notNull: value i is null!"); }
	
	public static void notNull(int i, String msg) { Validate.notNull(i, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(int i, String msg, Exceptions e) { if(Check.isNull(i)) Exceptions.handle(e, msg); }
	
	public static void notNull(int i, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(i)) Exceptions.handle(e, msg); }
	
	public static void notNull(long l) { Validate.notNull(l, "Validate notNull: value i is null!"); }
	
	public static void notNull(long l, String msg) { Validate.notNull(l, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(long l, String msg, Exceptions e) { if(Check.isNull(l)) Exceptions.handle(e, msg); }
	
	public static void notNull(long l, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(l)) Exceptions.handle(e, msg); }
	
	public static void notNull(float f) { Validate.notNull(f, "Validate notNull: value i is null!"); }
	
	public static void notNull(float f, String msg) { Validate.notNull(f, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(float f, String msg, Exceptions e) { if(Check.isNull(f)) Exceptions.handle(e, msg); }
	
	public static void notNull(float f, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(f)) Exceptions.handle(e, msg); }
	
	public static void notNull(double d) { Validate.notNull(d, "Validate notNull: value i is null!"); }
	
	public static void notNull(double d, String msg) { Validate.notNull(d, msg, Exceptions.IllegalArgument); }
	
	public static void notNull(double d, String msg, Exceptions e) { if(Check.isNull(d)) Exceptions.handle(e, msg); }
	
	public static void notNull(double d, String msg, Class<? extends RuntimeException> e) { if(Check.isNull(d)) Exceptions.handle(e, msg); }
	
	
	
	public static void notInBetween(byte b, byte min, byte max) { Validate.notInBetween(b, min, max, "Validate notInBetween: value i is between borders!"); }
	
	public static void notInBetween(byte b, byte min, byte max, String msg) { Validate.notInBetween(b, min ,max, msg, Exceptions.IllegalArgument); }
	
	public static void notInBetween(byte b, byte min, byte max, String msg, Exceptions e) { if(Check.isInBetween(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(byte b, byte min, byte max, String msg, Class<? extends RuntimeException> e) { if(Check.isInBetween(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(short s, short min, short max) { Validate.notInBetween(s, min, max, "Validate notInBetween: value i is between borders!"); }
	
	public static void notInBetween(short s, short min, short max, String msg) { Validate.notInBetween(s, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInBetween(short s, short min, short max, String msg, Exceptions e) { if(Check.isInBetween(s, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(short s, short min, short max, String msg, Class<? extends RuntimeException> e) { if(Check.isInBetween(s, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(int i, int min, int max) { Validate.notInBetween(i, min, max, "Validate notInBetween: value i is between borders!"); }
	
	public static void notInBetween(int i, int min, int max, String msg) { Validate.notInBetween(i, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInBetween(int i, int min, int max, String msg, Exceptions e) { if(Check.isInBetween(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(int i, int min, int max, String msg, Class<? extends RuntimeException> e) { if(Check.isInBetween(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(long l, long min, long max) { Validate.notInBetween(l, min, max, "Validate notInBetween: value i is between borders!"); }
	
	public static void notInBetween(long l, long min, long max, String msg) { Validate.notInBetween(l, min ,max, msg, Exceptions.IllegalArgument); }
	
	public static void notInBetween(long l, long min, long max, String msg, Exceptions e) { if(Check.isInBetween(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(long l, long min, long max, String msg, Class<? extends RuntimeException> e) { if(Check.isInBetween(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(float f, float min, float max) { Validate.notInBetween(f, min, max, "Validate notInBetween: value i is between borders!"); }
	
	public static void notInBetween(float f, float min ,float max, String msg) { Validate.notInBetween(f, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInBetween(float f, float min, float max, String msg, Exceptions e) { if(Check.isInBetween(f, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(float f, float min, float max, String msg, Class<? extends RuntimeException> e) { if(Check.isInBetween(f, min, max)) Exceptions.handle(e, msg); }	
	
	public static void notInBetween(double d, double min, double max) { Validate.notInBetween(d, min, max, "Validate notInBetween: value i is between borders!"); }
	
	public static void notInBetween(double d, double min, double max, String msg) { Validate.notInBetween(d, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInBetween(double d, double min, double max, String msg, Exceptions e) { if(Check.isInBetween(d, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInBetween(double d, double min, double max, String msg, Class<? extends RuntimeException> e) { if(Check.isInBetween(d, min, max)) Exceptions.handle(e, msg); }
	
	
	
	public static void notInRange(byte b, byte min, byte max) { Validate.notInRange(b, min, max, "Validate notInRange: value i is in range!"); }
	
	public static void notInRange(byte b, byte min, byte max, String msg) { Validate.notInRange(b, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInRange(byte b, byte min, byte max, String msg, Exceptions e) { if(Check.isInRange(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(byte b, byte min, byte max, String msg, Class<? extends RuntimeException> e) { if(Check.isInRange(b, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(short s, short min, short max) { Validate.notInRange(s, min, max, "Validate notInRange: value i is in range!"); }
	
	public static void notInRange(short s, short min, short max, String msg) { Validate.notInRange(s, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInRange(short s, short min, short max, String msg, Exceptions e) { if(Check.isInRange(s, min, max)) Exceptions.handle(e, msg); }	
	
	public static void notInRange(short s, short min, short max, String msg, Class<? extends RuntimeException> e) { if(Check.isInRange(s, min, max)) Exceptions.handle(e, msg); }	
	
	public static void notInRange(int i, int min, int max) { Validate.notInRange(i, min, max, "Validate notInRange: value i is in range!"); }
	
	public static void notInRange(int i, int min, int max, String msg) { Validate.notInRange(i, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInRange(int i, int min, int max, String msg, Exceptions e) { if(Check.isInRange(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(int i, int min, int max, String msg, Class<? extends RuntimeException> e) { if(Check.isInRange(i, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(long l, long min, long max) { Validate.notInRange(l, min, max, "Validate notInRange: value i is in range!"); }
	
	public static void notInRange(long l, long min, long max, String msg) { Validate.notInRange(l, min ,max, msg, Exceptions.IllegalArgument); }
	
	public static void notInRange(long l, long min, long max, String msg, Exceptions e) { if(Check.isInRange(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(long l, long min, long max, String msg, Class<? extends RuntimeException> e) { if(Check.isInRange(l, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(float f, float min, float max) { Validate.notInRange(f, min, max, "Validate notInRange: value i is in range!"); }
	
	public static void notInRange(float f, float min, float max, String msg) { Validate.notInRange(f, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInRange(float f, float min, float max, String msg, Exceptions e) { if(Check.isInRange(f, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(float f, float min, float max, String msg, Class<? extends RuntimeException> e) { if(Check.isInRange(f, min, max)) Exceptions.handle(e, msg); }	
	
	public static void notInRange(double d, double min, double max) { Validate.notInRange(d, min, max, "Validate notInRange: value i is in range!"); }
	
	public static void notInRange(double d, double min, double max, String msg) { Validate.notInRange(d, min, max, msg, Exceptions.IllegalArgument); }
	
	public static void notInRange(double d, double min, double max, String msg, Exceptions e) { if(Check.isInRange(d, min, max)) Exceptions.handle(e, msg); }
	
	public static void notInRange(double d, double min, double max, String msg, Class<? extends RuntimeException> e) { if(Check.isInRange(d, min, max)) Exceptions.handle(e, msg); }
	
	

	public static void notBelow(byte b, byte max) { Validate.notBelow(b, max, "Validate notBelow: value byte b is below min!"); }
	
	public static void notBelow(byte b, byte max, String msg) { Validate.notBelow(b, max, msg, Exceptions.IllegalArgument); }
	
	public static void notBelow(byte b, byte max, String msg, Exceptions e) { if(Check.isBelow(b, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(byte b, byte max, String msg, Class<? extends RuntimeException> e) { if(Check.isBelow(b, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(short s, short max) { Validate.notBelow(s, max, "Validate notBelow: value short s is below min!"); }
	
	public static void notBelow(short s, short max, String msg) { Validate.notBelow(s, max, msg, Exceptions.IllegalArgument); }
	
	public static void notBelow(short s, short max, String msg, Exceptions e) { if(Check.isBelow(s, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(short s, short max, String msg, Class<? extends RuntimeException> e) { if(Check.isBelow(s, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(int i, int max) { Validate.notBelow(i, max, "Validate notBelow: value int i is below min!"); }
	
	public static void notBelow(int i, int max, String msg) { Validate.notBelow(i, max, msg, Exceptions.IllegalArgument); }
	
	public static void notBelow(int i, int max, String msg, Exceptions e) { if(Check.isBelow(i, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(int i, int max, String msg, Class<? extends RuntimeException> e) { if(Check.isBelow(i, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(long l, long max) { Validate.notBelow(l, max, "Validate notBelow: value long l is below min!"); }
	
	public static void notBelow(long l, long max, String msg) { Validate.notBelow(l, max, msg, Exceptions.IllegalArgument); }
	
	public static void notBelow(long l, long max, String msg, Exceptions e) { if(Check.isBelow(l, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(long l, long max, String msg, Class<? extends RuntimeException> e) { if(Check.isBelow(l, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(float f, float max) { Validate.notBelow(f, max, "Validate notBelow: value float f is below min!"); }
	
	public static void notBelow(float f, float max, String msg) { Validate.notBelow(f, max, msg, Exceptions.IllegalArgument); }
	
	public static void notBelow(float f, float max, String msg, Exceptions e) { if(Check.isBelow(f, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(float f, float max, String msg, Class<? extends RuntimeException> e) { if(Check.isBelow(f, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(double d, double max) { Validate.notBelow(d, max, "Validate notBelow: value double d is below min!"); }
	
	public static void notBelow(double d, double max, String msg) { Validate.notBelow(d, max, msg, Exceptions.IllegalArgument); }
	
	public static void notBelow(double d, double max, String msg, Exceptions e) { if(Check.isBelow(d, max)) Exceptions.handle(e, msg); }
	
	public static void notBelow(double d, double max, String msg, Class<? extends RuntimeException> e) { if(Check.isBelow(d, max)) Exceptions.handle(e, msg); }
	

	
	public static void notAbove(byte b, byte min) { Validate.notAbove(b, min, "Validate notAbove: value byte b is above min!"); }
	
	public static void notAbove(byte b, byte min, String msg) { Validate.notAbove(b, min, msg, Exceptions.IllegalArgument); }
	
	public static void notAbove(byte b, byte min, String msg, Exceptions e) { if(Check.isAbove(b, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(byte b, byte min, String msg, Class<? extends RuntimeException> e) { if(Check.isAbove(b, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(short s, short min) { Validate.notAbove(s, min, "Validate notAbove: value short s is above min!"); }
	
	public static void notAbove(short s, short min, String msg) { Validate.notAbove(s, min, msg, Exceptions.IllegalArgument); }
	
	public static void notAbove(short s, short min, String msg, Exceptions e) { if(Check.isAbove(s, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(short s, short min, String msg, Class<? extends RuntimeException> e) { if(Check.isAbove(s, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(int i, int min) { Validate.notAbove(i, min, "Validate notAbove: value int i is above min!"); }
	
	public static void notAbove(int i, int min, String msg) { Validate.notAbove(i, min, msg, Exceptions.IllegalArgument); }
	
	public static void notAbove(int i, int min, String msg, Exceptions e) { if(Check.isAbove(i, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(int i, int min, String msg, Class<? extends RuntimeException> e) { if(Check.isAbove(i, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(long l, long min) { Validate.notAbove(l, min, "Validate notAbove: value long l is above min!"); }
	
	public static void notAbove(long l, long min, String msg) { Validate.notAbove(l, min, msg, Exceptions.IllegalArgument); }
	
	public static void notAbove(long l, long min, String msg, Exceptions e) { if(Check.isAbove(l, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(long l, long min, String msg, Class<? extends RuntimeException> e) { if(Check.isAbove(l, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(float f, float min) { Validate.notAbove(f, min, "Validate notAbove: value float f is above min!"); }
	
	public static void notAbove(float f, float min, String msg) { Validate.notAbove(f, min, msg, Exceptions.IllegalArgument); }
	
	public static void notAbove(float f, float min, String msg, Exceptions e) { if(Check.isAbove(f, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(float f, float min, String msg, Class<? extends RuntimeException> e) { if(Check.isAbove(f, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(double d, double min) { Validate.notAbove(d, min, "Validate notAbove: value double d is above min!"); }
	
	public static void notAbove(double d, double min, String msg) { Validate.notAbove(d, min, msg, Exceptions.IllegalArgument); }
	
	public static void notAbove(double d, double min, String msg, Exceptions e) { if(Check.isAbove(d, min)) Exceptions.handle(e, msg); }
	
	public static void notAbove(double d, double min, String msg, Class<? extends RuntimeException> e) { if(Check.isAbove(d, min)) Exceptions.handle(e, msg); }
	
	
	
	public static void notEmpty(String str) { Validate.notEmpty(str, "Validate notEmpty: string str is empty!"); }
	
	public static void notEmpty(String str, String msg) { Validate.notEmpty(str, msg, Exceptions.IllegalArgument); }
	
	public static void notEmpty(String str, String msg, Exceptions e) { if(Check.isEmpty(str)) Exceptions.handle(e, msg); }
	
	public static void notEmpty(String str, String msg, Class<? extends RuntimeException> e) { if(Check.isEmpty(str)) Exceptions.handle(e, msg); }
	
	public static void notEmpty(Object[] arg) { Validate.notEmpty(arg, "Validate notEmpty: array arg is empty!"); }
	
	public static void notEmpty(Object[] arg, String msg) { Validate.notEmpty(arg, msg, Exceptions.IllegalArgument); }
	
	public static void notEmpty(Object[] arg, String msg, Exceptions e) { if(Check.isEmpty(arg)) Exceptions.handle(e, msg); }
	
	public static void notEmpty(Object[] arg, String msg, Class<? extends RuntimeException> e) { if(Check.isEmpty(arg)) Exceptions.handle(e, msg); }
	
	public static void notEmpty(List<?> list) { Validate.notEmpty(list, "Validate notEmpty: list list is empty!"); }
	
	public static void notEmpty(List<?> list, String msg) { if(Check.isEmpty(list)) Validate.notEmpty(list, msg, Exceptions.IllegalArgument); }
	
	public static void notEmpty(List<?> list, String msg, Exceptions e) { if(Check.isEmpty(list)) Exceptions.handle(e, msg); }
	
	public static void notEmpty(List<?> list, String str, String msg, Class<? extends RuntimeException> e) { if(Check.isEmpty(list)) Exceptions.handle(e, msg); }
	
	
	
	
	
	
	public static class Check
	{
		
		public static boolean isTrue(boolean exp) { return exp; }
		
		public static boolean isFalse(boolean exp) { return !exp; }
		
		
		public static boolean isTrue(boolean... exp)
		{
			for(boolean val : exp)
				if(isFalse(val)) return false;
			
			return true;
		}
		
		public static boolean isFalse(boolean... exp)
		{
			for(boolean val : exp)
				if(isTrue(val)) return false;
			
			return true;
		}
		
		public static boolean isTrueOOO(boolean... exp)
		{
			for(boolean val : exp)
				if(isTrue(val)) return true;
			
			return false;
		}
		
		public static boolean isFalseOOO(boolean... exp)
		{
			for(boolean val : exp)
				if(isFalse(val)) return true;
			
			return false;
		}
		
		
		public static boolean isNull(Object obj) { return obj == null; }
		
		public static boolean isNull(String str) { return str == null; }
		
		public static boolean isNull(Vector2f v) { return v == null || (isNull(v.getX()) && isNull(v.getY())); }
		
		public static boolean isNull(Vector2d v) { return v == null || (isNull(v.getX()) && isNull(v.getY())); }
		
		public static boolean isNull(Vector3f v) { return v == null || (isNull(v.getX()) && isNull(v.getY()) && isNull(v.getZ())); }
		
		public static boolean isNull(Vector3d v) { return v == null || (isNull(v.getX()) && isNull(v.getY()) && isNull(v.getZ())); }
		
		public static boolean isNull(byte b) { return b == 0; }
		
		public static boolean isNull(short s) { return s == 0; }	
		
		public static boolean isNull(int i) { return i == 0; }
		
		public static boolean isNull(long l) { return l == 0; }
		
		public static boolean isNull(float f) { return f == 0.0f || f == -0.0f; }	
		
		public static boolean isNull(double d) { return d == 0.0d || d == -0.0d; }
		
		
		
		public static boolean isNull(String... str) 
		{
			for(String val : str)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(Vector2f... v) 
		{
			for(Vector2f val : v)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(Vector2d... v) 
		{
			for(Vector2d val : v)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(Vector3f... v) 
		{
			for(Vector3f val : v)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(Vector3d... v) 
		{
			for(Vector3d val : v)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(byte... b) 
		{
			for(byte val : b)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(short... s) 
		{
			for(short val : s)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(int... i) 
		{
			for(int val : i)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(long... l) 
		{
			for(long val : l)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(float... f) 
		{
			for(float val : f)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		public static boolean isNull(double... d) 
		{
			for(double val : d)
				if(Check.notNull(val)) return false;
			
			return true;
		}
		
		
		
		public static boolean isNullOOO(String... str) 
		{
			for(String val : str)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(Vector2f... v) 
		{
			for(Vector2f val : v)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(Vector2d... v) 
		{
			for(Vector2d val : v)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(Vector3f... v) 
		{
			for(Vector3f val : v)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(Vector3d... v) 
		{
			for(Vector3d val : v)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(byte... b) 
		{
			for(byte val : b)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(short... s) 
		{
			for(short val : s)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(int... i) 
		{
			for(int val : i)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(long... l) 
		{
			for(long val : l)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(float... f) 
		{
			for(float val : f)
				if(Check.isNull(val)) return true;
			
			return false;
		}
		
		public static boolean isNullOOO(double... d) 
		{
			for(double val : d)
				if(Check.isNull(val)) return true;
			
			return false;
		}

		
		
		public static boolean isInBetween(byte i, byte min, byte max) { return min < i && i < max; }
		
		public static boolean isInBetween(short i, short min, short max) { return min < i && i < max; }
		
		public static boolean isInBetween(int i, int min, int max) { return min < i && i < max; }
		
		public static boolean isInBetween(long i, long min, long max) { return min < i && i < max; }
		
		public static boolean isInBetween(float i, float min, float max) { return min < i && i < max; }	
		
		public static boolean isInBetween(double i, double min, double max) { return min < i && i < max; }
		
		
		
		public static boolean isInRange(byte i, byte min, byte max) { return min <= i && i <= max; }
		
		public static boolean isInRange(short i, short min, short max) { return min <= i && i <= max; }	
		
		public static boolean isInRange(int i, int min, int max) { return min <= i && i <= max; }
		
		public static boolean isInRange(long i, long min, long max) { return min <= i && i <= max; }
		
		public static boolean isInRange(float i, float min, float max) { return min <= i && i <= max; }	
		
		public static boolean isInRange(double i, double min, double max) { return min <= i && i <= max; }
		
		
		
		public static boolean isBelow(byte i, byte min) { return i < min;  }
		
		public static boolean isBelow(short i, short min) { return i < min; }
		
		public static boolean isBelow(int i, int min) { return i < min; }
		
		public static boolean isBelow(long i, long min) { return i < min; }
		
		public static boolean isBelow(float i, float min) { return i < min;}
		
		public static boolean isBelow(double i, double min) { return i < min; }
		
		
		
		public static boolean isAbove(byte i, byte max) { return i > max; }
		
		public static boolean isAbove(short i, short max) { return i > max; }

		public static boolean isAbove(int i, int max) { return i > max; }

		public static boolean isAbove(long i, long max) { return i >  max; }

		public static boolean isAbove(float i, float max) { return i > max; }

		public static boolean isAbove(double i, double max) { return i > max; }
		
		

		public static boolean isEmpty(String str) { return str == null || str == ""; }

		public static boolean isEmpty(Object[] arg) { return arg == null || arg.length == 0; }
		
		public static boolean isEmpty(List<?> list) { return list.size() == 0; }
		
		
		
		

		
		public static boolean notTrue(boolean expression) { return !isTrue(expression); }

		public static boolean notFalse(boolean expression) { return !isFalse(expression); }
		

		
		public static boolean notNull(Object obj) { return !isNull(obj); }

		public static boolean notNull(String str) { return !isNull(str); }
		
		public static boolean notNull(Vector2f v) { return !isNull(v); }
		
		public static boolean notNull(Vector2d v) { return !isNull(v); }
		
		public static boolean notNull(Vector3f v) { return !isNull(v); }
		
		public static boolean notNull(Vector3d v) { return !isNull(v); }

		public static boolean notNull(byte b) { return !isNull(b); }

		public static boolean notNull(short s) { return !isNull(s); }	

		public static boolean notNull(int i) { return !isNull(i); }

		public static boolean notNull(long l) { return !isNull(l); }

		public static boolean notNull(float f) { return !isNull(f); }	

		public static boolean notNull(double d) { return !isNull(d); }
		
		
		
		public static boolean notNull(String... str)
		{
			for(String val : str)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(Vector2f... v)
		{
			for(Vector2f val : v)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(Vector2d... v)
		{
			for(Vector2d val : v)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(Vector3f... v)
		{
			for(Vector3f val : v)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(Vector3d... v)
		{
			for(Vector3d val : v)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(byte... b)
		{
			for(byte val : b)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(short... s)
		{
			for(short val : s)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(int... i)
		{
			for(int val : i)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(long... l)
		{
			for(long val : l)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(float... f)
		{
			for(float val : f)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNull(double... d)
		{
			for(double val : d)
				if(Check.isNull(val)) return false;
			
			return true;
		}
		
		public static boolean notNullOOO(String... str)
		{
			for(String val : str)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(Vector2f... v)
		{
			for(Vector2f val : v)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(Vector2d... v)
		{
			for(Vector2d val : v)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(Vector3f... v)
		{
			for(Vector3f val : v)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(Vector3d... v)
		{
			for(Vector3d val : v)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(byte... b)
		{
			for(byte val : b)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(short... s)
		{
			for(short val : s)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(int... i)
		{
			for(int val : i)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(long... l)
		{
			for(long val : l)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(float... f)
		{
			for(float val : f)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		public static boolean notNullOOO(double... d)
		{
			for(double val : d)
				if(Check.notNull(val)) return true;
			
			return false;
		}
		
		

		public static boolean notInBetween(byte b, byte min, byte max) { return !isInBetween(b, min, max); }

		public static boolean notInBetween(short s, short min, short max) { return !isInBetween(s, min, max); }	

		public static boolean notInBetween(int i, int min, int max) { return !isInBetween(i, min, max); }

		public static boolean notInBetween(long l, long min, long max) { return !isInBetween(l, min, max); }

		public static boolean notInBetween(float f, float min, float max) { return !isInBetween(f, min, max); }	

		public static boolean notInBetween(double d, double min, double max) { return !isInBetween(d, min, max); }
		
		

		public static boolean notInRange(byte b, byte min, byte max) { return !isInRange(b, min, max); }

		public static boolean notInRange(short s, short min, short max) { return !isInRange(s, min, max); }	

		public static boolean notInRange(int i, int min, int max) { return !isInRange(i, min, max); }

		public static boolean notInRange(long l, long min, long max) { return !isInRange(l, min, max); }

		public static boolean notInRange(float f, float min, float max) { return !isInRange(f, min, max); }	

		public static boolean notInRange(double d, double min, double max) { return !isInRange(d, min, max); }
		
		

		public static boolean notBelow(byte b, byte min) { return !isBelow(b, min); }

		public static boolean notBelow(short s, short min) { return !isBelow(s, min); }

		public static boolean notBelow(int i, int min) { return !isBelow(i, min); }

		public static boolean notBelow(long l, long min) { return !isBelow(l, min); }

		public static boolean notBelow(float f, float min) { return !isBelow(f, min); }

		public static boolean notBelow(double d, double min) { return !isBelow(d, min); }
		
		

		public static boolean notAbove(byte b, byte max) { return !isAbove(b, max); }

		public static boolean notAbove(short s, short max) { return !isAbove(s, max); }

		public static boolean notAbove(int i, int max) { return !isAbove(i, max); }

		public static boolean notAbove(long l, long max) { return !isAbove(l, max); }

		public static boolean notAbove(float f, float max) { return !isAbove(f, max); }

		public static boolean notAbove(double d, double max) { return !isAbove(d, max); }
		
		

		public static boolean notEmpty(String str) { return !isEmpty(str); }

		public static boolean notEmpty(Object[] arg) { return !isEmpty(arg); }
		
		public static boolean notEmpty(List<?> list) { return !isEmpty(list); }
		
	}
	
}
