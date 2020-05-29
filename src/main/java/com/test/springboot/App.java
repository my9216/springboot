package com.test.springboot;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String str = "测试一下哪个效率高测试一下哪个效率高测试一下哪个效率高测试一下哪个效率高测试一下哪个效率高";
		long start = System.nanoTime();
		int indexOf = str.indexOf("测试一下哪个效率高测试一下哪个效率高测试一下哪个效率高测");
		long end = System.nanoTime();
		System.out.println(end - start);
		start = System.nanoTime();
		str.contains("测试一下哪个效率高测试一下哪个效率高测试一下哪个效率高测");
		end = System.nanoTime();
		System.out.println(end - start);
		start = System.nanoTime();
		str.startsWith("高");
		end = System.nanoTime();
		System.out.println(end - start);
	}
}
