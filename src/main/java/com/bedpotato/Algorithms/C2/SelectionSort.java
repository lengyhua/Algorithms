package com.bedpotato.Algorithms.C2;

@SuppressWarnings("rawtypes")
public class SelectionSort extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}

	@Override
	public void practise(Comparable[] a) {
		for(int i=0;i<a.length;i++){
			int minNumberLocation = i;
			for(int j=i;j<a.length;j++){
				
			}
		}
	}
}
