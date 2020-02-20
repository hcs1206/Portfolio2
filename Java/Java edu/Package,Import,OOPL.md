# Week5_day2 Summary



## Package, Import

```java
package test.pac;
/*
 * package : java 파일과 class 파일의 폴더 위치를 지정하는 문법
 * 상위폴더에서 하위폴터 순으로 .을 통해 접근하는 개념
 * 예) test.pac : test 폴더 밑의 pac 폴더가 현재 자바 파일과 클래스 파일의 위치임을 표시
 * 하나의 파일에는 하나의 package 선언만이 가능
 * 일반적으로 소문자로 표현
 * 컴파일 : javac -d .(현재폴더) PacTestObj.java
 */


public class PacTestObj {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

```

```java
package test.imprt;

/*
 * import : 현 파일에 필요한 다른 class의 위치를 지정
 * 상위 폴더에서 하위 폴더 순으로 . 을 통해 접근
 * 하나의 파일에 여러 import 선언 가능
 * 일반적으로 소문자 사용
 * 에) import test.pac.PacTestObj : test 폴더 밑에 pac 폴더에 있는 PacTestObj class를 가져와라
 * import java.util.* : * 모든 class를 가져오라는 의미 => 비추!!
 * import 에 선언된 class는 classLoader에 로딩된다.
 * 따라서, 꼭 필요한 class만 import로 지정하는 것을 권장한다.
 */

import test.pac.PacTestObj;

public class ImportTest {
	public static void main(String[] args) {
		PacTestObj pto = new PacTestObj();
		pto.setMessage("simple Package");
	}

}
```



## OOPL

- Encapsulation
  - Data hiding => 잘못된 데이터 입력 방지
  - Method 내부 숨기기

```java
/*
 * Encapsulation
 * 1. Data Hiding
 *  - set/get 메소드가 접근 통로 역할을 하면서, 잘못된 데이터를 거를 수 있음.
 * 2. Method Inner Hiding
 *  - 메소드의 내부 구현을 알지 못해도, return_type과 parameter_list만 알면,
 *    해당 메소드를 사용할 수 있다.
 *  예) int plus(int a, int b) : int 두개를 더해서 결과를 int로 준다.
 *  - return_type과 parameter_list : 접근 통로 역할.
 */
public class MeanOfEncapsulation {
	private int age;
	private String sCode;
	
	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		if(sCode == null) this.sCode = sCode;
		else System.out.println("wrong data !!!");
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age >= 0) this.age = age;
		else System.out.println("wrong data !!!");
	}

}
```



- Inheritance

```java
/*
 * Inheritance : 다른 class의 유전적 형질(member variable/method)을 가져옴.
 * - extends 를 통해 상속을 받을 수 있다.
 *  예) Child1 extends Parent1
 *   : Child1은 Parent1을 상속 받았다.
 *   : Child1은 Parent1을 확장했다.
 * - 유전적 형질을 주는 class : super class, 부모 class, 상위 class
 * - 유전적 형질을 받는 class : sub class, 자식 class, 하위 class
 * - 부모는 공통된 부분을 가짐 : generalize
 * - 자식은 자식만의 고유한 부분을 가짐 : specialize
 * - class diagram : 자식 -▷ 부모 (실선+속이빈삼각형)
 * - is a relationship : 자식은 부모의 한 종류이다.
 *  예) 박찬호 extends 투수, 류현진 extends 투수
 *   : 박찬호는 투수의 한명이다. 류현진은 투수의 한명이다.
 *   : 잘못된 예 - 투수는 박찬호다.(오류) 박찬호는 류현진이다.(오류)
 *   : sub class is a super class - O
 *   : sub class is a sub class - X
 *   : super class is a sub class - X
 * - 자바는 단일 상속.
 *  예) A extends B - O
 *  잘못된 예) A extends B, C - X
 */
/*
 * 상속을 사용하는 이유
 * - 구조가 간단 해진다.
 * - 코드 재사용성이 높일 수 있다.
 * - 수정과 추가 개발이 용이함.
 * - 프로그램의 확장과 관리가 쉬워지는 장점.
 */
class Parent1 {
	String firstName;
	String lastName;
	void print() {
		System.out.println(firstName);
	}
}
class Child1 extends Parent1 {
	String middleName;
	void print() {
		super.print();
		System.out.println(firstName+" "+middleName+" "+lastName);
	}
}
public class Inheritance1OverView {

	public static void main(String[] args) {
		Child1 c1 = new Child1();
		c1.firstName = "몽키";
		c1.middleName = "D";
		c1.lastName = "루피";
		c1.print();
	}

}
```

