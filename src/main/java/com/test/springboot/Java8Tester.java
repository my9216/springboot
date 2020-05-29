package com.test.springboot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Java8Tester {
	public static void main(String[] args) {
//		Java8Tester java8tester = new Java8Tester();
//		java8tester.testLocalDateTime();
//
//		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//
//		System.out.println("使用 Java 8: ");
//		System.out.println("列表: " + strings);
//
//		long count = strings.stream().filter(string -> string.isEmpty()).count();
//		System.out.println("空字符串数量为: " + count);
//
//		count = strings.stream().filter(string -> string.length() == 3).count();
//		System.out.println("字符串长度为 3 的数量为: " + count);
//
//		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//		System.out.println("筛选后的列表: " + filtered);
//
//		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
//		System.out.println("合并字符串: " + mergedString);
//
//		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
//
//		System.out.println("Squares List: " + squaresList);
//		System.out.println("列表: " + integers);
//
//		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
//
//		System.out.println("列表中最大的数 : " + stats.getMax());
//		System.out.println("列表中最小的数 : " + stats.getMin());
//		System.out.println("所有数之和 : " + stats.getSum());
//		System.out.println("平均数 : " + stats.getAverage());
//		System.out.println("随机数: ");
//
//		Random random = new Random();
//		random.ints().limit(10).sorted().forEach(System.out::println);
//
//		// 并行处理
//		count = strings.parallelStream().filter(string -> string.isEmpty()).count();
//		System.out.println("空字符串的数量为: " + count);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("str", "this is str");
		List<String> list = new ArrayList<String>();
		list.add("1111");
		list.add("2222");
		map.put("strlist", list);
		JSONObject json = JSON.parseObject(JSON.toJSONString(map));
		System.out.println(json);
		System.out.println(json.get("str"));
		//Collectors.
		List<String> list2 = json.getJSONArray("strlist").toJavaList(String.class);
		System.out.println(list2);
		
	}

	public void testLocalDateTime() {

		// 获取当前的日期时间
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("当前时间: " + currentTime);

		//currentTime.plusDays(1);
		System.out.println("一天后 " + currentTime.plusDays(1));
		
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();

		System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);

		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);

		// 22 小时 15 分钟
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);

		// 解析字符串
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
	}
}
