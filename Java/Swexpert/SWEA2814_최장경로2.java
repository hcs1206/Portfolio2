import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2814_������2 {
   static int N;
   static int M;
   static int ans;
   static int[][] adj;
   // � �湮 üũ���·�, � ������ �����ߴ���
   static int[][] memo;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for (int test_case = 1; test_case <= T; test_case++) {
         StringTokenizer st = new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken()); // �������� 1 <= N < 10
         M = Integer.parseInt(st.nextToken()); // ���� ���� <= 20
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
            ans = Math.max(ans, dfs(i,1<<i)); // visited : i��° ��Ʈ Ű��
         }
         System.out.println("#" + test_case + " "+ ans);
      }
   }
   
   public static int dfs(int v,int visited) {
      if(memo[visited][v] != 0) {
         return memo[visited][v];
      }
      
      int ret = 1; // ���� �������κ��� ���� ���� ���
      for (int i = 1; i <= N; i++) {
         if(adj[v][i] == 1 && (visited & (1 << i)) == 0) {
            ret = Math.max(ret, dfs(i, visited | (1<<i))+1);
         }
      }
      memo[visited][v] = ret;
      return ret;
   }
}