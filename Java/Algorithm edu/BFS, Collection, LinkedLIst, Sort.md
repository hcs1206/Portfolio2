# Week5_day4

# BFS, Collection, LinkedList, Sort

## BFS

```java
import java.util.LinkedList;
import java.util.Queue;

public class Z21_BFS_연습문제3 {
	public static void main(String[] args) {
		int[][] G = {
				{},
				{2,3},
				{1,4,5},
				{1,7},
				{2,6},
				{2,6},
				{4,5,7},
				{3,6}
		};
		
//		선형큐를 직접 구현해서 사용
		int[] q = new int[8]; // 큐생성
		int front = -1;
		int rear = -1;
		boolean[] visited = new boolean[8]; // 0번 정점은 안씀
		
		int v = 1;	// 시작정점 지정
		q[++rear] = v; // 정점 큐에 삽입
		visited[v] = true; // 방문한 것으로 표시	
		while(front != rear) {// 반복, 큐가 비어질때까지
			v = q[++front];// 큐에서 첫번째 원소 꺼내기
			System.out.print(v + " ");// 방문 처리(출력)
			for (int i = 0; i < G[v].length; i++) { // 인접한 정점의 개수만큼 반복하면서 모두 작업
				if(!visited[G[v][i]]) {// 방문하지 않았으면
					q[++rear] = G[v][i];// 큐에 넣기
					visited[G[v][i]] = true;// 방문한 것으로 표시
				}
			}
				
		}
		
//		API 사용
//		Queue<Integer> q = new LinkedList<Integer>(); // 큐생성
//		boolean[] visited = new boolean[8]; // 0번 정점은 안씀
//		
//		int v = 1;	// 시작정점 지정
//		q.offer(v); // 정점 큐에 삽입
//		visited[v] = true; // 방문한 것으로 표시	
//		while(!q.isEmpty()) {// 반복, 큐가 비어질때까지
//			v = q.poll();// 큐에서 첫번째 원소 꺼내기
//			System.out.print(v + " ");// 방문 처리(출력)
//			for (int i = 0; i < G[v].length; i++) { // 인접한 정점의 개수만큼 반복하면서 모두 작업
//				if(!visited[G[v][i]]) {// 방문하지 않았으면
//					q.offer(G[v][i]);// 큐에 넣기
//					visited[G[v][i]] = true;// 방문한 것으로 표시
//				}
//			}
//				
//		}
		
	}

}
```





## Collection

- 배열
  - 장점 : 접근 빠름, 순차 접근
  - 단점 : 비순차 접근이 느림, 크기 초기에 지정 변경불가
- List
  - 순서가 있고 중복 허용
  - ArrayList : 크기 동적 변경 가능
  - LinkedList
    - 장점 : 비순차적 접근, 크기 동적 변경
    - 단점 : 접근이 느리다, 다음링크 공간 필요
- Set
  - 순서 없고 중복 허용 x
  - HashSet, TreeSet
- Map
  - HashMap, TreeMap



## LinkedList

```java
import java.util.LinkedList;

/**
 * 리스트
 * 	배열의 단점을 해결하기 위해 준비된 객체
 * 	단순연결리스트 -> 이중연결리스트 -> 원형이중연결리스트
 */
public class Z22_LinkedList {
	public static void main(String[] args) {
		Node n1 = new Node();
		n1.data = 1;
		n1.next = null;
		
		Node head = n1; // 연결리스트
		
		Node n2 = new Node();
		n2.pre = n1;
		n2.data = 2;
		n2.next = null;
		n1.next = n2;
		
		
		LinkedList<Integer> list = new LinkedList<Integer>(); // 제너릭스 표현법
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		list.add(2,100);
		System.out.println(list);
		list.addFirst(0);
		System.out.println(list);
		list.addLast(1000);
		System.out.println(list);
		list.remove(2); // index에 있는 데이터 삭제
		System.out.println(list + " 2번째 인덱스 데이터 삭제");
		list.remove();
		System.out.println(list + " 0번째 인덱스 데이터 삭제");
		System.out.println(list.size());
		System.out.println(list.contains(3));
		
	}
}

class Node{
	int data; //초기값 0
	Node next; //초기값 null
	Node pre;
}
```



## LinkedList2

```java
import java.util.LinkedList;

/**
 * 리스트
 * 	배열의 단점을 해결하기 위해 준비된 객체
 * 	단순연결리스트 -> 이중연결리스트 -> 원형이중연결리스트
 */
public class Z23_RevisitToJosephusProblem {
	public static void main(String[] args) {
	
		LinkedList<Integer> soldier = new LinkedList<Integer>(); // 제너릭스 표현법
		for(int i=0; i<=23; i++) {
			soldier.add(i);
		}
		
		int index=0;
		while(soldier.size() > 2) {
			System.out.print(soldier.get(index)+ " ");
			soldier.remove(index);
			index = (index+2)%soldier.size();
			
		}
		System.out.println();
		System.out.println("생존 병사: " + soldier);
	}
}
```



## BubbleSort

```java
import java.util.Arrays;

/**
 * 거품정렬 O[n^2]
 */
public class Z25_BubbleSort {
	public static void main(String[] args) {
		int[] arr = {5,7,2,9,3,6,1,4,8}; // 9개
//		앞에서부터 2개씩 비교, 작은값 앞으로 큰값 뒤로
//		영역 0~8 시작값은 0~7 - 01 12 23 34 45 56 67 78
//		영역 0~7 시작값은 0~6 
//		...
//		영역 0~1 시작값은 0~0 
		for (int i = arr.length-1; i > 0; i--) { // 영역의 끝나는 숫자
			for (int j = 0; j < i; j++) { // 0~7, j 두개씩 비교할 시작위치
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

```



## InsertionSort

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * 삽입정렬 O[n^2]
 */
public class Z26_InsertionSort {
	public static void main(String[] args) {
		int[] arr = new int[3000];
		long time = System.currentTimeMillis();
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
//		LinkedList<Integer> ll = new LinkedList<Integer>();
		ArrayList<Integer> ll = new ArrayList<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			int index=0;
			for (; index < i; index++) {
				if(arr[i] < ll.get(index)) { // LinkedList가 손실나는 부분
					break;
				}
				
			}
			
			ll.add(index, arr[i]);
		}
		
		System.out.println(ll);
		System.out.println(System.currentTimeMillis() - time + "ms");
	}
}
```

