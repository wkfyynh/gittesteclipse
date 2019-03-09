package com.yynh.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;
/**
 * java8 ���õ��Ĵ���ĺ���ʽ�ӿ�
 * @author wangkefeng
 *
 * Consumer<T> :�����Խӿ�
 * 		void accept(T t);
 * 
 * Supplier<T> �������ͽӿ�
 * 		T get();
 * 
 * Fuction<T,R> : �����ͽӿ�
 * 		 R apply(T t);
 * 
 * Predicate<T> �������ͽӿ�
 * 		boolean test(T t):
 * 
 *
 */
public class TestLamber8FcuntionInterface {
	//Predicate<T> �����ͽӿ�
	@Test
	public void test4(){
		List<String> ad = Arrays.asList("hello","dfjlsd","budongnide ","22");
		List<String> filterStr = filterStr(ad, x -> x.length()>3);
		for (String string : filterStr) {
			System.out.println(string);
		}
	}
	
	//�������������ַ������뼯����ȥ
	public List<String> filterStr(List<String> list,Predicate<String> pre){
		ArrayList<String> sl = new ArrayList<>();
		for (String s : list) {
			if(pre.test(s))
			{
				sl.add(s);
			}
		}
		return sl;
	}
	
	//Function<T,R> �����ͽӿ�
	@Test 
	public void test3(){
		String s = strHandler("\t\t\t ��ɼ��Ҳ", x -> {
			System.out.println(x);
			return x.trim();
		});
		System.out.println(s);
		
		String ss = strHandler("ǳ����", x -> x.substring(1, 2));
		System.out.println(ss);
	}
	
	//���ﴦ���ַ���
	public String strHandler(String str,Function<String,String> fun){
		return fun.apply(str);
	}
	
	//Supplier<T> �����ͽӿڣ�
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() *100));
		for (Integer integer : numList) {
			System.out.println("�������"+integer);
		}
	}
	//����һЩ�������뼯����
	public List<Integer> getNumList(int num,Supplier<Integer> sup){
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0;i<num;i++) {
			list.add(sup.get());
		}
		return list;
	}
	
	//Consumer<T> �����ͽӿ�
	@Test
	public void test1(){
		happy(10000, m -> System.out.println("touch"+m));
	}
	
	public void happy(double money, Consumer<Double> con){
		con.accept(money);
	}
}
