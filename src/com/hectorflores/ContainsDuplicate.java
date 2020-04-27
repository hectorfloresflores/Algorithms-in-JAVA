package com.hectorflores;

import java.util.HashMap;

public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int a : nums) {

			Integer i = map.get(a);

			if (i == null) {
				map.put(a, 1);
			} else {
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,5};
		System.out.println(containsDuplicate(array));

	}

}
