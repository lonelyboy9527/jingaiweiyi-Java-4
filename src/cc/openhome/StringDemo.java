package cc.openhome;

public class StringDemo {
	// 字符串基础
	public static void exp1() {
		// <一> 
		// 1.创建字符串
		System.out.println("创建字符串:");
		String name = "justin";
		System.out.println(name);
		
		// char数组 转成 String实例
		char[] ca = {'j', 'K', 'm', 'i', 'n', 'g'};
		String name2 = new String(ca);
		System.out.println("char数组 转成 String实例: " + name2);
		
		// String实例 转成 char数组
		System.out.println("String实例 转成 char数组:");
		char[] ca2 = name2.toCharArray();
		for (char c : ca2) {
			System.out.printf("%c	", c);
		}
		System.out.println();
		
		// 2.字符串长度
		System.out.println("字符串长度: " + name.length());
		
		// 3.获取指定字符
		System.out.println("获取指定字符: "+ name.charAt(0));
		
		// 4.小写字母转大写
		System.out.println("小写字母转大写: " + name.toUpperCase());
		
		// 5.连接字符串
		String name3 = "hahfh";
		String name4 = "kjkjkf" + name3;
		System.out.println("连接字符串: " + name4);
		
		// 6.字符串转换基本数据类型
		String longString = "1324";
		long ll = Long.parseLong(longString);
		System.out.printf("parseLong: %d", ll);
		
		String doubleString = "1324.33";
		double dd = Double.parseDouble(doubleString);
		System.out.printf("parseDouble: %f", dd);
	}
	// 字符串特性
	public static void exp2() {
		/* 在Java的字符串，有一些必须注意的特性
		 * 
		 * 1.字符串常量与字符串池
		 * 2.不可变动字符串
		 * */
		// <一> 字符串常量与字符串池
		System.out.println("<一> 字符串常量与字符串池:");
		// 例子：你觉得以下会是 true 还是 false
		char[] nameChar = {'J', 'u', 's', 't', 'i', 'n'};
		String nameString = new String(nameChar);
		String nameString2 = new String(nameChar);
		System.out.println(nameString == nameString2); // false
		/* 因为都是新建的对象*/
		
		String nameString3 = "Justin";
		String nameString4 = "Justin";
		System.out.println(nameString3 == nameString4); // true
		/* 参考至同一个对象, 在Java中，为了效率考虑，以 "" 包括的字符串，只要内容相同（序列、大小写相同）
		 * 
		 * 无论在程序代码中出现几次，JVM都只会建立一个String实例，并放在字符串池中，并给nameString3参考
		 * 而nameString4直接参考至字符串池中的String实例。
		 * */
		/* 2.字符串常量
		 * 
		 * 用"" 写下的字符串称为字符串常量，既然你用"Justin"写死了字符串内容，基于节省内存考虑，自然就不用为这些字符串常量分别建立String实例。
		 * */
		System.out.println("测试相等性:");
		String name1 = "Justing"; // 创建一个Justing，放在线程池中
		String name2 = "Justing"; //索引至Justing
		
		String name3 = new String("Justing"); // 创建一个Justing实例
		String name4 = new String("Justing"); // 创建一个Justing实例
		
		System.out.println(name1 == name2); // true
		System.out.println(name1 == name3); // false
		System.out.println(name3 == name4); // false
		
		// 3.比较内容相等性
		System.out.println("使用equals比较内容相等性");
		System.out.println(name1.equals(name2));
		System.out.println(name1.equals(name3));
		System.out.println(name3.equals(name4));
		
		
		/* <二> 不可变动字符串
		 * 在Java中，字符串对象一旦建立，就无法改变对象中的任何内容，对象上没有任何方法可以更改字符串内容。那么使用 “+” 连接字符是怎么达到的呢？
		 * 例子：
		 * */
		System.out.println("<二> 不可变动字符串");
		
		String name21 = "Java";
		String name22 = name21 + "World";
		System.out.println(name22); 
		/* 通过反编译上面的程序，可以发现： 
		 * String s = "Java";
		 * String s1 = (new StringBuilder()).append(s).append("World").toString();
		 * 
		 * 使用 "+"连接，会变成java.lang.StringBuilder对象，使用其append()方法来进行 + 左右两边字符串附加，最后在转换为 toString()返回
		 * 
		 * 注意：因为会new 出新的实例，会耗费资源，不要在循环或者递归中等 重复性的场合使用 "+"。
		 * 
		 * 例如:
		 * 产生 1+2+3+4+5+6+...+100, 
		 * (不要轻易使用 “+”)
		 * */
		// 1.使用"+" (这种方法，效率低，占用资源)
		String text = "";
		for (int i = 1; i < 100; i++) {
			text = text + i + '+';
		}
		System.out.println(text);
		
		// 2.使用StringBuilder类 (效率高) 创建builder对象，每次进行append后都会返回原有的builder对象，方便进行下一次操作。
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < 100; i++) {
			builder.append(i).append('+');
		}
		String myString = builder.append(100).toString();
		System.out.println(myString);
		/* StringBuilder是 JDK5 之后新增的类
		 * 在该版本之前，是使用java.lang.StringBuffer类，StringBuilder和StringBuffer具有相同的操作接口
		 * 区别：
		 * StringBuffer会处理同步问题（多线程建议使用，让对象自动管理同步问题）
		 * StringBuilder不处理同步问题（非多线程使用会有较好效率）
		 * */
		
