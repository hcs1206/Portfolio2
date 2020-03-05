import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14500_테트로미노 {
	private static int M;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j,map[i][j], 1);
				visited[i][j] = false;
			}
		}
		
		int sum=0;
		// ㅏ
		for (int i = 1; i < N-1; i++) {
			for (int j = 0; j < M-1; j++) {
				sum = map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j+1];
				if(answer < sum) answer = sum;
			}
		}
		
		// ㅜ
		for (int i = 0; i < N-1; i++) {
			for (int j = 1; j < M-1; j++) {
				sum = map[i][j]+map[i][j-1]+map[i+1][j]+map[i][j+1];
				if(answer < sum) answer = sum;
			}
		}
		
		// ㅓ
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < M; j++) {
				sum = map[i][j]+map[i-1][j]+map[i+1][j]+map[i][j-1];
				if(answer < sum) answer = sum;
			}
		}
		
		// ㅗ
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M-1; j++) {
				sum = map[i][j]+map[i-1][j]+map[i][j+1]+map[i][j-1];
				if(answer < sum) answer = sum;
			}
		}
		
		System.out.println(answer);
		
	}

	// dfs를 통해 ㅁ, ㅣ, ㄱ 모양 계산
	private static void dfs(int i, int j, int sum, int count) {
		if(count == 4) {
			if(sum > answer)
				answer = sum;
		} else {
			if(i+1 < N && !visited[i+1][j]) {
				visited[i+1][j] = true;
				dfs(i+1,j,sum+map[i+1][j], count+1);
				visited[i+1][j] = false;
			}
			
			if(i-1 >= 0 && !visited[i-1][j]) {
				visited[i-1][j] = true;
				dfs(i-1,j,sum+map[i-1][j], count+1);
				visited[i-1][j] = false;
			}
			
			if(j+1 < M && !visited[i][j+1]) {
				visited[i][j+1] = true;
				dfs(i,j+1,sum+map[i][j+1], count+1);
				visited[i][j+1] = false;
			}
			
			if(j-1 >= 0 && !visited[i][j-1]) {
				visited[i][j-1] = true;
				dfs(i,j-1,sum+map[i][j-1], count+1);
				visited[i][j-1] = false;
			}
		}
	}

}