```java
//상속 구현의 예시
public class Inheritance2Person {
	String name;
	String ssn;
	String phone;
	String addr;
}
/*
 * has a relationship
 * - 다른 객체를 attribute(variable)로 소유할 수 있다.
 * - class diagram : 엔진-<>자동차(실선+속이빈다이아몬드), 포함관계
 */
class Inheritance2Student extends Inheritance2Person {
	String hakBun;
	String classRoom;
	//수업 과목{"국","영","수"} - 성적{100,80,90}
	Inheritance2Jumsu [] jumsu
		= new Inheritance2Jumsu [10];//has a relationship
}
class Inheritance2Teacher extends Inheritance2Person {
	String subject;
	String classRoom;
}
class Inheritance2Employee extends Inheritance2Person {
	String empNo;
	String deptName;
}
class Inheritance2Jumsu {
	String sihumSubject;
	int sihumJumsu;
}
```

Override

```java
/*
 * Method Override : 재정의(덮어쓰기)
 * - 상속관계에서 부모에 정의된 메소드를 자식에서 재정의하는 것.
 * - 부모 클래스에서 정의된 메소드와 이름과 파라미터가 같은 메소드를 자식 클래스에서 만드는 것.
 * - 호출 우선 순위 : 자식에 재정의된 메소드가 우선권을 갖음.
 */
class OverrideParent {
	void print() { System.out.println("부모 메소드..."); }
}
class OverrideChild extends OverrideParent {
	void print() { System.out.println("===> 자식 메소드..."); }
	//올바른 예) return type, method name, parameter list가 동일함.
	//int print() { System.out.println("===> 자식 메소드..."); return 777; }
	//잘못된 예1) return type 다르면 오류.
	void print(String str) { System.out.println("===> 자식 메소드:"+str); }
	//잘못된 예2) parameter list가 다르면, 다른 메소드로 인식함.
}
public class Inheritance3Override {

	public static void main(String[] args) {
		OverrideChild oc = new OverrideChild();
		oc.print();//호출 우선 순위는 자식 클래스가 가짐.
	}

}
```

Overload

```java
/*
 * Method Overload : 중복 선언(중복 정의)
 * - 하나의 클래스에서 파라미터가 다른 같은 이름의 메소드를 중복 선언하는 것.
 * - return type과는 무관함.
 * - 메소드는 이름과 파라미터로 구분됨.
 * - 따라서, 이름이 같아도, 파라미터가 다르면, 다른 메소드.
 * - 동일한 기능의 다루는 data가 다른 경우.
 * 예) System.out.println(777);//int를 파라미터로 받는 println 메소드
 * 예) System.out.println("hi");//문자열을 파라미터로 받는 println 메소드
 */
public class Review_Overload {

	public void overloadTest() {}
	//public int overloadTest() { return 777; }//overload 아님.
	public void overloadTest(int a) {}
	public void overloadTest(int a, char c, int b) {}
	//argument list(parameter list)가 다르면,
	//동일한 이름의 메소드를 무한히 선언할 수 있다.
	public static void main(String[] args) {

	}

}
```



- Polymorphism

