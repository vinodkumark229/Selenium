package com.herokuapp.tests;

import org.testng.annotations.Test;

public class Test2 {
		@Test
		public void test() throws ArithmeticException {
			System.out.println("Thread Id is : "+Thread.currentThread().getId());
			int num = 100/10;
			System.out.println("IN test method");
		}
		
		public void test2() {
			test();
			System.out.println("");
		}
	}
