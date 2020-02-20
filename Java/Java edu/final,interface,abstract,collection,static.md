# final,interface,abstract,collection,static

## final

```java
/*
 * final : 최종 정의
 * - final 변수 : 상수
 *   상수의 변수명 선언 규칙 : 모두 대문자 + 단어이어질 때 _ 사용.
 * - 메소드 : 오버라이드 불가.
 * - class : 상속 불가.
 */
final class FinalP {}
//class FinalChild extends FinalP {}//error
class FinalP2{
	public final void finalM() {}
}
class FinalChild2 extends FinalP2 {
	//public final void finalM() {}//error
	//public void finalM() {}//error
	//public int finalM() {return 0;}//error
	public void finalM(int a) {}
}
public class FinalTest {
	final double CIRCLE_RATIO = 3.14;//선언과 대입 동시에.
	public static void main(String[] args) {
		FinalTest ft = new FinalTest();
		//ft.CIRCLE_RATIO = 44.44;//error - 상수는 값 변경 불가.
		final int TEST_INT;
		TEST_INT = 777;
		//TEST_INT = 999;//error - 상수는 한번만 대입 가능.

	}

}
```

## Sigleton

```java
class Num {
	private static Num num = new Num();
	private static int number;//번호표
	private Num() {}
	public static Num getInstance() {
		return num;
	}
	public static int getNumber() {
		number++;
		return number;
	}
}
/*
 * Sigleton Design Pattern : 하나의 객체만 유지하고 싶을 때.
 * - 1. 객체를 private으로 생성.
 * - 2. 생성자를 private으로 막는다.
 * - 3. 접근 가능한 public 메소드를 정의한다.
*/
public class SigletonTest {
	public static void main(String[] args) {
		//Num n1 = new Num();//error - 생성자가 private.
		Num n2 = Num.getInstance();//번호 뽑는 기계 1.
		System.out.println(n2.getNumber());
		Num n3 = Num.getInstance();//번호 뽑는 기계 2.
		System.out.println(n3.getNumber());
		Num n4 = Num.getInstance();//번호 뽑는 기계 3.
		System.out.println(n4.getNumber());
		//번호 뽑는 기계가 아무리 많아도, 번호는 하나만 공유되어 증가된다.
	}
}
```

## Static

```java
public class Static1 {
	String nonS = new String("non static string");
	static String staticStr = new String("static string");
	public static void staticM() {}
	public void nonStaticM() {}
	public static void main(String[] args) {
		System.out.println(staticStr);
		staticM();
		//nonStaticM()//error - main은 메모리 확보했음. nonS변수는 메모리를 못받았음.
		//System.out.println(nonS);//error - main은 메모리 확보했음. nonS변수는 메모리를 못받았음.
		Static1 s1 = new Static1();//non static 영역을 메모리 할당하는 작업.
		System.out.println(s1.nonS);//객체참조변수s1.으로 접근.
		s1.nonStaticM();
	}

}

```

```java
/*
 * 자바에서 메모리를 확보하는 방법 : static, new.
 * - static 영역 : ClassLoader가 class를 메모리에 올릴때,
 *                static 선언 부분은 먼저 메모리를 할당함.
 * - new : 메모리에 객체를 올리라고 JVM에게 내리는 명령.
 * - static : ClassName.static변수명/static메소드명.
 * - non-static : new를 통해 생성된 객체참조변수.변수명/메소드명
 * - static 영역은 하나만 만들어져서 공유된다.
 */
public class Static1Declare {
	public int nonVar = 777;
	public static int sVar = 999;
	public void nonMethod() {}
	public static void staticMethod() {System.out.println("s~~~");}
	public static void main(String[] args) {
		Static1Declare.sVar = 12345;
		//Static1Declare.nonVar = 11111;//error
		Static1Declare.staticMethod();
		//Static1Declare.nonMethod();//error
		Static1Declare ddd = new Static1Declare();
		System.out.println(ddd.sVar);
		System.out.println(ddd.nonVar);
		ddd.nonMethod();
		ddd.staticMethod();
		Static1Declare ddd2 = new Static1Declare();
		ddd2.sVar = 98765;
		System.out.println("ddd2에서 sVar 변경 후 : "+ddd.sVar);
		//static 영역은 하나만 만들어져서 공유된다.
	}

}

```

