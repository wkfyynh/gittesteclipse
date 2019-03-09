package com.yynh.java8;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * @author wangkefeng
 * 方法引用：若 lambda体中的内容有方法已经实现了，我们可以使用方法引用（可以理解为方法引用是lambda表达式的另外一种表现形式）
 * 主要有三种语法格式：
 * 
 * 对象::实例方法名
 * 
 * 类::静态方法名
 * 
 * 类::实例方法名
 * 
 * 注意：
 *  lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致\
 *  若lambda参数列表中的第一个参数是实例方法的的引用者，第二个参数是实例方法的参数时，可以使用ClassName::method
 *  
 * 
 * 构造器引用：
 * 	格式：
 * ClassName::new
 * 主要：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * 
 * 
 * 数组引用：
 * 格式：
 * Type::new
 */
public class TestMethodRef {
	//数组引用
	@Test
	public void test7(){
		Function<Integer,String[]> f=(x) -> new String[x];
		String[] s = f.apply(2);
		System.out.println(s.length);
		Function<Integer,String[]> f2=String[]::new;
		System.out.println(f2.apply(20).length);
		
	}
	
	
	//构造器引用
	@Test
	public void test5(){
		Supplier<Employee> s= () -> new Employee();
		Supplier<Employee> s2= Employee::new;
		
	}
	
	@Test
	public void tese6(){
		Function<String,Employee> f=(x) -> new Employee(x);
		Function<String,Employee> f1=Employee::new;
		System.out.println(f1.apply("王克锋"));
		
	}
	
	
	//类::实例方法名
	@Test
	public void test4(){
		BiPredicate<String, String> bi = (x,y) -> x.equals(y);
		BiPredicate<String, String> bi2 = String::equals;
		
	}
	
	//类::静态方法名
	@Test
	public void test3(){
		Comparator<Integer> com=(x,y) -> Integer.compare(x,y);
		Comparator<Integer> com1=Integer::compare;
		
	}
	
	//对象::实例方法名
	@Test
	public void Test1(){
		Consumer<String> con=x -> System.out.println(x);
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		con1.accept("杏花");
		Consumer<String> con2= System.out::println;
	}
	
	@Test
	public void test2(){
		Employee emp = new Employee();
		Supplier<String> sup=() -> emp.getName();
		System.out.println(sup.get());
		
		Supplier<Integer> sup2 = emp::getAge;
		System.out.println(sup2.get());
	}
}
