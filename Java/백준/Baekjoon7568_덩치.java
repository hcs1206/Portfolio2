// 덩치

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] weight = new int[N];
		int[] tall = new int[N];
		int[] rank = new int[N];
		
		for (int i = 0; i < tall.length; i++) {
			weight[i] = sc.nextInt();
			tall[i] = sc.nextInt();
			rank[i] = 1;
		}
		
		for (int i = 0; i < rank.length; i++) {
			for (int j = i+1; j < rank.length; j++) {
				if(weight[i] > weight[j] && tall[i] > tall[j])
					rank[j]++;
				else if(weight[i] < weight[j] && tall[i] < tall[j])
					rank[i]++;
			}
		}
		
		for (int i = 0; i < rank.length; i++) {
			System.out.print(rank[i] + " ");
		}
		
	}

}