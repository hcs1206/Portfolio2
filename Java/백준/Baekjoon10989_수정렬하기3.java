import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr= new int[N];
		int[] arr2 = new int[N];
		int[] count = new int[10001];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			count[arr[i]]++;
			if(arr[i] > max)
				max = arr[i];
		}
		
		for(int i=1; i<=max; i++) {
			count[i] += count[i-1];
		}
		
		for (int i = 0; i < N; i++) {
			arr2[ count[arr[i]]-1 ] = arr[i];
			count[arr[i]]--;
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(arr2[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}

}
