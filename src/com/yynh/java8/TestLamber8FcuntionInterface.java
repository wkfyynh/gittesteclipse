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
 * java8 内置的四大核心函数式接口
 * @author wangkefeng
 *
 * Consumer<T> :消费性接口
 * 		void accept(T t);
 * 
 * Supplier<T> ：供给型接口
 * 		T get();
 * 
 * Fuction<T,R> : 函数型接口
 * 		 R apply(T t);
 * 
 * Predicate<T> ：断言型接口
 * 		boolean test(T t):
 * 
 *
 */
public class TestLamber8FcuntionInterface {
	//Predicate<T> 断言型接口
	@Test
	public void test4(){
		List<String> ad = Arrays.asList("hello","dfjlsd","budongnide ","22");
		List<String> filterStr = filterStr(ad, x -> x.length()>3);
		for (String string : filterStr) {
			System.out.println(string);
		}
	}
	
	//将满足条件的字符串放入集合中去
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
	
	//Function<T,R> 函数型接口
	@Test 
	public void test3(){
		String s = strHandler("\t\t\t 上杉达也", x -> {
			System.out.println(x);
			return x.trim();
		});
		System.out.println(s);
		
		String ss = strHandler("浅仓南", x -> x.substring(1, 2));
		System.out.println(ss);
	}
	
	//用语处理字符串
	public String strHandler(String str,Function<String,String> fun){
		return fun.apply(str);
	}
	
	//Supplier<T> 供给型接口：
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() *100));
		for (Integer integer : numList) {
			System.out.println("数据输出"+integer);
		}
	}
	//产生一些整数放入集合中
	public List<Integer> getNumList(int num,Supplier<Integer> sup){
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0;i<num;i++) {
			list.add(sup.get());
		}
		return list;
	}
	
	//Consumer<T> 消费型接口
	@Test
	public void test1(){
		happy(10000, m -> System.out.println("touch"+m));
	}
	
	public void happy(double money, Consumer<Double> con){
		con.accept(money);
	}
}
