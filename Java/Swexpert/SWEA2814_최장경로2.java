import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2814_최장경로2 {
   static int N;
   static int M;
   static int ans;
   static int[][] adj;
   // 어떤 방문 체크상태로, 어떤 정점에 도달했는지
   static int[][] memo;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for (int test_case = 1; test_case <= T; test_case++) {
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken()); // 정점개수 1 <= N < 10
         M = Integer.parseInt(st.nextToken()); // 간선 개수 <= 20
         ans = Integer.MIN_VALUE;
         adj = new int[N+1][N+1];
         memo = new int[1 << (N+1)][N+1];
         for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = adj[y][x] = 1;
         }
         for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dfs(i,1<<i)); // visited : i번째 비트 키기
         }
         System.out.println("#" + test_case + " "+ ans);
      }
   }
   
   public static int dfs(int v,int visited) {
      if(memo[visited][v] != 0) {
         return memo[visited][v];
      }
      
      int ret = 1; // 현재 정점으로부터 남은 최장 경로
      for (int i = 1; i <= N; i++) {
         if(adj[v][i] == 1 && (visited & (1 << i)) == 0) {
            ret = Math.max(ret, dfs(i, visited | (1<<i))+1);
         }
      }
      memo[visited][v] = ret;
      return ret;
   }
}