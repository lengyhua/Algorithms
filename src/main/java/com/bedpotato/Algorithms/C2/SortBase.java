package com.bedpotato.Algorithms.C2;

import java.util.Arrays;
import java.util.Random;

import com.bedpotato.alg4.Stopwatch;

@SuppressWarnings("rawtypes")
public abstract class SortBase {
	public static final String INSERTION_SORT = "insertionSort";
	public static final String SELECTION_SORT = "selectionSort";
	public static final String SHELL_SORT = "shellSort";
	public static final String MERGE_SORT = "mergeSort";
	public static final String QUICK_SORT = "quickSort";
	public static final String HEAP_SORT = "heapSort";

	// 排序算法
	static String method = SHELL_SORT;
	// 排序数组长度
	static int length = 7;

	public static void main(String[] args) {
		// 生成随机数
		// Double[] randomNumbers = new Double[length];
		// for (int i = 0; i < length; i++) {
		// randomNumbers[i] = Math.random();
		// }
		Integer[] randomNumbers = new Integer[length];
		for (int i = 0; i < length; i++) {
			randomNumbers[i] = new Random().nextInt(100);
		}
		// sortTest(INSERTION_SORT, randomNumbers);
		// sortTest(SELECTION_SORT, randomNumbers);
		sortTest(SHELL_SORT, randomNumbers);
	}

	public static void sortTest(String method, final Comparable[] randomNumbers) {
		Stopwatch timer = new Stopwatch();
		SortBase sort = null;
		if (method.equals(INSERTION_SORT)) {
			sort = new InsertionSort();
		} else if (method.equals(SELECTION_SORT)) {
			sort = new SelectionSort();
		} else if (method.equals(SHELL_SORT)) {
			sort = new ShellSort();
		}
		sort.sort(Arrays.copyOf(randomNumbers, length));
		System.out.println(timer.elapsedTime());
		// test practise
		Comparable[] testData = Arrays.copyOf(randomNumbers, length);
		sort.practise(testData);
		System.out.println(method + " Test Method Result:" + isSorted(testData));
	}

	public abstract void sort(Comparable[] a);

	public abstract void practise(Comparable[] a);

	@SuppressWarnings("unchecked")
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable p = a[i];
		a[i] = a[j];
		a[j] = p;
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
	}

	public static boolean isSorted(Comparable[] a) {
		if (a == null) {
			return false;
		}
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void print(Comparable[] a) {
		StringBuilder sb = new StringBuilder();
		for(Comparable ele : a){
			sb.append(ele.toString()).append(" ");
		}
		System.out.println(sb.toString());
	}
}
