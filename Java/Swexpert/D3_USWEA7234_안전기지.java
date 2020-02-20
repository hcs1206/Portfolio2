import java.util.Scanner;

public class Swexpert7234_안전기지 {
	public static void main(String[] args) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int[][] map = new int[N+2][N+2];
			int[] baseR = new int[B];
			int[] baseC = new int[B];
			
			for (int i = 0; i < B; i++) {
				baseR[i] = sc.nextInt();
				baseC[i] = sc.nextInt();
			}
			
			for (int i = 0; i < B; i++) {
				int curR = baseR[i];
				int curC = baseC[i];
				
				map[curR][curC]++;
				
				for(int j=0; j<4; j++) {
					int nextR = curR+dr[j];
					int nextC = curC+dc[j];
					
					if(nextR > 0 && nextR <= N && nextC > 0 && nextC <= N) {
						map[nextR][nextC]++;
						nextR+=dr[j];
						nextC+=dc[j];
						if(nextR > 0 && nextR <=N && nextC > 0 && nextC <= N) {
							map[nextR][nextC]++;							
						}
					}
					
				}	
			}
			
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] > answer)
						answer = map[i][j];
				}
			}
			
			
			
			
			System.out.println("#" + test_case + " " + answer);			
		}

	}
}
