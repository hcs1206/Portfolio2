import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10844_쉬운계단수 {
	private static long[][] dp = new long[101][10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp[1][1] = 1;
		dp[1][2] = 1;
		dp[1][3] = 1;
		dp[1][4] = 1;
		dp[1][5] = 1;
		dp[1][6] = 1;
		dp[1][7] = 1;
		dp[1][8] = 1;
		dp[1][9] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][1]%1000000000;
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
			}
			dp[i][9] = dp[i-1][8]%1000000000;
		}
		
		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer += dp[N][i]%1000000000;
		}
		
		System.out.print(answer%1000000000);
	}
}