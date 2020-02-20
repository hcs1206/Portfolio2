// Ladder

import java.util.Arrays;
import java.util.Scanner;

public class Swexpert1210 {
	
	static boolean[][] visited;
	static int[][] data;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			answer = -1;
			visited = new boolean[102][102];
			data = new int[102][102];
			
			for (int i = 1; i <= 100; i++) {
				for (int j = 1; j <= 100; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			
			
			for(int start=1; start<=100; start++) {
				if(data[1][start] == 1 && answer == -1) {
					dfs(1,start, start);
				}
			}
			
			System.out.println("#" + T + " " + answer);
		}

		
	}
	
	static void dfs(int curR, int curC, int startIndex) {
		
		if(answer != -1)
			return;
		
		visited[curR][curC] = true;
		
		if(data[curR][curC+1] == 1 && !visited[curR][curC+1]) {
			dfs(curR, curC+1, startIndex);
		}
		else if(data[curR][curC-1] == 1 && !visited[curR][curC-1]) {
			dfs(curR, curC-1, startIndex);
		}
		else if(data[curR+1][curC] == 2) {
			answer = startIndex-1;
			return;
		}
		else if(data[curR+1][curC] == 1 && !visited[curR+1][curC]) {
			dfs(curR+1, curC, startIndex);
		}
		else {
			return;
		}
	
		
		visited[curR][curC] = false;
		
	}
}
