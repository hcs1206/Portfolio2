import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1904_01≈∏¿œ {
	private static int[] dp = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%15746;
		}
		System.out.print(dp[N]);
	}
}
