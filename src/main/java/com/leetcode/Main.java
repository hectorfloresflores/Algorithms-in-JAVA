package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String text = br.readLine();

		String lineN = br.readLine();
		int N = Integer.parseInt(lineN);
		String matches = br.readLine();

		StringBuilder sb = new StringBuilder();

		HashMap<String, Boolean> map = new HashMap<>();

		for (String match : matches.split(" ")) {
			map.put(match, true);
		}

		for (String word : text.split(" ")) {

			if (map.containsKey(word)) {
					sb.append("/*");
					sb.append(word);
					sb.append("*/");

			}else {
				sb.append(word);
			}

			sb.append(" ");
		}

		System.out.println(sb.toString());
	}

}
