import java.util.Scanner;

public class Baekjoon1018_체스판다시칠하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				int cnt=0;
				char color = map[i][j];
				for (int r = i; r < i+8; r++) {	
					for (int c = j; c < j+8; c++) {
						if(color != map[r][c]) {
							color = map[r][c];
						}
						else {
							if(color == 'B') color = 'W';
							else color = 'B';
							cnt++;
						}
					}
					if(color == 'B') color = 'W';
					else color = 'B';
				}
				
				if(cnt > 32) cnt = 64-cnt;
				if(answer > cnt)
					answer = cnt;
			}
		}
		
		System.out.println(answer);
	}

}
