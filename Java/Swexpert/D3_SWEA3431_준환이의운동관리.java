import java.util.Scanner;

public class Swexpert3431 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; test_case++) {
			int L, U, X;
			L = sc.nextInt();
			U = sc.nextInt();
			X = sc.nextInt();
			
			int answer = 0;
			if(X > U) {
				answer = -1;
			}
			else if(X < L) {
				answer = L-X;
			}
			else {
				answer = 0;
			}
			
			System.out.println("#" + test_case + " " + answer);
		}

	}

}
