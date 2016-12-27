package cc.openhome;

import java.util.Arrays; // 使用数组的一些方法
import java.*;

public class ArrayDemo {
	// 数组基础
	public static void exp1() {
		/* <一> 数组在Java中就是对象。*/
		
		/* 1.在Java中声明数组并且初始化(静态定义)，如下*/
		int[] scores = {88, 77, 33, 78, 98};  // 建议使用这种
		int scores2[] = {89, 80, 90, 33, 44}; // 为了让C ／C++开发人员看起来友好
		
		/* 2.动态定义，如下*/
		int size = 5;
		int[] scores3 = new int[size];
		for (int i = 0; i < size; i++) {
			scores3[i] = i + 1;
		}

		
		/* 3.数组长度:length*/
		System.out.printf("scores长度: %d%n", scores.length);
		
		/* 4.数组取值
		 * 1.for循环
		 * 2.增强式for循环 (JDK5之后)
		 * 3.通过索引
		 * */ 
		// for循环
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("学生分数: %d\n", scores[i]);
		}
		// 增强式for循环 (JDK5之后)
		for (int score: scores2) { // 其实内部还是通过索引（反编译看到）
			System.out.printf("学生2分数: %d\n", score);
		}
		// 索引
		System.out.printf("scores3 第%d个分数: %d\n", 2, scores3[2]);
		