```java
/*
 * static 영역은 하나만 만들어져서 공유된다.
 * instance에 종속되어 있지 않다.
 */
class OnlyOne {
	int intVar;
	static int staticIntVar;
	public OnlyOne() {
		System.out.println("intVar : "+intVar+", staticIntVar : "+staticIntVar);
		intVar++;
		staticIntVar++;
	}
}
public class Static2OnlyOne {
	public static void main(String[] args) {
		OnlyOne oo = new OnlyOne();
		System.out.println(oo.intVar + " : " + oo.staticIntVar);
		OnlyOne oo2 = new OnlyOne();
		System.out.println(oo2.intVar + " : " + oo2.staticIntVar);
		OnlyOne oo3 = new OnlyOne();
		System.out.println(oo3.intVar + " : " + oo3.staticIntVar);
	}

}

```

```java
class StaticP {
	int intVar = 777;
	static int intVar2 = 111;
	public static void staticM() {System.out.println("부모 메소드");}
}
class StaticChild extends StaticP {
	int intVar = 999;//부모와 같은 이름의 변수 선언 가능. 오버라이드는 아님.
	static int intVar2 = 222;//static도 마찬가지. 서로 완전히 다른 변수가 됨.
	public static void staticM() {System.out.println("자식 메소드");}
	//static 메소드도 오버라이드 불가. 서로 완전히 다른 메소드가 됨.
}
public class Static3 {
	public static void main(String[] args) {
		StaticChild c = new StaticChild();
		System.out.println("자식 타입의 변수 : "+c.intVar);
		StaticP p = new StaticChild();
		System.out.println("부모 타입의 변수 : "+p.intVar);
		System.out.println("=======================");
		System.out.println("자식 타입의 변수 : "+c.intVar2);
		System.out.println("자식 타입의 변수 : "+p.intVar2);
		System.out.println("=======================");
		c.staticM();
		p.staticM();
	}

}

```

```java
class StaticSuper {
	static int intVar = 111;
	public void nonStaticMethod() {System.out.println("super---non");}
	public static void staticMethod() {System.out.println("super---static");}
}
class StaticChild extends StaticSuper {
	static int intVar = 999;//부모와 따로 존재함.
	public void nonStaticMethod() {System.out.println("child---non");}
	public static void staticMethod() {System.out.println("child---static");}
	//ststic 메소드  override할 때는 static도 가져온다.
	//또 다른 ststic 메소드  만든 셈이 됨.
}
/*
 * ststic 메소드  override.
 * - override 불가.
 * - 부모의 ststic 영역과 자식의 static 영역이 모두 따로 존재함. 따로 호출해야 함.
 * - 부모ClassName.부모의ststic메소드, 자식ClassName.부모의ststic메소드.
 */
public class Static3Inherit {
	public static void main(String[] args) {
		StaticSuper s1 = new StaticChild();
		s1.nonStaticMethod();//override 적용.
		s1.staticMethod();//override 적용X.
		System.out.println(s1.intVar);
		StaticChild c1 = new StaticChild();
		c1.staticMethod();
		System.out.println(c1.intVar);
	}

}

```

```java
/*
 * Static Initializer
 * - class load 시에 최초 1회성으로 돌아가는 코드를 배치할 수 있음.
 * - class load 시에 동작.
 * - 생성자는 객체 만들때마다 동작.
 * - Static Initializer는 class load 시에 최초 한번만 동작.
 */
public class Static4 {
	{
		int aaa = 777;//지역변수
	}//영역 선언이 가능.
	int bbb = 888;
	static int memVar = 999;
	static {
		System.out.println("static 영역 정의...");
		//System.out.println(aaa);//error
		//System.out.println(bbb);//error - bbb는 메모리를 받지 못함.
		System.out.println(memVar);
		//static area는 static 선언된 멤버 변수와 멤버 메소드만 접근 가능.
	}
	public static void main(String[] args) {
		Static4 s4;//객체 생성 안했으나, class load 되며 실행됨.

	}

}

```

```java
/*
 * Static Initializer
 * - class load 시에 최초 1회성으로 돌아가는 코드를 배치할 수 있음.
 * - class load 시에 동작.
 * - 생성자는 객체 만들때만다 동작.
 * - Static Initializer는 class load 시에 최초 한번만 동작.
 */
class InitializerTest {
	static int a = 0;
	static {//Static Initializer
		System.out.println("static run~~~");
		a = 999;
	}
}
public class Static4Initializer {

	public static void main(String[] args) {
		InitializerTest it = new InitializerTest();
		System.out.println(it.a);
		InitializerTest it2 = new InitializerTest();
		InitializerTest it3 = new InitializerTest();
	}

}

```

