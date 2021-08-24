package SW;

import java.io.IOException;
import java.util.PriorityQueue;

public class Programmers_더맵게 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] scoville = {0,1};
		int K = 7;
		
		solution(scoville, K);
		

	}

	private static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]);
		}
		
		while(pq.peek() < K) {
			answer++;
			
			if(pq.size() < 2) {
				answer = -1;
				break;
			}
				
			
			int a = pq.poll();
			int b = pq.poll();
			if(a+b*2 == 0) {
				answer = -1;
				break;
			}
			else
				pq.offer(a+b*2);
			
		}
		
        return answer;
		
	}



}
