# 메모리영역, 재귀, 문자열, StringBuilder



## 메모리의 3가지 영역

- CallStack : 지역변수
- Heap : 인스턴스변수
- ClassArea : 스태틱 변수



## 재귀함수

```java

public class Z07_재귀함수 {
	public static int z = 10;

	// static은 먼저 생성된다
	public static void main(String[] args) {
		for (int i = 0; i < 400; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		a(0); // 시작값을 보냄, 0 1 2 3
		// static을 붙히지 않았다면 객체 생성 후 사용
		
		for (int i = 3; i > 0; i--) {
			System.out.print(i+ " ");
		}
		System.out.println();
		b(3);
		
		for (int i = 1; i <= 4; i++) {
			System.out.print(i*2 + " ");
		}
		System.out.println();
		c(2);
		
		d(3,2,10); // 초기값, 증감값, 조건기준값
		
		for (int i = 10; i >= 0; i = i-3) {
			System.out.print(i + " ");
		}
		System.out.println();
		e(10, 3, 0); // 초기값, 감소값, 조건기준값
		
//		1~10 까지의 합
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1~10까지 합 : " + sum);
		
		f(1,10); // 전역변수를 사용해서 합을 구해보자
		System.out.println("1~10까지 합 : " + total);
		
		System.out.println(f2(1,10)); // 리턴값을 사용해서 합을 구해보자
		
		int facto = 1;
		for (int i = 5; i > 0; i--) {
			facto *= i;
		}
		System.out.println("5! : " + facto);
		
		System.out.println("5! : " + g(1,5));

	} // end of main

//	리턴타입 매서드명 (매개변수)
	public static void a(int i) {
		if(i >= 4) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(i + " "); // 반복할 실행문
			a(i+1); // 증감식
		}
	}
	
	public static void b(int i) {
		if(i <= 0) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(i + " "); // 반복할 실행문
			b(i-1); // 증감식
		}
	}
	
	public static void c(int i) {
		if(i > 8) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(i + " "); // 반복할 실행문
			c(i+2); // 증감식
		}
	}
	
	public static void d(int start, int plus, int stop) {
		if(start > stop) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(start + " "); // 반복할 실행문
			d(start+plus, plus, stop); // 증감식
		}
	}
	
	public static void e(int start, int sub, int end) {
		if(start <= end) { // basis case 종료파트
			System.out.println();
		} else { // inductive case 재귀파트
			System.out.print(start + " "); // 반복할 실행문
			e(start-sub, sub, end); // 증감식
		}
	}
	
	public static int total = 0; // 변수 선언만 해도 전역변수는 각타입의 초기값이 들어간다

	public static void f(int start, int end) {
		if(start > end) { // basis case 종료파트
			return;
		} else { // inductive case 재귀파트
			total += start;
			f(start+1, end);
		}
	}
	
	public static int f2(int start, int end) {
		if(start == end) { // basis case 종료파트
			return start;
		} else { // inductive case 재귀파트
			return start+f2(start+1, end); // 1+(2~10까지의 합)
		}
	}
	
	public static int g(int start, int end) {
		if(start == end) { // basis case 종료파트
			return start;
		} else { // inductive case 재귀파트
			return start*g(start+1, end); // 
		}
	}
}
```



## Variable

```java
/**
 * 변수 종류 :
 */
public class Z09_variable {
	int b; // 전역변수 초기값이 각 타입의 초기값으로 들어간다 - 인스턴스 변수
	static int c; // 전역변수 초기값이 들어간다 - static 변수
	
	// 메모리에 언제 올라가는지, 언제 호출되는지, 언제까지 유효한지
	
//	각 타입의 초기값
//	정수 : 0
//	실수 : 0.0
//	문자 : '\u0000'
//	논리 : false
//	참조형 : null
	
	public static void main(String[] args) {
		int d; // 지역변수 : 초기값이 들어가지 않는다
//		System.out.println(d); // 초기화전에 쓰면 에러
	} // end of main
	
	public static void a() {
		
	}
} // end of class

```



