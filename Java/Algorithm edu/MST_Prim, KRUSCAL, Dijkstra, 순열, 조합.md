# MST_Prim, KRUSCAL, Dijkstra, 순열, 조합

```java
import java.util.Scanner;
/**
 * 
 * MST 최소 신장 트리 : 모든 정점의 개수 V개라면 간선을 V-1를 선택한 사이클이 없는 트리
 *	Prim, Kruskal
 *	Prim : 임의의 정점을 하나 선택해서 시작, 결과는 동일하게 나옴
 *	선택한 정점들에서 인접한, 선택하지 않은 , 방문하지 않은 정점중 가중치가 최소인 정점을 선택해 나간다.
 */
/**
 * 정점의 갯수 V, 간선의 갯수 E
7 11
5 3 18
1 2 21
2 6 25
0 2 31
0 1 32
3 4 34
5 4 40
2 4 46
0 6 51
4 6 51
0 5 60
 * 
 */
public class Z30_MST_Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점의 갯수
		int E = sc.nextInt(); //간선의 갯수
		int [][] G = new int [V][V]; // 인접행렬, 초기값이 0
		for (int i = 0; i < E; i++) {
			int parent = sc.nextInt();
			int index = sc.nextInt();
			int value = sc.nextInt();
//			G[parent][index] = value;
//			G[index][parent] = value;
			G[parent][index] = G[index][parent] = value;
		}
		int []p = new int [G.length];//부모 index를 저장할 배열 , st,파이
		int []val = new int[G.length];//최소 가중치를 저장할 배열 ,val,key
		int index = 0; // 시작할 정점 지정(어떤 정점이 와도 결과는 동일)
		for(int i = 0; i < G[index].length; i++) {
			if(G[index][i] > 0) {// 인접함
				p[i] = index; // 부모표시
				val[i] = G[index][i]; // 가중치
			}
			else {//인접하지 않음
				p[i] = -1;// 부모없음 null
				val[i] = Integer.MAX_VALUE;// 무한대 표시
			}
		}
		p[index] = index;// 시작정점의 부모는 자기자신 (root를 의미)
		val[index] = 0;// 자기자신으로 가는 가중치는 0
		boolean[] selected = new boolean[V]; //선택한 정점 선택표시
		selected[index] = true;//시작 정점 선택표시
		for(int i = 1; i < V; i++) {// 정점의 갯수는 V, MST 간선의 개수는 V-1개
										//한 사이클마다 1개의 정점을 선택한다.
			//선택하지 않은 정점중에서 가중치가 최소인 정점을 찾는다.
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int j = 0; j < val.length; j++) {
				if(!selected[j] && min > val[j]) {
					min = val[j];
					minIndex = j;
				}
			}
			index = minIndex;
			selected[index] = true;
			// 선택한 정점을 출력(정점1-정점2 가중치)
			System.out.println(p[index]+ "-"+index+" "+val[index]);
			
			// 새로 선택한 정점을 통해서 개척된 새로운 경로를 업데이트 (부모,가중치)
			for (int j = 0; j < G[index].length; j++) {
				// 선택하지 않은 정점 중, 인접했고, 가중치가 더 작으면 업데이트
				if(!selected[j] && G[index][j] > 0 && val[j] > G[index][j]) {
					p[j] = index; // 부모 업데이트
					val[j] = G[index][j]; // 가중치 업데이트
				}
			}
		}
		//MST 합을 출력
		int MST = 0; // 치ㅗ소 신장트리 가중치의 합
		for (int i = 0; i < val.length; i++) {
			MST += val[i];
		}
		System.out.println("Prim으로 구한 MST의 전체 가중치 합: " + MST);
		
		
	}//endofmain
}//endofclass
```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * MST
 * 	Prim : 가중치를 정점에 매겨놓고, 정점을 선택해 나감
 * 		O[V ^ 2] : 순차 검색을 사용할 경우
 * 		O[E log V] : 최소힙(우선순위 큐)을 사용할 경우
 *
 *  KRUSKAL : 가중치를 간선에 매겨놓고, 간선을 선택해 나감
 *  	O[E log E] or O[E log V] : DisjointSet 사용, 퀵 or 병합 정렬 사용시
 *  		간선의 개수가 적으면 유리 ( E < V^2)
 *  	O[E * a]				 : DisjointSet 사용, 카운팅 정렬 사용시
 *  
7 11
5 3 18
1 2 21
2 6 25
0 2 31
0 1 32
3 4 34
5 4 40
2 4 46
0 6 51
4 6 51
0 5 60
 */
