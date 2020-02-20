import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11054_가장긴바이토닉부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] upDp = new int[N];
		int[] downDp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(A[i] > A[j] && upDp[i] < upDp[j]) {
					upDp[i] = upDp[j]+1;
				}
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			for(int j=i+1; j<N; j++) {
				if(A[i] > A[j] && downDp[i] < downDp[j]) {
					downDp[i] = downDp[j]+1;
				}
			}
		}
		
		int answer1=0;
		int answer2=0;
		for (int i = 0; i < downDp.length; i++) {
			
		}
	}

}
