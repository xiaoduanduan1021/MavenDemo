package com.demo.test;

import java.util.Date;

import org.junit.Test;

public class test {

	/**
	 * junit测试
	 * @param args
	 */
	public static void main(String[] args) {

		long s = new Date().getTime();
				
		for (int i = 0; i < 100000; i++) {
			System.out.println(i);
		}
		long e = new Date().getTime();
		System.out.println(e-s);
	}

	
	@Test
	public void test2(){
		
		System.out.println("junit测试");
	}
	
	
}
