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

public class Baekjoon1916_최소비용구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		
		for (int i = 0; i < N+1; i++) {
			adj.add(new ArrayList<int[]>());
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			adj.get(u).add(new int[] {v,w});
		}
		
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		
		dp[A] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(A);
		boolean[] visited = new boolean[N+1];
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
		
		bw.write(dp[B] + "\n");
		
		bw.flush();
		bw.close();		
		
		
	}

}
