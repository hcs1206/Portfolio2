import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9461_파도반수열 {
	private static long[] dp = new long[101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 1;
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(getNum(N));
			
		}
		
		
	}

	private static long getNum(int n) {
		if(n < 3) {
			return dp[n];
		}
		else if(dp[n] > 0) {
			return dp[n];
		}
		else {
			return dp[n] = getNum(n-2) + getNum(n-3);
		}
	}
}