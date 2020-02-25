import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Baekjoon2580_½ºµµÄí {
	private static int[][] map;
	private static ArrayList<int[]> point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		map = new int[9][9];
		point = new ArrayList<int[]>();
		
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j*2) - '0';
				if(map[i][j] == 0) {
					point.add(new int[] {i,j});
				}
			}
		}
		
		int r = point.get(0)[0];
		int c = point.get(0)[1];
		for (int i = 1; i <= 9 ; i++) {
			boolean check = false;
			for (int j = 0; j < 9 ; j++) {
				if(map[r][j] == i || map[j][c] == i) {
					check = true;
					break;
				}
			}
			
			for (int j = (r/3)*3; j < (r/3)*3 + 3; j++) {
				for (int k = (c/3)*3; k < (c/3)*3 + 3; k++) {
					if(map[j][k] == i) {
						check = true;
						break;
					}
				}
			}
			
			if(!check) {
				map[r][c] = i;
				dfs(1);
				map[r][c] = 0;
			}
		}
		
	}

	private static void dfs(int index) throws IOException {
		// TODO Auto-generated method stub
		if(index == point.size()) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					bw.write(map[i][j] + " ");
				}
				bw.write("\n");
			}
			bw.flush();
			bw.close();
			System.exit(0);
		} else {
			int r = point.get(index)[0];
			int c = point.get(index)[1];
			for (int i = 1; i <= 9 ; i++) {
				boolean check = false;
				for (int j = 0; j < 9 ; j++) {
					if(map[r][j] == i || map[j][c] == i) {
						check = true;
						break;
					}
				}
				
				for (int j = (r/3)*3; j < (r/3)*3 + 3; j++) {
					for (int k = (c/3)*3; k < (c/3)*3 + 3; k++) {
						if(map[j][k] == i) {
							check = true;
							break;
						}
					}
				}
				
				if(!check) {
					map[r][c] = i;
					dfs(index+1);
					map[r][c] = 0;
				}
			}
		}
	}

}
