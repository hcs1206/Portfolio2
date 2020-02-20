# 우선순위큐, binarySearchTree, DisjointSet

```java
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 우선순위 큐
 */
public class Z27_우선순위큐 {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.offer(1);
		pq.offer(3);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

		System.out.println("/// 큰수부터 나오게 하려면 - 우선순위를 지정 ///");
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // 내림차순
			}
		});
		pq2.offer(1);
		pq2.offer(3);
		pq2.offer(2);
		pq2.offer(4);
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());

		PriorityQueue<Com> pp = new PriorityQueue<Com>(new Comparator<Com>() {
			public int compare(Com o1, Com o2) { // 비교기준 작성
				// 나이 많은 순, 키 큰 순서
				if (o1.age != o2.age) {
					return o2.age - o1.age;
				} else {
					return o2.tall - o1.tall;
				}
			}
		});
		
		pp.offer(new Com(170, "호랑이", 26));
		pp.offer(new Com(160, "수지", 27));
		pp.offer(new Com(175, "김건모", 26));
		pp.offer(new Com(180, "서장훈", 26));
		System.out.println(pp.poll());
		System.out.println(pp.poll());
		System.out.println(pp.poll());
		System.out.println(pp.poll());
	} // end of main
} // end of class

class Com {
	int tall;
	String name;
	int age;

	public Com() {
	};

	public Com(int tall, String name, int age) {
		super();
		this.tall = tall;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "[" + tall + ", " + name + ", " + age + "]";
	}

}

```

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이진트리
 *  문제 : 추가 조건 설명
 *  	레벨4의 이진트리
 *  	루트의 정점을 1로 하자
 *  전위, 중위, 후위 순회로 출력
 *  
13
1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */
public class Z28_BinarySearchTree_sol {

	public static int[] tree= new int[32];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine()); // 정점의 개수
		String str = br.readLine();
		st = new StringTokenizer(str, " ");

		// 이진 트리 저장하기
		tree[1] = 1;// 루트 정점 번호를 저장
		for (; st.hasMoreTokens();) {
			int p = Integer.parseInt(st.nextToken()); // 간선의 시작
			int c = Integer.parseInt(st.nextToken()); // 간선의 끝
			
			// tree 배열에 p 정점이 있는지 index를 찾자
			int i;
			for (i = 1; i < tree.length; i++) {
				if(tree[i] == p) {
					break;
				}
			}
			// i 위치에 자식으로 삽입
			if (tree[i*2] == 0) { // 왼쪽 자식이 없으면, 왼쪽자식으로
				tree[i*2] = c;
			} else { // 왼쪽 자식이 있으면, 오른쪽자식으로
				tree[i*2+1] = c;
			}
		}
		
		// 이진트리 순회
		System.out.print("\n전위순회 : ");
		preOrder(1);
		System.out.print("\n중위순회 : ");
		inOrder(1);
		System.out.print("\n후위순회 : ");
		postOrder(1);
		
		
	} // end of main
	public static void preOrder(int i) {
		if(i >= tree.length || tree[i] == 0) return; // 유효성 체크, 정점이 있는지 체크
		System.out.print(tree[i] + " ");// 부모 정점 출력
		preOrder(i*2);// 왼쪽자식
		preOrder(i*2+1);// 오른쪽자식
	}

	public static void inOrder(int i) {
		if(i >= tree.length || tree[i] == 0) return; // 유효성 체크, 정점이 있는지 체크
		inOrder(i*2);// 왼쪽자식
		System.out.print(tree[i] + " ");// 부모 정점 출력
		inOrder(i*2+1);// 오른쪽자식
	}
	
	public static void postOrder(int i) {
		if(i >= tree.length || tree[i] == 0) return; // 유효성 체크, 정점이 있는지 체크
		postOrder(i*2);// 왼쪽자식
		postOrder(i*2+1);// 오른쪽자식
		System.out.print(tree[i] + " ");// 부모 정점 출력
	}


}

```

```java
/** 
 * 상호 배타 집합
 * 	그룹을 합치는 문제, 같은 그룹인지 확인 문제, 몇개의 그룹인지 세는 문제
 */
public class Z29_DisjointSet {
public static int[] p = new int[10]; // 부모 정보를 담는 배열
public static int[] rank = new int[p.length]; // 각 정점의 깊이를 저장할 배열
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < p.length; i++) {
			makeSet(i);
		}
		printSet();
		union(0,1);
		printSet();
		union(2,3);
		printSet();
		union(0,3);
		printSet();
		union(4,5);
		printSet();
		union(6,7);
		printSet();
		union(3,5);
		printSet();
		union(1,8);
		printSet();
		union(0,9);
		printSet();
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
	/** 일반 멤버 x를 포함하는 집합의 대표자 index를 리턴 */
	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		}else {
//			p[x] =  findSet(p[x]); // Path Compression
			return p[x] =  findSet(p[x]);
		}
	}
	/** 배열의 정보를 출력 */
	public static void printSet() {
		System.out.print("index : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ", i);
		}
		System.out.println();
		System.out.print("parent: ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ", p[i]);
		}
		System.out.println();
		System.out.print("rank  : ");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d ", rank[i]); // 깊이 정보를 출력
		}
		System.out.println();
		System.out.println();
	}
	/** 멤버 x를 포함하는 새로운 집합을 생성 */
	public static void makeSet(int x) {
		p[x] = x; // 부모를 자신의 index로 표기
//		rank[x] = 0; // 깊이 저장, 초기값이 0임
	}
}
```

