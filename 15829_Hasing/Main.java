import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	private static final int M = 1234567891;

	public static void main(String[] args) throws Exception {
		// r의 값은 26보다 큰 소수인 31로 하고 M의 값은 1234567891(놀랍게도 소수이다!!)로 하자.
		System.setIn(new java.io.FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int L = Integer.parseInt(st.nextToken());

		input = br.readLine();
		char[] ch = input.toCharArray();

		long res = 0;
		long mul = 1;

		for (int i = 0; i < input.length(); i++) {
			res += ((ch[i] - 'a' + 1) * mul) % M;
			mul *= 31;
			mul %= M;
		}
		res %= M;
		System.out.println(res);
	}
} // 124ms

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//import java.util.StringTokenizer;
//
//class Main {
//	public static void main(String[] args) throws Exception {
//		// r의 값은 26보다 큰 소수인 31로 하고 M의 값은 1234567891(놀랍게도 소수이다!!)로 하자.
//		System.setIn(new java.io.FileInputStream("res/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();
//		StringTokenizer st = new StringTokenizer(input);
//		int L = Integer.parseInt(st.nextToken());
//
//		input = br.readLine();
//		char[] ch = input.toCharArray();
//
//		BigInteger res = new BigInteger("0");
//		BigInteger mul = new BigInteger("1");
//		
//		for (int i = 0; i < input.length(); i++) {
//			res = res.add(mul.multiply(new BigInteger(Integer.toString((ch[i] - 'a' + 1)))));
//			mul = mul.multiply(new BigInteger("31"));
//		}
//		res = res.remainder(new BigInteger("1234567891"));
//		System.out.println(res);
//	}
//} // 140ms
