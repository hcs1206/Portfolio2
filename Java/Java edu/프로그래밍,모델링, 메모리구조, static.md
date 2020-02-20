# 프로그래밍,모델링, 메모리구조, static



## Computer progamming

- 현실 속의 업무를 컴퓨터 세계에 만드는 것(ex. DB, 객체지향 언어)\

개념 모델링->논리 모델링-> 물리 모델링



ex) 사람을 컴퓨터에 인식시키는 과정

1. 사람은 이름을 갖고 있다.
2. 사람은 주민번호를 통해 관공서에 등록되어 있다.
3. 사람이 아파서 병원에 가면, 환자라고 불린다.





## 논리 모델링

- 개념 모델링의 결과, 컴퓨터에 반영할 내용을 축약한 것
  - 사람
  - 이름 
  - 주민번호



## 물리 모델링

- 논리 모델링의 결과를 컴퓨터에 반영할 수 있도록 변환한 것



## OOP

- 현실세계의 모델을 컴퓨터의 세계에서도 하나의 대상(Object)로 접근하는 것.
- ex) 엄마가 린을 씻긴다. 엄마가 윤을 씻긴다.
- high level language: 인간이 쉽게 알 수 있는 언어 - c, java
- low level language: 컴퓨터 언어, 0과 1,  omr 카드, 천공카드
- class : 객체 지향 물리 모델링의 결과, low level language로 변환할 내용들을 정의하는 문서
  - 시스템에서 동작하는 프로그램의 설계도 역할.
  - data적 요소, 기능적 요소를 포함함
- instance : 메모리에 로드된 class
  - 하나의 class로 여러 instance 생성
- 생성자: class가 만들어질 때, 정의해야 하는 부분을 설계한 곳.



```java
public class DataClass {
	int[] arr = {9,5,1,7,3,6,4,2,8};
}
```

```java
import java.util.Arrays;

public class FuncClass {
	public void arrage(int[] intArr) {
		Arrays.sort(intArr);
	}
	
	public void print(int[] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
	}
}
```

```java
import java.util.Arrays;

public class FuncClass2 {
	public int[] thisArr;
	
	public FuncClass2(int[] intArr){
		thisArr = intArr;
	}
	
	public void arrage() {
		Arrays.sort(thisArr);
	}
	
	public void print() {
		for (int i = 0; i < thisArr.length; i++) {
			System.out.print(thisArr[i] + " ");
		}
	}
}
```

```java
public class ControlClass {
	public static void main(String[] args) {
		DataClass data = new DataClass(); // data 요소만
		FuncClass func = new FuncClass(); // 기능 요소만
		func.arrage(data.arr);
		func.print(data.arr);
		FuncClass2 func2 = new FuncClass2(data.arr);
		func2.arrage();
		func2.print();
	}
}
```



## Abstraction

- 추상화, 필요한 것만 가지고 간다
- 학적부 사람(학생), 진료카드 사람(환자)
  - 이름, 주민번호, 연락처 등 공통사항
  - 과목, 과목점수, 당수치, 간수치 등 다른 내용을 가질 수 있다



## JVM Memory 구조

- Class area
  - 메모리로 읽어온 클래스의 정보를 기억하는 곳
- heap
  - 클래스의 객체를 생성하여 기억하는 곳
- Java stack
  - 메서드 수행 시마다 프레임이 할당되어 메서드 수행에 필요한 변수나, 
    중간 결과 값을 임시기억 하는 곳, 메서드 종료 시 할당 메모리 자동 제거
- Garbage Collection
  - Heap 영역(class 영역 포함)에 생성된 객체들의 메모리 관리를 담당하는 프로그램
  - 더 이상 사용되지 않은 객체들을 점검하여 제거한다.
  - 자동적인 실행, CPU가 한가하거나 메모리가 부족할 때 JVM에 의해서 실행된다.
  - System.gc()를 호출하여 실행을 유도할 수는 있으나 바로 수행된다는 보장은 없다.
  - JVM에 따라 다양하게 구현 실행되며, 성능에 영향을 주기 때문에 Java version에 따라 더 좋은 성능의 Garbage Collection 기법 사용한다.



아래 코드 수행 시 메모리의 변화를 살펴보자.

```java
/**
*	Consturctor 생성자
*	특수한 역할 메소드, instance가 처음 만들어 질 때 한번만 수행
*/
FuncClass2 f; // 변수선언
f = new FuncClass2(); // 1. class Loading, heap 영역 확보
					  // 2. 생성자 실행
					  // 3. (=) 주소입력
```

## Static 변수

```java
class Static{
	int non = 1;
	static int yes = 1;
	public Static(){
		non++;
		yes++;
	}
}
public class StaticTest2 {
	public static void main(String[] args) {
		Static y1 = new Static();
		System.out.println(y1.non + " : " + y1.yes); // 2 : 2
		Static y2 = new Static();
		System.out.println(y2.non + " : " + y2.yes); // 2 : 3
        Static.yes // 객체 이름을 통해 접근하는 것이 일반적
	}

}
```

