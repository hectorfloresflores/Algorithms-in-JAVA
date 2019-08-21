package com.hectorflores;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContainsDuplicateII {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, LinkedList<Integer>> map = containsDuplicate(nums);
		if (map == null) {
			return false;
		}

		for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {

			if (entry.getValue().size() > 1) {

				for (int i = 0; i < (entry.getValue().size() - 1); i++) {

					if ((entry.getValue().get(i + 1) - entry.getValue().get(i)) <= k) {

						return true;

					}

				}

			}

		}

		return false;
	}

	public static HashMap<Integer, LinkedList<Integer>> containsDuplicate(int[] nums) {

		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
		boolean bole = false;
		LinkedList<Integer> list;
		for (int a = 0; a < nums.length; a++) {

			list = map.get(nums[a]);

			if (list == null) {
				list = new LinkedList<>();
				list.add(a);
				map.put(nums[a], list);
			} else {
				bole = true;
				map.get(nums[a]).add(a);
			}

		}

		if (bole == false) {
			return null;
		} else {
			return map;
		}

	}

	public static void main(String[] args) {
		int[] array = {1,2,3,1};
System.out.println(containsNearbyDuplicate(array, 3));

	}

}
