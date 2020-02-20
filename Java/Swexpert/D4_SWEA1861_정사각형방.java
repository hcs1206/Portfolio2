import java.util.Scanner;

public class SWEA1861_정사각형방 {
	
	static class Room{
		Room(int r, int c){
			this.r = r;
			this.c = c;
		}
		int r;
		int c;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] map = new int[N+2][N+2];
			
			Room[] r= new Room[N*N + 1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
					r[map[i][j]] = new Room(i,j);
				}
			}
			
			int Idx=0;
			int answer = 0;
			
			for (int i = 1; i <= N*N; i++) {
				int curR = r[i].r;
				int curC = r[i].c;
				int count=1;
				
				while(true) {
					if(map[curR-1][curC] == map[curR][curC]+1) {
						curR = curR-1;
						count++;
					}
					else if(map[curR+1][curC] == map[curR][curC]+1) {
						curR = curR+1;
						count++;
					}
					else if(map[curR][curC-1] == map[curR][curC]+1) {
						curC = curC-1;
						count++;
					}
					else if(map[curR][curC+1] == map[curR][curC]+1) {
						curC = curC+1;
						count++;
					}
					else {
						break;
					}
				}
				
				if(answer < count) {
					Idx = i;
					answer= count;
				}
				
			}
			
			System.out.println("#" + test_case + " " + Idx + " " + answer);
		
		}
	}

}
