import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA4534_����ĥ {
	static final int MOD = 1000000007;
	static int N;
	static List<Integer>[] adj;
	static long[][] memo;
	
	 static long dfs(int v, int color, int parent) {
	        //memo[color][v] ���� �����Ѵٸ�, �ٽ� ������� �ʰ�, �˰� �ִ��� ����
	        if(memo[color][v] != 0)
	            return memo[color][v];
	        long ret = 1;
	        
	        //color�� ��(0)�� ���.
	        //�ڽ� ������ ��(1)���� ĥ�� ����� ����Ǽ����� ��
	        if( color == 0 ) {
	            //���� ���� v���� ����� ��� ������ ���ؼ�
	            for(int i = 0; i < adj[v].size(); i++) {
	                if( adj[v].get(i) != parent ) {
	                    ret *= dfs(adj[v].get(i), 1, v);
	                    ret %= MOD;
	                }
	            }
	        }
	        //color�� ��(1)�� ���
	        else {
	            for(int i = 0; i < adj[v].size(); i++) {
	                if( adj[v].get(i) != parent ) {
	                    //�ڽ� ������ ��(0)���� ĥ�� ����� ����Ǽ� ���� ��
	                    ret *= ( dfs(adj[v].get(i), 1, v) + dfs(adj[v].get(i), 0, v)  );
	                    ret %= MOD;
	                    //�ڽ� ������ ��(1)���� ĥ�� ����� ����Ǽ� ���� ��
	                }
	            }
	        }
	        //memo[color][v] �� ���
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
