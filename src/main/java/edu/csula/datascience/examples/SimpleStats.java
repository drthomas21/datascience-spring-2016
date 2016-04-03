package edu.csula.datascience.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * A simple math statistics programming exercise
 */
public class SimpleStats {
	private final List<Integer> data;
	public SimpleStats(List<Integer> data) {
		this.data = data;
	}

	/**
	 * Sum of entire list of numbers
	 */
	public int sum() {
		int sum = 0;
		for(Integer num : data) {
			sum += num;
		}
		return sum;
	}

	/**
	 * Average of the numbers
	 */
	public double mean() {
		return this.sum()/data.size();
	}

	/**
	 * Sort the numbers, median is the middle value of the sorted list
	 */
	public int median() {
		ArrayList<Integer> sortedList = new ArrayList<>();
		sortedList.addAll(data);
		Collections.sort(sortedList);
		if(sortedList.size() % 2 == 1) {
			int index = (sortedList.size() / 2) + 1;
			return sortedList.get(index);
		} else {
			int index = sortedList.size() / 2;
			return (sortedList.get(index) + sortedList.get(index + 1)) / 2;
		}       
	}

	/**
	 * The value of max minus min
	 */
	public int range() {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(Integer num : data) {
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
		}
		return max-min;
	}

	/**
	 * The number that repeats the most in the numbers
	 */
	public int mode() {
		HashMap<Integer,Integer> map = new HashMap<>();
		Integer index = 0;
		int max = Integer.MIN_VALUE;
		for(Integer num : data) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num,1);
			}
		}

		for(Integer key : map.keySet()){
			if(map.get(key) > max) {
				index = key;
				max = map.get(key);
			}
		}
		return index;
	}

	/**
	 * Maximum number of the numbers
	 */
	public int max() {
		int max = Integer.MIN_VALUE;
		for(Integer num : data) {
			if(num > max) {
				max = num;
			}
		}
		return max;
	}

	/**
	 * Minimum number of the numbers
	 */
	public int min() {
		int min = Integer.MAX_VALUE;
		for(Integer num : data) {
			if(num < min) {
				min = num;
			}
		}
		return min;
	}
}