## 문자열

```java
import java.util.Arrays;

/**
 * 
 * 문자열
 *
 */
public class Z08_String {
	public static void main(String[] args) {
//					0123456789
		String s = "abcDefGHij";
		p(s);
		p(s.replace("Def", "abababab") + " : 문자열을 변경");
		p(s); // String 클래스는 작업후에도 원본문자열은 그대로
		p(s.substring(7) + " : 문자열 추출 7번째~끝");
		p(s.substring(5,8) + " : 문자열 추출 5번째~7");
		
		String str = "호랑이,사자,기린,토끼,다람쥐";
		String[] srr = str.split(","); // 정규화 표현식
		System.out.println(Arrays.toString(srr));
		
		String s2= "abcdefg";
		for (int i = 0; i < s2.length(); i++) {
			System.out.print(s2.charAt(i)+ " ");
		}
		System.out.println();
		char[] crr = s2.toCharArray(); // 복사하는 시간만큼 낭비가 된다, 꼭 필요할때만 사용
		System.out.println(Arrays.toString(crr));
		for (int i = 0; i < crr.length; i++) {
			System.out.print(crr[i] + " ");
		}
		System.out.println();
		
		// 참조형 변수는 주소를 저장하기에 4byte
		String s4 = new String("hi"); // 객체를 생성하는 FM 방법, Heap 영역에 생성
		String s5 = new String("hi"); // 객체를 생성하는 FM 방법, Heap 영역에 생성
		
		// 아래처럼 사용하는 것을 권장
		String s6 = "hi"; // ClassArea 상수풀에 생성
		String s7 = "hi"; // 문자열만 기본형타입처럼 생성하는 것을 허용, 상수풀은 재사용을 한다(같은 것이 있으면 안만듬)
		
		
		System.out.println(s4 == s5); // false, 주소가 다름
		System.out.println(s6 == s7); // true, 같은 주소를 가르킴
		System.out.println(s4.equals(s5)); // true 내용물 비교
		System.out.println(s6.equals(s7)); // true 내용물 비교
		
		String s8 = "apple";
		// "pp" 를 제거
		p(s8.replace("pp", ""));
		
		s8 = "hello";
		// 역순으로 출력
		for (int i = 0; i < s8.length(); i++) {
			System.out.print(s8.charAt(s8.length()-1-i));
		}
		System.out.println();
		
		String s9 = "";
		for (int i = 0; i < s8.length(); i++) {
			s9 = s8.charAt(i) + s9;
		}
		p(s9);
		
		
		
	} // end of main
	public static void p(String str) {
		System.out.println(str);
	}
} // end of class
```



## StringBuilder

- String의 단점 
  - 매번 주소를 새로 할당해서 사용해야하므로 시간적으로 느림

```java
/**
 * String
 * StringBuffer		멀티쓰레드용 : sync를 이용해 여럿이 접근해도 이용가능
 * StringBuilder	단일쓰레드용 : 여럿이 접근하면 이용불가
 */
public class Z10_StringBuilder {
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(str + "a"); // 메소드 호출 후 원본 변경 x
		System.out.println(str.concat("A"));
		
		StringBuilder sb = new StringBuilder("hello"); // 빈공간이 추가로 16칸이 더 생긴다
		System.out.println(sb);
		System.out.println(sb.append("a")); // 메소드 호출 후 원본이 변경된다
		System.out.println(sb);
		System.out.println(sb.reverse());
		
		String s = "apple";
		// String -> StringBuilder로 변경하기
		StringBuilder sbb = new StringBuilder(s);
		sbb.reverse();
		// StringBuilder => String로 q변경
		s = sbb.toString();
		System.out.println(s);
		
		s = "apple";
		System.out.println(new StringBuilder(s).reverse().toString());
		
	} // end of main
} // end of class
```

