package com.leetcode;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
class A {
	public A() {
		System.out.println("I am A");
	}
}
class B extends A{
	public B() {
		System.out.println("I am B");
	}
	}
class C extends B {
	public C() {
		super();
		System.out.println("I am C");
	}
}
public class Main {



	public static void main(String[] args) throws IOException {
		C c = new C();
		int[] a = { 1, 2, 3, 4 };
		int[] b = { 2, 3, 1, 0 };
		System.out.println( a [ (a = b)[3] ] );
		String test = "hola";
		test.compareTo("te");
		System.out.println(test.substring(0,4));

	}

}
