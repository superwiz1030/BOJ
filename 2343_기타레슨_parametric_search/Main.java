import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		long left = 0;
		long right = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			left = Math.max(left, arr[i]);
			right += arr[i];
		}

		while (left <= right) {
			long mid = (left + right) / 2;

			long sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > mid) {
					sum = 0;
					cnt++;
				}
				sum += arr[i];
			}
			if (sum != 0)
				cnt++;

			if (cnt <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}
}