public class Z31_MST_KRUSCAL_sol {
	public static int[] p;
	public static int[] rank;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());// 정점의 갯수
		int E = Integer.parseInt(st.nextToken());// 간선의 갯수
		// 간선배열을 사용
		Edge[] G = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 =  Integer.parseInt(st.nextToken());
			int w  =Integer.parseInt(st.nextToken());
			G[i] = new Edge(v1,v2,w);
		}
		// 정렬리 KRUSKAL 알고리즘에서 가장 오래걸리는 부분
		System.out.println("정렬 전");
		System.out.println(Arrays.toString(G));
		Arrays.sort(G); // N log N => 카운팅 정렬시 N으로 줄일 수 있다
		System.out.println("정렬 후");
		System.out.println(Arrays.toString(G));
		// 각 정점을 집합으로 만듬
		p = new int[V]; // 부모 정보를 담는 배열
		rank = new int[p.length];
		for (int i = 0; i < p.length; i++) {
			makeSet(i);
		}
		int cnt = 0; // 선택된 간선의 개수
		int MST = 0; // 최소 신장 트리의 가중치 합
		// 가중치가 최소인 간선을 선택 V-1개
		for (int i = 0; i < E; i++) { // 간선을 정렬해 놓은 순서대로 검토
			Edge e = G[i];
			int px = findSet(e.v1);
			int py = findSet(e.v2);
			if(px != py) { // 사이클이 생기면 안됨, 대표자가 다르면
				union(px,py);
				System.out.println(e); // 선택된 간선을 출력
				cnt++;
				MST += e.w;
				if(cnt == V-1) {
					break;
				}
			}
		}
		System.out.println("KRUSKAL로 구한 MST의 전체 가중치 합 : "+MST);
	}
	/** 멤버 x를 포함하는 새로운 집합을 생성 */
	public static void makeSet(int x) {
		p[x] = x; // 부모를 자신의 index로 표기
//		rank[x] = 0; // 깊이 저장, 초기값이 0임
	}
	/** 일반 멤버 x를 포함하는 집합의 대표자 index를 리턴 */
	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		}else {
//			p[x] =  findSet(p[x]); // Path Compression
			return p[x] =  findSet(p[x]);
		}
	}
	/** 일반 멤버 x, 일반 멤버 y를 포함하는 두 집합을 통합*/
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px != py) { // 다른 집합일 때만 합치기, 같은 집합인데 합치면 StackOverflowError 발생
			link(px,py);		
		}
	}
	/** x의 대표자 집합과 y의 대표자 집합을 rank값을 기준으로 합침 */
	public static void link(int px, int py) {
		if(rank[px] > rank[py]) {
			p[py] = p[px]; // 깊은 쪽을 대표자로 설정
		}else { // rank[px] <= rank[py]
			p[px] = py;
			if(rank[px] == rank[py]) { // 깊이가 같은 경우 랭크 값을 증가시켜준다
				rank[py]++;
			}
		}
	}
	public static class Edge implements Comparable<Edge>{
		int v1; // 정점1
		int v2; // 정점2
		int w; // 가중치
		public Edge(int v1,int v2, int w) {
			this.v1= v1;
			this.v2= v2;
			this.w = w;
		}
		public String toString() {
			return "(" + v1 + "," + v2 + "=" + w + ")";
		}
		@Override
		public int compareTo(Edge o) {
			// 나 this o1, 참조변수 o o2
			// return o1 - o2
			return this.w - o.w;
		}
	}
}
```

```java
import java.util.Arrays;

/**
 * Dijkstra :  특정 정점에서 시작하는 각 정점까지의 거리를 구하는 알고리즘
 * 		음이 아닌 가중치일 경우만 가능
 * 		O[N^2]
 */
public class Z32_Dijkstra {
	static final int M = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] G = {
				{0,3,5,M,M,M},
				{M,0,2,6,M,M},
				{M,1,0,4,6,M},
				{M,M,M,0,2,3},
				{3,M,M,M,0,6},
				{M,M,M,M,M,0},
		};
		int s = 0; // 시작정점 지정
		int[] D = G[s]; // 가중치 배열, 인접행렬의 진출 차수를 기준으로 초기화
		boolean[] used = new boolean[G.length]; // 사용한 정점 저장
		used[s] = true;
		for (int i = 1; i < used.length; i++) { // 정점의 개수만큼 반복, 1사이클에 정점 1개 선택
			// 사용하지 않은 정점 중에서, D 가중치 배열에서 최소 가중치값 정점을 찾기
			int minIndex = -1;
			int min = M;
			for (int j = 0; j < used.length; j++) {
				if(!used[j] && min > D[j]) {
					minIndex = j;
					min = D[j];
				}
			}
			used[minIndex] = true;
			
			// 선택한 정점을 통해서 갈수 있는 정점의 가중치를 갱신하기
			for (int j = 0; j < D.length; j++) {
				if(!used[j] && G[minIndex][j] != M && D[j] > D[minIndex] + G[minIndex][i]) {
					D[j] = D[minIndex] + G[minIndex][j];
				}
			}
		}
		System.out.println(Arrays.toString(D));
	}

}

```

```java

public class Z33_순열 {
	public static int[] arr = {6,7,8};
	public static void main(String[] args) {
		int n = arr.length;
		int r = 3;
		perm(r,0);
	}
	/** r: 뽑을개수, k: 현재 단계 */
	public static void perm(int r, int k) {
		// TODO Auto-generated method stub
		if(r==k) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}else {
			for (int i = k; i < arr.length; i++) { // 0~(k-1) 확정, 미선택 수 k~끝, k번째 숫자를 결정
				// arr[i] <-> arr[k] swap
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				perm(r, k+1);
				
				// arr[i] <-> arr[k] swap, 다음 작업을 위해 원상복귀
				temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
	}

}

```

```java
/**
 * 조합 Combination
 * 	1. 반복문		<= 이코드
 * 	2. 재귀함수
 */
public class Z34_조합 {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
//		5C3 arr 의 5개 원소중 임의의 3개 선택
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				for (int k = j+1; k < arr.length; k++) {
					System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
				}
			}
		}
	} // end of main

} // end of class
```

```java
import java.util.Arrays;

/**
 * 조합 Combination
 * 	1. 반복문		
 * 	2. 재귀함수	<= 이코드
 */
public class Z34_조합2 {
	private static int[] arr ={1,3,5,7,9};
	private static int[] trr;

	public static void main(String[] args) {
		int n = arr.length;
		int r= 3;
		trr = new int[r];
		comb(n,r);
		
	} // end of main

	public static void comb(int n, int r) {
		// TODO Auto-generated method stub
		if(r == 0) { // 종료파트
			System.out.println(Arrays.toString(trr));
		} else if(n<r) {
			return;
		} else { // 재귀파트0
			trr[r-1] = arr[n-1];
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
  
} // end of class
```

