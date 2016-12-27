package cc.openhome;
import java.math.BigDecimal;
import java.util.Scanner;

public class Guess {

	// 使用标准类
	public static void exp1() {
		/* java SE提供了标准API， 这些API就是由许多类组成的，你可以直接取用这些标准类，省去很多重新打造基础的需求
		 * 
		一. 使用 java.util.Scanner
		 * 1. 建立Scanner实例时，必须传入java.io.InputStream实例，System.in就是一种InputStream
		 * 2. nextInt()方法会看看标准输入中，有没有输入空格或换行分割，有的话会尝试将以空格或换行分割之前的剖析为int类型。
		 * 3. 取得直接取得上一个字符串，用 next();
		 * 4. 取得用户输入的整行文字，用 nextLine();
		 * */
		Scanner scanner = new Scanner(System.in);
		int number = (int) (Math.random() * 10);
		int quess;
		System.out.printf("number: %d\n", number);
		do {
			System.out.print("猜数字(0 ~ 9):");
			quess = scanner.nextInt();
		} while (quess != number);
		System.out.println("猜中了...XD");
		
		double a1 = 1.0;
		double b1 = 0.8;
		double c1 = a1 - b1;
		System.out.println(c1);
		/* 二. 使用java.math.BigDecimal
		 * 1. 1.0 - 0.8为什么不是 0.2，而是0.19999999999999996。为什么？
		 * 	简单的说：Java（其他程序语言）遵守 IEEE754浮点数运算规范，使用分数与指数来表示浮点数。例如：
		 * 	0.5会使用 1／2来表示，0.75会使用 1/2+1/4来表示，0.875会使用1/2+1/4+1/8来表示。
		 * 	而0.1会使用1/16+1/32+1/256+1/512+1/4096+1/8192...无限循环下去，无法精确表示，因而造成运算上的误差。
		 * 
		 * 再来举个例子：
		 * */
		double a = 0.1;
		double b = 0.1;
		double c = 0.1;
		if ((a + b + c) == 0.3) {
			System.out.println("等于0.3");
		} else {
			System.out.println("不等于0.3");
		}
		/* 通过以上可以知道，如果要使用浮点数，就要小心，而且别用 == 直接比较浮点数运算结果。
		 * 那么怎么办能得到更好的精确度？可以java.math.BigDecimal类。
		 * */
		
		BigDecimal aBigDecimal = new BigDecimal("1.0");
		BigDecimal bBigDecimal = new BigDecimal("0.8");
		BigDecimal cBigDecimal = aBigDecimal.subtract(bBigDecimal); // subtract减去
		System.out.println(cBigDecimal);
		/* 创建BigDecimal类的方法之一就是使用字符串，BigDecimal在创建时会剖析传入字符串，以默认精度进行接下来的运算。
		 * BigDecimal提供 plus()、substract()、multiply()、divide()等方法。
		 * 使用BigDecimal比较相等的例子：
		 * ️*/
		BigDecimal aaBigDecimal = new BigDecimal("0.1");
		BigDecimal bbBigDecimal = new BigDecimal("0.1");
		BigDecimal ccBigDecimal = new BigDecimal("0.1");
		BigDecimal result = new BigDecimal("0.3");
		if (aaBigDecimal.add(bbBigDecimal).add(ccBigDecimal).equals(result)) {
			System.out.println("等于0.3");
		} else {
			System.out.println("不等于0.3");
		}
	}
	// 对象指定与相等性
	public static void exp2() {
		BigDecimal aBigDecimal = new BigDecimal("0.1");
		BigDecimal bBigDecimal = new BigDecimal("0.1");
		BigDecimal cBigDecimal = aBigDecimal;
		// a 和c指向同一个对象
		System.out.println(aBigDecimal == bBigDecimal); // false // 是否指向同一个对象
		System.out.println(aBigDecimal == cBigDecimal); // true
		System.out.println(aBigDecimal.equals(bBigDecimal)); // true，equals比较的是值
	}
}
