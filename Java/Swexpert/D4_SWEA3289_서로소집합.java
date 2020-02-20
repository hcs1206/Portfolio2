import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_황창섭 {
	private static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N + 1];
			System.out.print("#" + test_case + " ");
			
			
			for (int i = 0; i <= N; i++) {
				p[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				if(Integer.parseInt(st.nextToken()) == 1) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					
					if(findSet(a) == findSet(b)) {
						System.out.print(1);
					}
					else {
						System.out.print(0);
					}
				}
				else {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					union(a,b);
				}
			}
			System.out.println();
		}
	}

	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px > py) {
			p[py] = px;
		}
		else {
			p[px] = py;
		}
		
	}

	public static int findSet(int x) {
		if(x == p[x]) {
			return x;
		}
		else {
			return findSet(p[x]);
		}
	}
}
