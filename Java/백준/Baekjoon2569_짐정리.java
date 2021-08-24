package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Baekjoon2569_짐정리 {

	static class Pair {
		int weight;
		int index;

		public Pair(int weight, int index) {
			super();
			this.weight = weight;
			this.index = index;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] map = new int[N];
		int[] copyMap = new int[N];

		for (int i = 0; i < copyMap.length; i++) {
			int temp = Integer.parseInt(br.readLine());
			map[i] = temp;
			copyMap[i] = temp;
		}

		Arrays.sort(copyMap);

		List<Pair> list = new ArrayList<>();

		for (int i = 0; i < copyMap.length; i++) {
			if (map[i] != copyMap[i]) {
				list.add(new Pair(map[i], i));
			}
		}

		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.weight - o2.weight;
			}

		});

		while (!list.isEmpty()) {
			loop: for (int i = 0; i < list.size()-1; i++) {
				for (int j = i+1; j < list.size(); j++) {
					if(list.get(i).weight == copyMap[list.get(j).index] && list.get(j).weight == copyMap[list.get(i).index]) {
						answer += list.get(i).weight + list.get(j).weight;
						list.remove(i);
						list.remove(j-1);
						break loop;
						
					} 
//					else if(list.get(i).weight == copyMap[list.get(j).index]) {
//						answer += list.get(i).weight + list.get(j).weight;
//						list.get(j).index = list.get(i).index;
//						list.remove(i);
//						break loop;
//					}
					else if(list.get(j).weight == copyMap[list.get(i).index]) {
						answer += list.get(i).weight + list.get(j).weight;
						list.get(i).index = list.get(j).index;
						list.remove(j);
						break loop;
					}
					
				}
			}
		}
		
		System.out.println(answer);

	}

}