		/* 需要注意的问题:
		 * 
		 * 例子:*/
		String text1 = "Ja" + "va";
		String text2 = "Java";
		System.out.println(text1 == text2); // true
		/* 有人也许会认为：因为用了"+"连接字符串，所以应该text1 != text2
		 * 
		 * 答案是 true，反编译就知道了
		 * String s = "Java";
		 * String s1 = "Java";
		 * 
		 * 编译程序这么认为，既然你写死了 "Ja" + "va",那你要的不就是 "Java"吗？根据以上反编译之后的程序代码，显示true的结果就不足为奇怪了。
		 * */
	}
	// 字符串编码
	public static void exp3() {
		/* 前面的字符串都用 英文，在Java中你不会只处理英文，所以，要了解Java中如何处理中文
		 * 
		 * 问题一、
		 * 编写的.java原始码文档是什么编码？？？？
		 * 
		 * 如果是简体中文windows，纯文本编辑器建立.java，应该是 GB2312编码
		 * 在NetBeans中建立.java，默认应该是 UTF-8编码
		 * 在Eclipse中建立.java，如果是windows中，是GB2312编码，如果是OS X平台，则是UTF-8编码
		 * 
		 * 问题二、
		 * 明明你的windows纯文本编辑器是GB2312编码，为什么写下的字符在JVM中会是 Unicode编码？？？
		 * JVM在加载.class之后，就是读取Unicode编码并产生对应的字符串对象，而不是最初在原始码中写下的 汉字字符。
		 * 
		 * 问题三、
		 * 编译程序怎么知道要将汉字字符转为哪个Unicode编码？
		 * 当你在写下javac指令而没有指定-encoding选项时，会使用操作系统默认编码，
		 * 如果你的文字编译程序使用UTF-8编码，那么编译时，就要指定-encoding 为 UTF-8， 这样程序才会知道用何种编译读取.java的内容。
		 * 在javac -encoding UTF-8 Main.java 
		 * 
		 * IDE可以让用户自定义设定 原始码编码，
		 * 	在Eclipse中，选择windows | Preferences 命令，在打开的 Preferences对话框中，
		 * 展开左边的Workspace 节点，在右边的 Text file encoding选项区选择Other单选按钮， 并在其下拉列表中选择编码方式。
		 * 
		 * 
		 * */
	}
	
}
