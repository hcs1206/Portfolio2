import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon17070_파이프옮기기1 {
	private static int[][] map;
	private static int N;
	private static int answer;
	private static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[3][N][N];
		answer = 0;		
		
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = str.charAt(j*2) - '0';
			}
		}
		visited[0][0][1] = true;
		
		dfs(0,1,0,0,0);
		System.out.println(answer);
	}

	public static void dfs(int hR, int hC, int tR, int tC, int state) {
		if(hR==N-1 && hC==N-1) {
			answer++;
			return;
		}
		
		if(state == 0) {
			if(hR < N && hC+1 < N && !visited[0][hR][hC+1] && map[hR][hC+1] == 0) {
				dfs(hR,hC+1, hR,hC,0);
			}
			
			if(hR+1 < N && hC+1 < N && !visited[2][hR+1][hC+1] && map[hR+1][hC+1] == 0 && map[hR+1][hC] == 0 && map[hR][hC+1] == 0) {
				dfs(hR+1,hC+1, hR,hC,2);
			}
			
		}
		else if(state == 1) {
			if(hR+1 < N && hC < N && !visited[1][hR+1][hC] && map[hR+1][hC] == 0) {
				dfs(hR+1,hC, tR+1, tC,1);
			}
			if(hR+1 < N && hC+1 < N && !visited[2][hR+1][hC+1] && map[hR+1][hC+1] == 0 && map[hR+1][hC] == 0 && map[hR][hC+1] == 0) {
				dfs(hR+1,hC+1, hR,hC,2);
			}
		}
		else {
			if(hR < N && hC+1 < N && !visited[0][hR][hC+1] && map[hR][hC+1] == 0) {
				dfs(hR,hC+1, hR,hC,0);
			}
			if(hR+1 < N && hC < N && !visited[1][hR+1][hC] && map[hR+1][hC] == 0) {
				dfs(hR+1,hC, tR+1, tC,1);
			}
			if(hR+1 < N && hC+1 < N && !visited[2][hR+1][hC+1] && map[hR+1][hC+1] == 0 && map[hR+1][hC] == 0 && map[hR][hC+1] == 0) {
				dfs(hR+1,hC+1, hR,hC,2);
			}
		}
		
		
		
	}
	
}
