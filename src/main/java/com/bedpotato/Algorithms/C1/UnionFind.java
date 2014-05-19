package com.bedpotato.Algorithms.C1;

import com.bedpotato.alg4.utils.StdIn;

public class UnionFind {
	private int id[];// 分量ID
	private int count;// 分量数量

	public UnionFind(int number) {
		count = number;
		id = new int[number];
		for (int i = 0; i < number; i++) {
			id[i] = i;
		}
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		// TODO
		return 0;
	}

	public void union(int p, int q) {

	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
	}
}
