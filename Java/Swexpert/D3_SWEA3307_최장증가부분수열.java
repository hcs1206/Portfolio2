import java.util.Scanner;
import java.util.Vector;

public class Swexpert3307 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			int[] dp = new int[N+1];
			arr[N] = -1;
			
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			for(int i=N-1; i>=0; i--) {
				int cur = 1;
				for(int j=i+1; j<N; j++) {
					if(arr[i] < arr[j]) {
						cur = Math.max(cur, dp[j]+1);
					}
				}
				dp[i] = cur;
			}
			
			int answer = 0;
			for(int i=0; i<N; i++) {
				if(answer < dp[i])
					answer = dp[i];
			}
			
						
			System.out.println("#" + test_case + " " + answer);
		}
		
	} // end of main

} // end of class





