package com.bedpotato.Algorithms.C2;

public class InsertionWith extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		int length = a.length;
		for (int i = 2; i < length; i++) {
			System.out.println("arr[0]==" + a[0]);
			if (less(a[i], a[i - 1])) {
				a[0] = a[i];
				int j;
				for (j = i - 1; less(a[0], a[j]); j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = a[0];
			}
		}
	}
}
