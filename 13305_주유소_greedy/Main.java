import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static long[] distance;
	static long[] cost;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());

		distance = new long[N - 1];
		cost = new long[N];

		input = br.readLine();
		st = new StringTokenizer(input);
		for (int i = 0; i < N - 1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}

		input = br.readLine();
		st = new StringTokenizer(input);
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		long ret = 0;
		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < cost[i + 1]) {
				cost[i + 1] = cost[i];
			}
			ret += cost[i] * distance[i];
		}

		System.out.println(ret);
	}
}
