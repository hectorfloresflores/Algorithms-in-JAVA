package com.hectorflores;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

class Interval {
	int left;

	@Override
	public String toString() {
		return "Interval [left=" + left + ", right=" + right + "]";
	}

	int right;

	public Interval(int left, int right) {
		this.left = left;
		this.right = right;
	}

}

public class MergeIntervals {

	public static int[][] mergeIntervals(int[][] intervals) {

		if (intervals.length <= 1) {
			return intervals;
		}
		sort(intervals);
		LinkedList<Interval> list = new LinkedList<>();

		for (int i = 0, j = 1; j < intervals.length;) {

			
			
			if (intervals[i][1] < intervals[j][1] && intervals[i][1] < intervals[j][0]) {
				// No se cruzaron

				list.add(new Interval(intervals[i][0], intervals[i][1]));
				if (j == intervals.length-1) {
					list.add(new Interval(intervals[j][0], intervals[j][1]));
				}
				intervals[j - 1][0] = intervals[i][0];
				intervals[j - 1][1] = intervals[i][1];

				j++;
				i = j - 1;

			} else {
				if (intervals[j][1] > intervals[i][1]) {
					intervals[i][1] = intervals[j][1];
				}
				if (j == intervals.length-1) {
					list.add(new Interval(intervals[i][0], Math.max(intervals[j][1], intervals[i][1])));
				}
				j++;
			}

			
		}

		int[][] myarray = new int[list.size()][2];
		int counter = 0;
		for(Interval i : list) {
			myarray[counter][0] = i.left;
			myarray[counter][1] = i.right;
			counter++;
		}
		return myarray;

	}

	private static void sort(int[][] intervals) {

		Map<Integer, LinkedList<Interval>> map = new TreeMap<>();
		LinkedList<Interval> list;
		for (int i = 0; i < intervals.length; i++) {

			if (map.containsKey(intervals[i][0])) {

				map.get(intervals[i][0]).add(new Interval(intervals[i][0], intervals[i][1]));

			} else {
				list = new LinkedList<>();
				list.add(new Interval(intervals[i][0], intervals[i][1]));
				map.put(intervals[i][0], list);

			}

		}

		int counter = 0;

		for (Map.Entry<Integer, LinkedList<Interval>> entry : map.entrySet()) {

			for (Interval i : entry.getValue()) {
				intervals[counter][0] = i.left;
				intervals[counter][1] = i.right;
				counter++;
			}

		}

	}

	public static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i][0]);
			System.out.println(matrix[i][1]);
		}

	}

	public static void main(String[] args) {
		int[][] array = { { 1,9} };
		printMatrix(MergeIntervals.mergeIntervals(array));
	}

}
