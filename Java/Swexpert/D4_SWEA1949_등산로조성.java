import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1949_등산로조성 {
	public static int[][] map;
	public static boolean[][] visited;
	public static int answer;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N+2][N+2];
			visited = new boolean[N+2][N+2];
			int peaks = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > peaks)
						peaks = map[i][j];
				}
			}
			
			int[] peakR = new int[5];
			int[] peakC = new int[5];
			int top = -1;
			
			for (int k = 1; k <= N; k++) {
				for (int l = 1; l <= N; l++) {
					if(map[k][l] == peaks) {
						peakR[++top] = k;
						peakC[top] = l;
					}
				}
			}
			
            for(int height = 0; height <= K; height++){
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						map[i][j] -= height;
						for(int k=0; k<=top; k++) {
							dfs(peakR[k], peakC[k], 1);
						}
						map[i][j] += height;
					}
				}
            }
			
			System.out.println("#" + test_case + " " +answer);
		} // end of testcase
		
	} // end of main

	public static void dfs(int r, int c, int count) {
		// TODO Auto-generated method stub
		
		if(map[r+1][c] < map[r][c] && r+1 <= N) {
			dfs(r+1,c,count+1);
		}
		
		if(map[r-1][c] < map[r][c] && r-1 > 0) {
			dfs(r-1,c,count+1);
		}
		
		if(map[r][c+1] < map[r][c] && c+1 <= N) {
			dfs(r,c+1,count+1);
		}
		
		if(map[r][c-1] < map[r][c] && c-1 > 0) {
			dfs(r,c-1,count+1);
		}
		
		if(count > answer)
			answer = count;
	}
}