```java
class Company{
	private static Company com = new Company();
	private Company() {}//1.외부 생성을 막는다.
	public static Company getCompany() {
		return com;
	}
}//class
public class Static5Singleton {

	public static void main(String[] args) {
		Company c3 = Company.getCompany();
		Company c4 = Company.getCompany();
		System.out.println(c3 == c4);
//		Company c1 = new Company();//error
//		Company c2 = new Company();//error
//		System.out.println(c1 == c2);
	}

}

```

## Collection

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Collection API (Collection Framework)
 * - Data Structure를 구현해 놓은 Library.
 * - java.util 패키지에 구현됨.
 * - 개발 소요 시간 절약 + 최적 알고리즘 제공.
 * Set : 순서 없음, 중복 불가. HashSet, TreeSet.
 * Map : 순서 없음, key 중복 불가, value 중복 가능. HashMap, TreeMap.
 * List : 순서 있음, 중복 가능.(번지가 key 역할.) ArrayList, LikedList, Vector.
 * 순차 접근 : Iterator, Enumeration.
 * Generic : data type 제한.
 */
public class Collection1OverView {

	public static void main(String[] args) {
		HashSet set = new HashSet();//중복 없다.
		set.add(1);
		set.add(new Double(3.14));
		set.add(new String("hello"));
		set.add(new Double(3.14));
		set.add("hello");
		System.out.println("set : " + set);
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(new Double(3.14));
		list.add(new String("hello"));
		list.add(new Double(3.14));
		list.add("hello");
		System.out.println("list : " + list);
		HashMap map = new HashMap();
		map.put("you", "010-1234-5678");
		map.put("kang", "010-9876-5432");
		map.put("haha", "010-5555-7777");//data 중복 가능.
		map.put("you", "010-5555-7777");//key 중복 시, data 엎어씀.
		map.put("kang", "010-9876-5432");//key 중복 불가.
		System.out.println("map : "+map);
	}

}

```

```java
import java.util.ArrayList;

/*
 * ArrayList : array -> ArrayList -> LinkedList(array와 LinkedList 사이 개념.)
 * ArrayList는 LinkedList 보다, data 추가 삭제 시의 부하가 큼.
 * array는 동적을 길이가 변하지 않음.
 * size() : 길이 개념.
 * index 개념.
 */
public class Collection2ArrayList {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Double(3.14));
		list.add(new String("hello"));//add
		Object o = list.get(0);//get
		if(o instanceof Double) {
			Double d = (Double) o;
		}
		ArrayList<Double> list2 = new ArrayList<Double>();
		list2.add(new Double(3.14));
		//list2.add(new String("hello"));//error - list2는 Double 전용으로 data type 제한
		Double d2 = list2.get(0);//data type 제한으로 casting 필요 없음.
		//====================================
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));//get - index 접근.
//		}
//		for(Object o2 : list) {
//			System.out.println(o2);
//		}
		System.out.println(list.contains(3.14));//contains
		ArrayList list3 = (ArrayList) list.clone();//clone
		list3.add("bye~~~");
		list3.add("bye~~~");
		list3.add("first");
		list3.add("second");
		list3.add(33333);
		System.out.println("list3 : "+list3);
		System.out.println(list3.indexOf("bye~~~"));//indexOf
		System.out.println(list3.lastIndexOf("bye~~~"));//lastIndexOf
		list3.remove(0);//remove : 특정 위치 data 삭제.
		list3.remove("bye~~~");//remove : 특정 객체 삭제.
		System.out.println("list3 : "+list3);
		Object[] oArr = list3.toArray();
//		for(Object o2 : list) {
//			System.out.println(o2);
//		}
		System.out.println("list3.isEmpty() : "+list3.isEmpty());
		list3.clear();
		System.out.println("list3.isEmpty() : "+list3.isEmpty());
		System.out.println(list3);
		System.out.println(list);
	}//main

}

```

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Collection3Iterator {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("how are you");
		list.add("i am fine");
		list.add("thanks");
		System.out.println(list);
		Iterator<String> iter = list.iterator();
//		System.out.println(iter.hasNext());
//		System.out.println(iter.next());
//		System.out.println(iter.next());
		while(iter.hasNext()) {//hasNext : 현재 커서 위치의 다음 라인에 data가 있는지 문의.
			System.out.println(iter.next());
			//next : 커서를 다음 라인으로 이동 시키고, 이동한 라인의 data 추출.
		}
	}//main

}

```

