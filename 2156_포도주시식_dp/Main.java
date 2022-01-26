import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	private static final int MAX = 10001;
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new java.io.FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		arr = new int[MAX];
		dp = new int[MAX];

		for (int i = 1; i < N + 1; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];

		for (int i = 3; i < N + 1; ++i) {
			dp[i] = dp[i - 1]; // 3번째 잔을 마시지 않을 경우
			dp[i] = Math.max(dp[i], dp[i - 2] + arr[i]); // 3번째 잔이 1번째 잔일 경우
			dp[i] = Math.max(dp[i], dp[i - 3] + arr[i - 1] + arr[i]); // 3번째 잔이 연속 2번째 잔일 경우
		}
		
		System.out.println(dp[N]);
	}
}