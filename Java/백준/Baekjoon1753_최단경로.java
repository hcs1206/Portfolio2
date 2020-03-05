import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
		int[] dp = new int[V+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		
		for (int i = 0; i < V+1; i++) {
			adj.add(new ArrayList<int[]>());
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			adj.get(u).add(new int[] {v,w});
		}
		
		dp[K] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(K);
		boolean[] visited = new boolean[V+1];
		while(!q.isEmpty()) {
			int k = q.poll();
			
			//if(visited[k]) continue;
			visited[k] = true;
			
			for (int[] v : adj.get(k)) {
				if(dp[v[0]] > dp[k] + v[1]) {
					dp[v[0]] = dp[k] + v[1];
					q.offer(v[0]);
				}
			}
		}
		
		for (int i = 1; i < dp.length; i++) {
			if(dp[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			}
			else {
				bw.write(dp[i] + "\n");
			}
		}
		
		bw.flush();
		bw.close();		
		
		
	}

}
