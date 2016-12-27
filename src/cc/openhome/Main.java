package cc.openhome;

public class Main {
	
	/* String[] args 是一个字符串数组，如果要提供自定义 命令行自变量，在Eclipse中可以这样操作:
	 * 
	 * 选择 Run|Run Configurations 命令，在Java Application上点击，在弹窗中选择New命令
	 * 
	 * 在新增的配置文件中进行设置。
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World");
		
		/* Java中有基本类型和 类类型两个类型系统，上一章节=谈过基本类型，这章来谈类类型*/
		/* 使用Java撰写程序几乎都在使用对象，要产生对象必须先定义类（Class），类是对象对设计图，对象是类对实例。
		 * 
		 * */
		exp5();
	}
	/* ********************4.5 查询Java API文件******************** */
	public static void exp5() {
		FindAPIDemo.exp1(); 
	}
	/* ********************4.4 字符串对象******************** */
	public static void exp4() {
		/* 由字符组成的文字符号称为字符串，在某些语言中，字符串是以字符数组的方式存在
		 * 
		 * 在Java中，字符串是java.lang.String实例，用来打包字符数组，可以用""包括一串字符来建立字符串。
		 * */	
//		StringDemo.exp1(); // 4.4.1 字符串基础
//		StringDemo.exp2(); // 4.4.2 字符串特性
		StringDemo.exp3(); // 4.4.3 字符串编码
	}
	
	/* ********************4.3 数组对象******************** */
	public static void exp3() {
//		ArrayDemo.exp1(); // 4.3.1 数组基础
		ArrayDemo.exp2(); // 4.3.2 操作数组对象
	}
	
	/* ********************4.2 基本类型打包器******************** */
	public static void exp2() {
		/* 基本类型long、int、double、float、boolean等，在J2SE 5.0之前必须使用Long、Integer、Double、Boolean等类打包为对象，才能当作对象来操作。
		 * 即使在J2SE 5.0开始支持自动装箱、拆箱，仍然有必要了解如何打包基本类型，这有助于进一步了解对象与基本类型的差别。
		 * */
//		IntegerDemo.exp1(); // 4.2.1 打包基本类型
//		IntegerDemo.exp2(); // 4.2.2 自动装箱(autoboxing)、拆箱
		IntegerDemo.exp3(); // 4.2.3 装箱的内幕
	}
	/* ********************4.1 类与对象******************** */
	public static void exp1() {
//		Field.exp1(); // 4.1.1 定义类
//		Guess.exp1(); // 4.1.2 使用标准类
		Guess.exp2(); // 4.1.3 对象指定与相等性
	}
}


