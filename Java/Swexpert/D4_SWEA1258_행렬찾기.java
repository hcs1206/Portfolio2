import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA1258_행렬찾기 {
	static class Chemical implements Comparable<Chemical>{
		
		public Chemical(int r, int c, int i, int size) {
			this.r = r;
			this.c = c;
			this.i = i;
			this.size = size;
		}

		int r;
		int c;
		int i;
		int size;
		
		public int compareTo(Chemical c) {
			if(this.size == c.size) {
				return this.r - c.r;
			}
			else {
				return this.size - c.size;
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N+2][N+2];

			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ArrayList<Chemical> arr= new ArrayList<Chemical>();
			
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int endR=-1, endC=-1;
					if(map[i][j] > 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
						for (int k = i; k <=N+1; k++) {
							if(map[k][j] == 0) {
								endR = k;
								break;
							}
						}
						for (int k = j; k <=N+1; k++) {
							if(map[i][k] == 0) {
								endC = k;
								break;
							}
						}
						arr.add(new Chemical(endR-i, endC-j, i,(endR-i)*(endC-j)));
					}	
				}
			}
			
			Collections.sort(arr);
			
			
			
			System.out.print("#" + test_case + " " + arr.size() + " ");
			for (int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i).r + " " +arr.get(i).c + " ");
			}
			System.out.println();
		}
		
	}
		
}
