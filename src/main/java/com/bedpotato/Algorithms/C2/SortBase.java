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
	static int length = 10;

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

		sortTest(INSERTION_SORT, Arrays.copyOf(randomNumbers, length));
		// sortTest(SELECTION_SORT, Arrays.copyOf(randomNumbers, length));
		// sortTest(SHELL_SORT, Arrays.copyOf(randomNumbers, length));
	}

	public static void sortTest(String method, Comparable[] randomNumbers) {
		Stopwatch timer = new Stopwatch();
		SortBase sort = null;
		if (method.equals(INSERTION_SORT)) {
			sort = new InsertionSort();
		} else if (method.equals(SELECTION_SORT)) {
			sort = new SelectionSort();
		} else if (method.equals(SHELL_SORT)) {
			sort = new ShellSort();
		}
		sort.sort(randomNumbers);
		sort.show(randomNumbers);
		System.out.println(timer.elapsedTime());
	}

	public abstract void sort(Comparable[] a);

	@SuppressWarnings("unchecked")
	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public void exch(Comparable[] a, int i, int j) {
		Comparable p = a[i];
		a[i] = a[j];
		a[j] = p;
	}

	public void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].toString());
		}
	}

	public boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