```java
/*
 * Polymorphism : 다형성 : 다양한 형태
 * - 그리스어 poly(많은) + morphos(형태)
 * - 반드시 상속 관계에서만 성립
 * - 부모 data type의 변수로, 자식 data type의 객체에 접근할 수 있다.
 */
/*
 * Polymorphism 사용 이유.
 * - Heterogeneous Collection : 이종 data 저장 가능한 자료 구조.
 * - Polymorphic Argument : parameter list를 부모타입으로 정의할 수 있음.
 * - method override : 부모 타입의 메소드명으로 자식 타입의 재정의된 메소드 사용.
 */
class ParentTmp {}
class ChildTmp1 extends ParentTmp {}
class ChildTmp2 extends ParentTmp {}
public class Inheritance4Polymorphism {

	public static void main(String[] args) {
		ParentTmp p1 = new ParentTmp();//정상적인 객체 생성.
		//String str = new Parent1();//error
		//String 타입의 변수 str은 자신을 선언한 Reference Type의 객체만 참조 가능.
		ParentTmp p2 = new ChildTmp1();//Polymorphsm 객체 생성.
		ParentTmp p3 = new ChildTmp2();//Polymorphsm 객체 생성.
		//부모 타입의 변수가 자식 타입의 객체를 참조 가능한 이유.
		// - 자식 타입의 객체 내부에 부모 타입의 객체가 존재하기 때문.
		//ChildTmp1 c1 = new ChildTmp2();//error
		//ChildTmp1 c1 = new ParentTmp();//error
		//부모 타입의 변수만 자식 타입의 객체 참조 가능.
	}

}
```

- Polymophism 한계
  - 부모타입으로 선언된 부분만 사용할 수 있고 자식의 고유한 메소드나 변수는 접근할 수 없다



- Heterogeneous

```java
/*
 * Heterogeneous Collection : 이종 data 저장 가능한 자료 구조.
 * - 반드시 상속 관계가 있어야 함.
 * - 부모 타입의 배열에 자식 타입의 객체를 담는 것.
 */

public class Inheritance5Heterogeneous {

	public static void main(String[] args) {
		String [] strArr = new String [10];
		//Homogeneous Collection : 같은 종류의 data를 저장하는 구조
		Person p[] = new Person[3];
		p[0] = new Person("강호동","111","010-1111-2222","강남구");
		p[1] = new Student("유재석","222","010-9999-8888","서초구","A2018","301");
		p[2] = new Teacher("딘딘","333","010-7777-3535","송파구","국어","110");
		for(int i=0; i<p.length; i++){
			p[i].print();
		}//override 장점 : 부모 타입의 메소드명으로 자식 타입의 재정의된 메소드를 불러 올 수 있다.
		//System.out.println(p[2].classRoom);
		//polymorphic 변수는 자식 타입 고유의 값에는 접근이 안됨.
	}
}

```



- PolyArgument

```java
/*
 * Polymorphsm 한계 : polymorphic 변수는 자식 타입 고유의 값에는 접근이 안됨.
 * - 극복 방법 : Object Casting
 */
public class Inheritance6PolyArgument {

	public static void main(String[] args) {
		Person p = new Person("강호동","111","010-1111-2222","강남구");
		Student s = new Student("유재석","222","010-9999-8888","서초구","A2018","301");
		Teacher t = new Teacher("딘딘","333","010-7777-3535","송파구","국어","110");
		callPrint(s); callPrint(t); callPrint(p);
	}
	/*
	 * Polymorphic Argument : parameter list를 polymorphic으로 구현.
	 * - parameter list를 부모타입으로 정의하면, 모든 자식 타입의 객체를 받을 수 있다.
	 * - 반드시 상속관계에서 성립 가능함.
	 */
	public static void callPrint(Person p) {
		if(p instanceof Student) {
			System.out.println("===> Student...");
		} else if(p instanceof Teacher) {
			System.out.println("===> Teacher...");
		} else if(p instanceof Person) {
			System.out.println("Person...");
		}
		p.print();
		//System.out.println(p.classRoom);
		//polymorphic 변수는 자식 타입 고유의 값에는 접근이 안됨.
	}
//	public static void callPrint(Student s) {
//		s.print();
//	}

}

```



- Casting

