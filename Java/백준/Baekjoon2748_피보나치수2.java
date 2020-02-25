import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2748_피보나치수2 {
	private static long[] dp = new long[91];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.print(dp[N]);
	}
}