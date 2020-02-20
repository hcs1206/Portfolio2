import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */



class Swexpert1284
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int P, Q, R, S, W;
			P = sc.nextInt();
			Q = sc.nextInt();
			R = sc.nextInt();
			S = sc.nextInt();
			W = sc.nextInt();
			
			int ACompany = P*W;
			int BCompany;
			
			if(W > R) {
				BCompany = Q + (W-R)*S;
			}
			else {
				BCompany = Q;
			}
			
			int answer = Math.max(ACompany, BCompany);
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}