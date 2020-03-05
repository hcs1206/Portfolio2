import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1907_모래성쌓기 {
	private static int H;
	private static int W;
	private static int[][] map;
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {0,1,1,1,0,-1,-1,-1};
	static int[] dc = {1,1,0,-1,-1,-1,0,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			
					
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					if(str.charAt(j) == '.') {
						map[i][j] = 0;
					}
					else {
						map[i][j] = str.charAt(j)-'0';
					}
				}
			}
			
			Queue<Node> queue = new LinkedList<Node>();
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if(map[r][c] == 0) {
						for (int d = 0; d < 8; d++) {
							int nr = r+dr[d];
							int nc = c+dc[d];
							
							if(nr < 0 || nc < 0 || nr>=H || nc >= W) continue;
							
							if(map[nr][nc] != 0) {
								map[nr][nc]--;
								if (map[nr][nc] == 0) {
									// 원래는 모래였으나 깍여서 바다가 된 친구는 -1로 표시
									map[nr][nc] = -1;
									// 다음 회차에서 주변 모래의 견고함을 줄이기 위해 큐에 저장
									queue.add(new Node(nr,nc));
									
								}
							}
						}
					}
				}
			}
			int ans = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					// 직전 루프에서 바다로 된 친구들
					Node node = queue.poll();
					
					for (int d = 0; d < 8; d++) {
						int nr = node.r+dr[d];
						int nc = node.c+dc[d];
						
						if(nr < 0 || nc < 0 || nr>=H || nc >= W) continue;
						
						// 모래가 발견되면
						if(map[nr][nc] > 0) {
							map[nr][nc]--;
							if (map[nr][nc] == 0) {
								// 원래는 모래였으나 깍여서 바다가 된 친구는 -1로 표시
								map[nr][nc] = -1;
								// 다음 회차에서 주변 모래의 견고함을 줄이기 위해 큐에 저장
								queue.add(new Node(nr,nc));
								
							}
						}
					}
				}
				ans++;
			}

			

			System.out.println("#" + test_case + " " + ans);
		}
	}

}
