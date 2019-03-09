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
 * �������ã��� lambda���е������з����Ѿ�ʵ���ˣ����ǿ���ʹ�÷������ã��������Ϊ����������lambda���ʽ������һ�ֱ�����ʽ��
 * ��Ҫ�������﷨��ʽ��
 * 
 * ����::ʵ��������
 * 
 * ��::��̬������
 * 
 * ��::ʵ��������
 * 
 * ע�⣺
 *  lambda ���е��÷����Ĳ����б��뷵��ֵ���ͣ�Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ��\
 *  ��lambda�����б��еĵ�һ��������ʵ�������ĵ������ߣ��ڶ���������ʵ�������Ĳ���ʱ������ʹ��ClassName::method
 *  
 * 
 * ���������ã�
 * 	��ʽ��
 * ClassName::new
 * ��Ҫ����Ҫ���õĹ������Ĳ����б�Ҫ�뺯��ʽ�ӿ��г��󷽷��Ĳ����б���һ��
 * 
 * 
 * �������ã�
 * ��ʽ��
 * Type::new
 */
public class TestMethodRef {
	//��������
	@Test
	public void test7(){
		Function<Integer,String[]> f=(x) -> new String[x];
		String[] s = f.apply(2);
		System.out.println(s.length);
		Function<Integer,String[]> f2=String[]::new;
		System.out.println(f2.apply(20).length);
		
	}
	
	
	//����������
	@Test
	public void test5(){
		Supplier<Employee> s= () -> new Employee();
		Supplier<Employee> s2= Employee::new;
		
	}
	
	@Test
	public void tese6(){
		Function<String,Employee> f=(x) -> new Employee(x);
		Function<String,Employee> f1=Employee::new;
		System.out.println(f1.apply("���˷�"));
		
	}
	
	
	//��::ʵ��������
	@Test
	public void test4(){
		BiPredicate<String, String> bi = (x,y) -> x.equals(y);
		BiPredicate<String, String> bi2 = String::equals;
		
	}
	
	//��::��̬������
	@Test
	public void test3(){
		Comparator<Integer> com=(x,y) -> Integer.compare(x,y);
		Comparator<Integer> com1=Integer::compare;
		
	}
	
	//����::ʵ��������
	@Test
	public void Test1(){
		Consumer<String> con=x -> System.out.println(x);
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		con1.accept("�ӻ�");
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
