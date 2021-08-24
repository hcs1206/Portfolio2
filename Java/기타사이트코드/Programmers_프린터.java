package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_프린터 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q.offer(i + 1);
		}

		System.out.print("<");

		while (!q.isEmpty()) {
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			if (q.size() > 1) {
				System.out.print(q.poll() + ", ");
			} else {
				System.out.println(q.poll() + ">");
			}
		}

	}

	public int solution(int[] priorities, int location) {
		int answer = priorities.length;

		int curPriority = 0;
		int[] cntPriority = new int[10];

		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			q.offer(new int[] {priorities[i], i});
			cntPriority[priorities[i]]++;
			if (curPriority < priorities[i])
				curPriority = priorities[i];
		}
		
		while(q.size() > 0) {
			int[] paper = q.poll();
			
			if(paper[0] == curPriority) {
				if(paper[1] == location)
					break;
				
				if(--cntPriority[paper[0]] < 1) {
					for (int i = paper[0]; i >= 0; i--) {
						if(cntPriority[i] > 0) {
							curPriority = i;
							break;
						}
						
					}
				}
			}
			else {
				q.offer(paper);
			}
			
		}
		

		return answer - q.size();
	}

}