		/* <二> 二维数组, 使用两个索引存取数组元素*/
		int[][] cords = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12}
		};
		// 普通for 循环遍历二维数组
		for (int i = 0; i < cords.length; i++) { // 行cords.length
			for (int j = 0; j < cords[i].length; j++) {
				System.out.printf("cords[%d][%d]: %d	", i, j, cords[i][j]);
			}
			System.out.println();
		}
		
		// 增强式for 循环遍历
		for (int[] row : cords) {
			for (int value : row) {
				System.out.printf("value: %d	", value);
			}
			System.out.println();
		}
	}
	// 操作数组对象
	public static void exp2() {
		System.out.println("一维数组操作:");
		// 1.使用new 建立数组
		int[] scores = new int[10]; // 在Java中，只要见到new一定是建立对象
		// 默认初始值 是0(byte, short, int), 0L(long), 0.0F(float), 0.0D(double), \u0000(char),false(boolean),null(类)。
		
		// 自定义设置初始值
		int[] scores2 = new int [10];
		for (int i : scores2) {
			System.out.printf("%2d ", i); // 打印默认初始值 
		}
		System.out.println();
		// 2.填充初始值 60
		Arrays.fill(scores2, 60);
		for (int i : scores2) {
			System.out.printf("%2d ", i);
		}
		System.out.println();
		
		// 3.new的时候指定初始值
		int [] scores3 = new int[] {88, 45, 89, 66, 98};
		for (int i : scores3) {
			System.out.printf("%2d ", i);
		}
		System.out.println();
		
		/* 数组即然是对象。对象是根据类而建立的实例，代表建立数组对象的类定义在那里？
		 * 答案：是由JVM动态产生。
		 * 某种情况下，可以将int[]这样的写法，看作类名称，根据int[]而声明的变量就是参考名称了。
		 * 
		 * */
		int[] scores11 = {88, 81, 74, 68, 78, 76 ,77, 85, 95, 93};
		int[] scores22 = scores11;
		scores22[0] = 99;
		System.out.println(scores11[0]);
		
		/* <二> 二维数组*/
		System.out.println("二维数组操作:");
		int[][] cords = new int[2][3];
		// 1.这个语法实际上是建立了一个int[][]类型的对象，里面有2个int[]类型的索引，分别是参考长度为3的一维数组对象，初始值都是0。
		// 2.new时候赋值
		int[][] cords2 =  new int[][] {
				{1, 2, 3},
				{4, 5, 6}
		};
		// 3.二维数组可以是不规则矩阵
		int[][] arr = new int[2][]; // 表明arr参考的对象会有两个索引，但暂时参考至null
		arr[0] = new int[] {1, 2, 3, 4, 5};
		arr[1] = new int[] {1, 2, 3};
		for (int[] row : arr) {
			for (int value : row) {
				System.out.printf("%2d	", value);
			}
			System.out.println();
		}
		
		/* 类类型建立数组(Integer, Double, Float...) */
		System.out.println("建立类类型数组:");
		/* 1.初始化数组
		 * 下面的数组其实建立了 0个Integer对象，因为每个索引都是参考至null。
		 * */ 
		Integer[] integers = new Integer[3];
		for (Integer integer : integers) {
			System.out.println(integer);
		}
		integers[0] = new Integer(99);
		integers[1] = 98; // 使用装箱语法
		integers[2] = new Integer(100);
//		integers[4] = new Integer(100); // 不能越界
		for (Integer integer : integers) {
			System.out.println(integer);
		}
		
		// 2.初始化数组（初始值）
		Integer[] integers2 =  {new Integer(78), new Integer(98)};
		Integer[] integers3 = {33, 56, 88}; // JDK5以上, 使用装箱语法
			
		// <二>二维 类类型数组
		System.out.println("二维类类型数组:");
		Integer[][] integers4 = new Integer[3][2];
		/* 有三个Integer[]类型的索引，分别参考至长度为2的Integer类型一维数组对象。
		 * 而每个Integer一维数组的索引都参考至null，所以还是0个Integer实例
		 * */ 
		
		/* <三> 数组复制
		 * 
		 * 以下并非数组复制, 需要数组复制，需要另行建立新数组
		 * */ 
		System.out.println("数组复制:");
		
		int[] scores111 = {88, 99, 67, 90, 100};
		int[] scores222 = scores111; // 只是指向同一个参考
		
		// 1.复制数组内容
		int[] copyScores1 = new int[scores111.length];
		for (int i = 0; i < scores111.length; i++) {
			copyScores1[i] = scores111[i];
		}
		// 2.使用系统方法(JDK6以上使用 Array.copyOf()方法，可以不用另行建立数组，会自动建立)
		int[] copyScores2 = new int[scores111.length];
		// (1)系统方法 // 0 源起始索引， 0 目的起始索引
		System.arraycopy(scores111, 0, copyScores2, 0, scores111.length);
		for (int i : copyScores2) {
			System.out.printf("arraycopy: %d	", i);
		}
		System.out.println();
		// (2)使用Arrays.copyOf方法
		int[] copyScores3 = Arrays.copyOf(scores111, scores111.length);
		copyScores3[2] = 100; // 不影响scores111
		for (int i : copyScores3) {
			System.out.printf("copyOf: %d	", i);
		}
		System.out.println();
		
		/* 在Java中，数组一旦建立了，长度就固定了，如果事先建立的数组长度不够怎么办？
		 * 那么只好建立新数组，将原来的内容复制至新数组。
		 * 例如:
		 * */
		System.out.println("数组长度延伸:");
		int[] srcArray = {11, 22, 33, 44, 55};
		int[] copySrcArray = Arrays.copyOf(srcArray, srcArray.length * 2);
		
		for (int i : copySrcArray) {
			System.out.printf("copySrcArray: %3d	", i);
		}
		System.out.println();
		
		/* 自定义类类型复制操作:*/
		System.out.println("浅层复制操作:");
		MyClothes[] c1 = {
				new MyClothes("red", 'L'),
				new MyClothes("blue", 'M')
		};
		MyClothes[] c2 = new MyClothes[c1.length];
		for (int i = 0; i < c1.length; i++) {
			c2[i] = c1[i];
		}
		c1[0].color = "yellow";
		c1[0].size = 'M';
		System.out.println(c2[0].color);
		System.out.println(c2[0].size);
		/* 为什么c2[0].color 为 yellow?
		 * 浅层复制： Shallow copy:实际上给c1参考的MyClothes对象，也给 c2来参考,这叫复制参考(浅层复制 Shallowcopy)。
		 * 无论System.arraycopy还是Array.copyOf用在类类型声明的数组时，都是浅层复制。
		 * 
		 * 
		 * 要想连同对象一通复制，得自行操作，因为基本上只有自己才知道，每个对象复制时，有哪些属性必须复制。
		 * 深层复制：Deep copy，也就是每个索引参考的对象会被复制。
		 * 例如:
		 * */
		System.out.println("深层复制:");
		MyClothes[] c3 = {
				new MyClothes("red", 'L'),
				new MyClothes("blue", 'M')
		};
		
		MyClothes[] c4 = new MyClothes[c3.length];
		for (int i = 0; i < c3.length; i++) {
			// 自行复制元素
			MyClothes clothes = new MyClothes(c3[i].color, c3[i].size);
			c4[i] = clothes;
		}
		c3[0].color = "yellow";
		System.out.println(c4[0].color);
		
  	}
}

class MyClothes {
	String color;
	char size;

	MyClothes(String color, char size) {
		this.color = color;
		this.size = size;
	}
}
