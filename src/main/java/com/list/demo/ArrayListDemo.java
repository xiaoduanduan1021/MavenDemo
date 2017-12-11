package com.list.demo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ArrayListDemo {

	/**
	 * 测试arraylist中间插入数据
	 * 
	 */
	@Test
	public void test1(){
		ArrayList<Integer> arrayList = new  ArrayList<Integer>();
		
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		
		arrayList.add(1, 5);
		
		for (Integer i : arrayList) {
			System.out.println(i);
		}
	}
	
	
	/**
	 * arraylist性能测试
	 */
	@Test
	public void test2(){
		System.out.println("ArrayList开始初始化");
		for (int i = 0; i < 1000000; i++) {
			l1.add("1234567890");
		}
		System.out.println(l1.size());
		System.out.println("ArrayList初始化完毕");
	}
	/**
	 * linkedlist性能测试
	 */
	@Test
	public void test3(){
		System.out.println("LinkedList开始初始化");
		for (int i = 0; i < 1000000; i++) {
			l2.add("1234567890");
		}
		System.out.println(l2.size());
		System.out.println("LinkedList初始化完毕");
	}
	
 	public static List<String> l1 = new ArrayList<String>();
 	public static List<String> l2 = new LinkedList<String>();
	
	static{
		new ArrayListDemo().test2();
		new ArrayListDemo().test3();
	}
	
	/**
	 * arraylist插入性能测试
	 */
	@Test
	public void test4(){
		System.out.println("ArrayList开始插入");
		for (int i = 0; i < 10000; i++) {
			l1.add(1, "1234567890");
		}
		System.out.println(l1.size());
		System.out.println("ArrayList插入完毕");
	}
	/**
	 * linkedlist插入性能测试
	 */
	@Test
	public void test5(){
		System.out.println("LinkedList开始插入");
		for (int i = 0; i < 10000; i++) {
			l2.add(1, "1234567890");
		}
		
		System.out.println(l2.size());
		System.out.println("LinkedList插入完毕");
	}
	/**
	 * arraylist修改性能测试
	 */
	@Test
	public void test6(){
		System.out.println("ArrayList开始修改");
		for (int i = 0; i < 10000; i++) {
			l1.get(500000);
		}
		System.out.println(l1.size());
		System.out.println("ArrayList修改完毕");
	}
	/**
	 * linkedlist修改性能测试
	 */
	@Test
	public void test7(){
		System.out.println("LinkedList开始修改");
		for (int i = 0; i < 10000; i++) {
			l2.get(500000);
		}
		
		System.out.println(l2.size());
		System.out.println("LinkedList修改完毕");
	}
	
	/**
	 * 笔记
	 * 添加到最后性能ArrayList快很多
	 * 插入到其中linkedlist快很多
	 * 查询Arraylist快
	 * 修改Arraylist快，因为修改前得找到他
	 */
}
