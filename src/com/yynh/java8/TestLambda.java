package com.yynh.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * lambda���ʽ�����﷨ 
 * @author wangkefeng
 * -> ��ͷ��������lambda��Ϊ������
 * ��ࣺ���ʽ�Ĳ����б�
 * �Ҳࣺ���ʽ����Ҫִ�еĹ��ܣ���lambda��
 * 
 * �﷨��ʽһ���޲����޷���ֵ
 * 		() -> System.out.println("hello");
 * 
 * �﷨��ʽ������һ�������������޷���ֵ
 * 
 * �﷨��ʽ������ֻ��һ��������С���ſ��Բ�д
 * 
 * �﷨��ʽ�ģ����������ϵĲ���������lambda�����ж������
 * 	Comparator<Integer> com=(x,y) -> {
			System.out.println("����ʽ�ӿ�");
			return Integer.compare(x, y);
		};
		
 * �﷨��ʽ�壺��lambda����ֻ��һ����䣬return�ʹ����Ŷ�����ʡ�Բ�д
 * 
 * �﷨��ʽ����lambda���ʽ�Ĳ����б���������Ϳ���ʡ�Բ�д����Ϊjvm����������ͨ���������ƶϳ��������ͣ����������ƶϡ�
 * 
 * ������һ����ʡ
 * ����ƶ�����ʡ
 * 
 * 
 * ����lambda���ʽ��Ҫ������ʽ�ӿڡ���֧��
 * ����ʽ�ӿڣ��ӿ���ֻ��һ�����󷽷��Ľӿڣ���Ϊ����ʽ�ӿڣ�����ͨ��ʹ��ע��@FunctionInterface ����
 * ���Լ���Ƿ��Ǻ���ʽ�ӿ�
 */
public class TestLambda {
	@Test
	public void test1() throws InterruptedException{
		int num = 0;//jdk1.7��ǰ������final		
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
		c.accept("һ���������޷���ֵ");
	}
	
	@Test
	public void Test3(){
		Comparator<Integer> com=(x,y) -> {
			System.out.println("����ʽ�ӿ�");
			return Integer.compare(x, y);
		};
	}
	
	@Test
	public void Test4(){
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
	}
	
	@Test
	public void Test5(){
		//jdk1.8 ����Ҫָ�������е�����
		show(new HashMap<>());
	}
	
	public void show(Map<String,Integer> map){
	
	}
	
//	���󣺶�һ������������
	@Test 
	public void Test6(){
		Integer i = operation(100, x -> x*x);
		System.out.println(i);
	}
	
	public Integer operation(Integer num, MyFun mf){
		return mf.getValue(num);
	}
}