```java
import java.util.HashSet;
/*
 * Set : index 개념이 없음. 순서 없음.
 * - add : 특정 위치에 값을 삽입 못함.
 * - remove : 특정 위치에 값을 삭제 못함.
 */
public class Collection4Set {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("hi");
		set.add("hello");
		set.add("how are you");
		set.add("i am fine");
		set.add("thanks");//add
		System.out.println("set : "+set);
		System.out.println("set.size() : "+set.size());
		HashSet<String> set2 = (HashSet<String>) set.clone();//clone
		System.out.println("set2.contains : "+set2.contains("hello"));
		set2.remove("hello");
		System.out.println("set2 : "+set2);
		set2.clear();
		System.out.println("set2.isEmpty : "+set2.isEmpty());
	}

}
```

```java
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 * map : key를 호출하면, value를 주는 저장 구조.
 */
public class Collection5Map {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"hi");
		map.put(2,"hello");
		map.put(3,"how are you");
		map.put(4,"i am fine");
		map.put(5,"thanks");//put
		System.out.println(map);//순서 없음.
		System.out.println("map.size : "+map.size());//순서 없음.
		/**/
		Set<Integer> set = (Set<Integer>) map.keySet();
		//System.out.println(set);
		//keySet : 키값만 Set<key data type> 객체로 가져온다
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int keyInt = it.next();
			System.out.println(keyInt+" : "+map.get(keyInt));
		}
		/**/
		//System.out.println(map.values());
		Collection<String> col = map.values();
		Iterator<String> it2 = col.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println("map.containsKey : "+map.containsKey(5));
		System.out.println("map.containsValue : "+map.containsValue("thank you"));
		System.out.println("map.get : "+map.get(1));
		HashMap map2 = (HashMap) map.clone();
		map2.remove(1);
		map2.remove(2,"world");
		System.out.println(map2);
		System.out.println(map2.isEmpty());
		map2.clear();
		System.out.println(map2.isEmpty());
	}//main

}
```

```java
import java.util.Enumeration;
import java.util.Vector;

public class Collection6Enumeration {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(2,3);
		v.add("hi");
		v.add("hello");
		v.add("how are you");
		v.add("i am fine");
		v.add("thanks");//add
		Enumeration<String> enu = v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}

}

```

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Address {
	String name;//이름
	String group;//소속
	String telRep;//전번 대표
	String telHome;//전번 집
	String telCompany;//전번 회사
	String email;//이메일
	Address(String nm, String grp, String tel1, String tel2, String tel3, String mail){
		this.name = nm;
		this.group = grp;
		this.telRep = tel1;
		this.telHome = tel2;
		this.telCompany = tel3;
		this.email = mail;
	}
	@Override
	public String toString() {
		return "이름 : "+name+"\t"+"소속 : "+group+"\t"+"대표전화 : "+telRep+"\t"
				+"집전화 : "+telHome+"\t"+"회사전화 : "+telCompany+"\t"+"이메일 : "+email;
	}//toString
}
public class Collection7Address {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Address> map = new HashMap<String, Address>();
		int menuNo = 0;
		String tmpName, tmpGrp, tmpTel1, tmpTel2, tmpTel3, tmpEmail;
		System.out.print("0:종료 및 출력, 1:입력.");
		while((menuNo = scan.nextInt()) != 0) {
			System.out.print("이름 : ");
			tmpName = scan.next();
			System.out.print("소속 : ");
			tmpGrp = scan.next();
			System.out.print("대표전화 : ");
			tmpTel1 = scan.next();
			System.out.print("집전화 : ");
			tmpTel2 = scan.next();
			System.out.print("회사전화 : ");
			tmpTel3 = scan.next();
			System.out.print("이메일 : ");
			tmpEmail = scan.next();
			map.put(tmpName, new Address(tmpName, tmpGrp, tmpTel1, tmpTel2, tmpTel3, tmpEmail));
			System.out.print("0:종료 및 출력, 1:입력.");
		}//while
		//2.출력
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(map.get(it.next()));
		}//while
	}//main

}//class

```

## Abstract

```java
/*
 * abstract method : 미완성 메소드.
 * - 구현부{}가 없는 메소드. (메소드가 할 작업의 내용, 절차, 순서 없음.)
 * - {} 대신 ;으로 종료됨.
 * abstract class : abstract method가 있는 class.
 */
