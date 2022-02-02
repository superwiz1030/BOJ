import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static final int MAX_ALPHABET = 26;
	static int N;
	static int M;

	static class Trie {
		Trie[] nodes;
		int cnt;

		public Trie() {
			this.nodes = new Trie[MAX_ALPHABET];
			this.cnt = 0;
		}
	}

	static Trie root;

	static void makeTrie(Trie cur, char[] str) {
		int i = 0;
		while (i < str.length) {
			int c = str[i] - 'a';
			if (cur.nodes[c] == null) {
				cur.nodes[c] = new Trie();
			}
			cur = cur.nodes[c];
			i++;
		}
		cur.cnt++;
	}

	static int find(Trie cur, char[] str) {
		int i = 0;
		while (i < str.length) {
			int c = str[i] - 'a';
			if (cur.nodes[c] == null)
				break;
			cur = cur.nodes[c];
			i++;
		}

		if (i == str.length)
			return 1;

		return 0;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		root = new Trie();

		for (int i = 0; i < N; ++i) {
			makeTrie(root, br.readLine().toCharArray());
		}

		int ret = 0;
		for (int i = 0; i < M; ++i) {
			ret += find(root, br.readLine().toCharArray());
		}
		System.out.println(ret);
	}
}
