import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int K;
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		long left = 1;
		long right = arr[K - 1];

		long ret = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			if (possible(mid) >= N) {
				ret = Math.max(ret, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ret);
	}

	static int possible(long diff) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += arr[i] / diff;
		}
		return cnt;
	}
}
