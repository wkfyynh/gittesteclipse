package com.yynh.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestLambda2 {
	List<Employee> emps = Arrays.asList(
			new Employee("����",18,9999.99),
			new Employee("����",59,5599.99),
			new Employee("����",55,8899.99),
			new Employee("����",45,3399.99),
			new Employee("����",8,7799.99)
			);
	@Test
	public void test1(){
		Collections.sort(emps, (x,y) -> {
			if(x.getAge() == y.getAge()){
				return x.getName().compareTo(y.getName());
			}else{
				return Integer.compare(x.getAge(), y.getAge());
			}
		});
		
		for (Employee e : emps) {
			System.out.println(e);
			
		}
	}
	
	@Test
	public void test2(){
		String strHandler = strHandler("\t\t\t ��ɼ��Ҳ��ǳ����", x -> x.trim());
		System.out.println(strHandler);
	}
	
	@Test
	public void test3(){
		op(100L, 200L, (x,y) -> x*y);
	}
	
	//�����ַ���
	//�������ģʽ
	public String strHandler(String str,MyFunciotn mf){
		return mf.getValue(str);
	}
	
	//������long�������ݽ��д���
	public void op(Long l1,Long l2,MyFuncion2<Long,Long> mf)
	{
		System.out.println(mf.getValue(l1, l2));
	}
}
