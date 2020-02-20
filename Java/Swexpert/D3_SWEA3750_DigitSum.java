import java.util.Scanner;

public class Swexpert3750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			long N = sc.nextLong();
			
			long answer = dfs(N);

			System.out.println("#" + test_case + " " + answer);
		} // end of testcase
	}
	
	public static long dfs(long n) {
		if(n/10 == 0) {
			return n;
		}
		else {
			long sum=0;
			while(n != 0) {
				sum += n%10;
				n = n/10;
			}
			return dfs(sum);
		}
	}

}
