import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */



class Swexpert1954
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			int dest = 0;
			int Num = 1;
			int r=0,c=0;
			int[][] answer;
			answer = new int[N][N];
			for(int i=0; i<N*N; i++) {
				answer[r][c] = Num++;
				int nextR = r+dy[dest];
				int nextC = c+dx[dest];
				if(nextR < N && nextC < N && nextR >= 0 && nextC >= 0) {
					if(answer[nextR][nextC] > 0) {
						dest = (dest+1)%4;
						r = r+dy[dest];
						c = c+dx[dest];
					}
					else {
						r = nextR;
						c = nextC;
					}
				}
				else {
					dest = (dest+1)%4;
					r = r+dy[dest];
					c = c+dx[dest];
				}
			}
			
			System.out.println("#" + test_case + " ");
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(answer[i][j]);
					System.out.print(' ');
				}
				System.out.println();
			}


		}
	}
}