import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5684_¿îµ¿ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());		
		for (int test_case = 1; test_case <= T; test_case++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] adj = new int[N+1][N+1];
			boolean[][] visited;
			
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				adj[s][e] = c;
			}
			
			int ans = Integer.MAX_VALUE;
			for (int i = 1; i <=N; i++) {
				visited = new boolean[N+1][N+1];
				boolean check = false;
				Queue<int[]> q = new LinkedList<int[]>();
				q.offer(new int[] {i,0});
				while(!q.isEmpty()) {
					int[] p = q.poll();
					int v = p[0];
					int sum = p[1];
					
					if(sum >= ans) continue;
					
					if(v == i && check) {
						if(ans > sum)
							ans = sum;
					}
					
					for (int j = 1; j <= N; j++) {
						if(adj[v][j] > 0 && !visited[v][j]) {
							visited[v][j] = true;
							q.offer(new int[] {j,sum+adj[v][j]});
						}
					}
					check = true;
				}
				
			}
		
			System.out.println("#" + test_case + " " + ans);
			
		}
	}

}