```java
import java.util.ArrayList;

/*
 * Object Type Casting
 * - 반드시 상속관계에서 성립 가능함.
 * - 묵시적 Casting : 자식 타입 -> 부모 타입
 * - 명시적 Casting : 부모 타입 -> 자식 타입
 */
/*
 *  instanceof 연산자
 *  - 누구의 객체인가를 확인하는 연산자.
 *  - true/false 만을 리턴함.
 */
public class Inheritance7Casting {

	public static void main(String[] args) {
		Person p = new Student("유재석","222","010-9999-8888","서초구","A2018","301");
		//Polymorphsm : 부모 타입의 변수로 자식 타입의 객체를 참조.
		//묵시적 Casting : 자식 타입 -> 부모 타입
		p.print();//부모 타입의 변수로 자식 타입의 메소드 호출.
		//System.out.println(p.hakbun);//error - 부모 타입의 변수로 자식 타입의 고유 부분에 접근이 불가능함.
		Student stu = (Student) p;//명시적 Casting : 부모 타입 -> 자식 타입
		System.out.println("stu : " + stu.hakbun);
		//????? - 다형성 왜 하나요?
		ArrayList list = new ArrayList();
		list.add(new Person("강호동","111","010-1111-2222","강남구"));
		list.add(new Student("유재석","222","010-9999-8888","서초구","A2018","301"));
		list.add(new Teacher("딘딘","333","010-7777-3535","송파구","국어","110"));
		//System.out.println(list.get(1).name);//error - 부모 타입의 변수로 자식 타입의 고유 부분에 접근이 불가능함.
		if(list.get(1) instanceof Student) {
			Student stu2 = (Student) list.get(1);
			System.out.println("stu2 : " + stu2.hakbun);
		}
	}

}

```



- ThisKeyword

```java
/*
 * this : 자기 자신의 객체를 반환하는 키워드.
 * - 변수/메소드 호출 : this.변수명, this.메소드명
 * - 생성자 호출 : this() : 생성자 안에서 다른 생성자 호출.
 * - sub class에서 this는 자식 타입을 의미함.
 */
class ThisObj {
	String memVar = "member variable...";
	public ThisObj(){
		this("다른 생성자 호출을 통한 멤버 변수 입력.");
	}
	public ThisObj(String message) {
		this.memVar = message;
	}
	public void print() {
		String memVar = "local variable...";
		System.out.println("지역 변수 우선 : " + memVar);
		this.call();//this 메소드 용법.
		System.out.println("this를 통한 멤버 변수 호출 : " + this.memVar);//this 변수 용법.
	}
	public void call() {
		System.out.println("this를 통한 다른 메소드 호출.");
	}
}
public class ThisKeyword {

	public static void main(String[] args) {
		ThisObj to = new ThisObj();
		to.print();
		System.out.println("================");
		ThisObj to2 = new ThisObj("직접 메세지 입력");
		to2.print();
	}

}

```

- Passby

```java
/*
 * pass by value : 데이터를 전달 할 때, data value를 복사하여 전달.
 * - primitive data type.
 * pass by reference : 데이터를 전달 할 때, 주소 value를 복사하여 전달.
 * - reference data type.
 */
class RefObj {
	String str = "first string...";
}
public class PassBy {

	public static void main(String[] args) {
		RefObj obj1 = new RefObj();
		System.out.println(obj1.str);
		passByRef(obj1);
		System.out.println(obj1.str);
		int i = 777;
		passByVal(i);
		System.out.println(i);
		i = passByVal2(i);
		System.out.println(i);
	}
	public static void passByRef(RefObj obj) {
		obj.str = "string by passByRef...";
	}
	public static void passByVal(int a) {
		a = 9999999;
	}
	public static int passByVal2(int a) {
		a = 999999;
		return a;
	}
}
```



- PersonArrayTest

