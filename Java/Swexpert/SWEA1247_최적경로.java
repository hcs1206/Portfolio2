import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247_������� {
	static int N, p[]; // N : ���� ��, p : �� ���� ������ ���� ������ �迭

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			
			int min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			int[][] customers = new int[N][2]; // N���� ���� ��ǥ
		    int[][] distance = new int[N+2][2]; // ȸ�� ��ǥ(0), N���� �� ��ǥ(������ ���� ����:1-N), �� ��ǥ(N+1)
		    p = new int[N];

			
			st = new StringTokenizer(br.readLine());
			distance[0][0] = Integer.parseInt(st.nextToken()); // ȸ��
			distance[0][1] = Integer.parseInt(st.nextToken());
			distance[N+1][0] = Integer.parseInt(st.nextToken()); // ��
			distance[N+1][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
				p[i] = i+1;
			}
			// p�迭 = {1,2,3,4,5}
			// np ȣ�� => 1,2,3,5,4
			// np ȣ�� => 1,2,4,3,5
			
			do {
				// ������ ó��
				for (int i = 0; i < N; i++) {
					distance[p[i]] = customers[i];
				}
				int temp = 0;
				for (int i = 0; i <= N; i++) { // �������� ����(������ �� �� ó��)
					temp += Math.abs(distance[i][0] - distance[i+1][0]);
					temp += Math.abs(distance[i][1] - distance[i+1][1]);
				}
				if(min > temp) {
					min  = temp;
				}
				
			} while(nextPermutation());
			
			System.out.println("#"+t+" "+min);
		}
	} // end of main

	// boolean : true=> ���� ���� ���� ok, false=> ���� ���� ���� �Ұ�(�̹� ���� ū ����)
	private static boolean nextPermutation() {
		// 1. ���ʺ��� Ž���ϸ� �����(i) ã��
		int i= N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		if(i==0) return false;
		
		// 2. ���ʺ��� Ž���ϸ� ��ȯ�� ū��(j) ã��
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		// 3. i-1, j��ġ�� ��ȯ
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		// 4. i��ġ���� N-1(�ǵ�)���� �������� ������ ���ڸ� ������������ ���� ���� ���� ����� ���� ��ȯ(����)
		int k = N-1;
		while(i<k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			++i;
			--k;
		}
		return true;
	} // end of nextPermutation

} // end of class
