package com.yynh.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * lambda表达式基础语法 
 * @author wangkefeng
 * -> 箭头操作符将lambda分为两部分
 * 左侧：表达式的参数列表
 * 右侧：表达式中需要执行的功能，即lambda体
 * 
 * 语法格式一：无参数无返回值
 * 		() -> System.out.println("hello");
 * 
 * 语法格式二：有一个参数，并且无返回值
 * 
 * 语法格式三：若只有一个参数，小括号可以不写
 * 
 * 语法格式四：有两个以上的参数，并且lambda体中有多条语句
 * 	Comparator<Integer> com=(x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		
 * 语法格式五：若lambda体中只有一条语句，return和大括号都可以省略不写
 * 
 * 语法格式六：lambda表达式的参数列表的数据类型可以省略不写，因为jvm编译器可以通过上下文推断出数据类型，即”类型推断“
 * 
 * 左右遇一括号省
 * 左侧推断类型省
 * 
 * 
 * 二：lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以通过使用注解@FunctionInterface 修饰
 * 可以检查是否是函数式接口
 */
public class TestLambda {
	@Test
	public void test1() throws InterruptedException{
		int num = 0;//jdk1.7以前必须是final		
		Runnable r = new Runnable(){
			@Override
			public void run() {
				System.out.println("hello world" + num);
			}
			
		};
		r.run();
		Thread.sleep(2000);
		System.out.println("--------------------------------");
		Runnable r1 = () -> System.out.println("lambda"); 
		r1.run();
	}
	
	@Test
	public void Test2(){
		Consumer<String> c = x -> System.out.println(x);
		c.accept("一个参数，无返回值");
	}
	
	@Test
	public void Test3(){
		Comparator<Integer> com=(x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
	}
	
	@Test
	public void Test4(){
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
	}
	
	@Test
	public void Test5(){
		//jdk1.8 不需要指定泛型中的类型
		show(new HashMap<>());
	}
	
	public void show(Map<String,Integer> map){
	
	}
	
//	需求：对一个数进行运算
	@Test 
	public void Test6(){
		Integer i = operation(100, x -> x*x);
		System.out.println(i);
	}
	
	public Integer operation(Integer num, MyFun mf){
		return mf.getValue(num);
	}
}
