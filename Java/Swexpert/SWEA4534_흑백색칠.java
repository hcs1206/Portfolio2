import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA4534_흑백색칠 {
	static final int MOD = 1000000007;
	static int N;
	static List<Integer>[] adj;
	static long[][] memo;
	
	 static long dfs(int v, int color, int parent) {
	        //memo[color][v] 값이 존재한다면, 다시 계산하지 않고, 알고 있던값 리턴
	        if(memo[color][v] != 0)
	            return memo[color][v];
	        long ret = 1;
	        
	        //color가 흑(0)인 경우.
	        //자식 노드들을 백(1)으로 칠한 경우의 경우의수들의 곱
	        if( color == 0 ) {
	            //현재 정점 v에서 연결된 모든 간선에 대해서
	            for(int i = 0; i < adj[v].size(); i++) {
	                if( adj[v].get(i) != parent ) {
	                    ret *= dfs(adj[v].get(i), 1, v);
	                    ret %= MOD;
	                }
	            }
	        }
	        //color가 백(1)인 경우
	        else {
	            for(int i = 0; i < adj[v].size(); i++) {
	                if( adj[v].get(i) != parent ) {
	                    //자식 노드들을 백(0)으로 칠한 경우의 경우의수 들의 곱
	                    ret *= ( dfs(adj[v].get(i), 1, v) + dfs(adj[v].get(i), 0, v)  );
	                    ret %= MOD;
	                    //자식 노드들을 흑(1)으로 칠한 경우의 경우의수 들의 곱
	                }
	            }
	        }
	        //memo[color][v] 에 기록
	        memo[color][v] = ret;
	        return ret;
	    }
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			adj = new ArrayList[N+1];
			memo = new long[2][N+1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}

			StringTokenizer st;
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
				
			}

			long ans = (dfs(1,0,-1) + dfs(1,1,-1)) % MOD;
	
			System.out.println("#" + test_case + " " + ans);
		}
		
	}


}
