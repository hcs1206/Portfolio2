package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2623_음악프로그램 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] singer = new int[N+1];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			int cur = Integer.parseInt(st.nextToken());
			while (st.hasMoreElements()) {
				int next = Integer.parseInt(st.nextToken());
				adjList.get(cur).add(next);
				singer[next]++;
				cur = next;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < singer.length; i++) {
			if(singer[i] == 0) {
				q.offer(i);
				singer[i] = -1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int curSinger = q.poll();
			
			for (Integer nextSinger : adjList.get(curSinger)) {
				singer[nextSinger]--;
			}
			
			sb.append(curSinger).append("\n");
			
			for (int i = 1; i < singer.length; i++) {
				if(singer[i] == 0) {
					q.offer(i);
					singer[i] = -1;
				}
			}
			
		}
		
		for (int i = 1; i < singer.length; i++) {
			if(singer[i] > 0) {
				System.out.print(0);
				return;
			}
		}
		
		System.out.println(sb);
		


	}

}
