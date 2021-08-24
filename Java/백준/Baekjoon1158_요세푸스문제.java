package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon1158_요세푸스문제 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<Integer>[] set = new Set[20000];
		for (int i = 0; i < set.length; i++) {
			set[i] = new HashSet<>();
		}
		
		for (Integer set2 : set[0]) {

		}
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.offer(i+1);
		}
		
		System.out.print("<");
		
		while(!q.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				q.offer(q.poll());
			}
			if(q.size() > 1) {
			System.out.print(q.poll() +", ");
			}
			else {
				System.out.println(q.poll() + ">");
			}
		}
		
	}

}
