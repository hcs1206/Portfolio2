import java.util.Scanner;

public class Swexpert2814 {
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			for (int i = 0; i < M; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				map[start][end] = 1;
				map[end][start] = 1;
			}
			
			int answer = 0;
			
			for(int i=1; i<= N; i++) {
				int temp = dfs(i, 1, N);
				if(temp > answer)
					answer = temp;
			}

			System.out.println("#" + test_case + " " + answer);
		} // end of testcase
	}
	
	static int dfs(int curIdx, int count, int N) {
		visited[curIdx] = true;
		
		for(int i=1; i<= N; i++) {
			if(!visited[i] && map[curIdx][i] == 1) {
				return dfs(i, count+1, N);
			}
		}
		
		
		visited[curIdx] = false;
		
		return count;
	}
}
