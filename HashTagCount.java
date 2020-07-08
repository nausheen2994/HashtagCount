package com.test.main;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashTagCount {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		String str = scan.nextLine();
		String[] splitedInput = str.split("\\s+");
		int countTopTen = 0;

		for (String s : splitedInput) {
			char[] ch = s.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == '#') {
					String str1 = s.replace("#", "");
					if (map.get(str1) == null) {
						map.put(str1, 1);

					} else
						map.put(str1, map.get(str1) + 1);
					break;
				}
			}
		}

		Map<String, Integer> result = sortMap(map);
			for (Map.Entry<String, Integer> mp : result.entrySet()) {
				if (countTopTen< 11) {

				System.out.println(mp.getKey());
				countTopTen++;
              
			}
		}
	}

	public static LinkedHashMap<String, Integer> sortMap(LinkedHashMap<String, Integer> hashmap) {
		List<Map.Entry<String, Integer>> capitalList = new LinkedList<>(hashmap.entrySet());

		Collections.sort(capitalList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : capitalList) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

}