```java
import java.util.Scanner;

public class PersonArrayTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Person pArr [] = new Person[100];
		int menuNo=0, pArrCnt=0;
		while(true) {
			System.out.println("메뉴 선택=======");
			System.out.print("0:종료, 1:입력, 2:검색, 3:출력. ");
			menuNo = scan.nextInt();
			if(menuNo == 0){
				System.out.println("bye bye ~~~"); break;
			} else if(menuNo == 1) {
				pArrCnt = input(scan, pArr, pArrCnt);
			} else if(menuNo == 2) {
				search(scan, pArr, pArrCnt);
			} else if(menuNo == 3) {
				output(pArr, pArrCnt);
			} else {
				System.out.println("wrong input !!! try again !!!");
			}
		}//while
	}//main
	public static int input(Scanner scan, Person[] pArr, int pArrCnt) {
		int subMenuNo=0;
		System.out.print("1:Student, 2:Teacher. ");
		subMenuNo = scan.nextInt();
		System.out.print("이름 : ");
		String tmpNm = scan.next();
		System.out.println(tmpNm);
		System.out.print("주민번호 : "); String tmpSn = scan.next();
		System.out.print("전화번호 : "); String tmpPn = scan.next();
		System.out.print("주소 : "); String tmpAd = scan.next();
		if(subMenuNo == 1) {
			System.out.print("학번 : "); String tmpHb = scan.next();
			System.out.print("소속학년반 : "); String tmpCr = scan.next();
			pArr[pArrCnt] = new Student(tmpNm,tmpSn,tmpPn,tmpAd,tmpHb,tmpCr);
		} else if(subMenuNo == 2) {
			System.out.print("담당과목 : "); String tmpSj = scan.next();
			System.out.print("담당학년반 : "); String tmpCr = scan.next();
			pArr[pArrCnt] = new Teacher(tmpNm,tmpSn,tmpPn,tmpAd,tmpSj,tmpCr);
		} else {
			System.out.println("wrong input !!! try again !!!");
		}
		return ++pArrCnt;
	}//input
	public static void search(Scanner scan, Person[] pArr, int pArrCnt) {
		int subMenuNo=0;
		System.out.print("1:학생학번, 2:교수과목. ");
		subMenuNo = scan.nextInt();
		if(subMenuNo == 1) {
			System.out.print("학생학번입력 : ");
			String tmpHb = scan.next();
			for(int i=0; i<pArrCnt; i++) {
				if(pArr[i] instanceof Student){
					Student tmpS = (Student) pArr[i];
					if(tmpS.hakbun.equals(tmpHb)) {
						tmpS.print();
					}
				}
			}
		} else if(subMenuNo == 2) {
			System.out.print("교수과목입력 : ");
			String tmpSj = scan.next();
			for(int i=0; i<pArrCnt; i++) {
				if(pArr[i] instanceof Teacher){
					Teacher tmpT = (Teacher) pArr[i];
					if(tmpT.subject.equals(tmpT)) {
						tmpT.print();
					}
				}
			}
		}else {
			System.out.println("wrong input !!! try again !!!");
		}
	}//search
	public static void output(Person[] pArr, int pArrCnt) {
		for(int i=0; i<pArrCnt; i++) {
			System.out.println("=====================");
			pArr[i].print();
		}
	}//output
}//class

```



- SuperKeyword

```java
class SuperParent {
	String testStr = "super test...";
	public SuperParent() {
		System.out.println("super super super...");
	}
	public SuperParent(String message) {
		System.out.println("super message : " + message);
	}
	void print() {
		System.out.println("parent : " + testStr);
	}
}
class SuperChild extends SuperParent {
	String testStr = "===>child test...";
	public SuperChild() {
		//super();
		super("부모 생성자를 불렀어요.!!!");
		System.out.println("run child constructor...");
		//super();//error - 부모 생성자 호출은 반드시 생성자 {} 첫줄에서.!!!
	}
	//부모타입에서 선언한 변수를 자식에서도 선언할 수 있다. 다만, 호출 우선순위는 없다.
	void print() {
		super.print();//부모 메소드 호출.
		System.out.println("child : " + super.testStr);//부모 변수 호출.
		System.out.println("child : " + testStr);
	}
}
/*
 * super : 부모 객체를 반환.(부모 객체에 접근 가능한 통로 역할.)
 * - 변수/메소드 호출 : super.변수, super.메소드.
 * - 생성자 호출 : super() : 생성자 안에서 super() 사용하면 부모의 생성자를 호출함.
 */
public class SuperKeyword {

	public static void main(String[] args) {
		//SuperChild c1 = new SuperChild();
		//System.out.println(c1.testStr);
		SuperParent p1 = new SuperChild();
		//System.out.println(p1.testStr);
		//p1.print();
	}

}
```

