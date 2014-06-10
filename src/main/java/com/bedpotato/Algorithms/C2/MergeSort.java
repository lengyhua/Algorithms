package com.bedpotato.Algorithms.C2;


@SuppressWarnings("rawtypes")
public class MergeSort extends SortBase {
	private static Comparable[] aux;// 归并所需的辅助数组

	@Override
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// 将数组a[lo...hi]排序
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// 将a[lo...mid]和a[mid+1..hi]归并
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {// 左半边用尽
				a[k] = aux[j++];
			} else if (j > hi) {// 右半边用尽
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	@Override
	public void practise(Comparable[] a) {
		// TODO Auto-generated method stub

	}
}
