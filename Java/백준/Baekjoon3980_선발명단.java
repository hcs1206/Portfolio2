package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3980_선발명단 {
	
	static int answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			answer = 0;
			visited = new boolean[11];
			int[][] player = new int[11][11];

			for (int i = 0; i < player.length; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < str.length; j++) {
					player[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			makePosition(player, 0, 0);
			

			System.out.println(answer);
		}

	}

	private static void makePosition(int[][] player, int cur, int sum) {
		if(cur == player.length) {
			if(sum > answer)
				answer = sum;
			return;
		}
		
		for (int i = 0; i < player.length; i++) {
			if(!visited[i] && player[i][cur] > 0) {
				visited[i] = true;
				makePosition(player, cur+1, sum+player[i][cur]);
				visited[i] = false;
			}
		}
		
	}

}