abstract class AbsClass {
	public abstract void name();
}
public class Abstract1Declare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
```

```java
/*
 * abstract class
 * - instance 생성이 안된다는 점을 제외하고, 일반 class와 다른 바 없음.
 * - 정상적인 변수와 메소드 선언이 모두 가능.
 * - 상속도 가능.
 * - 사용 이유 : 구현 강제.
 */
abstract class AbsExam {
	int normalMemVar = 777;
	static int normalSMemVar = 999;
	final int SAGAK = 4;
	public void nomalMethod() {}
	public abstract void name();
}
/*
 * 미완성 class 상속 받은 class도 미완성 class가 되므로,
 * 상속받은 class는 미완성 메소드를 오버라이드 해야 함.
 */
class AbsExamChild extends AbsExam {
	@Override
	public void name() {}
}
public class Abstract2Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
```

## Interface

```java
/*
 * interface : 특별한 class.
 * - abstract method로만 이루어진 class.
 * - 일반 메소드 선언 불가.
 * - class 대신에 interface 선언 사용.
 * - 상수 선언만 가능. (일반 변수 선언 불가.)
 * - instance 생성 불가.
 * - 사용 이유 : 구현 강제.
 * - 장점 : 다중 상속 구현.
 */
public interface Interface1Declare {
	int normalMemVar = 777;//final 없어도 상수.
	static int normalSMemVar = 999;//final 없어도 상수.
	final int SAGAK = 4;
	public void name();//abstract 없어도 모두 abstract.
	//public void nomalM() {}//error
}

```

```java
class Inter implements Interface1Declare {
	@Override
	public void name() {}
}

public class Interface1Test {

	public static void main(String[] args) {
		Inter i = new Inter();
		//i.normalMemVar = 123;//error - interface 내부 변수는 모두 상수.
		//i.normalSMemVar = 123;//error - interface 내부 변수는 모두 상수.
		//i.SAGAK = 123;//error - interface 내부 변수는 모두 상수.
		//Interface1Declare i1d = new Interface1Declare();//error - 객체 생성 불가.

	}

}

```

```java
import java.util.Arrays;

class SortTest implements Comparable<SortTest> {
	int sortVar;
	SortTest(int a){
		sortVar = a;
	}
	@Override
	public String toString() {
		return ""+sortVar;
	}
	@Override
	public int compareTo(SortTest o) {
		return this.sortVar - o.sortVar;
	}
}
public class Interface2Why {
	public static void main(String[] args) {
		SortTest [] arr = {new SortTest(999),new SortTest(7),new SortTest(123)};
		Arrays.sort(arr);
		//Arrays.sort를 사용하고 싶으면, Comparable의 compareTo를 구현해 와라! - 구현 강제
		System.out.println(Arrays.toString(arr));
	}

}

```

```java
/*
 * implements : 구현하다.
 * interface 간의 관계는 implements를 통해 확보.
 * - 단일 상속의 약점을 극복. 다중 상속 방법 제공.
 * - implements 뒤에 올 수 있는 interface 갯수에 제한이 없음.
 * - 연관성 없는 class들에게 연관성 부여.
 */
interface AAA {}
interface DDD {}
class CCC{}
class ClassB extends CCC implements AAA, DDD {}
/*
 * interface 간의 extends를 통한 상속이 가능.
 * interface 간의 상속은 다중 상속이 가능.
 * interface 간의 다중 상속 가능 이유는 상수와 미완성 메소드만 상속되기 때문에, 다중 상속의 모호성이 없음.
 * - 구현부가 없어서, 다중 상속의 모호성이 없음.
 */
interface EEE extends AAA, DDD {}

public class Interface3Implements {

	public static void main(String[] args) {
	}

}

```

```java
class 포유류 {}
class 사람 extends 포유류 implements FunctionWalk {
	@Override
	public void walk() {
	}
}
class 파충류{}
class 도마뱀 extends 파충류 implements FunctionWalk {
	@Override
	public void walk() {
	}
}
interface FunctionWalk {
	public void walk();
}
/*
 * interface의 또 다른 장점 : 연관성이 없는 class들에게 연관성 부여.
 * - Heterogeneous Collection, Polymorpic arguments를 사용 가능하게 함.
 * - Polymorphism 개념 적용 가능.
 */
public class Interface4Poly {
	public static void main(String[] args) {
		포유류 [] p = new 포유류[3];
		//p[0] = new 도마뱀();//error - 상속 관계가 없음.
		FunctionWalk [] fw = new FunctionWalk[2];
		fw[0] = new 사람();
		fw[1] = new 도마뱀();
	}
}
```

